package com.qq.e.ads.nativ.express2;

import android.view.View;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;
/* loaded from: classes3.dex */
public class NativeExpressADDataAdapter implements NativeExpressADData2 {

    /* renamed from: a  reason: collision with root package name */
    private NativeExpressADData2 f11793a;

    /* renamed from: b  reason: collision with root package name */
    private MediaEventListener f11794b;
    private AdEventListener c;

    public NativeExpressADDataAdapter(NativeExpressADData2 nativeExpressADData2) {
        this.f11793a = nativeExpressADData2;
        if (this.f11793a instanceof ADEventListener) {
            ((ADEventListener) this.f11793a).setAdListener(new ADListener() { // from class: com.qq.e.ads.nativ.express2.NativeExpressADDataAdapter.1
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

    static /* synthetic */ void a(NativeExpressADDataAdapter nativeExpressADDataAdapter, ADEvent aDEvent) {
        if (nativeExpressADDataAdapter.c != null) {
            switch (aDEvent.getType()) {
                case 101:
                    nativeExpressADDataAdapter.c.onClick();
                    return;
                case 102:
                    nativeExpressADDataAdapter.c.onExposed();
                    return;
                case 103:
                    nativeExpressADDataAdapter.c.onRenderSuccess();
                    return;
                case 104:
                    nativeExpressADDataAdapter.c.onRenderFail();
                    return;
                case 105:
                    nativeExpressADDataAdapter.c.onAdClosed();
                    return;
                default:
                    return;
            }
        }
    }

    static /* synthetic */ void b(NativeExpressADDataAdapter nativeExpressADDataAdapter, ADEvent aDEvent) {
        if (nativeExpressADDataAdapter.f11794b != null) {
            switch (aDEvent.getType()) {
                case 201:
                    nativeExpressADDataAdapter.f11794b.onVideoCache();
                    return;
                case 202:
                    nativeExpressADDataAdapter.f11794b.onVideoStart();
                    return;
                case 203:
                    nativeExpressADDataAdapter.f11794b.onVideoResume();
                    return;
                case 204:
                case 205:
                    nativeExpressADDataAdapter.f11794b.onVideoPause();
                    return;
                case 206:
                    nativeExpressADDataAdapter.f11794b.onVideoComplete();
                    return;
                case 207:
                    nativeExpressADDataAdapter.f11794b.onVideoError();
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void destroy() {
        this.f11793a.destroy();
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public View getAdView() {
        return this.f11793a.getAdView();
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public String getECPMLevel() {
        return this.f11793a.getECPMLevel();
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public int getVideoDuration() {
        return this.f11793a.getVideoDuration();
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public boolean isVideoAd() {
        return this.f11793a.isVideoAd();
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void render() {
        this.f11793a.render();
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void setAdEventListener(AdEventListener adEventListener) {
        this.c = adEventListener;
    }

    @Override // com.qq.e.ads.nativ.express2.NativeExpressADData2
    public void setMediaListener(MediaEventListener mediaEventListener) {
        this.f11794b = mediaEventListener;
    }
}
