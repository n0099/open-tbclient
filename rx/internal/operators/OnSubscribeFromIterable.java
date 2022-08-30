package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.av9;
import com.baidu.tieba.cv9;
import com.baidu.tieba.gv9;
import com.baidu.tieba.mv9;
import com.baidu.tieba.vv9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes8.dex */
public final class OnSubscribeFromIterable<T> implements av9.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Iterable<? extends T> a;

    /* loaded from: classes8.dex */
    public static final class IterableProducer<T> extends AtomicLong implements cv9 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8730475647105475802L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Iterator<? extends T> it;
        public final gv9<? super T> o;

        public IterableProducer(gv9<? super T> gv9Var, Iterator<? extends T> it) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gv9Var, it};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.o = gv9Var;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gv9<? super T> gv9Var = this.o;
                Iterator<? extends T> it = this.it;
                while (!gv9Var.isUnsubscribed()) {
                    try {
                        gv9Var.onNext((T) it.next());
                        if (gv9Var.isUnsubscribed()) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                if (gv9Var.isUnsubscribed()) {
                                    return;
                                }
                                gv9Var.onCompleted();
                                return;
                            }
                        } catch (Throwable th) {
                            mv9.f(th, gv9Var);
                            return;
                        }
                    } catch (Throwable th2) {
                        mv9.f(th2, gv9Var);
                        return;
                    }
                }
            }
        }

        @Override // com.baidu.tieba.cv9
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j <= 0 || vv9.b(this, j) != 0) {
            } else {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v3. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                gv9<? super T> gv9Var = this.o;
                Iterator<? extends T> it = this.it;
                do {
                    long j2 = 0;
                    while (true) {
                        if (j2 != j) {
                            if (gv9Var.isUnsubscribed()) {
                                return;
                            }
                            try {
                                gv9Var.onNext((T) it.next());
                                if (gv9Var.isUnsubscribed()) {
                                    return;
                                }
                                try {
                                    if (!it.hasNext()) {
                                        if (gv9Var.isUnsubscribed()) {
                                            return;
                                        }
                                        gv9Var.onCompleted();
                                        return;
                                    }
                                    j2++;
                                } catch (Throwable th) {
                                    mv9.f(th, gv9Var);
                                    return;
                                }
                            } catch (Throwable th2) {
                                mv9.f(th2, gv9Var);
                                return;
                            }
                        } else {
                            j = get();
                            if (j2 == j) {
                                j = vv9.g(this, j2);
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

    @Override // com.baidu.tieba.av9.a, com.baidu.tieba.ov9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((gv9) ((gv9) obj));
    }

    public void call(gv9<? super T> gv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gv9Var) == null) {
            try {
                Iterator<? extends T> it = this.a.iterator();
                boolean hasNext = it.hasNext();
                if (gv9Var.isUnsubscribed()) {
                    return;
                }
                if (!hasNext) {
                    gv9Var.onCompleted();
                } else {
                    gv9Var.f(new IterableProducer(gv9Var, it));
                }
            } catch (Throwable th) {
                mv9.f(th, gv9Var);
            }
        }
    }
}
