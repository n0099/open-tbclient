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
/* loaded from: classes7.dex */
public class NativeUnifiedADDataAdapter implements NativeUnifiedADData, DownloadConfirmListener {

    /* renamed from: a  reason: collision with root package name */
    public NativeUnifiedADData f39072a;

    /* renamed from: b  reason: collision with root package name */
    public NativeADEventListener f39073b;

    /* renamed from: c  reason: collision with root package name */
    public NativeADMediaListener f39074c;

    /* renamed from: d  reason: collision with root package name */
    public DownloadConfirmListener f39075d;

    /* loaded from: classes7.dex */
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
        this.f39072a = nativeUnifiedADData;
        if (nativeUnifiedADData instanceof ADEventListener) {
            ((ADEventListener) nativeUnifiedADData).setAdListener(new UnifiedAdListener(this, (byte) 0));
        }
    }

    public static /* synthetic */ void a(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, ADEvent aDEvent) {
        if (nativeUnifiedADDataAdapter.f39073b != null) {
            int type = aDEvent.getType();
            if (type == 1) {
                nativeUnifiedADDataAdapter.f39073b.onADExposed();
            } else if (type != 2) {
                if (type != 3) {
                    if (type != 4) {
                        return;
                    }
                    nativeUnifiedADDataAdapter.f39073b.onADStatusChanged();
                } else if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                    nativeUnifiedADDataAdapter.f39073b.onADError(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                }
            } else if (aDEvent.getParas().length <= 0 || !(aDEvent.getParas()[0] instanceof String)) {
            } else {
                try {
                    NativeUnifiedADData.ext.put(Constants.KEYS.EXPOSED_CLICK_URL_KEY, (String) aDEvent.getParas()[0]);
                } catch (Exception e2) {
                    GDTLogger.e("native 2.0 set click url error");
                    e2.printStackTrace();
                }
                NativeADEventListener nativeADEventListener = nativeUnifiedADDataAdapter.f39073b;
                if (!(nativeADEventListener instanceof NativeADEventListenerWithClickInfo)) {
                    nativeADEventListener.onADClicked();
                    return;
                }
                View view = null;
                if (aDEvent.getParas().length == 2 && (aDEvent.getParas()[1] instanceof View)) {
                    view = (View) aDEvent.getParas()[1];
                }
                ((NativeADEventListenerWithClickInfo) nativeUnifiedADDataAdapter.f39073b).onADClicked(view);
            }
        }
    }

    public static /* synthetic */ void b(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, ADEvent aDEvent) {
        if (nativeUnifiedADDataAdapter.f39074c != null) {
            switch (aDEvent.getType()) {
                case 5:
                    nativeUnifiedADDataAdapter.f39074c.onVideoInit();
                    return;
                case 6:
                    nativeUnifiedADDataAdapter.f39074c.onVideoLoading();
                    return;
                case 7:
                    nativeUnifiedADDataAdapter.f39074c.onVideoReady();
                    return;
                case 8:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        nativeUnifiedADDataAdapter.f39074c.onVideoLoaded(((Integer) aDEvent.getParas()[0]).intValue());
                        return;
                    }
                    return;
                case 9:
                    nativeUnifiedADDataAdapter.f39074c.onVideoStart();
                    return;
                case 10:
                    nativeUnifiedADDataAdapter.f39074c.onVideoPause();
                    return;
                case 11:
                    nativeUnifiedADDataAdapter.f39074c.onVideoResume();
                    return;
                case 12:
                    nativeUnifiedADDataAdapter.f39074c.onVideoCompleted();
                    return;
                case 13:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        nativeUnifiedADDataAdapter.f39074c.onVideoError(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                        return;
                    }
                    return;
                case 14:
                    nativeUnifiedADDataAdapter.f39074c.onVideoStop();
                    return;
                case 15:
                    nativeUnifiedADDataAdapter.f39074c.onVideoClicked();
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list) {
        this.f39072a.bindAdToView(context, nativeAdContainer, layoutParams, list);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        this.f39072a.bindAdToView(context, nativeAdContainer, layoutParams, list, list2);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindCTAViews(List<View> list) {
        this.f39072a.bindCTAViews(list);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindMediaView(MediaView mediaView, VideoOption videoOption, NativeADMediaListener nativeADMediaListener) {
        this.f39074c = nativeADMediaListener;
        this.f39072a.bindMediaView(mediaView, videoOption, null);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void destroy() {
        this.f39072a.destroy();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData) {
        return this.f39072a.equalsAdData(nativeUnifiedADData);
    }

    public NativeUnifiedADData getAdData() {
        return this.f39072a;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAdPatternType() {
        return this.f39072a.getAdPatternType();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return this.f39072a.getApkInfoUrl();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public double getAppPrice() {
        return this.f39072a.getAppPrice();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppScore() {
        return this.f39072a.getAppScore();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppStatus() {
        return this.f39072a.getAppStatus();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getCTAText() {
        return this.f39072a.getCTAText();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getDesc() {
        return this.f39072a.getDesc();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public long getDownloadCount() {
        return this.f39072a.getDownloadCount();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getECPM() {
        return this.f39072a.getECPM();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getECPMLevel() {
        return this.f39072a.getECPMLevel();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getIconUrl() {
        return this.f39072a.getIconUrl();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public List<String> getImgList() {
        return this.f39072a.getImgList();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getImgUrl() {
        return this.f39072a.getImgUrl();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureHeight() {
        return this.f39072a.getPictureHeight();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureWidth() {
        return this.f39072a.getPictureWidth();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getProgress() {
        return this.f39072a.getProgress();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getTitle() {
        return this.f39072a.getTitle();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getVastContent() {
        return this.f39072a.getVastContent();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getVastTag() {
        return this.f39072a.getVastTag();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoCurrentPosition() {
        return this.f39072a.getVideoCurrentPosition();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoDuration() {
        return this.f39072a.getVideoDuration();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isAppAd() {
        return this.f39072a.isAppAd();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isSkippable() {
        return this.f39072a.isSkippable();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void negativeFeedback() {
        this.f39072a.negativeFeedback();
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.f39075d;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i2, str, downloadConfirmCallBack);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void onVideoADExposured(View view) {
        this.f39072a.onVideoADExposured(view);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void pauseAppDownload() {
        this.f39072a.pauseAppDownload();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void pauseVideo() {
        this.f39072a.pauseVideo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void preloadVideo(VideoPreloadListener videoPreloadListener) {
        this.f39072a.preloadVideo(videoPreloadListener);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void reportVastEvent(ADEvent aDEvent) {
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resume() {
        this.f39072a.resume();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeAppDownload() {
        this.f39072a.resumeAppDownload();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeVideo() {
        this.f39072a.resumeVideo();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.f39075d = downloadConfirmListener;
        NativeUnifiedADData nativeUnifiedADData = this.f39072a;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.setDownloadConfirmListener(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setNativeAdEventListener(NativeADEventListener nativeADEventListener) {
        this.f39073b = nativeADEventListener;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setVideoMute(boolean z) {
        this.f39072a.setVideoMute(z);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void startVideo() {
        this.f39072a.startVideo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void stopVideo() {
        this.f39072a.stopVideo();
    }
}
