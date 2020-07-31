package com.google.ar.core;

import com.google.ar.core.exceptions.UnavailableException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class y {
    boolean a = false;
    final /* synthetic */ InstallActivity niD;

    public void a(p pVar) {
        synchronized (this.niD) {
            if (!this.a) {
                InstallActivity.a(this.niD, pVar);
                switch (pVar.ordinal()) {
                    case 0:
                        return;
                    case 1:
                        InstallActivity.a(this.niD, new UnavailableUserDeclinedInstallationException());
                        break;
                    case 2:
                        if (!InstallActivity.d(this.niD)) {
                            InstallActivity.e(this.niD);
                        }
                        InstallActivity.a(this.niD, (Exception) null);
                        break;
                }
                this.a = true;
            }
        }
    }

    public void a(Exception exc) {
        synchronized (this.niD) {
            if (!this.a) {
                this.a = true;
                InstallActivity.a(this.niD, p.CANCELLED);
                if (!(exc instanceof UnavailableException)) {
                }
                InstallActivity.a(this.niD, exc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(InstallActivity installActivity) {
        this.niD = installActivity;
    }
}
