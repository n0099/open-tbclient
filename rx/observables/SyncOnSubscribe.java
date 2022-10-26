package rx.observables;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dy9;
import com.baidu.tieba.e2a;
import com.baidu.tieba.ey9;
import com.baidu.tieba.jy9;
import com.baidu.tieba.sy9;
import com.baidu.tieba.xx9;
import com.baidu.tieba.yx9;
import com.baidu.tieba.zx9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public abstract class SyncOnSubscribe implements xx9.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract Object a();

    public abstract Object b(Object obj, yx9 yx9Var);

    public void c(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
        }
    }

    /* loaded from: classes9.dex */
    public final class SubscriptionProducer extends AtomicLong implements zx9, ey9, yx9 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -3736864024352728072L;
        public transient /* synthetic */ FieldHolder $fh;
        public final dy9 actualSubscriber;
        public boolean hasTerminated;
        public boolean onNextCalled;
        public final SyncOnSubscribe parent;
        public Object state;

        public SubscriptionProducer(dy9 dy9Var, SyncOnSubscribe syncOnSubscribe, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dy9Var, syncOnSubscribe, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actualSubscriber = dy9Var;
            this.parent = syncOnSubscribe;
            this.state = obj;
        }

        private void doUnsubscribe() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                try {
                    this.parent.c(this.state);
                } catch (Throwable th) {
                    jy9.e(th);
                    e2a.j(th);
                }
            }
        }

        private void fastPath() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65538, this) == null) {
                SyncOnSubscribe syncOnSubscribe = this.parent;
                dy9 dy9Var = this.actualSubscriber;
                do {
                    try {
                        this.onNextCalled = false;
                        nextIteration(syncOnSubscribe);
                    } catch (Throwable th) {
                        handleThrownError(dy9Var, th);
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

        @Override // com.baidu.tieba.ey9
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

        @Override // com.baidu.tieba.yx9
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

        @Override // com.baidu.tieba.ey9
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

        private void handleThrownError(dy9 dy9Var, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, this, dy9Var, th) == null) {
                if (this.hasTerminated) {
                    e2a.j(th);
                    return;
                }
                this.hasTerminated = true;
                dy9Var.onError(th);
                unsubscribe();
            }
        }

        private void nextIteration(SyncOnSubscribe syncOnSubscribe) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, syncOnSubscribe) == null) {
                this.state = syncOnSubscribe.b(this.state, this);
            }
        }

        @Override // com.baidu.tieba.yx9
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

        @Override // com.baidu.tieba.yx9
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
                if (!this.onNextCalled) {
                    this.onNextCalled = true;
                    this.actualSubscriber.onNext(obj);
                    return;
                }
                throw new IllegalStateException("onNext called multiple times!");
            }
        }

        @Override // com.baidu.tieba.zx9
        public void request(long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeJ(1048580, this, j) == null) && j > 0 && sy9.b(this, j) == 0) {
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
                SyncOnSubscribe syncOnSubscribe = this.parent;
                dy9 dy9Var = this.actualSubscriber;
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
                            handleThrownError(dy9Var, th);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.xx9.a, com.baidu.tieba.ly9
    public final void call(dy9 dy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dy9Var) == null) {
            try {
                SubscriptionProducer subscriptionProducer = new SubscriptionProducer(dy9Var, this, a());
                dy9Var.b(subscriptionProducer);
                dy9Var.f(subscriptionProducer);
            } catch (Throwable th) {
                jy9.e(th);
                dy9Var.onError(th);
            }
        }
    }
}
