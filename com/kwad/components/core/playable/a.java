package com.kwad.components.core.playable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.e.d.c;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.be;
import com.kwad.components.core.webview.jshandler.h;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.tachikoma.a.f;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.b;
import com.kwad.sdk.utils.bn;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public final class a implements n {
    public final KsAdWebView QC;
    public long QD;
    public int QE;
    public PlayableSource QF = PlayableSource.UNKNOWN_TRYPLAY_ENTRY_SOURCE;
    public List<aq.b> QG = new CopyOnWriteArrayList();
    public List<KsAdWebView.d> QH = new CopyOnWriteArrayList();
    @Nullable
    public com.kwad.components.core.webview.a cN;
    public aw cQ;
    @Nullable
    public AdTemplate mAdTemplate;
    public c mApkDownloadHelper;
    public Context mContext;
    public AdBaseFrameLayout mRootContainer;

    /* renamed from: com.kwad.components.core.playable.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0659a implements be.b {
        public final WeakReference<a> QJ;

        public C0659a(a aVar) {
            this.QJ = new WeakReference<>(aVar);
        }

        @Override // com.kwad.components.core.webview.jshandler.be.b
        public final void Q(int i) {
            a aVar = this.QJ.get();
            if (aVar == null) {
                return;
            }
            aVar.ay(i);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public a(KsAdWebView ksAdWebView) {
        this.QC = ksAdWebView;
        ksAdWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.playable.a.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    a.this.QD = SystemClock.elapsedRealtime();
                    a.this.QC.getClientConfig().bt(true);
                    return false;
                }
                return false;
            }
        });
        ksAdWebView.setClientConfig(ksAdWebView.getClientConfig().eh(this.mAdTemplate).b(ih()));
        a(this.QC);
    }

    public final void e(PlayableSource playableSource) {
        if (playableSource != null) {
            this.QF = playableSource;
        }
        if (this.QC == null) {
            return;
        }
        pt();
        com.kwad.sdk.core.e.c.d("PlayableViewHelper", "showPlayable");
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.sg();
        }
        this.QC.setVisibility(0);
        aw awVar2 = this.cQ;
        if (awVar2 != null) {
            awVar2.sh();
        }
    }

    public static void a(KsAdWebView ksAdWebView) {
        if (Build.VERSION.SDK_INT >= 17 && d.Bf()) {
            ksAdWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
    }

    public final void b(@Nullable aq.b bVar) {
        this.QG.remove(bVar);
    }

    private void a(b bVar, com.kwad.components.core.webview.a aVar, c cVar) {
        aVar.a(new be(bVar, cVar, new C0659a(this)));
        aVar.a(new aq(new aq.b() { // from class: com.kwad.components.core.playable.a.3
            @Override // com.kwad.components.core.webview.jshandler.aq.b
            public final void a(aq.a aVar2) {
                a.this.QE = aVar2.status;
                if (aVar2.status == 1 && a.this.mAdTemplate != null) {
                    com.kwad.sdk.core.report.a.bS(a.this.mAdTemplate);
                }
                for (aq.b bVar2 : a.this.QG) {
                    bVar2.a(aVar2);
                }
            }
        }, getUrl()));
        aVar.a(new ak(bVar));
        aVar.b(new m(bVar));
        aVar.b(new l(bVar));
        this.cQ = new aw();
        aVar.a(new af());
        aVar.a(new ae(bVar));
        aVar.a(new f());
        aVar.a(this.cQ);
        aVar.a(new h(this));
    }

    private void aA() {
        com.kwad.components.core.webview.a aVar = this.cN;
        if (aVar != null) {
            aVar.destroy();
            this.cN = null;
        }
    }

    @Nullable
    private AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    private String getUrl() {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate == null) {
            return "";
        }
        return com.kwad.sdk.core.response.b.a.bN(e.dP(adTemplate));
    }

    private KsAdWebView.d ih() {
        return new KsAdWebView.d() { // from class: com.kwad.components.core.playable.a.2
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                for (KsAdWebView.d dVar : a.this.QH) {
                    dVar.onPageFinished();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
                for (KsAdWebView.d dVar : a.this.QH) {
                    dVar.onPageStart();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i, String str, String str2) {
                for (KsAdWebView.d dVar : a.this.QH) {
                    dVar.onReceivedHttpError(i, str, str2);
                }
            }
        };
    }

    public final long getLoadTime() {
        KsAdWebView ksAdWebView = this.QC;
        if (ksAdWebView != null) {
            return ksAdWebView.getLoadTime();
        }
        return -1L;
    }

    public final void hx() {
        com.kwad.sdk.core.e.c.d("PlayableViewHelper", "showPlayable");
        if (this.QC == null) {
            return;
        }
        aw awVar = this.cQ;
        if (awVar != null) {
            awVar.si();
        }
        this.QC.setVisibility(8);
        aw awVar2 = this.cQ;
        if (awVar2 != null) {
            awVar2.sj();
        }
        this.QC.reload();
    }

    public final void pS() {
        com.kwad.components.core.webview.a aVar = this.cN;
        if (aVar != null) {
            aVar.destroy();
            this.cN = null;
        }
    }

    public final void pT() {
        KsAdWebView ksAdWebView;
        if (this.mAdTemplate != null && (ksAdWebView = this.QC) != null) {
            ksAdWebView.getClientConfig().bt(false);
            String url = getUrl();
            if (!TextUtils.isEmpty(url)) {
                this.QC.loadUrl(url);
            }
            com.kwad.sdk.core.report.a.bT(this.mAdTemplate);
        }
    }

    public final boolean pU() {
        if (this.QC != null && this.QE == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ay(int i) {
        if (getAdTemplate() == null) {
            return;
        }
        long Bg = d.Bg();
        if (Bg > 0 && SystemClock.elapsedRealtime() - this.QD > Bg) {
            return;
        }
        y.b bVar = new y.b();
        bVar.kk = i;
        bVar.km = this.mRootContainer.getTouchCoords();
        com.kwad.components.core.e.d.a.a(new a.C0644a(this.mContext).aq(this.mAdTemplate).b(this.mApkDownloadHelper).ao(false).a(bVar).aq(true));
    }

    private void pt() {
        if (com.kwad.sdk.core.response.b.a.bJ(e.dP(this.mAdTemplate)) > 0) {
            bn.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.playable.a.4
                @Override // java.lang.Runnable
                @SuppressLint({"SetTextI18n"})
                public final void run() {
                    a.this.QC.getClientConfig().bt(true);
                }
            }, com.kwad.sdk.core.response.b.a.bJ(e.dP(this.mAdTemplate)));
        }
        if (com.kwad.sdk.core.response.b.a.bJ(e.dP(this.mAdTemplate)) == 0) {
            this.QC.getClientConfig().bt(true);
        }
    }

    public final void a(@Nullable aq.b bVar) {
        this.QG.add(bVar);
    }

    @Override // com.kwad.components.core.webview.jshandler.n
    public final void a(h hVar, String str) {
        AdTemplate adTemplate;
        if ("playableSrc".equals(str)) {
            hVar.f(this.QF);
        }
        if ("getAdType".equals(str) && (adTemplate = this.mAdTemplate) != null) {
            hVar.aJ(adTemplate.adStyle);
        }
    }

    @SuppressLint({"AddJavascriptInterface"})
    public final void a(AdTemplate adTemplate, AdBaseFrameLayout adBaseFrameLayout, c cVar) {
        if (this.QC == null) {
            com.kwad.sdk.core.e.c.w("PlayableViewHelper", "registerJsBridge mPlayableView is null");
            return;
        }
        this.mContext = adBaseFrameLayout.getContext();
        this.mRootContainer = adBaseFrameLayout;
        this.mAdTemplate = adTemplate;
        this.mApkDownloadHelper = cVar;
        this.QE = -1;
        b bVar = new b();
        bVar.setAdTemplate(adTemplate);
        bVar.mScreenOrientation = 0;
        AdBaseFrameLayout adBaseFrameLayout2 = this.mRootContainer;
        bVar.aCG = adBaseFrameLayout2;
        bVar.Ov = adBaseFrameLayout2;
        bVar.NP = this.QC;
        aA();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.QC);
        this.cN = aVar;
        a(bVar, aVar, cVar);
        this.QC.addJavascriptInterface(this.cN, "KwaiAd");
    }

    public final void a(@Nullable KsAdWebView.d dVar) {
        this.QH.add(dVar);
    }
}
