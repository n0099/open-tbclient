package com.google.ar.core;

import android.os.Bundle;
import android.util.Log;
import com.baidu.tieba.jvb;
import com.baidu.tieba.kvb;
import com.baidu.tieba.ovb;
import com.google.ar.core.exceptions.FatalException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class x extends com.google.a.b.a.a.a.e {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ ovb b;

    @Override // com.google.a.b.a.a.a.d
    public final void a() {
    }

    @Override // com.google.a.b.a.a.a.d
    public final void b(Bundle bundle) {
    }

    public x(ovb ovbVar, AtomicBoolean atomicBoolean) {
        this.b = ovbVar;
        this.a = atomicBoolean;
    }

    @Override // com.google.a.b.a.a.a.d
    public final void a(Bundle bundle) {
        if (this.a.getAndSet(true)) {
            return;
        }
        int i = bundle.getInt("error.code", -100);
        int i2 = bundle.getInt("install.status", 0);
        if (i2 == 4) {
            this.b.b.a(p.COMPLETED);
        } else if (i != 0) {
            StringBuilder sb = new StringBuilder(51);
            sb.append("requestInstall = ");
            sb.append(i);
            sb.append(", launching fullscreen.");
            Log.w("ARCore-InstallService", sb.toString());
            ovb ovbVar = this.b;
            jvb jvbVar = ovbVar.c;
            jvb.n(ovbVar.a, ovbVar.b);
        } else if (bundle.containsKey("resolution.intent")) {
            ovb ovbVar2 = this.b;
            jvb jvbVar2 = ovbVar2.c;
            jvb.b(ovbVar2.a, bundle, ovbVar2.b);
        } else if (i2 != 10) {
            switch (i2) {
                case 1:
                case 2:
                case 3:
                    this.b.b.a(p.ACCEPTED);
                    return;
                case 4:
                    this.b.b.a(p.COMPLETED);
                    return;
                case 5:
                    this.b.b.b(new FatalException("Unexpected FAILED install status without error."));
                    return;
                case 6:
                    this.b.b.a(p.CANCELLED);
                    return;
                default:
                    kvb kvbVar = this.b.b;
                    StringBuilder sb2 = new StringBuilder(38);
                    sb2.append("Unexpected install status: ");
                    sb2.append(i2);
                    kvbVar.b(new FatalException(sb2.toString()));
                    return;
            }
        } else {
            this.b.b.b(new FatalException("Unexpected REQUIRES_UI_INTENT install status without an intent."));
        }
    }
}
