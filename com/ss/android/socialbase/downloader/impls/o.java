package com.ss.android.socialbase.downloader.impls;

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
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.ak;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;
/* loaded from: classes2.dex */
public class o implements com.ss.android.socialbase.downloader.downloader.m, com.ss.android.socialbase.downloader.downloader.n {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f69574a = "o";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public volatile com.ss.android.socialbase.downloader.downloader.i f69575b;

    /* renamed from: c  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.downloader.o<IndependentProcessDownloadService> f69576c;

    /* renamed from: d  reason: collision with root package name */
    public com.ss.android.socialbase.downloader.downloader.m f69577d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-292378874, "Lcom/ss/android/socialbase/downloader/impls/o;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-292378874, "Lcom/ss/android/socialbase/downloader/impls/o;");
        }
    }

    public o() {
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
        this.f69577d = new p();
        com.ss.android.socialbase.downloader.downloader.o<IndependentProcessDownloadService> z = com.ss.android.socialbase.downloader.downloader.c.z();
        this.f69576c = z;
        z.a(this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || this.f69575b == null) {
            return;
        }
        try {
            this.f69575b.a(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, downloadInfo) == null) {
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            if (this.f69575b == null) {
                return false;
            }
            try {
                return this.f69575b.b(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048609, this, i2) == null) || this.f69575b == null) {
            return;
        }
        try {
            this.f69575b.c(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048615, this, i2) == null) || this.f69575b == null) {
            return;
        }
        try {
            this.f69575b.d(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public long e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i2)) == null) {
            if (this.f69575b == null) {
                return 0L;
            }
            try {
                return this.f69575b.e(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return 0L;
            }
        }
        return invokeI.longValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public int f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048619, this, i2)) == null) {
            if (this.f69575b == null) {
                return 0;
            }
            try {
                return this.f69575b.f(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeI.intValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048622, this, i2)) == null) {
            if (this.f69575b == null) {
                return false;
            }
            try {
                return this.f69575b.g(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public DownloadInfo h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i2)) == null) {
            if (this.f69575b == null) {
                return this.f69577d.h(i2);
            }
            try {
                return this.f69575b.h(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<com.ss.android.socialbase.downloader.model.b> i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048625, this, i2)) == null) {
            if (this.f69575b == null) {
                return this.f69577d.i(i2);
            }
            try {
                return this.f69575b.i(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i2) == null) {
            if (this.f69575b == null) {
                this.f69577d.j(i2);
                return;
            }
            try {
                this.f69575b.j(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void k(int i2) {
        com.ss.android.socialbase.downloader.downloader.o<IndependentProcessDownloadService> oVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048627, this, i2) == null) || (oVar = this.f69576c) == null) {
            return;
        }
        oVar.a(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048628, this, i2)) == null) {
            if (this.f69575b == null) {
                return false;
            }
            try {
                return this.f69575b.k(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public int m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048629, this, i2)) == null) {
            if (this.f69575b == null) {
                return com.ss.android.socialbase.downloader.downloader.d.a().b(i2);
            }
            try {
                return this.f69575b.m(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return -1;
            }
        }
        return invokeI.intValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048630, this, i2)) == null) {
            if (this.f69575b == null) {
                return this.f69577d.n(i2);
            }
            try {
                return this.f69575b.n(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i2) == null) {
            if (this.f69575b == null) {
                this.f69577d.o(i2);
                return;
            }
            try {
                this.f69575b.o(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048632, this, i2)) == null) {
            if (this.f69575b == null) {
                return this.f69577d.p(i2);
            }
            try {
                return this.f69575b.p(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public z q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048633, this, i2)) == null) {
            if (this.f69575b != null) {
                try {
                    return com.ss.android.socialbase.downloader.i.g.a(this.f69575b.q(i2));
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (z) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public af r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048634, this, i2)) == null) {
            if (this.f69575b != null) {
                try {
                    return com.ss.android.socialbase.downloader.i.g.a(this.f69575b.r(i2));
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (af) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public IDownloadFileUriProvider s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048635, this, i2)) == null) {
            if (this.f69575b != null) {
                try {
                    return com.ss.android.socialbase.downloader.i.g.a(this.f69575b.s(i2));
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (IDownloadFileUriProvider) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void startService() {
        com.ss.android.socialbase.downloader.downloader.o<IndependentProcessDownloadService> oVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048636, this) == null) || (oVar = this.f69576c) == null) {
            return;
        }
        oVar.startService();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.f69575b == null) {
            return;
        }
        try {
            this.f69575b.a(i2, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public DownloadInfo b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, str, str2)) == null) ? h(a(str, str2)) : (DownloadInfo) invokeLL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
            if (this.f69575b == null) {
                return this.f69577d.c(str);
            }
            try {
                return this.f69575b.c(str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (this.f69575b == null) {
                return this.f69577d.d();
            }
            try {
                return this.f69575b.b();
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeV.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, str)) == null) {
            if (this.f69575b != null) {
                try {
                    return this.f69575b.d(str);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            if (this.f69575b == null) {
                this.f69577d.f();
                return;
            }
            try {
                this.f69575b.e();
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.f69575b != null : invokeV.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            this.f69575b = null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            if (this.f69575b == null) {
                return this.f69577d.b(str);
            }
            try {
                return this.f69575b.b(str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f69575b == null) {
            return;
        }
        try {
            this.f69575b.a();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (this.f69575b == null) {
                return this.f69577d.e();
            }
            try {
                return this.f69575b.d();
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? com.ss.android.socialbase.downloader.downloader.c.O() : invokeV.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) {
            if (this.f69575b == null) {
                return this.f69577d.d(str);
            }
            try {
                return this.f69575b.e(str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void c(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || this.f69575b == null) {
            return;
        }
        try {
            this.f69575b.d(i2, z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (this.f69575b == null) {
                return this.f69577d.a(str);
            }
            try {
                return this.f69575b.a(str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, list) == null) {
            if (this.f69575b == null) {
                this.f69577d.b(list);
                return;
            }
            try {
                this.f69575b.b(list);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean c(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, downloadInfo)) == null) {
            if (this.f69575b == null) {
                return this.f69577d.c(downloadInfo);
            }
            try {
                return this.f69575b.b(downloadInfo);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public int a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) ? com.ss.android.socialbase.downloader.downloader.c.a(str, str2) : invokeLL.intValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (this.f69575b == null) {
                this.f69577d.b(i2, z);
                return;
            }
            try {
                this.f69575b.b(i2, z);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            if (this.f69575b == null) {
                this.f69577d.a(list);
                return;
            }
            try {
                this.f69575b.a(list);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iDownloadListener, fVar, Boolean.valueOf(z)}) == null) || this.f69575b == null) {
            return;
        }
        try {
            this.f69575b.a(i2, i3, com.ss.android.socialbase.downloader.i.g.a(iDownloadListener, fVar != com.ss.android.socialbase.downloader.constants.f.f69187b), fVar.ordinal(), z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iDownloadListener, fVar, Boolean.valueOf(z)}) == null) || this.f69575b == null) {
            return;
        }
        try {
            this.f69575b.b(i2, i3, com.ss.android.socialbase.downloader.i.g.a(iDownloadListener, fVar != com.ss.android.socialbase.downloader.constants.f.f69187b), fVar.ordinal(), z);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.f69575b == null) {
                com.ss.android.socialbase.downloader.c.a.d(f69574a, "isServiceForeground, aidlService is null");
                return false;
            }
            com.ss.android.socialbase.downloader.c.a.c(f69574a, "aidlService.isServiceForeground");
            try {
                return this.f69575b.f();
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iDownloadListener, fVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f69575b == null) {
            return;
        }
        try {
            this.f69575b.a(i2, i3, com.ss.android.socialbase.downloader.i.g.a(iDownloadListener, fVar != com.ss.android.socialbase.downloader.constants.f.f69187b), fVar.ordinal(), z, z2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean a(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, downloadInfo)) == null) {
            if (this.f69575b == null) {
                return this.f69577d.a(downloadInfo);
            }
            try {
                this.f69575b.a(downloadInfo);
                return false;
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.o<IndependentProcessDownloadService> oVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, downloadTask) == null) || downloadTask == null || (oVar = this.f69576c) == null) {
            return;
        }
        oVar.c(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048601, this, i2, list) == null) {
            if (this.f69575b == null) {
                this.f69577d.b(i2, list);
                return;
            }
            try {
                this.f69575b.a(i2, list);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, Notification notification) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i2, notification) == null) {
            if (this.f69575b == null) {
                com.ss.android.socialbase.downloader.c.a.d(f69574a, "startForeground, aidlService is null");
                return;
            }
            String str = f69574a;
            com.ss.android.socialbase.downloader.c.a.c(str, "aidlService.startForeground, id = " + i2);
            try {
                this.f69575b.a(i2, notification);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (this.f69575b == null) {
                com.ss.android.socialbase.downloader.c.a.d(f69574a, "stopForeground, aidlService is null");
                return;
            }
            com.ss.android.socialbase.downloader.c.a.c(f69574a, "aidlService.stopForeground");
            try {
                this.f69575b.a(z2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.o<IndependentProcessDownloadService> oVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, downloadTask) == null) || downloadTask == null || (oVar = this.f69576c) == null) {
            return;
        }
        oVar.b(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048589, this, i2, list) == null) || this.f69575b == null) {
            return;
        }
        try {
            this.f69575b.b(i2, list);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bVar) == null) {
            if (this.f69575b == null) {
                this.f69577d.a(bVar);
                return;
            }
            try {
                this.f69575b.a(bVar);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, int i3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)}) == null) {
            if (this.f69575b == null) {
                this.f69577d.a(i2, i3, j);
                return;
            }
            try {
                this.f69575b.a(i2, i3, j);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, int i3, int i4, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j)}) == null) {
            if (this.f69575b == null) {
                this.f69577d.a(i2, i3, i4, j);
                return;
            }
            try {
                this.f69575b.a(i2, i3, i4, j);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) {
            if (this.f69575b == null) {
                this.f69577d.a(i2, i3, i4, i5);
                return;
            }
            try {
                this.f69575b.a(i2, i3, i4, i5);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(ak akVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, akVar) == null) || this.f69575b == null) {
            return;
        }
        try {
            this.f69575b.a(com.ss.android.socialbase.downloader.i.g.a(akVar));
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) || this.f69575b == null) {
            return;
        }
        try {
            this.f69575b.a(i2, i3);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, z zVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048588, this, i2, zVar) == null) || this.f69575b == null) {
            return;
        }
        try {
            this.f69575b.a(i2, com.ss.android.socialbase.downloader.i.g.a(zVar));
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.n
    public void a(IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, iBinder) == null) {
            this.f69575b = i.a.a(iBinder);
            if (com.ss.android.socialbase.downloader.i.f.a()) {
                a(new ak(this) { // from class: com.ss.android.socialbase.downloader.impls.o.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ o f69578a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f69578a = this;
                    }

                    @Override // com.ss.android.socialbase.downloader.depend.ak
                    public void a(int i2, int i3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeII(1048576, this, i2, i3) == null) {
                            if (i3 != 1) {
                                if (i3 == 2) {
                                    Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).cancel(i2);
                                    return;
                                }
                                return;
                            }
                            Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).pause(i2);
                            List<com.ss.android.socialbase.downloader.model.b> i4 = l.a(false).i(i2);
                            if (i4 != null) {
                                l.a(true).a(i2, com.ss.android.socialbase.downloader.i.f.a(i4));
                            }
                        }
                    }
                });
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) || this.f69575b == null) {
            return;
        }
        try {
            this.f69575b.a(i2, j);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
