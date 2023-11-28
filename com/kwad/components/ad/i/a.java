package com.kwad.components.ad.i;

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
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.utils.bn;
/* loaded from: classes10.dex */
public final class a {
    public View Hg;
    public Runnable Hh;
    public boolean Hi = false;
    @Nullable
    public Animator hG;
    public View xZ;
    public Button ya;
    public Button yb;

    public a(View view2) {
        this.Hg = view2;
        initView();
    }

    public static Animator a(final View view2, float f, final float f2, long j) {
        final float f3 = f / f2;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, f2);
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        final float dimension = view2.getResources().getDimension(R.dimen.obfuscated_res_0x7f0704f5);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.i.a.3
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

    public static Animator a(final View view2, View view3, int i, int i2, long j, long j2) {
        Animator d = d(view2, 200L);
        float f = i;
        float f2 = i2;
        Animator a = a(view3, f, f2, 200L);
        a.addListener(new com.kwad.components.ad.widget.tailframe.appbar.b() { // from class: com.kwad.components.ad.i.a.2
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
        Animator d2 = d(view3, 200L);
        Animator a2 = a(view2, f, f2, 200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(d, a, ofFloat, d2, a2);
        return animatorSet;
    }

    public static Animator d(View view2, long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.ALPHA, 1.0f, 0.0f);
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        return ofFloat;
    }

    private void initView() {
        this.ya = (Button) this.Hg.findViewById(R.id.obfuscated_res_0x7f091416);
        this.yb = (Button) this.Hg.findViewById(R.id.obfuscated_res_0x7f091418);
        this.xZ = this.Hg.findViewById(R.id.obfuscated_res_0x7f091417);
    }

    public final void jN() {
        lU();
    }

    public final void lU() {
        Animator animator = this.hG;
        if (animator != null) {
            animator.cancel();
            this.hG.removeAllListeners();
            this.Hi = true;
        }
        Runnable runnable = this.Hh;
        if (runnable != null) {
            bn.c(runnable);
            this.Hh = null;
        }
    }

    public final void lV() {
        this.Hi = true;
    }

    public final void hR() {
        c.d("ApkInstallAnimHelper", "startAnimation");
        int height = this.xZ.getHeight();
        int width = this.xZ.getWidth();
        if (height != 0 && width != 0) {
            if (this.hG == null) {
                Animator a = a(this.yb, this.ya, width, height, 1600L, 200L);
                this.hG = a;
                a.addListener(new com.kwad.components.ad.widget.tailframe.appbar.b() { // from class: com.kwad.components.ad.i.a.1
                    @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(final Animator animator) {
                        if (a.this.Hi) {
                            return;
                        }
                        if (a.this.Hh == null) {
                            a.this.Hh = new Runnable() { // from class: com.kwad.components.ad.i.a.1.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    animator.start();
                                }
                            };
                        }
                        bn.a(a.this.Hh, null, 1600L);
                    }
                });
            }
            c.d("ApkInstallAnimHelper", "mAnimator isStarted: " + this.hG.isStarted());
            if (!this.hG.isStarted()) {
                c.d("ApkInstallAnimHelper", "mAnimator.start()");
                this.hG.start();
            }
            this.Hi = false;
        }
    }
}
