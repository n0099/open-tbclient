package rx.observables;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import i.m.a;
import i.r.c;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes5.dex */
public abstract class SyncOnSubscribe<S, T> implements d.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class SubscriptionProducer<S, T> extends AtomicLong implements f, k, e<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -3736864024352728072L;
        public transient /* synthetic */ FieldHolder $fh;
        public final j<? super T> actualSubscriber;
        public boolean hasTerminated;
        public boolean onNextCalled;
        public final SyncOnSubscribe<S, T> parent;
        public S state;

        public SubscriptionProducer(j<? super T> jVar, SyncOnSubscribe<S, T> syncOnSubscribe, S s) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, syncOnSubscribe, s};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actualSubscriber = jVar;
            this.parent = syncOnSubscribe;
            this.state = s;
        }

        private void doUnsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                try {
                    this.parent.c(this.state);
                } catch (Throwable th) {
                    a.e(th);
                    c.j(th);
                }
            }
        }

        private void fastPath() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
                j<? super T> jVar = this.actualSubscriber;
                do {
                    try {
                        this.onNextCalled = false;
                        nextIteration(syncOnSubscribe);
                    } catch (Throwable th) {
                        handleThrownError(jVar, th);
                        return;
                    }
                } while (!tryUnsubscribe());
            }
        }

        private void handleThrownError(j<? super T> jVar, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, this, jVar, th) == null) {
                if (this.hasTerminated) {
                    c.j(th);
                    return;
                }
                this.hasTerminated = true;
                jVar.onError(th);
                unsubscribe();
            }
        }

        private void nextIteration(SyncOnSubscribe<S, T> syncOnSubscribe) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, syncOnSubscribe) == null) {
                this.state = syncOnSubscribe.b(this.state, this);
            }
        }

        private void slowPath(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(65541, this, j2) == null) {
                SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
                j<? super T> jVar = this.actualSubscriber;
                do {
                    long j3 = j2;
                    do {
                        try {
                            this.onNextCalled = false;
                            nextIteration(syncOnSubscribe);
                            if (tryUnsubscribe()) {
                                return;
                            }
                            if (this.onNextCalled) {
                                j3--;
                            }
                        } catch (Throwable th) {
                            handleThrownError(jVar, th);
                            return;
                        }
                    } while (j3 != 0);
                    j2 = addAndGet(-j2);
                } while (j2 > 0);
                tryUnsubscribe();
            }
        }

        private boolean tryUnsubscribe() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
                if (this.hasTerminated || get() < -1) {
                    set(-1L);
                    doUnsubscribe();
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // i.k
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? get() < 0 : invokeV.booleanValue;
        }

        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (!this.hasTerminated) {
                    this.hasTerminated = true;
                    if (this.actualSubscriber.isUnsubscribed()) {
                        return;
                    }
                    this.actualSubscriber.onCompleted();
                    return;
                }
                throw new IllegalStateException("Terminal event already emitted.");
            }
        }

        @Override // i.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (!this.hasTerminated) {
                    this.hasTerminated = true;
                    if (this.actualSubscriber.isUnsubscribed()) {
                        return;
                    }
                    this.actualSubscriber.onError(th);
                    return;
                }
                throw new IllegalStateException("Terminal event already emitted.");
            }
        }

        @Override // i.e
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
                if (!this.onNextCalled) {
                    this.onNextCalled = true;
                    this.actualSubscriber.onNext(t);
                    return;
                }
                throw new IllegalStateException("onNext called multiple times!");
            }
        }

        @Override // i.f
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) && j2 > 0 && i.o.a.a.b(this, j2) == 0) {
                if (j2 == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j2);
                }
            }
        }

        @Override // i.k
        public void unsubscribe() {
            long j2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                do {
                    j2 = get();
                    if (compareAndSet(0L, -1L)) {
                        doUnsubscribe();
                        return;
                    }
                } while (!compareAndSet(j2, -2L));
            }
        }
    }

    public SyncOnSubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public abstract S a();

    public abstract S b(S s, e<? super T> eVar);

    public void c(S s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, s) == null) {
        }
    }

    @Override // i.d.a, i.n.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((j) ((j) obj));
    }

    public final void call(j<? super T> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, jVar) == null) {
            try {
                SubscriptionProducer subscriptionProducer = new SubscriptionProducer(jVar, this, a());
                jVar.b(subscriptionProducer);
                jVar.f(subscriptionProducer);
            } catch (Throwable th) {
                a.e(th);
                jVar.onError(th);
            }
        }
    }
}
