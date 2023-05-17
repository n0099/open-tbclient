package com.kwad.components.ad.feed;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
/* loaded from: classes9.dex */
public final class b {
    public Animator cG;

    public static Animator b(View view2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.SCALE_X, 1.0f, 1.05f, 1.1f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, Key.SCALE_Y, 1.0f, 1.05f, 1.1f, 1.0f);
        ofFloat.setRepeatMode(1);
        ofFloat.setRepeatCount(-1);
        ofFloat2.setRepeatMode(1);
        ofFloat2.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(600L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    public final void a(View view2) {
        if (this.cG == null) {
            this.cG = b(view2);
        }
        this.cG.start();
    }

    public final void aX() {
        Animator animator = this.cG;
        if (animator != null) {
            animator.removeAllListeners();
            this.cG.cancel();
        }
    }
}
