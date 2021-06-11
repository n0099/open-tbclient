package d.g.b.a;

import android.animation.ValueAnimator;
import com.google.ar.core.InstallActivity;
/* loaded from: classes6.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f69928e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f69929f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f69930g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ InstallActivity f69931h;

    public j(InstallActivity installActivity, int i2, int i3, int i4) {
        this.f69931h = installActivity;
        this.f69928e = i2;
        this.f69929f = i3;
        this.f69930g = i4;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
        float animatedFraction2 = valueAnimator.getAnimatedFraction();
        int i2 = this.f69929f;
        this.f69931h.getWindow().setLayout((int) ((this.f69928e * animatedFraction) + (i2 * animatedFraction2)), (int) ((this.f69930g * animatedFraction) + (i2 * animatedFraction2)));
        this.f69931h.getWindow().getDecorView().refreshDrawableState();
    }
}
