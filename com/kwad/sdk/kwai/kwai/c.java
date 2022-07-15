package com.kwad.sdk.kwai.kwai;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.av;
/* loaded from: classes5.dex */
public final class c implements View.OnClickListener {
    @NonNull
    public final Context a;
    @NonNull
    public final AdTemplate b;
    public final AdInfo c;
    public final boolean d;
    public final boolean e;
    @NonNull
    public View f = b();
    public View g;
    public ImageView h;
    public TextView i;
    public Button j;
    public int k;
    public int l;

    public c(@NonNull Context context, @NonNull AdTemplate adTemplate, boolean z, boolean z2) {
        this.a = context;
        this.b = adTemplate;
        this.c = d.i(adTemplate);
        this.d = z;
        this.e = z2;
        c();
    }

    private Animator a(View view2) {
        ObjectAnimator ofFloat = (this.d && this.e) ? ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, 0.0f, this.l) : ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, 0.0f, -this.k);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.42f, 0.85f, 0.64f));
        ofFloat.setDuration(260L);
        return ofFloat;
    }

    @SuppressLint({"InflateParams"})
    private View b() {
        LayoutInflater from;
        int i;
        if (this.d && this.e) {
            from = LayoutInflater.from(this.a);
            i = R.layout.obfuscated_res_0x7f0d0429;
        } else {
            from = LayoutInflater.from(this.a);
            i = R.layout.obfuscated_res_0x7f0d0428;
        }
        this.f = from.inflate(i, (ViewGroup) null);
        ViewCompat.setElevation(this.f, this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f07036f));
        this.g = this.f.findViewById(R.id.obfuscated_res_0x7f091055);
        this.h = (ImageView) this.f.findViewById(R.id.obfuscated_res_0x7f091057);
        this.i = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f091056);
        this.j = (Button) this.f.findViewById(R.id.obfuscated_res_0x7f091058);
        return this.f;
    }

    private void b(FrameLayout frameLayout) {
        int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070370);
        int dimensionPixelSize2 = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070371);
        this.k = dimensionPixelSize + dimensionPixelSize2;
        ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : new FrameLayout.LayoutParams(-1, dimensionPixelSize);
        layoutParams2.gravity = 48;
        layoutParams2.leftMargin = dimensionPixelSize2;
        layoutParams2.rightMargin = dimensionPixelSize2;
        layoutParams2.topMargin = dimensionPixelSize2;
        this.f.setTranslationY(-this.k);
        frameLayout.addView(this.f, layoutParams2);
        d();
    }

    private void c() {
        this.j.setText(this.d ? "安装" : "打开");
        this.g.setOnClickListener(this);
        this.j.setOnClickListener(this);
        KSImageLoader.loadAppIcon(this.h, com.kwad.sdk.core.response.a.a.aE(d.i(this.b)), this.b, 8);
        String A = com.kwad.sdk.core.response.a.a.A(d.i(this.b));
        if (A.length() >= 8) {
            A = A.substring(0, 7) + StringHelper.STRING_MORE;
        }
        this.i.setText(this.a.getString(this.d ? R.string.obfuscated_res_0x7f0f09a9 : R.string.obfuscated_res_0x7f0f09aa, A));
    }

    private void c(FrameLayout frameLayout) {
        int k = av.k(this.a);
        int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07036e);
        int dimensionPixelSize2 = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07036d);
        int dimensionPixelOffset = this.a.getResources().getDimensionPixelOffset(R.dimen.obfuscated_res_0x7f07036c);
        this.l = k - dimensionPixelSize;
        ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : new FrameLayout.LayoutParams(-1, dimensionPixelOffset);
        layoutParams2.gravity = 80;
        layoutParams2.leftMargin = dimensionPixelSize;
        layoutParams2.rightMargin = 0;
        layoutParams2.bottomMargin = dimensionPixelSize2;
        this.f.setTranslationX(this.l);
        frameLayout.addView(this.f, layoutParams2);
        d();
    }

    private void d() {
        ObjectAnimator ofFloat = (this.d && this.e) ? ObjectAnimator.ofFloat(this.f, View.TRANSLATION_X, this.l, 0.0f) : ObjectAnimator.ofFloat(this.f, View.TRANSLATION_Y, -this.k, 0.0f);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.27f, 0.87f));
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public final void a() {
        if (this.f.getParent() == null) {
            return;
        }
        final ViewGroup viewGroup = (ViewGroup) this.f.getParent();
        Animator a = a(this.f);
        a.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.kwai.kwai.c.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                viewGroup.removeView(c.this.f);
            }
        });
        a.start();
        b.a().c();
    }

    public final void a(FrameLayout frameLayout) {
        if (this.f.getParent() != null) {
            return;
        }
        if (this.d && this.e) {
            c(frameLayout);
        } else {
            b(frameLayout);
        }
        this.f.postDelayed(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.1
            @Override // java.lang.Runnable
            public final void run() {
                c.this.a();
            }
        }, 10000L);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view2) {
        a();
        if (view2.getId() != R.id.obfuscated_res_0x7f091058) {
            if (view2.getId() == R.id.obfuscated_res_0x7f091055) {
                if (this.d) {
                    com.kwad.sdk.core.report.a.j(this.b, 46);
                } else {
                    com.kwad.sdk.core.report.a.i(this.b, 48);
                }
            }
        } else if (this.d) {
            if (af.d(((com.kwad.sdk.service.kwai.d) ServiceProvider.a(com.kwad.sdk.service.kwai.d.class)).a(), this.c.downloadFilePath)) {
                com.kwad.sdk.core.report.a.b(this.b, 1);
            }
            com.kwad.sdk.core.report.a.j(this.b, 45);
        } else {
            if (af.c(this.a, com.kwad.sdk.core.response.a.a.C(this.c))) {
                com.kwad.sdk.core.report.a.e(this.b);
            }
            com.kwad.sdk.core.report.a.i(this.b, 47);
        }
    }
}
