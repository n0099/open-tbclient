package com.google.ar.core;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class v extends AnimatorListenerAdapter {
    private final /* synthetic */ InstallActivity pSj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(InstallActivity installActivity) {
        this.pSj = installActivity;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.pSj.eAV();
    }
}
