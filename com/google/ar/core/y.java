package com.google.ar.core;

import com.google.ar.core.exceptions.UnavailableException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    boolean f7873a = false;
    final /* synthetic */ InstallActivity pHI;

    public void a(p pVar) {
        synchronized (this.pHI) {
            if (!this.f7873a) {
                InstallActivity.a(this.pHI, pVar);
                switch (pVar.ordinal()) {
                    case 0:
                        return;
                    case 1:
                        InstallActivity.a(this.pHI, new UnavailableUserDeclinedInstallationException());
                        break;
                    case 2:
                        if (!InstallActivity.d(this.pHI)) {
                            InstallActivity.e(this.pHI);
                        }
                        InstallActivity.a(this.pHI, (Exception) null);
                        break;
                }
                this.f7873a = true;
            }
        }
    }

    public void a(Exception exc) {
        synchronized (this.pHI) {
            if (!this.f7873a) {
                this.f7873a = true;
                InstallActivity.a(this.pHI, p.CANCELLED);
                if (!(exc instanceof UnavailableException)) {
                }
                InstallActivity.a(this.pHI, exc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(InstallActivity installActivity) {
        this.pHI = installActivity;
    }
}
