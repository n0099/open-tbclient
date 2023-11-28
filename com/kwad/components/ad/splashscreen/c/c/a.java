package com.kwad.components.ad.splashscreen.c.c;

import android.os.SystemClock;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.components.ad.splashscreen.f;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.m;
import com.kwad.components.core.webview.tachikoma.a.u;
import com.kwad.sdk.components.p;
/* loaded from: classes10.dex */
public final class a extends c implements com.kwad.sdk.core.h.c {
    public m Fb;
    public FrameLayout lc;
    public aw wy;
    public boolean Fe = false;
    public f EQ = new f() { // from class: com.kwad.components.ad.splashscreen.c.c.a.3
        @Override // com.kwad.components.ad.splashscreen.f
        public final void ku() {
            a.this.lc.postDelayed(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.c.a.3.1
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.lc.setVisibility(8);
                }
            }, 500L);
            if (a.this.wy != null) {
                a.this.wy.si();
                a.this.wy.sj();
            }
        }
    };

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_splash";
    }

    @NonNull
    private m lD() {
        m mVar = new m();
        this.Fb = mVar;
        return mVar;
    }

    private void lE() {
        com.kwad.components.ad.splashscreen.e.a aVar = this.Df.Cp;
        if (aVar != null) {
            aVar.lH();
        }
    }

    @NonNull
    private u lF() {
        u uVar = new u();
        uVar.a(new u.a() { // from class: com.kwad.components.ad.splashscreen.c.c.a.2
            @Override // com.kwad.components.core.webview.tachikoma.a.u.a
            public final void a(final u.b bVar) {
                int i = bVar.status;
                if (i == 1) {
                    a.this.Df.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.c.a.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (com.kwad.components.core.e.c.b.nj()) {
                                a.this.Df.mRootContainer.postDelayed(this, 1000L);
                            } else {
                                a.this.Df.kF();
                            }
                        }
                    });
                } else if (i == 2) {
                    a.this.Df.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.c.a.2.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.kwad.components.ad.splashscreen.monitor.a.kM().l(a.this.Df.mAdTemplate);
                            a.this.Df.kH();
                        }
                    });
                } else if (i == 3) {
                    a.this.Df.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.c.a.2.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.Df.kB();
                        }
                    });
                } else if (i == 4) {
                    a.this.Df.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.c.a.2.4
                        @Override // java.lang.Runnable
                        public final void run() {
                            h hVar = a.this.Df;
                            u.b bVar2 = bVar;
                            hVar.i(bVar2.errorCode, bVar2.errorMsg);
                        }
                    });
                }
            }
        });
        return uVar;
    }

    @Override // com.kwad.sdk.core.h.c
    public final void aM() {
        if (this.Df.Cy) {
            return;
        }
        aw awVar = this.wy;
        if (awVar != null) {
            awVar.sk();
        } else {
            this.Fe = true;
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
        this.Df.a(this.EQ);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void bF() {
        aw awVar;
        if (this.Df.Cy) {
            return;
        }
        aw awVar2 = this.wy;
        if (awVar2 != null) {
            awVar2.sg();
            this.wy.sh();
        }
        if (this.Fe && (awVar = this.wy) != null) {
            awVar.sk();
        }
        this.lc.setVisibility(0);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.lc;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.cd(this.Df.mAdTemplate).splashPlayCardTKInfo.templateId;
    }

    @Override // com.kwad.components.ad.splashscreen.c.c.c
    public final int lC() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        h hVar = this.Df;
        return (int) (com.kwad.sdk.core.response.b.b.dd(hVar.mAdTemplate) - (elapsedRealtime - hVar.Cz));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.lc = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f09235c);
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
    }

    @NonNull
    private x a(com.kwad.sdk.core.webview.b bVar) {
        return new x(bVar, this.Df.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.c.c.a.1
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    a.this.Df.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.c.c.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.Df.kz();
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
        lE();
    }

    @Override // com.kwad.components.ad.splashscreen.c.c.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(pVar, bVar);
        pVar.c(a(bVar));
        pVar.c(lD());
        pVar.c(lF());
    }
}
