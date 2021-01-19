package com.google.ar.core;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class s implements View.OnClickListener {
    private final /* synthetic */ InstallActivity pHE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(InstallActivity installActivity) {
        this.pHE = installActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.pHE.eyw();
        this.pHE.eyy();
    }
}
