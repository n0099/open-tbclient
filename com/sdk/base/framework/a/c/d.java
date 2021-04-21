package com.sdk.base.framework.a.c;

import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public final class d extends h<Params, Result> {

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ c f38819b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar) {
        super((byte) 0);
        this.f38819b = cVar;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, Result] */
    @Override // java.util.concurrent.Callable
    public final Result call() {
        AtomicBoolean atomicBoolean;
        ?? a2;
        atomicBoolean = this.f38819b.f38817g;
        atomicBoolean.set(true);
        Process.setThreadPriority(10);
        c cVar = this.f38819b;
        a2 = cVar.a((c) cVar.b(this.f38823a));
        return a2;
    }
}
