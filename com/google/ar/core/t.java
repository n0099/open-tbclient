package com.google.ar.core;

import android.animation.ValueAnimator;
/* loaded from: classes6.dex */
final class t implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ int f8166a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ int f8167b;
    private final /* synthetic */ int c;
    private final /* synthetic */ InstallActivity pMf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(InstallActivity installActivity, int i, int i2, int i3) {
        this.pMf = installActivity;
        this.f8166a = i;
        this.f8167b = i2;
        this.c = i3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
        float animatedFraction2 = valueAnimator.getAnimatedFraction();
        this.pMf.getWindow().setLayout((int) ((this.f8166a * animatedFraction) + (this.f8167b * animatedFraction2)), (int) ((animatedFraction * this.c) + (animatedFraction2 * this.f8167b)));
        this.pMf.getWindow().getDecorView().refreshDrawableState();
    }
}
