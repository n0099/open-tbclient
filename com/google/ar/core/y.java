package com.google.ar.core;

import com.google.ar.core.exceptions.UnavailableException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    boolean f4053a = false;
    final /* synthetic */ InstallActivity ptz;

    public void a(p pVar) {
        synchronized (this.ptz) {
            if (!this.f4053a) {
                InstallActivity.a(this.ptz, pVar);
                switch (pVar.ordinal()) {
                    case 0:
                        return;
                    case 1:
                        InstallActivity.a(this.ptz, new UnavailableUserDeclinedInstallationException());
                        break;
                    case 2:
                        if (!InstallActivity.d(this.ptz)) {
                            InstallActivity.e(this.ptz);
                        }
                        InstallActivity.a(this.ptz, (Exception) null);
                        break;
                }
                this.f4053a = true;
            }
        }
    }

    public void a(Exception exc) {
        synchronized (this.ptz) {
            if (!this.f4053a) {
                this.f4053a = true;
                InstallActivity.a(this.ptz, p.CANCELLED);
                if (!(exc instanceof UnavailableException)) {
                }
                InstallActivity.a(this.ptz, exc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(InstallActivity installActivity) {
        this.ptz = installActivity;
    }
}
