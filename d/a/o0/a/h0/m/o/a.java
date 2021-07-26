package d.a.o0.a.h0.m.o;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.h0.m.f;
import d.a.o0.a.v2.q0;
/* loaded from: classes7.dex */
public class a extends f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b F;

    /* renamed from: d.a.o0.a.h0.m.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0759a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f45534e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.q2.a f45535f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f45536g;

        public RunnableC0759a(a aVar, int i2, d.a.o0.a.q2.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45536g = aVar;
            this.f45534e = i2;
            this.f45535f = aVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f45536g.F == null) {
                return;
            }
            int i2 = this.f45534e;
            if (i2 == -1) {
                this.f45536g.F.b(this.f45535f);
            } else if (i2 == 0) {
                this.f45536g.F.a();
            } else if (i2 != 1) {
            } else {
                this.f45536g.F.onSuccess();
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a();

        void b(d.a.o0.a.q2.a aVar);

        void onSuccess();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String str, b bVar) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.F = bVar;
    }

    @Override // d.a.o0.a.h0.m.f, d.a.o0.n.f.g
    public void B(d.a.o0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.B(aVar);
            d.a.o0.a.q2.a aVar2 = new d.a.o0.a.q2.a();
            aVar2.j(10L);
            aVar2.h(aVar.f51130a);
            aVar2.c(aVar.f51131b);
            aVar2.p(aVar.f51132c);
            G0(-1, aVar2);
        }
    }

    @Override // d.a.o0.n.f.g
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            F0(0);
        }
    }

    public final void F0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            G0(i2, null);
        }
    }

    public final void G0(int i2, d.a.o0.a.q2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, aVar) == null) {
            q0.X(new RunnableC0759a(this, i2, aVar));
        }
    }

    @Override // d.a.o0.a.h0.m.j
    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // d.a.o0.a.h0.m.f
    public PMSDownloadType h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (PMSDownloadType) invokeV.objValue;
    }

    @Override // d.a.o0.a.h0.m.f
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.s0();
            d.a.o0.a.q2.a C0 = C0();
            if (C0 == null) {
                F0(1);
                x0("page_route_download", "0");
                return;
            }
            G0(-1, C0);
        }
    }

    @Override // d.a.o0.a.h0.m.f
    public void t0(Throwable th) {
        d.a.o0.a.q2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, th) == null) {
            if (th instanceof PkgDownloadError) {
                aVar = ((PkgDownloadError) th).getErrCode();
            } else {
                aVar = new d.a.o0.a.q2.a();
                aVar.j(10L);
                aVar.h(0L);
            }
            G0(-1, aVar);
        }
    }
}
