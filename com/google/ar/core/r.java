package com.google.ar.core;

import android.view.View;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class r implements View.OnClickListener {
    private final /* synthetic */ InstallActivity pSj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(InstallActivity installActivity) {
        this.pSj = installActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.pSj.E(new UnavailableUserDeclinedInstallationException());
    }
}
