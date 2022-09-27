package rx.internal.operators;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b2a;
import com.baidu.tieba.c2a;
import com.baidu.tieba.dx9;
import com.baidu.tieba.ex9;
import com.baidu.tieba.mx9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class CompletableOnSubscribeConcatIterable implements dx9.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Iterable<? extends dx9> a;

    /* loaded from: classes9.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements ex9 {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -7965400327305809232L;
        public transient /* synthetic */ FieldHolder $fh;
        public final ex9 actual;
        public final b2a sd;
        public final Iterator<? extends dx9> sources;

        public ConcatInnerSubscriber(ex9 ex9Var, Iterator<? extends dx9> it) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ex9Var, it};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = ex9Var;
            this.sources = it;
            this.sd = new b2a();
        }

        public void next() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !this.sd.isUnsubscribed() && getAndIncrement() == 0) {
                Iterator<? extends dx9> it = this.sources;
                while (!this.sd.isUnsubscribed()) {
                    try {
                        if (!it.hasNext()) {
                            this.actual.onCompleted();
                            return;
                        }
                        try {
                            dx9 next = it.next();
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

        @Override // com.baidu.tieba.ex9
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                next();
            }
        }

        @Override // com.baidu.tieba.ex9
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                this.actual.onError(th);
            }
        }

        @Override // com.baidu.tieba.ex9
        public void onSubscribe(mx9 mx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, mx9Var) == null) {
                this.sd.a(mx9Var);
            }
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends dx9> iterable) {
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
    @Override // com.baidu.tieba.dx9.f, com.baidu.tieba.tx9
    public void call(ex9 ex9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ex9Var) == null) {
            try {
                Iterator<? extends dx9> it = this.a.iterator();
                if (it == null) {
                    ex9Var.onSubscribe(c2a.c());
                    ex9Var.onError(new NullPointerException("The iterator returned is null"));
                    return;
                }
                ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(ex9Var, it);
                ex9Var.onSubscribe(concatInnerSubscriber.sd);
                concatInnerSubscriber.next();
            } catch (Throwable th) {
                ex9Var.onSubscribe(c2a.c());
                ex9Var.onError(th);
            }
        }
    }
}
