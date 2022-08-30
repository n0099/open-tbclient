package rx.internal.operators;

import com.baidu.tieba.cv9;
import com.baidu.tieba.ew9;
import com.baidu.tieba.vv9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes8.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements cv9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -657299606803478389L;
    public transient /* synthetic */ FieldHolder $fh;
    public final ew9<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(ew9<?, ?> ew9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ew9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.parent = ew9Var;
    }

    @Override // com.baidu.tieba.cv9
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i < 0) {
                throw new IllegalStateException("n >= 0 required but it was " + j);
            } else if (i > 0) {
                vv9.b(this, j);
                this.parent.g();
            }
        }
    }
}
