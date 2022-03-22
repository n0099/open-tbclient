package g.o.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import g.g;
/* loaded from: classes7.dex */
public class i implements g.n.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final g.n.a a;

    /* renamed from: b  reason: collision with root package name */
    public final g.a f44977b;

    /* renamed from: c  reason: collision with root package name */
    public final long f44978c;

    public i(g.n.a aVar, g.a aVar2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, aVar2, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = aVar;
        this.f44977b = aVar2;
        this.f44978c = j;
    }

    @Override // g.n.a
    public void call() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f44977b.isUnsubscribed()) {
            return;
        }
        long a = this.f44978c - this.f44977b.a();
        if (a > 0) {
            try {
                Thread.sleep(a);
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                g.m.a.c(e2);
                throw null;
            }
        }
        if (this.f44977b.isUnsubscribed()) {
            return;
        }
        this.a.call();
    }
}
