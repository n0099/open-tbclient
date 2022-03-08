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
import com.baidu.tieba.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.widget.KsShakeView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ax;
/* loaded from: classes8.dex */
public class g extends Presenter implements View.OnClickListener, com.kwad.sdk.core.g.a, com.kwad.sdk.widget.d {
    public static long a = 400;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f56346b;

    /* renamed from: c  reason: collision with root package name */
    public View f56347c;

    /* renamed from: d  reason: collision with root package name */
    public KsShakeView f56348d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f56349e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.g.b f56350f;

    /* renamed from: g  reason: collision with root package name */
    public Vibrator f56351g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56352h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.g f56353i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.a f56354j;
    public com.kwad.sdk.splashscreen.e k;

    private void e() {
        TextView textView = this.f56349e;
        if (textView != null) {
            textView.setText(this.k.a());
        }
        KsShakeView ksShakeView = this.f56348d;
        if (ksShakeView != null) {
            ksShakeView.a(this.k.b());
        }
    }

    private void f() {
        if (this.f56353i != null) {
            com.kwad.sdk.splashscreen.a aVar = this.f56354j;
            if (aVar == null) {
                this.f56354j = new com.kwad.sdk.splashscreen.a(this.f56346b) { // from class: com.kwad.sdk.splashscreen.a.g.2
                    @Override // com.kwad.sdk.splashscreen.a
                    @SuppressLint({"SetTextI18n"})
                    public void a(String str) {
                        if (g.this.f56349e != null) {
                            TextView textView = g.this.f56349e;
                            textView.setText("或点击" + str);
                        }
                    }
                };
            } else {
                aVar.a(this.f56346b);
            }
            com.kwad.sdk.core.download.a.b bVar = this.f56353i.f56440g;
            if (bVar != null) {
                bVar.a(this.f56354j);
            }
        }
    }

    private void g() {
        View view = this.f56347c;
        if (view == null || this.f56353i == null) {
            return;
        }
        view.setVisibility(0);
        com.kwad.sdk.core.report.a.c(this.f56346b, 19, null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        Object p = p();
        if (p instanceof com.kwad.sdk.splashscreen.g) {
            this.f56353i = (com.kwad.sdk.splashscreen.g) p;
        }
        com.kwad.sdk.splashscreen.g gVar = this.f56353i;
        if (gVar == null) {
            return;
        }
        AdTemplate adTemplate = gVar.f56437d;
        this.f56346b = adTemplate;
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.k = com.kwad.sdk.splashscreen.e.a(this.f56346b, j2, this.f56353i.f56440g);
        float o = com.kwad.sdk.core.response.a.b.o(this.f56346b);
        com.kwad.sdk.core.g.b bVar = this.f56350f;
        if (bVar == null) {
            com.kwad.sdk.core.g.b bVar2 = new com.kwad.sdk.core.g.b(o);
            this.f56350f = bVar2;
            bVar2.a(this);
        } else {
            bVar.a(o);
        }
        e();
        if (com.kwad.sdk.core.response.a.a.B(j2)) {
            f();
        }
        g();
        this.f56350f.a(q());
        this.f56348d.post(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.g.1
            @Override // java.lang.Runnable
            public void run() {
                g.this.f56348d.a();
            }
        });
        com.kwad.sdk.splashscreen.kwai.a.a(q());
        this.f56352h = com.kwad.sdk.core.response.a.c.g(this.f56353i.f56437d);
        new com.kwad.sdk.widget.f(this.f56348d.getContext(), this.f56348d, this);
    }

    @Override // com.kwad.sdk.core.g.a
    public void a(final double d2) {
        Runnable runnable;
        long j2;
        boolean isShown = this.f56348d.isShown();
        boolean a2 = com.kwad.sdk.core.download.kwai.b.a();
        com.kwad.sdk.core.d.a.a("SplashShakePresenter", "onShakeEvent called isShakeViewShown: " + isShown + ", isDialogShown: " + a2);
        if (!isShown || a2) {
            runnable = new Runnable() { // from class: com.kwad.sdk.splashscreen.a.g.3
                @Override // java.lang.Runnable
                public void run() {
                    g.this.f56350f.a();
                }
            };
            j2 = 500;
        } else {
            this.f56348d.a(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.splashscreen.a.g.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (g.this.f56353i != null) {
                        g.this.f56353i.a(g.this.q(), 157, 2, d2);
                    }
                }
            });
            Vibrator vibrator = this.f56351g;
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
                    g.this.f56350f.a();
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
        if (com.kwad.sdk.core.response.a.b.c(com.kwad.sdk.core.response.a.d.j(this.f56346b)) && (gVar = this.f56353i) != null) {
            gVar.a(q(), 158, 1);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        com.kwad.sdk.splashscreen.g gVar;
        com.kwad.sdk.core.d.a.a("SplashShakePresenter", "onSlide: enableSlickClick: " + this.f56352h);
        if (this.f56352h && (gVar = this.f56353i) != null) {
            gVar.a(view.getContext(), 153, 1);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("SplashShakePresenter", "onUnbind");
        com.kwad.sdk.core.g.b bVar = this.f56350f;
        if (bVar != null) {
            bVar.b(q());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        Context q = q();
        if (q != null) {
            this.f56351g = (Vibrator) q.getSystemService("vibrator");
        }
        this.f56347c = a(R.id.ksad_shake_layout);
        this.f56349e = (TextView) a(R.id.ksad_shake_action);
        KsShakeView ksShakeView = (KsShakeView) a(R.id.ksad_shake_view);
        this.f56348d = ksShakeView;
        ksShakeView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AdTemplate adTemplate;
        com.kwad.sdk.core.d.a.a("SplashShakePresenter", "onClick: " + view);
        if (!view.equals(this.f56348d) || this.f56353i == null || (adTemplate = this.f56346b) == null || !com.kwad.sdk.core.response.a.b.c(com.kwad.sdk.core.response.a.d.j(adTemplate))) {
            return;
        }
        this.f56353i.a(q(), 158, 1);
    }
}
