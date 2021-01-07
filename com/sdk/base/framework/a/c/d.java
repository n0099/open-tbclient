package com.sdk.base.framework.a.c;

import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class d extends h<Params, Result> {

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ c f13080b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(c cVar) {
        super((byte) 0);
        this.f13080b = cVar;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, Result] */
    @Override // java.util.concurrent.Callable
    public final Result call() {
        AtomicBoolean atomicBoolean;
        ?? a2;
        atomicBoolean = this.f13080b.g;
        atomicBoolean.set(true);
        Process.setThreadPriority(10);
        a2 = this.f13080b.a((c) this.f13080b.b(this.f13084a));
        return a2;
    }
}
