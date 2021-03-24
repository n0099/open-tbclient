package d.b.i0.p3.m;

import android.animation.Animator;
/* loaded from: classes5.dex */
public abstract class m implements Animator.AnimatorListener {

    /* renamed from: e  reason: collision with root package name */
    public boolean f59204e = false;

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f59204e = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f59204e = false;
    }
}
