package com.sdk.base.framework.a.c;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public final class e extends FutureTask<Result> {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ c f12781a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, Callable callable) {
        super(callable);
        this.f12781a = cVar;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void done() {
        try {
            c.b(this.f12781a, super.get());
        } catch (Exception e) {
            c.b(this.f12781a, null);
            com.sdk.base.framework.a.a.c.b("PriorityAsyncTask", e.getMessage(), this.f12781a.f12779a);
        }
    }
}
