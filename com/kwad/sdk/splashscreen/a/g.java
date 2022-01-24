package com.kwad.sdk.splashscreen.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kuaishou.weapon.un.w0;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.widget.KsShakeView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ax;
/* loaded from: classes3.dex */
public class g extends Presenter implements View.OnClickListener, com.kwad.sdk.core.g.a, com.kwad.sdk.widget.d {
    public static long a = 400;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f57829b;

    /* renamed from: c  reason: collision with root package name */
    public View f57830c;

    /* renamed from: d  reason: collision with root package name */
    public KsShakeView f57831d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f57832e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.g.b f57833f;

    /* renamed from: g  reason: collision with root package name */
    public Vibrator f57834g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57835h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.g f57836i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.a f57837j;
    public com.kwad.sdk.splashscreen.e k;

    private void e() {
        TextView textView = this.f57832e;
        if (textView != null) {
            textView.setText(this.k.a());
        }
        KsShakeView ksShakeView = this.f57831d;
        if (ksShakeView != null) {
            ksShakeView.a(this.k.b());
        }
    }

    private void f() {
        if (this.f57836i != null) {
            com.kwad.sdk.splashscreen.a aVar = this.f57837j;
            if (aVar == null) {
                this.f57837j = new com.kwad.sdk.splashscreen.a(this.f57829b) { // from class: com.kwad.sdk.splashscreen.a.g.2
                    @Override // com.kwad.sdk.splashscreen.a
                    @SuppressLint({"SetTextI18n"})
                    public void a(String str) {
                        if (g.this.f57832e != null) {
                            TextView textView = g.this.f57832e;
                            textView.setText("或点击" + str);
                        }
                    }
                };
            } else {
                aVar.a(this.f57829b);
            }
            com.kwad.sdk.core.download.a.b bVar = this.f57836i.f57923g;
            if (bVar != null) {
                bVar.a(this.f57837j);
            }
        }
    }

    private void g() {
        View view = this.f57830c;
        if (view == null || this.f57836i == null) {
            return;
        }
        view.setVisibility(0);
        com.kwad.sdk.core.report.a.c(this.f57829b, 19, null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        Object p = p();
        if (p instanceof com.kwad.sdk.splashscreen.g) {
            this.f57836i = (com.kwad.sdk.splashscreen.g) p;
        }
        com.kwad.sdk.splashscreen.g gVar = this.f57836i;
        if (gVar == null) {
            return;
        }
        AdTemplate adTemplate = gVar.f57920d;
        this.f57829b = adTemplate;
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.k = com.kwad.sdk.splashscreen.e.a(this.f57829b, j2, this.f57836i.f57923g);
        float o = com.kwad.sdk.core.response.a.b.o(this.f57829b);
        com.kwad.sdk.core.g.b bVar = this.f57833f;
        if (bVar == null) {
            com.kwad.sdk.core.g.b bVar2 = new com.kwad.sdk.core.g.b(o);
            this.f57833f = bVar2;
            bVar2.a(this);
        } else {
            bVar.a(o);
        }
        e();
        if (com.kwad.sdk.core.response.a.a.B(j2)) {
            f();
        }
        g();
        this.f57833f.a(q());
        this.f57831d.post(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.g.1
            @Override // java.lang.Runnable
            public void run() {
                g.this.f57831d.a();
            }
        });
        com.kwad.sdk.splashscreen.kwai.a.a(q());
        this.f57835h = com.kwad.sdk.core.response.a.c.g(this.f57836i.f57920d);
        new com.kwad.sdk.widget.f(this.f57831d.getContext(), this.f57831d, this);
    }

    @Override // com.kwad.sdk.core.g.a
    public void a(final double d2) {
        Runnable runnable;
        long j2;
        boolean isShown = this.f57831d.isShown();
        boolean a2 = com.kwad.sdk.core.download.kwai.b.a();
        com.kwad.sdk.core.d.a.a("SplashShakePresenter", "onShakeEvent called isShakeViewShown: " + isShown + ", isDialogShown: " + a2);
        if (!isShown || a2) {
            runnable = new Runnable() { // from class: com.kwad.sdk.splashscreen.a.g.3
                @Override // java.lang.Runnable
                public void run() {
                    g.this.f57833f.a();
                }
            };
            j2 = 500;
        } else {
            this.f57831d.a(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.splashscreen.a.g.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (g.this.f57836i != null) {
                        g.this.f57836i.a(g.this.q(), w0.p0, 2, d2);
                    }
                }
            });
            Vibrator vibrator = this.f57834g;
            if (vibrator != null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    vibrator.vibrate(VibrationEffect.createOneShot(a, -1));
                } else {
                    vibrator.vibrate(a);
                }
            }
            runnable = new Runnable() { // from class: com.kwad.sdk.splashscreen.a.g.5
                @Override // java.lang.Runnable
                public void run() {
                    g.this.f57833f.a();
                }
            };
            j2 = 700;
        }
        ax.a(runnable, null, j2);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        com.kwad.sdk.splashscreen.g gVar;
        com.kwad.sdk.core.d.a.a("SplashShakePresenter", "onSingleTap: " + view);
        if (com.kwad.sdk.core.response.a.b.c(com.kwad.sdk.core.response.a.d.j(this.f57829b)) && (gVar = this.f57836i) != null) {
            gVar.a(q(), 158, 1);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        com.kwad.sdk.splashscreen.g gVar;
        com.kwad.sdk.core.d.a.a("SplashShakePresenter", "onSlide: enableSlickClick: " + this.f57835h);
        if (this.f57835h && (gVar = this.f57836i) != null) {
            gVar.a(view.getContext(), 153, 1);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("SplashShakePresenter", "onUnbind");
        com.kwad.sdk.core.g.b bVar = this.f57833f;
        if (bVar != null) {
            bVar.b(q());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        Context q = q();
        if (q != null) {
            this.f57834g = (Vibrator) q.getSystemService("vibrator");
        }
        this.f57830c = a(R.id.ksad_shake_layout);
        this.f57832e = (TextView) a(R.id.ksad_shake_action);
        KsShakeView ksShakeView = (KsShakeView) a(R.id.ksad_shake_view);
        this.f57831d = ksShakeView;
        ksShakeView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AdTemplate adTemplate;
        com.kwad.sdk.core.d.a.a("SplashShakePresenter", "onClick: " + view);
        if (!view.equals(this.f57831d) || this.f57836i == null || (adTemplate = this.f57829b) == null || !com.kwad.sdk.core.response.a.b.c(com.kwad.sdk.core.response.a.d.j(adTemplate))) {
            return;
        }
        this.f57836i.a(q(), 158, 1);
    }
}
