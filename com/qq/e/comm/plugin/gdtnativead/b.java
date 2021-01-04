package com.qq.e.comm.plugin.gdtnativead;

import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
class b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(String str) {
        return GDTADManager.getInstance().getSM().getIntegerForPlacement(Constants.KEYS.DownConfirm, str, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, DownAPPConfirmPolicy downAPPConfirmPolicy) {
        GDTADManager.getInstance().getSM().setDEVCodeSetting(Constants.KEYS.DownConfirm, Integer.valueOf(downAPPConfirmPolicy.value()), str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str, VideoOption videoOption) {
        GDTADManager.getInstance().getSM().setDEVCodeSetting("videoOptions", videoOption.getOptions().toString(), str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return GDTADManager.getInstance().getSM().getInteger("expressInstallFilter", 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JSONObject b(String str) {
        String stringForPlacement = GDTADManager.getInstance().getSM().getStringForPlacement("videoOptions", str);
        try {
            if (stringForPlacement == null) {
                stringForPlacement = "{}";
            }
            return new JSONObject(stringForPlacement);
        } catch (JSONException e) {
            return new JSONObject();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b() {
        return GDTADManager.getInstance().getSM().getInteger("nativeExpressPreloadVideo", 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c() {
        return GDTADManager.getInstance().getSM().getString("aNativeJS_1_1");
    }
}
