package d.g.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.ar.core.InstallActivity;
/* loaded from: classes6.dex */
public final class k extends AnimatorListenerAdapter {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ InstallActivity f69932e;

    public k(InstallActivity installActivity) {
        this.f69932e = installActivity;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.f69932e.showSpinner();
    }
}
