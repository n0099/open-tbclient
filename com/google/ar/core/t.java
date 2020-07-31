package com.google.ar.core;

import android.animation.ValueAnimator;
/* loaded from: classes5.dex */
final class t implements ValueAnimator.AnimatorUpdateListener {
    private final /* synthetic */ int a;
    private final /* synthetic */ int b;
    private final /* synthetic */ int c;
    private final /* synthetic */ InstallActivity niy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(InstallActivity installActivity, int i, int i2, int i3) {
        this.niy = installActivity;
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
        float animatedFraction2 = valueAnimator.getAnimatedFraction();
        this.niy.getWindow().setLayout((int) ((this.a * animatedFraction) + (this.b * animatedFraction2)), (int) ((animatedFraction * this.c) + (animatedFraction2 * this.b)));
        this.niy.getWindow().getDecorView().refreshDrawableState();
    }
}
