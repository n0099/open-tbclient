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
/* loaded from: classes5.dex */
public class g extends Presenter implements View.OnClickListener, com.kwad.sdk.core.g.a, com.kwad.sdk.widget.d {
    public static long a = 400;
    public AdTemplate b;
    public View c;
    public KsShakeView d;
    public TextView e;
    public com.kwad.sdk.core.g.b f;
    public Vibrator g;
    public boolean h;
    @Nullable
    public com.kwad.sdk.splashscreen.g i;
    public com.kwad.sdk.splashscreen.a j;
    public com.kwad.sdk.splashscreen.e k;

    private void e() {
        TextView textView = this.e;
        if (textView != null) {
            textView.setText(this.k.a());
        }
        KsShakeView ksShakeView = this.d;
        if (ksShakeView != null) {
            ksShakeView.a(this.k.b());
        }
    }

    private void f() {
        if (this.i != null) {
            com.kwad.sdk.splashscreen.a aVar = this.j;
            if (aVar == null) {
                this.j = new com.kwad.sdk.splashscreen.a(this.b) { // from class: com.kwad.sdk.splashscreen.a.g.2
                    @Override // com.kwad.sdk.splashscreen.a
                    @SuppressLint({"SetTextI18n"})
                    public void a(String str) {
                        if (g.this.e != null) {
                            TextView textView = g.this.e;
                            textView.setText("或点击" + str);
                        }
                    }
                };
            } else {
                aVar.a(this.b);
            }
            com.kwad.sdk.core.download.a.b bVar = this.i.g;
            if (bVar != null) {
                bVar.a(this.j);
            }
        }
    }

    private void g() {
        View view2 = this.c;
        if (view2 == null || this.i == null) {
            return;
        }
        view2.setVisibility(0);
        com.kwad.sdk.core.report.a.c(this.b, 19, null);
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
        AdTemplate adTemplate = gVar.d;
        this.b = adTemplate;
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        this.k = com.kwad.sdk.splashscreen.e.a(this.b, j, this.i.g);
        float o = com.kwad.sdk.core.response.a.b.o(this.b);
        com.kwad.sdk.core.g.b bVar = this.f;
        if (bVar == null) {
            com.kwad.sdk.core.g.b bVar2 = new com.kwad.sdk.core.g.b(o);
            this.f = bVar2;
            bVar2.a(this);
        } else {
            bVar.a(o);
        }
        e();
        if (com.kwad.sdk.core.response.a.a.B(j)) {
            f();
        }
        g();
        this.f.a(q());
        this.d.post(new Runnable() { // from class: com.kwad.sdk.splashscreen.a.g.1
            @Override // java.lang.Runnable
            public void run() {
                g.this.d.a();
            }
        });
        com.kwad.sdk.splashscreen.kwai.a.a(q());
        this.h = com.kwad.sdk.core.response.a.c.g(this.i.d);
        new com.kwad.sdk.widget.f(this.d.getContext(), this.d, this);
    }

    @Override // com.kwad.sdk.core.g.a
    public void a(final double d) {
        Runnable runnable;
        long j;
        boolean isShown = this.d.isShown();
        boolean a2 = com.kwad.sdk.core.download.kwai.b.a();
        com.kwad.sdk.core.d.a.a("SplashShakePresenter", "onShakeEvent called isShakeViewShown: " + isShown + ", isDialogShown: " + a2);
        if (!isShown || a2) {
            runnable = new Runnable() { // from class: com.kwad.sdk.splashscreen.a.g.3
                @Override // java.lang.Runnable
                public void run() {
                    g.this.f.a();
                }
            };
            j = 500;
        } else {
            this.d.a(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.splashscreen.a.g.4
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (g.this.i != null) {
                        g.this.i.a(g.this.q(), 157, 2, d);
                    }
                }
            });
            Vibrator vibrator = this.g;
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
                    g.this.f.a();
                }
            };
            j = 700;
        }
        ax.a(runnable, null, j);
    }

    @Override // com.kwad.sdk.widget.d
    public void a_(View view2) {
        com.kwad.sdk.splashscreen.g gVar;
        com.kwad.sdk.core.d.a.a("SplashShakePresenter", "onSingleTap: " + view2);
        if (com.kwad.sdk.core.response.a.b.c(com.kwad.sdk.core.response.a.d.j(this.b)) && (gVar = this.i) != null) {
            gVar.a(q(), 158, 1);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public void b(View view2) {
        com.kwad.sdk.splashscreen.g gVar;
        com.kwad.sdk.core.d.a.a("SplashShakePresenter", "onSlide: enableSlickClick: " + this.h);
        if (this.h && (gVar = this.i) != null) {
            gVar.a(view2.getContext(), 153, 1);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        com.kwad.sdk.core.d.a.a("SplashShakePresenter", "onUnbind");
        com.kwad.sdk.core.g.b bVar = this.f;
        if (bVar != null) {
            bVar.b(q());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c_() {
        super.c_();
        Context q = q();
        if (q != null) {
            this.g = (Vibrator) q.getSystemService("vibrator");
        }
        this.c = a(R.id.obfuscated_res_0x7f09112e);
        this.e = (TextView) a(R.id.obfuscated_res_0x7f09112d);
        KsShakeView ksShakeView = (KsShakeView) a(R.id.obfuscated_res_0x7f091130);
        this.d = ksShakeView;
        ksShakeView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        AdTemplate adTemplate;
        com.kwad.sdk.core.d.a.a("SplashShakePresenter", "onClick: " + view2);
        if (!view2.equals(this.d) || this.i == null || (adTemplate = this.b) == null || !com.kwad.sdk.core.response.a.b.c(com.kwad.sdk.core.response.a.d.j(adTemplate))) {
            return;
        }
        this.i.a(q(), 158, 1);
    }
}
