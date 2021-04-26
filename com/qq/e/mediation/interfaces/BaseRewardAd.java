package com.qq.e.mediation.interfaces;

import android.app.Activity;
import android.content.Context;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
/* loaded from: classes6.dex */
public abstract class BaseRewardAd {
    public static final int DEFAULT_PRIORITY = -1;
    public static final int EVENT_TYPE_ON_AD_CLICK = 6;
    public static final int EVENT_TYPE_ON_AD_CLOSE = 8;
    public static final int EVENT_TYPE_ON_AD_EXPOSE = 4;
    public static final int EVENT_TYPE_ON_AD_LOADED = 1;
    public static final int EVENT_TYPE_ON_AD_SHOW = 3;
    public static final int EVENT_TYPE_ON_ERROR = 9;
    public static final int EVENT_TYPE_ON_REWARD = 5;
    public static final int EVENT_TYPE_ON_VIDEO_CACHED = 2;
    public static final int EVENT_TYPE_ON_VIDEO_COMPLETE = 7;

    /* renamed from: a  reason: collision with root package name */
    public LoadAdParams f36365a = null;

    public BaseRewardAd(Context context, String str, String str2, String str3) {
    }

    public int getAdapterPriority() {
        return -1;
    }

    public abstract int getECPM();

    public abstract String getECPMLevel();

    public abstract long getExpireTimestamp();

    public LoadAdParams getLoadAdParams() {
        return this.f36365a;
    }

    public int getRewardAdType() {
        return 0;
    }

    public abstract int getVideoDuration();

    public abstract boolean hasShown();

    public abstract void loadAD();

    public abstract void setAdListener(ADListener aDListener);

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.f36365a = loadAdParams;
    }

    public abstract void setVolumeOn(boolean z);

    public abstract void showAD();

    public void showAD(Activity activity) {
        showAD();
    }
}
