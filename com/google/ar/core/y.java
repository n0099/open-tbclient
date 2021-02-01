package com.google.ar.core;

import com.google.ar.core.exceptions.UnavailableException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    boolean f7875a = false;
    final /* synthetic */ InstallActivity pRN;

    public void a(p pVar) {
        synchronized (this.pRN) {
            if (!this.f7875a) {
                InstallActivity.a(this.pRN, pVar);
                switch (pVar.ordinal()) {
                    case 0:
                        return;
                    case 1:
                        InstallActivity.a(this.pRN, new UnavailableUserDeclinedInstallationException());
                        break;
                    case 2:
                        if (!InstallActivity.d(this.pRN)) {
                            InstallActivity.e(this.pRN);
                        }
                        InstallActivity.a(this.pRN, (Exception) null);
                        break;
                }
                this.f7875a = true;
            }
        }
    }

    public void a(Exception exc) {
        synchronized (this.pRN) {
            if (!this.f7875a) {
                this.f7875a = true;
                InstallActivity.a(this.pRN, p.CANCELLED);
                if (!(exc instanceof UnavailableException)) {
                }
                InstallActivity.a(this.pRN, exc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(InstallActivity installActivity) {
        this.pRN = installActivity;
    }
}
