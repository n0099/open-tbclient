package com.sdk.base.framework.a.c;

import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public abstract class c<Params, Progress, Result> {

    /* renamed from: b  reason: collision with root package name */
    public static final g f36392b = new g((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    public static Executor f36393c = new i();

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f36397f = new AtomicBoolean();

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f36398g = new AtomicBoolean();

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f36399h = false;

    /* renamed from: a  reason: collision with root package name */
    public Boolean f36394a = Boolean.valueOf(com.sdk.base.framework.c.f.f36489c);

    /* renamed from: d  reason: collision with root package name */
    public final h<Params, Result> f36395d = new d(this);

    /* renamed from: e  reason: collision with root package name */
    public final FutureTask<Result> f36396e = new e(this, this.f36395d);

    /* JADX INFO: Access modifiers changed from: private */
    public Result a(Result result) {
        f36392b.obtainMessage(1, new f(this, result)).sendToTarget();
        return result;
    }

    public static /* synthetic */ void b(c cVar, Object obj) {
        if (cVar.f36398g.get()) {
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
        this.f36397f.set(true);
        return this.f36396e.cancel(true);
    }

    public abstract Result b(Params... paramsArr);

    public final boolean b() {
        return this.f36397f.get();
    }

    public final c<Params, Progress, Result> c(Params... paramsArr) {
        Executor executor = f36393c;
        if (this.f36399h) {
            throw new IllegalStateException("Cannot execute task: the task is already executed.");
        }
        this.f36399h = true;
        this.f36395d.f36404a = paramsArr;
        executor.execute(new n(0, this.f36396e));
        return this;
    }

    public final void d(Progress... progressArr) {
        if (this.f36397f.get()) {
            return;
        }
        f36392b.obtainMessage(2, new f(this, progressArr)).sendToTarget();
    }
}
