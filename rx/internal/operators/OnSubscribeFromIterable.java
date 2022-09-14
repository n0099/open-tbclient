package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cx9;
import com.baidu.tieba.lx9;
import com.baidu.tieba.qw9;
import com.baidu.tieba.sw9;
import com.baidu.tieba.ww9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OnSubscribeFromIterable<T> implements qw9.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Iterable<? extends T> a;

    /* loaded from: classes9.dex */
    public static final class IterableProducer<T> extends AtomicLong implements sw9 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8730475647105475802L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Iterator<? extends T> it;
        public final ww9<? super T> o;

        public IterableProducer(ww9<? super T> ww9Var, Iterator<? extends T> it) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ww9Var, it};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.o = ww9Var;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ww9<? super T> ww9Var = this.o;
                Iterator<? extends T> it = this.it;
                while (!ww9Var.isUnsubscribed()) {
                    try {
                        ww9Var.onNext((T) it.next());
                        if (ww9Var.isUnsubscribed()) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                if (ww9Var.isUnsubscribed()) {
                                    return;
                                }
                                ww9Var.onCompleted();
                                return;
                            }
                        } catch (Throwable th) {
                            cx9.f(th, ww9Var);
                            return;
                        }
                    } catch (Throwable th2) {
                        cx9.f(th2, ww9Var);
                        return;
                    }
                }
            }
        }

        @Override // com.baidu.tieba.sw9
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j <= 0 || lx9.b(this, j) != 0) {
            } else {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v3. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                ww9<? super T> ww9Var = this.o;
                Iterator<? extends T> it = this.it;
                do {
                    long j2 = 0;
                    while (true) {
                        if (j2 != j) {
                            if (ww9Var.isUnsubscribed()) {
                                return;
                            }
                            try {
                                ww9Var.onNext((T) it.next());
                                if (ww9Var.isUnsubscribed()) {
                                    return;
                                }
                                try {
                                    if (!it.hasNext()) {
                                        if (ww9Var.isUnsubscribed()) {
                                            return;
                                        }
                                        ww9Var.onCompleted();
                                        return;
                                    }
                                    j2++;
                                } catch (Throwable th) {
                                    cx9.f(th, ww9Var);
                                    return;
                                }
                            } catch (Throwable th2) {
                                cx9.f(th2, ww9Var);
                                return;
                            }
                        } else {
                            j = get();
                            if (j2 == j) {
                                j = lx9.g(this, j2);
                            }
                        }
                    }
                } while (j != 0);
            }
        }
    }

    public OnSubscribeFromIterable(Iterable<? extends T> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iterable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (iterable != null) {
            this.a = iterable;
            return;
        }
        throw new NullPointerException("iterable must not be null");
    }

    @Override // com.baidu.tieba.qw9.a, com.baidu.tieba.ex9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((ww9) ((ww9) obj));
    }

    public void call(ww9<? super T> ww9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ww9Var) == null) {
            try {
                Iterator<? extends T> it = this.a.iterator();
                boolean hasNext = it.hasNext();
                if (ww9Var.isUnsubscribed()) {
                    return;
                }
                if (!hasNext) {
                    ww9Var.onCompleted();
                } else {
                    ww9Var.f(new IterableProducer(ww9Var, it));
                }
            } catch (Throwable th) {
                cx9.f(th, ww9Var);
            }
        }
    }
}
