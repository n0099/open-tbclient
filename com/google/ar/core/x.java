package com.google.ar.core;

import android.os.Bundle;
import android.util.Log;
import com.baidu.tieba.aja;
import com.baidu.tieba.bja;
import com.baidu.tieba.fja;
import com.google.ar.core.exceptions.FatalException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public final class x extends com.google.a.b.a.a.a.e {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ fja b;

    @Override // com.google.a.b.a.a.a.d
    public final void a() {
    }

    @Override // com.google.a.b.a.a.a.d
    public final void b(Bundle bundle) {
    }

    public x(fja fjaVar, AtomicBoolean atomicBoolean) {
        this.b = fjaVar;
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
            fja fjaVar = this.b;
            aja ajaVar = fjaVar.c;
            aja.n(fjaVar.a, fjaVar.b);
        } else if (bundle.containsKey("resolution.intent")) {
            fja fjaVar2 = this.b;
            aja ajaVar2 = fjaVar2.c;
            aja.b(fjaVar2.a, bundle, fjaVar2.b);
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
                    bja bjaVar = this.b.b;
                    StringBuilder sb2 = new StringBuilder(38);
                    sb2.append("Unexpected install status: ");
                    sb2.append(i2);
                    bjaVar.b(new FatalException(sb2.toString()));
                    return;
            }
        } else {
            this.b.b.b(new FatalException("Unexpected REQUIRES_UI_INTENT install status without an intent."));
        }
    }
}
