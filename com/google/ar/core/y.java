package com.google.ar.core;

import com.google.ar.core.exceptions.UnavailableException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    boolean f4050a = false;
    final /* synthetic */ InstallActivity ocb;

    public void a(p pVar) {
        synchronized (this.ocb) {
            if (!this.f4050a) {
                InstallActivity.a(this.ocb, pVar);
                switch (pVar.ordinal()) {
                    case 0:
                        return;
                    case 1:
                        InstallActivity.a(this.ocb, new UnavailableUserDeclinedInstallationException());
                        break;
                    case 2:
                        if (!InstallActivity.d(this.ocb)) {
                            InstallActivity.e(this.ocb);
                        }
                        InstallActivity.a(this.ocb, (Exception) null);
                        break;
                }
                this.f4050a = true;
            }
        }
    }

    public void a(Exception exc) {
        synchronized (this.ocb) {
            if (!this.f4050a) {
                this.f4050a = true;
                InstallActivity.a(this.ocb, p.CANCELLED);
                if (!(exc instanceof UnavailableException)) {
                }
                InstallActivity.a(this.ocb, exc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(InstallActivity installActivity) {
        this.ocb = installActivity;
    }
}
