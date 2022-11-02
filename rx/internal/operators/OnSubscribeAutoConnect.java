package rx.internal.operators;

import com.baidu.tieba.e3a;
import com.baidu.tieba.gz9;
import com.baidu.tieba.k3a;
import com.baidu.tieba.mz9;
import com.baidu.tieba.nz9;
import com.baidu.tieba.uz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements gz9.a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final uz9<? super nz9> connection;
    public final int numberOfSubscribers;
    public final e3a<? extends T> source;

    public OnSubscribeAutoConnect(e3a<? extends T> e3aVar, int i, uz9<? super nz9> uz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e3aVar, Integer.valueOf(i), uz9Var};
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
            this.source = e3aVar;
            this.numberOfSubscribers = i;
            this.connection = uz9Var;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    public void call(mz9<? super T> mz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mz9Var) == null) {
            this.source.B(k3a.c(mz9Var));
            if (incrementAndGet() == this.numberOfSubscribers) {
                this.source.C(this.connection);
            }
        }
    }

    @Override // com.baidu.tieba.gz9.a, com.baidu.tieba.uz9
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((mz9) ((mz9) obj));
    }
}
