package rx.internal.producers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.f;
import h.j;
import h.m.a;
import h.o.d.i.e;
import h.o.d.j.f0;
import h.o.d.j.y;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes3.dex */
public final class QueuedValueProducer<T> extends AtomicLong implements f {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Object NULL_SENTINEL;
    public static final long serialVersionUID = 7277121710709137047L;
    public transient /* synthetic */ FieldHolder $fh;
    public final j<? super T> child;
    public final Queue<Object> queue;
    public final AtomicInteger wip;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-216272082, "Lrx/internal/producers/QueuedValueProducer;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-216272082, "Lrx/internal/producers/QueuedValueProducer;");
                return;
            }
        }
        NULL_SENTINEL = new Object();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QueuedValueProducer(j<? super T> jVar) {
        this(jVar, f0.b() ? new y() : new e());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((j) objArr2[0], (Queue) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void drain() {
        Object poll;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.wip.getAndIncrement() == 0) {
            j<? super T> jVar = this.child;
            Queue<Object> queue = this.queue;
            while (!jVar.isUnsubscribed()) {
                this.wip.lazySet(1);
                long j = get();
                long j2 = 0;
                while (j != 0 && (poll = queue.poll()) != null) {
                    try {
                        if (poll == NULL_SENTINEL) {
                            jVar.onNext(null);
                        } else {
                            jVar.onNext(poll);
                        }
                        if (jVar.isUnsubscribed()) {
                            return;
                        }
                        j--;
                        j2++;
                    } catch (Throwable th) {
                        if (poll == NULL_SENTINEL) {
                            poll = null;
                        }
                        a.g(th, jVar, poll);
                        return;
                    }
                }
                if (j2 != 0 && get() != Long.MAX_VALUE) {
                    addAndGet(-j2);
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    public boolean offer(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) {
            if (t == null) {
                if (!this.queue.offer(NULL_SENTINEL)) {
                    return false;
                }
            } else if (!this.queue.offer(t)) {
                return false;
            }
            drain();
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // h.f
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
            if (i2 > 0) {
                h.o.a.a.b(this, j);
                drain();
            }
        }
    }

    public QueuedValueProducer(j<? super T> jVar, Queue<Object> queue) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jVar, queue};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.child = jVar;
        this.queue = queue;
        this.wip = new AtomicInteger();
    }
}
