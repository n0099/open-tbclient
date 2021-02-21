package com.google.ar.core;

import android.animation.ValueAnimator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class t implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ int f7868a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ int f7869b;
    private final /* synthetic */ int c;
    private final /* synthetic */ InstallActivity pSk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(InstallActivity installActivity, int i, int i2, int i3) {
        this.pSk = installActivity;
        this.f7868a = i;
        this.f7869b = i2;
        this.c = i3;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = 1.0f - valueAnimator.getAnimatedFraction();
        float animatedFraction2 = valueAnimator.getAnimatedFraction();
        this.pSk.getWindow().setLayout((int) ((this.f7868a * animatedFraction) + (this.f7869b * animatedFraction2)), (int) ((animatedFraction * this.c) + (animatedFraction2 * this.f7869b)));
        this.pSk.getWindow().getDecorView().refreshDrawableState();
    }
}
