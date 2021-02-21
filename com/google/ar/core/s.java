package com.google.ar.core;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class s implements View.OnClickListener {
    private final /* synthetic */ InstallActivity pSj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(InstallActivity installActivity) {
        this.pSj = installActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.pSj.eAW();
        this.pSj.eAY();
    }
}
