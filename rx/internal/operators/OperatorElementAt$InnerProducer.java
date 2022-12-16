package rx.internal.operators;

import com.baidu.tieba.d3a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public class OperatorElementAt$InnerProducer extends AtomicBoolean implements d3a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final d3a actual;

    public OperatorElementAt$InnerProducer(d3a d3aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d3aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.actual = d3aVar;
    }

    @Override // com.baidu.tieba.d3a
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i >= 0) {
                if (i > 0 && compareAndSet(false, true)) {
                    this.actual.request(Long.MAX_VALUE);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required");
        }
    }
}
