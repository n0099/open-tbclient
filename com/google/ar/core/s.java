package com.google.ar.core;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class s implements View.OnClickListener {
    private final /* synthetic */ InstallActivity pRJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(InstallActivity installActivity) {
        this.pRJ = installActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.pRJ.eAO();
        this.pRJ.eAQ();
    }
}
