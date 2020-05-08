package com.demo.sdkforbaidudemo;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.w;
import com.kascend.cstvsdk.CSTVSdk;
import com.kascend.cstvsdk.SdkConfig;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class ChushouSdkInit {
    public static final void testInit(Application application) {
        SdkConfig sdkConfig = new SdkConfig();
        sdkConfig.setApplication(application);
        sdkConfig.setResources(application.getResources());
        sdkConfig.setXappkey("7abec51b863e0a3");
        sdkConfig.setXsecret("cc9181875b65f7eaec6bd0cad5c09369");
        sdkConfig.setServer("rc");
        sdkConfig.setOkhttp(null);
        sdkConfig.setDebug(false);
        sdkConfig.setThirdParty(ChushouSdkThirdParty.class);
        sdkConfig.setSdkHostParams(generateCommonParams());
        CSTVSdk.INSTANCE.init(sdkConfig);
        TbadkCoreApplication.isChushouInit = CSTVSdk.INSTANCE.getInitialized();
    }

    public static final void testStartLiveRoom(Context context, String str, String str2) {
        if (!CyberPlayerManager.isCoreLoaded(1)) {
            CyberPlayerManager.install(TbadkCoreApplication.getInst().getContext(), TbadkCoreApplication.getInst().getCuid(), null, 1, null, null, null);
        }
        CSTVSdk.INSTANCE.startLiveRoom(context, str, str2);
    }

    private static final HashMap<String, String> generateCommonParams() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("_client_type", "2");
        if (!TbadkCoreApplication.getInst().isOfficial()) {
            hashMap.put("apid", "sw");
        }
        hashMap.put("_client_version", TbConfig.getVersion());
        if (TbadkCoreApplication.getInst().getImei() != null) {
            hashMap.put("_phone_imei", TbadkCoreApplication.getInst().getImei());
        }
        String clientId = TbadkCoreApplication.getClientId();
        if (clientId != null) {
            hashMap.put("_client_id", clientId);
        }
        hashMap.put("subapp_type", "tieba");
        String from = TbadkCoreApplication.getFrom();
        if (from != null && from.length() > 0) {
            hashMap.put("from", from);
        }
        hashMap.put("net_type", String.valueOf(j.netType()));
        String bax = w.bax();
        if (!TextUtils.isEmpty(bax)) {
            hashMap.put("oaid", bax);
        }
        hashMap.put("cuid", TbadkCoreApplication.getInst().getCuid());
        hashMap.put("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
        hashMap.put("cuid_gid", TbadkCoreApplication.getInst().getCuidGid());
        hashMap.put("timestamp", Long.toString(System.currentTimeMillis()));
        hashMap.put("model", Build.MODEL);
        return hashMap;
    }
}
