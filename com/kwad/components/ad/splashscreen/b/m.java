package com.kwad.components.ad.splashscreen.b;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.bd;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class m extends e implements com.kwad.components.ad.splashscreen.f {
    public static String TAG = "SplashWebViewPresenter";
    public KsAdWebView bF;
    public AdInfo mAdInfo;
    public com.kwad.sdk.core.webview.b mJsBridgeContext;
    public com.kwad.components.core.webview.a mJsInterface;
    public com.kwad.components.ad.splashscreen.d.b zp;
    public ViewStub zq;
    public volatile boolean zr;
    public Runnable zs = new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.m.1
        @Override // java.lang.Runnable
        public final void run() {
            m.this.kv();
        }
    };

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new ac(this.mJsBridgeContext, this.yF.mApkDownloadHelper));
        aVar.a(da());
        aVar.a(cZ());
        aVar.a(new com.kwad.components.core.webview.jshandler.l(this.mJsBridgeContext));
        aVar.a(new com.kwad.components.core.webview.b.kwai.c());
        aVar.a(new x(new x.b() { // from class: com.kwad.components.ad.splashscreen.b.m.3
            @Override // com.kwad.components.core.webview.jshandler.x.b
            public final void a(x.a aVar2) {
                String str = m.TAG;
                com.kwad.sdk.core.e.b.d(str, "updatePageStatus: " + aVar2);
                if (aVar2.status != 1) {
                    m.this.kv();
                    return;
                }
                bd.c(m.this.zs);
                m.this.ku();
            }
        }, getUrl()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, int i, @Nullable u.b bVar) {
        this.yF.jD();
        int i2 = 0;
        boolean z2 = bVar != null;
        boolean z3 = i == 1;
        com.kwad.components.core.c.a.a.a(new a.C0594a(this.yF.mRootContainer.getContext()).L(this.yF.mAdTemplate).b(this.yF.mApkDownloadHelper).aj(z3).ae(i).a(bVar).al(z2).a(new a.b() { // from class: com.kwad.components.ad.splashscreen.b.m.6
            @Override // com.kwad.components.core.c.a.a.b
            public final void onAdClicked() {
                String jC;
                if (com.kwad.sdk.core.response.a.a.am(com.kwad.sdk.core.response.a.d.bQ(m.this.yF.mAdTemplate)) || (jC = m.this.yF.jC()) == null) {
                    return;
                }
                com.kwad.components.ad.splashscreen.h hVar = m.this.yF;
                hVar.yb = true;
                hVar.mAdTemplate.mMiniWindowId = jC;
            }
        }));
        if (z2) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.yF != null) {
                if (this.yF.yc != null) {
                    jSONObject.put("duration", this.yF.yc.getCurrentPosition());
                }
                if (z) {
                    i2 = 153;
                } else if (z3) {
                    i2 = 132;
                }
                com.kwad.sdk.core.report.a.a(this.yF.mAdTemplate, i2, (aa.a) null, jSONObject);
            }
        } catch (JSONException e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
    }

    private void aE() {
        String url = getUrl();
        String str = TAG;
        com.kwad.sdk.core.e.b.d(str, "startPreloadWebView url: " + url);
        if (ax.dT(url)) {
            kv();
            return;
        }
        this.bF.setVisibility(0);
        inflateJsBridgeContext();
        aF();
        this.bF.setClientConfig(this.bF.getClientConfig().R(this.yF.mAdTemplate).b(getWebErrorListener()));
        this.bF.loadUrl(url);
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

    private com.kwad.components.core.webview.jshandler.f cZ() {
        return new com.kwad.components.core.webview.jshandler.f(this.mJsBridgeContext, this.yF.mApkDownloadHelper, new com.kwad.sdk.core.webview.a.kwai.a() { // from class: com.kwad.components.ad.splashscreen.b.m.4
            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                if (com.kwad.sdk.b.kwai.a.ro()) {
                    return;
                }
                if (aVar.wj() || m.n(m.this.mAdInfo)) {
                    u.b bVar = new u.b();
                    bVar.Mn = aVar.My.Mn;
                    m.this.a(false, aVar.Mx, bVar);
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

    private com.kwad.components.core.webview.jshandler.i da() {
        return new com.kwad.components.core.webview.jshandler.i(this.mJsBridgeContext, this.yF.mApkDownloadHelper, new com.kwad.sdk.core.webview.a.kwai.a() { // from class: com.kwad.components.ad.splashscreen.b.m.5
            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
                if (aVar.Mv || !m.n(m.this.mAdInfo)) {
                    m.this.a(false, aVar.Mv ? 1 : 3, null);
                }
            }
        });
    }

    public static String getUrl() {
        String str = com.kwad.components.ad.splashscreen.a.b.jJ() != null ? com.kwad.components.ad.splashscreen.a.b.jJ().h5Url : "";
        return TextUtils.isEmpty(str) ? "" : str;
    }

    @NonNull
    private KsAdWebView.d getWebErrorListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.splashscreen.b.m.2
            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i, String str, String str2) {
                m.this.kv();
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
        bVar.setAdTemplate(this.yF.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.mJsBridgeContext;
        bVar2.mScreenOrientation = 0;
        AdBaseFrameLayout adBaseFrameLayout = this.yF.mRootContainer;
        bVar2.agd = adBaseFrameLayout;
        bVar2.Gl = adBaseFrameLayout;
        bVar2.Fv = this.bF;
        bVar2.mReportExtData = null;
        bVar2.agf = false;
        bVar2.agg = n(this.mAdInfo);
    }

    private int kw() {
        if (this.yF.fn instanceof SceneImpl) {
            return com.kwad.components.ad.splashscreen.local.d.a(getContext(), this.mAdInfo, (SceneImpl) this.yF.fn);
        }
        return 0;
    }

    public static boolean n(@NonNull AdInfo adInfo) {
        return adInfo.adSplashInfo.fullScreenClickSwitch == 1;
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void aq() {
        super.aq();
        this.bF = (KsAdWebView) this.yF.mRootContainer.findViewById(R.id.obfuscated_res_0x7f091370);
        this.zq = (ViewStub) this.yF.mRootContainer.findViewById(R.id.obfuscated_res_0x7f09135d);
        this.mAdInfo = com.kwad.sdk.core.response.a.d.bQ(this.yF.mAdTemplate);
        com.kwad.components.ad.splashscreen.d.b bVar = new com.kwad.components.ad.splashscreen.d.b((ViewGroup) getRootView(), this.zq, this.bF, com.kwad.sdk.core.response.a.c.bF(this.yF.mAdTemplate), this.yF.mApkDownloadHelper);
        this.zp = bVar;
        bVar.E(this.yF.mAdTemplate);
        this.zp.a(this);
        this.bF.setBackgroundColor(0);
        this.bF.getBackground().setAlpha(0);
        this.bF.setVisibility(0);
        this.zr = false;
        aE();
        bd.a(this.zs, null, 1000L);
    }

    @Override // com.kwad.components.ad.splashscreen.f
    public final void f(boolean z, boolean z2) {
        String str = TAG;
        com.kwad.sdk.core.e.b.d(str, "isClick: " + z + ", isActionBar: " + z2);
        a(!z, z2 ? 1 : 2, null);
    }

    @SuppressLint({"WrongConstant"})
    public final void ku() {
        if (this.zr) {
            return;
        }
        this.zr = true;
        u.b bVar = new u.b();
        u.a aVar = new u.a();
        aVar.aby = kw();
        bVar.abW = aVar;
        com.kwad.sdk.core.report.a.a(this.yF.mAdTemplate, 123, bVar, (JSONObject) null);
    }

    public final void kv() {
        if (this.zp == null) {
            return;
        }
        ku();
        this.zp.kv();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        clearJsInterfaceRegister();
        com.kwad.components.ad.splashscreen.d.b bVar = this.zp;
        if (bVar != null) {
            bVar.onUnbind();
        }
    }
}
