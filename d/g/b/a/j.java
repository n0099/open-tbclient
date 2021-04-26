package d.g.b.a;

import android.animation.ValueAnimator;
import com.google.ar.core.InstallActivity;
/* loaded from: classes6.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f65468e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f65469f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f65470g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ InstallActivity f65471h;

    public j(InstallActivity installActivity, int i2, int i3, int i4) {
        this.f65471h = installActivity;
        this.f65468e = i2;
        this.f65469f = i3;
        this.f65470g = i4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
        float animatedFraction2 = valueAnimator.getAnimatedFraction();
        int i2 = this.f65469f;
        this.f65471h.getWindow().setLayout((int) ((this.f65468e * animatedFraction) + (i2 * animatedFraction2)), (int) ((this.f65470g * animatedFraction) + (i2 * animatedFraction2)));
        this.f65471h.getWindow().getDecorView().refreshDrawableState();
    }
}
