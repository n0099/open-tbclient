package com.qq.e.comm.pi;

import android.app.Activity;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.ADRewardListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.constants.LoadAdParams;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public interface UIADI extends LADI {
    public static final Map<String, String> ext = new HashMap();

    void close();

    void destory();

    String getAdNetWorkName();

    int getAdPatternType();

    int getVideoDuration();

    boolean isValid();

    void loadAd();

    void loadFullScreenAD();

    void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy);

    void setLoadAdParams(LoadAdParams loadAdParams);

    void setMaxVideoDuration(int i);

    void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener);

    void setMinVideoDuration(int i);

    void setRewardListener(ADRewardListener aDRewardListener);

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    void setVideoOption(VideoOption videoOption);

    void setVideoPlayPolicy(int i);

    void show();

    void show(Activity activity);

    void showAsPopupWindow();

    void showAsPopupWindow(Activity activity);

    void showFullScreenAD(Activity activity);
}
