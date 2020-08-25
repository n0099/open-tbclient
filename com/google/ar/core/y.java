package com.google.ar.core;

import com.google.ar.core.exceptions.UnavailableException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class y {
    boolean a = false;
    final /* synthetic */ InstallActivity nCw;

    public void a(p pVar) {
        synchronized (this.nCw) {
            if (!this.a) {
                InstallActivity.a(this.nCw, pVar);
                switch (pVar.ordinal()) {
                    case 0:
                        return;
                    case 1:
                        InstallActivity.a(this.nCw, new UnavailableUserDeclinedInstallationException());
                        break;
                    case 2:
                        if (!InstallActivity.d(this.nCw)) {
                            InstallActivity.e(this.nCw);
                        }
                        InstallActivity.a(this.nCw, (Exception) null);
                        break;
                }
                this.a = true;
            }
        }
    }

    public void a(Exception exc) {
        synchronized (this.nCw) {
            if (!this.a) {
                this.a = true;
                InstallActivity.a(this.nCw, p.CANCELLED);
                if (!(exc instanceof UnavailableException)) {
                }
                InstallActivity.a(this.nCw, exc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(InstallActivity installActivity) {
        this.nCw = installActivity;
    }
}
