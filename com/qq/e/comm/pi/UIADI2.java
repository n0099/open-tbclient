package com.qq.e.comm.pi;

import android.app.Activity;
import com.qq.e.ads.nativ.express2.VideoOption2;
import com.qq.e.comm.compliance.ApkDownloadComplianceInterface;
/* loaded from: classes7.dex */
public interface UIADI2 extends ApkDownloadComplianceInterface {
    void closeHalfScreenAD();

    void destroy();

    String getECPMLevel();

    long getExpireTimestamp();

    int getVideoDuration();

    boolean hasShown();

    boolean isVideoAd();

    boolean isVideoCached();

    void loadFullScreenAD();

    void loadHalfScreenAD();

    void setVideoOption(VideoOption2 videoOption2);

    void showFullScreenAD(Activity activity);

    void showHalfScreenAD(Activity activity);
}
