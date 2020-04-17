package com.example.utility_plugin;

import java.util.HashMap;
/* loaded from: classes6.dex */
public class ResNameTransform {
    private static HashMap<String, String> platformImageNameMap = new HashMap<>();

    static {
        platformImageNameMap.put("full_screen_loading", "lottie_full_screen_refresh");
        platformImageNameMap.put("lottie_pull_refresh", "lottie_common_pull_refresh");
    }

    public static String getAndroidNameFromIos(String str) {
        return platformImageNameMap.containsKey(str) ? platformImageNameMap.get(str) : str;
    }
}
