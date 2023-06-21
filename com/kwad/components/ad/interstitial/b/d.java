package com.kwad.components.ad.interstitial.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Outline;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tieba.R;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.kwad.components.ad.f.kwai.kwai.b;
import com.kwad.components.ad.interstitial.b.c;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.video.a;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.b.kwai.j;
import com.kwad.components.core.webview.b.kwai.n;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.k;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.q;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.w;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.kwai.c;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes9.dex */
public final class d extends b {
    public static long gO = 400;
    public static float gP = 0.8f;
    public static float gQ = 1.0f;
    public static float gR = 0.749f;
    public com.kwad.components.core.widget.kwai.b aM;
    @NonNull
    public KsAdVideoPlayConfig cN;
    public KSFrameLayout dN;
    public aa dP;
    public boolean dR;

    /* renamed from: do  reason: not valid java name */
    public ImageView f6do;
    public com.kwad.sdk.core.video.videoview.a dp;
    public com.kwad.sdk.core.g.d eN;
    public Vibrator eO;
    public ab gN;
    public KSFrameLayout gS;
    public KsAdWebView gT;
    public ImageView gU;
    public a.b gV;
    public j gW;
    public c.a gX;
    @Nullable
    public com.kwad.components.ad.f.kwai.kwai.b gY;
    public c gh;
    public Dialog gi;
    public AdInfo mAdInfo;
    public AdTemplate mAdTemplate;
    @Nullable
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    @NonNull
    public Context mContext;
    public com.kwad.sdk.core.webview.b mJsBridgeContext;
    public com.kwad.components.core.webview.a mJsInterface;
    public Handler mHandler = new Handler(Looper.getMainLooper());
    public int bH = -1;
    public boolean gZ = false;
    public com.kwad.sdk.core.h.b bX = new com.kwad.sdk.core.h.c() { // from class: com.kwad.components.ad.interstitial.b.d.1
        @Override // com.kwad.sdk.core.h.c, com.kwad.sdk.core.h.b
        public final void aR() {
            com.kwad.sdk.core.e.b.d("InterstitialWebViewPresenter", "onPageVisible");
            if (d.this.dP != null) {
                d.this.dP.py();
                d.this.dP.pz();
            }
        }

        @Override // com.kwad.sdk.core.h.c, com.kwad.sdk.core.h.b
        public final void aS() {
            com.kwad.sdk.core.e.b.d("InterstitialWebViewPresenter", "onPageInvisible");
            if (d.this.dP != null) {
                d.this.dP.pA();
                d.this.dP.pB();
            }
        }
    };
    public final Runnable ha = new Runnable() { // from class: com.kwad.components.ad.interstitial.b.d.12
        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.e.b.d("InterstitialWebViewPresenter", "rollBackRunnable run");
            d.this.t("4");
        }
    };
    public s.a hb = new s.a() { // from class: com.kwad.components.ad.interstitial.b.d.23
        @Override // com.kwad.components.core.webview.jshandler.s.a
        public final void onAdShow() {
            if (d.this.mAdTemplate.mPvReported || d.this.gh.gn || d.this.gh.fo == null) {
                return;
            }
            d.this.gh.fo.onAdShow();
            com.kwad.components.ad.interstitial.monitor.b.cr().a(d.this.mAdTemplate, 2);
        }
    };
    public x.b bM = new x.b() { // from class: com.kwad.components.ad.interstitial.b.d.17
        @Override // com.kwad.components.core.webview.jshandler.x.b
        public final void a(x.a aVar) {
            if (d.this.dR || d.this.gZ) {
                return;
            }
            d.this.bH = aVar.status;
            if (d.this.bH != 1) {
                d.this.t("3");
                return;
            }
            d.this.gT.setVisibility(0);
            com.kwad.components.core.j.a.og().O(d.this.mAdTemplate);
            d.this.mHandler.removeCallbacksAndMessages(null);
            bd.c(d.this.ha);
            if (d.this.gY != null) {
                d.this.gY.ez();
            }
        }
    };

    public static ViewGroup.LayoutParams A(int i) {
        int i2 = (int) (i * gR);
        return new ViewGroup.LayoutParams((int) (i2 / 0.749f), i2);
    }

    public static float a(boolean z, boolean z2) {
        return (z && z2) ? 1.7777778f : 0.749f;
    }

    public static ViewGroup.LayoutParams a(int i, boolean z) {
        int i2 = (int) (i * (z ? gP : gQ));
        return new ViewGroup.LayoutParams(i2, (int) (i2 * (z ? 1.7777778f : 0.749f)));
    }

    public static ViewGroup.MarginLayoutParams a(WebCardVideoPositionHandler.VideoPosition videoPosition, ViewGroup.MarginLayoutParams marginLayoutParams) {
        marginLayoutParams.topMargin = videoPosition.topMargin;
        marginLayoutParams.leftMargin = videoPosition.leftMargin;
        marginLayoutParams.width = videoPosition.width;
        marginLayoutParams.height = videoPosition.height;
        return marginLayoutParams;
    }

    public static void a(ViewGroup.MarginLayoutParams marginLayoutParams, ViewGroup.MarginLayoutParams marginLayoutParams2) {
        marginLayoutParams2.leftMargin = marginLayoutParams.leftMargin;
        marginLayoutParams2.rightMargin = marginLayoutParams.rightMargin;
        marginLayoutParams2.topMargin = marginLayoutParams.topMargin;
        marginLayoutParams2.bottomMargin = marginLayoutParams.bottomMargin;
        marginLayoutParams2.width = marginLayoutParams.width;
        marginLayoutParams2.height = marginLayoutParams.height;
    }

    private void a(com.kwad.components.core.webview.a aVar, String str) {
        aVar.a(da());
        aVar.a(cZ());
        aVar.a(new com.kwad.components.core.webview.b.kwai.c());
        aVar.a(cS());
        aVar.a(new l(this.mJsBridgeContext));
        aVar.a(cR());
        aVar.a(cQ());
        aVar.a(cW());
        aa aaVar = new aa();
        this.dP = aaVar;
        aVar.a(aaVar);
        this.gh.a(cT());
        aVar.a(cX());
        aVar.a(cU());
        aVar.a(new o(this.mJsBridgeContext));
        aVar.a(cN());
        aVar.a(new x(this.bM, str));
        aVar.a(cL());
        s sVar = new s(this.mJsBridgeContext);
        sVar.a(this.hb);
        aVar.a(sVar);
        aVar.a(cV());
        aVar.a(new w(getOpenNewPageListener()));
        if (com.kwad.sdk.core.response.a.b.bZ(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate))) {
            aVar.a(cK());
        }
        if (cO() != null) {
            aVar.a(this.gY);
        }
        aVar.a(cM());
        aVar.a(cP());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdInfo adInfo, WebCardVideoPositionHandler.VideoPosition videoPosition, KSFrameLayout kSFrameLayout, boolean z) {
        kSFrameLayout.setWidthBasedRatio(!z);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) kSFrameLayout.getLayoutParams();
        com.kwad.sdk.core.e.b.d("InterstitialWebViewPresenter", "updateVideoContainerSize before size: " + marginLayoutParams.width + StringUtil.ARRAY_ELEMENT_SEPARATOR + marginLayoutParams.height);
        a(videoPosition, marginLayoutParams);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = new ViewGroup.MarginLayoutParams(marginLayoutParams);
        float aw = com.kwad.sdk.core.response.a.a.aw(adInfo);
        com.kwad.sdk.core.e.b.d("InterstitialWebViewPresenter", "updateVideoContainerSize materialRatio: " + aw);
        if (!z || aw <= 0.0f) {
            kSFrameLayout.setRatio(0.0f);
        } else {
            int i = marginLayoutParams.width;
            int i2 = marginLayoutParams.height;
            int i3 = (int) (i2 / aw);
            marginLayoutParams.width = i3;
            marginLayoutParams.leftMargin += (i - i3) / 2;
            if (i3 != 0) {
                float f = i2 / i3;
                com.kwad.sdk.core.e.b.d("InterstitialWebViewPresenter", "cardParams ratio: " + f);
                kSFrameLayout.setRatio(f);
            }
        }
        com.kwad.sdk.core.e.b.d("InterstitialWebViewPresenter", "cardParams width: " + marginLayoutParams.width + ", height: " + marginLayoutParams.height);
        kSFrameLayout.setLayoutParams(marginLayoutParams);
        float dimension = getContext().getResources().getDimension(R.dimen.obfuscated_res_0x7f0704bb);
        WebCardVideoPositionHandler.VideoPosition.KSAdJSCornerModel kSAdJSCornerModel = videoPosition.cornerRadius;
        if (kSAdJSCornerModel != null) {
            kSFrameLayout.setRadius((float) kSAdJSCornerModel.topLeft, (float) kSAdJSCornerModel.topRight, (float) kSAdJSCornerModel.bottomRight, (float) kSAdJSCornerModel.bottomLeft);
        } else if (marginLayoutParams.width > marginLayoutParams.height) {
            kSFrameLayout.setRadius(dimension, dimension, 0.0f, 0.0f);
        } else {
            kSFrameLayout.setRadius(dimension, dimension, dimension, dimension);
        }
        if (z) {
            this.gU.setVisibility(0);
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.gU.getLayoutParams();
            a(marginLayoutParams2, marginLayoutParams3);
            this.gU.setLayoutParams(marginLayoutParams3);
            this.gh.a(this.mContext, adInfo, this.mAdTemplate, this.gU);
        } else {
            this.gU.setVisibility(8);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            kSFrameLayout.setOutlineProvider(new ViewOutlineProvider() { // from class: com.kwad.components.ad.interstitial.b.d.16
                @Override // android.view.ViewOutlineProvider
                public final void getOutline(View view2, Outline outline) {
                    outline.setRect(0, 0, view2.getWidth(), view2.getHeight());
                }
            });
            kSFrameLayout.setClipToOutline(true);
        }
    }

    public static boolean a(Dialog dialog) {
        Activity ownerActivity = dialog.getOwnerActivity();
        return (ownerActivity == null || ownerActivity.isFinishing()) ? false : true;
    }

    public static /* synthetic */ boolean a(d dVar, Dialog dialog) {
        return a(dialog);
    }

    public static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.gZ = true;
        return true;
    }

    private void aE() {
        String bo = com.kwad.sdk.core.response.a.b.bo(this.mAdTemplate);
        if (TextUtils.isEmpty(bo)) {
            t("1");
        } else {
            v(bo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(double d) {
        this.gh.a(new c.b(getContext()).m(true).b(d).y(2).a(this.gS.getTouchCoords()).z(Cea708Decoder.COMMAND_DF5));
        bd.a(getContext(), this.eO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJ() {
        final boolean av = com.kwad.sdk.core.response.a.a.av(this.mAdInfo);
        final boolean cB = ag.cB(this.mContext);
        float a = a(cB, av);
        com.kwad.sdk.core.e.b.d("InterstitialWebViewPresenter", "replaceNativeView cardRatio: " + a);
        this.gh.gj.setRatio(a);
        final ViewGroup viewGroup = (ViewGroup) this.gS.findViewById(R.id.obfuscated_res_0x7f0912ab);
        viewGroup.setVisibility(0);
        viewGroup.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.b.d.22
            @Override // java.lang.Runnable
            public final void run() {
                ViewGroup.LayoutParams a2 = cB ? d.a(d.this.gS.getWidth(), av) : d.A(d.this.gS.getHeight());
                d.this.gT.setVisibility(8);
                d.this.dN.setVisibility(8);
                ViewParent parent = d.this.gh.gj.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(d.this.gh.gj);
                }
                viewGroup.addView(d.this.gh.gj);
                d.this.gh.gj.f(a2.width, a2.height);
                d.this.dp.requestLayout();
                d.a(d.this, true);
            }
        });
    }

    @NonNull
    private ab cK() {
        ab abVar = new ab(new ab.a() { // from class: com.kwad.components.ad.interstitial.b.d.24
            @Override // com.kwad.components.core.webview.jshandler.ab.a
            public final void dd() {
                d.this.db();
            }
        });
        this.gN = abVar;
        return abVar;
    }

    private ac cL() {
        return new ac(this.mJsBridgeContext, this.mApkDownloadHelper);
    }

    private com.kwad.components.core.webview.b.kwai.d cM() {
        com.kwad.components.core.webview.b.a.h hVar = new com.kwad.components.core.webview.b.a.h();
        hVar.NQ = this.gh.gx;
        return new com.kwad.components.core.webview.b.kwai.d(hVar);
    }

    private k cN() {
        k kVar = new k(this.mJsBridgeContext);
        kVar.a(new k.b() { // from class: com.kwad.components.ad.interstitial.b.d.25
            @Override // com.kwad.components.core.webview.jshandler.k.b
            public final void a(k.a aVar) {
                aVar.height = com.kwad.sdk.b.kwai.a.getScreenHeight(d.this.mContext);
                aVar.width = com.kwad.sdk.b.kwai.a.getScreenHeight(d.this.mContext);
            }
        });
        return kVar;
    }

    private com.kwad.components.ad.f.kwai.kwai.b cO() {
        com.kwad.components.ad.f.kwai.kwai.b j = com.kwad.components.ad.f.kwai.kwai.b.j(this.mAdTemplate);
        this.gY = j;
        if (j != null) {
            j.a(new b.InterfaceC0586b() { // from class: com.kwad.components.ad.interstitial.b.d.2
                @Override // com.kwad.components.ad.f.kwai.kwai.b.InterfaceC0586b
                public final void C(int i) {
                    if (i == com.kwad.components.ad.f.kwai.kwai.b.kt) {
                        d.this.gh.b(d.this.getContext(), d.this.mAdTemplate);
                        d.this.gh.a(true, -1, d.this.gh.dp);
                    }
                    d.this.cY();
                }
            });
        }
        return this.gY;
    }

    private com.kwad.components.ad.f.kwai.kwai.a cP() {
        final com.kwad.components.ad.f.kwai.kwai.a aVar = new com.kwad.components.ad.f.kwai.kwai.a();
        this.gh.gs.add(new c.InterfaceC0595c() { // from class: com.kwad.components.ad.interstitial.b.d.3
            @Override // com.kwad.components.ad.interstitial.b.c.InterfaceC0595c
            public final void cH() {
                aVar.ey();
            }
        });
        return aVar;
    }

    private n cQ() {
        n nVar = new n();
        nVar.a(new n.a() { // from class: com.kwad.components.ad.interstitial.b.d.4
            @Override // com.kwad.components.core.webview.b.kwai.n.a
            public final void a(com.kwad.components.core.webview.b.a.i iVar) {
                d.this.dp.setVideoSoundEnable(!iVar.NR);
            }
        });
        return nVar;
    }

    @NonNull
    private com.kwad.components.core.webview.b.kwai.i cR() {
        return new com.kwad.components.core.webview.b.kwai.i() { // from class: com.kwad.components.ad.interstitial.b.d.5
            @Override // com.kwad.components.core.webview.b.kwai.e, com.kwad.sdk.core.webview.kwai.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.b.a.i iVar = new com.kwad.components.core.webview.b.a.i();
                iVar.NR = !d.this.cN.isVideoSoundEnable();
                cVar.a(iVar);
            }
        };
    }

    @NonNull
    private r cS() {
        return new r(this.mJsBridgeContext, new r.b() { // from class: com.kwad.components.ad.interstitial.b.d.6
            @Override // com.kwad.components.core.webview.jshandler.r.b
            public final void a(r.a aVar) {
            }
        });
    }

    private a.b cT() {
        final com.kwad.components.core.webview.b.a.s sVar = new com.kwad.components.core.webview.b.a.s();
        a.b bVar = new a.b() { // from class: com.kwad.components.ad.interstitial.b.d.7
            @Override // com.kwad.components.core.video.a.b
            public final void bm() {
                com.kwad.components.core.webview.b.a.s sVar2 = sVar;
                sVar2.NZ = false;
                sVar2.Oa = true;
                sVar.kD = com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.bQ(d.this.mJsBridgeContext.getAdTemplate()));
                d.this.gW.a(sVar);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void d(long j) {
                com.kwad.components.core.webview.b.a.s sVar2 = sVar;
                sVar2.NZ = false;
                sVar2.Oa = false;
                sVar2.kD = (int) Math.ceil(((float) j) / 1000.0f);
                d.this.gW.a(sVar);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayStart() {
                com.kwad.components.core.webview.b.a.s sVar2 = sVar;
                sVar2.NZ = false;
                sVar2.Oa = false;
                sVar2.kD = 0;
                d.this.gW.a(sVar);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlaying() {
                if (d.this.f6do.getVisibility() == 0) {
                    d.this.f6do.setVisibility(8);
                }
                com.kwad.components.core.webview.b.a.s sVar2 = sVar;
                sVar2.NZ = false;
                sVar2.Oa = false;
                sVar2.kD = (int) Math.ceil(((float) d.this.dp.getCurrentPosition()) / 1000.0f);
                d.this.gW.a(sVar);
            }
        };
        this.gV = bVar;
        return bVar;
    }

    @NonNull
    private WebCardVideoPositionHandler cU() {
        return new WebCardVideoPositionHandler(new WebCardVideoPositionHandler.a() { // from class: com.kwad.components.ad.interstitial.b.d.8
            @Override // com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.a
            public final void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                AdInfo adInfo;
                com.kwad.sdk.core.e.b.d("InterstitialWebViewPresenter", "onVideoSetPosition hadRollBackToNative: " + d.this.gZ);
                if (d.this.gZ || (adInfo = d.this.mAdInfo) == null || !com.kwad.sdk.core.response.a.a.aB(adInfo)) {
                    return;
                }
                c unused = d.this.gh;
                d dVar = d.this;
                boolean a = c.a(dVar.mContext, dVar.mAdInfo);
                d dVar2 = d.this;
                dVar2.a(dVar2.mAdInfo, videoPosition, dVar2.dN, a);
                d.this.dN.setVisibility(0);
                d.this.gT.setVisibility(0);
            }
        });
    }

    private ah cV() {
        ah ahVar = new ah(getContext(), this.mAdTemplate);
        ahVar.a(new ah.a() { // from class: com.kwad.components.ad.interstitial.b.d.9
            @Override // com.kwad.components.core.webview.jshandler.ah.a
            public final boolean dc() {
                if (d.this.gW != null) {
                    d.this.gW.aD(false);
                }
                bd.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.b.d.9.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (d.this.gi != null) {
                            d dVar = d.this;
                            if (d.a(dVar, dVar.gi)) {
                                d.this.gi.dismiss();
                                if (d.this.gh.gn || d.this.gh.fo == null) {
                                    return;
                                }
                                d.this.gh.fo.onAdClosed();
                            }
                        }
                    }
                });
                boolean z = !d.this.gh.gv;
                if (z) {
                    d.this.gh.a(true, -1, d.this.gh.dp);
                }
                return z;
            }
        });
        return ahVar;
    }

    @NonNull
    private q cW() {
        return new q(new q.b() { // from class: com.kwad.components.ad.interstitial.b.d.11
            @Override // com.kwad.components.core.webview.jshandler.q.b
            public final void a(final q.a aVar) {
                if (d.this.gi != null) {
                    d.this.mHandler.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.b.d.11.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (!d.this.gh.gn && aVar.type == 0 && !d.this.gh.gl && !d.this.gh.gm && com.kwad.components.ad.interstitial.c.a.c(d.this.gh)) {
                                d.this.gh.gm = true;
                                com.kwad.components.ad.interstitial.a.b.J(d.this.mContext);
                                return;
                            }
                            d dVar = d.this;
                            if (d.a(dVar, dVar.gi)) {
                                d.this.gi.dismiss();
                                d.this.gh.a(aVar.type == 3, -1, d.this.dp);
                                if (d.this.gh.gn || d.this.gh.fo == null) {
                                    return;
                                }
                                d.this.gh.fo.onAdClosed();
                            }
                        }
                    });
                }
            }
        });
    }

    private j cX() {
        j jVar = new j() { // from class: com.kwad.components.ad.interstitial.b.d.13
            @Override // com.kwad.components.core.webview.b.kwai.j, com.kwad.components.core.webview.b.kwai.e, com.kwad.sdk.core.webview.kwai.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
                super.a(str, cVar);
                if (d.this.dp.isIdle()) {
                    com.kwad.components.core.webview.b.a.s sVar = new com.kwad.components.core.webview.b.a.s();
                    sVar.NZ = false;
                    sVar.Oa = false;
                    sVar.kD = 0;
                    cVar.a(sVar);
                }
                if (d.this.dp.isCompleted()) {
                    com.kwad.components.core.webview.b.a.s sVar2 = new com.kwad.components.core.webview.b.a.s();
                    sVar2.NZ = false;
                    sVar2.Oa = true;
                    sVar2.kD = com.kwad.sdk.core.response.a.a.B(com.kwad.sdk.core.response.a.d.bQ(d.this.mJsBridgeContext.getAdTemplate()));
                    cVar.a(sVar2);
                }
            }
        };
        this.gW = jVar;
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cY() {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        com.kwad.sdk.core.video.videoview.a aVar = this.gh.dp;
        if (aVar != null) {
            aVar.release();
        }
        this.gh.gi.dismiss();
        c cVar = this.gh;
        if (cVar.gn || (adInteractionListener = cVar.fo) == null) {
            return;
        }
        adInteractionListener.onAdClosed();
    }

    @NonNull
    private com.kwad.components.core.webview.jshandler.f cZ() {
        return new com.kwad.components.core.webview.jshandler.f(this.mJsBridgeContext, this.mApkDownloadHelper, new com.kwad.sdk.core.webview.a.kwai.a() { // from class: com.kwad.components.ad.interstitial.b.d.14
            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                if (aVar != null) {
                    if (!d.this.gh.gn && d.this.gh.fo != null) {
                        d.this.gh.fo.onAdClicked();
                    }
                    d.this.gh.gl = true;
                    if (!d.this.gh.gn) {
                        d.this.gh.cy();
                    }
                    if (d.this.gh.gi == null || !com.kwad.components.ad.interstitial.kwai.b.co()) {
                        return;
                    }
                    d.this.gh.gi.dismiss();
                }
            }
        });
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar = this.mJsInterface;
        if (aVar != null) {
            aVar.destroy();
            this.mJsInterface = null;
        }
    }

    @NonNull
    private com.kwad.components.core.webview.jshandler.i da() {
        return new com.kwad.components.core.webview.jshandler.i(this.mJsBridgeContext, this.mApkDownloadHelper, new com.kwad.sdk.core.webview.a.kwai.a() { // from class: com.kwad.components.ad.interstitial.b.d.15
            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                if (aVar != null) {
                    if (!d.this.gh.gn && d.this.gh.fo != null) {
                        d.this.gh.fo.onAdClicked();
                    }
                    d.this.gh.gl = true;
                    if (!d.this.gh.gn) {
                        d.this.gh.cy();
                    }
                    if (d.this.gh.gi == null || !com.kwad.components.ad.interstitial.kwai.b.co()) {
                        return;
                    }
                    d.this.gh.gi.dismiss();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void db() {
        float bm = com.kwad.sdk.core.response.a.b.bm(this.mAdTemplate);
        if (this.eN == null) {
            com.kwad.sdk.core.g.d dVar = new com.kwad.sdk.core.g.d(bm);
            this.eN = dVar;
            dVar.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.interstitial.b.d.18
                @Override // com.kwad.sdk.core.g.b
                public final void a(double d) {
                    if (com.kwad.sdk.b.kwai.a.g(d.this.gS, 100)) {
                        d.this.c(d);
                    }
                    bd.a(new Runnable() { // from class: com.kwad.components.ad.interstitial.b.d.18.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.kwad.sdk.core.e.b.d("InterstitialWebViewPresenter", "onShakeEvent openGate2");
                            d.this.eN.vb();
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
        return new w.a() { // from class: com.kwad.components.ad.interstitial.b.d.10
            @Override // com.kwad.components.core.webview.jshandler.w.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(d.this.mContext, new AdWebViewActivityProxy.a.C0638a().ao(bVar.title).ap(bVar.url).N(d.this.mAdTemplate).nx());
            }
        };
    }

    @NonNull
    private KsAdWebView.d getWebListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.interstitial.b.d.20
            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i, String str, String str2) {
                d.this.t("1");
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bv() {
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bw() {
            }
        };
    }

    private void inflateJsBridgeContext() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.mJsBridgeContext = bVar;
        bVar.setAdTemplate(this.gh.mAdTemplate);
        int i = !ag.cB(this.mContext) ? 1 : 0;
        com.kwad.sdk.core.webview.b bVar2 = this.mJsBridgeContext;
        bVar2.mScreenOrientation = i;
        KSFrameLayout kSFrameLayout = this.gS;
        bVar2.agd = kSFrameLayout;
        bVar2.Gl = kSFrameLayout;
        bVar2.Fv = this.gT;
        bVar2.mReportExtData = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str) {
        com.kwad.sdk.core.e.b.d("InterstitialWebViewPresenter", "handleWebViewError " + str);
        com.kwad.sdk.core.g.d dVar = this.eN;
        if (dVar != null) {
            dVar.bA(getContext());
        }
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.dR) {
            return;
        }
        this.dR = true;
        com.kwad.components.core.j.a og = com.kwad.components.core.j.a.og();
        AdTemplate adTemplate = this.mAdTemplate;
        og.c(adTemplate, com.kwad.sdk.core.response.a.b.bo(adTemplate), str);
        this.mHandler.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.b.d.21
            @Override // java.lang.Runnable
            public final void run() {
                d.this.cJ();
                d.this.gh.cx();
            }
        });
        c.a aVar = this.gX;
        if (aVar != null) {
            aVar.b((KsAdWebView.d) null);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void v(String str) {
        clearJsInterfaceRegister();
        c.a b = this.gT.getClientConfig().R(this.mAdTemplate).b(getWebListener());
        this.gX = b;
        this.gT.setClientConfig(b);
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.gT);
        this.mJsInterface = aVar;
        a(aVar, str);
        this.gT.addJavascriptInterface(this.mJsInterface, "KwaiAd");
        this.gT.loadUrl(str);
        bd.a(this.ha, null, 3000L);
    }

    @Override // com.kwad.components.ad.interstitial.b.b, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        c cVar = (c) xR();
        this.gh = cVar;
        this.gZ = false;
        this.gi = cVar.gi;
        this.cN = cVar.cN;
        this.mApkDownloadHelper = cVar.mApkDownloadHelper;
        AdTemplate adTemplate = cVar.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
        this.dp = this.gh.dp;
        this.aM.qi();
        this.aM.a(this.bX);
        if (com.kwad.sdk.core.response.a.b.bn(this.mAdTemplate)) {
            this.mHandler.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.b.d.19
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.cJ();
                    d.this.gh.cx();
                }
            });
            return;
        }
        inflateJsBridgeContext();
        aE();
    }

    @Override // com.kwad.components.ad.interstitial.b.b
    public final void cv() {
        super.cv();
        com.kwad.components.ad.f.kwai.kwai.b bVar = this.gY;
        if (bVar != null) {
            bVar.eB();
        }
    }

    @Override // com.kwad.components.ad.interstitial.b.b
    public final void cw() {
        super.cw();
        com.kwad.components.ad.f.kwai.kwai.b bVar = this.gY;
        if (bVar != null) {
            bVar.eA();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        KsAdWebView ksAdWebView = (KsAdWebView) getRootView().findViewById(R.id.obfuscated_res_0x7f09140f);
        this.gT = ksAdWebView;
        ksAdWebView.setBackgroundColor(0);
        this.gT.setVisibility(4);
        this.aM = new com.kwad.components.core.widget.kwai.b(this.gT, 100);
        this.gS = (KSFrameLayout) getRootView().findViewById(R.id.obfuscated_res_0x7f09125c);
        this.dN = (KSFrameLayout) getRootView().findViewById(R.id.obfuscated_res_0x7f0913e6);
        this.f6do = (ImageView) getRootView().findViewById(R.id.obfuscated_res_0x7f0913f6);
        this.gU = (ImageView) getRootView().findViewById(R.id.obfuscated_res_0x7f0912b3);
        Context context = getContext();
        this.mContext = context;
        if (context != null) {
            this.eO = (Vibrator) context.getSystemService("vibrator");
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mHandler.removeCallbacksAndMessages(null);
        this.aM.b(this.bX);
        this.aM.qj();
        com.kwad.sdk.core.g.d dVar = this.eN;
        if (dVar != null) {
            dVar.bA(getContext());
        }
        c.a aVar = this.gX;
        if (aVar != null) {
            aVar.b((KsAdWebView.d) null);
        }
    }
}
