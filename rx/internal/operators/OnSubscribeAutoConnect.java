package rx.internal.operators;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.as9;
import com.repackage.bs9;
import com.repackage.is9;
import com.repackage.sv9;
import com.repackage.ur9;
import com.repackage.yv9;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements ur9.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final is9<? super bs9> connection;
    public final int numberOfSubscribers;
    public final sv9<? extends T> source;

    public OnSubscribeAutoConnect(sv9<? extends T> sv9Var, int i, is9<? super bs9> is9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sv9Var, Integer.valueOf(i), is9Var};
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
            this.source = sv9Var;
            this.numberOfSubscribers = i;
            this.connection = is9Var;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    @Override // com.repackage.ur9.a, com.repackage.is9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((as9) ((as9) obj));
    }

    public void call(as9<? super T> as9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, as9Var) == null) {
            this.source.B(yv9.c(as9Var));
            if (incrementAndGet() == this.numberOfSubscribers) {
                this.source.C(this.connection);
            }
        }
    }
}
