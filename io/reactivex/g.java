package io.reactivex;

import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.flowable.FlowableCreate;
import io.reactivex.internal.operators.flowable.FlowableInternalHelper;
import io.reactivex.internal.operators.flowable.FlowableInterval;
import io.reactivex.internal.operators.flowable.FlowableIntervalRange;
import io.reactivex.internal.operators.flowable.FlowableObserveOn;
import io.reactivex.internal.operators.flowable.FlowableRetryPredicate;
import io.reactivex.internal.operators.flowable.FlowableSubscribeOn;
import io.reactivex.internal.operators.flowable.FlowableUnsubscribeOn;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.subscribers.StrictSubscriber;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public abstract class g<T> implements org.a.b<T> {
    static final int BUFFER_SIZE = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    protected abstract void a(org.a.c<? super T> cVar);

    public static int dKG() {
        return BUFFER_SIZE;
    }

    public static <T> g<T> a(i<T> iVar, BackpressureStrategy backpressureStrategy) {
        io.reactivex.internal.functions.a.k(iVar, "source is null");
        io.reactivex.internal.functions.a.k(backpressureStrategy, "mode is null");
        return io.reactivex.e.a.a(new FlowableCreate(iVar, backpressureStrategy));
    }

    public static <T> g<T> dKH() {
        return io.reactivex.e.a.a(io.reactivex.internal.operators.flowable.e.noC);
    }

    public static g<Long> a(long j, long j2, TimeUnit timeUnit) {
        return a(j, j2, timeUnit, io.reactivex.f.a.dLq());
    }

    public static g<Long> a(long j, long j2, TimeUnit timeUnit, v vVar) {
        io.reactivex.internal.functions.a.k(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.k(vVar, "scheduler is null");
        return io.reactivex.e.a.a(new FlowableInterval(Math.max(0L, j), Math.max(0L, j2), timeUnit, vVar));
    }

    public static g<Long> a(long j, long j2, long j3, long j4, TimeUnit timeUnit) {
        return a(j, j2, j3, j4, timeUnit, io.reactivex.f.a.dLq());
    }

    public static g<Long> a(long j, long j2, long j3, long j4, TimeUnit timeUnit, v vVar) {
        if (j2 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j2);
        }
        if (j2 == 0) {
            return dKH().a(j3, timeUnit, vVar);
        }
        long j5 = j + (j2 - 1);
        if (j > 0 && j5 < 0) {
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
        io.reactivex.internal.functions.a.k(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.k(vVar, "scheduler is null");
        return io.reactivex.e.a.a(new FlowableIntervalRange(j, j5, Math.max(0L, j3), Math.max(0L, j4), timeUnit, vVar));
    }

    public final g<T> a(long j, TimeUnit timeUnit, v vVar) {
        return a(j, timeUnit, vVar, false);
    }

    public final g<T> a(long j, TimeUnit timeUnit, v vVar, boolean z) {
        io.reactivex.internal.functions.a.k(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.k(vVar, "scheduler is null");
        return io.reactivex.e.a.a(new io.reactivex.internal.operators.flowable.b(this, Math.max(0L, j), timeUnit, vVar, z));
    }

    public final g<T> a(io.reactivex.c.a aVar) {
        return a(Functions.dKQ(), Functions.nnO, aVar);
    }

    public final g<T> b(io.reactivex.c.a aVar) {
        return a(Functions.dKQ(), Functions.dKQ(), aVar, Functions.nnK);
    }

    private g<T> a(io.reactivex.c.g<? super T> gVar, io.reactivex.c.g<? super Throwable> gVar2, io.reactivex.c.a aVar, io.reactivex.c.a aVar2) {
        io.reactivex.internal.functions.a.k(gVar, "onNext is null");
        io.reactivex.internal.functions.a.k(gVar2, "onError is null");
        io.reactivex.internal.functions.a.k(aVar, "onComplete is null");
        io.reactivex.internal.functions.a.k(aVar2, "onAfterTerminate is null");
        return io.reactivex.e.a.a(new io.reactivex.internal.operators.flowable.c(this, gVar, gVar2, aVar, aVar2));
    }

    public final g<T> a(io.reactivex.c.g<? super org.a.d> gVar, io.reactivex.c.i iVar, io.reactivex.c.a aVar) {
        io.reactivex.internal.functions.a.k(gVar, "onSubscribe is null");
        io.reactivex.internal.functions.a.k(iVar, "onRequest is null");
        io.reactivex.internal.functions.a.k(aVar, "onCancel is null");
        return io.reactivex.e.a.a(new io.reactivex.internal.operators.flowable.d(this, gVar, iVar, aVar));
    }

    public final g<T> a(io.reactivex.c.g<? super org.a.d> gVar) {
        return a(gVar, Functions.nnO, Functions.nnK);
    }

    public final <R> g<R> a(io.reactivex.c.h<? super T, ? extends R> hVar) {
        io.reactivex.internal.functions.a.k(hVar, "mapper is null");
        return io.reactivex.e.a.a(new io.reactivex.internal.operators.flowable.f(this, hVar));
    }

    public final g<T> a(v vVar) {
        return a(vVar, false, dKG());
    }

    public final g<T> a(v vVar, boolean z, int i) {
        io.reactivex.internal.functions.a.k(vVar, "scheduler is null");
        io.reactivex.internal.functions.a.bD(i, "bufferSize");
        return io.reactivex.e.a.a(new FlowableObserveOn(this, vVar, z, i));
    }

    public final g<T> a(long j, io.reactivex.c.j<? super Throwable> jVar) {
        if (j < 0) {
            throw new IllegalArgumentException("times >= 0 required but it was " + j);
        }
        io.reactivex.internal.functions.a.k(jVar, "predicate is null");
        return io.reactivex.e.a.a(new FlowableRetryPredicate(this, j, jVar));
    }

    public final io.reactivex.disposables.b b(io.reactivex.c.g<? super T> gVar) {
        return a(gVar, Functions.nnN, Functions.nnK, FlowableInternalHelper.RequestMax.INSTANCE);
    }

    public final io.reactivex.disposables.b a(io.reactivex.c.g<? super T> gVar, io.reactivex.c.g<? super Throwable> gVar2) {
        return a(gVar, gVar2, Functions.nnK, FlowableInternalHelper.RequestMax.INSTANCE);
    }

    public final io.reactivex.disposables.b a(io.reactivex.c.g<? super T> gVar, io.reactivex.c.g<? super Throwable> gVar2, io.reactivex.c.a aVar) {
        return a(gVar, gVar2, aVar, FlowableInternalHelper.RequestMax.INSTANCE);
    }

    public final io.reactivex.disposables.b a(io.reactivex.c.g<? super T> gVar, io.reactivex.c.g<? super Throwable> gVar2, io.reactivex.c.a aVar, io.reactivex.c.g<? super org.a.d> gVar3) {
        io.reactivex.internal.functions.a.k(gVar, "onNext is null");
        io.reactivex.internal.functions.a.k(gVar2, "onError is null");
        io.reactivex.internal.functions.a.k(aVar, "onComplete is null");
        io.reactivex.internal.functions.a.k(gVar3, "onSubscribe is null");
        LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(gVar, gVar2, aVar, gVar3);
        a((j) lambdaSubscriber);
        return lambdaSubscriber;
    }

    @Override // org.a.b
    public final void subscribe(org.a.c<? super T> cVar) {
        if (cVar instanceof j) {
            a((j) ((j) cVar));
            return;
        }
        io.reactivex.internal.functions.a.k(cVar, "s is null");
        a((j) new StrictSubscriber(cVar));
    }

    public final void a(j<? super T> jVar) {
        io.reactivex.internal.functions.a.k(jVar, "s is null");
        try {
            org.a.c<? super T> a = io.reactivex.e.a.a(this, jVar);
            io.reactivex.internal.functions.a.k(a, "Plugin returned null Subscriber");
            a(a);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.L(th);
            io.reactivex.e.a.onError(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final g<T> b(v vVar) {
        io.reactivex.internal.functions.a.k(vVar, "scheduler is null");
        return a(vVar, !(this instanceof FlowableCreate));
    }

    public final g<T> a(v vVar, boolean z) {
        io.reactivex.internal.functions.a.k(vVar, "scheduler is null");
        return io.reactivex.e.a.a(new FlowableSubscribeOn(this, vVar, z));
    }

    public final g<T> c(v vVar) {
        io.reactivex.internal.functions.a.k(vVar, "scheduler is null");
        return io.reactivex.e.a.a(new FlowableUnsubscribeOn(this, vVar));
    }
}
