package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import g.d;
import g.f;
import g.j;
import g.n.a;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.subjects.UnicastSubject;
/* loaded from: classes8.dex */
public final class OperatorWindowWithSize$WindowOverlap<T> extends j<T> implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final j<? super d<T>> f45434e;

    /* renamed from: f  reason: collision with root package name */
    public final int f45435f;

    /* renamed from: g  reason: collision with root package name */
    public final int f45436g;

    /* renamed from: h  reason: collision with root package name */
    public final AtomicInteger f45437h;
    public final ArrayDeque<g.t.d<T, T>> i;
    public final AtomicLong j;
    public final AtomicInteger k;
    public final Queue<g.t.d<T, T>> l;
    public Throwable m;
    public volatile boolean n;
    public int o;
    public int p;

    /* loaded from: classes8.dex */
    public final class WindowOverlapProducer extends AtomicBoolean implements f {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 4625807964358024108L;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OperatorWindowWithSize$WindowOverlap this$0;

        public WindowOverlapProducer(OperatorWindowWithSize$WindowOverlap operatorWindowWithSize$WindowOverlap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {operatorWindowWithSize$WindowOverlap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = operatorWindowWithSize$WindowOverlap;
        }

        @Override // g.f
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + j);
                } else if (i != 0) {
                    OperatorWindowWithSize$WindowOverlap operatorWindowWithSize$WindowOverlap = this.this$0;
                    if (!get() && compareAndSet(false, true)) {
                        operatorWindowWithSize$WindowOverlap.e(g.o.a.a.a(g.o.a.a.c(operatorWindowWithSize$WindowOverlap.f45436g, j - 1), operatorWindowWithSize$WindowOverlap.f45435f));
                    } else {
                        this.this$0.e(g.o.a.a.c(operatorWindowWithSize$WindowOverlap.f45436g, j));
                    }
                    g.o.a.a.b(operatorWindowWithSize$WindowOverlap.j, j);
                    operatorWindowWithSize$WindowOverlap.j();
                }
            }
        }
    }

    @Override // g.n.a
    public void call() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f45437h.decrementAndGet() == 0) {
            unsubscribe();
        }
    }

    public boolean i(boolean z, boolean z2, j<? super g.t.d<T, T>> jVar, Queue<g.t.d<T, T>> queue) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), jVar, queue})) == null) {
            if (jVar.isUnsubscribed()) {
                queue.clear();
                return true;
            } else if (z) {
                Throwable th = this.m;
                if (th != null) {
                    queue.clear();
                    jVar.onError(th);
                    return true;
                } else if (z2) {
                    jVar.onCompleted();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r15v0, resolved type: rx.internal.operators.OperatorWindowWithSize$WindowOverlap<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public void j() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            AtomicInteger atomicInteger = this.k;
            if (atomicInteger.getAndIncrement() != 0) {
                return;
            }
            j<? super d<T>> jVar = this.f45434e;
            Queue<g.t.d<T, T>> queue = this.l;
            int i2 = 1;
            do {
                long j = this.j.get();
                long j2 = 0;
                while (true) {
                    i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i == 0) {
                        break;
                    }
                    boolean z = this.n;
                    g.t.d<T, T> poll = queue.poll();
                    boolean z2 = poll == null;
                    if (i(z, z2, jVar, queue)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    jVar.onNext(poll);
                    j2++;
                }
                if (i == 0 && i(this.n, queue.isEmpty(), jVar, queue)) {
                    return;
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    this.j.addAndGet(-j2);
                }
                i2 = atomicInteger.addAndGet(-i2);
            } while (i2 != 0);
        }
    }

    @Override // g.e
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Iterator<g.t.d<T, T>> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().onCompleted();
            }
            this.i.clear();
            this.n = true;
            j();
        }
    }

    @Override // g.e
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
            Iterator<g.t.d<T, T>> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().onError(th);
            }
            this.i.clear();
            this.m = th;
            this.n = true;
            j();
        }
    }

    @Override // g.e
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, t) == null) {
            int i = this.o;
            ArrayDeque<g.t.d<T, T>> arrayDeque = this.i;
            if (i == 0 && !this.f45434e.isUnsubscribed()) {
                this.f45437h.getAndIncrement();
                UnicastSubject F = UnicastSubject.F(16, this);
                arrayDeque.offer(F);
                this.l.offer(F);
                j();
            }
            Iterator<g.t.d<T, T>> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            int i2 = this.p + 1;
            if (i2 == this.f45435f) {
                this.p = i2 - this.f45436g;
                g.t.d<T, T> poll = arrayDeque.poll();
                if (poll != null) {
                    poll.onCompleted();
                }
            } else {
                this.p = i2;
            }
            int i3 = i + 1;
            if (i3 == this.f45436g) {
                this.o = 0;
            } else {
                this.o = i3;
            }
        }
    }
}
