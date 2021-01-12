package com.example.flutter_lottie;

import java.util.HashMap;
/* loaded from: classes14.dex */
public class LottieNameTransform {
    private static HashMap<String, String> platformImageNameMap = new HashMap<>();

    static {
        platformImageNameMap.put("full_screen_loading", "lottie_full_screen_refresh");
        platformImageNameMap.put("full_screen_loading_night", "lottie_full_screen_refresh_1");
        platformImageNameMap.put("full_screen_loading_dark", "lottie_full_screen_refresh_2");
        platformImageNameMap.put("lottie_pull_refresh", "lottie_common_pull_refresh");
        platformImageNameMap.put("lottie_pull_refresh_night", "lottie_common_pull_refresh_1");
        platformImageNameMap.put("lottie_pull_refresh_dark", "lottie_common_pull_refresh_2");
    }

    public static String getAndroidNameFromIos(String str) {
        return platformImageNameMap.containsKey(str) ? platformImageNameMap.get(str) : str;
    }
}
