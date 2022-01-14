package rx.internal.operators;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.f;
import i.j;
import i.o.a.a;
import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes4.dex */
public final class OperatorBufferWithSize$BufferOverlap<T> extends j<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public final j<? super List<T>> f62491i;

    /* renamed from: j  reason: collision with root package name */
    public final int f62492j;
    public final int k;
    public final ArrayDeque<List<T>> l;
    public final AtomicLong m;

    /* loaded from: classes4.dex */
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

        @Override // i.f
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                OperatorBufferWithSize$BufferOverlap operatorBufferWithSize$BufferOverlap = this.this$0;
                if (!a.e(operatorBufferWithSize$BufferOverlap.m, j2, operatorBufferWithSize$BufferOverlap.l, operatorBufferWithSize$BufferOverlap.f62491i) || j2 == 0) {
                    return;
                }
                if (get() || !compareAndSet(false, true)) {
                    operatorBufferWithSize$BufferOverlap.e(a.c(operatorBufferWithSize$BufferOverlap.k, j2));
                } else {
                    operatorBufferWithSize$BufferOverlap.e(a.a(a.c(operatorBufferWithSize$BufferOverlap.k, j2 - 1), operatorBufferWithSize$BufferOverlap.f62492j));
                }
            }
        }
    }
}
