package com.kwad.components.ad.splashscreen.c.b;

import android.os.SystemClock;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.components.ad.splashscreen.f;
import com.kwad.components.ad.splashscreen.g;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.m;
import com.kwad.sdk.components.p;
import com.kwad.sdk.core.response.b.e;
/* loaded from: classes10.dex */
public final class c extends com.kwad.components.ad.splashscreen.c.c.c implements g, com.kwad.sdk.core.h.c {
    public f EQ = new f() { // from class: com.kwad.components.ad.splashscreen.c.b.c.2
        @Override // com.kwad.components.ad.splashscreen.f
        public final void ku() {
            c.this.lc.setVisibility(8);
            if (c.this.wy != null) {
                c.this.wy.si();
                c.this.wy.sj();
            }
        }
    };
    public m Fb;
    public FrameLayout lc;
    public aw wy;

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_splash";
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void ky() {
    }

    @NonNull
    private m lD() {
        m mVar = new m();
        this.Fb = mVar;
        return mVar;
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        aw awVar;
        if (!this.Df.Cy && (awVar = this.wy) != null) {
            awVar.sk();
        }
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aN() {
        aw awVar;
        if (!this.Df.Cy && (awVar = this.wy) != null) {
            awVar.sl();
        }
    }

    @Override // com.kwad.components.ad.splashscreen.c.c.c, com.kwad.components.ad.splashscreen.c.e, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        com.kwad.components.ad.splashscreen.monitor.b.kO();
        h hVar = this.Df;
        com.kwad.components.ad.splashscreen.monitor.b.b(hVar.mAdTemplate, hVar.Cq);
        this.Df.Cr.a(this);
        this.Df.a(this);
        this.Df.a(this.EQ);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bF() {
        if (this.Df.Cy) {
            return;
        }
        aw awVar = this.wy;
        if (awVar != null) {
            awVar.sg();
            this.wy.sh();
        }
        this.lc.setVisibility(0);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.lc;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dq(this.Df.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.c.c.c
    public final int lC() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        h hVar = this.Df;
        return (int) (com.kwad.sdk.core.response.b.b.di(e.dP(hVar.mAdTemplate)) - (elapsedRealtime - hVar.Cz));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.lc = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f092362);
    }

    @Override // com.kwad.components.ad.splashscreen.c.c.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        aw awVar = this.wy;
        if (awVar != null) {
            awVar.si();
            this.wy.sj();
        }
        super.onUnbind();
        this.Df.Cr.b(this);
        this.Df.b(this.EQ);
        this.Df.b(this);
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void W(int i) {
        m mVar = this.Fb;
        if (mVar != null) {
            mVar.aO(i);
        }
    }

    @NonNull
    private x a(com.kwad.sdk.core.webview.b bVar) {
        return new x(bVar, this.Df.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.c.b.c.1
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    c.this.Df.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.b.c.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            c.this.Df.kz();
                        }
                    });
                }
            }
        });
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void b(ac.a aVar) {
        aVar.width = com.kwad.sdk.d.a.a.b(getContext(), this.Df.mRootContainer.getWidth());
        aVar.height = com.kwad.sdk.d.a.a.b(getContext(), this.Df.mRootContainer.getHeight());
    }

    @Override // com.kwad.components.ad.splashscreen.c.c.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(aw awVar) {
        super.a(awVar);
        this.wy = awVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        aw awVar = this.wy;
        if (awVar != null) {
            awVar.si();
            this.wy.sj();
        }
        this.lc.setVisibility(8);
    }

    @Override // com.kwad.components.ad.splashscreen.c.c.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(pVar, bVar);
        pVar.c(a(bVar));
        pVar.c(lD());
    }
}
