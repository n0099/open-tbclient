package com.sdk.base.framework.a.c;

import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public abstract class c<Params, Progress, Result> {

    /* renamed from: b  reason: collision with root package name */
    public static final g f38426b = new g((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    public static Executor f38427c = new i();

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f38431f = new AtomicBoolean();

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f38432g = new AtomicBoolean();

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f38433h = false;

    /* renamed from: a  reason: collision with root package name */
    public Boolean f38428a = Boolean.valueOf(com.sdk.base.framework.c.f.f38520c);

    /* renamed from: d  reason: collision with root package name */
    public final h<Params, Result> f38429d = new d(this);

    /* renamed from: e  reason: collision with root package name */
    public final FutureTask<Result> f38430e = new e(this, this.f38429d);

    /* JADX INFO: Access modifiers changed from: private */
    public Result a(Result result) {
        f38426b.obtainMessage(1, new f(this, result)).sendToTarget();
        return result;
    }

    public static /* synthetic */ void b(c cVar, Object obj) {
        if (cVar.f38432g.get()) {
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
        this.f38431f.set(true);
        return this.f38430e.cancel(true);
    }

    public abstract Result b(Params... paramsArr);

    public final boolean b() {
        return this.f38431f.get();
    }

    public final c<Params, Progress, Result> c(Params... paramsArr) {
        Executor executor = f38427c;
        if (this.f38433h) {
            throw new IllegalStateException("Cannot execute task: the task is already executed.");
        }
        this.f38433h = true;
        this.f38429d.f38438a = paramsArr;
        executor.execute(new n(0, this.f38430e));
        return this;
    }

    public final void d(Progress... progressArr) {
        if (this.f38431f.get()) {
            return;
        }
        f38426b.obtainMessage(2, new f(this, progressArr)).sendToTarget();
    }
}
