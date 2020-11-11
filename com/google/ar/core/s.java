package com.google.ar.core;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public final class s implements View.OnClickListener {
    private final /* synthetic */ InstallActivity pcI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(InstallActivity installActivity) {
        this.pcI = installActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.pcI.esw();
        this.pcI.esy();
    }
}
