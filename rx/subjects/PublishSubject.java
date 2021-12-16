package rx.subjects;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.d;
import i.e;
import i.f;
import i.j;
import i.k;
import i.o.a.a;
import i.t.d;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes4.dex */
public final class PublishSubject<T> extends d<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final PublishSubjectState<T> f65026f;

    /* loaded from: classes4.dex */
    public static final class PublishSubjectProducer<T> extends AtomicLong implements f, k, e<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 6451806817170721536L;
        public transient /* synthetic */ FieldHolder $fh;
        public final j<? super T> actual;
        public final PublishSubjectState<T> parent;
        public long produced;

        public PublishSubjectProducer(PublishSubjectState<T> publishSubjectState, j<? super T> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {publishSubjectState, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = publishSubjectState;
            this.actual = jVar;
        }

        @Override // i.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? get() == Long.MIN_VALUE : invokeV.booleanValue;
        }

        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || get() == Long.MIN_VALUE) {
                return;
            }
            this.actual.onCompleted();
        }

        @Override // i.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) || get() == Long.MIN_VALUE) {
                return;
            }
            this.actual.onError(th);
        }

        @Override // i.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                long j2 = get();
                if (j2 != Long.MIN_VALUE) {
                    long j3 = this.produced;
                    if (j2 != j3) {
                        this.produced = j3 + 1;
                        this.actual.onNext(t);
                        return;
                    }
                    unsubscribe();
                    this.actual.onError(new MissingBackpressureException("PublishSubject: could not emit value due to lack of requests"));
                }
            }
        }

        @Override // i.f
        public void request(long j2) {
            long j3;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) && a.h(j2)) {
                do {
                    j3 = get();
                    if (j3 == Long.MIN_VALUE) {
                        return;
                    }
                } while (!compareAndSet(j3, a.a(j3, j2)));
            }
        }

        @Override // i.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
                return;
            }
            this.parent.remove(this);
        }
    }

    /* loaded from: classes4.dex */
    public static final class PublishSubjectState<T> extends AtomicReference<PublishSubjectProducer<T>[]> implements d.a<T>, e<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final PublishSubjectProducer[] EMPTY;
        public static final PublishSubjectProducer[] TERMINATED;
        public static final long serialVersionUID = -7568940796666027140L;
        public transient /* synthetic */ FieldHolder $fh;
        public Throwable error;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(36534403, "Lrx/subjects/PublishSubject$PublishSubjectState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(36534403, "Lrx/subjects/PublishSubject$PublishSubjectState;");
                    return;
                }
            }
            EMPTY = new PublishSubjectProducer[0];
            TERMINATED = new PublishSubjectProducer[0];
        }

        public PublishSubjectState() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            lazySet(EMPTY);
        }

        public boolean add(PublishSubjectProducer<T> publishSubjectProducer) {
            PublishSubjectProducer<T>[] publishSubjectProducerArr;
            PublishSubjectProducer[] publishSubjectProducerArr2;
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, publishSubjectProducer)) == null) {
                do {
                    publishSubjectProducerArr = get();
                    if (publishSubjectProducerArr == TERMINATED) {
                        return false;
                    }
                    int length = publishSubjectProducerArr.length;
                    publishSubjectProducerArr2 = new PublishSubjectProducer[length + 1];
                    System.arraycopy(publishSubjectProducerArr, 0, publishSubjectProducerArr2, 0, length);
                    publishSubjectProducerArr2[length] = publishSubjectProducer;
                } while (!compareAndSet(publishSubjectProducerArr, publishSubjectProducerArr2));
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // i.d.a, i.n.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((j) ((j) obj));
        }

        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                for (PublishSubjectProducer<T> publishSubjectProducer : getAndSet(TERMINATED)) {
                    publishSubjectProducer.onCompleted();
                }
            }
        }

        @Override // i.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
                this.error = th;
                ArrayList arrayList = null;
                for (PublishSubjectProducer<T> publishSubjectProducer : getAndSet(TERMINATED)) {
                    try {
                        publishSubjectProducer.onError(th);
                    } catch (Throwable th2) {
                        if (arrayList == null) {
                            arrayList = new ArrayList(1);
                        }
                        arrayList.add(th2);
                    }
                }
                i.m.a.d(arrayList);
            }
        }

        @Override // i.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, t) == null) {
                for (PublishSubjectProducer<T> publishSubjectProducer : get()) {
                    publishSubjectProducer.onNext(t);
                }
            }
        }

        public void remove(PublishSubjectProducer<T> publishSubjectProducer) {
            PublishSubjectProducer<T>[] publishSubjectProducerArr;
            PublishSubjectProducer[] publishSubjectProducerArr2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, publishSubjectProducer) == null) {
                do {
                    publishSubjectProducerArr = get();
                    if (publishSubjectProducerArr == TERMINATED || publishSubjectProducerArr == EMPTY) {
                        return;
                    }
                    int length = publishSubjectProducerArr.length;
                    int i2 = -1;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        } else if (publishSubjectProducerArr[i3] == publishSubjectProducer) {
                            i2 = i3;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (i2 < 0) {
                        return;
                    }
                    if (length == 1) {
                        publishSubjectProducerArr2 = EMPTY;
                    } else {
                        PublishSubjectProducer[] publishSubjectProducerArr3 = new PublishSubjectProducer[length - 1];
                        System.arraycopy(publishSubjectProducerArr, 0, publishSubjectProducerArr3, 0, i2);
                        System.arraycopy(publishSubjectProducerArr, i2 + 1, publishSubjectProducerArr3, i2, (length - i2) - 1);
                        publishSubjectProducerArr2 = publishSubjectProducerArr3;
                    }
                } while (!compareAndSet(publishSubjectProducerArr, publishSubjectProducerArr2));
            }
        }

        public void call(j<? super T> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar) == null) {
                PublishSubjectProducer<T> publishSubjectProducer = new PublishSubjectProducer<>(this, jVar);
                jVar.b(publishSubjectProducer);
                jVar.f(publishSubjectProducer);
                if (add(publishSubjectProducer)) {
                    if (publishSubjectProducer.isUnsubscribed()) {
                        remove(publishSubjectProducer);
                        return;
                    }
                    return;
                }
                Throwable th = this.error;
                if (th != null) {
                    jVar.onError(th);
                } else {
                    jVar.onCompleted();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishSubject(PublishSubjectState<T> publishSubjectState) {
        super(publishSubjectState);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {publishSubjectState};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65026f = publishSubjectState;
    }

    public static <T> PublishSubject<T> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? new PublishSubject<>(new PublishSubjectState()) : (PublishSubject) invokeV.objValue;
    }

    @Override // i.e
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f65026f.onCompleted();
        }
    }

    @Override // i.e
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
            this.f65026f.onError(th);
        }
    }

    @Override // i.e
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
            this.f65026f.onNext(t);
        }
    }
}
