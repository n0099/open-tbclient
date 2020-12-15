package com.google.ar.core;

import com.google.ar.core.exceptions.UnavailableException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    boolean f4053a = false;
    final /* synthetic */ InstallActivity ptB;

    public void a(p pVar) {
        synchronized (this.ptB) {
            if (!this.f4053a) {
                InstallActivity.a(this.ptB, pVar);
                switch (pVar.ordinal()) {
                    case 0:
                        return;
                    case 1:
                        InstallActivity.a(this.ptB, new UnavailableUserDeclinedInstallationException());
                        break;
                    case 2:
                        if (!InstallActivity.d(this.ptB)) {
                            InstallActivity.e(this.ptB);
                        }
                        InstallActivity.a(this.ptB, (Exception) null);
                        break;
                }
                this.f4053a = true;
            }
        }
    }

    public void a(Exception exc) {
        synchronized (this.ptB) {
            if (!this.f4053a) {
                this.f4053a = true;
                InstallActivity.a(this.ptB, p.CANCELLED);
                if (!(exc instanceof UnavailableException)) {
                }
                InstallActivity.a(this.ptB, exc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(InstallActivity installActivity) {
        this.ptB = installActivity;
    }
}
