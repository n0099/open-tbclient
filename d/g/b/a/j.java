package d.g.b.a;

import android.animation.ValueAnimator;
import com.google.ar.core.InstallActivity;
/* loaded from: classes6.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f66061e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f66062f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f66063g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ InstallActivity f66064h;

    public j(InstallActivity installActivity, int i, int i2, int i3) {
        this.f66064h = installActivity;
        this.f66061e = i;
        this.f66062f = i2;
        this.f66063g = i3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
        float animatedFraction2 = valueAnimator.getAnimatedFraction();
        int i = this.f66062f;
        this.f66064h.getWindow().setLayout((int) ((this.f66061e * animatedFraction) + (i * animatedFraction2)), (int) ((this.f66063g * animatedFraction) + (i * animatedFraction2)));
        this.f66064h.getWindow().getDecorView().refreshDrawableState();
    }
}
