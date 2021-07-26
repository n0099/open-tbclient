package d.a.o0.a.h0.m.q;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a1.e;
import d.a.o0.a.h0.m.c;
import d.a.o0.a.h0.m.j;
import d.a.o0.a.k;
import d.a.o0.a.v2.j0;
import d.a.o0.n.f.c;
import d.a.o0.n.h.g;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public class a extends j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.a.h0.m.b f45543g;

    /* renamed from: h  reason: collision with root package name */
    public String f45544h;

    /* renamed from: i  reason: collision with root package name */
    public String f45545i;
    public c<g> j;

    /* renamed from: d.a.o0.a.h0.m.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0761a extends d.a.o0.n.f.b<g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f45546e;

        public C0761a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45546e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.c
        /* renamed from: l */
        public String d(g gVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gVar)) == null) ? d.a.o0.a.h0.m.r.b.a(this.f45546e.f45545i) : (String) invokeL.objValue;
        }

        @Override // d.a.o0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, bundle, set)) == null) ? this.f45546e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: o */
        public void e(g gVar, d.a.o0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048582, this, gVar, aVar) == null) {
                super.e(gVar, aVar);
                if (a.k) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadError:" + aVar.toString());
                }
                d.a.o0.a.q2.a aVar2 = new d.a.o0.a.q2.a();
                aVar2.j(12L);
                aVar2.h(aVar.f51130a);
                aVar2.c("分包下载失败");
                aVar2.e(aVar.toString());
                this.f45546e.R(3, aVar2);
                d.a.o0.a.h0.m.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: p */
        public void i(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, gVar) == null) {
                super.i(gVar);
                if (a.k) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish:" + gVar.toString());
                }
                this.f45546e.T(gVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: q */
        public void f(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gVar) == null) {
                super.f(gVar);
                if (a.k) {
                    Log.i("SwanAppSubPkgDownload", "onDownloading");
                }
                this.f45546e.U(gVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c.InterfaceC0753c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f45547a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f45547a = aVar;
        }

        @Override // d.a.o0.a.h0.m.c.InterfaceC0753c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.f45547a.S();
            }
        }

        @Override // d.a.o0.a.h0.m.c.InterfaceC0753c
        public void b(PMSDownloadType pMSDownloadType, d.a.o0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f45547a.R(0, aVar);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(484456778, "Ld/a/o0/a/h0/m/q/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(484456778, "Ld/a/o0/a/h0/m/q/a;");
                return;
            }
        }
        k = k.f46335a;
    }

    public a(String str, String str2, d.a.o0.a.h0.m.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = new C0761a(this);
        this.f45544h = str;
        this.f45543g = bVar;
        this.f45545i = e.C0638e.i(str, str2).getPath();
    }

    @Override // d.a.o0.n.f.g
    public void B(d.a.o0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.B(aVar);
            d.a.o0.a.q2.a aVar2 = new d.a.o0.a.q2.a();
            aVar2.j(12L);
            aVar2.h(aVar.f51130a);
            aVar2.c(aVar.f51131b);
            aVar2.p(aVar.f51132c);
            R(1, aVar2);
        }
    }

    @Override // d.a.o0.n.f.g
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            d.a.o0.a.q2.a aVar = new d.a.o0.a.q2.a();
            aVar.j(12L);
            aVar.h(2901L);
            aVar.c("Server无包");
            R(2, aVar);
        }
    }

    public final void R(int i2, d.a.o0.a.q2.a aVar) {
        d.a.o0.a.h0.m.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, aVar) == null) || (bVar = this.f45543g) == null) {
            return;
        }
        bVar.b(i2, aVar);
    }

    public final void S() {
        d.a.o0.a.h0.m.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bVar = this.f45543g) == null) {
            return;
        }
        bVar.a();
    }

    public final void T(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, gVar) == null) {
            if (!j0.a(new File(gVar.f51134a), gVar.m)) {
                if (k) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                d.a.o0.a.q2.a aVar = new d.a.o0.a.q2.a();
                aVar.j(12L);
                aVar.h(2300L);
                aVar.c("分包签名校验");
                R(4, aVar);
                d.a.o0.a.h0.m.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar);
            } else if (d.a.o0.a.h0.m.r.b.h(new File(gVar.f51134a), new File(this.f45545i, gVar.p))) {
                if (k) {
                    Log.i("SwanAppSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                gVar.o = this.f45544h;
                d.a.o0.n.g.a.h().l(gVar);
                S();
                d.a.o0.a.h0.m.c.c().b(gVar, PMSDownloadType.ALONE_SUB);
            } else {
                if (k) {
                    Log.e("SwanAppSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                d.a.o0.a.q2.a aVar2 = new d.a.o0.a.q2.a();
                aVar2.j(12L);
                aVar2.h(2320L);
                aVar2.c("分包解压失败");
                R(5, aVar2);
                d.a.o0.a.h0.m.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar2);
            }
        }
    }

    public final void U(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            d.a.o0.a.h0.m.c.c().d(gVar, new b(this));
        }
    }

    @Override // d.a.o0.n.f.g
    public d.a.o0.n.f.c<g> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : (d.a.o0.n.f.c) invokeV.objValue;
    }
}
