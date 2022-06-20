package rx.internal.operators;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.bz9;
import com.repackage.dv9;
import com.repackage.ev9;
import com.repackage.lv9;
import com.repackage.vy9;
import com.repackage.xu9;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements xu9.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final lv9<? super ev9> connection;
    public final int numberOfSubscribers;
    public final vy9<? extends T> source;

    public OnSubscribeAutoConnect(vy9<? extends T> vy9Var, int i, lv9<? super ev9> lv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vy9Var, Integer.valueOf(i), lv9Var};
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
            this.source = vy9Var;
            this.numberOfSubscribers = i;
            this.connection = lv9Var;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    @Override // com.repackage.xu9.a, com.repackage.lv9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((dv9) ((dv9) obj));
    }

    public void call(dv9<? super T> dv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dv9Var) == null) {
            this.source.B(bz9.c(dv9Var));
            if (incrementAndGet() == this.numberOfSubscribers) {
                this.source.C(this.connection);
            }
        }
    }
}
