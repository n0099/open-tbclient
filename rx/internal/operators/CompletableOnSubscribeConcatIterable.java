package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mz9;
import com.repackage.nz9;
import com.repackage.ou9;
import com.repackage.pu9;
import com.repackage.xu9;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public final class CompletableOnSubscribeConcatIterable implements ou9.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Iterable<? extends ou9> a;

    /* loaded from: classes8.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements pu9 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -7965400327305809232L;
        public transient /* synthetic */ FieldHolder $fh;
        public final pu9 actual;
        public final mz9 sd;
        public final Iterator<? extends ou9> sources;

        public ConcatInnerSubscriber(pu9 pu9Var, Iterator<? extends ou9> it) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pu9Var, it};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = pu9Var;
            this.sources = it;
            this.sd = new mz9();
        }

        public void next() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.sd.isUnsubscribed() && getAndIncrement() == 0) {
                Iterator<? extends ou9> it = this.sources;
                while (!this.sd.isUnsubscribed()) {
                    try {
                        if (!it.hasNext()) {
                            this.actual.onCompleted();
                            return;
                        }
                        try {
                            ou9 next = it.next();
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

        @Override // com.repackage.pu9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                next();
            }
        }

        @Override // com.repackage.pu9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                this.actual.onError(th);
            }
        }

        @Override // com.repackage.pu9
        public void onSubscribe(xu9 xu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, xu9Var) == null) {
                this.sd.a(xu9Var);
            }
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends ou9> iterable) {
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
    @Override // com.repackage.ou9.f, com.repackage.ev9
    public void call(pu9 pu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pu9Var) == null) {
            try {
                Iterator<? extends ou9> it = this.a.iterator();
                if (it == null) {
                    pu9Var.onSubscribe(nz9.c());
                    pu9Var.onError(new NullPointerException("The iterator returned is null"));
                    return;
                }
                ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(pu9Var, it);
                pu9Var.onSubscribe(concatInnerSubscriber.sd);
                concatInnerSubscriber.next();
            } catch (Throwable th) {
                pu9Var.onSubscribe(nz9.c());
                pu9Var.onError(th);
            }
        }
    }
}
