package com.sdk.base.framework.a.c;

import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public final class d extends h<Params, Result> {

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ c f12780b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar) {
        super((byte) 0);
        this.f12780b = cVar;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, Result] */
    @Override // java.util.concurrent.Callable
    public final Result call() {
        AtomicBoolean atomicBoolean;
        ?? a2;
        atomicBoolean = this.f12780b.g;
        atomicBoolean.set(true);
        Process.setThreadPriority(10);
        a2 = this.f12780b.a((c) this.f12780b.b(this.f12784a));
        return a2;
    }
}
