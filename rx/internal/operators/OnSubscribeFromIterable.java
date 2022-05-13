package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cy9;
import com.repackage.iy9;
import com.repackage.ry9;
import com.repackage.wx9;
import com.repackage.yx9;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes8.dex */
public final class OnSubscribeFromIterable<T> implements wx9.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Iterable<? extends T> a;

    /* loaded from: classes8.dex */
    public static final class IterableProducer<T> extends AtomicLong implements yx9 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8730475647105475802L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Iterator<? extends T> it;
        public final cy9<? super T> o;

        public IterableProducer(cy9<? super T> cy9Var, Iterator<? extends T> it) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cy9Var, it};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.o = cy9Var;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                cy9<? super T> cy9Var = this.o;
                Iterator<? extends T> it = this.it;
                while (!cy9Var.isUnsubscribed()) {
                    try {
                        cy9Var.onNext((T) it.next());
                        if (cy9Var.isUnsubscribed()) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                if (cy9Var.isUnsubscribed()) {
                                    return;
                                }
                                cy9Var.onCompleted();
                                return;
                            }
                        } catch (Throwable th) {
                            iy9.f(th, cy9Var);
                            return;
                        }
                    } catch (Throwable th2) {
                        iy9.f(th2, cy9Var);
                        return;
                    }
                }
            }
        }

        @Override // com.repackage.yx9
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j <= 0 || ry9.b(this, j) != 0) {
            } else {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v3. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                cy9<? super T> cy9Var = this.o;
                Iterator<? extends T> it = this.it;
                do {
                    long j2 = 0;
                    while (true) {
                        if (j2 != j) {
                            if (cy9Var.isUnsubscribed()) {
                                return;
                            }
                            try {
                                cy9Var.onNext((T) it.next());
                                if (cy9Var.isUnsubscribed()) {
                                    return;
                                }
                                try {
                                    if (!it.hasNext()) {
                                        if (cy9Var.isUnsubscribed()) {
                                            return;
                                        }
                                        cy9Var.onCompleted();
                                        return;
                                    }
                                    j2++;
                                } catch (Throwable th) {
                                    iy9.f(th, cy9Var);
                                    return;
                                }
                            } catch (Throwable th2) {
                                iy9.f(th2, cy9Var);
                                return;
                            }
                        } else {
                            j = get();
                            if (j2 == j) {
                                j = ry9.g(this, j2);
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

    @Override // com.repackage.wx9.a, com.repackage.ky9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((cy9) ((cy9) obj));
    }

    public void call(cy9<? super T> cy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cy9Var) == null) {
            try {
                Iterator<? extends T> it = this.a.iterator();
                boolean hasNext = it.hasNext();
                if (cy9Var.isUnsubscribed()) {
                    return;
                }
                if (!hasNext) {
                    cy9Var.onCompleted();
                } else {
                    cy9Var.f(new IterableProducer(cy9Var, it));
                }
            } catch (Throwable th) {
                iy9.f(th, cy9Var);
            }
        }
    }
}
