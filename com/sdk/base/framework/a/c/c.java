package com.sdk.base.framework.a.c;

import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public abstract class c<Params, Progress, Result> {

    /* renamed from: b  reason: collision with root package name */
    public static final g f35566b = new g((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    public static Executor f35567c = new i();

    /* renamed from: f  reason: collision with root package name */
    public final AtomicBoolean f35571f = new AtomicBoolean();

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f35572g = new AtomicBoolean();

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f35573h = false;

    /* renamed from: a  reason: collision with root package name */
    public Boolean f35568a = Boolean.valueOf(com.sdk.base.framework.c.f.f35663c);

    /* renamed from: d  reason: collision with root package name */
    public final h<Params, Result> f35569d = new d(this);

    /* renamed from: e  reason: collision with root package name */
    public final FutureTask<Result> f35570e = new e(this, this.f35569d);

    /* JADX INFO: Access modifiers changed from: private */
    public Result a(Result result) {
        f35566b.obtainMessage(1, new f(this, result)).sendToTarget();
        return result;
    }

    public static /* synthetic */ void b(c cVar, Object obj) {
        if (cVar.f35572g.get()) {
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
        this.f35571f.set(true);
        return this.f35570e.cancel(true);
    }

    public abstract Result b(Params... paramsArr);

    public final boolean b() {
        return this.f35571f.get();
    }

    public final c<Params, Progress, Result> c(Params... paramsArr) {
        Executor executor = f35567c;
        if (this.f35573h) {
            throw new IllegalStateException("Cannot execute task: the task is already executed.");
        }
        this.f35573h = true;
        this.f35569d.f35578a = paramsArr;
        executor.execute(new n(0, this.f35570e));
        return this;
    }

    public final void d(Progress... progressArr) {
        if (this.f35571f.get()) {
            return;
        }
        f35566b.obtainMessage(2, new f(this, progressArr)).sendToTarget();
    }
}
