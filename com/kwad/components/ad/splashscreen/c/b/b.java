package com.kwad.components.ad.splashscreen.c.b;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.splashscreen.c.e;
import com.kwad.components.ad.splashscreen.c.p;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.utils.bn;
/* loaded from: classes10.dex */
public final class b extends e {
    public com.kwad.components.core.n.a.d.b EU;
    public long EV;
    public volatile boolean EW = false;
    public com.kwad.components.core.webview.tachikoma.e.e jR = new com.kwad.components.core.webview.tachikoma.e.e() { // from class: com.kwad.components.ad.splashscreen.c.b.b.1
        @Override // com.kwad.components.core.webview.tachikoma.e.b
        public final void q(String str) {
            b.this.Df.Cy = true;
            if (!"tk_splash".equals(str)) {
                return;
            }
            b.this.lA();
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.e
        public final void a(String str, long j, long j2, long j3) {
            if (!TextUtils.isEmpty(str) && str.equals(com.kwad.sdk.core.response.b.b.dq(b.this.Df.mAdTemplate))) {
                com.kwad.components.ad.splashscreen.monitor.b.kO();
                com.kwad.components.ad.splashscreen.monitor.b.a(b.this.Df.mAdTemplate, b.this.Df.Cq, b.this.Df.CA, b.this.Df.CC, b.this.Df.CB, b.this.Df.CD, j, j2, j3, SystemClock.elapsedRealtime() - b.this.EV);
                b.this.Df.CE = j;
                b.this.Df.CF = j2;
                b.this.Df.CG = j3;
                bn.c(b.this.EX);
            }
        }
    };
    public final Runnable EX = new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.b.b.2
        @Override // java.lang.Runnable
        public final void run() {
            if (!b.this.EW) {
                b.this.lz();
                return;
            }
            b.this.Df.Cy = true;
            b.this.lA();
            com.kwad.components.ad.splashscreen.monitor.b.kO();
            com.kwad.components.ad.splashscreen.monitor.b.c(b.this.Df.mAdTemplate, b.this.Df.Cq);
        }
    };
    public com.kwad.components.core.n.a.d.a EY = new com.kwad.components.core.n.a.d.a() { // from class: com.kwad.components.ad.splashscreen.c.b.b.3
        @Override // com.kwad.components.core.n.a.d.a
        public final void a(int i, int i2, long j, long j2) {
            b.this.Df.CA = i;
            b.this.Df.CB = i2;
            b.this.Df.CC = j;
            b.this.Df.CD = j2;
            com.kwad.components.ad.splashscreen.monitor.b.kO();
            com.kwad.components.ad.splashscreen.monitor.b.e(b.this.Df.mAdTemplate, SystemClock.elapsedRealtime() - b.this.EV);
            b.this.lz();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void lA() {
        if (com.kwad.sdk.core.response.b.b.dy(com.kwad.sdk.core.response.b.e.dP(this.Df.mAdTemplate))) {
            h hVar = this.Df;
            if (hVar.Cw) {
                return;
            }
            hVar.Cw = true;
            bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.b.b.5
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.a(new p(), true);
                }
            });
        }
    }

    private boolean lB() {
        if (!d.AM()) {
            return false;
        }
        return com.kwad.sdk.core.response.b.b.de(com.kwad.sdk.core.response.b.e.dP(this.Df.mAdTemplate));
    }

    private void ly() {
        com.kwad.components.core.n.a.d.b bVar = (com.kwad.components.core.n.a.d.b) com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.d.b.class);
        this.EU = bVar;
        if (bVar != null) {
            bVar.a(this.EY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lz() {
        if (this.EW) {
            return;
        }
        this.EW = true;
        if (lB()) {
            bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.b.b.4
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.a(new c(), true);
                }
            });
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.n.a.d.b bVar = this.EU;
        if (bVar != null) {
            bVar.b(this.EY);
        }
        if (lB()) {
            bn.c(this.EX);
            com.kwad.components.core.webview.tachikoma.d.b.sS().b(this.jR);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.EV = SystemClock.elapsedRealtime();
        if (lB()) {
            com.kwad.components.ad.splashscreen.monitor.b.kO();
            h hVar = this.Df;
            com.kwad.components.ad.splashscreen.monitor.b.a(hVar.mAdTemplate, hVar.Cq);
            h hVar2 = this.Df;
            hVar2.Cz = this.EV;
            bn.runOnUiThreadDelay(this.EX, com.kwad.sdk.core.response.b.b.di(com.kwad.sdk.core.response.b.e.dP(hVar2.mAdTemplate)));
            com.kwad.components.core.webview.tachikoma.d.b.sS().a(this.jR);
        }
        if (d.AM()) {
            ly();
        } else {
            lA();
        }
    }
}
