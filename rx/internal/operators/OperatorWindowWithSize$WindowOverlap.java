package rx.internal.operators;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.f;
import h.j;
import h.n.a;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes10.dex */
public final class OperatorWindowWithSize$WindowOverlap<T> extends j<T> implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f76222e;

    /* renamed from: f  reason: collision with root package name */
    public final int f76223f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicLong f76224g;

    /* loaded from: classes10.dex */
    public final class WindowOverlapProducer extends AtomicBoolean implements f {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 4625807964358024108L;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OperatorWindowWithSize$WindowOverlap this$0;

        public WindowOverlapProducer(OperatorWindowWithSize$WindowOverlap operatorWindowWithSize$WindowOverlap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {operatorWindowWithSize$WindowOverlap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = operatorWindowWithSize$WindowOverlap;
        }

        @Override // h.f
        public void request(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i2 < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + j);
                } else if (i2 != 0) {
                    OperatorWindowWithSize$WindowOverlap operatorWindowWithSize$WindowOverlap = this.this$0;
                    if (!get() && compareAndSet(false, true)) {
                        operatorWindowWithSize$WindowOverlap.request(h.o.a.a.a(h.o.a.a.c(operatorWindowWithSize$WindowOverlap.f76223f, j - 1), operatorWindowWithSize$WindowOverlap.f76222e));
                    } else {
                        this.this$0.request(h.o.a.a.c(operatorWindowWithSize$WindowOverlap.f76223f, j));
                    }
                    h.o.a.a.b(operatorWindowWithSize$WindowOverlap.f76224g, j);
                    operatorWindowWithSize$WindowOverlap.d();
                }
            }
        }
    }

    public abstract void d();
}
