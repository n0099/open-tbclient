package com.google.ar.core;

import android.animation.ValueAnimator;
/* loaded from: classes11.dex */
final class t implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ int f4046a;
    private final /* synthetic */ int b;
    private final /* synthetic */ int c;
    private final /* synthetic */ InstallActivity pcJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(InstallActivity installActivity, int i, int i2, int i3) {
        this.pcJ = installActivity;
        this.f4046a = i;
        this.b = i2;
        this.c = i3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
        float animatedFraction2 = valueAnimator.getAnimatedFraction();
        this.pcJ.getWindow().setLayout((int) ((this.f4046a * animatedFraction) + (this.b * animatedFraction2)), (int) ((animatedFraction * this.c) + (animatedFraction2 * this.b)));
        this.pcJ.getWindow().getDecorView().refreshDrawableState();
    }
}
