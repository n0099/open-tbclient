package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.h3a;
import com.baidu.tieba.s5a;
import com.baidu.tieba.s6a;
import com.baidu.tieba.w3a;
import com.baidu.tieba.y6a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class OnSubscribeFromEmitter$BufferEmitter<T> extends OnSubscribeFromEmitter$BaseEmitter<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 2427151001689639875L;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean done;
    public Throwable error;
    public final Queue<Object> queue;
    public final AtomicInteger wip;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnSubscribeFromEmitter$BufferEmitter(h3a<? super T> h3aVar, int i) {
        super(h3aVar);
        Queue<Object> s5aVar;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h3aVar, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((h3a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (y6a.b()) {
            s5aVar = new s6a<>(i);
        } else {
            s5aVar = new s5a<>(i);
        }
        this.queue = s5aVar;
        this.wip = new AtomicInteger();
    }

    public void drain() {
        int i;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.wip.getAndIncrement() != 0) {
            return;
        }
        h3a<? super T> h3aVar = this.actual;
        Queue<Object> queue = this.queue;
        int i2 = 1;
        do {
            long j = get();
            long j2 = 0;
            while (true) {
                i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                if (i == 0) {
                    break;
                } else if (h3aVar.isUnsubscribed()) {
                    queue.clear();
                    return;
                } else {
                    boolean z2 = this.done;
                    Object poll = queue.poll();
                    if (poll == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z2 && z) {
                        Throwable th = this.error;
                        if (th != null) {
                            super.onError(th);
                            return;
                        } else {
                            super.onCompleted();
                            return;
                        }
                    } else if (z) {
                        break;
                    } else {
                        h3aVar.onNext((Object) NotificationLite.e(poll));
                        j2++;
                    }
                }
            }
            if (i == 0) {
                if (h3aVar.isUnsubscribed()) {
                    queue.clear();
                    return;
                }
                boolean z3 = this.done;
                boolean isEmpty = queue.isEmpty();
                if (z3 && isEmpty) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        super.onError(th2);
                        return;
                    } else {
                        super.onCompleted();
                        return;
                    }
                }
            }
            if (j2 != 0) {
                w3a.g(this, j2);
            }
            i2 = this.wip.addAndGet(-i2);
        } while (i2 != 0);
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.done = true;
            drain();
        }
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onRequested() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            drain();
        }
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onUnsubscribed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.wip.getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
            this.error = th;
            this.done = true;
            drain();
        }
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
            this.queue.offer(NotificationLite.h(t));
            drain();
        }
    }
}
