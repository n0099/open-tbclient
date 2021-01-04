package com.google.ar.core;

import com.google.ar.core.exceptions.UnavailableException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    boolean f8172a = false;
    final /* synthetic */ InstallActivity pKA;

    public void a(p pVar) {
        synchronized (this.pKA) {
            if (!this.f8172a) {
                InstallActivity.a(this.pKA, pVar);
                switch (pVar.ordinal()) {
                    case 0:
                        return;
                    case 1:
                        InstallActivity.a(this.pKA, new UnavailableUserDeclinedInstallationException());
                        break;
                    case 2:
                        if (!InstallActivity.d(this.pKA)) {
                            InstallActivity.e(this.pKA);
                        }
                        InstallActivity.a(this.pKA, (Exception) null);
                        break;
                }
                this.f8172a = true;
            }
        }
    }

    public void a(Exception exc) {
        synchronized (this.pKA) {
            if (!this.f8172a) {
                this.f8172a = true;
                InstallActivity.a(this.pKA, p.CANCELLED);
                if (!(exc instanceof UnavailableException)) {
                }
                InstallActivity.a(this.pKA, exc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(InstallActivity installActivity) {
        this.pKA = installActivity;
    }
}
