package com.google.ar.core;

import com.google.ar.core.exceptions.UnavailableException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    boolean f4048a = false;
    final /* synthetic */ InstallActivity oTs;

    public void a(p pVar) {
        synchronized (this.oTs) {
            if (!this.f4048a) {
                InstallActivity.a(this.oTs, pVar);
                switch (pVar.ordinal()) {
                    case 0:
                        return;
                    case 1:
                        InstallActivity.a(this.oTs, new UnavailableUserDeclinedInstallationException());
                        break;
                    case 2:
                        if (!InstallActivity.d(this.oTs)) {
                            InstallActivity.e(this.oTs);
                        }
                        InstallActivity.a(this.oTs, (Exception) null);
                        break;
                }
                this.f4048a = true;
            }
        }
    }

    public void a(Exception exc) {
        synchronized (this.oTs) {
            if (!this.f4048a) {
                this.f4048a = true;
                InstallActivity.a(this.oTs, p.CANCELLED);
                if (!(exc instanceof UnavailableException)) {
                }
                InstallActivity.a(this.oTs, exc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(InstallActivity installActivity) {
        this.oTs = installActivity;
    }
}
