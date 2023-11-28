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
/* loaded from: classes10.dex */
public abstract class b extends KSFrameLayout {
    public Animator FP;
    public boolean FQ;

    public void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
    }

    public abstract int getAnimationDelayTime();

    public abstract View getInteractionView();

    public abstract void lK();

    public abstract Animator lL();

    public abstract void lM();

    public b(@NonNull Context context) {
        this(context, null, 0);
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.FQ = false;
        a(context, attributeSet, i);
        lK();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        Animator animator = this.FP;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void lN() {
        this.FQ = true;
        Animator animator = this.FP;
        if (animator != null) {
            animator.cancel();
        }
    }

    @MainThread
    public final void lh() {
        Animator animator = this.FP;
        if (animator != null) {
            animator.cancel();
            this.FP = null;
        }
        Animator lL = lL();
        this.FP = lL;
        if (lL != null) {
            lL.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.b.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator2) {
                    super.onAnimationCancel(animator2);
                    b.this.lM();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator2) {
                    super.onAnimationEnd(animator2);
                    if (b.this.FQ) {
                        return;
                    }
                    b.this.getInteractionView().postDelayed(new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.b.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.this.FP.start();
                        }
                    }, b.this.getAnimationDelayTime());
                }
            });
            this.FP.start();
        }
    }
}
