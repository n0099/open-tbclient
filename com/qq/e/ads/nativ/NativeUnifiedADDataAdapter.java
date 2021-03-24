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
    public NativeUnifiedADData f38165a;

    /* renamed from: b  reason: collision with root package name */
    public NativeADEventListener f38166b;

    /* renamed from: c  reason: collision with root package name */
    public NativeADMediaListener f38167c;

    /* renamed from: d  reason: collision with root package name */
    public DownloadConfirmListener f38168d;

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
        this.f38165a = nativeUnifiedADData;
        if (nativeUnifiedADData instanceof ADEventListener) {
            ((ADEventListener) nativeUnifiedADData).setAdListener(new UnifiedAdListener(this, (byte) 0));
        }
    }

    public static /* synthetic */ void a(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, ADEvent aDEvent) {
        if (nativeUnifiedADDataAdapter.f38166b != null) {
            int type = aDEvent.getType();
            if (type == 1) {
                nativeUnifiedADDataAdapter.f38166b.onADExposed();
            } else if (type != 2) {
                if (type != 3) {
                    if (type != 4) {
                        return;
                    }
                    nativeUnifiedADDataAdapter.f38166b.onADStatusChanged();
                } else if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                    nativeUnifiedADDataAdapter.f38166b.onADError(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                }
            } else if (aDEvent.getParas().length <= 0 || !(aDEvent.getParas()[0] instanceof String)) {
            } else {
                try {
                    NativeUnifiedADData.ext.put(Constants.KEYS.EXPOSED_CLICK_URL_KEY, (String) aDEvent.getParas()[0]);
                } catch (Exception e2) {
                    GDTLogger.e("native 2.0 set click url error");
                    e2.printStackTrace();
                }
                NativeADEventListener nativeADEventListener = nativeUnifiedADDataAdapter.f38166b;
                if (!(nativeADEventListener instanceof NativeADEventListenerWithClickInfo)) {
                    nativeADEventListener.onADClicked();
                    return;
                }
                View view = null;
                if (aDEvent.getParas().length == 2 && (aDEvent.getParas()[1] instanceof View)) {
                    view = (View) aDEvent.getParas()[1];
                }
                ((NativeADEventListenerWithClickInfo) nativeUnifiedADDataAdapter.f38166b).onADClicked(view);
            }
        }
    }

    public static /* synthetic */ void b(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, ADEvent aDEvent) {
        if (nativeUnifiedADDataAdapter.f38167c != null) {
            switch (aDEvent.getType()) {
                case 5:
                    nativeUnifiedADDataAdapter.f38167c.onVideoInit();
                    return;
                case 6:
                    nativeUnifiedADDataAdapter.f38167c.onVideoLoading();
                    return;
                case 7:
                    nativeUnifiedADDataAdapter.f38167c.onVideoReady();
                    return;
                case 8:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        nativeUnifiedADDataAdapter.f38167c.onVideoLoaded(((Integer) aDEvent.getParas()[0]).intValue());
                        return;
                    }
                    return;
                case 9:
                    nativeUnifiedADDataAdapter.f38167c.onVideoStart();
                    return;
                case 10:
                    nativeUnifiedADDataAdapter.f38167c.onVideoPause();
                    return;
                case 11:
                    nativeUnifiedADDataAdapter.f38167c.onVideoResume();
                    return;
                case 12:
                    nativeUnifiedADDataAdapter.f38167c.onVideoCompleted();
                    return;
                case 13:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        nativeUnifiedADDataAdapter.f38167c.onVideoError(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                        return;
                    }
                    return;
                case 14:
                    nativeUnifiedADDataAdapter.f38167c.onVideoStop();
                    return;
                case 15:
                    nativeUnifiedADDataAdapter.f38167c.onVideoClicked();
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list) {
        this.f38165a.bindAdToView(context, nativeAdContainer, layoutParams, list);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        this.f38165a.bindAdToView(context, nativeAdContainer, layoutParams, list, list2);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindCTAViews(List<View> list) {
        this.f38165a.bindCTAViews(list);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindMediaView(MediaView mediaView, VideoOption videoOption, NativeADMediaListener nativeADMediaListener) {
        this.f38167c = nativeADMediaListener;
        this.f38165a.bindMediaView(mediaView, videoOption, null);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void destroy() {
        this.f38165a.destroy();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData) {
        return this.f38165a.equalsAdData(nativeUnifiedADData);
    }

    public NativeUnifiedADData getAdData() {
        return this.f38165a;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAdPatternType() {
        return this.f38165a.getAdPatternType();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        return this.f38165a.getApkInfoUrl();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public double getAppPrice() {
        return this.f38165a.getAppPrice();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppScore() {
        return this.f38165a.getAppScore();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppStatus() {
        return this.f38165a.getAppStatus();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getCTAText() {
        return this.f38165a.getCTAText();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getDesc() {
        return this.f38165a.getDesc();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public long getDownloadCount() {
        return this.f38165a.getDownloadCount();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getECPM() {
        return this.f38165a.getECPM();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getECPMLevel() {
        return this.f38165a.getECPMLevel();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getIconUrl() {
        return this.f38165a.getIconUrl();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public List<String> getImgList() {
        return this.f38165a.getImgList();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getImgUrl() {
        return this.f38165a.getImgUrl();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureHeight() {
        return this.f38165a.getPictureHeight();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureWidth() {
        return this.f38165a.getPictureWidth();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getProgress() {
        return this.f38165a.getProgress();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getTitle() {
        return this.f38165a.getTitle();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getVastContent() {
        return this.f38165a.getVastContent();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public String getVastTag() {
        return this.f38165a.getVastTag();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoCurrentPosition() {
        return this.f38165a.getVideoCurrentPosition();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoDuration() {
        return this.f38165a.getVideoDuration();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isAppAd() {
        return this.f38165a.isAppAd();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isSkippable() {
        return this.f38165a.isSkippable();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void negativeFeedback() {
        this.f38165a.negativeFeedback();
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.f38168d;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i, str, downloadConfirmCallBack);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void onVideoADExposured(View view) {
        this.f38165a.onVideoADExposured(view);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void pauseAppDownload() {
        this.f38165a.pauseAppDownload();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void pauseVideo() {
        this.f38165a.pauseVideo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void preloadVideo(VideoPreloadListener videoPreloadListener) {
        this.f38165a.preloadVideo(videoPreloadListener);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void reportVastEvent(ADEvent aDEvent) {
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resume() {
        this.f38165a.resume();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeAppDownload() {
        this.f38165a.resumeAppDownload();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeVideo() {
        this.f38165a.resumeVideo();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.f38168d = downloadConfirmListener;
        NativeUnifiedADData nativeUnifiedADData = this.f38165a;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.setDownloadConfirmListener(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setNativeAdEventListener(NativeADEventListener nativeADEventListener) {
        this.f38166b = nativeADEventListener;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setVideoMute(boolean z) {
        this.f38165a.setVideoMute(z);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void startVideo() {
        this.f38165a.startVideo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void stopVideo() {
        this.f38165a.stopVideo();
    }
}
