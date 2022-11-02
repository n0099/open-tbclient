package rx.internal.operators;

import com.baidu.tieba.b0a;
import com.baidu.tieba.iz9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OperatorZip$ZipProducer<R> extends AtomicLong implements iz9 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -1216676403723546796L;
    public transient /* synthetic */ FieldHolder $fh;
    public final OperatorZip$Zip<R> zipper;

    public OperatorZip$ZipProducer(OperatorZip$Zip<R> operatorZip$Zip) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {operatorZip$Zip};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.zipper = operatorZip$Zip;
    }

    @Override // com.baidu.tieba.iz9
    public void request(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            b0a.b(this, j);
            this.zipper.tick();
        }
    }
}
