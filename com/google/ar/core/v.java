package com.google.ar.core;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class v extends AnimatorListenerAdapter {
    private final /* synthetic */ InstallActivity oTn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(InstallActivity installActivity) {
        this.oTn = installActivity;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.oTn.eoG();
    }
}
