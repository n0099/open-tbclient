package rx.internal.operators;

import com.baidu.tieba.e3a;
import com.baidu.tieba.i3a;
import com.baidu.tieba.x3a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class OperatorBufferWithSize$BufferSkip<T> extends i3a<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int e;
    public final int f;

    /* loaded from: classes9.dex */
    public final class BufferSkipProducer extends AtomicBoolean implements e3a {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3428177408082367154L;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OperatorBufferWithSize$BufferSkip this$0;

        public BufferSkipProducer(OperatorBufferWithSize$BufferSkip operatorBufferWithSize$BufferSkip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {operatorBufferWithSize$BufferSkip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = operatorBufferWithSize$BufferSkip;
        }

        @Override // com.baidu.tieba.e3a
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i >= 0) {
                    if (i != 0) {
                        OperatorBufferWithSize$BufferSkip operatorBufferWithSize$BufferSkip = this.this$0;
                        if (get() || !compareAndSet(false, true)) {
                            operatorBufferWithSize$BufferSkip.e(x3a.c(j, operatorBufferWithSize$BufferSkip.f));
                            return;
                        } else {
                            operatorBufferWithSize$BufferSkip.e(x3a.a(x3a.c(j, operatorBufferWithSize$BufferSkip.e), x3a.c(operatorBufferWithSize$BufferSkip.f - operatorBufferWithSize$BufferSkip.e, j - 1)));
                            return;
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("n >= 0 required but it was " + j);
            }
        }
    }
}
