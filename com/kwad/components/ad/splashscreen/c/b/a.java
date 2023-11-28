package com.kwad.components.ad.splashscreen.c.b;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.ad.splashscreen.c.e;
import com.kwad.components.ad.splashscreen.c.j;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.sdk.utils.bn;
/* loaded from: classes10.dex */
public final class a extends e {
    public com.kwad.components.core.n.a.d.b EU;
    public long EV;
    public volatile boolean EW = false;
    public com.kwad.components.core.webview.tachikoma.e.e jR = new com.kwad.components.core.webview.tachikoma.e.e() { // from class: com.kwad.components.ad.splashscreen.c.b.a.1
        @Override // com.kwad.components.core.webview.tachikoma.e.b
        public final void q(String str) {
            a.this.Df.Cy = true;
            if (!"tk_splash".equals(str)) {
                return;
            }
            a.this.aq();
        }

        @Override // com.kwad.components.core.webview.tachikoma.e.e
        public final void a(String str, long j, long j2, long j3) {
            if (!TextUtils.isEmpty(str) && str.equals(com.kwad.sdk.core.response.b.b.dq(a.this.Df.mAdTemplate))) {
                com.kwad.components.ad.splashscreen.monitor.b.kO();
                com.kwad.components.ad.splashscreen.monitor.b.a(a.this.Df.mAdTemplate, a.this.Df.Cq, a.this.Df.CA, a.this.Df.CC, a.this.Df.CB, a.this.Df.CD, j, j2, j3, SystemClock.elapsedRealtime() - a.this.EV);
                a.this.Df.CE = j;
                a.this.Df.CF = j2;
                a.this.Df.CG = j3;
                bn.c(a.this.EX);
            }
        }
    };
    public final Runnable EX = new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.b.a.2
        @Override // java.lang.Runnable
        public final void run() {
            if (!a.this.EW) {
                a.this.lz();
                return;
            }
            a.this.Df.Cy = true;
            a.this.aq();
            com.kwad.components.ad.splashscreen.monitor.b.kO();
            com.kwad.components.ad.splashscreen.monitor.b.c(a.this.Df.mAdTemplate, a.this.Df.Cq);
        }
    };
    public com.kwad.components.core.n.a.d.a EY = new com.kwad.components.core.n.a.d.a() { // from class: com.kwad.components.ad.splashscreen.c.b.a.3
        @Override // com.kwad.components.core.n.a.d.a
        public final void a(int i, int i2, long j, long j2) {
            a.this.Df.CA = i;
            a.this.Df.CB = i2;
            a.this.Df.CC = j;
            a.this.Df.CD = j2;
            com.kwad.components.ad.splashscreen.monitor.b.kO();
            com.kwad.components.ad.splashscreen.monitor.b.e(a.this.Df.mAdTemplate, SystemClock.elapsedRealtime() - a.this.EV);
            a.this.lz();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void aq() {
        h hVar = this.Df;
        if (hVar.Cx) {
            return;
        }
        hVar.Cx = true;
        hVar.Cw = true;
        bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.b.a.5
            @Override // java.lang.Runnable
            public final void run() {
                a.this.a(new j(), true);
            }
        });
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
        bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.b.a.4
            @Override // java.lang.Runnable
            public final void run() {
                a.this.a(new com.kwad.components.ad.splashscreen.c.c.a(), true);
            }
        });
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
        bn.c(this.EX);
        com.kwad.components.core.webview.tachikoma.d.b.sS().b(this.jR);
    }

    @Override // com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        this.EV = SystemClock.elapsedRealtime();
        com.kwad.components.ad.splashscreen.monitor.b.kO();
        h hVar = this.Df;
        com.kwad.components.ad.splashscreen.monitor.b.a(hVar.mAdTemplate, hVar.Cq);
        h hVar2 = this.Df;
        hVar2.Cz = this.EV;
        bn.runOnUiThreadDelay(this.EX, com.kwad.sdk.core.response.b.b.dd(hVar2.mAdTemplate));
        com.kwad.components.core.webview.tachikoma.d.b.sS().a(this.jR);
        ly();
    }
}
