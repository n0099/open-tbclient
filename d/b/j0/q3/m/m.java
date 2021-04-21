package d.b.j0.q3.m;

import android.animation.Animator;
/* loaded from: classes5.dex */
public abstract class m implements Animator.AnimatorListener {

    /* renamed from: e  reason: collision with root package name */
    public boolean f61294e = false;

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f61294e = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f61294e = false;
    }
}
