package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.d0a;
import com.baidu.tieba.m0a;
import com.baidu.tieba.rz9;
import com.baidu.tieba.tz9;
import com.baidu.tieba.xz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OnSubscribeFromIterable<T> implements rz9.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Iterable<? extends T> a;

    /* loaded from: classes9.dex */
    public static final class IterableProducer<T> extends AtomicLong implements tz9 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8730475647105475802L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Iterator<? extends T> it;
        public final xz9<? super T> o;

        public IterableProducer(xz9<? super T> xz9Var, Iterator<? extends T> it) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xz9Var, it};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.o = xz9Var;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                xz9<? super T> xz9Var = this.o;
                Iterator<? extends T> it = this.it;
                while (!xz9Var.isUnsubscribed()) {
                    try {
                        xz9Var.onNext((T) it.next());
                        if (xz9Var.isUnsubscribed()) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                if (!xz9Var.isUnsubscribed()) {
                                    xz9Var.onCompleted();
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            d0a.f(th, xz9Var);
                            return;
                        }
                    } catch (Throwable th2) {
                        d0a.f(th2, xz9Var);
                        return;
                    }
                }
            }
        }

        @Override // com.baidu.tieba.tz9
        public void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) != null) || get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j > 0 && m0a.b(this, j) == 0) {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v3. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                xz9<? super T> xz9Var = this.o;
                Iterator<? extends T> it = this.it;
                do {
                    long j2 = 0;
                    while (true) {
                        if (j2 != j) {
                            if (xz9Var.isUnsubscribed()) {
                                return;
                            }
                            try {
                                xz9Var.onNext((T) it.next());
                                if (xz9Var.isUnsubscribed()) {
                                    return;
                                }
                                try {
                                    if (!it.hasNext()) {
                                        if (!xz9Var.isUnsubscribed()) {
                                            xz9Var.onCompleted();
                                            return;
                                        }
                                        return;
                                    }
                                    j2++;
                                } catch (Throwable th) {
                                    d0a.f(th, xz9Var);
                                    return;
                                }
                            } catch (Throwable th2) {
                                d0a.f(th2, xz9Var);
                                return;
                            }
                        } else {
                            j = get();
                            if (j2 == j) {
                                j = m0a.g(this, j2);
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

    public void call(xz9<? super T> xz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xz9Var) == null) {
            try {
                Iterator<? extends T> it = this.a.iterator();
                boolean hasNext = it.hasNext();
                if (!xz9Var.isUnsubscribed()) {
                    if (!hasNext) {
                        xz9Var.onCompleted();
                    } else {
                        xz9Var.f(new IterableProducer(xz9Var, it));
                    }
                }
            } catch (Throwable th) {
                d0a.f(th, xz9Var);
            }
        }
    }

    @Override // com.baidu.tieba.rz9.a, com.baidu.tieba.f0a
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((xz9) ((xz9) obj));
    }
}
