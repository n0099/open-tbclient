package com.sdk.base.framework.a.c;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class e extends FutureTask<Result> {
    private /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, Callable callable) {
        super(callable);
        this.a = cVar;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void done() {
        try {
            c.b(this.a, super.get());
        } catch (Exception e) {
            c.b(this.a, null);
            com.sdk.base.framework.a.a.c.b("PriorityAsyncTask", e.getMessage(), this.a.a);
        }
    }
}
