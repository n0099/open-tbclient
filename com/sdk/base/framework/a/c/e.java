package com.sdk.base.framework.a.c;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* loaded from: classes6.dex */
public final class e extends FutureTask<Result> {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ c f38435a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, Callable callable) {
        super(callable);
        this.f38435a = cVar;
    }

    @Override // java.util.concurrent.FutureTask
    public final void done() {
        try {
            c.b(this.f38435a, super.get());
        } catch (Exception e2) {
            c.b(this.f38435a, null);
            com.sdk.base.framework.a.a.c.b("PriorityAsyncTask", e2.getMessage(), this.f38435a.f38428a);
        }
    }
}
