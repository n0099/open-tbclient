package com.qq.e.comm.constants;

import com.qq.e.ads.ADActivity;
import com.qq.e.ads.LandscapeADActivity;
import com.qq.e.ads.PortraitADActivity;
import com.qq.e.ads.RewardvideoLandscapeADActivity;
import com.qq.e.ads.RewardvideoPortraitADActivity;
import com.qq.e.comm.DownloadService;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.util.StringUtil;
/* loaded from: classes7.dex */
public class CustomPkgConstants {

    /* renamed from: a  reason: collision with root package name */
    public static final String f39171a = DownloadService.class.getName();

    /* renamed from: b  reason: collision with root package name */
    public static final String f39172b = ADActivity.class.getName();

    /* renamed from: c  reason: collision with root package name */
    public static final String f39173c = PortraitADActivity.class.getName();

    /* renamed from: d  reason: collision with root package name */
    public static final String f39174d = RewardvideoPortraitADActivity.class.getName();

    /* renamed from: e  reason: collision with root package name */
    public static final String f39175e = LandscapeADActivity.class.getName();

    /* renamed from: f  reason: collision with root package name */
    public static final String f39176f = RewardvideoLandscapeADActivity.class.getName();

    public static String getADActivityName() {
        String customADActivityClassName = GlobalSetting.getCustomADActivityClassName();
        return !StringUtil.isEmpty(customADActivityClassName) ? customADActivityClassName : f39172b;
    }

    public static String getAssetPluginDir() {
        return "gdt_plugin";
    }

    public static String getAssetPluginName() {
        return "gdtadv2.jar";
    }

    public static String getAssetPluginXorKey() {
        return "";
    }

    public static String getDownLoadServiceName() {
        return f39171a;
    }

    public static String getLandscapeADActivityName() {
        String customLandscapeActivityClassName = GlobalSetting.getCustomLandscapeActivityClassName();
        return !StringUtil.isEmpty(customLandscapeActivityClassName) ? customLandscapeActivityClassName : f39175e;
    }

    public static String getPortraitADActivityName() {
        String customPortraitActivityClassName = GlobalSetting.getCustomPortraitActivityClassName();
        return !StringUtil.isEmpty(customPortraitActivityClassName) ? customPortraitActivityClassName : f39173c;
    }

    public static String getRewardvideoLandscapeADActivityName() {
        String customRewardvideoLandscapeActivityClassName = GlobalSetting.getCustomRewardvideoLandscapeActivityClassName();
        return !StringUtil.isEmpty(customRewardvideoLandscapeActivityClassName) ? customRewardvideoLandscapeActivityClassName : f39176f;
    }

    public static String getRewardvideoPortraitADActivityName() {
        String customRewardvideoPortraitActivityClassName = GlobalSetting.getCustomRewardvideoPortraitActivityClassName();
        return !StringUtil.isEmpty(customRewardvideoPortraitActivityClassName) ? customRewardvideoPortraitActivityClassName : f39174d;
    }
}
