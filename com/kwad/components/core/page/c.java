package com.kwad.components.core.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.tieba.R;
import com.kwad.components.ad.a.g;
import com.kwad.components.core.c.kwai.b;
import com.kwad.components.core.kwai.a;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.f;
import com.kwad.components.core.webview.jshandler.i;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
/* loaded from: classes10.dex */
public final class c implements x.b {
    public int FH;
    public LinearLayout FI;
    public TextView FJ;
    public TextView FK;
    public TextView FL;
    public TextView FM;
    public com.kwad.components.core.webview.a.a FN;
    public a FP;
    public aa FQ;
    public boolean FS;
    public boolean FU;
    public z FV;
    public String FW;
    public AdTemplate mAdTemplate;
    public KsAdWebView mAdWebView;
    public Context mContext;
    public com.kwad.sdk.core.webview.b mJsBridgeContext;
    public com.kwad.components.core.webview.a mJsInterface;
    public boolean mNormalMode;
    public com.kwad.components.core.kwai.a mTitleBarHelper;
    public ViewGroup mWebContainer;
    public ImageView mWebTipBarCloseBtn;
    public LinearLayout mWebTipBarLayout;
    public TextView mWebTipBarTitle;
    public ViewGroup zO;
    public Handler mHandler = new Handler(Looper.getMainLooper());
    public boolean counterPaused = true;
    public int FR = -1;
    public boolean FT = false;
    public int FO = com.kwad.sdk.core.config.d.sf();

    /* loaded from: classes10.dex */
    public interface a {
        void onBackBtnClicked(View view2);

        void onCloseBtnClicked(View view2);
    }

    /* loaded from: classes10.dex */
    public static class b {
        public final String FC;
        public final String FD;
        public final boolean FY;
        public final boolean FZ;

        public b(C0644c c0644c) {
            this.FY = c0644c.FY;
            this.FZ = c0644c.FZ;
            this.FD = c0644c.FD;
            this.FC = c0644c.FC;
        }

        public /* synthetic */ b(C0644c c0644c, byte b) {
            this(c0644c);
        }
    }

    /* renamed from: com.kwad.components.core.page.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0644c {
        public String FC;
        public String FD;
        public boolean FY = true;
        public boolean FZ = true;

        public final C0644c aq(String str) {
            this.FC = str;
            return this;
        }

        public final C0644c ar(String str) {
            this.FD = str;
            return this;
        }

        public final C0644c as(boolean z) {
            this.FY = true;
            return this;
        }

        public final C0644c at(boolean z) {
            this.FZ = false;
            return this;
        }

        public final b nI() {
            return new b(this, (byte) 0);
        }
    }

    public c(Context context, AdTemplate adTemplate, int i, boolean z) {
        this.FS = false;
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.FH = i;
        this.FS = z;
        this.zO = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0487, (ViewGroup) null);
    }

    public static void a(WebView webView) {
        webView.getSettings().setAllowFileAccess(true);
    }

    private void a(KsAdWebView ksAdWebView) {
        clearJsInterfaceRegister();
        com.kwad.components.core.webview.a.a aVar = new com.kwad.components.core.webview.a.a(ksAdWebView, this.mJsBridgeContext);
        this.FN = aVar;
        ksAdWebView.addJavascriptInterface(aVar, "KwaiAdForThird");
    }

    private void b(b bVar) {
        com.kwad.components.core.kwai.a aVar;
        if (bVar == null || (aVar = this.mTitleBarHelper) == null) {
            return;
        }
        aVar.ag(bVar.FZ);
        this.mTitleBarHelper.ah(bVar.FY);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void b(KsAdWebView ksAdWebView) {
        clearJsInterfaceRegister();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(ksAdWebView);
        this.mJsInterface = aVar;
        b(aVar);
        ksAdWebView.addJavascriptInterface(this.mJsInterface, "KwaiAd");
    }

    private void b(com.kwad.components.core.webview.a aVar) {
        aa aaVar = new aa();
        this.FQ = aaVar;
        aVar.a(aaVar);
        aVar.a(new x(this, this.FW));
        com.kwad.components.core.c.a.c cVar = new com.kwad.components.core.c.a.c(this.mAdTemplate);
        aVar.a(new i(this.mJsBridgeContext, cVar, getClickListener(), true));
        aVar.a(new f(this.mJsBridgeContext, cVar, getClickListener(), true, 0, false));
        aVar.a(new ac(this.mJsBridgeContext, cVar));
        aVar.a(new p(this.mJsBridgeContext));
        aVar.a(new y(this.mJsBridgeContext));
        aVar.a(new s(this.mJsBridgeContext));
        aVar.a(new l(this.mJsBridgeContext));
        aVar.a(new af(new af.a() { // from class: com.kwad.components.core.page.c.7
            @Override // com.kwad.components.core.webview.jshandler.af.a
            public final void nH() {
                if (com.kwad.sdk.core.response.a.b.bt(c.this.mAdTemplate)) {
                    com.kwad.components.core.c.kwai.b.a(new b.a().ah(c.this.mContext).K(c.this.mAdTemplate).ak(com.kwad.sdk.core.response.a.b.bs(c.this.mAdTemplate)).ms());
                }
            }
        }));
        z zVar = new z();
        this.FV = zVar;
        aVar.a(zVar);
    }

    private void c(b bVar) {
        String bl;
        this.FU = TextUtils.equals(bVar.FD, com.kwad.sdk.core.response.a.a.ar(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate)));
        if (this.mNormalMode) {
            bl = bVar.FC;
        } else {
            List<AdInfo> list = this.mAdTemplate.adInfoList;
            bl = (list == null || list.size() <= 0 || this.mAdTemplate.adInfoList.get(0) == null) ? "详情页面" : com.kwad.sdk.core.response.a.a.bl(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate));
        }
        com.kwad.components.core.kwai.a aVar = new com.kwad.components.core.kwai.a(this.zO);
        this.mTitleBarHelper = aVar;
        aVar.a(new com.kwad.components.core.kwai.b(bl));
        this.mTitleBarHelper.a(new a.InterfaceC0642a() { // from class: com.kwad.components.core.page.c.5
            @Override // com.kwad.components.core.kwai.a.InterfaceC0642a
            public final void r(View view2) {
                if (c.this.mAdWebView == null || !c.this.mAdWebView.canGoBack()) {
                    if (c.this.FP != null) {
                        c.this.FP.onBackBtnClicked(view2);
                        return;
                    }
                    return;
                }
                c.this.mAdWebView.goBack();
                if (c.this.FU) {
                    com.kwad.sdk.core.report.a.ay(c.this.mAdTemplate);
                }
            }

            @Override // com.kwad.components.core.kwai.a.InterfaceC0642a
            public final void s(View view2) {
                if (c.this.mAdWebView == null || !c.this.mAdWebView.canGoBack()) {
                    if (c.this.FP != null) {
                        c.this.FP.onCloseBtnClicked(view2);
                        return;
                    }
                    return;
                }
                c.this.mAdWebView.goBack();
                if (c.this.FU) {
                    com.kwad.sdk.core.report.a.ay(c.this.mAdTemplate);
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
        com.kwad.components.core.webview.a.a aVar2 = this.FN;
        if (aVar2 != null) {
            aVar2.destroy();
            this.FN = null;
        }
    }

    private <T extends View> T findViewById(int i) {
        ViewGroup viewGroup = this.zO;
        if (viewGroup == null) {
            return null;
        }
        return (T) viewGroup.findViewById(i);
    }

    @NonNull
    private com.kwad.sdk.core.webview.a.kwai.a getClickListener() {
        return new com.kwad.sdk.core.webview.a.kwai.a() { // from class: com.kwad.components.core.page.c.8
            @Override // com.kwad.sdk.core.webview.a.kwai.a
            public final void a(com.kwad.sdk.core.webview.a.a.a aVar) {
            }
        };
    }

    @NonNull
    private KsAdWebView.c getOnWebViewScrollChangeListener() {
        return new KsAdWebView.c() { // from class: com.kwad.components.core.page.c.3
            @Override // com.kwad.components.core.webview.KsAdWebView.c
            public final void nu() {
                if (c.this.mNormalMode && c.this.mWebTipBarLayout.getVisibility() == 0) {
                    c.this.mWebTipBarLayout.setVisibility(8);
                }
            }
        };
    }

    public static /* synthetic */ int i(c cVar) {
        int i = cVar.FO;
        cVar.FO = i - 1;
        return i;
    }

    private void inflateJsBridgeContext() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.mJsBridgeContext = bVar;
        bVar.setAdTemplate(this.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.mJsBridgeContext;
        bVar2.mScreenOrientation = 0;
        bVar2.Fv = this.mAdWebView;
        bVar2.Gl = this.mWebContainer;
    }

    private void initTipBarView() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091458);
        this.mWebTipBarLayout = linearLayout;
        if (this.mNormalMode) {
            linearLayout.setVisibility(8);
            return;
        }
        this.mWebTipBarTitle = (TextView) findViewById(R.id.obfuscated_res_0x7f091459);
        ImageView imageView = (ImageView) findViewById(R.id.obfuscated_res_0x7f09145a);
        this.mWebTipBarCloseBtn = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.c.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                c.this.mWebTipBarLayout.setVisibility(8);
            }
        });
        AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate);
        boolean aQ = com.kwad.sdk.core.response.a.a.aQ(bQ);
        String aM = com.kwad.sdk.core.response.a.a.aM(bQ);
        if (!aQ) {
            this.mWebTipBarLayout.setVisibility(8);
            return;
        }
        this.mWebTipBarLayout.setVisibility(0);
        this.mWebTipBarTitle.setText(aM);
        this.mWebTipBarTitle.setSelected(true);
    }

    private void nA() {
        a((WebView) this.mAdWebView);
        this.mAdWebView.setClientConfig(this.mAdWebView.getClientConfig().R(this.mAdTemplate).b(nG()).b(nC()).a(nB()).a(getOnWebViewScrollChangeListener()));
        if (com.kwad.sdk.core.response.a.a.E(com.kwad.sdk.core.response.a.d.bQ(this.mAdTemplate))) {
            inflateJsBridgeContext();
            a(this.mAdWebView);
        } else if (this.FH == 4) {
            this.mAdTemplate.interactLandingPageShowing = true;
            inflateJsBridgeContext();
            b(this.mAdWebView);
        }
        this.mAdWebView.loadUrl(this.FW);
        this.mAdWebView.pp();
    }

    @NonNull
    private KsAdWebView.b nB() {
        return new KsAdWebView.b() { // from class: com.kwad.components.core.page.c.2
            @Override // com.kwad.components.core.webview.KsAdWebView.b
            public final void kU() {
                if (c.this.FV != null) {
                    c.this.FV.kU();
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.b
            public final void onSuccess() {
                if (c.this.FV != null) {
                    c.this.FV.onSuccess();
                }
            }
        };
    }

    private KsAdWebView.d nC() {
        return new KsAdWebView.d() { // from class: com.kwad.components.core.page.c.4
            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i, String str, String str2) {
                c.this.FT = false;
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bv() {
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bw() {
                c.this.FT = true;
                if (c.this.FS) {
                    c.this.show();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nD() {
        this.FK.setText(nE());
        this.FM.setText(nF());
    }

    private String nE() {
        int i = this.FO / 60;
        StringBuilder sb = i >= 10 ? new StringBuilder() : new StringBuilder("0");
        sb.append(i);
        return sb.toString();
    }

    private String nF() {
        int i = this.FO % 60;
        StringBuilder sb = i >= 10 ? new StringBuilder() : new StringBuilder("0");
        sb.append(i);
        return sb.toString();
    }

    private u.b nG() {
        u.b bVar = new u.b();
        bVar.abM = 0;
        bVar.FH = this.FH;
        return bVar;
    }

    private void nz() {
        if (com.kwad.sdk.core.response.a.d.p(this.mAdTemplate)) {
            this.FI.setVisibility(0);
            if (!this.mAdTemplate.mRewardVerifyCalled) {
                nD();
                this.mHandler.postDelayed(new Runnable() { // from class: com.kwad.components.core.page.c.1
                    @Override // java.lang.Runnable
                    @SuppressLint({"SetTextI18n"})
                    public final void run() {
                        if (c.this.counterPaused) {
                            c.this.mHandler.postDelayed(this, 500L);
                            return;
                        }
                        if (c.this.FO <= 0) {
                            c.this.FJ.setText("任务已完成");
                            c.this.FK.setVisibility(8);
                            c.this.FL.setVisibility(8);
                            c.this.FM.setVisibility(8);
                            g gVar = (g) com.kwad.sdk.components.c.f(g.class);
                            if (gVar != null) {
                                gVar.notifyRewardVerify();
                            }
                        } else {
                            c.this.nD();
                            c.this.mHandler.postDelayed(this, 1000L);
                        }
                        c.i(c.this);
                    }
                }, 1000L);
                return;
            }
            this.FJ.setText("任务已完成");
            this.FK.setVisibility(8);
            this.FL.setVisibility(8);
            this.FM.setVisibility(8);
        }
    }

    public final void a(a aVar) {
        this.FP = aVar;
    }

    public final void a(b bVar) {
        if (this.mAdTemplate == null) {
            return;
        }
        this.FW = bVar.FD;
        this.mNormalMode = (TextUtils.isEmpty(bVar.FC) || TextUtils.isEmpty(bVar.FD)) ? false : true;
        this.mAdWebView = (KsAdWebView) findViewById(R.id.obfuscated_res_0x7f09144f);
        this.mWebContainer = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f091302);
        this.FI = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0913a0);
        this.FJ = (TextView) findViewById(R.id.obfuscated_res_0x7f09139d);
        this.FK = (TextView) findViewById(R.id.obfuscated_res_0x7f09139e);
        this.FL = (TextView) findViewById(R.id.obfuscated_res_0x7f09139c);
        this.FM = (TextView) findViewById(R.id.obfuscated_res_0x7f09139f);
        initTipBarView();
        c(bVar);
        nA();
        b(bVar);
        nz();
    }

    @Override // com.kwad.components.core.webview.jshandler.x.b
    public final void a(x.a aVar) {
        this.FR = aVar.status;
    }

    public final void destroy() {
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.onActivityDestroy();
            this.mAdWebView = null;
        }
        if (com.kwad.sdk.core.response.a.d.p(this.mAdTemplate)) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    public final View getRootView() {
        return this.zO;
    }

    public final void hide() {
        aa aaVar = this.FQ;
        if (aaVar != null) {
            aaVar.pA();
        }
        ViewGroup viewGroup = this.zO;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        aa aaVar2 = this.FQ;
        if (aaVar2 != null) {
            aaVar2.pB();
        }
        if (com.kwad.sdk.core.response.a.d.p(this.mAdTemplate)) {
            this.counterPaused = true;
        }
    }

    public final boolean ny() {
        return this.FR == 1;
    }

    public final void show() {
        if (this.FT) {
            aa aaVar = this.FQ;
            if (aaVar != null) {
                aaVar.py();
            }
            try {
                if (this.zO != null) {
                    this.zO.setVisibility(0);
                }
            } catch (Exception e) {
                com.kwad.components.core.b.a.b(e);
            }
            aa aaVar2 = this.FQ;
            if (aaVar2 != null) {
                aaVar2.pz();
            }
            if (com.kwad.sdk.core.response.a.d.p(this.mAdTemplate)) {
                this.counterPaused = false;
            }
        }
    }
}
