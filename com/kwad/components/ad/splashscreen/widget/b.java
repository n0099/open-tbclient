package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.widget.KSFrameLayout;
/* loaded from: classes8.dex */
public abstract class b extends KSFrameLayout {
    public Animator Ag;
    public boolean Ah;

    public b(@NonNull Context context) {
        this(context, null, 0);
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ah = false;
        a(context, attributeSet, i);
        kp();
    }

    public void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void an() {
        super.an();
        Animator animator = this.Ag;
        if (animator != null) {
            animator.cancel();
        }
    }

    public abstract int getAnimationDelayTime();

    public abstract View getInteractionView();

    public abstract Animator kD();

    public abstract void kE();

    public final void kF() {
        this.Ah = true;
        Animator animator = this.Ag;
        if (animator != null) {
            animator.cancel();
        }
    }

    @MainThread
    public final void kk() {
        Animator animator = this.Ag;
        if (animator != null) {
            animator.cancel();
            this.Ag = null;
        }
        Animator kD = kD();
        this.Ag = kD;
        if (kD != null) {
            kD.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.b.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator2) {
                    super.onAnimationCancel(animator2);
                    b.this.kE();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator2) {
                    super.onAnimationEnd(animator2);
                    if (b.this.Ah) {
                        return;
                    }
                    b.this.getInteractionView().postDelayed(new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.b.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.this.Ag.start();
                        }
                    }, b.this.getAnimationDelayTime());
                }
            });
            this.Ag.start();
        }
    }

    public abstract void kp();
}
