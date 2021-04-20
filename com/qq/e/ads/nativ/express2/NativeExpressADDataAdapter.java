package com.qq.e.ads.nativ.express2;

import android.app.Activity;
import android.view.View;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
/* loaded from: classes6.dex */
public class NativeExpressADDataAdapter implements NativeExpressADData2, DownloadConfirmListener {

    /* renamed from: a  reason: collision with root package name */
    public NativeExpressADData2 f38466a;

    /* renamed from: b  reason: collision with root package name */
    public MediaEventListener f38467b;

    /* renamed from: c  reason: collision with root package name */
    public AdEventListener f38468c;

    /* renamed from: d  reason: collision with root package name */
    public DownloadConfirmListener f38469d;

    public NativeExpressADDataAdapter(NativeExpressADData2 nativeExpressADData2) {
        this.f38466a = nativeExpressADData2;
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
        if (nativeExpressADDataAdapter.f38468c != null) {
            switch (aDEvent.getType()) {
                case 101:
                    nativeExpressADDataAdapter.f38468c.onClick();
                    return;
                case 102:
                    nativeExpressADDataAdapter.f38468c.onExposed();
                    return;
                case 103:
                    nativeExpressADDataAdapter.f38468c.onRenderSuccess();
                    return;
                case 104:
                    nativeExpressADDataAdapter.f38468c.onRenderFail();
                    return;
                case 105:
                    nativeExpressADDataAdapter.f38468c.onAdClosed();
                    return;
                default:
                    return;
            }
        }
    }

    public static /* synthetic */ void b(NativeExpressADDataAdapter nativeExpressADDataAdapter, ADEvent aDEvent) {
        if (nativeExpressADDataAdapter.f38467b != null) {
            switch (aDEvent.getType()) {
                case 201:
                    nativeExpressADDataAdapter.f38467b.onVideoCache();
                    return;
                case 202:
                    nativeExpressADDataAdapter.f38467b.onVideoStart();
                    return;
                case 203:
                    nativeExpressADDataAdapter.f38467b.onVideoResume();
                    return;
                case 204:
                case 205:
                    nativeExpressADDataAdapter.f38467b.onVideoPause();
                    return;
                case 206:
                    nativeExpressADDataAdapter.f38467b.onVideoComplete();
                    return;
                case 207:
                    nativeExpressADDataAdapter.f38467b.onVideoError();
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void destroy() {
        this.f38466a.destroy();
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public View getAdView() {
        return this.f38466a.getAdView();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public String getApkInfoUrl() {
        NativeExpressADData2 nativeExpressADData2 = this.f38466a;
        if (nativeExpressADData2 != null) {
            return nativeExpressADData2.getApkInfoUrl();
        }
        return null;
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public String getECPMLevel() {
        return this.f38466a.getECPMLevel();
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public int getVideoDuration() {
        return this.f38466a.getVideoDuration();
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public boolean isVideoAd() {
        return this.f38466a.isVideoAd();
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(Activity activity, int i, String str, DownloadConfirmCallBack downloadConfirmCallBack) {
        DownloadConfirmListener downloadConfirmListener = this.f38469d;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i, str, downloadConfirmCallBack);
        }
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void render() {
        this.f38466a.render();
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void setAdEventListener(AdEventListener adEventListener) {
        this.f38468c = adEventListener;
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(DownloadConfirmListener downloadConfirmListener) {
        this.f38469d = downloadConfirmListener;
        NativeExpressADData2 nativeExpressADData2 = this.f38466a;
        if (nativeExpressADData2 != null) {
            nativeExpressADData2.setDownloadConfirmListener(this);
        }
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void setMediaListener(MediaEventListener mediaEventListener) {
        this.f38467b = mediaEventListener;
    }
}
