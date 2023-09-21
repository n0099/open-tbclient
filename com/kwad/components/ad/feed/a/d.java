package com.kwad.components.ad.feed.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public final class d extends FrameLayout {
    public int count;
    public ImageView dA;
    public ImageView dB;
    public Animator dC;
    public Animator dD;
    public Animation dE;
    public Animation dF;
    public ImageView dz;

    public d(@NonNull Context context) {
        this(context, null);
    }

    public d(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public d(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        this.count = 0;
        E(context);
    }

    private void E(Context context) {
        FrameLayout.inflate(context, R.layout.obfuscated_res_0x7f0d04d1, this);
        this.dz = (ImageView) findViewById(R.id.obfuscated_res_0x7f0912d7);
        this.dA = (ImageView) findViewById(R.id.obfuscated_res_0x7f091322);
        this.dB = (ImageView) findViewById(R.id.obfuscated_res_0x7f0912d4);
    }

    private Animation a(final View view2, float f, int i) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, 0.0f);
        float a = i / com.kwad.sdk.b.kwai.a.a(getContext(), 10.0f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, a, 1.0f, a, 1, 0.5f, 1, 0.5f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(200L);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kwad.components.ad.feed.a.d.3
            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                view2.setVisibility(4);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationStart(Animation animation) {
                view2.setVisibility(0);
            }
        });
        return animationSet;
    }

    private void bp() {
        this.dC = c(this.dB);
        this.dD = d(this.dB);
        this.dE = a(this.dz, 0.45f, com.kwad.sdk.b.kwai.a.a(getContext(), 34.0f));
        this.dF = a(this.dA, 0.5f, com.kwad.sdk.b.kwai.a.a(getContext(), 50.0f));
        this.dC.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.a.d.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                d.this.dz.startAnimation(d.this.dE);
                d.this.dA.startAnimation(d.this.dF);
                d.this.dD.start();
            }
        });
        this.dD.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.a.d.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                d.f(d.this);
                if (d.this.count >= 5) {
                    return;
                }
                d.this.dC.start();
            }
        });
    }

    private Animator c(View view2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "rotation", 0.0f, -10.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_X, 0.0f, -com.kwad.sdk.b.kwai.a.a(getContext(), 9.5f));
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, 0.0f, -com.kwad.sdk.b.kwai.a.a(getContext(), 9.5f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        return animatorSet;
    }

    private Animator d(View view2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "rotation", -10.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_X, -com.kwad.sdk.b.kwai.a.a(getContext(), 9.5f), 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, -com.kwad.sdk.b.kwai.a.a(getContext(), 9.5f), 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        return animatorSet;
    }

    public static /* synthetic */ int f(d dVar) {
        int i = dVar.count;
        dVar.count = i + 1;
        return i;
    }

    public final void bn() {
        bp();
        this.dC.start();
    }

    public final void bo() {
        Animator animator = this.dC;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.dD;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animation animation = this.dE;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.dF;
        if (animation2 != null) {
            animation2.cancel();
        }
    }
}
