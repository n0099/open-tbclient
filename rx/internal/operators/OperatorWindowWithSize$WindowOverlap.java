package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.d;
import i.f;
import i.j;
import i.n.a;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.subjects.UnicastSubject;
/* loaded from: classes3.dex */
public final class OperatorWindowWithSize$WindowOverlap<T> extends j<T> implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public final j<? super d<T>> f64386i;

    /* renamed from: j  reason: collision with root package name */
    public final int f64387j;

    /* renamed from: k  reason: collision with root package name */
    public final int f64388k;
    public final AtomicInteger l;
    public final ArrayDeque<i.t.d<T, T>> m;
    public final AtomicLong n;
    public final AtomicInteger o;
    public final Queue<i.t.d<T, T>> p;
    public Throwable q;
    public volatile boolean r;
    public int s;
    public int t;

    /* loaded from: classes3.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = operatorWindowWithSize$WindowOverlap;
        }

        @Override // i.f
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                if (i2 < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + j2);
                } else if (i2 != 0) {
                    OperatorWindowWithSize$WindowOverlap operatorWindowWithSize$WindowOverlap = this.this$0;
                    if (!get() && compareAndSet(false, true)) {
                        operatorWindowWithSize$WindowOverlap.e(i.o.a.a.a(i.o.a.a.c(operatorWindowWithSize$WindowOverlap.f64388k, j2 - 1), operatorWindowWithSize$WindowOverlap.f64387j));
                    } else {
                        this.this$0.e(i.o.a.a.c(operatorWindowWithSize$WindowOverlap.f64388k, j2));
                    }
                    i.o.a.a.b(operatorWindowWithSize$WindowOverlap.n, j2);
                    operatorWindowWithSize$WindowOverlap.j();
                }
            }
        }
    }

    @Override // i.n.a
    public void call() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.l.decrementAndGet() == 0) {
            unsubscribe();
        }
    }

    public boolean i(boolean z, boolean z2, j<? super i.t.d<T, T>> jVar, Queue<i.t.d<T, T>> queue) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), jVar, queue})) == null) {
            if (jVar.isUnsubscribed()) {
                queue.clear();
                return true;
            } else if (z) {
                Throwable th = this.q;
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
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            AtomicInteger atomicInteger = this.o;
            if (atomicInteger.getAndIncrement() != 0) {
                return;
            }
            j<? super d<T>> jVar = this.f64386i;
            Queue<i.t.d<T, T>> queue = this.p;
            int i3 = 1;
            do {
                long j2 = this.n.get();
                long j3 = 0;
                while (true) {
                    i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    }
                    boolean z = this.r;
                    i.t.d<T, T> poll = queue.poll();
                    boolean z2 = poll == null;
                    if (i(z, z2, jVar, queue)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    jVar.onNext(poll);
                    j3++;
                }
                if (i2 == 0 && i(this.r, queue.isEmpty(), jVar, queue)) {
                    return;
                }
                if (j3 != 0 && j2 != Long.MAX_VALUE) {
                    this.n.addAndGet(-j3);
                }
                i3 = atomicInteger.addAndGet(-i3);
            } while (i3 != 0);
        }
    }

    @Override // i.e
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Iterator<i.t.d<T, T>> it = this.m.iterator();
            while (it.hasNext()) {
                it.next().onCompleted();
            }
            this.m.clear();
            this.r = true;
            j();
        }
    }

    @Override // i.e
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
            Iterator<i.t.d<T, T>> it = this.m.iterator();
            while (it.hasNext()) {
                it.next().onError(th);
            }
            this.m.clear();
            this.q = th;
            this.r = true;
            j();
        }
    }

    @Override // i.e
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, t) == null) {
            int i2 = this.s;
            ArrayDeque<i.t.d<T, T>> arrayDeque = this.m;
            if (i2 == 0 && !this.f64386i.isUnsubscribed()) {
                this.l.getAndIncrement();
                UnicastSubject F = UnicastSubject.F(16, this);
                arrayDeque.offer(F);
                this.p.offer(F);
                j();
            }
            Iterator<i.t.d<T, T>> it = this.m.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            int i3 = this.t + 1;
            if (i3 == this.f64387j) {
                this.t = i3 - this.f64388k;
                i.t.d<T, T> poll = arrayDeque.poll();
                if (poll != null) {
                    poll.onCompleted();
                }
            } else {
                this.t = i3;
            }
            int i4 = i2 + 1;
            if (i4 == this.f64388k) {
                this.s = 0;
            } else {
                this.s = i4;
            }
        }
    }
}
