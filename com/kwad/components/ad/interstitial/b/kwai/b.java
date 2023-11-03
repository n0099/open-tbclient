package com.kwad.components.ad.interstitial.b.kwai;

import android.app.Dialog;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.ad.f.kwai.kwai.b;
import com.kwad.components.ad.interstitial.b.c;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.b.a.h;
import com.kwad.components.core.webview.b.a.r;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.f;
import com.kwad.components.core.webview.jshandler.k;
import com.kwad.components.core.webview.jshandler.q;
import com.kwad.components.core.webview.jshandler.w;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.g.d;
import com.kwad.sdk.core.h.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bd;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b extends a {
    public static long gO = 400;
    public aa dP;
    public d eN;
    public Vibrator eO;
    @Nullable
    public com.kwad.components.ad.f.kwai.kwai.b gY;
    public FrameLayout hP;
    public boolean hR;
    public boolean hQ = false;
    public com.kwad.sdk.core.h.b bX = new c() { // from class: com.kwad.components.ad.interstitial.b.kwai.b.1
        @Override // com.kwad.sdk.core.h.c, com.kwad.sdk.core.h.b
        public final void aR() {
            if (b.this.dP != null && !b.this.hQ) {
                b.a(b.this, true);
                b.this.dP.py();
                b.this.dP.pz();
            }
            if (b.this.dP != null) {
                b.this.dP.pC();
            }
            if (b.this.gY != null) {
                b.this.gY.eB();
            }
            if (b.this.hR || b.this.gh.gn || b.this.gh.fo == null) {
                return;
            }
            b.this.gh.fo.onAdShow();
            com.kwad.components.ad.interstitial.monitor.b.cr().a(b.this.gh.mAdTemplate, 3);
            b.b(b.this, true);
        }

        @Override // com.kwad.sdk.core.h.c, com.kwad.sdk.core.h.b
        public final void aS() {
            if (b.this.dP != null) {
                b.this.dP.pD();
            }
            if (b.this.gY != null) {
                b.this.gY.eA();
            }
        }
    };

    @NonNull
    private f a(com.kwad.sdk.core.webview.b bVar) {
        return new f(bVar, this.gh.mApkDownloadHelper, new com.kwad.sdk.core.webview.a.kwai.a() { // from class: com.kwad.components.ad.interstitial.b.kwai.b.7
            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                if (aVar != null) {
                    if (!b.this.gh.gn && b.this.gh.fo != null) {
                        b.this.gh.fo.onAdClicked();
                    }
                    b.this.gh.gl = true;
                    if (!b.this.gh.gn) {
                        b.this.gh.cy();
                    }
                    if (b.this.gh.gi == null || !com.kwad.components.ad.interstitial.kwai.b.co()) {
                        return;
                    }
                    b.this.gh.gi.dismiss();
                }
            }
        });
    }

    public static /* synthetic */ boolean a(b bVar, boolean z) {
        bVar.hQ = true;
        return true;
    }

    public static void b(AdTemplate adTemplate, boolean z) {
        com.kwad.sdk.core.report.a.a(adTemplate, 14, -1L, -1, null);
    }

    public static /* synthetic */ boolean b(b bVar, boolean z) {
        bVar.hR = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(double d) {
        this.gh.a(new c.b(getContext()).m(true).b(d).y(2).a(this.gh.gq.getTouchCoords()).z(Cea708Decoder.COMMAND_DF5));
        if (this.eO == null || aj.Y(getContext(), "android.permission.VIBRATE") != 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.eO.vibrate(VibrationEffect.createOneShot(gO, -1));
        } else {
            this.eO.vibrate(gO);
        }
    }

    private com.kwad.components.core.webview.b.kwai.d cM() {
        h hVar = new h();
        hVar.NQ = this.gh.gx;
        return new com.kwad.components.core.webview.b.kwai.d(hVar);
    }

    private com.kwad.components.ad.f.kwai.kwai.a cP() {
        final com.kwad.components.ad.f.kwai.kwai.a aVar = new com.kwad.components.ad.f.kwai.kwai.a();
        this.gh.gs.add(new c.InterfaceC0589c() { // from class: com.kwad.components.ad.interstitial.b.kwai.b.6
            @Override // com.kwad.components.ad.interstitial.b.c.InterfaceC0589c
            public final void cH() {
                aVar.ey();
            }
        });
        return aVar;
    }

    private ah cV() {
        ah ahVar = new ah(getContext(), this.gh.mAdTemplate);
        ahVar.a(new ah.a() { // from class: com.kwad.components.ad.interstitial.b.kwai.b.8
            @Override // com.kwad.components.core.webview.jshandler.ah.a
            public final boolean dc() {
                com.kwad.components.core.page.a.launch(b.this.getContext(), b.this.gh.mAdTemplate);
                b.this.gh.a(true, -1, (com.kwad.sdk.core.video.videoview.a) null);
                bd.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.interstitial.b.kwai.b.8.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.cY();
                    }
                }, 0L);
                return false;
            }
        });
        return ahVar;
    }

    @NonNull
    private q cW() {
        return new q(new q.b() { // from class: com.kwad.components.ad.interstitial.b.kwai.b.10
            @Override // com.kwad.components.core.webview.jshandler.q.b
            public final void a(final q.a aVar) {
                if (b.this.gh.gi != null) {
                    b.this.gh.gq.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.b.kwai.b.10.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (aVar.type == 0 && !b.this.gh.gl && !b.this.gh.gm && com.kwad.components.ad.interstitial.c.a.c(b.this.gh)) {
                                b.this.gh.gm = true;
                                com.kwad.components.ad.interstitial.a.b.J(b.this.getContext());
                                return;
                            }
                            b.this.dJ();
                            b.this.gh.gi.dismiss();
                            b.this.gh.a(aVar.type == 3, aVar.Mh, (com.kwad.sdk.core.video.videoview.a) null);
                            if (b.this.gh.fo != null) {
                                b.this.gh.fo.onAdClosed();
                            }
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cY() {
        com.kwad.components.ad.interstitial.b.c cVar = this.gh;
        if (cVar == null) {
            return;
        }
        Dialog dialog = cVar.gi;
        if (dialog != null) {
            dialog.dismiss();
        }
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.gh.fo;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClosed();
        }
    }

    @NonNull
    private com.kwad.components.core.webview.b.kwai.h dG() {
        return new com.kwad.components.core.webview.b.kwai.h() { // from class: com.kwad.components.ad.interstitial.b.kwai.b.9
            @Override // com.kwad.components.core.webview.b.kwai.e, com.kwad.sdk.core.webview.kwai.a
            public final void a(String str, @NonNull final com.kwad.sdk.core.webview.kwai.c cVar) {
                super.a(str, cVar);
                bd.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.interstitial.b.kwai.b.9.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.components.core.webview.b.a.d dVar = new com.kwad.components.core.webview.b.a.d();
                        dVar.NM = ae.isWifiConnected(b.this.getContext()) || b.this.gh.cN.isDataFlowAutoStart() || b.h(b.this.gh.mAdTemplate);
                        cVar.a(dVar);
                    }
                }, 0L);
            }
        };
    }

    private com.kwad.components.core.webview.jshandler.d dH() {
        return new com.kwad.components.core.webview.jshandler.d() { // from class: com.kwad.components.ad.interstitial.b.kwai.b.11
            @Override // com.kwad.components.core.webview.jshandler.d, com.kwad.sdk.core.webview.kwai.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
                super.a(str, cVar);
                final r rVar = new r();
                try {
                    rVar.parseJson(new JSONObject(str));
                } catch (JSONException e) {
                    com.kwad.sdk.core.e.b.printStackTrace(e);
                }
                bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.b.kwai.b.11.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (TextUtils.equals("start", rVar.NY)) {
                            if (b.this.gh.gn || b.this.gh.fo == null) {
                                return;
                            }
                            b.this.gh.fo.onVideoPlayStart();
                        } else if (!TextUtils.equals("end", rVar.NY) || b.this.gh.gn || b.this.gh.fo == null) {
                        } else {
                            b.this.gh.fo.onVideoPlayEnd();
                        }
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJ() {
        aa aaVar = this.dP;
        if (aaVar != null) {
            aaVar.pA();
            this.dP.pB();
        }
        com.kwad.components.ad.f.kwai.kwai.b bVar = this.gY;
        if (bVar != null) {
            bVar.eA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void db() {
        if (getContext() != null) {
            this.eO = (Vibrator) getContext().getSystemService("vibrator");
        }
        float bm = com.kwad.sdk.core.response.a.b.bm(this.gh.mAdTemplate);
        if (this.eN == null) {
            d dVar = new d(bm);
            this.eN = dVar;
            dVar.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.interstitial.b.kwai.b.2
                @Override // com.kwad.sdk.core.g.b
                public final void a(double d) {
                    if (com.kwad.sdk.b.kwai.a.g(b.this.ca(), 100)) {
                        b.this.c(d);
                    }
                    bd.a(new Runnable() { // from class: com.kwad.components.ad.interstitial.b.kwai.b.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.this.eN.vb();
                        }
                    }, null, 500L);
                }

                @Override // com.kwad.sdk.core.g.b
                public final void bX() {
                }
            });
        }
        this.eN.d(bm);
        this.eN.bz(getContext());
    }

    private w.a getOpenNewPageListener() {
        return new w.a() { // from class: com.kwad.components.ad.interstitial.b.kwai.b.3
            @Override // com.kwad.components.core.webview.jshandler.w.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(b.this.getContext(), new AdWebViewActivityProxy.a.C0632a().ao(bVar.title).ap(bVar.url).N(b.this.gh.mAdTemplate).nx());
            }
        };
    }

    public static boolean h(@NonNull AdTemplate adTemplate) {
        File ad = com.kwad.sdk.core.diskcache.a.a.sS().ad(com.kwad.sdk.core.response.a.a.A(com.kwad.sdk.core.response.a.d.bQ(adTemplate)));
        return ad != null && ad.exists();
    }

    @Override // com.kwad.components.ad.interstitial.b.kwai.a, com.kwad.components.core.webview.b.e
    public final void a(aa aaVar) {
        super.a(aaVar);
        this.dP = aaVar;
    }

    @Override // com.kwad.components.ad.interstitial.b.kwai.a, com.kwad.components.core.webview.b.e
    public final void a(com.kwad.sdk.components.h hVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(hVar, bVar);
        com.kwad.components.ad.f.kwai.kwai.b j = com.kwad.components.ad.f.kwai.kwai.b.j(this.gh.mAdTemplate);
        this.gY = j;
        if (j != null) {
            j.a(new b.InterfaceC0580b() { // from class: com.kwad.components.ad.interstitial.b.kwai.b.4
                @Override // com.kwad.components.ad.f.kwai.kwai.b.InterfaceC0580b
                public final void C(int i) {
                    if (i == com.kwad.components.ad.f.kwai.kwai.b.kt) {
                        b.this.gh.b(b.this.getContext(), b.this.gh.mAdTemplate);
                        b.b(b.this.gh.mAdTemplate, true);
                    }
                    b.this.cY();
                }
            });
            hVar.c(this.gY);
            this.gY.ez();
        }
        hVar.c(cW());
        hVar.c(new w(getOpenNewPageListener()));
        if (com.kwad.sdk.core.response.a.b.bZ(com.kwad.sdk.core.response.a.d.bQ(this.gh.mAdTemplate))) {
            hVar.c(new ab(new ab.a() { // from class: com.kwad.components.ad.interstitial.b.kwai.b.5
                @Override // com.kwad.components.core.webview.jshandler.ab.a
                public final void dd() {
                    b.this.db();
                }
            }));
        }
        hVar.c(dG());
        hVar.c(cV());
        hVar.c(cM());
        hVar.c(a(bVar));
        hVar.c(dH());
        hVar.c(cP());
    }

    @Override // com.kwad.components.ad.interstitial.b.kwai.a, com.kwad.components.ad.interstitial.b.b, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void b(k.a aVar) {
        float aI = com.kwad.sdk.b.kwai.a.aI(getContext());
        aVar.width = (int) ((az.getScreenWidth(getContext()) / aI) + 0.5f);
        aVar.height = (int) ((az.getScreenHeight(getContext()) / aI) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.b.e
    public final String bZ() {
        return "ksad-interstitial-card";
    }

    @Override // com.kwad.components.core.webview.b.e
    public final FrameLayout ca() {
        return this.hP;
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void cb() {
        this.hP.setVisibility(8);
        com.kwad.components.core.webview.b.d.b bVar = this.gh.gp;
        if (bVar != null) {
            bVar.u(bZ());
        }
    }

    @Override // com.kwad.components.ad.interstitial.b.kwai.a, com.kwad.components.core.webview.b.e
    public final void dE() {
        cY();
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void dF() {
        if (this.dP != null && this.gh.gt.dK()) {
            this.hQ = true;
            this.dP.py();
            this.dP.pz();
        }
        this.gh.gt.a(this.bX);
    }

    @Override // com.kwad.components.core.webview.b.e
    public final void dI() {
    }

    @Override // com.kwad.components.ad.interstitial.b.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f091476);
        this.hP = frameLayout;
        frameLayout.setVisibility(0);
    }

    @Override // com.kwad.components.ad.interstitial.b.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.hQ = false;
        this.hR = false;
        if (this.eO != null && aj.Y(getContext(), "android.permission.VIBRATE") == 0) {
            this.eO.cancel();
        }
        d dVar = this.eN;
        if (dVar != null) {
            dVar.bA(getContext());
        }
        com.kwad.components.ad.interstitial.c.b bVar = this.gh.gt;
        if (bVar != null) {
            bVar.b(this.bX);
        }
    }
}
