package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dy9;
import com.baidu.tieba.ky9;
import com.baidu.tieba.p2a;
import com.baidu.tieba.sy9;
import com.baidu.tieba.zx9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.subjects.UnicastSubject;
/* loaded from: classes9.dex */
public final class OperatorWindowWithSize$WindowOverlap extends dy9 implements ky9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final dy9 e;
    public final int f;
    public final int g;
    public final AtomicInteger h;
    public final ArrayDeque i;
    public final AtomicLong j;
    public final AtomicInteger k;
    public final Queue l;
    public Throwable m;
    public volatile boolean n;
    public int o;
    public int p;

    /* loaded from: classes9.dex */
    public final class WindowOverlapProducer extends AtomicBoolean implements zx9 {
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

        @Override // com.baidu.tieba.zx9
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i >= 0) {
                    if (i != 0) {
                        OperatorWindowWithSize$WindowOverlap operatorWindowWithSize$WindowOverlap = this.this$0;
                        if (!get() && compareAndSet(false, true)) {
                            operatorWindowWithSize$WindowOverlap.e(sy9.a(sy9.c(operatorWindowWithSize$WindowOverlap.g, j - 1), operatorWindowWithSize$WindowOverlap.f));
                        } else {
                            this.this$0.e(sy9.c(operatorWindowWithSize$WindowOverlap.g, j));
                        }
                        sy9.b(operatorWindowWithSize$WindowOverlap.j, j);
                        operatorWindowWithSize$WindowOverlap.j();
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
        }
    }

    @Override // com.baidu.tieba.ky9
    public void call() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.h.decrementAndGet() == 0) {
            unsubscribe();
        }
    }

    @Override // com.baidu.tieba.yx9
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Iterator it = this.i.iterator();
            while (it.hasNext()) {
                ((p2a) it.next()).onCompleted();
            }
            this.i.clear();
            this.n = true;
            j();
        }
    }

    public boolean i(boolean z, boolean z2, dy9 dy9Var, Queue queue) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), dy9Var, queue})) == null) {
            if (dy9Var.isUnsubscribed()) {
                queue.clear();
                return true;
            } else if (z) {
                Throwable th = this.m;
                if (th != null) {
                    queue.clear();
                    dy9Var.onError(th);
                    return true;
                } else if (z2) {
                    dy9Var.onCompleted();
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

    public void j() {
        int i;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            AtomicInteger atomicInteger = this.k;
            if (atomicInteger.getAndIncrement() != 0) {
                return;
            }
            dy9 dy9Var = this.e;
            Queue queue = this.l;
            int i2 = 1;
            do {
                long j = this.j.get();
                long j2 = 0;
                while (true) {
                    i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i == 0) {
                        break;
                    }
                    boolean z2 = this.n;
                    p2a p2aVar = (p2a) queue.poll();
                    if (p2aVar == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (i(z2, z, dy9Var, queue)) {
                        return;
                    }
                    if (z) {
                        break;
                    }
                    dy9Var.onNext(p2aVar);
                    j2++;
                }
                if (i == 0 && i(this.n, queue.isEmpty(), dy9Var, queue)) {
                    return;
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    this.j.addAndGet(-j2);
                }
                i2 = atomicInteger.addAndGet(-i2);
            } while (i2 != 0);
        }
    }

    @Override // com.baidu.tieba.yx9
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
            Iterator it = this.i.iterator();
            while (it.hasNext()) {
                ((p2a) it.next()).onError(th);
            }
            this.i.clear();
            this.m = th;
            this.n = true;
            j();
        }
    }

    @Override // com.baidu.tieba.yx9
    public void onNext(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, obj) == null) {
            int i = this.o;
            ArrayDeque arrayDeque = this.i;
            if (i == 0 && !this.e.isUnsubscribed()) {
                this.h.getAndIncrement();
                UnicastSubject D = UnicastSubject.D(16, this);
                arrayDeque.offer(D);
                this.l.offer(D);
                j();
            }
            Iterator it = this.i.iterator();
            while (it.hasNext()) {
                ((p2a) it.next()).onNext(obj);
            }
            int i2 = this.p + 1;
            if (i2 == this.f) {
                this.p = i2 - this.g;
                p2a p2aVar = (p2a) arrayDeque.poll();
                if (p2aVar != null) {
                    p2aVar.onCompleted();
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
