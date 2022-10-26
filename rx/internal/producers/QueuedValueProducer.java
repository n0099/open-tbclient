package rx.internal.producers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dy9;
import com.baidu.tieba.jy9;
import com.baidu.tieba.n0a;
import com.baidu.tieba.n1a;
import com.baidu.tieba.sy9;
import com.baidu.tieba.u1a;
import com.baidu.tieba.zx9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class QueuedValueProducer extends AtomicLong implements zx9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Object NULL_SENTINEL;
    public static final long serialVersionUID = 7277121710709137047L;
    public transient /* synthetic */ FieldHolder $fh;
    public final dy9 child;
    public final Queue queue;
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

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QueuedValueProducer(dy9 dy9Var) {
        this(dy9Var, r0);
        Queue n0aVar;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dy9Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((dy9) objArr2[0], (Queue) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (u1a.b()) {
            n0aVar = new n1a();
        } else {
            n0aVar = new n0a();
        }
    }

    public QueuedValueProducer(dy9 dy9Var, Queue queue) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dy9Var, queue};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.child = dy9Var;
        this.queue = queue;
        this.wip = new AtomicInteger();
    }

    private void drain() {
        Object poll;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.wip.getAndIncrement() == 0) {
            dy9 dy9Var = this.child;
            Queue queue = this.queue;
            while (!dy9Var.isUnsubscribed()) {
                this.wip.lazySet(1);
                long j = get();
                long j2 = 0;
                while (j != 0 && (poll = queue.poll()) != null) {
                    try {
                        if (poll == NULL_SENTINEL) {
                            dy9Var.onNext(null);
                        } else {
                            dy9Var.onNext(poll);
                        }
                        if (dy9Var.isUnsubscribed()) {
                            return;
                        }
                        j--;
                        j2++;
                    } catch (Throwable th) {
                        if (poll == NULL_SENTINEL) {
                            poll = null;
                        }
                        jy9.g(th, dy9Var, poll);
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

    public boolean offer(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == null) {
                if (!this.queue.offer(NULL_SENTINEL)) {
                    return false;
                }
            } else if (!this.queue.offer(obj)) {
                return false;
            }
            drain();
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.zx9
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i > 0) {
                    sy9.b(this, j);
                    drain();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required");
        }
    }
}
