package com.google.ar.core;

import android.os.Bundle;
import android.util.Log;
import com.baidu.tieba.tlb;
import com.baidu.tieba.ulb;
import com.baidu.tieba.ylb;
import com.google.ar.core.exceptions.FatalException;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class x extends com.google.a.b.a.a.a.e {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ ylb b;

    @Override // com.google.a.b.a.a.a.d
    public final void a() {
    }

    @Override // com.google.a.b.a.a.a.d
    public final void b(Bundle bundle) {
    }

    public x(ylb ylbVar, AtomicBoolean atomicBoolean) {
        this.b = ylbVar;
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
            ylb ylbVar = this.b;
            tlb tlbVar = ylbVar.c;
            tlb.n(ylbVar.a, ylbVar.b);
        } else if (bundle.containsKey("resolution.intent")) {
            ylb ylbVar2 = this.b;
            tlb tlbVar2 = ylbVar2.c;
            tlb.b(ylbVar2.a, bundle, ylbVar2.b);
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
                    ulb ulbVar = this.b.b;
                    StringBuilder sb2 = new StringBuilder(38);
                    sb2.append("Unexpected install status: ");
                    sb2.append(i2);
                    ulbVar.b(new FatalException(sb2.toString()));
                    return;
            }
        } else {
            this.b.b.b(new FatalException("Unexpected REQUIRES_UI_INTENT install status without an intent."));
        }
    }
}
