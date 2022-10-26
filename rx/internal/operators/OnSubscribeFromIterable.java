package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dy9;
import com.baidu.tieba.jy9;
import com.baidu.tieba.sy9;
import com.baidu.tieba.xx9;
import com.baidu.tieba.zx9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OnSubscribeFromIterable implements xx9.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Iterable a;

    /* loaded from: classes9.dex */
    public final class IterableProducer extends AtomicLong implements zx9 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8730475647105475802L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Iterator it;
        public final dy9 o;

        public IterableProducer(dy9 dy9Var, Iterator it) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dy9Var, it};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.o = dy9Var;
            this.it = it;
        }

        public void fastPath() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                dy9 dy9Var = this.o;
                Iterator it = this.it;
                while (!dy9Var.isUnsubscribed()) {
                    try {
                        dy9Var.onNext(it.next());
                        if (dy9Var.isUnsubscribed()) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                if (!dy9Var.isUnsubscribed()) {
                                    dy9Var.onCompleted();
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            jy9.f(th, dy9Var);
                            return;
                        }
                    } catch (Throwable th2) {
                        jy9.f(th2, dy9Var);
                        return;
                    }
                }
            }
        }

        @Override // com.baidu.tieba.zx9
        public void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) != null) || get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j > 0 && sy9.b(this, j) == 0) {
                slowPath(j);
            }
        }

        public void slowPath(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                dy9 dy9Var = this.o;
                Iterator it = this.it;
                do {
                    long j2 = 0;
                    while (true) {
                        if (j2 != j) {
                            if (dy9Var.isUnsubscribed()) {
                                return;
                            }
                            try {
                                dy9Var.onNext(it.next());
                                if (dy9Var.isUnsubscribed()) {
                                    return;
                                }
                                try {
                                    if (!it.hasNext()) {
                                        if (!dy9Var.isUnsubscribed()) {
                                            dy9Var.onCompleted();
                                            return;
                                        }
                                        return;
                                    }
                                    j2++;
                                } catch (Throwable th) {
                                    jy9.f(th, dy9Var);
                                    return;
                                }
                            } catch (Throwable th2) {
                                jy9.f(th2, dy9Var);
                                return;
                            }
                        } else {
                            j = get();
                            if (j2 == j) {
                                j = sy9.g(this, j2);
                            }
                        }
                    }
                } while (j != 0);
            }
        }
    }

    public OnSubscribeFromIterable(Iterable iterable) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.xx9.a, com.baidu.tieba.ly9
    public void call(dy9 dy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dy9Var) == null) {
            try {
                Iterator it = this.a.iterator();
                boolean hasNext = it.hasNext();
                if (!dy9Var.isUnsubscribed()) {
                    if (!hasNext) {
                        dy9Var.onCompleted();
                    } else {
                        dy9Var.f(new IterableProducer(dy9Var, it));
                    }
                }
            } catch (Throwable th) {
                jy9.f(th, dy9Var);
            }
        }
    }
}
