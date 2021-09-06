package com.dr.code.diff.config;

import com.dr.code.diff.CodeDiffApplicationTest;
import com.dr.code.diff.dto.DiffMethodParams;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * @ProjectName: base-service
 * @Package: com.dr.codediff.config
 * @Description: java类作用描述
 * @Author: duanrui
 * @CreateDate: 2021/1/7 19:56
 * @Version: 1.0
 * <p>
 * Copyright: Copyright (c) 2021
 */
class GitConfigTest extends CodeDiffApplicationTest {

    @Autowired
    private GitConfig gitConfig;

    @Test
    void cloneRepository() {
        String localRepo = "D:\\git-test\\base-service";
        String gitUrl = "http://192.168.75.128/rayduan/base-service.git";
        gitConfig.cloneRepository(gitUrl, localRepo, "2ea401406d775005245faa0a57d6e08db348433f");
    }

    @Test
    void test1() throws IOException, InterruptedException {
        String exc = "java -jar /Users/songyuqi/Downloads/org.jacoco.cli-0.8.7-SNAPSHOT-nodeps.jar report " +
                "/Users/songyuqi/Downloads/jacoco.exec --classfiles /Users/songyuqi/Downloads/code/caocao-dic/master/dic-core/target/classes --sourcefiles /Users/songyuqi/Downloads/code/caocao-dic/master/dic-core/src/main/java --html /Users/songyuqi/Downloads/jacoco/report/dic/report --diffCode \"[{\\\"classFile\\\":\\\"com/caocao/dic/core/service/provider/sdkv3/ChargeServiceSdkApiImpl\\\",\\\"methodInfos\\\":[{\\\"methodName\\\":\\\"chargeStart\\\",\\\"parameters\\\":\\\"ChargeStartRequest request\\\"},{\\\"methodName\\\":\\\"checkBeforeChargeStart\\\",\\\"parameters\\\":\\\"ChargeStartRequest request\\\"}],\\\"type\\\":\\\"MODIFY\\\"},{\\\"classFile\\\":\\\"com/caocao/dic/core/charge/manage/QrCodeScanManager\\\",\\\"methodInfos\\\":[{\\\"methodName\\\":\\\"getScanResultDTO\\\",\\\"parameters\\\":\\\"String qrCode\\\"}],\\\"type\\\":\\\"MODIFY\\\"},{\\\"classFile\\\":\\\"com/caocao/dic/core/service/provider/sdkv3/ChargeStationSdkApiImpl\\\",\\\"methodInfos\\\":[{\\\"methodName\\\":\\\"getStationInfoByScanOrEntry\\\",\\\"parameters\\\":\\\"StationChargeRequest stationChargeRequest\\\"},{\\\"methodName\\\":\\\"getGunInfoByScan\\\",\\\"parameters\\\":\\\"String qrCode, String sourceType, String districtCode\\\"},{\\\"methodName\\\":\\\"getQrCodeScanResultByThirdApi\\\",\\\"parameters\\\":\\\"String qrCode\\\"}],\\\"type\\\":\\\"MODIFY\\\"},{\\\"classFile\\\":\\\"com/caocao/dic/core/service/provider/cooperate/CooperateChargingApiImpl\\\",\\\"methodInfos\\\":[{\\\"methodName\\\":\\\"chargeStart\\\",\\\"parameters\\\":\\\"@FluentValid({ExtSourceValidator.class}) ChargeStartRequest request\\\"}],\\\"type\\\":\\\"MODIFY\\\"},{\\\"classFile\\\":\\\"com/caocao/dic/core/infrastructure/retry/listener/AutoPayRetryListener\\\",\\\"methodInfos\\\":[{\\\"methodName\\\":\\\"onRetry\\\",\\\"parameters\\\":\\\"RetryContext ctx\\\"}],\\\"type\\\":\\\"MODIFY\\\"},{\\\"classFile\\\":\\\"com/caocao/dic/core/service/provider/open/OpenChargingServiceApiImpl\\\",\\\"methodInfos\\\":[{\\\"methodName\\\":\\\"chargeStart\\\",\\\"parameters\\\":\\\"@FluentValid({ExtSourceValidator.class}) ChargeStartCmdRequest startCmd\\\"},{\\\"methodName\\\":\\\"checkChargeStartRequest\\\",\\\"parameters\\\":\\\"ChargeStartCmdRequest startCmd\\\"}],\\\"type\\\":\\\"MODIFY\\\"},{\\\"classFile\\\":\\\"com/caocao/dic/core/event/msgevent/listener/OrderPayEventListener\\\",\\\"methodInfos\\\":[{\\\"methodName\\\":\\\"autoPayMsgPush\\\",\\\"parameters\\\":\\\"OrderFlowBaseDTO orderPayResult\\\"}],\\\"type\\\":\\\"MODIFY\\\"},{\\\"classFile\\\":\\\"com/caocao/dic/core/infrastructure/message/KafkaFinishBillReceiver\\\",\\\"methodInfos\\\":[{\\\"methodName\\\":\\\"process\\\",\\\"parameters\\\":\\\"ConsumerRecord<String,String> message\\\"}],\\\"type\\\":\\\"MODIFY\\\"},{\\\"classFile\\\":\\\"com/caocao/dic/core/service/pay/impl/AutoPayServiceImpl\\\",\\\"methodInfos\\\":[{\\\"methodName\\\":\\\"addAutoPayTask\\\",\\\"parameters\\\":\\\"AutoPayContext context\\\"}],\\\"type\\\":\\\"MODIFY\\\"},{\\\"classFile\\\":\\\"com/caocao/dic/core/service/provider/open/OpenChargingStationServiceImpl\\\",\\\"methodInfos\\\":[{\\\"methodName\\\":\\\"getPileInfoByScan\\\",\\\"parameters\\\":\\\"@FluentValid({ExtSourceValidator.class}) QueryPileInfoByScanRequest scanRequest\\\"},{\\\"methodName\\\":\\\"getPileInfoByScan\\\",\\\"parameters\\\":\\\"String qrCode, String providerNo, String pileNo, String sourceTypeKey\\\"}],\\\"type\\\":\\\"MODIFY\\\"},{\\\"classFile\\\":\\\"com/caocao/dic/common/util/SourceTypeHelper\\\",\\\"methodInfos\\\":[{\\\"methodName\\\":\\\"needCheckPrefrozenSourceType\\\",\\\"parameters\\\":\\\"String sourceTypeKey\\\"}],\\\"type\\\":\\\"MODIFY\\\"}]\" --encoding=utf8";
        Runtime run = Runtime.getRuntime();
        Process p = run.exec(exc);
        p.waitFor();
        p.destroy();
    }

    @Test
    void diffMethods() {
//        DiffMethodParams diff = DiffMethodParams.builder()
//                .baseVersion("dac68b2f3976509b4204a66df8f5e71dffe023b7")
//                .nowVersion("74c026849763f1f9f0dfc967949d0b581959c2ea")
//                .gitUrl("https://github.com/rayduan/devops-data.git")
//                .build();
        DiffMethodParams diff = DiffMethodParams.builder()
                .baseVersion("db84201eea9be107073fa07c24e30262ac91d384")
                .nowVersion("dca3a374ba9100c64b970081fad5db7335e99ff6")
                .gitUrl("https://github.com/rayduan/base-service.git")
                .build();
        gitConfig.diffMethods(diff);
    }
}