package rx.internal.operators;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.fv9;
import com.repackage.py9;
import com.repackage.ru9;
import com.repackage.vy9;
import com.repackage.xu9;
import com.repackage.yu9;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements ru9.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final fv9<? super yu9> connection;
    public final int numberOfSubscribers;
    public final py9<? extends T> source;

    public OnSubscribeAutoConnect(py9<? extends T> py9Var, int i, fv9<? super yu9> fv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {py9Var, Integer.valueOf(i), fv9Var};
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
            this.source = py9Var;
            this.numberOfSubscribers = i;
            this.connection = fv9Var;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    @Override // com.repackage.ru9.a, com.repackage.fv9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((xu9) ((xu9) obj));
    }

    public void call(xu9<? super T> xu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, xu9Var) == null) {
            this.source.B(vy9.c(xu9Var));
            if (incrementAndGet() == this.numberOfSubscribers) {
                this.source.C(this.connection);
            }
        }
    }
}
