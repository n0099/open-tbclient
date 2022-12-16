package rx.observables;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b3a;
import com.baidu.tieba.c3a;
import com.baidu.tieba.d3a;
import com.baidu.tieba.h3a;
import com.baidu.tieba.i3a;
import com.baidu.tieba.i7a;
import com.baidu.tieba.n3a;
import com.baidu.tieba.w3a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public abstract class SyncOnSubscribe<S, T> implements b3a.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract S a();

    public abstract S b(S s, c3a<? super T> c3aVar);

    public void c(S s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, s) == null) {
        }
    }

    /* loaded from: classes9.dex */
    public static final class SubscriptionProducer<S, T> extends AtomicLong implements d3a, i3a, c3a<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -3736864024352728072L;
        public transient /* synthetic */ FieldHolder $fh;
        public final h3a<? super T> actualSubscriber;
        public boolean hasTerminated;
        public boolean onNextCalled;
        public final SyncOnSubscribe<S, T> parent;
        public S state;

        public SubscriptionProducer(h3a<? super T> h3aVar, SyncOnSubscribe<S, T> syncOnSubscribe, S s) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h3aVar, syncOnSubscribe, s};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actualSubscriber = h3aVar;
            this.parent = syncOnSubscribe;
            this.state = s;
        }

        private void doUnsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                try {
                    this.parent.c(this.state);
                } catch (Throwable th) {
                    n3a.e(th);
                    i7a.j(th);
                }
            }
        }

        private void fastPath() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
                h3a<? super T> h3aVar = this.actualSubscriber;
                do {
                    try {
                        this.onNextCalled = false;
                        nextIteration(syncOnSubscribe);
                    } catch (Throwable th) {
                        handleThrownError(h3aVar, th);
                        return;
                    }
                } while (!tryUnsubscribe());
            }
        }

        private boolean tryUnsubscribe() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
                if (!this.hasTerminated && get() >= -1) {
                    return false;
                }
                set(-1L);
                doUnsubscribe();
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.i3a
        public boolean isUnsubscribed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (get() < 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.c3a
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (!this.hasTerminated) {
                    this.hasTerminated = true;
                    if (!this.actualSubscriber.isUnsubscribed()) {
                        this.actualSubscriber.onCompleted();
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("Terminal event already emitted.");
            }
        }

        @Override // com.baidu.tieba.i3a
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

        private void handleThrownError(h3a<? super T> h3aVar, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, this, h3aVar, th) == null) {
                if (this.hasTerminated) {
                    i7a.j(th);
                    return;
                }
                this.hasTerminated = true;
                h3aVar.onError(th);
                unsubscribe();
            }
        }

        private void nextIteration(SyncOnSubscribe<S, T> syncOnSubscribe) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, syncOnSubscribe) == null) {
                this.state = syncOnSubscribe.b(this.state, this);
            }
        }

        @Override // com.baidu.tieba.c3a
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                if (!this.hasTerminated) {
                    this.hasTerminated = true;
                    if (!this.actualSubscriber.isUnsubscribed()) {
                        this.actualSubscriber.onError(th);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("Terminal event already emitted.");
            }
        }

        @Override // com.baidu.tieba.c3a
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

        @Override // com.baidu.tieba.d3a
        public void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048580, this, j) == null) && j > 0 && w3a.b(this, j) == 0) {
                if (j == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j);
                }
            }
        }

        private void slowPath(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(65541, this, j) == null) {
                SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
                h3a<? super T> h3aVar = this.actualSubscriber;
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
                            handleThrownError(h3aVar, th);
                            return;
                        }
                    } while (j2 != 0);
                    j = addAndGet(-j);
                } while (j > 0);
                tryUnsubscribe();
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

    public final void call(h3a<? super T> h3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, h3aVar) == null) {
            try {
                SubscriptionProducer subscriptionProducer = new SubscriptionProducer(h3aVar, this, a());
                h3aVar.b(subscriptionProducer);
                h3aVar.f(subscriptionProducer);
            } catch (Throwable th) {
                n3a.e(th);
                h3aVar.onError(th);
            }
        }
    }

    @Override // com.baidu.tieba.b3a.a, com.baidu.tieba.p3a
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((h3a) ((h3a) obj));
    }
}
