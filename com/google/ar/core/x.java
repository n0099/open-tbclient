package com.google.ar.core;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.ar.core.exceptions.FatalException;
import d.h.b.a.l;
import d.h.b.a.m;
import d.h.b.a.q;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public final class x extends com.google.a.b.a.a.a.e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f30672a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ q f30673b;

    public x(q qVar, AtomicBoolean atomicBoolean) {
        this.f30673b = qVar;
        this.f30672a = atomicBoolean;
    }

    @Override // com.google.a.b.a.a.a.d
    public final void a() throws RemoteException {
    }

    @Override // com.google.a.b.a.a.a.d
    public final void a(Bundle bundle) throws RemoteException {
        if (this.f30672a.getAndSet(true)) {
            return;
        }
        int i = bundle.getInt("error.code", -100);
        int i2 = bundle.getInt("install.status", 0);
        if (i2 == 4) {
            this.f30673b.f67075f.a(p.COMPLETED);
        } else if (i != 0) {
            StringBuilder sb = new StringBuilder(51);
            sb.append("requestInstall = ");
            sb.append(i);
            sb.append(", launching fullscreen.");
            Log.w("ARCore-InstallService", sb.toString());
            q qVar = this.f30673b;
            l lVar = qVar.f67076g;
            l.n(qVar.f67074e, qVar.f67075f);
        } else if (bundle.containsKey("resolution.intent")) {
            q qVar2 = this.f30673b;
            l lVar2 = qVar2.f67076g;
            l.b(qVar2.f67074e, bundle, qVar2.f67075f);
        } else if (i2 != 10) {
            switch (i2) {
                case 1:
                case 2:
                case 3:
                    this.f30673b.f67075f.a(p.ACCEPTED);
                    return;
                case 4:
                    this.f30673b.f67075f.a(p.COMPLETED);
                    return;
                case 5:
                    this.f30673b.f67075f.b(new FatalException("Unexpected FAILED install status without error."));
                    return;
                case 6:
                    this.f30673b.f67075f.a(p.CANCELLED);
                    return;
                default:
                    m mVar = this.f30673b.f67075f;
                    StringBuilder sb2 = new StringBuilder(38);
                    sb2.append("Unexpected install status: ");
                    sb2.append(i2);
                    mVar.b(new FatalException(sb2.toString()));
                    return;
            }
        } else {
            this.f30673b.f67075f.b(new FatalException("Unexpected REQUIRES_UI_INTENT install status without an intent."));
        }
    }

    @Override // com.google.a.b.a.a.a.d
    public final void b(Bundle bundle) throws RemoteException {
    }
}
