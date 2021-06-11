package com.sdk.base.framework.a.c;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes7.dex */
public final class e extends FutureTask<Result> {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ c f39254a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, Callable callable) {
        super(callable);
        this.f39254a = cVar;
    }

    @Override // java.util.concurrent.FutureTask
    public final void done() {
        try {
            c.b(this.f39254a, super.get());
        } catch (Exception e2) {
            c.b(this.f39254a, null);
            com.sdk.base.framework.a.a.c.b("PriorityAsyncTask", e2.getMessage(), this.f39254a.f39247a);
        }
    }
}
