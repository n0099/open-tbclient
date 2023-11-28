package com.kwad.components.ad.k;

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
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.a.c;
/* loaded from: classes10.dex */
public final class a {
    public InterfaceC0604a HA;
    public c.a HE;
    public b HF;
    public KsAdWebView Hw;
    public boolean Hx;
    public boolean Hy;
    public AdBaseFrameLayout Hz;
    @Nullable
    public com.kwad.sdk.core.webview.d.a.a cR;
    public AdBaseFrameLayout dB;
    public FrameLayout da;
    public Activity mActivity;
    public AdTemplate mAdTemplate;
    public ImageView mBackIcon;
    public long mLastDown;
    public boolean Hv = true;
    public Handler fS = new Handler(Looper.getMainLooper());
    public boolean HB = false;
    public boolean HC = false;
    public boolean HD = false;

    /* renamed from: com.kwad.components.ad.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0604a {
        void R(boolean z);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void it();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bx() {
        if (this.HD) {
            if (!this.Hv) {
                return true;
            }
            return false;
        } else if (!this.Hv && !this.HB && !this.HC) {
            return true;
        } else {
            return false;
        }
    }

    private KsAdWebView.d ih() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.k.a.3
            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                if (a.this.HA != null) {
                    a.this.HA.R(a.this.bx());
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i, String str, String str2) {
                a.b(a.this, true);
                if (a.this.HA != null) {
                    a.this.HA.R(a.this.bx());
                }
            }
        };
    }

    private KsAdWebView.b ma() {
        return new KsAdWebView.b() { // from class: com.kwad.components.ad.k.a.4
            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                a.c(a.this, true);
                if (a.this.HA != null) {
                    a.this.HA.R(a.this.bx());
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                a.c(a.this, true);
                if (a.this.HA != null) {
                    a.this.HA.R(a.this.bx());
                }
            }
        };
    }

    private boolean mb() {
        if (bx()) {
            FrameLayout frameLayout = this.da;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
                return true;
            }
            return true;
        }
        FrameLayout frameLayout2 = this.da;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
        return false;
    }

    public final void ay() {
        this.da.setVisibility(4);
        String B = B(this.mAdTemplate);
        if (TextUtils.isEmpty(B)) {
            return;
        }
        this.Hw.loadUrl(B);
    }

    public static String B(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.a.aS(e.dP(adTemplate));
    }

    public final a af(boolean z) {
        this.Hy = true;
        return this;
    }

    public final void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    public static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.Hv = true;
        return true;
    }

    public static /* synthetic */ boolean c(a aVar, boolean z) {
        aVar.HB = true;
        return true;
    }

    public static /* synthetic */ boolean d(a aVar, boolean z) {
        aVar.Hx = true;
        return true;
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.HC = true;
        return true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void fi() {
        this.da.removeAllViews();
        this.da.setVisibility(4);
        this.Hz = (AdBaseFrameLayout) ((ViewGroup) com.kwad.sdk.d.a.a.a((ViewGroup) this.da, (int) R.layout.obfuscated_res_0x7f0d04b0, true)).findViewById(R.id.obfuscated_res_0x7f091515);
        KsAdWebView ksAdWebView = (KsAdWebView) this.da.findViewById(R.id.obfuscated_res_0x7f091516);
        this.Hw = ksAdWebView;
        ksAdWebView.setBackgroundColor(-1);
        y.b bVar = new y.b();
        bVar.axA = 1;
        c.a b2 = this.Hw.getClientConfig().bt(false).bv(true).bu(false).b(bVar).eh(this.mAdTemplate).a(ma()).b(ih());
        this.HE = b2;
        this.Hw.setClientConfig(b2);
        this.Hw.setDownloadListener(new DownloadListener() { // from class: com.kwad.components.ad.k.a.1
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                a.a(a.this, true);
                if (a.this.HA != null) {
                    a.this.HA.R(a.this.bx());
                }
            }
        });
        ImageView imageView = (ImageView) this.Hz.findViewById(R.id.obfuscated_res_0x7f09135d);
        this.mBackIcon = imageView;
        imageView.setVisibility(8);
        this.mBackIcon.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.k.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (a.this.HF != null) {
                    a.this.HF.it();
                }
            }
        });
    }

    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate) {
        this.da = frameLayout;
        this.dB = adBaseFrameLayout;
        this.mAdTemplate = adTemplate;
        fi();
        this.Hv = false;
    }

    public final void a(InterfaceC0604a interfaceC0604a) {
        this.HA = interfaceC0604a;
    }

    public final void a(b bVar) {
        this.HF = bVar;
    }

    public final void a(com.kwad.sdk.core.webview.d.a.a aVar) {
        this.cR = aVar;
    }

    public final boolean ar() {
        boolean mb = mb();
        this.HD = true;
        if (mb && this.mActivity != null) {
            if (this.Hw.getClientConfig() != null) {
                this.Hw.getClientConfig().bt(true);
                this.Hw.getClientConfig().bu(true);
            }
            this.Hz.a(new View.OnTouchListener() { // from class: com.kwad.components.ad.k.a.5
                @Override // android.view.View.OnTouchListener
                @SuppressLint({"ClickableViewAccessibility"})
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (motionEvent.getX() > a.this.mBackIcon.getX() && motionEvent.getX() - a.this.mBackIcon.getX() < a.this.mBackIcon.getWidth() && motionEvent.getY() > a.this.mBackIcon.getY() && motionEvent.getY() - a.this.mBackIcon.getY() < a.this.mBackIcon.getHeight()) {
                        com.kwad.sdk.core.e.c.d("LandingPageWebCard", "onClick backIcon");
                        return false;
                    }
                    if (motionEvent.getAction() == 0) {
                        a.this.mLastDown = SystemClock.elapsedRealtime();
                    } else if (motionEvent.getAction() == 1) {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.mLastDown;
                        if (a.this.mLastDown > 0 && elapsedRealtime > 30 && elapsedRealtime < 500) {
                            com.kwad.sdk.core.report.a.a(a.this.mAdTemplate, 155, a.this.dB.getTouchCoords());
                            if (!a.this.Hx) {
                                a.d(a.this, true);
                                if (a.this.cR != null) {
                                    com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
                                    aVar.Xn = 3;
                                    a.this.cR.a(aVar);
                                }
                            }
                        }
                        a.this.mLastDown = 0L;
                    }
                    return false;
                }
            });
            long am = com.kwad.sdk.core.response.b.a.am(e.dP(this.mAdTemplate));
            if (am != 0 && this.Hy) {
                this.fS.postDelayed(new Runnable() { // from class: com.kwad.components.ad.k.a.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (a.this.mActivity != null && !a.this.mActivity.isFinishing()) {
                            a.this.mBackIcon.setVisibility(0);
                            a.this.mBackIcon.setAlpha(0.0f);
                            a.this.mBackIcon.animate().alpha(1.0f).setDuration(500L).start();
                        }
                    }
                }, am);
            } else {
                this.mBackIcon.setVisibility(0);
            }
            KsAdWebView ksAdWebView = this.Hw;
            if (ksAdWebView != null) {
                ksAdWebView.onActivityCreate();
            }
        }
        return mb;
    }
}
