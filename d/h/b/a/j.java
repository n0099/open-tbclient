package d.h.b.a;

import android.animation.ValueAnimator;
import com.google.ar.core.InstallActivity;
/* loaded from: classes6.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f67053e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f67054f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f67055g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ InstallActivity f67056h;

    public j(InstallActivity installActivity, int i, int i2, int i3) {
        this.f67056h = installActivity;
        this.f67053e = i;
        this.f67054f = i2;
        this.f67055g = i3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
        float animatedFraction2 = valueAnimator.getAnimatedFraction();
        int i = this.f67054f;
        this.f67056h.getWindow().setLayout((int) ((this.f67053e * animatedFraction) + (i * animatedFraction2)), (int) ((this.f67055g * animatedFraction) + (i * animatedFraction2)));
        this.f67056h.getWindow().getDecorView().refreshDrawableState();
    }
}
