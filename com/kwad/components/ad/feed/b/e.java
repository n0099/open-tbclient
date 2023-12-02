package com.kwad.components.ad.feed.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public final class e extends FrameLayout {
    public View fp;
    public ImageView fq;
    @Nullable
    public Animator fr;
    public com.kwad.sdk.widget.c fs;

    public e(@NonNull Context context) {
        this(context, null);
    }

    private Animator f(final View view2) {
        if (view2 == null) {
            return null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.ALPHA, 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.setDuration(500L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.b.e.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view2.setVisibility(8);
            }
        });
        return animatorSet;
    }

    private void init(Context context) {
        com.kwad.sdk.m.l.inflate(context, R.layout.obfuscated_res_0x7f0d04c9, this);
        setClickable(false);
        this.fp = findViewById(R.id.obfuscated_res_0x7f09136a);
        this.fq = (ImageView) findViewById(R.id.obfuscated_res_0x7f09136b);
    }

    public final void setOnViewEventListener(com.kwad.sdk.widget.c cVar) {
        this.fs = cVar;
    }

    public e(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public e(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        init(context);
    }

    private Animator a(View view2, long j, float f) {
        if (view2 == null) {
            return null;
        }
        Interpolator create = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
        this.fq.setPivotX(view2.getWidth());
        this.fq.setPivotY(view2.getHeight());
        Animator a = com.kwad.components.core.s.n.a(view2, create, 100L, 16.0f);
        Animator a2 = com.kwad.components.core.s.n.a(view2, create, 100L, 16.0f);
        Animator a3 = com.kwad.components.core.s.n.a(view2, create, 100L, 16.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(a, a2, a3);
        return animatorSet;
    }

    private Animator b(final View view2, int i) {
        if (view2 == null) {
            return null;
        }
        view2.setPivotX(view2.getWidth() / 2.0f);
        view2.setPivotY(view2.getHeight() / 2.0f);
        float min = i / Math.min(view2.getHeight(), view2.getWidth());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.SCALE_X, min, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, Key.SCALE_Y, min, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view2, Key.ALPHA, 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.setDuration(500L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.b.e.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                view2.setVisibility(0);
                view2.setClickable(true);
                new com.kwad.sdk.widget.f(view2, e.this.fs);
            }
        });
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animator bq() {
        View view2 = this.fp;
        if (view2 != null && this.fq != null && view2.getWidth() + this.fp.getHeight() != 0 && this.fq.getWidth() + this.fq.getHeight() != 0) {
            Animator br = br();
            Animator a = a(this.fq, 100L, 16.0f);
            Animator bs = bs();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(br, a, bs);
            return animatorSet;
        }
        return null;
    }

    private Animator br() {
        Animator b = b(this.fp, com.kwad.sdk.d.a.a.a(getContext(), 128.0f));
        Animator b2 = b(this.fq, com.kwad.sdk.d.a.a.a(getContext(), 71.11f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.playTogether(b, b2);
        return animatorSet;
    }

    private Animator bs() {
        Animator f = f(this.fp);
        Animator f2 = f(this.fq);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.playTogether(f, f2);
        return animatorSet;
    }

    @MainThread
    public final void a(final AnimatorListenerAdapter animatorListenerAdapter) {
        Animator animator = this.fr;
        if (animator != null) {
            animator.cancel();
            this.fr = null;
        }
        this.fq.post(new Runnable() { // from class: com.kwad.components.ad.feed.b.e.1
            @Override // java.lang.Runnable
            public final void run() {
                e eVar = e.this;
                eVar.fr = eVar.bq();
                if (e.this.fr != null) {
                    e.this.fr.addListener(animatorListenerAdapter);
                    e.this.fr.start();
                    return;
                }
                animatorListenerAdapter.onAnimationEnd(null);
            }
        });
    }
}
