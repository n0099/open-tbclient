package com.google.ar.core;

import com.google.ar.core.exceptions.UnavailableException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class y {
    boolean a = false;
    final /* synthetic */ InstallActivity nCO;

    public void a(p pVar) {
        synchronized (this.nCO) {
            if (!this.a) {
                InstallActivity.a(this.nCO, pVar);
                switch (pVar.ordinal()) {
                    case 0:
                        return;
                    case 1:
                        InstallActivity.a(this.nCO, new UnavailableUserDeclinedInstallationException());
                        break;
                    case 2:
                        if (!InstallActivity.d(this.nCO)) {
                            InstallActivity.e(this.nCO);
                        }
                        InstallActivity.a(this.nCO, (Exception) null);
                        break;
                }
                this.a = true;
            }
        }
    }

    public void a(Exception exc) {
        synchronized (this.nCO) {
            if (!this.a) {
                this.a = true;
                InstallActivity.a(this.nCO, p.CANCELLED);
                if (!(exc instanceof UnavailableException)) {
                }
                InstallActivity.a(this.nCO, exc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(InstallActivity installActivity) {
        this.nCO = installActivity;
    }
}
