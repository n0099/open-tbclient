package com.google.ar.core;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.ar.core.exceptions.FatalException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes11.dex */
final class x extends com.google.a.b.a.a.a.e {
    private final /* synthetic */ AtomicBoolean a;
    private final /* synthetic */ aj b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(aj ajVar, AtomicBoolean atomicBoolean) {
        this.b = ajVar;
        this.a = atomicBoolean;
    }

    @Override // com.google.a.b.a.a.a.d
    public final void a(Bundle bundle) throws RemoteException {
        if (!this.a.getAndSet(true)) {
            int i = bundle.getInt("error.code", -100);
            int i2 = bundle.getInt("install.status", 0);
            if (i2 == 4) {
                this.b.nCC.a(p.COMPLETED);
            } else if (i != 0) {
                Log.w("ARCore-InstallService", new StringBuilder(51).append("requestInstall = ").append(i).append(", launching fullscreen.").toString());
                w wVar = this.b.nCR;
                w.b(this.b.a, this.b.nCC);
            } else if (bundle.containsKey("resolution.intent")) {
                w wVar2 = this.b.nCR;
                w.a(this.b.a, bundle, this.b.nCC);
            } else {
                switch (i2) {
                    case 1:
                    case 2:
                    case 3:
                        this.b.nCC.a(p.ACCEPTED);
                        return;
                    case 4:
                        this.b.nCC.a(p.COMPLETED);
                        return;
                    case 5:
                        this.b.nCC.a(new FatalException("Unexpected FAILED install status without error."));
                        return;
                    case 6:
                        this.b.nCC.a(p.CANCELLED);
                        return;
                    case 7:
                    case 8:
                    case 9:
                    default:
                        this.b.nCC.a(new FatalException(new StringBuilder(38).append("Unexpected install status: ").append(i2).toString()));
                        return;
                    case 10:
                        this.b.nCC.a(new FatalException("Unexpected REQUIRES_UI_INTENT install status without an intent."));
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
