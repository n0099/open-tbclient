package com.google.ar.core;

import com.google.ar.core.exceptions.UnavailableException;
import com.google.ar.core.exceptions.UnavailableUserDeclinedInstallationException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    boolean f7875a = false;
    final /* synthetic */ InstallActivity pSn;

    public void a(p pVar) {
        synchronized (this.pSn) {
            if (!this.f7875a) {
                InstallActivity.a(this.pSn, pVar);
                switch (pVar.ordinal()) {
                    case 0:
                        return;
                    case 1:
                        InstallActivity.a(this.pSn, new UnavailableUserDeclinedInstallationException());
                        break;
                    case 2:
                        if (!InstallActivity.d(this.pSn)) {
                            InstallActivity.e(this.pSn);
                        }
                        InstallActivity.a(this.pSn, (Exception) null);
                        break;
                }
                this.f7875a = true;
            }
        }
    }

    public void a(Exception exc) {
        synchronized (this.pSn) {
            if (!this.f7875a) {
                this.f7875a = true;
                InstallActivity.a(this.pSn, p.CANCELLED);
                if (!(exc instanceof UnavailableException)) {
                }
                InstallActivity.a(this.pSn, exc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(InstallActivity installActivity) {
        this.pSn = installActivity;
    }
}
