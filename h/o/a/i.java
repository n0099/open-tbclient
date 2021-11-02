package h.o.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import h.d;
import h.g;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public final class i implements d.a<Long> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final long f71922e;

    /* renamed from: f  reason: collision with root package name */
    public final TimeUnit f71923f;

    /* renamed from: g  reason: collision with root package name */
    public final h.g f71924g;

    /* loaded from: classes2.dex */
    public class a implements h.n.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.j f71925e;

        public a(i iVar, h.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f71925e = jVar;
        }

        @Override // h.n.a
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f71925e.onNext(0L);
                    this.f71925e.onCompleted();
                } catch (Throwable th) {
                    h.m.a.f(th, this.f71925e);
                }
            }
        }
    }

    public i(long j, TimeUnit timeUnit, h.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), timeUnit, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71922e = j;
        this.f71923f = timeUnit;
        this.f71924g = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // h.d.a, h.n.b
    public void call(h.j<? super Long> jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
            g.a createWorker = this.f71924g.createWorker();
            jVar.b(createWorker);
            createWorker.c(new a(this, jVar), this.f71922e, this.f71923f);
        }
    }
}
