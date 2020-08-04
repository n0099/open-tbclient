package com.google.ar.core;

import com.google.ar.core.exceptions.UnavailableException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class y {
    boolean a = false;
    final /* synthetic */ InstallActivity niF;

    public void a(p pVar) {
        synchronized (this.niF) {
            if (!this.a) {
                InstallActivity.a(this.niF, pVar);
                switch (pVar.ordinal()) {
                    case 0:
                        return;
                    case 1:
                        InstallActivity.a(this.niF, new UnavailableUserDeclinedInstallationException());
                        break;
                    case 2:
                        if (!InstallActivity.d(this.niF)) {
                            InstallActivity.e(this.niF);
                        }
                        InstallActivity.a(this.niF, (Exception) null);
                        break;
                }
                this.a = true;
            }
        }
    }

    public void a(Exception exc) {
        synchronized (this.niF) {
            if (!this.a) {
                this.a = true;
                InstallActivity.a(this.niF, p.CANCELLED);
                if (!(exc instanceof UnavailableException)) {
                }
                InstallActivity.a(this.niF, exc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(InstallActivity installActivity) {
        this.niF = installActivity;
    }
}
