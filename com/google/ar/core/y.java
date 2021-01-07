package com.google.ar.core;

import com.google.ar.core.exceptions.UnavailableException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    boolean f8173a = false;
    final /* synthetic */ InstallActivity pMi;

    public void a(p pVar) {
        synchronized (this.pMi) {
            if (!this.f8173a) {
                InstallActivity.a(this.pMi, pVar);
                switch (pVar.ordinal()) {
                    case 0:
                        return;
                    case 1:
                        InstallActivity.a(this.pMi, new UnavailableUserDeclinedInstallationException());
                        break;
                    case 2:
                        if (!InstallActivity.d(this.pMi)) {
                            InstallActivity.e(this.pMi);
                        }
                        InstallActivity.a(this.pMi, (Exception) null);
                        break;
                }
                this.f8173a = true;
            }
        }
    }

    public void a(Exception exc) {
        synchronized (this.pMi) {
            if (!this.f8173a) {
                this.f8173a = true;
                InstallActivity.a(this.pMi, p.CANCELLED);
                if (!(exc instanceof UnavailableException)) {
                }
                InstallActivity.a(this.pMi, exc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(InstallActivity installActivity) {
        this.pMi = installActivity;
    }
}
