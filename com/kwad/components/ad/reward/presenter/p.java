package com.kwad.components.ad.reward.presenter;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.ad.reflux.KsRefluxView;
import com.kwad.components.ad.reward.e;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.e;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.w;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.bd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class p extends a implements KsRefluxView.a, e.a, e.b, com.kwad.sdk.core.webview.a.kwai.a {
    public static long qY = 2000;
    public KsAdWebView bF;
    public aa dP;
    public com.kwad.sdk.core.webview.b mJsBridgeContext;
    public com.kwad.components.core.webview.a mJsInterface;
    public List<com.kwad.components.ad.reward.c.b> qW;
    public KsRefluxView qX;
    public List<com.kwad.components.core.c.a.c> me = new ArrayList();
    public int bH = -1;
    public Runnable qZ = new Runnable() { // from class: com.kwad.components.ad.reward.presenter.p.1
        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.kwad.components.ad.reward.presenter.p.b(com.kwad.components.ad.reward.presenter.p):java.lang.String
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
            Caused by: java.lang.IndexOutOfBoundsException: Index: 0
            	at java.base/java.util.Collections$EmptyList.get(Collections.java:4807)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
            	... 1 more
            */
        @Override // java.lang.Runnable
        public final void run() {
            /*
                r5 = this;
                com.kwad.components.ad.reward.presenter.p r0 = com.kwad.components.ad.reward.presenter.p.this
                com.kwad.components.ad.reward.presenter.p.a(r0)
                com.kwad.components.ad.reward.presenter.p r0 = com.kwad.components.ad.reward.presenter.p.this
                com.kwad.components.ad.reward.k r1 = r0.nM
                boolean r1 = r1.mz
                java.lang.String r0 = com.kwad.components.ad.reward.presenter.p.b(r0)
                long r2 = com.kwad.components.ad.reward.presenter.p.ho()
                java.lang.String r4 = "reflux"
                com.kwad.components.ad.reward.monitor.a.a(r1, r4, r0, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.presenter.p.AnonymousClass1.run():void");
        }
    };
    public com.kwad.components.ad.reward.c.c ra = new com.kwad.components.ad.reward.c.c(null) { // from class: com.kwad.components.ad.reward.presenter.p.2
        {
            super(null);
        }

        @Override // com.kwad.components.ad.reward.c.c
        public final void d(com.kwad.components.ad.reward.c.b bVar) {
            p.this.nM.b(bVar);
        }

        @Override // com.kwad.components.ad.reward.c.c
        public final void e(com.kwad.components.ad.reward.c.b bVar) {
            p.this.nM.c(bVar);
        }
    };
    public x.b bM = new x.b() { // from class: com.kwad.components.ad.reward.presenter.p.4
        @Override // com.kwad.components.core.webview.jshandler.x.b
        public final void a(x.a aVar) {
            KsRefluxView ksRefluxView;
            p.this.bH = aVar.status;
            boolean z = true;
            if (p.this.bH == 1) {
                ksRefluxView = p.this.qX;
            } else {
                ksRefluxView = p.this.qX;
                z = false;
            }
            ksRefluxView.z(z);
            bd.c(p.this.qZ);
        }
    };
    public KsAdWebView.d rb = new KsAdWebView.d() { // from class: com.kwad.components.ad.reward.presenter.p.5
        @Override // com.kwad.components.core.webview.KsAdWebView.d
        public final void a(int i, String str, String str2) {
            p.this.hn();
        }

        @Override // com.kwad.components.core.webview.KsAdWebView.d
        public final void bv() {
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
            jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.kwad.components.ad.reward.presenter.p.b(com.kwad.components.ad.reward.presenter.p):java.lang.String
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
            Caused by: java.lang.IndexOutOfBoundsException: Index: 0
            	at java.base/java.util.Collections$EmptyList.get(Collections.java:4807)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
            	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
            	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
            	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
            	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
            	... 1 more
            */
        @Override // com.kwad.components.core.webview.KsAdWebView.d
        public final void bw() {
            /*
                r6 = this;
                com.kwad.components.ad.reward.presenter.p r0 = com.kwad.components.ad.reward.presenter.p.this
                com.kwad.components.ad.reward.k r1 = r0.nM
                boolean r1 = r1.mz
                java.lang.String r0 = com.kwad.components.ad.reward.presenter.p.b(r0)
                long r2 = java.lang.System.currentTimeMillis()
                com.kwad.components.ad.reward.presenter.p r4 = com.kwad.components.ad.reward.presenter.p.this
                com.kwad.components.core.webview.KsAdWebView r4 = com.kwad.components.ad.reward.presenter.p.h(r4)
                long r4 = r4.getLoadTime()
                long r2 = r2 - r4
                java.lang.String r4 = "reflux"
                com.kwad.components.ad.reward.monitor.a.b(r1, r4, r0, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.presenter.p.AnonymousClass5.bw():void");
        }
    };

    private void a(com.kwad.components.core.webview.a aVar) {
        aa aaVar = new aa();
        this.dP = aaVar;
        aVar.a(aaVar);
        aVar.a(new com.kwad.components.core.webview.jshandler.f(this.mJsBridgeContext, this.me, this));
        aVar.a(new com.kwad.components.core.webview.jshandler.l(this.mJsBridgeContext));
        aVar.a(new com.kwad.components.core.webview.jshandler.o(this.mJsBridgeContext));
        aVar.a(new com.kwad.components.core.webview.jshandler.k(this.mJsBridgeContext));
        aVar.a(new x(this.bM, getUrl()));
        List<AdTemplate> f = com.kwad.components.ad.reward.c.b.f(this.qW);
        aVar.a(new u(f, this.me));
        aVar.a(new com.kwad.components.core.webview.jshandler.q(null));
        aVar.a(new s(this.mJsBridgeContext));
        com.kwad.components.core.webview.jshandler.e eVar = new com.kwad.components.core.webview.jshandler.e(f);
        eVar.a(this);
        aVar.a(eVar);
        aVar.a(new w(new w.a() { // from class: com.kwad.components.ad.reward.presenter.p.3
            @Override // com.kwad.components.core.webview.jshandler.w.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                if (bVar.pv() <= 0 || p.this.qW == null) {
                    return;
                }
                AdTemplate adTemplate = null;
                Iterator it = p.this.qW.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    AdTemplate adTemplate2 = ((com.kwad.components.ad.reward.c.b) it.next()).getAdTemplate();
                    if (com.kwad.sdk.core.response.a.d.ca(adTemplate2) == bVar.pv()) {
                        adTemplate = adTemplate2;
                        break;
                    }
                }
                if (adTemplate != null) {
                    AdWebViewActivityProxy.launch(p.this.getContext(), new AdWebViewActivityProxy.a.C0643a().ao(bVar.title).ap(bVar.url).N(adTemplate).nx());
                }
            }
        }));
    }

    private void aE() {
        this.bH = -1;
        aF();
        this.qX.z(false);
        String url = getUrl();
        com.kwad.components.ad.reward.monitor.a.a(this.nM.mz, "reflux", url);
        com.kwad.sdk.core.e.b.d("RewardRefluxPresenter", "startPreloadWebView url : " + url);
        if (ax.dT(url)) {
            hn();
            return;
        }
        this.bF.loadUrl(url);
        bd.runOnUiThreadDelay(this.qZ, qY);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aF() {
        clearJsInterfaceRegister();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.bF);
        this.mJsInterface = aVar;
        a(aVar);
        this.bF.addJavascriptInterface(this.mJsInterface, "KwaiAd");
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.kwad.components.ad.reward.presenter.p.1.run():void, com.kwad.components.ad.reward.presenter.p.5.bw():void] */
    public static /* synthetic */ String b(p pVar) {
        return getUrl();
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar = this.mJsInterface;
        if (aVar != null) {
            aVar.destroy();
            this.mJsInterface = null;
        }
    }

    @Nullable
    public static String getUrl() {
        String str = com.kwad.components.ad.reward.kwai.b.fU() != null ? com.kwad.components.ad.reward.kwai.b.fU().h5Url : "";
        return TextUtils.isEmpty(str) ? "" : str;
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.kwad.components.ad.reward.presenter.p.5.bw():void] */
    public static /* synthetic */ KsAdWebView h(p pVar) {
        return pVar.bF;
    }

    private void hl() {
        SceneImpl sceneImpl = this.nM.mAdTemplate.mAdScene;
        SceneImpl m178clone = sceneImpl != null ? sceneImpl.m178clone() : null;
        if (m178clone != null) {
            com.kwad.components.ad.reward.e.a(m178clone, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn() {
        this.qX.getNativeView().c(com.kwad.components.ad.reflux.a.b(this.qW, this.me));
        this.qX.z(false);
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.kwad.components.ad.reward.presenter.p.1.run():void] */
    public static /* synthetic */ long ho() {
        return qY;
    }

    private void inflateJsBridgeContext() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.mJsBridgeContext = bVar;
        bVar.setAdTemplateList(com.kwad.components.ad.reward.c.b.f(this.qW));
        com.kwad.sdk.core.webview.b bVar2 = this.mJsBridgeContext;
        com.kwad.components.ad.reward.k kVar = this.nM;
        bVar2.mScreenOrientation = kVar.mScreenOrientation;
        AdBaseFrameLayout adBaseFrameLayout = kVar.mRootContainer;
        bVar2.agd = adBaseFrameLayout;
        bVar2.Gl = adBaseFrameLayout;
        bVar2.Fv = this.bF;
    }

    @Override // com.kwad.components.ad.reward.e.a
    public final void C(String str) {
    }

    @Override // com.kwad.sdk.core.webview.a.kwai.a
    public final void a(@Nullable com.kwad.sdk.core.webview.a.a.a aVar) {
        if (aVar != null) {
            com.kwad.components.ad.reward.c.b a = com.kwad.components.ad.reward.k.a(this.qW, aVar.creativeId);
            if (a != null) {
                this.nM.b(a);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        KsAdWebView ksAdWebView = this.bF;
        if (ksAdWebView != null) {
            this.bF.setClientConfig(ksAdWebView.getClientConfig().R(this.nM.mAdTemplate).b(this.rb));
        }
        com.kwad.components.ad.reward.monitor.a.a(this.nM.mz, "reflux");
        hl();
    }

    @Override // com.kwad.components.core.webview.jshandler.e.b
    public final void b(AdTemplate adTemplate, long j) {
        this.nM.c(com.kwad.components.ad.reward.k.a(this.qW, j));
    }

    @Override // com.kwad.components.ad.reflux.KsRefluxView.a
    public final void dh() {
        List<com.kwad.components.ad.reward.c.b> list = this.qW;
        if (list != null && list.size() > 0) {
            com.kwad.sdk.core.report.a.b(this.qW.get(0).getAdTemplate(), new com.kwad.sdk.core.report.f().aJ(1).aP(this.qX.eC() ? 8 : 9), (JSONObject) null);
        }
        this.nM.mAdOpenInteractionListener.j(false);
        gR();
    }

    @Override // com.kwad.components.ad.reward.e.a
    public final void e(@Nullable List<com.kwad.components.ad.reward.c.b> list) {
        com.kwad.sdk.core.e.b.d("RewardRefluxPresenter", "onRefluxAdLoad :" + list.size());
        this.qW = list;
        if (list.size() > 0) {
            this.me.clear();
            for (com.kwad.components.ad.reward.c.b bVar : this.qW) {
                com.kwad.components.core.c.a.c cVar = new com.kwad.components.core.c.a.c(bVar.getAdTemplate());
                com.kwad.sdk.core.e.b.d("RewardRefluxPresenter", "onRefluxAdLoad helper: " + cVar.mJ());
                this.me.add(cVar);
            }
            if (this.bF == null) {
                hn();
                return;
            }
            inflateJsBridgeContext();
            aE();
        }
    }

    @Override // com.kwad.components.ad.reflux.KsRefluxView.a
    public final void eI() {
        this.nM.eF.pause();
    }

    public final BackPressHandleResult fS() {
        return !this.nM.fD() ? BackPressHandleResult.NOT_HANDLED : isRefluxVisible() ? BackPressHandleResult.HANDLED_CLOSE : hm() ? BackPressHandleResult.HANDLED : BackPressHandleResult.NOT_HANDLED;
    }

    public final boolean hm() {
        List<com.kwad.components.ad.reward.c.b> list = this.qW;
        if (list == null || list.size() <= 0) {
            return false;
        }
        aa aaVar = this.dP;
        if (aaVar != null) {
            aaVar.py();
        }
        this.qX.show();
        aa aaVar2 = this.dP;
        if (aaVar2 != null) {
            aaVar2.pz();
            return true;
        }
        return true;
    }

    public final boolean isRefluxVisible() {
        if (this.qX == null) {
            return false;
        }
        return this.qX.getGlobalVisibleRect(new Rect());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        KsRefluxView ksRefluxView = (KsRefluxView) findViewById(R.id.obfuscated_res_0x7f0913d4);
        this.qX = ksRefluxView;
        this.bF = ksRefluxView.getWebView();
        this.qX.setViewListener(this);
        this.qX.setInnerAdInteractionListener(this.ra);
    }

    @Override // com.kwad.components.ad.reward.e.a
    public final void onRequestResult(int i) {
    }
}
