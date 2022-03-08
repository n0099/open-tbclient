package com.qq.e.comm.pi;

import android.app.Activity;
import com.qq.e.ads.nativ.express2.VideoOption2;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
/* loaded from: classes8.dex */
public interface UIADI2 extends LADI {
    void closeHalfScreenAD();

    void destroy();

    long getExpireTimestamp();

    int getVideoDuration();

    boolean hasShown();

    boolean isVideoAd();

    boolean isVideoCached();

    void loadFullScreenAD();

    void loadHalfScreenAD();

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    void setVideoOption(VideoOption2 videoOption2);

    void showFullScreenAD(Activity activity);

    void showHalfScreenAD(Activity activity);
}
