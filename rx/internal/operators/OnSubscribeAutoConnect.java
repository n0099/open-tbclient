package rx.internal.operators;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a2a;
import com.repackage.cy9;
import com.repackage.dy9;
import com.repackage.ky9;
import com.repackage.u1a;
import com.repackage.wx9;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements wx9.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ky9<? super dy9> connection;
    public final int numberOfSubscribers;
    public final u1a<? extends T> source;

    public OnSubscribeAutoConnect(u1a<? extends T> u1aVar, int i, ky9<? super dy9> ky9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {u1aVar, Integer.valueOf(i), ky9Var};
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
            this.source = u1aVar;
            this.numberOfSubscribers = i;
            this.connection = ky9Var;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    @Override // com.repackage.wx9.a, com.repackage.ky9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((cy9) ((cy9) obj));
    }

    public void call(cy9<? super T> cy9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cy9Var) == null) {
            this.source.B(a2a.c(cy9Var));
            if (incrementAndGet() == this.numberOfSubscribers) {
                this.source.C(this.connection);
            }
        }
    }
}
