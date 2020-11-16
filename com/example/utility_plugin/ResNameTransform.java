package com.example.utility_plugin;

import java.util.HashMap;
/* loaded from: classes12.dex */
public class ResNameTransform {
    private static HashMap<String, String> platformImageNameMap = new HashMap<>();

    static {
        platformImageNameMap.put("full_screen_loading", "lottie_full_screen_refresh");
        platformImageNameMap.put("lottie_pull_refresh", "lottie_common_pull_refresh");
        platformImageNameMap.put("ad_refresh_load", "lottie_frs_refresh");
        platformImageNameMap.put("lottie_live_status_new", "ala_live2");
        platformImageNameMap.put("profileViewOnLivingCardNormal", "card_live_bg");
    }

    public static String getAndroidNameFromIos(String str) {
        return platformImageNameMap.containsKey(str) ? platformImageNameMap.get(str) : str;
    }
}
