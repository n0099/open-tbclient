package com.google.ar.core;

import android.os.Bundle;
import android.util.Log;
import com.google.ar.core.exceptions.FatalException;
import d.g.b.a.l;
import d.g.b.a.m;
import d.g.b.a.q;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public final class x extends com.google.a.b.a.a.a.e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f30854a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ q f30855b;

    public x(q qVar, AtomicBoolean atomicBoolean) {
        this.f30855b = qVar;
        this.f30854a = atomicBoolean;
    }

    @Override // com.google.a.b.a.a.a.d
    public final void a() {
    }

    @Override // com.google.a.b.a.a.a.d
    public final void a(Bundle bundle) {
        if (this.f30854a.getAndSet(true)) {
            return;
        }
        int i2 = bundle.getInt("error.code", -100);
        int i3 = bundle.getInt("install.status", 0);
        if (i3 == 4) {
            this.f30855b.f66176f.a(p.COMPLETED);
        } else if (i2 != 0) {
            StringBuilder sb = new StringBuilder(51);
            sb.append("requestInstall = ");
            sb.append(i2);
            sb.append(", launching fullscreen.");
            Log.w("ARCore-InstallService", sb.toString());
            q qVar = this.f30855b;
            l lVar = qVar.f66177g;
            l.n(qVar.f66175e, qVar.f66176f);
        } else if (bundle.containsKey("resolution.intent")) {
            q qVar2 = this.f30855b;
            l lVar2 = qVar2.f66177g;
            l.b(qVar2.f66175e, bundle, qVar2.f66176f);
        } else if (i3 != 10) {
            switch (i3) {
                case 1:
                case 2:
                case 3:
                    this.f30855b.f66176f.a(p.ACCEPTED);
                    return;
                case 4:
                    this.f30855b.f66176f.a(p.COMPLETED);
                    return;
                case 5:
                    this.f30855b.f66176f.b(new FatalException("Unexpected FAILED install status without error."));
                    return;
                case 6:
                    this.f30855b.f66176f.a(p.CANCELLED);
                    return;
                default:
                    m mVar = this.f30855b.f66176f;
                    StringBuilder sb2 = new StringBuilder(38);
                    sb2.append("Unexpected install status: ");
                    sb2.append(i3);
                    mVar.b(new FatalException(sb2.toString()));
                    return;
            }
        } else {
            this.f30855b.f66176f.b(new FatalException("Unexpected REQUIRES_UI_INTENT install status without an intent."));
        }
    }

    @Override // com.google.a.b.a.a.a.d
    public final void b(Bundle bundle) {
    }
}
