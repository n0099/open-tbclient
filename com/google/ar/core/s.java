package com.google.ar.core;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class s implements View.OnClickListener {
    private final /* synthetic */ InstallActivity pKw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(InstallActivity installActivity) {
        this.pKw = installActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.pKw.eBK();
        this.pKw.eBM();
    }
}
