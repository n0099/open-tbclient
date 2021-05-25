package d.g.b.a;

import android.animation.ValueAnimator;
import com.google.ar.core.InstallActivity;
/* loaded from: classes6.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f66197e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f66198f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f66199g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ InstallActivity f66200h;

    public j(InstallActivity installActivity, int i2, int i3, int i4) {
        this.f66200h = installActivity;
        this.f66197e = i2;
        this.f66198f = i3;
        this.f66199g = i4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
        float animatedFraction2 = valueAnimator.getAnimatedFraction();
        int i2 = this.f66198f;
        this.f66200h.getWindow().setLayout((int) ((this.f66197e * animatedFraction) + (i2 * animatedFraction2)), (int) ((this.f66199g * animatedFraction) + (i2 * animatedFraction2)));
        this.f66200h.getWindow().getDecorView().refreshDrawableState();
    }
}
