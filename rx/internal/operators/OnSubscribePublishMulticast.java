package rx.internal.operators;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dy9;
import com.baidu.tieba.ey9;
import com.baidu.tieba.g1a;
import com.baidu.tieba.l0a;
import com.baidu.tieba.sy9;
import com.baidu.tieba.u1a;
import com.baidu.tieba.xx9;
import com.baidu.tieba.yx9;
import com.baidu.tieba.zx9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes9.dex */
public final class OnSubscribePublishMulticast extends AtomicInteger implements xx9.a, yx9, ey9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final PublishProducer[] EMPTY;
    public static final PublishProducer[] TERMINATED;
    public static final long serialVersionUID = -3741892510772238743L;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final a parent;
    public final int prefetch;
    public volatile zx9 producer;
    public final Queue queue;
    public volatile PublishProducer[] subscribers;

    /* loaded from: classes9.dex */
    public final class PublishProducer extends AtomicLong implements zx9, ey9 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 960704844171597367L;
        public transient /* synthetic */ FieldHolder $fh;
        public final dy9 actual;
        public final AtomicBoolean once;
        public final OnSubscribePublishMulticast parent;

        public PublishProducer(dy9 dy9Var, OnSubscribePublishMulticast onSubscribePublishMulticast) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dy9Var, onSubscribePublishMulticast};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = dy9Var;
            this.parent = onSubscribePublishMulticast;
            this.once = new AtomicBoolean();
        }

        @Override // com.baidu.tieba.ey9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.once.get();
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.ey9
        public void unsubscribe() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.once.compareAndSet(false, true)) {
                this.parent.remove(this);
            }
        }

        @Override // com.baidu.tieba.zx9
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i >= 0) {
                    if (i != 0) {
                        sy9.b(this, j);
                        this.parent.drain();
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
        }
    }

    /* loaded from: classes9.dex */
    public final class a extends dy9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final OnSubscribePublishMulticast e;

        public a(OnSubscribePublishMulticast onSubscribePublishMulticast) {
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
            this.e = onSubscribePublishMulticast;
        }

        @Override // com.baidu.tieba.dy9
        public void f(zx9 zx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, zx9Var) == null) {
                this.e.setProducer(zx9Var);
            }
        }

        @Override // com.baidu.tieba.yx9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                this.e.onError(th);
            }
        }

        @Override // com.baidu.tieba.yx9
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
                this.e.onNext(obj);
            }
        }

        @Override // com.baidu.tieba.yx9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.e.onCompleted();
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

    @Override // com.baidu.tieba.ey9
    public boolean isUnsubscribed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.parent.isUnsubscribed();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yx9
    public void onCompleted() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.done = true;
            drain();
        }
    }

    public dy9 subscriber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.parent;
        }
        return (dy9) invokeV.objValue;
    }

    public PublishProducer[] terminate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            PublishProducer[] publishProducerArr = this.subscribers;
            if (publishProducerArr != TERMINATED) {
                synchronized (this) {
                    publishProducerArr = this.subscribers;
                    if (publishProducerArr != TERMINATED) {
                        this.subscribers = TERMINATED;
                    }
                }
            }
            return publishProducerArr;
        }
        return (PublishProducer[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ey9
    public void unsubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.parent.unsubscribe();
        }
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
            if (u1a.b()) {
                this.queue = new g1a(i);
            } else {
                this.queue = new l0a(i);
            }
            this.subscribers = EMPTY;
            this.parent = new a(this);
            return;
        }
        throw new IllegalArgumentException("prefetch > 0 required but it was " + i);
    }

    public boolean checkTerminated(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int i = 0;
            if (z) {
                if (this.delayError) {
                    if (z2) {
                        PublishProducer[] terminate = terminate();
                        Throwable th = this.error;
                        if (th != null) {
                            int length = terminate.length;
                            while (i < length) {
                                terminate[i].actual.onError(th);
                                i++;
                            }
                        } else {
                            int length2 = terminate.length;
                            while (i < length2) {
                                terminate[i].actual.onCompleted();
                                i++;
                            }
                        }
                        return true;
                    }
                } else {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.queue.clear();
                        PublishProducer[] terminate2 = terminate();
                        int length3 = terminate2.length;
                        while (i < length3) {
                            terminate2[i].actual.onError(th2);
                            i++;
                        }
                        return true;
                    } else if (z2) {
                        PublishProducer[] terminate3 = terminate();
                        int length4 = terminate3.length;
                        while (i < length4) {
                            terminate3[i].actual.onCompleted();
                            i++;
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean add(PublishProducer publishProducer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, publishProducer)) == null) {
            if (this.subscribers == TERMINATED) {
                return false;
            }
            synchronized (this) {
                PublishProducer[] publishProducerArr = this.subscribers;
                if (publishProducerArr == TERMINATED) {
                    return false;
                }
                int length = publishProducerArr.length;
                PublishProducer[] publishProducerArr2 = new PublishProducer[length + 1];
                System.arraycopy(publishProducerArr, 0, publishProducerArr2, 0, length);
                publishProducerArr2[length] = publishProducer;
                this.subscribers = publishProducerArr2;
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.xx9.a, com.baidu.tieba.ly9
    public void call(dy9 dy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dy9Var) == null) {
            PublishProducer publishProducer = new PublishProducer(dy9Var, this);
            dy9Var.b(publishProducer);
            dy9Var.f(publishProducer);
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
                dy9Var.onError(th);
            } else {
                dy9Var.onCompleted();
            }
        }
    }

    @Override // com.baidu.tieba.yx9
    public void onError(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, th) == null) {
            this.error = th;
            this.done = true;
            drain();
        }
    }

    @Override // com.baidu.tieba.yx9
    public void onNext(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj) == null) {
            if (!this.queue.offer(obj)) {
                this.parent.unsubscribe();
                this.error = new MissingBackpressureException("Queue full?!");
                this.done = true;
            }
            drain();
        }
    }

    public void setProducer(zx9 zx9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, zx9Var) == null) {
            this.producer = zx9Var;
            zx9Var.request(this.prefetch);
        }
    }

    public void drain() {
        int i;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || getAndIncrement() != 0) {
            return;
        }
        Queue queue = this.queue;
        int i2 = 0;
        do {
            long j = Long.MAX_VALUE;
            PublishProducer[] publishProducerArr = this.subscribers;
            int length = publishProducerArr.length;
            for (PublishProducer publishProducer : publishProducerArr) {
                j = Math.min(j, publishProducer.get());
            }
            if (length != 0) {
                long j2 = 0;
                while (true) {
                    i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i == 0) {
                        break;
                    }
                    boolean z2 = this.done;
                    Object poll = queue.poll();
                    if (poll == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (checkTerminated(z2, z)) {
                        return;
                    }
                    if (z) {
                        break;
                    }
                    for (PublishProducer publishProducer2 : publishProducerArr) {
                        publishProducer2.actual.onNext(poll);
                    }
                    j2++;
                }
                if (i == 0 && checkTerminated(this.done, queue.isEmpty())) {
                    return;
                }
                if (j2 != 0) {
                    zx9 zx9Var = this.producer;
                    if (zx9Var != null) {
                        zx9Var.request(j2);
                    }
                    for (PublishProducer publishProducer3 : publishProducerArr) {
                        sy9.g(publishProducer3, j2);
                    }
                }
            }
            i2 = addAndGet(-i2);
        } while (i2 != 0);
    }

    public void remove(PublishProducer publishProducer) {
        PublishProducer[] publishProducerArr;
        PublishProducer[] publishProducerArr2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, publishProducer) == null) && (publishProducerArr = this.subscribers) != TERMINATED && publishProducerArr != EMPTY) {
            synchronized (this) {
                PublishProducer[] publishProducerArr3 = this.subscribers;
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
    }
}
