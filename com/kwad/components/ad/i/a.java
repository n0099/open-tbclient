package com.kwad.components.ad.i;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.kwad.components.core.webview.KsAdWebView;
import com.kwad.components.core.webview.kwai.c;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
/* loaded from: classes10.dex */
public final class a {
    public KsAdWebView BQ;
    public boolean BR;
    public boolean BS;
    public View BT;
    public InterfaceC0608a BU;
    public b BY;
    @Nullable
    public com.kwad.sdk.core.webview.a.kwai.a bJ;
    public FrameLayout bS;
    public AdBaseFrameLayout ct;
    public c.a gX;
    public Activity mActivity;
    public AdTemplate mAdTemplate;
    public ImageView mBackIcon;
    public long mLastDown;
    public boolean BP = true;
    public Handler mHandler = new Handler(Looper.getMainLooper());
    public boolean BV = false;
    public boolean BW = false;
    public boolean BX = false;

    /* renamed from: com.kwad.components.ad.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0608a {
        void V(boolean z);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void hI();
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.BW = true;
        return true;
    }

    public static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.BP = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bs() {
        return this.BX ? !this.BP : (this.BP || this.BV || this.BW) ? false : true;
    }

    public static /* synthetic */ boolean c(a aVar, boolean z) {
        aVar.BV = true;
        return true;
    }

    public static /* synthetic */ boolean d(a aVar, boolean z) {
        aVar.BR = true;
        return true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void fh() {
        this.bS.removeAllViews();
        this.bS.setVisibility(4);
        this.BT = com.kwad.sdk.b.kwai.a.a((ViewGroup) this.bS, getLayoutId(), true);
        KsAdWebView ksAdWebView = (KsAdWebView) this.bS.findViewById(R.id.obfuscated_res_0x7f09145c);
        this.BQ = ksAdWebView;
        ksAdWebView.setBackgroundColor(-1);
        u.b bVar = new u.b();
        bVar.abM = 1;
        c.a b2 = this.BQ.getClientConfig().aA(false).aB(false).b(bVar).R(this.mAdTemplate).a(kS()).b(getWebListener());
        this.gX = b2;
        this.BQ.setClientConfig(b2);
        this.BQ.setDownloadListener(new DownloadListener() { // from class: com.kwad.components.ad.i.a.1
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                a.a(a.this, true);
                if (a.this.BU != null) {
                    a.this.BU.V(a.this.bs());
                }
            }
        });
        ImageView imageView = (ImageView) this.BT.findViewById(R.id.obfuscated_res_0x7f0912cb);
        this.mBackIcon = imageView;
        imageView.setVisibility(8);
        this.mBackIcon.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.i.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (a.this.BY != null) {
                    a.this.BY.hI();
                }
            }
        });
    }

    public static int getLayoutId() {
        return R.layout.obfuscated_res_0x7f0d0488;
    }

    private KsAdWebView.d getWebListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.i.a.3
            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void a(int i, String str, String str2) {
                a.b(a.this, true);
                if (a.this.BU != null) {
                    a.this.BU.V(a.this.bs());
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bv() {
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.d
            public final void bw() {
                if (a.this.BU != null) {
                    a.this.BU.V(a.this.bs());
                }
            }
        };
    }

    private KsAdWebView.b kS() {
        return new KsAdWebView.b() { // from class: com.kwad.components.ad.i.a.4
            @Override // com.kwad.components.core.webview.KsAdWebView.b
            public final void kU() {
                a.c(a.this, true);
                if (a.this.BU != null) {
                    a.this.BU.V(a.this.bs());
                }
            }

            @Override // com.kwad.components.core.webview.KsAdWebView.b
            public final void onSuccess() {
                a.c(a.this, true);
                if (a.this.BU != null) {
                    a.this.BU.V(a.this.bs());
                }
            }
        };
    }

    private boolean kT() {
        if (!bs()) {
            FrameLayout frameLayout = this.bS;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            return false;
        }
        FrameLayout frameLayout2 = this.bS;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
            return true;
        }
        return true;
    }

    public static String l(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.a.ar(d.bQ(adTemplate));
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate) {
        this.bS = frameLayout;
        this.ct = adBaseFrameLayout;
        this.mAdTemplate = adTemplate;
        fh();
        this.BP = false;
    }

    public final void a(InterfaceC0608a interfaceC0608a) {
        this.BU = interfaceC0608a;
    }

    public final void a(b bVar) {
        this.BY = bVar;
    }

    public final void a(com.kwad.sdk.core.webview.a.kwai.a aVar) {
        this.bJ = aVar;
    }

    public final void aE() {
        this.bS.setVisibility(4);
        String l = l(this.mAdTemplate);
        if (TextUtils.isEmpty(l)) {
            return;
        }
        this.BQ.loadUrl(l);
    }

    public final a ae(boolean z) {
        this.BS = z;
        return this;
    }

    public final boolean ay() {
        boolean kT = kT();
        this.BX = true;
        if (kT && this.mActivity != null) {
            if (this.BQ.getClientConfig() != null) {
                this.BQ.getClientConfig().aA(true);
                this.BQ.getClientConfig().aB(true);
            }
            this.ct.a(new View.OnTouchListener() { // from class: com.kwad.components.ad.i.a.5
                @Override // android.view.View.OnTouchListener
                @SuppressLint({"ClickableViewAccessibility"})
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (motionEvent.getX() > a.this.mBackIcon.getX() && motionEvent.getX() - a.this.mBackIcon.getX() < a.this.mBackIcon.getWidth() && motionEvent.getY() > a.this.mBackIcon.getY() && motionEvent.getY() - a.this.mBackIcon.getY() < a.this.mBackIcon.getHeight()) {
                        com.kwad.sdk.core.e.b.d("LandingPageWebCard", "onClick backIcon");
                        return false;
                    }
                    if (motionEvent.getAction() == 0) {
                        a.this.mLastDown = SystemClock.elapsedRealtime();
                    } else if (motionEvent.getAction() == 1) {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.mLastDown;
                        if (a.this.mLastDown > 0 && elapsedRealtime > 30 && elapsedRealtime < 500) {
                            com.kwad.sdk.core.report.a.a(a.this.mAdTemplate, 155, a.this.ct.getTouchCoords());
                            if (!a.this.BR) {
                                a.d(a.this, true);
                                if (a.this.bJ != null) {
                                    com.kwad.sdk.core.webview.a.a.a aVar = new com.kwad.sdk.core.webview.a.a.a();
                                    aVar.Mx = 3;
                                    a.this.bJ.a(aVar);
                                }
                            }
                        }
                        a.this.mLastDown = 0L;
                    }
                    return false;
                }
            });
            long X = com.kwad.sdk.core.response.a.a.X(d.bQ(this.mAdTemplate));
            if (X == 0 || !this.BS) {
                this.mBackIcon.setVisibility(0);
            } else {
                this.mHandler.postDelayed(new Runnable() { // from class: com.kwad.components.ad.i.a.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (a.this.mActivity == null || a.this.mActivity.isFinishing()) {
                            return;
                        }
                        a.this.mBackIcon.setVisibility(0);
                        a.this.mBackIcon.setAlpha(0.0f);
                        a.this.mBackIcon.animate().alpha(1.0f).setDuration(500L).start();
                    }
                }, X);
            }
            KsAdWebView ksAdWebView = this.BQ;
            if (ksAdWebView != null) {
                ksAdWebView.pp();
            }
        }
        return kT;
    }

    public final void setActivity(Activity activity) {
        this.mActivity = activity;
    }
}
