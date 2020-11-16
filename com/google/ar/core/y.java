package com.google.ar.core;

import com.google.ar.core.exceptions.UnavailableException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    boolean f4050a = false;
    final /* synthetic */ InstallActivity peq;

    public void a(p pVar) {
        synchronized (this.peq) {
            if (!this.f4050a) {
                InstallActivity.a(this.peq, pVar);
                switch (pVar.ordinal()) {
                    case 0:
                        return;
                    case 1:
                        InstallActivity.a(this.peq, new UnavailableUserDeclinedInstallationException());
                        break;
                    case 2:
                        if (!InstallActivity.d(this.peq)) {
                            InstallActivity.e(this.peq);
                        }
                        InstallActivity.a(this.peq, (Exception) null);
                        break;
                }
                this.f4050a = true;
            }
        }
    }

    public void a(Exception exc) {
        synchronized (this.peq) {
            if (!this.f4050a) {
                this.f4050a = true;
                InstallActivity.a(this.peq, p.CANCELLED);
                if (!(exc instanceof UnavailableException)) {
                }
                InstallActivity.a(this.peq, exc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(InstallActivity installActivity) {
        this.peq = installActivity;
    }
}
