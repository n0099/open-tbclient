package com.sdk.base.framework.a.c;

import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes15.dex */
public abstract class c<Params, Progress, Result> {

    /* renamed from: b  reason: collision with root package name */
    private static final g f13077b = new g((byte) 0);
    private static Executor c = new i();
    private final AtomicBoolean f = new AtomicBoolean();
    private final AtomicBoolean g = new AtomicBoolean();
    private volatile boolean h = false;

    /* renamed from: a  reason: collision with root package name */
    protected Boolean f13078a = Boolean.valueOf(com.sdk.base.framework.c.f.c);
    private final h<Params, Result> d = new d(this);
    private final FutureTask<Result> e = new e(this, this.d);

    /* JADX INFO: Access modifiers changed from: private */
    public Result a(Result result) {
        f13077b.obtainMessage(1, new f(this, result)).sendToTarget();
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(c cVar, Object obj) {
        if (cVar.g.get()) {
            return;
        }
        cVar.a((c) obj);
    }

    public void a() {
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Progress... progressArr) {
    }

    public final boolean a(boolean z) {
        this.f.set(true);
        return this.e.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Result b(Params... paramsArr);

    public final boolean b() {
        return this.f.get();
    }

    public final c<Params, Progress, Result> c(Params... paramsArr) {
        Executor executor = c;
        if (this.h) {
            throw new IllegalStateException("Cannot execute task: the task is already executed.");
        }
        this.h = true;
        this.d.f13083a = paramsArr;
        executor.execute(new n(0, this.e));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(Progress... progressArr) {
        if (this.f.get()) {
            return;
        }
        f13077b.obtainMessage(2, new f(this, progressArr)).sendToTarget();
    }
}
