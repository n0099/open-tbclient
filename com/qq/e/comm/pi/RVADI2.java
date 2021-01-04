package com.qq.e.comm.pi;

import android.app.Activity;
/* loaded from: classes3.dex */
public interface RVADI2 {
    void destroy();

    String getECPMLevel();

    long getExpireTimestamp();

    int getVideoDuration();

    boolean hasShown();

    boolean isVideoCached();

    void loadAD();

    void setVolumeOn(boolean z);

    void showAD(Activity activity);
}
