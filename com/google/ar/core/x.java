package com.google.ar.core;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.ar.core.exceptions.FatalException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes11.dex */
final class x extends com.google.a.b.a.a.a.e {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ AtomicBoolean f4049a;
    private final /* synthetic */ aj b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(aj ajVar, AtomicBoolean atomicBoolean) {
        this.b = ajVar;
        this.f4049a = atomicBoolean;
    }

    @Override // com.google.a.b.a.a.a.d
    public final void a(Bundle bundle) throws RemoteException {
        if (!this.f4049a.getAndSet(true)) {
            int i = bundle.getInt("error.code", -100);
            int i2 = bundle.getInt("install.status", 0);
            if (i2 == 4) {
                this.b.obQ.a(p.COMPLETED);
            } else if (i != 0) {
                Log.w("ARCore-InstallService", new StringBuilder(51).append("requestInstall = ").append(i).append(", launching fullscreen.").toString());
                w wVar = this.b.oce;
                w.b(this.b.f4039a, this.b.obQ);
            } else if (bundle.containsKey("resolution.intent")) {
                w wVar2 = this.b.oce;
                w.a(this.b.f4039a, bundle, this.b.obQ);
            } else {
                switch (i2) {
                    case 1:
                    case 2:
                    case 3:
                        this.b.obQ.a(p.ACCEPTED);
                        return;
                    case 4:
                        this.b.obQ.a(p.COMPLETED);
                        return;
                    case 5:
                        this.b.obQ.a(new FatalException("Unexpected FAILED install status without error."));
                        return;
                    case 6:
                        this.b.obQ.a(p.CANCELLED);
                        return;
                    case 7:
                    case 8:
                    case 9:
                    default:
                        this.b.obQ.a(new FatalException(new StringBuilder(38).append("Unexpected install status: ").append(i2).toString()));
                        return;
                    case 10:
                        this.b.obQ.a(new FatalException("Unexpected REQUIRES_UI_INTENT install status without an intent."));
                        return;
                }
            }
        }
    }

    @Override // com.google.a.b.a.a.a.d
    public final void b(Bundle bundle) throws RemoteException {
    }

    @Override // com.google.a.b.a.a.a.d
    public final void a() throws RemoteException {
    }
}
