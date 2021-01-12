package com.google.ar.core;

import com.google.ar.core.exceptions.UnavailableException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    boolean f7873a = false;
    final /* synthetic */ InstallActivity pHH;

    public void a(p pVar) {
        synchronized (this.pHH) {
            if (!this.f7873a) {
                InstallActivity.a(this.pHH, pVar);
                switch (pVar.ordinal()) {
                    case 0:
                        return;
                    case 1:
                        InstallActivity.a(this.pHH, new UnavailableUserDeclinedInstallationException());
                        break;
                    case 2:
                        if (!InstallActivity.d(this.pHH)) {
                            InstallActivity.e(this.pHH);
                        }
                        InstallActivity.a(this.pHH, (Exception) null);
                        break;
                }
                this.f7873a = true;
            }
        }
    }

    public void a(Exception exc) {
        synchronized (this.pHH) {
            if (!this.f7873a) {
                this.f7873a = true;
                InstallActivity.a(this.pHH, p.CANCELLED);
                if (!(exc instanceof UnavailableException)) {
                }
                InstallActivity.a(this.pHH, exc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(InstallActivity installActivity) {
        this.pHH = installActivity;
    }
}
