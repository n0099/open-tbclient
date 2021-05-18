package com.sdk.base.framework.a.c;

import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public abstract class c<Params, Progress, Result> {

    /* renamed from: b  reason: collision with root package name */
    public static final g f35637b = new g((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    public static Executor f35638c = new i();

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f35642f = new AtomicBoolean();

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f35643g = new AtomicBoolean();

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f35644h = false;

    /* renamed from: a  reason: collision with root package name */
    public Boolean f35639a = Boolean.valueOf(com.sdk.base.framework.c.f.f35734c);

    /* renamed from: d  reason: collision with root package name */
    public final h<Params, Result> f35640d = new d(this);

    /* renamed from: e  reason: collision with root package name */
    public final FutureTask<Result> f35641e = new e(this, this.f35640d);

    /* JADX INFO: Access modifiers changed from: private */
    public Result a(Result result) {
        f35637b.obtainMessage(1, new f(this, result)).sendToTarget();
        return result;
    }

    public static /* synthetic */ void b(c cVar, Object obj) {
        if (cVar.f35643g.get()) {
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
        this.f35642f.set(true);
        return this.f35641e.cancel(true);
    }

    public abstract Result b(Params... paramsArr);

    public final boolean b() {
        return this.f35642f.get();
    }

    public final c<Params, Progress, Result> c(Params... paramsArr) {
        Executor executor = f35638c;
        if (this.f35644h) {
            throw new IllegalStateException("Cannot execute task: the task is already executed.");
        }
        this.f35644h = true;
        this.f35640d.f35649a = paramsArr;
        executor.execute(new n(0, this.f35641e));
        return this;
    }

    public final void d(Progress... progressArr) {
        if (this.f35642f.get()) {
            return;
        }
        f35637b.obtainMessage(2, new f(this, progressArr)).sendToTarget();
    }
}
