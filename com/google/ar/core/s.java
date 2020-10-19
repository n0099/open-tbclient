package com.google.ar.core;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class s implements View.OnClickListener {
    private final /* synthetic */ InstallActivity obW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(InstallActivity installActivity) {
        this.obW = installActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.obW.eeH();
        this.obW.eeJ();
    }
}
