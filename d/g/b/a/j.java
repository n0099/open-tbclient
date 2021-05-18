package d.g.b.a;

import android.animation.ValueAnimator;
import com.google.ar.core.InstallActivity;
/* loaded from: classes6.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f66154e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f66155f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f66156g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ InstallActivity f66157h;

    public j(InstallActivity installActivity, int i2, int i3, int i4) {
        this.f66157h = installActivity;
        this.f66154e = i2;
        this.f66155f = i3;
        this.f66156g = i4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
        float animatedFraction2 = valueAnimator.getAnimatedFraction();
        int i2 = this.f66155f;
        this.f66157h.getWindow().setLayout((int) ((this.f66154e * animatedFraction) + (i2 * animatedFraction2)), (int) ((this.f66156g * animatedFraction) + (i2 * animatedFraction2)));
        this.f66157h.getWindow().getDecorView().refreshDrawableState();
    }
}
