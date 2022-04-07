package rx.observables;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.az9;
import com.repackage.bz9;
import com.repackage.c3a;
import com.repackage.gz9;
import com.repackage.pz9;
import com.repackage.uy9;
import com.repackage.vy9;
import com.repackage.wy9;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes8.dex */
public abstract class SyncOnSubscribe<S, T> implements uy9.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static final class SubscriptionProducer<S, T> extends AtomicLong implements wy9, bz9, vy9<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -3736864024352728072L;
        public transient /* synthetic */ FieldHolder $fh;
        public final az9<? super T> actualSubscriber;
        public boolean hasTerminated;
        public boolean onNextCalled;
        public final SyncOnSubscribe<S, T> parent;
        public S state;

        public SubscriptionProducer(az9<? super T> az9Var, SyncOnSubscribe<S, T> syncOnSubscribe, S s) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az9Var, syncOnSubscribe, s};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actualSubscriber = az9Var;
            this.parent = syncOnSubscribe;
            this.state = s;
        }

        private void doUnsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                try {
                    this.parent.c(this.state);
                } catch (Throwable th) {
                    gz9.e(th);
                    c3a.j(th);
                }
            }
        }

        private void fastPath() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
                az9<? super T> az9Var = this.actualSubscriber;
                do {
                    try {
                        this.onNextCalled = false;
                        nextIteration(syncOnSubscribe);
                    } catch (Throwable th) {
                        handleThrownError(az9Var, th);
                        return;
                    }
                } while (!tryUnsubscribe());
            }
        }

        private void handleThrownError(az9<? super T> az9Var, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, this, az9Var, th) == null) {
                if (this.hasTerminated) {
                    c3a.j(th);
                    return;
                }
                this.hasTerminated = true;
                az9Var.onError(th);
                unsubscribe();
            }
        }

        private void nextIteration(SyncOnSubscribe<S, T> syncOnSubscribe) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, syncOnSubscribe) == null) {
                this.state = syncOnSubscribe.b(this.state, this);
            }
        }

        private void slowPath(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(65541, this, j) == null) {
                SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
                az9<? super T> az9Var = this.actualSubscriber;
                do {
                    long j2 = j;
                    do {
                        try {
                            this.onNextCalled = false;
                            nextIteration(syncOnSubscribe);
                            if (tryUnsubscribe()) {
                                return;
                            }
                            if (this.onNextCalled) {
                                j2--;
                            }
                        } catch (Throwable th) {
                            handleThrownError(az9Var, th);
                            return;
                        }
                    } while (j2 != 0);
                    j = addAndGet(-j);
                } while (j > 0);
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

        @Override // com.repackage.bz9
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? get() < 0 : invokeV.booleanValue;
        }

        @Override // com.repackage.vy9
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

        @Override // com.repackage.vy9
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

        @Override // com.repackage.vy9
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

        @Override // com.repackage.wy9
        public void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048580, this, j) == null) && j > 0 && pz9.b(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j);
                }
            }
        }

        @Override // com.repackage.bz9
        public void unsubscribe() {
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                do {
                    j = get();
                    if (compareAndSet(0L, -1L)) {
                        doUnsubscribe();
                        return;
                    }
                } while (!compareAndSet(j, -2L));
            }
        }
    }

    public SyncOnSubscribe() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public abstract S a();

    public abstract S b(S s, vy9<? super T> vy9Var);

    public void c(S s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, s) == null) {
        }
    }

    @Override // com.repackage.uy9.a, com.repackage.iz9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((az9) ((az9) obj));
    }

    public final void call(az9<? super T> az9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, az9Var) == null) {
            try {
                SubscriptionProducer subscriptionProducer = new SubscriptionProducer(az9Var, this, a());
                az9Var.b(subscriptionProducer);
                az9Var.f(subscriptionProducer);
            } catch (Throwable th) {
                gz9.e(th);
                az9Var.onError(th);
            }
        }
    }
}
