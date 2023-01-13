package rx.subjects;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cda;
import com.baidu.tieba.f9a;
import com.baidu.tieba.k8a;
import com.baidu.tieba.l8a;
import com.baidu.tieba.m8a;
import com.baidu.tieba.q8a;
import com.baidu.tieba.r8a;
import com.baidu.tieba.w8a;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes9.dex */
public final class PublishSubject<T> extends cda<T, T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final PublishSubjectState<T> b;

    /* loaded from: classes9.dex */
    public static final class PublishSubjectProducer<T> extends AtomicLong implements m8a, r8a, l8a<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 6451806817170721536L;
        public transient /* synthetic */ FieldHolder $fh;
        public final q8a<? super T> actual;
        public final PublishSubjectState<T> parent;
        public long produced;

        public PublishSubjectProducer(PublishSubjectState<T> publishSubjectState, q8a<? super T> q8aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {publishSubjectState, q8aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = publishSubjectState;
            this.actual = q8aVar;
        }

        @Override // com.baidu.tieba.r8a
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (get() == Long.MIN_VALUE) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.l8a
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && get() != Long.MIN_VALUE) {
                this.actual.onCompleted();
            }
        }

        @Override // com.baidu.tieba.r8a
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
            }
        }

        @Override // com.baidu.tieba.l8a
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) && get() != Long.MIN_VALUE) {
                this.actual.onError(th);
            }
        }

        @Override // com.baidu.tieba.m8a
        public void request(long j) {
            long j2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048580, this, j) == null) && f9a.h(j)) {
                do {
                    j2 = get();
                    if (j2 == Long.MIN_VALUE) {
                        return;
                    }
                } while (!compareAndSet(j2, f9a.a(j2, j)));
            }
        }

        @Override // com.baidu.tieba.l8a
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                long j = get();
                if (j != Long.MIN_VALUE) {
                    long j2 = this.produced;
                    if (j != j2) {
                        this.produced = j2 + 1;
                        this.actual.onNext(t);
                        return;
                    }
                    unsubscribe();
                    this.actual.onError(new MissingBackpressureException("PublishSubject: could not emit value due to lack of requests"));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class PublishSubjectState<T> extends AtomicReference<PublishSubjectProducer<T>[]> implements k8a.a<T>, l8a<T> {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            lazySet(EMPTY);
        }

        @Override // com.baidu.tieba.l8a
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                for (PublishSubjectProducer<T> publishSubjectProducer : getAndSet(TERMINATED)) {
                    publishSubjectProducer.onCompleted();
                }
            }
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

        @Override // com.baidu.tieba.k8a.a, com.baidu.tieba.y8a
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((q8a) ((q8a) obj));
        }

        @Override // com.baidu.tieba.l8a
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, t) == null) {
                for (PublishSubjectProducer<T> publishSubjectProducer : get()) {
                    publishSubjectProducer.onNext(t);
                }
            }
        }

        public void call(q8a<? super T> q8aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q8aVar) == null) {
                PublishSubjectProducer<T> publishSubjectProducer = new PublishSubjectProducer<>(this, q8aVar);
                q8aVar.b(publishSubjectProducer);
                q8aVar.f(publishSubjectProducer);
                if (add(publishSubjectProducer)) {
                    if (publishSubjectProducer.isUnsubscribed()) {
                        remove(publishSubjectProducer);
                        return;
                    }
                    return;
                }
                Throwable th = this.error;
                if (th != null) {
                    q8aVar.onError(th);
                } else {
                    q8aVar.onCompleted();
                }
            }
        }

        @Override // com.baidu.tieba.l8a
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
                w8a.d(arrayList);
            }
        }

        public void remove(PublishSubjectProducer<T> publishSubjectProducer) {
            PublishSubjectProducer<T>[] publishSubjectProducerArr;
            PublishSubjectProducer[] publishSubjectProducerArr2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, publishSubjectProducer) == null) {
                do {
                    publishSubjectProducerArr = get();
                    if (publishSubjectProducerArr != TERMINATED && publishSubjectProducerArr != EMPTY) {
                        int length = publishSubjectProducerArr.length;
                        int i = -1;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                break;
                            } else if (publishSubjectProducerArr[i2] == publishSubjectProducer) {
                                i = i2;
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (i < 0) {
                            return;
                        }
                        if (length == 1) {
                            publishSubjectProducerArr2 = EMPTY;
                        } else {
                            PublishSubjectProducer[] publishSubjectProducerArr3 = new PublishSubjectProducer[length - 1];
                            System.arraycopy(publishSubjectProducerArr, 0, publishSubjectProducerArr3, 0, i);
                            System.arraycopy(publishSubjectProducerArr, i + 1, publishSubjectProducerArr3, i, (length - i) - 1);
                            publishSubjectProducerArr2 = publishSubjectProducerArr3;
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(publishSubjectProducerArr, publishSubjectProducerArr2));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((k8a.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = publishSubjectState;
    }

    public static <T> PublishSubject<T> D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new PublishSubject<>(new PublishSubjectState());
        }
        return (PublishSubject) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l8a
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.onCompleted();
        }
    }

    @Override // com.baidu.tieba.l8a
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
            this.b.onError(th);
        }
    }

    @Override // com.baidu.tieba.l8a
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
            this.b.onNext(t);
        }
    }
}
