package com.qq.e.ads.nativ;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.List;
/* loaded from: classes6.dex */
public class NativeUnifiedADDataAdapter implements NativeUnifiedADData, DownloadConfirmListener {

    /* renamed from: a  reason: collision with root package name */
    public NativeUnifiedADData f38455a;

    /* renamed from: b  reason: collision with root package name */
    public NativeADEventListener f38456b;

    /* renamed from: c  reason: collision with root package name */
    public NativeADMediaListener f38457c;

    /* renamed from: d  reason: collision with root package name */
    public DownloadConfirmListener f38458d;

    /* loaded from: classes6.dex */
    public class UnifiedAdListener implements ADListener {
        public UnifiedAdListener() {
        }

        public /* synthetic */ UnifiedAdListener(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, byte b2) {
            this();
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (aDEvent.getType() <= 4) {
                NativeUnifiedADDataAdapter.a(NativeUnifiedADDataAdapter.this, aDEvent);
            } else {
                NativeUnifiedADDataAdapter.b(NativeUnifiedADDataAdapter.this, aDEvent);
            }
        }
    }

    public NativeUnifiedADDataAdapter(NativeUnifiedADData nativeUnifiedADData) {
        this.f38455a = nativeUnifiedADData;
        if (nativeUnifiedADData instanceof ADEventListener) {
            ((ADEventListener) nativeUnifiedADData).setAdListener(new UnifiedAdListener(this, (byte) 0));
        }
    }

    public static /* synthetic */ void a(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, ADEvent aDEvent) {
        if (nativeUnifiedADDataAdapter.f38456b != null) {
            int type = aDEvent.getType();
            if (type == 1) {
                nativeUnifiedADDataAdapter.f38456b.onADExposed();
            } else if (type != 2) {
                if (type != 3) {
                    if (type != 4) {
                        return;
                    }
                    nativeUnifiedADDataAdapter.f38456b.onADStatusChanged();
                } else if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                    nativeUnifiedADDataAdapter.f38456b.onADError(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                }
            } else if (aDEvent.getParas().length <= 0 || !(aDEvent.getParas()[0] instanceof String)) {
            } else {
                try {
                    NativeUnifiedADData.ext.put(Constants.KEYS.EXPOSED_CLICK_URL_KEY, (String) aDEvent.getParas()[0]);
                } catch (Exception e2) {
                    GDTLogger.e("native 2.0 set click url error");
                    e2.printStackTrace();
                }
                NativeADEventListener nativeADEventListener = nativeUnifiedADDataAdapter.f38456b;
                if (!(nativeADEventListener instanceof NativeADEventListenerWithClickInfo)) {
                    nativeADEventListener.onADClicked();
                    return;
                }
                View view = null;
                if (aDEvent.getParas().length == 2 && (aDEvent.getParas()[1] instanceof View)) {
                    view = (View) aDEvent.getParas()[1];
                }
                ((NativeADEventListenerWithClickInfo) nativeUnifiedADDataAdapter.f38456b).onADClicked(view);
            }
        }
    }

    public static /* synthetic */ void b(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, ADEvent aDEvent) {
        if (nativeUnifiedADDataAdapter.f38457c != null) {
            switch (aDEvent.getType()) {
                case 5:
                    nativeUnifiedADDataAdapter.f38457c.onVideoInit();
                    return;
                case 6:
                    nativeUnifiedADDataAdapter.f38457c.onVideoLoading();
                    return;
                case 7:
                    nativeUnifiedADDataAdapter.f38457c.onVideoReady();
                    return;
                case 8:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        nativeUnifiedADDataAdapter.f38457c.onVideoLoaded(((Integer) aDEvent.getParas()[0]).intValue());
                        return;
                    }
                    return;
                case 9:
                    nativeUnifiedADDataAdapter.f38457c.onVideoStart();
                    return;
                case 10:
                    nativeUnifiedADDataAdapter.f38457c.onVideoPause();
                    return;
                case 11:
                    nativeUnifiedADDataAdapter.f38457c.onVideoResume();
                    return;
                case 12:
                    nativeUnifiedADDataAdapter.f38457c.onVideoCompleted();
                    return;
                case 13:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        nativeUnifiedADDataAdapter.f38457c.onVideoError(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                        return;
                    }
                    return;
                case 14:
                    nativeUnifiedADDataAdapter.f38457c.onVideoStop();
                    return;
                case 15:
                    nativeUnifiedADDataAdapter.f38457c.onVideoClicked();
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list) {
        this.f38455a.bindAdToView(context, nativeAdContainer, layoutParams, list);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        this.f38455a.bindAdToView(context, nativeAdContainer, layoutParams, list, list2);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindCTAViews(List<View> list) {
        this.f38455a.bindCTAViews(list);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindMediaView(MediaView mediaView, VideoOption videoOption, NativeADMediaListener nativeADMediaListener) {
        this.f38457c = nativeADMediaListener;
        this.f38455a.bindMediaView(mediaView, videoOption, null);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void destroy() {
        this.f38455a.destroy();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData) {
        return this.f38455a.equalsAdData(nativeUnifiedADData);
    }

    public NativeUnifiedADData getAdData() {
        return this.f38455a;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAdPatternType() {
        return this.f38455a.getAdPatternType();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return this.f38455a.getApkInfoUrl();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public double getAppPrice() {
        return this.f38455a.getAppPrice();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppScore() {
        return this.f38455a.getAppScore();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppStatus() {
        return this.f38455a.getAppStatus();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getCTAText() {
        return this.f38455a.getCTAText();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getDesc() {
        return this.f38455a.getDesc();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public long getDownloadCount() {
        return this.f38455a.getDownloadCount();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getECPM() {
        return this.f38455a.getECPM();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getECPMLevel() {
        return this.f38455a.getECPMLevel();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getIconUrl() {
        return this.f38455a.getIconUrl();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public List<String> getImgList() {
        return this.f38455a.getImgList();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getImgUrl() {
        return this.f38455a.getImgUrl();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureHeight() {
        return this.f38455a.getPictureHeight();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureWidth() {
        return this.f38455a.getPictureWidth();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getProgress() {
        return this.f38455a.getProgress();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getTitle() {
        return this.f38455a.getTitle();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getVastContent() {
        return this.f38455a.getVastContent();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getVastTag() {
        return this.f38455a.getVastTag();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoCurrentPosition() {
        return this.f38455a.getVideoCurrentPosition();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoDuration() {
        return this.f38455a.getVideoDuration();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isAppAd() {
        return this.f38455a.isAppAd();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isSkippable() {
        return this.f38455a.isSkippable();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void negativeFeedback() {
        this.f38455a.negativeFeedback();
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.f38458d;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i, str, downloadConfirmCallBack);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void onVideoADExposured(View view) {
        this.f38455a.onVideoADExposured(view);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void pauseAppDownload() {
        this.f38455a.pauseAppDownload();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void pauseVideo() {
        this.f38455a.pauseVideo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void preloadVideo(VideoPreloadListener videoPreloadListener) {
        this.f38455a.preloadVideo(videoPreloadListener);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void reportVastEvent(ADEvent aDEvent) {
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resume() {
        this.f38455a.resume();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeAppDownload() {
        this.f38455a.resumeAppDownload();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeVideo() {
        this.f38455a.resumeVideo();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.f38458d = downloadConfirmListener;
        NativeUnifiedADData nativeUnifiedADData = this.f38455a;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.setDownloadConfirmListener(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setNativeAdEventListener(NativeADEventListener nativeADEventListener) {
        this.f38456b = nativeADEventListener;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setVideoMute(boolean z) {
        this.f38455a.setVideoMute(z);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void startVideo() {
        this.f38455a.startVideo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void stopVideo() {
        this.f38455a.stopVideo();
    }
}
