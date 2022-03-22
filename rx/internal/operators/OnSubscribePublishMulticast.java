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
import g.d;
import g.e;
import g.f;
import g.j;
import g.k;
import g.o.d.i.c;
import g.o.d.j.f0;
import g.o.d.j.r;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = jVar;
            this.parent = onSubscribePublishMulticast;
            this.once = new AtomicBoolean();
        }

        @Override // g.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.once.get() : invokeV.booleanValue;
        }

        @Override // g.f
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + j);
                } else if (i != 0) {
                    g.o.a.a.b(this, j);
                    this.parent.drain();
                }
            }
        }

        @Override // g.k
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.once.compareAndSet(false, true)) {
                this.parent.remove(this);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class a<T> extends j<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final OnSubscribePublishMulticast<T> f45407e;

        public a(OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {onSubscribePublishMulticast};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45407e = onSubscribePublishMulticast;
        }

        @Override // g.j
        public void f(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
                this.f45407e.setProducer(fVar);
            }
        }

        @Override // g.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f45407e.onCompleted();
            }
        }

        @Override // g.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                this.f45407e.onError(th);
            }
        }

        @Override // g.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                this.f45407e.onNext(t);
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

    public OnSubscribePublishMulticast(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (i > 0) {
            this.prefetch = i;
            this.delayError = z;
            if (f0.b()) {
                this.queue = new r(i);
            } else {
                this.queue = new c(i);
            }
            this.subscribers = (PublishProducer<T>[]) EMPTY;
            this.parent = new a<>(this);
            return;
        }
        throw new IllegalArgumentException("prefetch > 0 required but it was " + i);
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

    @Override // g.d.a, g.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((j) ((j) obj));
    }

    public boolean checkTerminated(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int i = 0;
            if (z) {
                if (!this.delayError) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.queue.clear();
                        PublishProducer<T>[] terminate = terminate();
                        int length = terminate.length;
                        while (i < length) {
                            terminate[i].actual.onError(th);
                            i++;
                        }
                        return true;
                    } else if (z2) {
                        PublishProducer<T>[] terminate2 = terminate();
                        int length2 = terminate2.length;
                        while (i < length2) {
                            terminate2[i].actual.onCompleted();
                            i++;
                        }
                        return true;
                    }
                } else if (z2) {
                    PublishProducer<T>[] terminate3 = terminate();
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        int length3 = terminate3.length;
                        while (i < length3) {
                            terminate3[i].actual.onError(th2);
                            i++;
                        }
                    } else {
                        int length4 = terminate3.length;
                        while (i < length4) {
                            terminate3[i].actual.onCompleted();
                            i++;
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
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && getAndIncrement() == 0) {
            Queue<T> queue = this.queue;
            int i2 = 0;
            do {
                long j = Long.MAX_VALUE;
                PublishProducer<T>[] publishProducerArr = this.subscribers;
                int length = publishProducerArr.length;
                for (PublishProducer<T> publishProducer : publishProducerArr) {
                    j = Math.min(j, publishProducer.get());
                }
                if (length != 0) {
                    long j2 = 0;
                    while (true) {
                        i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i == 0) {
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
                        j2++;
                    }
                    if (i == 0 && checkTerminated(this.done, queue.isEmpty())) {
                        return;
                    }
                    if (j2 != 0) {
                        f fVar = this.producer;
                        if (fVar != null) {
                            fVar.request(j2);
                        }
                        for (PublishProducer<T> publishProducer3 : publishProducerArr) {
                            g.o.a.a.g(publishProducer3, j2);
                        }
                    }
                }
                i2 = addAndGet(-i2);
            } while (i2 != 0);
        }
    }

    @Override // g.k
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.parent.isUnsubscribed() : invokeV.booleanValue;
    }

    @Override // g.e
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.done = true;
            drain();
        }
    }

    @Override // g.e
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, th) == null) {
            this.error = th;
            this.done = true;
            drain();
        }
    }

    @Override // g.e
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
                int i = -1;
                int length = publishProducerArr3.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (publishProducerArr3[i2] == publishProducer) {
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
                    publishProducerArr2 = EMPTY;
                } else {
                    PublishProducer[] publishProducerArr4 = new PublishProducer[length - 1];
                    System.arraycopy(publishProducerArr3, 0, publishProducerArr4, 0, i);
                    System.arraycopy(publishProducerArr3, i + 1, publishProducerArr4, i, (length - i) - 1);
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

    @Override // g.k
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
            jVar.b(publishProducer);
            jVar.f(publishProducer);
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
