package com.qq.e.comm.plugin.ad;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes3.dex */
public enum d {
    BANNER_240(e.BANNER, 240, 38),
    BANNER_320(e.BANNER, 320, 50),
    BANNER_480(e.BANNER, 480, 75),
    BANNER_640(e.BANNER, 640, 100),
    INTERSTITIAL_300(e.INTERSTITIAL, 300, 250),
    INTERSTITIAL_600(e.INTERSTITIAL, 600, 500),
    APPWALL_72(e.APP_WALL, 72, 72),
    SPLASH_320(e.SPLASH, 320, 480),
    SPLASH_640(e.SPLASH, 640, TbConfig.HEAD_IMG_SIZE),
    FEEDS_1000(e.FEEDS, 1000, 560);
    
    private e k;
    private int l;
    private int m;

    d(e eVar, int i, int i2) {
        this.k = eVar;
        this.l = i;
        this.m = i2;
    }

    public int a() {
        return this.l;
    }

    public int b() {
        return this.m;
    }
}
