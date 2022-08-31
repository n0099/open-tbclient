package rx.internal.operators;

import com.baidu.tieba.cz9;
import com.baidu.tieba.ev9;
import com.baidu.tieba.fv9;
import com.baidu.tieba.mv9;
import com.baidu.tieba.wy9;
import com.baidu.tieba.yu9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements yu9.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final mv9<? super fv9> connection;
    public final int numberOfSubscribers;
    public final wy9<? extends T> source;

    public OnSubscribeAutoConnect(wy9<? extends T> wy9Var, int i, mv9<? super fv9> mv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wy9Var, Integer.valueOf(i), mv9Var};
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
            this.source = wy9Var;
            this.numberOfSubscribers = i;
            this.connection = mv9Var;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    @Override // com.baidu.tieba.yu9.a, com.baidu.tieba.mv9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((ev9) ((ev9) obj));
    }

    public void call(ev9<? super T> ev9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ev9Var) == null) {
            this.source.B(cz9.c(ev9Var));
            if (incrementAndGet() == this.numberOfSubscribers) {
                this.source.C(this.connection);
            }
        }
    }
}
