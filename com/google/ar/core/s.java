package com.google.ar.core;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public final class s implements View.OnClickListener {
    private final /* synthetic */ InstallActivity ptw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(InstallActivity installActivity) {
        this.ptw = installActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.ptw.exZ();
        this.ptw.eyb();
    }
}
