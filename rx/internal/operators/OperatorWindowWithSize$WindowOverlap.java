package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dv9;
import com.repackage.kv9;
import com.repackage.pz9;
import com.repackage.sv9;
import com.repackage.xu9;
import com.repackage.zu9;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.subjects.UnicastSubject;
/* loaded from: classes8.dex */
public final class OperatorWindowWithSize$WindowOverlap<T> extends dv9<T> implements kv9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final dv9<? super xu9<T>> e;
    public final int f;
    public final int g;
    public final AtomicInteger h;
    public final ArrayDeque<pz9<T, T>> i;
    public final AtomicLong j;
    public final AtomicInteger k;
    public final Queue<pz9<T, T>> l;
    public Throwable m;
    public volatile boolean n;
    public int o;
    public int p;

    /* loaded from: classes8.dex */
    public final class WindowOverlapProducer extends AtomicBoolean implements zu9 {
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

        @Override // com.repackage.zu9
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + j);
                } else if (i != 0) {
                    OperatorWindowWithSize$WindowOverlap operatorWindowWithSize$WindowOverlap = this.this$0;
                    if (!get() && compareAndSet(false, true)) {
                        operatorWindowWithSize$WindowOverlap.e(sv9.a(sv9.c(operatorWindowWithSize$WindowOverlap.g, j - 1), operatorWindowWithSize$WindowOverlap.f));
                    } else {
                        this.this$0.e(sv9.c(operatorWindowWithSize$WindowOverlap.g, j));
                    }
                    sv9.b(operatorWindowWithSize$WindowOverlap.j, j);
                    operatorWindowWithSize$WindowOverlap.j();
                }
            }
        }
    }

    @Override // com.repackage.kv9
    public void call() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.h.decrementAndGet() == 0) {
            unsubscribe();
        }
    }

    public boolean i(boolean z, boolean z2, dv9<? super pz9<T, T>> dv9Var, Queue<pz9<T, T>> queue) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), dv9Var, queue})) == null) {
            if (dv9Var.isUnsubscribed()) {
                queue.clear();
                return true;
            } else if (z) {
                Throwable th = this.m;
                if (th != null) {
                    queue.clear();
                    dv9Var.onError(th);
                    return true;
                } else if (z2) {
                    dv9Var.onCompleted();
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
            dv9<? super xu9<T>> dv9Var = this.e;
            Queue<pz9<T, T>> queue = this.l;
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
                    pz9<T, T> poll = queue.poll();
                    boolean z2 = poll == null;
                    if (i(z, z2, dv9Var, queue)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    dv9Var.onNext(poll);
                    j2++;
                }
                if (i == 0 && i(this.n, queue.isEmpty(), dv9Var, queue)) {
                    return;
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    this.j.addAndGet(-j2);
                }
                i2 = atomicInteger.addAndGet(-i2);
            } while (i2 != 0);
        }
    }

    @Override // com.repackage.yu9
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Iterator<pz9<T, T>> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().onCompleted();
            }
            this.i.clear();
            this.n = true;
            j();
        }
    }

    @Override // com.repackage.yu9
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
            Iterator<pz9<T, T>> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().onError(th);
            }
            this.i.clear();
            this.m = th;
            this.n = true;
            j();
        }
    }

    @Override // com.repackage.yu9
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, t) == null) {
            int i = this.o;
            ArrayDeque<pz9<T, T>> arrayDeque = this.i;
            if (i == 0 && !this.e.isUnsubscribed()) {
                this.h.getAndIncrement();
                UnicastSubject D = UnicastSubject.D(16, this);
                arrayDeque.offer(D);
                this.l.offer(D);
                j();
            }
            Iterator<pz9<T, T>> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            int i2 = this.p + 1;
            if (i2 == this.f) {
                this.p = i2 - this.g;
                pz9<T, T> poll = arrayDeque.poll();
                if (poll != null) {
                    poll.onCompleted();
                }
            } else {
                this.p = i2;
            }
            int i3 = i + 1;
            if (i3 == this.g) {
                this.o = 0;
            } else {
                this.o = i3;
            }
        }
    }
}
