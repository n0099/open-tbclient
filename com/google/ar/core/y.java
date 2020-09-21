package com.google.ar.core;

import com.google.ar.core.exceptions.UnavailableException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes24.dex */
public class y {
    boolean a = false;
    final /* synthetic */ InstallActivity nMK;

    public void a(p pVar) {
        synchronized (this.nMK) {
            if (!this.a) {
                InstallActivity.a(this.nMK, pVar);
                switch (pVar.ordinal()) {
                    case 0:
                        return;
                    case 1:
                        InstallActivity.a(this.nMK, new UnavailableUserDeclinedInstallationException());
                        break;
                    case 2:
                        if (!InstallActivity.d(this.nMK)) {
                            InstallActivity.e(this.nMK);
                        }
                        InstallActivity.a(this.nMK, (Exception) null);
                        break;
                }
                this.a = true;
            }
        }
    }

    public void a(Exception exc) {
        synchronized (this.nMK) {
            if (!this.a) {
                this.a = true;
                InstallActivity.a(this.nMK, p.CANCELLED);
                if (!(exc instanceof UnavailableException)) {
                }
                InstallActivity.a(this.nMK, exc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(InstallActivity installActivity) {
        this.nMK = installActivity;
    }
}
