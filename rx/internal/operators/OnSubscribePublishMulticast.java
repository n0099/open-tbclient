package rx.internal.operators;

import androidx.core.view.InputDeviceCompat;
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
import i.o.d.i.c;
import i.o.d.j.f0;
import i.o.d.j.r;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class OnSubscribePublishMulticast<T> extends AtomicInteger implements d.a<T>, e<T>, k {
    public static /* synthetic */ Interceptable $ic = null;
    public static final PublishProducer<?>[] EMPTY;
    public static final PublishProducer<?>[] TERMINATED;
    public static final long serialVersionUID = -3741892510772238743L;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final a<T> parent;
    public final int prefetch;
    public volatile f producer;
    public final Queue<T> queue;
    public volatile PublishProducer<T>[] subscribers;

    /* loaded from: classes2.dex */
    public static final class PublishProducer<T> extends AtomicLong implements f, k {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 960704844171597367L;
        public transient /* synthetic */ FieldHolder $fh;
        public final j<? super T> actual;
        public final AtomicBoolean once;
        public final OnSubscribePublishMulticast<T> parent;

        public PublishProducer(j<? super T> jVar, OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, onSubscribePublishMulticast};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = jVar;
            this.parent = onSubscribePublishMulticast;
            this.once = new AtomicBoolean();
        }

        @Override // i.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.once.get() : invokeV.booleanValue;
        }

        @Override // i.f
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                if (i2 < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + j2);
                } else if (i2 != 0) {
                    i.o.a.a.b(this, j2);
                    this.parent.drain();
                }
            }
        }

        @Override // i.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.once.compareAndSet(false, true)) {
                this.parent.remove(this);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class a<T> extends j<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final OnSubscribePublishMulticast<T> f79175e;

        public a(OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {onSubscribePublishMulticast};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79175e = onSubscribePublishMulticast;
        }

        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f79175e.onCompleted();
            }
        }

        @Override // i.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.f79175e.onError(th);
            }
        }

        @Override // i.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                this.f79175e.onNext(t);
            }
        }

        @Override // i.j
        public void setProducer(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
                this.f79175e.setProducer(fVar);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(848331708, "Lrx/internal/operators/OnSubscribePublishMulticast;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(848331708, "Lrx/internal/operators/OnSubscribePublishMulticast;");
                return;
            }
        }
        EMPTY = new PublishProducer[0];
        TERMINATED = new PublishProducer[0];
    }

    public OnSubscribePublishMulticast(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (i2 > 0) {
            this.prefetch = i2;
            this.delayError = z;
            if (f0.b()) {
                this.queue = new r(i2);
            } else {
                this.queue = new c(i2);
            }
            this.subscribers = (PublishProducer<T>[]) EMPTY;
            this.parent = new a<>(this);
            return;
        }
        throw new IllegalArgumentException("prefetch > 0 required but it was " + i2);
    }

    public boolean add(PublishProducer<T> publishProducer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, publishProducer)) == null) {
            if (this.subscribers == TERMINATED) {
                return false;
            }
            synchronized (this) {
                PublishProducer<T>[] publishProducerArr = this.subscribers;
                if (publishProducerArr == TERMINATED) {
                    return false;
                }
                int length = publishProducerArr.length;
                PublishProducer<T>[] publishProducerArr2 = new PublishProducer[length + 1];
                System.arraycopy(publishProducerArr, 0, publishProducerArr2, 0, length);
                publishProducerArr2[length] = publishProducer;
                this.subscribers = publishProducerArr2;
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // i.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((j) ((j) obj));
    }

    public boolean checkTerminated(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int i2 = 0;
            if (z) {
                if (!this.delayError) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.queue.clear();
                        PublishProducer<T>[] terminate = terminate();
                        int length = terminate.length;
                        while (i2 < length) {
                            terminate[i2].actual.onError(th);
                            i2++;
                        }
                        return true;
                    } else if (z2) {
                        PublishProducer<T>[] terminate2 = terminate();
                        int length2 = terminate2.length;
                        while (i2 < length2) {
                            terminate2[i2].actual.onCompleted();
                            i2++;
                        }
                        return true;
                    }
                } else if (z2) {
                    PublishProducer<T>[] terminate3 = terminate();
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        int length3 = terminate3.length;
                        while (i2 < length3) {
                            terminate3[i2].actual.onError(th2);
                            i2++;
                        }
                    } else {
                        int length4 = terminate3.length;
                        while (i2 < length4) {
                            terminate3[i2].actual.onCompleted();
                            i2++;
                        }
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public void drain() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && getAndIncrement() == 0) {
            Queue<T> queue = this.queue;
            int i3 = 0;
            do {
                long j2 = Long.MAX_VALUE;
                PublishProducer<T>[] publishProducerArr = this.subscribers;
                int length = publishProducerArr.length;
                for (PublishProducer<T> publishProducer : publishProducerArr) {
                    j2 = Math.min(j2, publishProducer.get());
                }
                if (length != 0) {
                    long j3 = 0;
                    while (true) {
                        i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        }
                        boolean z = this.done;
                        T poll = queue.poll();
                        boolean z2 = poll == null;
                        if (checkTerminated(z, z2)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        for (PublishProducer<T> publishProducer2 : publishProducerArr) {
                            publishProducer2.actual.onNext(poll);
                        }
                        j3++;
                    }
                    if (i2 == 0 && checkTerminated(this.done, queue.isEmpty())) {
                        return;
                    }
                    if (j3 != 0) {
                        f fVar = this.producer;
                        if (fVar != null) {
                            fVar.request(j3);
                        }
                        for (PublishProducer<T> publishProducer3 : publishProducerArr) {
                            i.o.a.a.g(publishProducer3, j3);
                        }
                    }
                }
                i3 = addAndGet(-i3);
            } while (i3 != 0);
        }
    }

    @Override // i.k
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.parent.isUnsubscribed() : invokeV.booleanValue;
    }

    @Override // i.e
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.done = true;
            drain();
        }
    }

    @Override // i.e
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, th) == null) {
            this.error = th;
            this.done = true;
            drain();
        }
    }

    @Override // i.e
    public void onNext(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t) == null) {
            if (!this.queue.offer(t)) {
                this.parent.unsubscribe();
                this.error = new MissingBackpressureException("Queue full?!");
                this.done = true;
            }
            drain();
        }
    }

    public void remove(PublishProducer<T> publishProducer) {
        PublishProducer<T>[] publishProducerArr;
        PublishProducer[] publishProducerArr2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, publishProducer) == null) || (publishProducerArr = this.subscribers) == TERMINATED || publishProducerArr == EMPTY) {
            return;
        }
        synchronized (this) {
            PublishProducer<T>[] publishProducerArr3 = this.subscribers;
            if (publishProducerArr3 != TERMINATED && publishProducerArr3 != EMPTY) {
                int i2 = -1;
                int length = publishProducerArr3.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (publishProducerArr3[i3] == publishProducer) {
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
                    publishProducerArr2 = EMPTY;
                } else {
                    PublishProducer[] publishProducerArr4 = new PublishProducer[length - 1];
                    System.arraycopy(publishProducerArr3, 0, publishProducerArr4, 0, i2);
                    System.arraycopy(publishProducerArr3, i2 + 1, publishProducerArr4, i2, (length - i2) - 1);
                    publishProducerArr2 = publishProducerArr4;
                }
                this.subscribers = publishProducerArr2;
            }
        }
    }

    public void setProducer(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fVar) == null) {
            this.producer = fVar;
            fVar.request(this.prefetch);
        }
    }

    public j<T> subscriber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.parent : (j) invokeV.objValue;
    }

    public PublishProducer<T>[] terminate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            PublishProducer<T>[] publishProducerArr = this.subscribers;
            if (publishProducerArr != TERMINATED) {
                synchronized (this) {
                    publishProducerArr = this.subscribers;
                    if (publishProducerArr != TERMINATED) {
                        this.subscribers = (PublishProducer<T>[]) TERMINATED;
                    }
                }
            }
            return publishProducerArr;
        }
        return (PublishProducer[]) invokeV.objValue;
    }

    @Override // i.k
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.parent.unsubscribe();
        }
    }

    public void call(j<? super T> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jVar) == null) {
            PublishProducer<T> publishProducer = new PublishProducer<>(jVar, this);
            jVar.add(publishProducer);
            jVar.setProducer(publishProducer);
            if (add(publishProducer)) {
                if (publishProducer.isUnsubscribed()) {
                    remove(publishProducer);
                    return;
                } else {
                    drain();
                    return;
                }
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
