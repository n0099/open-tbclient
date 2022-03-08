package rx.internal.operators;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.f;
import i.j;
import i.o.a.a;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes9.dex */
public final class OperatorBufferWithSize$BufferSkip<T> extends j<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public final int f61055i;

    /* renamed from: j  reason: collision with root package name */
    public final int f61056j;

    /* loaded from: classes9.dex */
    public final class BufferSkipProducer extends AtomicBoolean implements f {
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = operatorBufferWithSize$BufferSkip;
        }

        @Override // i.f
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                if (i2 < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + j2);
                } else if (i2 != 0) {
                    OperatorBufferWithSize$BufferSkip operatorBufferWithSize$BufferSkip = this.this$0;
                    if (get() || !compareAndSet(false, true)) {
                        operatorBufferWithSize$BufferSkip.e(a.c(j2, operatorBufferWithSize$BufferSkip.f61056j));
                    } else {
                        operatorBufferWithSize$BufferSkip.e(a.a(a.c(j2, operatorBufferWithSize$BufferSkip.f61055i), a.c(operatorBufferWithSize$BufferSkip.f61056j - operatorBufferWithSize$BufferSkip.f61055i, j2 - 1)));
                    }
                }
            }
        }
    }
}
