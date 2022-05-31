package rx.internal.operators;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ev9;
import com.repackage.oy9;
import com.repackage.qu9;
import com.repackage.uy9;
import com.repackage.wu9;
import com.repackage.xu9;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements qu9.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ev9<? super xu9> connection;
    public final int numberOfSubscribers;
    public final oy9<? extends T> source;

    public OnSubscribeAutoConnect(oy9<? extends T> oy9Var, int i, ev9<? super xu9> ev9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {oy9Var, Integer.valueOf(i), ev9Var};
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
            this.source = oy9Var;
            this.numberOfSubscribers = i;
            this.connection = ev9Var;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    @Override // com.repackage.qu9.a, com.repackage.ev9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((wu9) ((wu9) obj));
    }

    public void call(wu9<? super T> wu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, wu9Var) == null) {
            this.source.B(uy9.c(wu9Var));
            if (incrementAndGet() == this.numberOfSubscribers) {
                this.source.C(this.connection);
            }
        }
    }
}
