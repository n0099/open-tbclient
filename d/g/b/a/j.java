package d.g.b.a;

import android.animation.ValueAnimator;
import com.google.ar.core.InstallActivity;
/* loaded from: classes6.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f70032e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f70033f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f70034g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ InstallActivity f70035h;

    public j(InstallActivity installActivity, int i2, int i3, int i4) {
        this.f70035h = installActivity;
        this.f70032e = i2;
        this.f70033f = i3;
        this.f70034g = i4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
        float animatedFraction2 = valueAnimator.getAnimatedFraction();
        int i2 = this.f70033f;
        this.f70035h.getWindow().setLayout((int) ((this.f70032e * animatedFraction) + (i2 * animatedFraction2)), (int) ((this.f70034g * animatedFraction) + (i2 * animatedFraction2)));
        this.f70035h.getWindow().getDecorView().refreshDrawableState();
    }
}
