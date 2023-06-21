package com.kwad.components.ad.feed.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.TooltipCompatHandler;
import com.baidu.tieba.R;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.video.a;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.j;
import com.kwad.components.core.webview.jshandler.k;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.r;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.w;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.widget.b;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.RatioFrameLayout;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class l extends com.kwad.components.core.widget.b<AdTemplate> implements View.OnClickListener {
    public static final HashMap<Long, Double> dQ = new HashMap<>(8);
    public int bH;
    public x.b bM;
    public List<Integer> bv;
    public KsAdVideoPlayConfig cN;
    public RatioFrameLayout dL;
    public double dM;
    public KSFrameLayout dN;
    public ad dO;
    public aa dP;
    public boolean dR;
    public String dS;
    public boolean dT;
    public boolean dU;
    public com.kwad.components.core.widget.b dV;
    public a dW;
    public ViewGroup.MarginLayoutParams dX;
    public b.InterfaceC0655b dY;

    /* renamed from: do  reason: not valid java name */
    public ImageView f5do;
    public com.kwad.sdk.core.video.videoview.a dp;
    public com.kwad.components.core.video.c dq;
    public d dr;
    public boolean ds;
    public boolean dt;
    public final a.InterfaceC0642a du;
    public h.a dv;
    public KsAdWebView mAdWebView;
    @Nullable
    public com.kwad.components.core.c.a.c mApkDownloadHelper;
    public Handler mHandler;
    public com.kwad.sdk.core.webview.b mJsBridgeContext;
    public com.kwad.components.core.webview.a mJsInterface;
    public int mWidth;

    /* loaded from: classes9.dex */
    public interface a {
        void aZ();
    }

    public l(@NonNull Context context) {
        super(context);
        this.bH = -1;
        this.ds = false;
        this.dT = false;
        this.dU = false;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.dv = new h.a() { // from class: com.kwad.components.ad.feed.a.l.1
            @Override // com.kwad.sdk.utils.h.a
            public final void bk() {
                l.a(l.this, false);
                if (l.this.dp != null) {
                    l.this.dp.setVideoSoundEnable(false);
                }
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void bl() {
            }
        };
        this.dY = new b.InterfaceC0655b() { // from class: com.kwad.components.ad.feed.a.l.10
            @Override // com.kwad.components.core.widget.b.InterfaceC0655b
            public final void onAdClicked() {
                if (l.this.lp != null) {
                    l.this.lp.onAdClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0655b
            public final void onAdShow() {
                if (l.this.lp != null) {
                    l.this.lp.onAdShow();
                }
                if (l.this.dU) {
                    com.kwad.sdk.core.report.f fVar = new com.kwad.sdk.core.report.f();
                    u.a aVar = new u.a();
                    FeedType fromInt = FeedType.fromInt(l.this.mAdTemplate.type);
                    if (fromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                        fromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                    }
                    aVar.templateId = String.valueOf(fromInt.getType());
                    fVar.a(aVar);
                    com.kwad.components.core.m.c.ox().a(l.this.mAdTemplate, null, fVar);
                }
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0655b
            public final void onDislikeClicked() {
                if (l.this.lp != null) {
                    l.this.lp.onDislikeClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0655b
            public final void onDownloadTipsDialogDismiss() {
                if (l.this.lp != null) {
                    l.this.lp.onDownloadTipsDialogDismiss();
                }
            }

            @Override // com.kwad.components.core.widget.b.InterfaceC0655b
            public final void onDownloadTipsDialogShow() {
                if (l.this.lp != null) {
                    l.this.lp.onDownloadTipsDialogShow();
                }
            }
        };
        this.bM = new x.b() { // from class: com.kwad.components.ad.feed.a.l.3
            @Override // com.kwad.components.core.webview.jshandler.x.b
            public final void a(x.a aVar) {
                if (l.this.dR) {
                    return;
                }
                l.this.bH = aVar.status;
                if (l.this.bH != 1) {
                    l.this.t("3");
                    return;
                }
                if (l.this.dV != null) {
                    l.this.dV.setVisibility(8);
                }
                l.this.mAdWebView.setVisibility(0);
                com.kwad.components.core.j.a.og().O(l.this.mAdTemplate);
                l.this.mHandler.removeCallbacksAndMessages(null);
                if (l.this.dW != null) {
                    l.this.dW.aZ();
                }
            }
        };
        this.du = new a.InterfaceC0642a() { // from class: com.kwad.components.ad.feed.a.l.7
            @Override // com.kwad.components.core.video.a.InterfaceC0642a
            public final void a(int i, aa.a aVar) {
                int i2;
                int i3 = 2;
                boolean z = false;
                if (i == 1) {
                    i2 = 13;
                } else if (i == 2) {
                    i2 = 82;
                } else if (i != 3) {
                    i2 = 108;
                } else {
                    i2 = 83;
                    i3 = 1;
                    z = true;
                }
                u.b bVar = new u.b();
                bVar.gL = aVar;
                bVar.gJ = i2;
                com.kwad.components.core.c.a.a.a(new a.C0631a(com.kwad.sdk.b.kwai.a.x(l.this.dp)).L(l.this.mAdTemplate).b(l.this.mApkDownloadHelper).ae(i3).aj(z).al(true).a(bVar).an(true).a(new a.b() { // from class: com.kwad.components.ad.feed.a.l.7.1
                    @Override // com.kwad.components.core.c.a.a.b
                    public final void onAdClicked() {
                        l.this.dx();
                    }
                }));
            }
        };
        this.mWidth = context.getResources().getDisplayMetrics().widthPixels;
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        this.dO = new ad();
        com.kwad.components.core.webview.jshandler.aa aaVar = new com.kwad.components.core.webview.jshandler.aa();
        this.dP = aaVar;
        aVar.a(aaVar);
        aVar.a(new com.kwad.components.core.webview.jshandler.i(this.mJsBridgeContext, this.mApkDownloadHelper, getClickListener()));
        aVar.a(new com.kwad.components.core.webview.jshandler.f(this.mJsBridgeContext, this.mApkDownloadHelper, getClickListener()));
        aVar.a(new r(this.mJsBridgeContext, new r.b() { // from class: com.kwad.components.ad.feed.a.l.11
            @Override // com.kwad.components.core.webview.jshandler.r.b
            public final void a(r.a aVar2) {
                l.this.mAdWebView.setVisibility(0);
                if (l.this.dM == 0.0d) {
                    l.this.dM = aVar2.height;
                    double d = aVar2.height / l.this.mWidth;
                    l.this.dL.setRatio((float) d);
                    l.dQ.put(Long.valueOf(l.this.mAdTemplate.posId), Double.valueOf(d));
                }
            }
        }));
        aVar.a(new com.kwad.components.core.webview.b.kwai.c());
        aVar.a(new com.kwad.components.core.webview.jshandler.l(this.mJsBridgeContext));
        aVar.a(new WebCardVideoPositionHandler(new WebCardVideoPositionHandler.a() { // from class: com.kwad.components.ad.feed.a.l.12
            @Override // com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.a
            public final void a(WebCardVideoPositionHandler.VideoPosition videoPosition) {
                if (l.this.mAdInfo == null || !com.kwad.sdk.core.response.a.a.aB(l.this.mAdInfo)) {
                    return;
                }
                l lVar = l.this;
                lVar.dX = (ViewGroup.MarginLayoutParams) lVar.dN.getLayoutParams();
                int ceil = (int) Math.ceil(l.this.dM);
                int i = l.this.mWidth;
                if (videoPosition.widthRation == 0.0d) {
                    videoPosition.widthRation = 0.9200000166893005d;
                    videoPosition.leftMarginRation = 0.03999999910593033d;
                }
                l.this.dX.topMargin = (int) (videoPosition.topMarginRation * ceil);
                double d = i;
                l.this.dX.leftMargin = (int) (videoPosition.leftMarginRation * d);
                l.this.dX.width = (int) (d * videoPosition.widthRation);
                l.this.dX.height = (int) (l.this.dX.width * videoPosition.heightWidthRation);
                l.this.dN.setRadius(videoPosition.borderRadius);
                l.this.dN.setLayoutParams(l.this.dX);
                l lVar2 = l.this;
                lVar2.a(lVar2.cN);
            }
        }));
        aVar.a(new com.kwad.components.core.webview.jshandler.j(this.mJsBridgeContext, new j.a() { // from class: com.kwad.components.ad.feed.a.l.13
            @Override // com.kwad.components.core.webview.jshandler.j.a
            public final void bx() {
                l.this.mHandler.post(new Runnable() { // from class: com.kwad.components.ad.feed.a.l.13.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        l.this.pX();
                    }
                });
            }
        }));
        aVar.a(new o(this.mJsBridgeContext));
        com.kwad.components.core.webview.jshandler.k kVar = new com.kwad.components.core.webview.jshandler.k(this.mJsBridgeContext);
        kVar.a(new k.b() { // from class: com.kwad.components.ad.feed.a.l.14
            @Override // com.kwad.components.core.webview.jshandler.k.b
            public final void a(k.a aVar2) {
                aVar2.height = 0;
                aVar2.width = l.this.mWidth;
                l.this.dT = true;
            }
        });
        aVar.a(kVar);
        aVar.a(new x(this.bM, com.kwad.sdk.core.response.a.b.bi(this.mAdTemplate)));
        aVar.a(new ac(this.mJsBridgeContext, this.mApkDownloadHelper));
        aVar.a(new s(this.mJsBridgeContext));
        aVar.a(this.dO);
        aVar.a(new w(getOpenNewPageListener()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.video.videoview.a aVar) {
        if (aVar != null) {
            String A = com.kwad.sdk.core.response.a.a.A(this.mAdInfo);
            boolean z = false;
            this.dq.setAutoRelease(false);
            AdVideoPlayerViewCache.getInstance().a(A, this.dp);
            FeedType fromInt = FeedType.fromInt(this.mAdTemplate.type);
            a.C0631a ae = new a.C0631a(com.kwad.sdk.b.kwai.a.x(this)).L(this.mAdTemplate).b(this.mApkDownloadHelper).ae(2);
            if ((fromInt == FeedType.FEED_TYPE_TEXT_BELOW || fromInt == FeedType.FEED_TYPE_TEXT_ABOVE) && com.kwad.sdk.core.response.a.a.aB(this.mAdInfo)) {
                z = true;
            }
            com.kwad.components.core.c.a.a.a(ae.an(z).a(new a.b() { // from class: com.kwad.components.ad.feed.a.l.6
                @Override // com.kwad.components.core.c.a.a.b
                public final void onAdClicked() {
                    l.this.aq(100);
                }
            }));
        }
    }

    public static /* synthetic */ boolean a(l lVar, com.kwad.sdk.core.webview.a.a.a aVar) {
        return b(aVar);
    }

    public static /* synthetic */ boolean a(l lVar, boolean z) {
        lVar.dt = false;
        return false;
    }

    private void aE() {
        if (com.kwad.sdk.core.response.a.b.bk(this.mAdTemplate)) {
            bq();
        } else {
            t("0");
        }
    }

    public static boolean b(com.kwad.sdk.core.webview.a.a.a aVar) {
        return aVar.DS ? aVar.Mv : aVar.Mx == 1;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void bq() {
        clearJsInterfaceRegister();
        this.mAdWebView.setClientConfig(this.mAdWebView.getClientConfig().R(this.mAdTemplate).b(getWebListener()));
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.mAdWebView);
        this.mJsInterface = aVar;
        a(aVar);
        this.mAdWebView.addJavascriptInterface(this.mJsInterface, "KwaiAd");
        this.mAdWebView.loadUrl(com.kwad.sdk.core.response.a.b.bi(this.mAdTemplate));
    }

    private boolean bs() {
        return this.bH == 1;
    }

    private void bt() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int ceil = (int) Math.ceil(((float) j) / 1000.0f);
        List<Integer> list = this.bv;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.bv.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.report.a.b(this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar = this.mJsInterface;
        if (aVar != null) {
            aVar.destroy();
            this.mJsInterface = null;
        }
    }

    public static float e(AdTemplate adTemplate) {
        int i = adTemplate.type;
        if (i == 1) {
            return 0.6013f;
        }
        return (i == 2 || i == 3) ? 0.283f : 0.968f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.kwad.sdk.core.response.model.AdTemplate */
    /* JADX WARN: Multi-variable type inference failed */
    private void f(AdTemplate adTemplate) {
        RatioFrameLayout ratioFrameLayout;
        float e;
        com.kwad.components.core.c.a.c cVar = new com.kwad.components.core.c.a.c(this.mAdTemplate);
        this.mApkDownloadHelper = cVar;
        cVar.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        this.mAdTemplate = adTemplate;
        Double d = dQ.get(Long.valueOf(adTemplate.posId));
        if (d != null) {
            this.dL.setRatio(d.floatValue());
        } else {
            if (com.kwad.sdk.core.response.a.b.bj(this.mAdTemplate) > 0.0f) {
                ratioFrameLayout = this.dL;
                e = com.kwad.sdk.core.response.a.b.bj(this.mAdTemplate);
            } else if (this.dL.getRatio() == 0.0f) {
                ratioFrameLayout = this.dL;
                e = e(this.mAdTemplate);
            }
            ratioFrameLayout.setRatio(e);
        }
        inflateJsBridgeContext();
    }

    @NonNull
    private com.kwad.sdk.core.webview.a.kwai.a getClickListener() {
        return new com.kwad.sdk.core.webview.a.kwai.a() { // from class: com.kwad.components.ad.feed.a.l.2
            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                int i = aVar.Mx;
                if (aVar.DS) {
                    i = aVar.Mv ? 1 : 2;
                }
                boolean z = com.kwad.sdk.core.response.a.a.aB(l.this.mAdInfo) && (l.this.mAdTemplate.type == FeedType.FEED_TYPE_TEXT_BELOW.getType() || l.this.mAdTemplate.type == FeedType.FEED_TYPE_TEXT_ABOVE.getType());
                u.b bVar = new u.b();
                com.kwad.sdk.core.webview.a.a.c cVar = aVar.My;
                if (cVar != null && !TextUtils.isEmpty(cVar.Mn)) {
                    bVar.Mn = aVar.My.Mn;
                }
                com.kwad.components.core.c.a.a.a(new a.C0631a(com.kwad.sdk.b.kwai.a.x(l.this)).L(l.this.mAdTemplate).b(l.this.mApkDownloadHelper).aj(l.a(l.this, aVar)).ae(i).ao(aVar.DS).an(z).a(bVar).al(true).a(new a.b() { // from class: com.kwad.components.ad.feed.a.l.2.1
                    @Override // com.kwad.components.core.c.a.a.b
                    public final void onAdClicked() {
                        if (l.this.lp != null) {
                            l.this.lp.onAdClicked();
                        }
                    }
                }));
            }
        };
    }

    private w.a getOpenNewPageListener() {
        return new w.a() { // from class: com.kwad.components.ad.feed.a.l.15
            @Override // com.kwad.components.core.webview.jshandler.w.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(l.this.mContext, new AdWebViewActivityProxy.a.C0638a().ao(bVar.title).ap(bVar.url).N(l.this.mAdTemplate).nx());
            }
        };
    }

    private KsAdWebView.d getWebListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.feed.a.l.9
            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i, String str, String str2) {
                l.this.t("1");
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bv() {
                l.this.dT = false;
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bw() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(boolean z) {
        if (z) {
            if (!com.kwad.sdk.core.config.d.fY()) {
                return !com.kwad.components.core.m.b.at(this.mContext).ow() ? com.kwad.components.core.m.b.at(this.mContext).ay(false) : !com.kwad.components.core.m.b.at(this.mContext).ov();
            }
            if (!this.dt) {
                this.dt = com.kwad.components.core.m.b.at(this.mContext).ay(true);
            }
            return this.dt;
        }
        return false;
    }

    private a.b i(final boolean z) {
        return new a.b() { // from class: com.kwad.components.ad.feed.a.l.5
            public boolean bw = false;

            @Override // com.kwad.components.core.video.a.b
            public final void bm() {
                com.kwad.sdk.core.report.a.ax(l.this.mAdTemplate);
                if (z) {
                    l.this.dO.at(9);
                }
                if (l.this.dN != null) {
                    l.this.dN.setVisibility(8);
                }
                if (com.kwad.components.ad.feed.kwai.b.bc() && l.this.dr == null) {
                    l.this.dr = new d(l.this.getContext());
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    l lVar = l.this;
                    lVar.addView(lVar.dr, layoutParams);
                    l.this.dr.bn();
                }
            }

            @Override // com.kwad.components.core.video.a.b
            public final void d(long j) {
                l.this.c(j);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayStart() {
                com.kwad.sdk.core.report.a.aw(l.this.mAdTemplate);
                if (z) {
                    l.this.dO.at(3);
                }
                if (l.this.dr == null || !(l.this.dr.getParent() instanceof ViewGroup)) {
                    return;
                }
                ((ViewGroup) l.this.dr.getParent()).removeView(l.this.dr);
                l.this.dr.bo();
                l.this.dr = null;
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlaying() {
                if (!this.bw) {
                    this.bw = true;
                    com.kwad.components.core.j.a.og().a(l.this.mAdTemplate, System.currentTimeMillis(), 1);
                }
                com.kwad.sdk.core.video.videoview.a aVar = l.this.dp;
                l lVar = l.this;
                aVar.setVideoSoundEnable(lVar.h(lVar.ds));
            }
        };
    }

    private void inflateJsBridgeContext() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.mJsBridgeContext = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.mJsBridgeContext;
        bVar2.mScreenOrientation = 0;
        bVar2.agd = null;
        bVar2.Gl = this.dL;
        bVar2.Fv = this.mAdWebView;
        bVar2.mReportExtData = null;
        bVar2.agf = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str) {
        com.kwad.sdk.core.e.b.d("FeedWebView", "handleWebViewError " + str);
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.dR) {
            return;
        }
        a aVar = this.dW;
        if (aVar != null) {
            aVar.aZ();
        }
        this.dW = null;
        this.dR = true;
        com.kwad.components.core.j.a og = com.kwad.components.core.j.a.og();
        AdTemplate adTemplate = this.mAdTemplate;
        og.c(adTemplate, com.kwad.sdk.core.response.a.b.bi(adTemplate), str);
        if (this.dV == null) {
            this.dU = true;
            com.kwad.components.core.widget.b a2 = com.kwad.components.ad.feed.c.a(getContext(), FeedType.fromInt(this.mAdTemplate.type), com.kwad.sdk.core.response.a.a.aD(this.mAdInfo));
            this.dV = a2;
            if (a2 != null) {
                this.dV.setMargin(com.kwad.sdk.b.kwai.a.a(getContext(), 16.0f));
                this.dL.removeAllViews();
                this.dL.setRatio(0.0f);
                this.mAdWebView.setVisibility(8);
                this.dN.setVisibility(8);
                this.dV.setInnerAdInteractionListener(this.dY);
            }
            this.dL.addView(this.dV);
            this.dV.c((com.kwad.components.core.widget.b) this.mAdTemplate);
            com.kwad.components.core.widget.b bVar = this.dV;
            if (bVar instanceof c) {
                ((c) bVar).a(this.cN);
            }
        }
    }

    public final void a(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        ImageView imageView;
        int i;
        this.ds = (!(ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) || ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() == 0) ? com.kwad.sdk.core.response.a.a.bh(this.mAdInfo) : ksAdVideoPlayConfig.isVideoSoundEnable();
        String url = com.kwad.sdk.core.response.a.a.aL(this.mAdInfo).getUrl();
        if (TextUtils.isEmpty(url)) {
            imageView = this.f5do;
            i = 8;
        } else {
            this.f5do.setImageDrawable(null);
            KSImageLoader.loadImage(this.f5do, url, this.mAdTemplate);
            imageView = this.f5do;
            i = 0;
        }
        imageView.setVisibility(i);
        this.bv = com.kwad.sdk.core.response.a.a.aF(this.mAdInfo);
        com.kwad.sdk.core.video.videoview.a aVar = new com.kwad.sdk.core.video.videoview.a(this.mContext);
        this.dp = aVar;
        aVar.setTag(this.bv);
        String A = com.kwad.sdk.core.response.a.a.A(this.mAdInfo);
        if (TextUtils.isEmpty(A)) {
            return;
        }
        this.dp.a(new b.a(this.mAdTemplate).bk(A).bl(com.kwad.sdk.core.response.a.f.b(com.kwad.sdk.core.response.a.d.bR(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(new com.kwad.sdk.contentalliance.kwai.kwai.a(this.mAdTemplate, System.currentTimeMillis())).rC(), (Map<String, String>) null);
        this.dp.setVideoSoundEnable(this.ds);
        com.kwad.components.core.video.c cVar = new com.kwad.components.core.video.c(this.mContext, this.mAdTemplate, this.dp, ksAdVideoPlayConfig);
        this.dq = cVar;
        cVar.setVideoPlayCallback(i(true));
        this.dq.setAdClickListener(this.du);
        this.dp.setController(this.dq);
        if (this.dN.getTag() != null) {
            KSFrameLayout kSFrameLayout = this.dN;
            kSFrameLayout.removeView((View) kSFrameLayout.getTag());
            this.dN.setTag(null);
        }
        this.dN.addView(this.dp);
        this.dN.setTag(this.dp);
        this.dN.setClickable(true);
        this.dN.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.feed.a.l.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (!l.this.dp.isIdle()) {
                    l lVar = l.this;
                    lVar.a(lVar.dp);
                    return;
                }
                com.kwad.sdk.utils.k.ci(l.this.mAdTemplate);
                l.this.dp.setKsPlayLogParam(com.kwad.sdk.contentalliance.kwai.kwai.a.al(l.this.mAdTemplate));
                l.this.dp.start();
            }
        });
        if (this.ds) {
            com.kwad.components.core.m.b.at(this.mContext).a(this.dv);
        }
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        a aVar2 = this.dW;
        if (aVar2 != null) {
            aVar2.aZ();
            this.dW = null;
        }
        this.dW = aVar;
        adTemplate.realShowType = 2;
        super.c((l) adTemplate);
        if (this.bH != 1) {
            f(this.mAdTemplate);
        }
        String str = this.dS;
        if (str == null || !str.equals(adTemplate.mOriginJString)) {
            if (bs()) {
                this.mAdWebView.reload();
            } else {
                aE();
            }
        }
        this.dS = adTemplate.mOriginJString;
        this.mHandler.postDelayed(new Runnable() { // from class: com.kwad.components.ad.feed.a.l.8
            @Override // java.lang.Runnable
            public final void run() {
                l.this.mAdWebView.stopLoading();
                l.this.mAdWebView.setVisibility(8);
                l.this.t("0");
            }
        }, TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void am() {
        super.am();
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void an() {
        super.an();
        com.kwad.sdk.utils.k.ch(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.widget.b
    public final void bg() {
        KsAdWebView ksAdWebView = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f09140f);
        this.mAdWebView = ksAdWebView;
        ksAdWebView.setVisibility(4);
        this.dL = (RatioFrameLayout) findViewById(R.id.obfuscated_res_0x7f09125c);
        this.dN = (KSFrameLayout) findViewById(R.id.obfuscated_res_0x7f0913e6);
        this.f5do = (ImageView) findViewById(R.id.obfuscated_res_0x7f0913f6);
    }

    @Override // com.kwad.components.core.widget.b
    public final void br() {
        com.kwad.components.core.webview.jshandler.aa aaVar;
        b.InterfaceC0655b interfaceC0655b;
        if (!this.mAdTemplate.mPvReported && (interfaceC0655b = this.lp) != null) {
            interfaceC0655b.onAdShow();
        }
        if (this.dU || (aaVar = this.dP) == null) {
            return;
        }
        aaVar.pz();
    }

    @Override // com.kwad.components.core.widget.b
    public final void c(@NonNull AdTemplate adTemplate) {
        adTemplate.realShowType = 2;
        super.c((l) adTemplate);
        if (this.dR) {
            com.kwad.components.core.widget.b bVar = this.dV;
            if (bVar != null) {
                bVar.c((com.kwad.components.core.widget.b) this.mAdTemplate);
                com.kwad.components.core.widget.b bVar2 = this.dV;
                if (bVar2 instanceof c) {
                    ((c) bVar2).a(this.cN);
                    return;
                }
                return;
            }
            return;
        }
        if (this.bH != 1) {
            f(this.mAdTemplate);
        }
        String str = this.dS;
        if (str == null || !str.equals(adTemplate.mOriginJString)) {
            if (bs()) {
                this.mAdWebView.reload();
            } else {
                aE();
            }
        }
        this.dS = adTemplate.mOriginJString;
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d0492;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        bt();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        com.kwad.sdk.core.video.videoview.a aVar;
        ViewGroup viewGroup;
        super.onWindowFocusChanged(z);
        if (!z || (aVar = this.dp) == null || (viewGroup = (ViewGroup) aVar.getParent()) == this.dN) {
            return;
        }
        viewGroup.removeView(this.dp);
        if (this.dN.getTag() != null) {
            KSFrameLayout kSFrameLayout = this.dN;
            kSFrameLayout.removeView((View) kSFrameLayout.getTag());
            this.dN.setTag(null);
        }
        this.dN.addView(this.dp);
        this.dN.setTag(this.dp);
        String A = com.kwad.sdk.core.response.a.a.A(this.mAdInfo);
        this.dp.setVideoSoundEnable(this.ds);
        this.dq.setVideoPlayCallback(i(false));
        this.dq.setAdClickListener(this.du);
        this.dq.getAdTemplate().mAdWebVideoPageShowing = false;
        this.dq.pe();
        this.dq.setAutoRelease(true);
        AdVideoPlayerViewCache.getInstance().remove(A);
    }

    @Override // com.kwad.components.core.widget.b
    public final void setMargin(int i) {
    }

    public final void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        com.kwad.components.core.video.c cVar;
        this.cN = ksAdVideoPlayConfig;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoSoundValue() != 0 && this.dp != null) {
                boolean isVideoSoundEnable = kSAdVideoPlayConfigImpl.isVideoSoundEnable();
                this.ds = isVideoSoundEnable;
                this.dp.setVideoSoundEnable(h(isVideoSoundEnable));
                if (this.ds) {
                    com.kwad.components.core.m.b.at(this.mContext).a(this.dv);
                }
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() == 0 || (cVar = this.dq) == null) {
                return;
            }
            cVar.setDataAutoStart(kSAdVideoPlayConfigImpl.isDataFlowAutoStart());
        }
    }

    public final void setWidth(int i) {
        this.mWidth = i;
    }
}
