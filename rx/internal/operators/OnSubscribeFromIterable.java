package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b3a;
import com.baidu.tieba.d3a;
import com.baidu.tieba.h3a;
import com.baidu.tieba.n3a;
import com.baidu.tieba.w3a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OnSubscribeFromIterable<T> implements b3a.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Iterable<? extends T> a;

    /* loaded from: classes9.dex */
    public static final class IterableProducer<T> extends AtomicLong implements d3a {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8730475647105475802L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Iterator<? extends T> it;
        public final h3a<? super T> o;

        public IterableProducer(h3a<? super T> h3aVar, Iterator<? extends T> it) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h3aVar, it};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.o = h3aVar;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h3a<? super T> h3aVar = this.o;
                Iterator<? extends T> it = this.it;
                while (!h3aVar.isUnsubscribed()) {
                    try {
                        h3aVar.onNext((T) it.next());
                        if (h3aVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                if (!h3aVar.isUnsubscribed()) {
                                    h3aVar.onCompleted();
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th) {
                            n3a.f(th, h3aVar);
                            return;
                        }
                    } catch (Throwable th2) {
                        n3a.f(th2, h3aVar);
                        return;
                    }
                }
            }
        }

        @Override // com.baidu.tieba.d3a
        public void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) != null) || get() == Long.MAX_VALUE) {
                return;
            }
            if (j == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j > 0 && w3a.b(this, j) == 0) {
                slowPath(j);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v3. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                h3a<? super T> h3aVar = this.o;
                Iterator<? extends T> it = this.it;
                do {
                    long j2 = 0;
                    while (true) {
                        if (j2 != j) {
                            if (h3aVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                h3aVar.onNext((T) it.next());
                                if (h3aVar.isUnsubscribed()) {
                                    return;
                                }
                                try {
                                    if (!it.hasNext()) {
                                        if (!h3aVar.isUnsubscribed()) {
                                            h3aVar.onCompleted();
                                            return;
                                        }
                                        return;
                                    }
                                    j2++;
                                } catch (Throwable th) {
                                    n3a.f(th, h3aVar);
                                    return;
                                }
                            } catch (Throwable th2) {
                                n3a.f(th2, h3aVar);
                                return;
                            }
                        } else {
                            j = get();
                            if (j2 == j) {
                                j = w3a.g(this, j2);
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

    public void call(h3a<? super T> h3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, h3aVar) == null) {
            try {
                Iterator<? extends T> it = this.a.iterator();
                boolean hasNext = it.hasNext();
                if (!h3aVar.isUnsubscribed()) {
                    if (!hasNext) {
                        h3aVar.onCompleted();
                    } else {
                        h3aVar.f(new IterableProducer(h3aVar, it));
                    }
                }
            } catch (Throwable th) {
                n3a.f(th, h3aVar);
            }
        }
    }

    @Override // com.baidu.tieba.b3a.a, com.baidu.tieba.p3a
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((h3a) ((h3a) obj));
    }
}
