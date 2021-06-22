package com.qq.e.ads.nativ.express2;

import android.app.Activity;
import android.view.View;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
/* loaded from: classes7.dex */
public class NativeExpressADDataAdapter implements NativeExpressADData2, DownloadConfirmListener {

    /* renamed from: a  reason: collision with root package name */
    public NativeExpressADData2 f39083a;

    /* renamed from: b  reason: collision with root package name */
    public MediaEventListener f39084b;

    /* renamed from: c  reason: collision with root package name */
    public AdEventListener f39085c;

    /* renamed from: d  reason: collision with root package name */
    public DownloadConfirmListener f39086d;

    public NativeExpressADDataAdapter(NativeExpressADData2 nativeExpressADData2) {
        this.f39083a = nativeExpressADData2;
        if (nativeExpressADData2 instanceof ADEventListener) {
            ((ADEventListener) nativeExpressADData2).setAdListener(new ADListener() { // from class: com.qq.e.ads.nativ.express2.NativeExpressADDataAdapter.1
                @Override // com.qq.e.comm.adevent.ADListener
                public void onADEvent(ADEvent aDEvent) {
                    if (aDEvent.getType() < 201) {
                        NativeExpressADDataAdapter.a(NativeExpressADDataAdapter.this, aDEvent);
                    } else {
                        NativeExpressADDataAdapter.b(NativeExpressADDataAdapter.this, aDEvent);
                    }
                }
            });
        }
    }

    public static /* synthetic */ void a(NativeExpressADDataAdapter nativeExpressADDataAdapter, ADEvent aDEvent) {
        if (nativeExpressADDataAdapter.f39085c != null) {
            switch (aDEvent.getType()) {
                case 101:
                    nativeExpressADDataAdapter.f39085c.onClick();
                    return;
                case 102:
                    nativeExpressADDataAdapter.f39085c.onExposed();
                    return;
                case 103:
                    nativeExpressADDataAdapter.f39085c.onRenderSuccess();
                    return;
                case 104:
                    nativeExpressADDataAdapter.f39085c.onRenderFail();
                    return;
                case 105:
                    nativeExpressADDataAdapter.f39085c.onAdClosed();
                    return;
                default:
                    return;
            }
        }
    }

    public static /* synthetic */ void b(NativeExpressADDataAdapter nativeExpressADDataAdapter, ADEvent aDEvent) {
        if (nativeExpressADDataAdapter.f39084b != null) {
            switch (aDEvent.getType()) {
                case 201:
                    nativeExpressADDataAdapter.f39084b.onVideoCache();
                    return;
                case 202:
                    nativeExpressADDataAdapter.f39084b.onVideoStart();
                    return;
                case 203:
                    nativeExpressADDataAdapter.f39084b.onVideoResume();
                    return;
                case 204:
                case 205:
                    nativeExpressADDataAdapter.f39084b.onVideoPause();
                    return;
                case 206:
                    nativeExpressADDataAdapter.f39084b.onVideoComplete();
                    return;
                case 207:
                    nativeExpressADDataAdapter.f39084b.onVideoError();
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void destroy() {
        this.f39083a.destroy();
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public View getAdView() {
        return this.f39083a.getAdView();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        NativeExpressADData2 nativeExpressADData2 = this.f39083a;
        if (nativeExpressADData2 != null) {
            return nativeExpressADData2.getApkInfoUrl();
        }
        return null;
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public String getECPMLevel() {
        return this.f39083a.getECPMLevel();
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public int getVideoDuration() {
        return this.f39083a.getVideoDuration();
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public boolean isVideoAd() {
        return this.f39083a.isVideoAd();
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i2, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.f39086d;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i2, str, downloadConfirmCallBack);
        }
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void render() {
        this.f39083a.render();
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void setAdEventListener(AdEventListener adEventListener) {
        this.f39085c = adEventListener;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.f39086d = downloadConfirmListener;
        NativeExpressADData2 nativeExpressADData2 = this.f39083a;
        if (nativeExpressADData2 != null) {
            nativeExpressADData2.setDownloadConfirmListener(this);
        }
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void setMediaListener(MediaEventListener mediaEventListener) {
        this.f39084b = mediaEventListener;
    }
}
