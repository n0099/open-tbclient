package com.sdk.base.framework.a.c;

import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public abstract class c<Params, Progress, Result> {

    /* renamed from: b  reason: collision with root package name */
    public static final g f39245b = new g((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    public static Executor f39246c = new i();

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f39250f = new AtomicBoolean();

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f39251g = new AtomicBoolean();

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f39252h = false;

    /* renamed from: a  reason: collision with root package name */
    public Boolean f39247a = Boolean.valueOf(com.sdk.base.framework.c.f.f39342c);

    /* renamed from: d  reason: collision with root package name */
    public final h<Params, Result> f39248d = new d(this);

    /* renamed from: e  reason: collision with root package name */
    public final FutureTask<Result> f39249e = new e(this, this.f39248d);

    /* JADX INFO: Access modifiers changed from: private */
    public Result a(Result result) {
        f39245b.obtainMessage(1, new f(this, result)).sendToTarget();
        return result;
    }

    public static /* synthetic */ void b(c cVar, Object obj) {
        if (cVar.f39251g.get()) {
            return;
        }
        cVar.a((c) obj);
    }

    public void a() {
        a(true);
    }

    public void a(Progress... progressArr) {
    }

    public final boolean a(boolean z) {
        this.f39250f.set(true);
        return this.f39249e.cancel(true);
    }

    public abstract Result b(Params... paramsArr);

    public final boolean b() {
        return this.f39250f.get();
    }

    public final c<Params, Progress, Result> c(Params... paramsArr) {
        Executor executor = f39246c;
        if (this.f39252h) {
            throw new IllegalStateException("Cannot execute task: the task is already executed.");
        }
        this.f39252h = true;
        this.f39248d.f39257a = paramsArr;
        executor.execute(new n(0, this.f39249e));
        return this;
    }

    public final void d(Progress... progressArr) {
        if (this.f39250f.get()) {
            return;
        }
        f39245b.obtainMessage(2, new f(this, progressArr)).sendToTarget();
    }
}
