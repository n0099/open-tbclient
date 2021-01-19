package com.google.ar.core;

import android.animation.ValueAnimator;
/* loaded from: classes5.dex */
final class t implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ int f7866a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ int f7867b;
    private final /* synthetic */ int c;
    private final /* synthetic */ InstallActivity pHF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(InstallActivity installActivity, int i, int i2, int i3) {
        this.pHF = installActivity;
        this.f7866a = i;
        this.f7867b = i2;
        this.c = i3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
        float animatedFraction2 = valueAnimator.getAnimatedFraction();
        this.pHF.getWindow().setLayout((int) ((this.f7866a * animatedFraction) + (this.f7867b * animatedFraction2)), (int) ((animatedFraction * this.c) + (animatedFraction2 * this.f7867b)));
        this.pHF.getWindow().getDecorView().refreshDrawableState();
    }
}
