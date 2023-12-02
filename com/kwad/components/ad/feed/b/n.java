package com.kwad.components.ad.feed.b;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.j.a;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.a.o;
import com.kwad.components.core.webview.tachikoma.a.p;
import com.kwad.components.core.webview.tachikoma.b.t;
import com.kwad.components.core.widget.b;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.FeedSlideConf;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes10.dex */
public final class n extends com.kwad.components.core.widget.b<AdResultData, AdTemplate> implements com.kwad.sdk.widget.c {
    public KsAdVideoPlayConfig dU;
    public a.b eY;
    public long ey;
    public com.kwad.components.core.widget.b fM;
    public float fN;
    public float fO;
    public boolean fP;
    public b.a fZ;
    public com.kwad.components.core.webview.tachikoma.i gj;
    public KSFrameLayout gk;
    public boolean gl;
    public aw gm;
    public com.kwad.sdk.core.webview.c.c gn;
    public o go;
    public a gp;
    public com.kwad.components.core.e.d.c mApkDownloadHelper;
    public int mHeight;
    public int mWidth;

    /* loaded from: classes10.dex */
    public interface a {
        void c(int i, String str);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view2) {
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view2) {
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d04d2;
    }

    public n(@NonNull Context context) {
        this(context, null);
    }

    private void init(final Context context) {
        int a2 = com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.aqB);
        this.gj = new com.kwad.components.core.webview.tachikoma.i(context, a2, a2);
        com.kwad.sdk.core.c.b.Ct();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.ad.feed.b.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* renamed from: onActivityDestroyed */
            public final void b(@NonNull Activity activity) {
                Context context2 = context;
                if ((context2 instanceof Activity) && context2.equals(activity)) {
                    if (n.this.gj != null) {
                        n.this.gj.jn();
                    }
                    if (n.this.gm != null) {
                        n.this.gm.onDestroy();
                    }
                    com.kwad.sdk.core.c.b.Ct();
                    com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                }
            }
        });
    }

    public final void setTKLoadListener(a aVar) {
        int i;
        a aVar2 = this.gp;
        if (aVar2 != null) {
            if (this.gl) {
                i = 1;
            } else {
                i = 3;
            }
            aVar2.c(i, "");
        }
        this.gp = aVar;
    }

    public final void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.dU = ksAdVideoPlayConfig;
        bD();
    }

    public final void setWidth(int i) {
        if (i <= 0) {
            i = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        this.mWidth = i;
    }

    public n(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public n(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        this.mWidth = getContext().getResources().getDisplayMetrics().widthPixels;
        this.gl = false;
        this.fZ = new b.a() { // from class: com.kwad.components.ad.feed.b.n.4
            @Override // com.kwad.components.core.widget.b.a
            public final void onAdClicked() {
                if (n.this.aaZ != null) {
                    n.this.aaZ.onAdClicked();
                }
                com.kwad.components.ad.feed.monitor.b.a(n.this.mAdTemplate, 1, n.this.getStayTime());
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDislikeClicked() {
                if (n.this.aaZ != null) {
                    n.this.aaZ.onDislikeClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogDismiss() {
                if (n.this.aaZ != null) {
                    n.this.aaZ.onDownloadTipsDialogDismiss();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogShow() {
                if (n.this.aaZ != null) {
                    n.this.aaZ.onDownloadTipsDialogShow();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdShow() {
                if (n.this.gl) {
                    if (n.this.aaZ != null) {
                        n.this.aaZ.onAdShow();
                    }
                    com.kwad.sdk.core.report.j jVar = new com.kwad.sdk.core.report.j();
                    y.a aVar = new y.a();
                    FeedType fromInt = FeedType.fromInt(n.this.mAdTemplate.type);
                    if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                        fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                    }
                    aVar.templateId = String.valueOf(fromInt.getType());
                    jVar.a(aVar);
                    jVar.x(n.this.getHeight(), n.this.mWidth);
                    com.kwad.components.core.s.b.qL().a(n.this.mAdTemplate, null, jVar);
                    com.kwad.components.ad.feed.monitor.b.a(n.this.mAdTemplate, 1, 3);
                }
            }
        };
        init(context);
    }

    private void a(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.fN = motionEvent.getX();
            this.fO = motionEvent.getY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD() {
        if (this.gn == null) {
            return;
        }
        bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.b.n.3
            private boolean a(boolean z, boolean z2) {
                AdInfo dP = com.kwad.sdk.core.response.b.e.dP(n.this.mAdTemplate);
                if (com.kwad.sdk.core.response.b.a.bU(dP)) {
                    return z;
                }
                if (com.kwad.sdk.core.response.b.a.bV(dP)) {
                    return z2;
                }
                if (com.kwad.sdk.core.response.b.a.bW(dP)) {
                    return false;
                }
                if (com.kwad.sdk.core.config.d.AU()) {
                    return z;
                }
                return z2;
            }

            private boolean a(boolean z, boolean z2, KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl, int i) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                                if (kSAdVideoPlayConfigImpl.isDataFlowAutoStart()) {
                                    return z;
                                }
                                return z2;
                            }
                            return a(z, z2);
                        }
                        return false;
                    }
                    return z2;
                }
                return z;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.core.webview.tachikoma.b.d dVar = new com.kwad.components.core.webview.tachikoma.b.d();
                boolean isNetworkConnected = ag.isNetworkConnected(n.this.mContext);
                boolean isWifiConnected = ag.isWifiConnected(n.this.mContext);
                if (n.this.dU instanceof KSAdVideoPlayConfigImpl) {
                    KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) n.this.dU;
                    dVar.ZS = a(isNetworkConnected, isWifiConnected, kSAdVideoPlayConfigImpl, kSAdVideoPlayConfigImpl.getVideoAutoPlayType());
                } else {
                    dVar.ZS = a(isNetworkConnected, isWifiConnected);
                }
                n.this.gn.a(dVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bw() {
        if (this.fP) {
            return;
        }
        this.fP = true;
        com.kwad.components.ad.feed.monitor.b.a(this.mAdTemplate, 3, getStayTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.eY == null) {
            this.eY = new a.b(new a.c() { // from class: com.kwad.components.ad.feed.b.n.5
                @Override // com.kwad.components.core.j.a.c
                public final void bk() {
                }
            });
        }
        return this.eY;
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void aM() {
        super.aM();
        com.kwad.components.core.j.a.ow().a(getCurrentVoiceItem());
        aw awVar = this.gm;
        if (awVar != null) {
            awVar.sk();
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.h.c
    public final void aN() {
        super.aN();
        aw awVar = this.gm;
        if (awVar != null) {
            awVar.sl();
            com.kwad.components.core.j.a.ow().c(this.eY);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void bc() {
        this.gk = (KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f09133c);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bv() {
        if (!this.mAdTemplate.mPvReported) {
            aw awVar = this.gm;
            if (awVar != null) {
                awVar.sg();
                this.gm.sh();
                com.kwad.components.ad.feed.monitor.b.a((AdTemplate) this.mAdTemplate, 3, 3);
            }
            b.a aVar = this.aaZ;
            if (aVar != null) {
                aVar.onAdShow();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE() {
        if (this.fM == null) {
            this.gl = true;
            com.kwad.components.core.widget.b a2 = com.kwad.components.ad.feed.b.a(this.mContext, FeedType.fromInt(this.mAdTemplate.type), com.kwad.sdk.core.response.b.a.be(this.mAdInfo));
            this.fM = a2;
            if (a2 != null) {
                this.fM.setMargin(com.kwad.sdk.d.a.a.a(this.mContext, 16.0f));
                this.gk.removeAllViews();
                this.fM.setInnerAdInteractionListener(this.fZ);
                this.gk.addView(this.fM);
                this.gp.c(1, "");
                this.fM.b((com.kwad.components.core.widget.b) this.mAdResultData);
                com.kwad.components.core.widget.b bVar = this.fM;
                if (bVar instanceof c) {
                    ((c) bVar).a(this.dU);
                }
            }
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final void b(@NonNull AdResultData adResultData) {
        super.b((n) adResultData);
        com.kwad.components.core.e.d.c cVar = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        this.mApkDownloadHelper = cVar;
        cVar.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        this.ey = SystemClock.elapsedRealtime();
        if (com.kwad.sdk.core.response.b.b.cL(this.mAdTemplate) > 0.0d) {
            this.mHeight = (int) (this.mWidth * com.kwad.sdk.core.response.b.b.cL(this.mAdTemplate));
        } else {
            this.mHeight = this.gk.getHeight();
        }
        this.gj.a(com.kwad.sdk.m.l.m186do(this.mContext), adResultData, new com.kwad.components.core.webview.tachikoma.j() { // from class: com.kwad.components.ad.feed.b.n.2
            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(p pVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(com.kwad.components.core.webview.tachikoma.b.m mVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(t tVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void bG() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final String getTKReaderScene() {
                return "tk_feed_tk_card";
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final com.kwad.sdk.widget.e getTouchCoordsView() {
                return null;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(aw awVar) {
                n.this.gm = awVar;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void b(ac.a aVar) {
                aVar.width = com.kwad.sdk.d.a.a.b(n.this.mContext, n.this.mWidth);
                aVar.height = com.kwad.sdk.d.a.a.b(n.this.mContext, n.this.mHeight);
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(a.C0664a c0664a) {
                if (n.this.aaZ != null) {
                    if (c0664a.VE.equals("adDownloadConfirmTipShow")) {
                        n.this.aaZ.onDownloadTipsDialogShow();
                    } else if (c0664a.VE.equals("adDownloadConfirmTipDismiss") || c0664a.VE.equals("adDownloadConfirmTipCancel")) {
                        n.this.aaZ.onDownloadTipsDialogDismiss();
                    }
                }
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(TKRenderFailReason tKRenderFailReason) {
                n.this.bE();
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(o oVar) {
                n.this.go = oVar;
                n.this.go.a(new o.a() { // from class: com.kwad.components.ad.feed.b.n.2.3
                    /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
                        if (com.kwad.components.core.j.a.b(r3.gs.gr.eY) == false) goto L5;
                     */
                    /* JADX WARN: Removed duplicated region for block: B:24:0x007b  */
                    @Override // com.kwad.components.core.webview.tachikoma.a.o.a
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final boolean isMuted() {
                        boolean z;
                        boolean z2 = true;
                        if (com.kwad.sdk.core.config.d.gq() || !com.kwad.components.core.s.a.ah(n.this.mContext).qJ()) {
                            if (n.this.eY != null) {
                                com.kwad.components.core.j.a.ow();
                            }
                            if ((n.this.dU instanceof KSAdVideoPlayConfigImpl) && ((KSAdVideoPlayConfigImpl) n.this.dU).getVideoSoundValue() != 0) {
                                z = !n.this.dU.isVideoSoundEnable();
                                if (n.this.mAdTemplate != null) {
                                    n.this.mAdTemplate.mIsAudioEnable = !z;
                                }
                                return z;
                            } else if (com.kwad.sdk.core.response.b.a.bT(n.this.mAdInfo)) {
                                z2 = false;
                            }
                        }
                        z = z2;
                        if (n.this.mAdTemplate != null) {
                        }
                        return z;
                    }
                });
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(WebCloseStatus webCloseStatus) {
                if (n.this.gm != null) {
                    n.this.gm.si();
                    n.this.gm.sj();
                }
                bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.feed.b.n.2.4
                    @Override // com.kwad.sdk.utils.ay
                    public final void doTask() {
                        n.this.ta();
                    }
                });
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(com.kwad.sdk.components.p pVar, com.kwad.sdk.core.webview.b bVar) {
                pVar.c(new x(bVar, n.this.mApkDownloadHelper, (com.kwad.sdk.core.webview.d.a.a) n.this.gj, true));
                pVar.c(new com.kwad.components.core.webview.tachikoma.a.n() { // from class: com.kwad.components.ad.feed.b.n.2.1
                    @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
                    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar2) {
                        super.a(str, cVar2);
                        n.this.gn = cVar2;
                        n.this.bD();
                    }
                });
                pVar.c(new v() { // from class: com.kwad.components.ad.feed.b.n.2.2
                    @Override // com.kwad.components.core.webview.jshandler.v
                    public final void c(com.kwad.components.core.webview.tachikoma.b.x xVar) {
                        super.c(xVar);
                        com.kwad.components.core.j.a.ow().c(n.this.eY);
                    }

                    @Override // com.kwad.components.core.webview.jshandler.v
                    public final void a(com.kwad.components.core.webview.tachikoma.b.x xVar) {
                        super.a(xVar);
                        if (com.kwad.components.core.s.a.ah(n.this.mContext).qJ() && n.this.go != null) {
                            com.kwad.components.core.webview.tachikoma.b.m mVar = new com.kwad.components.core.webview.tachikoma.b.m();
                            mVar.aaa = true;
                            n.this.go.c(mVar);
                        }
                        com.kwad.components.core.j.a.ow().a(n.this.getCurrentVoiceItem());
                        com.kwad.components.ad.feed.monitor.b.a(n.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.b.a.K(n.this.mAdInfo), null, SystemClock.elapsedRealtime() - n.this.ey);
                    }

                    @Override // com.kwad.components.core.webview.jshandler.v
                    public final void b(com.kwad.components.core.webview.tachikoma.b.x xVar) {
                        super.b(xVar);
                        com.kwad.components.ad.feed.monitor.b.a(n.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.b.a.K(n.this.mAdInfo), xVar.errorReason, SystemClock.elapsedRealtime() - n.this.ey);
                        com.kwad.components.core.o.a.pX().c(n.this.mAdTemplate, xVar.errorCode, xVar.sK());
                    }
                });
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
                if (n.this.aaZ != null) {
                    n.this.aaZ.onAdClicked();
                }
                n.this.bw();
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void bF() {
                if (n.this.gp != null) {
                    n.this.gp.c(3, "");
                }
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final FrameLayout getTKContainer() {
                return n.this.gk;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final String getTkTemplateId() {
                return com.kwad.sdk.core.response.b.b.dz(n.this.mAdTemplate);
            }
        });
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        FeedSlideConf ce;
        int action = motionEvent.getAction() & 255;
        if (com.kwad.sdk.core.config.d.Be() && com.kwad.sdk.core.response.b.d.dE(this.mAdTemplate)) {
            if (com.kwad.sdk.core.response.b.b.ce(this.mAdTemplate) == null) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            a(motionEvent);
            if ((action == 2 || action == 3) && this.gk != null && !this.gl && Math.abs(motionEvent.getX() - this.fN) > 0.0f) {
                this.gk.requestDisallowInterceptTouchEvent(true);
                double abs = Math.abs(motionEvent.getX() - this.fN);
                double abs2 = Math.abs(motionEvent.getY() - this.fO);
                if (Math.tan(ce.maxRange) * abs < abs2 || Math.tan(ce.minRange) * abs < abs2) {
                    this.gk.requestDisallowInterceptTouchEvent(false);
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
