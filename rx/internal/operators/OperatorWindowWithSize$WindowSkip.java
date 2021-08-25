package rx.internal.operators;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.f;
import i.j;
import i.n.a;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public final class OperatorWindowWithSize$WindowSkip<T> extends j<T> implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final int f79219e;

    /* renamed from: f  reason: collision with root package name */
    public final int f79220f;

    /* loaded from: classes2.dex */
    public final class WindowSkipProducer extends AtomicBoolean implements f {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 4625807964358024108L;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OperatorWindowWithSize$WindowSkip this$0;

        public WindowSkipProducer(OperatorWindowWithSize$WindowSkip operatorWindowWithSize$WindowSkip) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {operatorWindowWithSize$WindowSkip};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = operatorWindowWithSize$WindowSkip;
        }

        @Override // i.f
        public void request(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
                if (i2 < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + j2);
                } else if (i2 != 0) {
                    OperatorWindowWithSize$WindowSkip operatorWindowWithSize$WindowSkip = this.this$0;
                    if (get() || !compareAndSet(false, true)) {
                        operatorWindowWithSize$WindowSkip.request(i.o.a.a.c(j2, operatorWindowWithSize$WindowSkip.f79220f));
                    } else {
                        operatorWindowWithSize$WindowSkip.request(i.o.a.a.a(i.o.a.a.c(j2, operatorWindowWithSize$WindowSkip.f79219e), i.o.a.a.c(operatorWindowWithSize$WindowSkip.f79220f - operatorWindowWithSize$WindowSkip.f79219e, j2 - 1)));
                    }
                }
            }
        }
    }
}
