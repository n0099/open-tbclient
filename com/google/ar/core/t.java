package com.google.ar.core;

import android.animation.ValueAnimator;
/* loaded from: classes17.dex */
final class t implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ int f4049a;
    private final /* synthetic */ int b;
    private final /* synthetic */ int c;
    private final /* synthetic */ InstallActivity ptx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(InstallActivity installActivity, int i, int i2, int i3) {
        this.ptx = installActivity;
        this.f4049a = i;
        this.b = i2;
        this.c = i3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
        float animatedFraction2 = valueAnimator.getAnimatedFraction();
        this.ptx.getWindow().setLayout((int) ((this.f4049a * animatedFraction) + (this.b * animatedFraction2)), (int) ((animatedFraction * this.c) + (animatedFraction2 * this.b)));
        this.ptx.getWindow().getDecorView().refreshDrawableState();
    }
}
