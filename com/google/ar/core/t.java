package com.google.ar.core;

import android.animation.ValueAnimator;
/* loaded from: classes3.dex */
final class t implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ int f8165a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ int f8166b;
    private final /* synthetic */ int c;
    private final /* synthetic */ InstallActivity pKx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(InstallActivity installActivity, int i, int i2, int i3) {
        this.pKx = installActivity;
        this.f8165a = i;
        this.f8166b = i2;
        this.c = i3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
        float animatedFraction2 = valueAnimator.getAnimatedFraction();
        this.pKx.getWindow().setLayout((int) ((this.f8165a * animatedFraction) + (this.f8166b * animatedFraction2)), (int) ((animatedFraction * this.c) + (animatedFraction2 * this.f8166b)));
        this.pKx.getWindow().getDecorView().refreshDrawableState();
    }
}
