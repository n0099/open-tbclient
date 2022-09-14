package rx.internal.operators;

import com.baidu.tieba.ex9;
import com.baidu.tieba.o0a;
import com.baidu.tieba.qw9;
import com.baidu.tieba.u0a;
import com.baidu.tieba.ww9;
import com.baidu.tieba.xw9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements qw9.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ex9<? super xw9> connection;
    public final int numberOfSubscribers;
    public final o0a<? extends T> source;

    public OnSubscribeAutoConnect(o0a<? extends T> o0aVar, int i, ex9<? super xw9> ex9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {o0aVar, Integer.valueOf(i), ex9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (i > 0) {
            this.source = o0aVar;
            this.numberOfSubscribers = i;
            this.connection = ex9Var;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    @Override // com.baidu.tieba.qw9.a, com.baidu.tieba.ex9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((ww9) ((ww9) obj));
    }

    public void call(ww9<? super T> ww9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ww9Var) == null) {
            this.source.B(u0a.c(ww9Var));
            if (incrementAndGet() == this.numberOfSubscribers) {
                this.source.C(this.connection);
            }
        }
    }
}
