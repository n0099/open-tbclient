package com.google.ar.core;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes24.dex */
public final class s implements View.OnClickListener {
    private final /* synthetic */ InstallActivity nME;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(InstallActivity installActivity) {
        this.nME = installActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.nME.eaW();
        this.nME.eaY();
    }
}
