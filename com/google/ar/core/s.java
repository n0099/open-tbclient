package com.google.ar.core;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class s implements View.OnClickListener {
    private final /* synthetic */ InstallActivity pMe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(InstallActivity installActivity) {
        this.pMe = installActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.pMe.eCo();
        this.pMe.eCq();
    }
}
