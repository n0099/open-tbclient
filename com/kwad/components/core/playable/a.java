package com.kwad.components.core.playable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.core.c.a.a;
import com.kwad.components.core.c.a.c;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ag;
import com.kwad.components.core.webview.jshandler.b;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public final class a implements b {
    public int FR;
    public final KsAdWebView Hq;
    public long Hr;
    public PlayableSource Hs = PlayableSource.UNKNOWN_TRYPLAY_ENTRY_SOURCE;
    public List<x.b> Ht = new CopyOnWriteArrayList();
    public List<KsAdWebView.d> Hu = new CopyOnWriteArrayList();
    public aa bI;
    @Nullable
    public AdTemplate mAdTemplate;
    public c mApkDownloadHelper;
    public Context mContext;
    @Nullable
    public com.kwad.components.core.webview.a mJsInterface;
    public AdBaseFrameLayout mRootContainer;

    /* renamed from: com.kwad.components.core.playable.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0635a implements ag.b {
        public final WeakReference<a> Hw;

        public C0635a(a aVar) {
            this.Hw = new WeakReference<>(aVar);
        }

        @Override // com.kwad.components.core.webview.jshandler.ag.b
        public final void al(int i) {
            a aVar = this.Hw.get();
            if (aVar != null) {
                aVar.ak(i);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public a(KsAdWebView ksAdWebView) {
        this.Hq = ksAdWebView;
        ksAdWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.playable.a.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    a.this.Hr = SystemClock.elapsedRealtime();
                    return false;
                }
                return false;
            }
        });
        ksAdWebView.setClientConfig(ksAdWebView.getClientConfig().R(this.mAdTemplate).b(getWebListener()));
        c(this.Hq);
    }

    private void a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.webview.a aVar, c cVar) {
        aVar.a(new ag(bVar, cVar, new C0635a(this)));
        aVar.a(new x(new x.b() { // from class: com.kwad.components.core.playable.a.3
            @Override // com.kwad.components.core.webview.jshandler.x.b
            public final void a(x.a aVar2) {
                a.this.FR = aVar2.status;
                if (aVar2.status == 1 && a.this.mAdTemplate != null) {
                    com.kwad.sdk.core.report.a.aC(a.this.mAdTemplate);
                }
                for (x.b bVar2 : a.this.Ht) {
                    bVar2.a(aVar2);
                }
            }
        }, getUrl()));
        aVar.a(new s(bVar));
        this.bI = new aa();
        aVar.a(new n());
        aVar.a(new m(bVar));
        aVar.a(new com.kwad.components.core.webview.b.kwai.c());
        aVar.a(this.bI);
        aVar.a(new com.kwad.components.core.webview.jshandler.a(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ak(int i) {
        if (getAdTemplate() == null) {
            return;
        }
        long so = d.so();
        if (so <= 0 || SystemClock.elapsedRealtime() - this.Hr <= so) {
            u.b bVar = new u.b();
            bVar.gJ = i;
            bVar.gL = this.mRootContainer.getTouchCoords();
            com.kwad.components.core.c.a.a.a(new a.C0625a(this.mContext).L(this.mAdTemplate).b(this.mApkDownloadHelper).aj(false).a(bVar).al(true));
        }
    }

    public static void c(KsAdWebView ksAdWebView) {
        if (Build.VERSION.SDK_INT < 17 || !d.sn()) {
            return;
        }
        ksAdWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
    }

    private void clearJsInterfaceRegister() {
        com.kwad.components.core.webview.a aVar = this.mJsInterface;
        if (aVar != null) {
            aVar.destroy();
            this.mJsInterface = null;
        }
    }

    @Nullable
    private AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    private String getUrl() {
        AdTemplate adTemplate = this.mAdTemplate;
        return adTemplate == null ? "" : com.kwad.sdk.core.response.a.a.bc(com.kwad.sdk.core.response.a.d.bQ(adTemplate));
    }

    private KsAdWebView.d getWebListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.core.playable.a.2
            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i, String str, String str2) {
                for (KsAdWebView.d dVar : a.this.Hu) {
                    dVar.a(i, str, str2);
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bv() {
                for (KsAdWebView.d dVar : a.this.Hu) {
                    dVar.bv();
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bw() {
                for (KsAdWebView.d dVar : a.this.Hu) {
                    dVar.bw();
                }
            }
        };
    }

    public final void a(@Nullable KsAdWebView.d dVar) {
        this.Hu.add(dVar);
    }

    @Override // com.kwad.components.core.webview.jshandler.b
    public final void a(com.kwad.components.core.webview.jshandler.a aVar, String str) {
        AdTemplate adTemplate;
        if ("playableSrc".equals(str)) {
            aVar.f(this.Hs);
        }
        if (!"getAdType".equals(str) || (adTemplate = this.mAdTemplate) == null) {
            return;
        }
        aVar.as(adTemplate.adStyle);
    }

    public final void a(@Nullable x.b bVar) {
        this.Ht.add(bVar);
    }

    @SuppressLint({"AddJavascriptInterface"})
    public final void a(AdTemplate adTemplate, AdBaseFrameLayout adBaseFrameLayout, c cVar) {
        if (this.Hq == null) {
            com.kwad.sdk.core.e.b.w("PlayableViewHelper", "registerJsBridge mPlayableView is null");
            return;
        }
        this.mContext = adBaseFrameLayout.getContext();
        this.mRootContainer = adBaseFrameLayout;
        this.mAdTemplate = adTemplate;
        this.mApkDownloadHelper = cVar;
        this.FR = -1;
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        bVar.setAdTemplate(adTemplate);
        bVar.mScreenOrientation = 0;
        AdBaseFrameLayout adBaseFrameLayout2 = this.mRootContainer;
        bVar.agd = adBaseFrameLayout2;
        bVar.Gl = adBaseFrameLayout2;
        bVar.Fv = this.Hq;
        clearJsInterfaceRegister();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.Hq);
        this.mJsInterface = aVar;
        a(bVar, aVar, cVar);
        this.Hq.addJavascriptInterface(this.mJsInterface, "KwaiAd");
    }

    public final void b(@Nullable x.b bVar) {
        this.Ht.remove(bVar);
    }

    public final void e(PlayableSource playableSource) {
        if (playableSource != null) {
            this.Hs = playableSource;
        }
        if (this.Hq == null) {
            return;
        }
        com.kwad.sdk.core.e.b.d("PlayableViewHelper", "showPlayable");
        aa aaVar = this.bI;
        if (aaVar != null) {
            aaVar.py();
        }
        this.Hq.setVisibility(0);
        aa aaVar2 = this.bI;
        if (aaVar2 != null) {
            aaVar2.pz();
        }
    }

    public final long getLoadTime() {
        KsAdWebView ksAdWebView = this.Hq;
        if (ksAdWebView != null) {
            return ksAdWebView.getLoadTime();
        }
        return -1L;
    }

    public final void ha() {
        com.kwad.sdk.core.e.b.d("PlayableViewHelper", "showPlayable");
        if (this.Hq == null) {
            return;
        }
        aa aaVar = this.bI;
        if (aaVar != null) {
            aaVar.pA();
        }
        this.Hq.setVisibility(8);
        aa aaVar2 = this.bI;
        if (aaVar2 != null) {
            aaVar2.pB();
        }
        this.Hq.reload();
    }

    public final void ob() {
        com.kwad.components.core.webview.a aVar = this.mJsInterface;
        if (aVar != null) {
            aVar.destroy();
            this.mJsInterface = null;
        }
    }

    public final void oc() {
        if (this.mAdTemplate == null || this.Hq == null) {
            return;
        }
        String url = getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.Hq.loadUrl(url);
        }
        com.kwad.sdk.core.report.a.aD(this.mAdTemplate);
    }

    public final boolean od() {
        return this.Hq != null && this.FR == 1;
    }
}
