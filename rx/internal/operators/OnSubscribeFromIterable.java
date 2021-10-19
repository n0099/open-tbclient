package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.d;
import i.f;
import i.j;
import i.m.a;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public final class OnSubscribeFromIterable<T> implements d.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final Iterable<? extends T> f79736e;

    /* loaded from: classes2.dex */
    public static final class IterableProducer<T> extends AtomicLong implements f {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8730475647105475802L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Iterator<? extends T> it;
        public final j<? super T> o;

        public IterableProducer(j<? super T> jVar, Iterator<? extends T> it) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, it};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.o = jVar;
            this.it = it;
        }

        /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: T, ? super T */
        public void fastPath() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                j<? super T> jVar = this.o;
                Iterator<? extends T> it = this.it;
                while (!jVar.isUnsubscribed()) {
                    try {
                        jVar.onNext((T) it.next());
                        if (jVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                if (jVar.isUnsubscribed()) {
                                    return;
                                }
                                jVar.onCompleted();
                                return;
                            }
                        } catch (Throwable th) {
                            a.f(th, jVar);
                            return;
                        }
                    } catch (Throwable th2) {
                        a.f(th2, jVar);
                        return;
                    }
                }
            }
        }

        @Override // i.f
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) || get() == Long.MAX_VALUE) {
                return;
            }
            if (j2 == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastPath();
            } else if (j2 <= 0 || i.o.a.a.b(this, j2) != 0) {
            } else {
                slowPath(j2);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v3. Raw type applied. Possible types: T, ? super T */
        public void slowPath(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
                j<? super T> jVar = this.o;
                Iterator<? extends T> it = this.it;
                do {
                    long j3 = 0;
                    while (true) {
                        if (j3 != j2) {
                            if (jVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                jVar.onNext((T) it.next());
                                if (jVar.isUnsubscribed()) {
                                    return;
                                }
                                try {
                                    if (!it.hasNext()) {
                                        if (jVar.isUnsubscribed()) {
                                            return;
                                        }
                                        jVar.onCompleted();
                                        return;
                                    }
                                    j3++;
                                } catch (Throwable th) {
                                    a.f(th, jVar);
                                    return;
                                }
                            } catch (Throwable th2) {
                                a.f(th2, jVar);
                                return;
                            }
                        } else {
                            j2 = get();
                            if (j3 == j2) {
                                j2 = i.o.a.a.g(this, j3);
                            }
                        }
                    }
                } while (j2 != 0);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (iterable != null) {
            this.f79736e = iterable;
            return;
        }
        throw new NullPointerException("iterable must not be null");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // i.n.b
    /* renamed from: a */
    public void call(j<? super T> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            try {
                Iterator<? extends T> it = this.f79736e.iterator();
                boolean hasNext = it.hasNext();
                if (jVar.isUnsubscribed()) {
                    return;
                }
                if (!hasNext) {
                    jVar.onCompleted();
                } else {
                    jVar.setProducer(new IterableProducer(jVar, it));
                }
            } catch (Throwable th) {
                a.f(th, jVar);
            }
        }
    }
}
