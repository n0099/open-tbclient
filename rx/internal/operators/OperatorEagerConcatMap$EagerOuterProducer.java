package rx.internal.operators;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ps9;
import com.repackage.wr9;
import com.repackage.ys9;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes8.dex */
public final class OperatorEagerConcatMap$EagerOuterProducer extends AtomicLong implements wr9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -657299606803478389L;
    public transient /* synthetic */ FieldHolder $fh;
    public final ys9<?, ?> parent;

    public OperatorEagerConcatMap$EagerOuterProducer(ys9<?, ?> ys9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ys9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.parent = ys9Var;
    }

    @Override // com.repackage.wr9
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i < 0) {
                throw new IllegalStateException("n >= 0 required but it was " + j);
            } else if (i > 0) {
                ps9.b(this, j);
                this.parent.g();
            }
        }
    }
}
