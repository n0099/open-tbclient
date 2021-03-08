package com.google.ar.core;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public final class s implements View.OnClickListener {
    private final /* synthetic */ InstallActivity pSY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(InstallActivity installActivity) {
        this.pSY = installActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.pSY.eBc();
        this.pSY.eBe();
    }
}
