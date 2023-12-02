package com.google.ar.core;

import android.os.Bundle;
import android.util.Log;
import com.baidu.tieba.u8c;
import com.baidu.tieba.v8c;
import com.baidu.tieba.z8c;
import com.google.ar.core.exceptions.FatalException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public final class x extends com.google.a.b.a.a.a.e {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ z8c b;

    @Override // com.google.a.b.a.a.a.d
    public final void a() {
    }

    @Override // com.google.a.b.a.a.a.d
    public final void b(Bundle bundle) {
    }

    public x(z8c z8cVar, AtomicBoolean atomicBoolean) {
        this.b = z8cVar;
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
            z8c z8cVar = this.b;
            u8c u8cVar = z8cVar.c;
            u8c.n(z8cVar.a, z8cVar.b);
        } else if (bundle.containsKey("resolution.intent")) {
            z8c z8cVar2 = this.b;
            u8c u8cVar2 = z8cVar2.c;
            u8c.b(z8cVar2.a, bundle, z8cVar2.b);
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
                    v8c v8cVar = this.b.b;
                    StringBuilder sb2 = new StringBuilder(38);
                    sb2.append("Unexpected install status: ");
                    sb2.append(i2);
                    v8cVar.b(new FatalException(sb2.toString()));
                    return;
            }
        } else {
            this.b.b.b(new FatalException("Unexpected REQUIRES_UI_INTENT install status without an intent."));
        }
    }
}
