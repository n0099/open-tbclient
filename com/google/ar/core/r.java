package com.google.ar.core;

import android.view.View;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class r implements View.OnClickListener {
    private final /* synthetic */ InstallActivity pRJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(InstallActivity installActivity) {
        this.pRJ = installActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.pRJ.E(new UnavailableUserDeclinedInstallationException());
    }
}
