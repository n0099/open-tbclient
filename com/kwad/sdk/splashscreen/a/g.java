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
/* loaded from: classes7.dex */
public class g extends Presenter implements View.OnClickListener, com.kwad.sdk.core.g.a, com.kwad.sdk.widget.d {
    public static long a = 400;

    /* renamed from: b  reason: collision with root package name */
    public AdTemplate f41252b;

    /* renamed from: c  reason: collision with root package name */
    public View f41253c;

    /* renamed from: d  reason: collision with root package name */
    public KsShakeView f41254d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f41255e;

    /* renamed from: f  reason: collision with root package name */
    public com.kwad.sdk.core.g.b f41256f;

    /* renamed from: g  reason: collision with root package name */
    public Vibrator f41257g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f41258h;
    @Nullable
    public com.kwad.sdk.splashscreen.g i;
    public com.kwad.sdk.splashscreen.a j;
    public com.kwad.sdk.splashscreen.e k;

    private void e() {
        TextView textView = this.f41255e;
        if (textView != null) {
            textView.setText(this.k.a());
        }
        KsShakeView ksShakeView = this.f41254d;
        if (ksShakeView != null) {
            ksShakeView.a(this.k.b());
        }
    }

    private void f() {
        if (this.i != null) {
            com.kwad.sdk.splashscreen.a aVar = this.j;
            if (aVar == null) {
                this.j = new com.kwad.sdk.splashscreen.a(this.f41252b) { // from class: com.kwad.sdk.splashscreen.a.g.2
                    @Override // com.kwad.sdk.splashscreen.a
                    @SuppressLint({"SetTextI18n"})
                    public void a(String str) {
                        if (g.this.f41255e != null) {
                            TextView textView = g.this.f41255e;
                            textView.setText("或点击" + str);
                        }
                    }
                };
            } else {
                aVar.a(this.f41252b);
            }
            com.kwad.sdk.core.download.a.b bVar = this.i.f41333g;
            if (bVar != null) {
                bVar.a(this.j);
            }
        }
    }

    private void g() {
        View view = this.f41253c;
        if (view == null || this.i == null) {
            return;
        }
        view.setVisibility(0);
        com.kwad.sdk.core.report.a.c(this.f41252b, 19, null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        Object p = p();
        if (p instanceof com.kwad.sdk.splashscreen.g) {
            this.i = (com.kwad.sdk.splashscreen.g) p;
        }
        com.kwad.sdk.splashscreen.g gVar = this.i;
        if (gVar == null) {
            return;
        }
        AdTemplate adTemplate = gVar.f41330d;
        this.f41252b = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.k = com.kwad.sdk.splashscreen.e.a(this.f41252b, j, this.i.f41333g);
        float o = com.kwad.sdk.core.response.a.b.o(this.f41252b);
        com.kwad.sdk.core.g.b bVar = this.f41256f;
        if (bVar == null) {
            com.kwad.sdk.core.g.b bVar2 = new com.kwad.sdk.core.g.b(o);
            this.f41256f = bVar2;
            bVar2.a(this);
        } else {
            bVar.a(o);
        }
        e();
        if (com.kwad.sdk.core.response.a.a.B(j)) {
            f();
        }
        g();
        this.f41256f.a(q());
        this.f41254d.post(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.g.1
            @Override // java.lang.Runnable
            public void run() {
                g.this.f41254d.a();
            }
        });
        com.kwad.sdk.splashscreen.kwai.a.a(q());
        this.f41258h = com.kwad.sdk.core.response.a.c.g(this.i.f41330d);
        new com.kwad.sdk.widget.f(this.f41254d.getContext(), this.f41254d, this);
    }

    @Override // com.kwad.sdk.core.g.a
    public void a(final double d2) {
        Runnable runnable;
        long j;
        boolean isShown = this.f41254d.isShown();
        boolean a2 = com.kwad.sdk.core.download.kwai.b.a();
        com.kwad.sdk.core.d.a.a("SplashShakePresenter", "onShakeEvent called isShakeViewShown: " + isShown + ", isDialogShown: " + a2);
        if (!isShown || a2) {
            runnable = new Runnable() { // from class: com.kwad.sdk.splashscreen.a.g.3
                @Override // java.lang.Runnable
                public void run() {
                    g.this.f41256f.a();
                }
            };
            j = 500;
        } else {
            this.f41254d.a(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.splashscreen.a.g.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (g.this.i != null) {
                        g.this.i.a(g.this.q(), 157, 2, d2);
                    }
                }
            });
            Vibrator vibrator = this.f41257g;
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
                    g.this.f41256f.a();
                }
            };
            j = 700;
        }
        ax.a(runnable, null, j);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view) {
        com.kwad.sdk.splashscreen.g gVar;
        com.kwad.sdk.core.d.a.a("SplashShakePresenter", "onSingleTap: " + view);
        if (com.kwad.sdk.core.response.a.b.c(com.kwad.sdk.core.response.a.d.j(this.f41252b)) && (gVar = this.i) != null) {
            gVar.a(q(), 158, 1);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view) {
        com.kwad.sdk.splashscreen.g gVar;
        com.kwad.sdk.core.d.a.a("SplashShakePresenter", "onSlide: enableSlickClick: " + this.f41258h);
        if (this.f41258h && (gVar = this.i) != null) {
            gVar.a(view.getContext(), 153, 1);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("SplashShakePresenter", "onUnbind");
        com.kwad.sdk.core.g.b bVar = this.f41256f;
        if (bVar != null) {
            bVar.b(q());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        Context q = q();
        if (q != null) {
            this.f41257g = (Vibrator) q.getSystemService("vibrator");
        }
        this.f41253c = a(R.id.obfuscated_res_0x7f091135);
        this.f41255e = (TextView) a(R.id.obfuscated_res_0x7f091134);
        KsShakeView ksShakeView = (KsShakeView) a(R.id.obfuscated_res_0x7f091137);
        this.f41254d = ksShakeView;
        ksShakeView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AdTemplate adTemplate;
        com.kwad.sdk.core.d.a.a("SplashShakePresenter", "onClick: " + view);
        if (!view.equals(this.f41254d) || this.i == null || (adTemplate = this.f41252b) == null || !com.kwad.sdk.core.response.a.b.c(com.kwad.sdk.core.response.a.d.j(adTemplate))) {
            return;
        }
        this.i.a(q(), 158, 1);
    }
}
