package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cy9;
import com.repackage.n0a;
import com.repackage.n1a;
import com.repackage.ry9;
import com.repackage.t1a;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public final class OnSubscribeFromEmitter$BufferEmitter<T> extends OnSubscribeFromEmitter$BaseEmitter<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 2427151001689639875L;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean done;
    public Throwable error;
    public final Queue<Object> queue;
    public final AtomicInteger wip;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnSubscribeFromEmitter$BufferEmitter(cy9<? super T> cy9Var, int i) {
        super(cy9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cy9Var, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((cy9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.queue = t1a.b() ? new n1a<>(i) : new n0a<>(i);
        this.wip = new AtomicInteger();
    }

    public void drain() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.wip.getAndIncrement() == 0) {
            cy9<? super T> cy9Var = this.actual;
            Queue<Object> queue = this.queue;
            int i2 = 1;
            do {
                long j = get();
                long j2 = 0;
                while (true) {
                    i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i == 0) {
                        break;
                    } else if (cy9Var.isUnsubscribed()) {
                        queue.clear();
                        return;
                    } else {
                        boolean z = this.done;
                        Object poll = queue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable th = this.error;
                            if (th != null) {
                                super.onError(th);
                                return;
                            } else {
                                super.onCompleted();
                                return;
                            }
                        } else if (z2) {
                            break;
                        } else {
                            cy9Var.onNext((Object) NotificationLite.e(poll));
                            j2++;
                        }
                    }
                }
                if (i == 0) {
                    if (cy9Var.isUnsubscribed()) {
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
                    ry9.g(this, j2);
                }
                i2 = this.wip.addAndGet(-i2);
            } while (i2 != 0);
        }
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
}
