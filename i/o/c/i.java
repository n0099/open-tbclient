package i.o.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import i.g;
/* loaded from: classes8.dex */
public class i implements i.n.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final i.n.a f60559e;

    /* renamed from: f  reason: collision with root package name */
    public final g.a f60560f;

    /* renamed from: g  reason: collision with root package name */
    public final long f60561g;

    public i(i.n.a aVar, g.a aVar2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, aVar2, Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60559e = aVar;
        this.f60560f = aVar2;
        this.f60561g = j2;
    }

    @Override // i.n.a
    public void call() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f60560f.isUnsubscribed()) {
            return;
        }
        long a = this.f60561g - this.f60560f.a();
        if (a > 0) {
            try {
                Thread.sleep(a);
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                i.m.a.c(e2);
                throw null;
            }
        }
        if (this.f60560f.isUnsubscribed()) {
            return;
        }
        this.f60559e.call();
    }
}
