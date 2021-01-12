package com.qq.e.comm.plugin.util;

import com.qq.e.comm.managers.GDTADManager;
/* loaded from: classes3.dex */
public class ar {
    public static String a() {
        String aDActivityClazz = GDTADManager.getInstance().getADActivityClazz();
        return aDActivityClazz == null ? "com.qq.e.ads.AdActivity" : aDActivityClazz;
    }

    public static String b() {
        String portraitADActivityClazz = GDTADManager.getInstance().getPortraitADActivityClazz();
        return portraitADActivityClazz == null ? "com.qq.e.ads.PortraitADActivity" : portraitADActivityClazz;
    }

    public static String c() {
        String rewardvideoPortraitADActivityClazz = GDTADManager.getInstance().getRewardvideoPortraitADActivityClazz();
        return rewardvideoPortraitADActivityClazz == null ? "com.qq.e.ads.RewardvideoPortraitADActivity" : rewardvideoPortraitADActivityClazz;
    }

    public static String d() {
        String landscapeADActivityClazz = GDTADManager.getInstance().getLandscapeADActivityClazz();
        return landscapeADActivityClazz == null ? "com.qq.e.ads.LandscapeADActivity" : landscapeADActivityClazz;
    }

    public static String e() {
        String rewardvideoLandscapeADActivityClazz = GDTADManager.getInstance().getRewardvideoLandscapeADActivityClazz();
        return rewardvideoLandscapeADActivityClazz == null ? "com.qq.e.ads.RewardvideoLandscapeADActivity" : rewardvideoLandscapeADActivityClazz;
    }

    public static String f() {
        String downLoadClazz = GDTADManager.getInstance().getDownLoadClazz();
        return downLoadClazz == null ? "com.qq.e.comm.DownloadService" : downLoadClazz;
    }
}
