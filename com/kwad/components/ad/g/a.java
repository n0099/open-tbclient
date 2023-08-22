package com.kwad.components.ad.g;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.tieba.R;
import com.kwad.sdk.utils.bd;
/* loaded from: classes10.dex */
public final class a {
    public View BA;
    public Runnable BB;
    public boolean BC = false;
    @Nullable
    public Animator eY;
    public View un;
    public Button uo;
    public Button up;

    public a(View view2) {
        this.BA = view2;
        initView();
    }

    public static Animator a(final View view2, float f, final float f2, long j) {
        final float f3 = f / f2;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, f2);
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        final float dimension = view2.getResources().getDimension(R.dimen.obfuscated_res_0x7f0704f5);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.g.a.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float f4 = f3 * floatValue;
                float f5 = f2;
                if (f5 != 0.0f) {
                    float f6 = (floatValue / f5) * dimension;
                    View view3 = view2;
                    if (view3 instanceof TextView) {
                        ((TextView) view3).setTextSize(0, f6);
                    }
                }
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = (int) floatValue;
                    layoutParams.width = (int) f4;
                    view2.setLayoutParams(layoutParams);
                }
            }
        });
        return ofFloat;
    }

    public static Animator a(View view2, long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.ALPHA, 1.0f, 0.0f);
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        return ofFloat;
    }

    public static Animator a(final View view2, View view3, int i, int i2, long j, long j2) {
        Animator a = a(view2, 200L);
        float f = i;
        float f2 = i2;
        Animator a2 = a(view3, f, f2, 200L);
        a2.addListener(new com.kwad.components.ad.widget.tailframe.appbar.b() { // from class: com.kwad.components.ad.g.a.2
            @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view2.setAlpha(1.0f);
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = 0;
                    layoutParams.height = 0;
                    view2.setLayoutParams(layoutParams);
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view3, Key.SCALE_X, 1.0f, 1.0f);
        ofFloat.setDuration(1600L);
        Animator a3 = a(view3, 200L);
        Animator a4 = a(view2, f, f2, 200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(a, a2, ofFloat, a3, a4);
        return animatorSet;
    }

    private void initView() {
        this.uo = (Button) this.BA.findViewById(R.id.obfuscated_res_0x7f091378);
        this.up = (Button) this.BA.findViewById(R.id.obfuscated_res_0x7f09137a);
        this.un = this.BA.findViewById(R.id.obfuscated_res_0x7f091379);
    }

    public final void iO() {
        kM();
    }

    public final void kL() {
        com.kwad.sdk.core.e.b.d("ApkInstallAnimHelper", "startAnimation");
        int height = this.un.getHeight();
        int width = this.un.getWidth();
        if (height == 0 || width == 0) {
            return;
        }
        if (this.eY == null) {
            Animator a = a(this.up, this.uo, width, height, 1600L, 200L);
            this.eY = a;
            a.addListener(new com.kwad.components.ad.widget.tailframe.appbar.b() { // from class: com.kwad.components.ad.g.a.1
                @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(final Animator animator) {
                    if (a.this.BC) {
                        return;
                    }
                    if (a.this.BB == null) {
                        a.this.BB = new Runnable() { // from class: com.kwad.components.ad.g.a.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                animator.start();
                            }
                        };
                    }
                    bd.a(a.this.BB, null, 1600L);
                }
            });
        }
        com.kwad.sdk.core.e.b.d("ApkInstallAnimHelper", "mAnimator isStarted: " + this.eY.isStarted());
        if (!this.eY.isStarted()) {
            com.kwad.sdk.core.e.b.d("ApkInstallAnimHelper", "mAnimator.start()");
            this.eY.start();
        }
        this.BC = false;
    }

    public final void kM() {
        Animator animator = this.eY;
        if (animator != null) {
            animator.cancel();
            this.eY.removeAllListeners();
            this.BC = true;
        }
        Runnable runnable = this.BB;
        if (runnable != null) {
            bd.c(runnable);
            this.BB = null;
        }
    }

    public final void kN() {
        this.BC = true;
    }
}
