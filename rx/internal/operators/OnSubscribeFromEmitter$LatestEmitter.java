package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.hz9;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class OnSubscribeFromEmitter$LatestEmitter<T> extends OnSubscribeFromEmitter$BaseEmitter<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 4023437720691792495L;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean done;
    public Throwable error;
    public final AtomicReference<Object> queue;
    public final AtomicInteger wip;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnSubscribeFromEmitter$LatestEmitter(hz9<? super T> hz9Var) {
        super(hz9Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hz9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((hz9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.queue = new AtomicReference<>();
        this.wip = new AtomicInteger();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
        if (r13 != 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005d, code lost:
        if (r1.isUnsubscribed() == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005f, code lost:
        r2.lazySet(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0062, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0063, code lost:
        r5 = r17.done;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0069, code lost:
        if (r2.get() != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006b, code lost:
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006c, code lost:
        if (r5 == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006e, code lost:
        if (r11 == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0070, code lost:
        r1 = r17.error;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0072, code lost:
        if (r1 == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0074, code lost:
        super.onError(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0078, code lost:
        super.onCompleted();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007b, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007e, code lost:
        if (r9 == 0) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0080, code lost:
        com.repackage.wz9.g(r17, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0083, code lost:
        r4 = r17.wip.addAndGet(-r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drain() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.wip.getAndIncrement() == 0) {
            hz9<? super T> hz9Var = this.actual;
            AtomicReference<Object> atomicReference = this.queue;
            int i = 1;
            do {
                long j = get();
                long j2 = 0;
                while (true) {
                    boolean z = false;
                    int i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    } else if (hz9Var.isUnsubscribed()) {
                        atomicReference.lazySet(null);
                        return;
                    } else {
                        boolean z2 = this.done;
                        Object andSet = atomicReference.getAndSet(null);
                        boolean z3 = andSet == null;
                        if (z2 && z3) {
                            Throwable th = this.error;
                            if (th != null) {
                                super.onError(th);
                                return;
                            } else {
                                super.onCompleted();
                                return;
                            }
                        } else if (z3) {
                            break;
                        } else {
                            hz9Var.onNext((Object) NotificationLite.e(andSet));
                            j2++;
                        }
                    }
                }
            } while (i != 0);
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
            this.queue.set(NotificationLite.h(t));
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
            this.queue.lazySet(null);
        }
    }
}
