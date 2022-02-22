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
/* loaded from: classes4.dex */
public class g extends Presenter implements View.OnClickListener, com.kwad.sdk.core.g.a, com.kwad.sdk.widget.d {
    public static long a = 400;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f57996b;

    /* renamed from: c  reason: collision with root package name */
    public View f57997c;

    /* renamed from: d  reason: collision with root package name */
    public KsShakeView f57998d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f57999e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.g.b f58000f;

    /* renamed from: g  reason: collision with root package name */
    public Vibrator f58001g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f58002h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.g f58003i;

    /* renamed from: j  reason: collision with root package name */
    public com.kwad.sdk.splashscreen.a f58004j;
    public com.kwad.sdk.splashscreen.e k;

    private void e() {
        TextView textView = this.f57999e;
        if (textView != null) {
            textView.setText(this.k.a());
        }
        KsShakeView ksShakeView = this.f57998d;
        if (ksShakeView != null) {
            ksShakeView.a(this.k.b());
        }
    }

    private void f() {
        if (this.f58003i != null) {
            com.kwad.sdk.splashscreen.a aVar = this.f58004j;
            if (aVar == null) {
                this.f58004j = new com.kwad.sdk.splashscreen.a(this.f57996b) { // from class: com.kwad.sdk.splashscreen.a.g.2
                    @Override // com.kwad.sdk.splashscreen.a
                    @SuppressLint({"SetTextI18n"})
                    public void a(String str) {
                        if (g.this.f57999e != null) {
                            TextView textView = g.this.f57999e;
                            textView.setText("或点击" + str);
                        }
                    }
                };
            } else {
                aVar.a(this.f57996b);
            }
            com.kwad.sdk.core.download.a.b bVar = this.f58003i.f58090g;
            if (bVar != null) {
                bVar.a(this.f58004j);
            }
        }
    }

    private void g() {
        View view = this.f57997c;
        if (view == null || this.f58003i == null) {
            return;
        }
        view.setVisibility(0);
        com.kwad.sdk.core.report.a.c(this.f57996b, 19, null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        Object p = p();
        if (p instanceof com.kwad.sdk.splashscreen.g) {
            this.f58003i = (com.kwad.sdk.splashscreen.g) p;
        }
        com.kwad.sdk.splashscreen.g gVar = this.f58003i;
        if (gVar == null) {
            return;
        }
        AdTemplate adTemplate = gVar.f58087d;
        this.f57996b = adTemplate;
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.k = com.kwad.sdk.splashscreen.e.a(this.f57996b, j2, this.f58003i.f58090g);
        float o = com.kwad.sdk.core.response.a.b.o(this.f57996b);
        com.kwad.sdk.core.g.b bVar = this.f58000f;
        if (bVar == null) {
            com.kwad.sdk.core.g.b bVar2 = new com.kwad.sdk.core.g.b(o);
            this.f58000f = bVar2;
            bVar2.a(this);
        } else {
            bVar.a(o);
        }
        e();
        if (com.kwad.sdk.core.response.a.a.B(j2)) {
            f();
        }
        g();
        this.f58000f.a(q());
        this.f57998d.post(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.g.1
            @Override // java.lang.Runnable
            public void run() {
                g.this.f57998d.a();
            }
        });
        com.kwad.sdk.splashscreen.kwai.a.a(q());
        this.f58002h = com.kwad.sdk.core.response.a.c.g(this.f58003i.f58087d);
        new com.kwad.sdk.widget.f(this.f57998d.getContext(), this.f57998d, this);
    }

    @Override // com.kwad.sdk.core.g.a
    public void a(final double d2) {
        Runnable runnable;
        long j2;
        boolean isShown = this.f57998d.isShown();
        boolean a2 = com.kwad.sdk.core.download.kwai.b.a();
        com.kwad.sdk.core.d.a.a("SplashShakePresenter", "onShakeEvent called isShakeViewShown: " + isShown + ", isDialogShown: " + a2);
        if (!isShown || a2) {
            runnable = new Runnable() { // from class: com.kwad.sdk.splashscreen.a.g.3
                @Override // java.lang.Runnable
                public void run() {
                    g.this.f58000f.a();
                }
            };
            j2 = 500;
        } else {
            this.f57998d.a(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.splashscreen.a.g.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (g.this.f58003i != null) {
                        g.this.f58003i.a(g.this.q(), w0.p0, 2, d2);
                    }
                }
            });
            Vibrator vibrator = this.f58001g;
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
                    g.this.f58000f.a();
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
        if (com.kwad.sdk.core.response.a.b.c(com.kwad.sdk.core.response.a.d.j(this.f57996b)) && (gVar = this.f58003i) != null) {
            gVar.a(q(), 158, 1);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        com.kwad.sdk.splashscreen.g gVar;
        com.kwad.sdk.core.d.a.a("SplashShakePresenter", "onSlide: enableSlickClick: " + this.f58002h);
        if (this.f58002h && (gVar = this.f58003i) != null) {
            gVar.a(view.getContext(), 153, 1);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("SplashShakePresenter", "onUnbind");
        com.kwad.sdk.core.g.b bVar = this.f58000f;
        if (bVar != null) {
            bVar.b(q());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        Context q = q();
        if (q != null) {
            this.f58001g = (Vibrator) q.getSystemService("vibrator");
        }
        this.f57997c = a(R.id.ksad_shake_layout);
        this.f57999e = (TextView) a(R.id.ksad_shake_action);
        KsShakeView ksShakeView = (KsShakeView) a(R.id.ksad_shake_view);
        this.f57998d = ksShakeView;
        ksShakeView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AdTemplate adTemplate;
        com.kwad.sdk.core.d.a.a("SplashShakePresenter", "onClick: " + view);
        if (!view.equals(this.f57998d) || this.f58003i == null || (adTemplate = this.f57996b) == null || !com.kwad.sdk.core.response.a.b.c(com.kwad.sdk.core.response.a.d.j(adTemplate))) {
            return;
        }
        this.f58003i.a(q(), 158, 1);
    }
}
