package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nz9;
import com.repackage.oz9;
import com.repackage.pu9;
import com.repackage.qu9;
import com.repackage.yu9;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public final class CompletableOnSubscribeConcatIterable implements pu9.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Iterable<? extends pu9> a;

    /* loaded from: classes8.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements qu9 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -7965400327305809232L;
        public transient /* synthetic */ FieldHolder $fh;
        public final qu9 actual;
        public final nz9 sd;
        public final Iterator<? extends pu9> sources;

        public ConcatInnerSubscriber(qu9 qu9Var, Iterator<? extends pu9> it) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu9Var, it};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = qu9Var;
            this.sources = it;
            this.sd = new nz9();
        }

        public void next() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.sd.isUnsubscribed() && getAndIncrement() == 0) {
                Iterator<? extends pu9> it = this.sources;
                while (!this.sd.isUnsubscribed()) {
                    try {
                        if (!it.hasNext()) {
                            this.actual.onCompleted();
                            return;
                        }
                        try {
                            pu9 next = it.next();
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

        @Override // com.repackage.qu9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                next();
            }
        }

        @Override // com.repackage.qu9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                this.actual.onError(th);
            }
        }

        @Override // com.repackage.qu9
        public void onSubscribe(yu9 yu9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, yu9Var) == null) {
                this.sd.a(yu9Var);
            }
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends pu9> iterable) {
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
    @Override // com.repackage.pu9.f, com.repackage.fv9
    public void call(qu9 qu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qu9Var) == null) {
            try {
                Iterator<? extends pu9> it = this.a.iterator();
                if (it == null) {
                    qu9Var.onSubscribe(oz9.c());
                    qu9Var.onError(new NullPointerException("The iterator returned is null"));
                    return;
                }
                ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(qu9Var, it);
                qu9Var.onSubscribe(concatInnerSubscriber.sd);
                concatInnerSubscriber.next();
            } catch (Throwable th) {
                qu9Var.onSubscribe(oz9.c());
                qu9Var.onError(th);
            }
        }
    }
}
