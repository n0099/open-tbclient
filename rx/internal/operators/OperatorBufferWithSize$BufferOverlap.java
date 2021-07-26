package rx.internal.operators;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.f;
import h.j;
import h.o.a.a;
import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes9.dex */
public final class OperatorBufferWithSize$BufferOverlap<T> extends j<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final j<? super List<T>> f73673e;

    /* renamed from: f  reason: collision with root package name */
    public final int f73674f;

    /* renamed from: g  reason: collision with root package name */
    public final int f73675g;

    /* renamed from: h  reason: collision with root package name */
    public final ArrayDeque<List<T>> f73676h;

    /* renamed from: i  reason: collision with root package name */
    public final AtomicLong f73677i;

    /* loaded from: classes9.dex */
    public final class BufferOverlapProducer extends AtomicBoolean implements f {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -4015894850868853147L;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OperatorBufferWithSize$BufferOverlap this$0;

        public BufferOverlapProducer(OperatorBufferWithSize$BufferOverlap operatorBufferWithSize$BufferOverlap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {operatorBufferWithSize$BufferOverlap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = operatorBufferWithSize$BufferOverlap;
        }

        @Override // h.f
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                OperatorBufferWithSize$BufferOverlap operatorBufferWithSize$BufferOverlap = this.this$0;
                if (!a.e(operatorBufferWithSize$BufferOverlap.f73677i, j, operatorBufferWithSize$BufferOverlap.f73676h, operatorBufferWithSize$BufferOverlap.f73673e) || j == 0) {
                    return;
                }
                if (get() || !compareAndSet(false, true)) {
                    operatorBufferWithSize$BufferOverlap.request(a.c(operatorBufferWithSize$BufferOverlap.f73675g, j));
                } else {
                    operatorBufferWithSize$BufferOverlap.request(a.a(a.c(operatorBufferWithSize$BufferOverlap.f73675g, j - 1), operatorBufferWithSize$BufferOverlap.f73674f));
                }
            }
        }
    }
}
