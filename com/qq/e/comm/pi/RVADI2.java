package com.qq.e.comm.pi;

import android.app.Activity;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
/* loaded from: classes4.dex */
public interface RVADI2 extends LADI {
    void destroy();

    long getExpireTimestamp();

    int getVideoDuration();

    boolean hasShown();

    boolean isVideoCached();

    void loadAD();

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    void setVolumeOn(boolean z);

    void showAD(Activity activity);
}
