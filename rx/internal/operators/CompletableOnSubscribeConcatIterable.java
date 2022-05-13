package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dy9;
import com.repackage.s2a;
import com.repackage.t2a;
import com.repackage.ux9;
import com.repackage.vx9;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public final class CompletableOnSubscribeConcatIterable implements ux9.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Iterable<? extends ux9> a;

    /* loaded from: classes8.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements vx9 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -7965400327305809232L;
        public transient /* synthetic */ FieldHolder $fh;
        public final vx9 actual;
        public final s2a sd;
        public final Iterator<? extends ux9> sources;

        public ConcatInnerSubscriber(vx9 vx9Var, Iterator<? extends ux9> it) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vx9Var, it};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = vx9Var;
            this.sources = it;
            this.sd = new s2a();
        }

        public void next() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.sd.isUnsubscribed() && getAndIncrement() == 0) {
                Iterator<? extends ux9> it = this.sources;
                while (!this.sd.isUnsubscribed()) {
                    try {
                        if (!it.hasNext()) {
                            this.actual.onCompleted();
                            return;
                        }
                        try {
                            ux9 next = it.next();
                            if (next == null) {
                                this.actual.onError(new NullPointerException("The completable returned is null"));
                                return;
                            }
                            next.j(this);
                            if (decrementAndGet() == 0) {
                                return;
                            }
                        } catch (Throwable th) {
                            this.actual.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        this.actual.onError(th2);
                        return;
                    }
                }
            }
        }

        @Override // com.repackage.vx9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                next();
            }
        }

        @Override // com.repackage.vx9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                this.actual.onError(th);
            }
        }

        @Override // com.repackage.vx9
        public void onSubscribe(dy9 dy9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, dy9Var) == null) {
                this.sd.a(dy9Var);
            }
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends ux9> iterable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iterable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = iterable;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ux9.f, com.repackage.ky9
    public void call(vx9 vx9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, vx9Var) == null) {
            try {
                Iterator<? extends ux9> it = this.a.iterator();
                if (it == null) {
                    vx9Var.onSubscribe(t2a.c());
                    vx9Var.onError(new NullPointerException("The iterator returned is null"));
                    return;
                }
                ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(vx9Var, it);
                vx9Var.onSubscribe(concatInnerSubscriber.sd);
                concatInnerSubscriber.next();
            } catch (Throwable th) {
                vx9Var.onSubscribe(t2a.c());
                vx9Var.onError(th);
            }
        }
    }
}
