package com.kwad.components.ad.i;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tieba.R;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.c;
import com.kwad.components.core.webview.jshandler.f;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.k;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.webview.jshandler.q;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    public View BT;
    public String Cd;
    public c.a Ce;
    public a Cf;
    @Nullable
    public InterfaceC0592b Cg;
    public KsAdWebView bF;
    public aa bI;
    @Nullable
    public com.kwad.sdk.core.webview.a.kwai.a bJ;
    public FrameLayout bS;
    public AdBaseFrameLayout ct;
    public AdTemplate mAdTemplate;
    public com.kwad.sdk.core.webview.b mJsBridgeContext;
    public com.kwad.components.core.webview.a mJsInterface;
    @Nullable
    public JSONObject mReportExtData;
    public int mScreenOrientation;
    public ae uF;
    public List<AdTemplate> Ca = new ArrayList();
    @NonNull
    public List<com.kwad.components.core.c.a.c> Cb = new ArrayList();
    public int bH = -1;
    public boolean Cc = false;
    public q.b bL = new q.b() { // from class: com.kwad.components.ad.i.b.3
        @Override // com.kwad.components.core.webview.jshandler.q.b
        public final void a(q.a aVar) {
            b.this.kV();
        }
    };
    public x.b bM = new x.b() { // from class: com.kwad.components.ad.i.b.4
        @Override // com.kwad.components.core.webview.jshandler.x.b
        public final void a(x.a aVar) {
            b.this.bH = aVar.status;
            com.kwad.sdk.core.e.b.i("PlayEndWebCard", b.this.getName() + "updatePageStatus mPageState: " + aVar + "，targetUrl: " + b.this.Cd);
            if (aVar.isSuccess() && b.this.Cg != null) {
                b.this.Cg.hk();
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void a(b bVar);
    }

    /* renamed from: com.kwad.components.ad.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0592b {
        void hk();
    }

    public b() {
    }

    public b(@Nullable JSONObject jSONObject, @Nullable String str) {
        this.mReportExtData = jSONObject;
        this.Cd = str;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aF() {
        clearJsInterfaceRegister();
        this.bF.getSettings().setAllowFileAccess(true);
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.bF);
        this.mJsInterface = aVar;
        a(aVar);
        this.bF.addJavascriptInterface(this.mJsInterface, "KwaiAd");
    }

    private void aM() {
        int i = this.bH;
        String str = i == -1 ? "timeout" : i != 1 ? "h5error" : AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
        com.kwad.sdk.core.e.b.w("PlayEndWebCard", "show webCard fail, reason: " + str);
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar = this.mJsInterface;
        if (aVar != null) {
            aVar.destroy();
            this.mJsInterface = null;
        }
    }

    public static int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d0473;
    }

    private KsAdWebView.d getWebListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.i.b.1
            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i, String str, String str2) {
                b.this.Cc = false;
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bv() {
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bw() {
                b bVar = b.this;
                bVar.Cc = true;
                bVar.fm();
            }
        };
    }

    private void inflateJsBridgeContext() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.mJsBridgeContext = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.mJsBridgeContext;
        bVar2.mScreenOrientation = this.mScreenOrientation;
        bVar2.agd = this.ct;
        bVar2.Gl = this.bS;
        bVar2.Fv = this.bF;
        bVar2.mReportExtData = this.mReportExtData;
        b(bVar2);
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, @Nullable com.kwad.components.core.c.a.c cVar) {
        a(frameLayout, adBaseFrameLayout, adTemplate, cVar, 0);
    }

    @Deprecated
    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.components.core.c.a.c cVar, int i) {
        this.Cb.add(cVar);
        this.ct = adBaseFrameLayout;
        this.bS = frameLayout;
        this.mScreenOrientation = i;
        this.mAdTemplate = adTemplate;
        fh();
        inflateJsBridgeContext();
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, List<AdTemplate> list, List<com.kwad.components.core.c.a.c> list2, int i) {
        this.Cb = list2;
        this.ct = adBaseFrameLayout;
        this.bS = frameLayout;
        this.mScreenOrientation = i;
        if (list != null && list.size() > 0) {
            this.Ca = list;
            this.mAdTemplate = list.get(0);
        }
        fh();
        inflateJsBridgeContext();
    }

    public final void a(a aVar) {
        this.Cf = aVar;
    }

    public final void a(@Nullable InterfaceC0592b interfaceC0592b) {
        this.Cg = interfaceC0592b;
        this.bS.setVisibility(4);
        this.bH = -1;
        String l = l(this.mAdTemplate);
        com.kwad.sdk.core.e.b.d("PlayEndWebCard", "startPreloadWebView url : " + l);
        if (TextUtils.isEmpty(l)) {
            return;
        }
        aF();
        fl();
        this.bF.loadUrl(l);
    }

    public void a(com.kwad.components.core.webview.a aVar) {
        if (this.Cb.size() <= 1 || this.Ca.size() <= 1) {
            com.kwad.components.core.c.a.c cVar = this.Cb.get(0);
            aVar.a(new i(this.mJsBridgeContext, cVar, this.bJ));
            aVar.a(new f(this.mJsBridgeContext, cVar, this.bJ));
            aVar.a(new ac(this.mJsBridgeContext, cVar));
        } else {
            aVar.a(new i(this.mJsBridgeContext, this.Cb.get(0), this.bJ));
            aVar.a(new f(this.mJsBridgeContext, this.Cb, this.bJ));
            aVar.a(new u(this.Ca, this.Cb));
        }
        ae aeVar = new ae();
        this.uF = aeVar;
        aVar.a(aeVar);
        aVar.a(new l(this.mJsBridgeContext));
        aVar.a(new com.kwad.components.core.webview.b.kwai.c());
        aVar.a(new o(this.mJsBridgeContext));
        aVar.a(new k(this.mJsBridgeContext));
        aVar.a(new x(this.bM, l(this.mAdTemplate)));
        aa aaVar = new aa();
        this.bI = aaVar;
        aVar.a(aaVar);
        aVar.a(new q(this.bL));
        aVar.a(new s(this.mJsBridgeContext));
        c cVar2 = new c();
        cVar2.b(new c.a() { // from class: com.kwad.components.ad.i.b.2
            @Override // com.kwad.components.core.webview.jshandler.c.a
            public final void onPlayAgainClick() {
                if (b.this.Ce != null) {
                    b.this.Ce.onPlayAgainClick();
                }
            }
        });
        aVar.a(cVar2);
    }

    public final void a(c.a aVar) {
        this.Ce = aVar;
    }

    public final void a(com.kwad.sdk.core.webview.a.kwai.a aVar) {
        this.bJ = aVar;
    }

    public final void af(boolean z) {
        this.uF.af(true);
    }

    public final boolean ay() {
        if (!bs()) {
            FrameLayout frameLayout = this.bS;
            if (frameLayout != null) {
                frameLayout.setVisibility(4);
            }
            aM();
            return false;
        }
        aa aaVar = this.bI;
        if (aaVar != null) {
            aaVar.py();
        }
        FrameLayout frameLayout2 = this.bS;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        }
        if (this.bI != null && fi()) {
            this.bI.pz();
        }
        a aVar = this.Cf;
        if (aVar != null) {
            aVar.a(this);
            return true;
        }
        return true;
    }

    public void b(com.kwad.sdk.core.webview.b bVar) {
        bVar.setAdTemplate(this.mAdTemplate);
    }

    public boolean bs() {
        return this.bH == 1;
    }

    public final void bt() {
        clearJsInterfaceRegister();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void fh() {
        this.bS.removeAllViews();
        this.bS.setVisibility(4);
        this.BT = com.kwad.sdk.b.kwai.a.a((ViewGroup) this.bS, getLayoutId(), true);
        KsAdWebView ksAdWebView = (KsAdWebView) this.bS.findViewById(R.id.obfuscated_res_0x7f09140a);
        this.bF = ksAdWebView;
        ksAdWebView.setBackgroundColor(0);
        this.bF.getBackground().setAlpha(0);
        this.bF.setClientConfig(this.bF.getClientConfig().R(this.mAdTemplate).b(getWebListener()));
        fk();
    }

    public boolean fi() {
        return true;
    }

    public void fk() {
    }

    public void fl() {
    }

    public void fm() {
    }

    public final long getLoadTime() {
        KsAdWebView ksAdWebView = this.bF;
        if (ksAdWebView != null) {
            return ksAdWebView.getLoadTime();
        }
        return -1L;
    }

    public String getName() {
        return "PlayEndWebCard";
    }

    public final void kV() {
        if (com.kwad.sdk.b.kwai.a.a((View) this.bF, 50, false)) {
            aa aaVar = this.bI;
            if (aaVar != null) {
                aaVar.pA();
            }
            this.bS.setVisibility(4);
            aa aaVar2 = this.bI;
            if (aaVar2 != null) {
                aaVar2.pB();
            }
        }
    }

    public final FrameLayout kW() {
        return this.bS;
    }

    public String l(AdTemplate adTemplate) {
        String str = this.Cd;
        return str == null ? com.kwad.sdk.core.response.a.b.bb(this.mAdTemplate) : str;
    }

    public final void release() {
        clearJsInterfaceRegister();
        this.Cg = null;
    }
}
