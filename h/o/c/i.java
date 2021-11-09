package h.o.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.g;
/* loaded from: classes2.dex */
public class i implements h.n.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final h.n.a f72053e;

    /* renamed from: f  reason: collision with root package name */
    public final g.a f72054f;

    /* renamed from: g  reason: collision with root package name */
    public final long f72055g;

    public i(h.n.a aVar, g.a aVar2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, aVar2, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72053e = aVar;
        this.f72054f = aVar2;
        this.f72055g = j;
    }

    @Override // h.n.a
    public void call() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f72054f.isUnsubscribed()) {
            return;
        }
        long a2 = this.f72055g - this.f72054f.a();
        if (a2 > 0) {
            try {
                Thread.sleep(a2);
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                h.m.a.c(e2);
                throw null;
            }
        }
        if (this.f72054f.isUnsubscribed()) {
            return;
        }
        this.f72053e.call();
    }
}
