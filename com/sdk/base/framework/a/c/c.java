package com.sdk.base.framework.a.c;

import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public abstract class c<Params, Progress, Result> {

    /* renamed from: b  reason: collision with root package name */
    public static final g f38427b = new g((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    public static Executor f38428c = new i();

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f38432f = new AtomicBoolean();

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f38433g = new AtomicBoolean();

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f38434h = false;

    /* renamed from: a  reason: collision with root package name */
    public Boolean f38429a = Boolean.valueOf(com.sdk.base.framework.c.f.f38521c);

    /* renamed from: d  reason: collision with root package name */
    public final h<Params, Result> f38430d = new d(this);

    /* renamed from: e  reason: collision with root package name */
    public final FutureTask<Result> f38431e = new e(this, this.f38430d);

    /* JADX INFO: Access modifiers changed from: private */
    public Result a(Result result) {
        f38427b.obtainMessage(1, new f(this, result)).sendToTarget();
        return result;
    }

    public static /* synthetic */ void b(c cVar, Object obj) {
        if (cVar.f38433g.get()) {
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
        this.f38432f.set(true);
        return this.f38431e.cancel(true);
    }

    public abstract Result b(Params... paramsArr);

    public final boolean b() {
        return this.f38432f.get();
    }

    public final c<Params, Progress, Result> c(Params... paramsArr) {
        Executor executor = f38428c;
        if (this.f38434h) {
            throw new IllegalStateException("Cannot execute task: the task is already executed.");
        }
        this.f38434h = true;
        this.f38430d.f38439a = paramsArr;
        executor.execute(new n(0, this.f38431e));
        return this;
    }

    public final void d(Progress... progressArr) {
        if (this.f38432f.get()) {
            return;
        }
        f38427b.obtainMessage(2, new f(this, progressArr)).sendToTarget();
    }
}
