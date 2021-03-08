package com.google.ar.core;

import com.google.ar.core.exceptions.UnavailableException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    boolean f5273a = false;
    final /* synthetic */ InstallActivity pTc;

    public void a(p pVar) {
        synchronized (this.pTc) {
            if (!this.f5273a) {
                InstallActivity.a(this.pTc, pVar);
                switch (pVar.ordinal()) {
                    case 0:
                        return;
                    case 1:
                        InstallActivity.a(this.pTc, new UnavailableUserDeclinedInstallationException());
                        break;
                    case 2:
                        if (!InstallActivity.d(this.pTc)) {
                            InstallActivity.e(this.pTc);
                        }
                        InstallActivity.a(this.pTc, (Exception) null);
                        break;
                }
                this.f5273a = true;
            }
        }
    }

    public void a(Exception exc) {
        synchronized (this.pTc) {
            if (!this.f5273a) {
                this.f5273a = true;
                InstallActivity.a(this.pTc, p.CANCELLED);
                if (!(exc instanceof UnavailableException)) {
                }
                InstallActivity.a(this.pTc, exc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(InstallActivity installActivity) {
        this.pTc = installActivity;
    }
}
