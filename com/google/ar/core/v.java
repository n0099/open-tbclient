package com.google.ar.core;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public final class v extends AnimatorListenerAdapter {
    private final /* synthetic */ InstallActivity ptw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(InstallActivity installActivity) {
        this.ptw = installActivity;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.ptw.exY();
    }
}
