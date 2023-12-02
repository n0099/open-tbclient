package com.kwad.components.ad.k;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.tieba.R;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.webview.b;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.bb;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.m.l;
import com.kwad.sdk.utils.bn;
import com.kwad.sdk.utils.bq;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    public View HJ;
    public String HL;
    public a HM;
    @Nullable
    public InterfaceC0606b HN;
    public KsAdWebView cL;
    public com.kwad.sdk.core.webview.b cO;
    public aw cQ;
    @Nullable
    public com.kwad.sdk.core.webview.d.a.a cR;
    public AdBaseFrameLayout dB;
    public FrameLayout da;
    public com.kwad.components.core.webview.b fX;
    public AdTemplate mAdTemplate;
    @Nullable
    public JSONObject mReportExtData;
    public bb ys;
    public List<AdTemplate> HH = new ArrayList();
    @NonNull
    public List<c> HI = new ArrayList();
    public int cP = -1;
    public boolean HK = false;
    public com.kwad.components.core.webview.c fY = new com.kwad.components.core.webview.c() { // from class: com.kwad.components.ad.k.b.1
        @Override // com.kwad.components.core.webview.c
        public final void a(aw awVar) {
            b.this.cQ = awVar;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.components.core.webview.a aVar, com.kwad.sdk.core.webview.b bVar) {
            b bVar2 = b.this;
            bVar2.cO = bVar;
            bVar2.b(bVar);
            b.this.a(aVar);
        }

        @Override // com.kwad.components.core.webview.c
        public final void g(int i, String str) {
            b.this.HK = false;
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(aq.a aVar) {
            boolean z;
            b.this.cP = aVar.status;
            com.kwad.sdk.core.e.c.i("PlayEndWebCard", b.this.getName() + "updatePageStatus mPageState: " + aVar + "，targetUrl: " + b.this.HL);
            if (aVar.isSuccess() && b.this.HN != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                b.this.HN.hH();
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(WebCloseStatus webCloseStatus) {
            bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.k.b.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (b.this.HM != null) {
                        b.this.HM.iy();
                    }
                }
            });
        }

        @Override // com.kwad.components.core.webview.c
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (b.this.cR != null) {
                b.this.cR.a(aVar);
            }
        }

        @Override // com.kwad.components.core.webview.c
        public final void onPageFinished() {
            b bVar = b.this;
            bVar.HK = true;
            bVar.fn();
        }
    };
    public ai.b cT = new ai.b() { // from class: com.kwad.components.ad.k.b.2
        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
            b.this.mc();
        }
    };

    /* loaded from: classes10.dex */
    public interface a {
        void iy();
    }

    /* renamed from: com.kwad.components.ad.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0606b {
        void hH();
    }

    public static int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d04b1;
    }

    public boolean fj() {
        return true;
    }

    public void fl() {
    }

    public void fm() {
    }

    public void fn() {
    }

    public String getName() {
        return "PlayEndWebCard";
    }

    public b() {
    }

    private void aH() {
        String str;
        int i = this.cP;
        if (i == -1) {
            str = "timeout";
        } else if (i != 1) {
            str = "h5error";
        } else {
            str = AccountConstants.LOGOUT_TYPE_NATIVE_SRC_OTHERS;
        }
        com.kwad.sdk.core.e.c.w("PlayEndWebCard", "show webCard fail, reason: " + str);
    }

    public final boolean ar() {
        if (bx()) {
            aw awVar = this.cQ;
            if (awVar != null) {
                awVar.sg();
            }
            FrameLayout frameLayout = this.da;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
            if (this.cQ != null && fj()) {
                this.cQ.sh();
                return true;
            }
            return true;
        }
        FrameLayout frameLayout2 = this.da;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(4);
        }
        aH();
        return false;
    }

    public boolean bx() {
        if (this.cP == 1) {
            return true;
        }
        return false;
    }

    public final long getLoadTime() {
        KsAdWebView ksAdWebView = this.cL;
        if (ksAdWebView != null) {
            return ksAdWebView.getLoadTime();
        }
        return -1L;
    }

    public final void lP() {
        com.kwad.components.core.webview.b bVar = this.fX;
        if (bVar != null) {
            bVar.jn();
        }
    }

    public final void mc() {
        if (!bq.a(this.cL, 50, false)) {
            return;
        }
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.si();
        }
        this.da.setVisibility(4);
        aw awVar2 = this.cQ;
        if (awVar2 != null) {
            awVar2.sj();
        }
    }

    public final void release() {
        this.HN = null;
    }

    public b(@Nullable JSONObject jSONObject, @Nullable String str) {
        this.mReportExtData = jSONObject;
        this.HL = str;
    }

    public String B(AdTemplate adTemplate) {
        String str = this.HL;
        if (str == null) {
            return com.kwad.sdk.core.response.b.b.cx(this.mAdTemplate);
        }
        return str;
    }

    public final void ag(boolean z) {
        this.ys.ag(true);
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, @Nullable c cVar) {
        a(frameLayout, adBaseFrameLayout, adTemplate, cVar, 0);
    }

    @Deprecated
    public void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, c cVar, int i) {
        this.HI.add(cVar);
        this.dB = adBaseFrameLayout;
        this.da = frameLayout;
        this.mAdTemplate = adTemplate;
        fi();
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, List<AdTemplate> list, List<c> list2) {
        this.HI = list2;
        this.dB = adBaseFrameLayout;
        this.da = frameLayout;
        if (list != null && list.size() > 0) {
            this.HH = list;
            this.mAdTemplate = list.get(0);
        }
        fi();
    }

    public final void a(a aVar) {
        this.HM = aVar;
    }

    public void b(com.kwad.sdk.core.webview.b bVar) {
        bVar.setAdTemplate(this.mAdTemplate);
    }

    public final void a(@Nullable InterfaceC0606b interfaceC0606b) {
        this.HN = interfaceC0606b;
        this.da.setVisibility(4);
        this.cP = -1;
        String B = B(this.mAdTemplate);
        com.kwad.sdk.core.e.c.d("PlayEndWebCard", "startPreloadWebView url : " + B);
        if (!TextUtils.isEmpty(B) && this.cL != null) {
            fm();
            this.cL.loadUrl(B);
        }
    }

    public void a(com.kwad.components.core.webview.a aVar) {
        if (this.HI.size() > 1 && this.HH.size() > 1) {
            aVar.a(new aa(this.cO, this.HI.get(0), this.cR, (byte) 0));
            aVar.a(new x(this.cO, this.HI, this.cR));
            aVar.a(new am(this.HH, this.HI));
        }
        bb bbVar = new bb();
        this.ys = bbVar;
        aVar.a(bbVar);
        aVar.a(new ai(this.cT));
    }

    public final void a(com.kwad.sdk.core.webview.d.a.a aVar) {
        this.cR = aVar;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void fi() {
        this.da.removeAllViews();
        this.da.setVisibility(4);
        this.HJ = l.inflate(this.da.getContext(), getLayoutId(), this.da);
        KsAdWebView ksAdWebView = (KsAdWebView) this.da.findViewById(R.id.obfuscated_res_0x7f091517);
        this.cL = ksAdWebView;
        if (ksAdWebView != null) {
            boolean z = false;
            ksAdWebView.setBackgroundColor(0);
            this.cL.getBackground().setAlpha(0);
            this.fX = new com.kwad.components.core.webview.b();
            b.a f = new b.a().az(this.mAdTemplate).ay(B(this.mAdTemplate)).d(this.cL).e(this.mReportExtData).k(this.dB).f(this.HI.get(0));
            if (this.HI.size() > 1 && this.HH.size() > 1) {
                z = true;
            }
            this.fX.a(f.aR(z).a(this.fY));
            this.cL.loadUrl(B(this.mAdTemplate));
            fl();
        }
    }
}
