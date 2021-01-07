package com.qq.e.comm.plugin.ad;
/* loaded from: classes4.dex */
public enum e {
    BANNER(1, 1),
    INTERSTITIAL(2, 3),
    APP_WALL(3, 8),
    SPLASH(4, 1),
    FEEDS(5, 1),
    NATIVEMEDIAAD(7, 1),
    GDTNATIVEAD(8, 1),
    GRID(6, 9),
    NATIVEEXPRESSAD(9, 1),
    CONTENTAD(10, 1),
    REWARDVIDEOAD(11, 1),
    NATIVEUNIFIEDAD(12, 1),
    UNIFIED_BANNER(13, 1),
    UNIFIED_INTERSTITIAL(14, 1),
    ROSE_AD(15, 1),
    PREMOVIE_AD(16, 1),
    PAUSE_AD(17, 1),
    POSTMOVIE_AD(18, 1),
    ENDING_AD(19, 1),
    HIGHLIGHT_AD(20, 1),
    IDLE_AD(21, 1),
    UNIFIED_INTERSTITIAL_FULLSCREEN(22, 1),
    EXPRESS2(23, 1),
    REWARDVIDEOAD2(24, 1);
    
    private int y;
    private int z;

    e(int i, int i2) {
        this.y = i;
        this.z = i2;
        ordinal();
    }

    public static e a(String str) {
        if ("banner".equals(str)) {
            return BANNER;
        }
        if ("appwall".equals(str)) {
            return APP_WALL;
        }
        if ("inter".equals(str)) {
            return INTERSTITIAL;
        }
        if ("splash".equals(str)) {
            return SPLASH;
        }
        if ("feeds".equals(str)) {
            return FEEDS;
        }
        if ("nativemediaad".equals(str)) {
            return NATIVEMEDIAAD;
        }
        if ("gdtnativead".equals(str)) {
            return GDTNATIVEAD;
        }
        if ("grid".equals(str)) {
            return GRID;
        }
        if ("nativeexpressad".equals(str)) {
            return NATIVEEXPRESSAD;
        }
        if ("contentad".equals(str)) {
            return CONTENTAD;
        }
        if ("rewardvideoad".equals(str)) {
            return REWARDVIDEOAD;
        }
        if ("nativeunifiedad".equals(str)) {
            return NATIVEUNIFIEDAD;
        }
        if ("banner2".equals(str)) {
            return UNIFIED_BANNER;
        }
        if ("inter2".equals(str)) {
            return UNIFIED_INTERSTITIAL;
        }
        if ("rose".equals(str)) {
            return ROSE_AD;
        }
        if ("premovie".equals(str)) {
            return PREMOVIE_AD;
        }
        if ("pause".equals(str)) {
            return PAUSE_AD;
        }
        if ("postmovie".equals(str)) {
            return POSTMOVIE_AD;
        }
        if ("ending".equals(str)) {
            return ENDING_AD;
        }
        if ("highlight".equals(str)) {
            return HIGHLIGHT_AD;
        }
        if ("idle".equals(str)) {
            return IDLE_AD;
        }
        if ("inter2fs".equals(str)) {
            return UNIFIED_INTERSTITIAL_FULLSCREEN;
        }
        if ("EXPRESS2".equals(str)) {
            return EXPRESS2;
        }
        if ("rewardvideoad2".equals(str)) {
            return REWARDVIDEOAD2;
        }
        return null;
    }

    public int b() {
        return this.y;
    }

    public int c() {
        return this.z;
    }
}
