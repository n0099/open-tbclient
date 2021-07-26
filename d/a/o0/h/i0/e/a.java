package d.a.o0.h.i0.e;

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
import d.a.o0.a.h0.m.c;
import d.a.o0.a.h0.m.j;
import d.a.o0.a.k;
import d.a.o0.a.v2.j0;
import d.a.o0.h.i0.b;
import d.a.o0.h.s.a;
import d.a.o0.n.f.c;
import d.a.o0.n.h.g;
import java.io.File;
import java.util.Set;
/* loaded from: classes7.dex */
public class a extends j {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public b.a f50538g;

    /* renamed from: h  reason: collision with root package name */
    public String f50539h;

    /* renamed from: i  reason: collision with root package name */
    public String f50540i;
    public String j;
    public c<g> k;

    /* renamed from: d.a.o0.h.i0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1104a extends d.a.o0.n.f.b<g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f50541e;

        public C1104a(a aVar) {
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
            this.f50541e = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.c
        /* renamed from: l */
        public String d(g gVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, gVar)) == null) ? d.a.o0.a.h0.m.r.b.c(this.f50541e.j) : (String) invokeL.objValue;
        }

        @Override // d.a.o0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.f50541e.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: o */
        public void e(g gVar, d.a.o0.n.h.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, gVar, aVar) == null) {
                super.e(gVar, aVar);
                if (a.l) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadError: " + aVar.toString());
                }
                this.f50541e.S(2103);
                d.a.o0.a.q2.a aVar2 = new d.a.o0.a.q2.a();
                aVar2.j(12L);
                aVar2.h(aVar.f51130a);
                aVar2.c("分包下载失败");
                aVar2.e(aVar.toString());
                d.a.o0.a.h0.m.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: p */
        public void i(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gVar) == null) {
                super.i(gVar);
                if (a.l) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: " + gVar.toString());
                }
                this.f50541e.V(gVar);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: q */
        public void a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, gVar) == null) {
                super.a(gVar);
                if (a.l) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadProgress: " + gVar.k + ":" + gVar.f51135b);
                }
                this.f50541e.T(gVar.f51135b, gVar.k);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.n.f.b, d.a.o0.n.f.c
        /* renamed from: r */
        public void f(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
                super.f(gVar);
                if (a.l) {
                    Log.i("SwanGameSubPkgDownload", "onDownloading");
                }
                this.f50541e.W(gVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c.InterfaceC0753c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f50542a;

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
            this.f50542a = aVar;
        }

        @Override // d.a.o0.a.h0.m.c.InterfaceC0753c
        public void a(PMSDownloadType pMSDownloadType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSDownloadType) == null) {
                this.f50542a.U();
            }
        }

        @Override // d.a.o0.a.h0.m.c.InterfaceC0753c
        public void b(PMSDownloadType pMSDownloadType, d.a.o0.a.q2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSDownloadType, aVar) == null) {
                this.f50542a.S(2103);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1567416508, "Ld/a/o0/h/i0/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1567416508, "Ld/a/o0/h/i0/e/a;");
                return;
            }
        }
        l = k.f46335a;
    }

    public a(String str, String str2, String str3, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = new C1104a(this);
        this.f50539h = str;
        this.f50540i = str3;
        this.f50538g = aVar;
        this.j = a.d.h(str, str2).getPath();
    }

    @Override // d.a.o0.n.f.g
    public void B(d.a.o0.n.h.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.B(aVar);
            if (l) {
                Log.e("SwanGameSubPkgDownload", "onFetchError: " + aVar.toString());
            }
            S(2103);
        }
    }

    @Override // d.a.o0.n.f.g
    public void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.E();
            if (l) {
                Log.i("SwanGameSubPkgDownload", "onNoPackage");
            }
            S(2102);
        }
    }

    public final void S(int i2) {
        b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (aVar = this.f50538g) == null) {
            return;
        }
        aVar.b(i2);
    }

    public final void T(long j, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) || this.f50538g == null) {
            return;
        }
        if (j2 > 0 && j <= j2) {
            int floor = (int) Math.floor((j * 100.0d) / j2);
            if (floor != 100) {
                if (l) {
                    Log.i("SwanGameSubPkgDownload", "callbackProgress: " + floor);
                }
                this.f50538g.a(floor, j, j2);
                return;
            }
            return;
        }
        S(2114);
    }

    public final void U() {
        b.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.f50538g) == null) {
            return;
        }
        aVar.success();
    }

    public final void V(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            if (!j0.a(new File(gVar.f51134a), gVar.m)) {
                if (l) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 签名校验失败");
                }
                S(2104);
                d.a.o0.a.q2.a aVar = new d.a.o0.a.q2.a();
                aVar.j(12L);
                aVar.h(2300L);
                aVar.c("分包签名校验");
                d.a.o0.a.h0.m.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar);
            } else if (d.a.o0.a.h0.m.r.b.h(new File(gVar.f51134a), new File(this.j, this.f50540i))) {
                if (l) {
                    Log.i("SwanGameSubPkgDownload", "onDownloadFinish: 解压成功");
                }
                U();
                gVar.o = this.f50539h;
                d.a.o0.n.g.a.h().l(gVar);
                d.a.o0.a.h0.m.c.c().b(gVar, PMSDownloadType.ALONE_SUB);
            } else {
                if (l) {
                    Log.e("SwanGameSubPkgDownload", "onDownloadFinish: 解压失败");
                }
                S(2105);
                d.a.o0.a.q2.a aVar2 = new d.a.o0.a.q2.a();
                aVar2.j(12L);
                aVar2.h(2320L);
                aVar2.c("分包解压失败");
                d.a.o0.a.h0.m.c.c().a(gVar, PMSDownloadType.ALONE_SUB, aVar2);
            }
        }
    }

    public final void W(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, gVar) == null) {
            d.a.o0.a.h0.m.c.c().d(gVar, new b(this));
        }
    }

    @Override // d.a.o0.n.f.g
    public d.a.o0.n.f.c<g> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : (d.a.o0.n.f.c) invokeV.objValue;
    }
}
