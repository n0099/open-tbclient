package d.l.a.e.b.m;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.e.b.f.v;
import java.util.List;
/* loaded from: classes10.dex */
public class n implements d.l.a.e.b.g.n, d.l.a.e.b.g.o {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static final String f74921d = "n";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile com.ss.android.socialbase.downloader.downloader.i f74922a;

    /* renamed from: b  reason: collision with root package name */
    public d.l.a.e.b.g.p<IndependentProcessDownloadService> f74923b;

    /* renamed from: c  reason: collision with root package name */
    public d.l.a.e.b.g.n f74924c;

    /* loaded from: classes10.dex */
    public class a implements d.l.a.e.b.f.l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.l.a.e.b.f.l
        public void a(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        d.l.a.e.b.g.a.H(d.l.a.e.b.g.e.n()).b(i2);
                        return;
                    }
                    return;
                }
                d.l.a.e.b.g.a.H(d.l.a.e.b.g.e.n()).u(i2);
                List<com.ss.android.socialbase.downloader.model.b> i4 = l.a(false).i(i2);
                if (i4 != null) {
                    l.a(true).a(i2, d.l.a.e.b.l.f.r(i4));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1799778158, "Ld/l/a/e/b/m/n;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1799778158, "Ld/l/a/e/b/m/n;");
        }
    }

    public n() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f74924c = new o();
        d.l.a.e.b.g.p<IndependentProcessDownloadService> O0 = d.l.a.e.b.g.e.O0();
        this.f74923b = O0;
        O0.d(this);
    }

    @Override // d.l.a.e.b.g.n
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f74922a == null) {
            return;
        }
        try {
            this.f74922a.a(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.l.a.e.b.g.n
    public void b(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, downloadInfo) == null) {
        }
    }

    @Override // d.l.a.e.b.g.n
    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) {
            if (this.f74922a == null) {
                return false;
            }
            try {
                return this.f74922a.b(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // d.l.a.e.b.g.n
    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048604, this, i2) == null) || this.f74922a == null) {
            return;
        }
        try {
            this.f74922a.c(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.l.a.e.b.g.n
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048611, this, i2) == null) || this.f74922a == null) {
            return;
        }
        try {
            this.f74922a.d(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.l.a.e.b.g.n
    public long e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i2)) == null) {
            if (this.f74922a == null) {
                return 0L;
            }
            try {
                return this.f74922a.e(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return 0L;
            }
        }
        return invokeI.longValue;
    }

    @Override // d.l.a.e.b.g.n
    public int f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048617, this, i2)) == null) {
            if (this.f74922a == null) {
                return 0;
            }
            try {
                return this.f74922a.f(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeI.intValue;
    }

    @Override // d.l.a.e.b.g.n
    public boolean g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048622, this, i2)) == null) {
            if (this.f74922a == null) {
                return false;
            }
            try {
                return this.f74922a.g(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // d.l.a.e.b.g.n
    public DownloadInfo h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i2)) == null) {
            if (this.f74922a == null) {
                return this.f74924c.h(i2);
            }
            try {
                return this.f74922a.h(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // d.l.a.e.b.g.n
    public List<com.ss.android.socialbase.downloader.model.b> i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048625, this, i2)) == null) {
            if (this.f74922a == null) {
                return this.f74924c.i(i2);
            }
            try {
                return this.f74922a.i(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeI.objValue;
    }

    @Override // d.l.a.e.b.g.n
    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048627, this, i2) == null) {
            if (this.f74922a == null) {
                this.f74924c.j(i2);
                return;
            }
            try {
                this.f74922a.j(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.l.a.e.b.g.n
    public void k(int i2) {
        d.l.a.e.b.g.p<IndependentProcessDownloadService> pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048628, this, i2) == null) || (pVar = this.f74923b) == null) {
            return;
        }
        pVar.a(i2);
    }

    @Override // d.l.a.e.b.g.n
    public boolean l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048629, this, i2)) == null) {
            if (this.f74922a == null) {
                return false;
            }
            try {
                return this.f74922a.k(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // d.l.a.e.b.g.n
    public int m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048630, this, i2)) == null) {
            if (this.f74922a == null) {
                return d.l.a.e.b.g.f.c().m(i2);
            }
            try {
                return this.f74922a.m(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return -1;
            }
        }
        return invokeI.intValue;
    }

    @Override // d.l.a.e.b.g.n
    public boolean n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048631, this, i2)) == null) {
            if (this.f74922a == null) {
                return this.f74924c.n(i2);
            }
            try {
                return this.f74922a.n(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // d.l.a.e.b.g.n
    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i2) == null) {
            if (this.f74922a == null) {
                this.f74924c.o(i2);
                return;
            }
            try {
                this.f74922a.o(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.l.a.e.b.g.n
    public boolean p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048633, this, i2)) == null) {
            if (this.f74922a == null) {
                return this.f74924c.p(i2);
            }
            try {
                return this.f74922a.p(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // d.l.a.e.b.g.n
    public d.l.a.e.b.f.d q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048634, this, i2)) == null) {
            if (this.f74922a != null) {
                try {
                    return com.ss.android.socialbase.downloader.i.g.d(this.f74922a.q(i2));
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (d.l.a.e.b.f.d) invokeI.objValue;
    }

    @Override // d.l.a.e.b.g.n
    public d.l.a.e.b.f.i r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048635, this, i2)) == null) {
            if (this.f74922a != null) {
                try {
                    return com.ss.android.socialbase.downloader.i.g.f(this.f74922a.r(i2));
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (d.l.a.e.b.f.i) invokeI.objValue;
    }

    @Override // d.l.a.e.b.g.n
    public v s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048636, this, i2)) == null) {
            if (this.f74922a != null) {
                try {
                    return com.ss.android.socialbase.downloader.i.g.w(this.f74922a.s(i2));
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (v) invokeI.objValue;
    }

    @Override // d.l.a.e.b.g.n
    public void a(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.f74922a == null) {
            return;
        }
        try {
            this.f74922a.a(i2, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.l.a.e.b.g.n
    public DownloadInfo b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, str, str2)) == null) ? h(a(str, str2)) : (DownloadInfo) invokeLL.objValue;
    }

    @Override // d.l.a.e.b.g.n
    public List<DownloadInfo> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            if (this.f74922a == null) {
                return this.f74924c.c(str);
            }
            try {
                return this.f74922a.c(str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // d.l.a.e.b.g.n
    public List<DownloadInfo> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.f74922a == null) {
                return this.f74924c.d();
            }
            try {
                return this.f74922a.b();
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeV.objValue;
    }

    @Override // d.l.a.e.b.g.n
    public List<DownloadInfo> e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) {
            if (this.f74922a != null) {
                try {
                    return this.f74922a.d(str);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    @Override // d.l.a.e.b.g.n
    public void f(int i2, int i3, d.l.a.e.b.f.b bVar, com.ss.android.socialbase.downloader.constants.g gVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), bVar, gVar, Boolean.valueOf(z)}) == null) || this.f74922a == null) {
            return;
        }
        try {
            this.f74922a.b(i2, i3, com.ss.android.socialbase.downloader.i.g.n(bVar, gVar != com.ss.android.socialbase.downloader.constants.g.f41461b), gVar.ordinal(), z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.l.a.e.b.g.n
    public void g(int i2, int i3, d.l.a.e.b.f.b bVar, com.ss.android.socialbase.downloader.constants.g gVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), bVar, gVar, Boolean.valueOf(z)}) == null) || this.f74922a == null) {
            return;
        }
        try {
            this.f74922a.a(i2, i3, com.ss.android.socialbase.downloader.i.g.n(bVar, gVar != com.ss.android.socialbase.downloader.constants.g.f41461b), gVar.ordinal(), z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.l.a.e.b.g.n
    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.f74922a != null : invokeV.booleanValue;
    }

    @Override // d.l.a.e.b.g.o
    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            this.f74922a = null;
        }
    }

    @Override // d.l.a.e.b.g.n
    public List<DownloadInfo> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            if (this.f74922a == null) {
                return this.f74924c.b(str);
            }
            try {
                return this.f74922a.b(str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // d.l.a.e.b.g.n
    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f74922a == null) {
            return;
        }
        try {
            this.f74922a.a();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.l.a.e.b.g.n
    public void e() {
        d.l.a.e.b.g.p<IndependentProcessDownloadService> pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048615, this) == null) || (pVar = this.f74923b) == null) {
            return;
        }
        pVar.f();
    }

    @Override // d.l.a.e.b.g.n
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (this.f74922a == null) {
                return this.f74924c.f();
            }
            try {
                return this.f74922a.d();
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // d.l.a.e.b.g.n
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            if (this.f74922a == null) {
                this.f74924c.g();
                return;
            }
            try {
                this.f74922a.e();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.l.a.e.b.g.n
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? d.l.a.e.b.g.e.o() : invokeV.booleanValue;
    }

    @Override // d.l.a.e.b.g.n
    public void d(int i2, int i3, d.l.a.e.b.f.b bVar, com.ss.android.socialbase.downloader.constants.g gVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), bVar, gVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f74922a == null) {
            return;
        }
        try {
            this.f74922a.a(i2, i3, com.ss.android.socialbase.downloader.i.g.n(bVar, gVar != com.ss.android.socialbase.downloader.constants.g.f41461b), gVar.ordinal(), z, z2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.l.a.e.b.g.n
    public void c(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.f74922a == null) {
            return;
        }
        try {
            this.f74922a.d(i2, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.l.a.e.b.g.n
    public void e(d.l.a.e.b.f.l lVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, lVar) == null) || this.f74922a == null) {
            return;
        }
        try {
            this.f74922a.a(com.ss.android.socialbase.downloader.i.g.h(lVar));
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.l.a.e.b.g.n
    public List<DownloadInfo> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.f74922a == null) {
                return this.f74924c.a(str);
            }
            try {
                return this.f74922a.a(str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // d.l.a.e.b.g.n
    public void b(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, list) == null) {
            if (this.f74922a == null) {
                this.f74924c.b(list);
                return;
            }
            try {
                this.f74922a.b(list);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.l.a.e.b.g.n
    public List<DownloadInfo> d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            if (this.f74922a == null) {
                return this.f74924c.d(str);
            }
            try {
                return this.f74922a.e(str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // d.l.a.e.b.g.n
    public boolean c(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, downloadInfo)) == null) {
            if (this.f74922a == null) {
                return this.f74924c.c(downloadInfo);
            }
            try {
                return this.f74922a.b(downloadInfo);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // d.l.a.e.b.g.n
    public int a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) ? d.l.a.e.b.g.e.w(str, str2) : invokeLL.intValue;
    }

    @Override // d.l.a.e.b.g.n
    public void b(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (this.f74922a == null) {
                this.f74924c.b(i2, z);
                return;
            }
            try {
                this.f74922a.b(i2, z);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.l.a.e.b.g.n
    public void a(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            if (this.f74922a == null) {
                this.f74924c.a(list);
                return;
            }
            try {
                this.f74922a.a(list);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.l.a.e.b.g.n
    public void c(int i2, d.l.a.e.b.f.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048605, this, i2, dVar) == null) || this.f74922a == null) {
            return;
        }
        try {
            this.f74922a.a(i2, com.ss.android.socialbase.downloader.i.g.c(dVar));
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.l.a.e.b.g.n
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.f74922a == null) {
                d.l.a.e.b.c.a.j(f74921d, "isServiceForeground, aidlService is null");
                return false;
            }
            d.l.a.e.b.c.a.i(f74921d, "aidlService.isServiceForeground");
            try {
                return this.f74922a.f();
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // d.l.a.e.b.g.n
    public boolean a(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, downloadInfo)) == null) {
            if (this.f74922a == null) {
                return this.f74924c.a(downloadInfo);
            }
            try {
                this.f74922a.a(downloadInfo);
                return false;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // d.l.a.e.b.g.n
    public void a(int i2, Notification notification) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048585, this, i2, notification) == null) {
            if (this.f74922a == null) {
                d.l.a.e.b.c.a.j(f74921d, "startForeground, aidlService is null");
                return;
            }
            String str = f74921d;
            d.l.a.e.b.c.a.i(str, "aidlService.startForeground, id = " + i2);
            try {
                this.f74922a.a(i2, notification);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.l.a.e.b.g.n
    public void b(d.l.a.e.b.n.a aVar) {
        d.l.a.e.b.g.p<IndependentProcessDownloadService> pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, aVar) == null) || aVar == null || (pVar = this.f74923b) == null) {
            return;
        }
        pVar.a(aVar);
    }

    @Override // d.l.a.e.b.g.n
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048596, this, i2, list) == null) {
            if (this.f74922a == null) {
                this.f74924c.b(i2, list);
                return;
            }
            try {
                this.f74922a.a(i2, list);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.l.a.e.b.g.n
    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (this.f74922a == null) {
                d.l.a.e.b.c.a.j(f74921d, "stopForeground, aidlService is null");
                return;
            }
            d.l.a.e.b.c.a.i(f74921d, "aidlService.stopForeground");
            try {
                this.f74922a.a(z2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.l.a.e.b.g.n
    public void a(d.l.a.e.b.n.a aVar) {
        d.l.a.e.b.g.p<IndependentProcessDownloadService> pVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) || aVar == null || (pVar = this.f74923b) == null) {
            return;
        }
        pVar.b(aVar);
    }

    @Override // d.l.a.e.b.g.n
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048586, this, i2, list) == null) || this.f74922a == null) {
            return;
        }
        try {
            this.f74922a.b(i2, list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.l.a.e.b.g.n
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            if (this.f74922a == null) {
                this.f74924c.a(bVar);
                return;
            }
            try {
                this.f74922a.a(bVar);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.l.a.e.b.g.n
    public void a(int i2, int i3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)}) == null) {
            if (this.f74922a == null) {
                this.f74924c.a(i2, i3, j);
                return;
            }
            try {
                this.f74922a.a(i2, i3, j);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.l.a.e.b.g.n
    public void a(int i2, int i3, int i4, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j)}) == null) {
            if (this.f74922a == null) {
                this.f74924c.a(i2, i3, i4, j);
                return;
            }
            try {
                this.f74922a.a(i2, i3, i4, j);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.l.a.e.b.g.n
    public void a(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) {
            if (this.f74922a == null) {
                this.f74924c.a(i2, i3, i4, i5);
                return;
            }
            try {
                this.f74922a.a(i2, i3, i4, i5);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // d.l.a.e.b.g.n
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) || this.f74922a == null) {
            return;
        }
        try {
            this.f74922a.a(i2, i3);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.l.a.e.b.g.o
    public void a(IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, iBinder) == null) {
            this.f74922a = i.a.a(iBinder);
            if (d.l.a.e.b.l.f.F()) {
                e(new a(this));
            }
        }
    }

    @Override // d.l.a.e.b.g.n
    public void a(int i2, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f74922a == null) {
            return;
        }
        try {
            this.f74922a.a(i2, j);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
