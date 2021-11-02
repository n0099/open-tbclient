package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
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
import com.ss.android.socialbase.downloader.depend.ae;
import com.ss.android.socialbase.downloader.depend.aj;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class m extends i.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final String f69568a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.downloader.m f69569b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-292378936, "Lcom/ss/android/socialbase/downloader/impls/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-292378936, "Lcom/ss/android/socialbase/downloader/impls/m;");
                return;
            }
        }
        f69568a = m.class.getSimpleName();
    }

    public m() {
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
        this.f69569b = new p(true);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(com.ss.android.socialbase.downloader.model.a aVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.b(com.ss.android.socialbase.downloader.i.g.a(aVar));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean b(int i2) throws RemoteException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) {
            com.ss.android.socialbase.downloader.downloader.m mVar = this.f69569b;
            if (mVar == null) {
                return false;
            }
            return mVar.b(i2);
        }
        return invokeI.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void c(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048607, this, i2) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.c(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void d(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048611, this, i2) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.d(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public long e(int i2) throws RemoteException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048614, this, i2)) == null) {
            com.ss.android.socialbase.downloader.downloader.m mVar = this.f69569b;
            if (mVar == null) {
                return 0L;
            }
            return mVar.e(i2);
        }
        return invokeI.longValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public int f(int i2) throws RemoteException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048617, this, i2)) == null) {
            com.ss.android.socialbase.downloader.downloader.m mVar = this.f69569b;
            if (mVar == null) {
                return 0;
            }
            return mVar.f(i2);
        }
        return invokeI.intValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean g(int i2) throws RemoteException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048619, this, i2)) == null) {
            com.ss.android.socialbase.downloader.downloader.m mVar = this.f69569b;
            if (mVar == null) {
                return false;
            }
            return mVar.g(i2);
        }
        return invokeI.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo h(int i2) throws RemoteException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048620, this, i2)) == null) {
            com.ss.android.socialbase.downloader.downloader.m mVar = this.f69569b;
            if (mVar == null) {
                return null;
            }
            return mVar.h(i2);
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<com.ss.android.socialbase.downloader.model.b> i(int i2) throws RemoteException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048621, this, i2)) == null) {
            com.ss.android.socialbase.downloader.downloader.m mVar = this.f69569b;
            if (mVar == null) {
                return null;
            }
            return mVar.i(i2);
        }
        return (List) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void j(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048622, this, i2) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.j(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean k(int i2) throws RemoteException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i2)) == null) {
            com.ss.android.socialbase.downloader.downloader.m mVar = this.f69569b;
            if (mVar == null) {
                return false;
            }
            return mVar.l(i2);
        }
        return invokeI.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void l(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048624, this, i2) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.k(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public int m(int i2) throws RemoteException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048625, this, i2)) == null) ? com.ss.android.socialbase.downloader.downloader.d.a().b(i2) : invokeI.intValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean n(int i2) throws RemoteException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048626, this, i2)) == null) {
            com.ss.android.socialbase.downloader.downloader.m mVar = this.f69569b;
            if (mVar == null) {
                return false;
            }
            return mVar.n(i2);
        }
        return invokeI.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void o(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048627, this, i2) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.o(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean p(int i2) throws RemoteException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048628, this, i2)) == null) {
            com.ss.android.socialbase.downloader.downloader.m mVar = this.f69569b;
            if (mVar == null) {
                return false;
            }
            return mVar.p(i2);
        }
        return invokeI.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public y q(int i2) throws RemoteException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048629, this, i2)) == null) {
            com.ss.android.socialbase.downloader.downloader.m mVar = this.f69569b;
            if (mVar == null) {
                return null;
            }
            return com.ss.android.socialbase.downloader.i.g.a(mVar.q(i2));
        }
        return (y) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public ae r(int i2) throws RemoteException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048630, this, i2)) == null) {
            com.ss.android.socialbase.downloader.downloader.m mVar = this.f69569b;
            if (mVar == null) {
                return null;
            }
            return com.ss.android.socialbase.downloader.i.g.a(mVar.r(i2));
        }
        return (ae) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public com.ss.android.socialbase.downloader.depend.g s(int i2) throws RemoteException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048631, this, i2)) == null) {
            com.ss.android.socialbase.downloader.downloader.m mVar = this.f69569b;
            if (mVar == null) {
                return null;
            }
            return com.ss.android.socialbase.downloader.i.g.a(mVar.s(i2));
        }
        return (com.ss.android.socialbase.downloader.depend.g) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.a(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public DownloadInfo b(String str, String str2) throws RemoteException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, str, str2)) == null) {
            com.ss.android.socialbase.downloader.downloader.m mVar = this.f69569b;
            if (mVar == null) {
                return null;
            }
            return mVar.b(str, str2);
        }
        return (DownloadInfo) invokeLL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<DownloadInfo> c(String str) throws RemoteException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            com.ss.android.socialbase.downloader.downloader.m mVar = this.f69569b;
            if (mVar == null) {
                return null;
            }
            return mVar.c(str);
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<DownloadInfo> d(String str) throws RemoteException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            com.ss.android.socialbase.downloader.downloader.m mVar = this.f69569b;
            if (mVar == null) {
                return null;
            }
            return mVar.e(str);
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<DownloadInfo> e(String str) throws RemoteException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, str)) == null) {
            com.ss.android.socialbase.downloader.downloader.m mVar = this.f69569b;
            if (mVar == null) {
                return null;
            }
            return mVar.d(str);
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean f() throws RemoteException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            com.ss.android.socialbase.downloader.downloader.m mVar = this.f69569b;
            if (mVar == null) {
                return false;
            }
            return mVar.b();
        }
        return invokeV.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i2, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.a(i2, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<DownloadInfo> b(String str) throws RemoteException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            com.ss.android.socialbase.downloader.downloader.m mVar = this.f69569b;
            if (mVar == null) {
                return null;
            }
            return mVar.b(str);
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void c(int i2, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.b(i2, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean d() throws RemoteException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            com.ss.android.socialbase.downloader.downloader.m mVar = this.f69569b;
            if (mVar == null) {
                return false;
            }
            return mVar.e();
        }
        return invokeV.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void e() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.f();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.a();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<DownloadInfo> b() throws RemoteException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            com.ss.android.socialbase.downloader.downloader.m mVar = this.f69569b;
            if (mVar == null) {
                return null;
            }
            return mVar.d();
        }
        return (List) invokeV.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean c() throws RemoteException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            com.ss.android.socialbase.downloader.downloader.m mVar = this.f69569b;
            if (mVar == null) {
                return false;
            }
            return mVar.c();
        }
        return invokeV.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void d(int i2, boolean z) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            com.ss.android.socialbase.downloader.downloader.d.a().b(i2, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public List<DownloadInfo> a(String str) throws RemoteException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            com.ss.android.socialbase.downloader.downloader.m mVar = this.f69569b;
            if (mVar == null) {
                return null;
            }
            return mVar.a(str);
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void b(List<String> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, list) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.b(list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public int a(String str, String str2) throws RemoteException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            com.ss.android.socialbase.downloader.downloader.m mVar = this.f69569b;
            if (mVar == null) {
                return 0;
            }
            return mVar.a(str, str2);
        }
        return invokeLL.intValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void b(int i2, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.b(i2, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(List<String> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, list) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.a(list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void b(int i2, int i3, com.ss.android.socialbase.downloader.depend.i iVar, int i4, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iVar, Integer.valueOf(i4), Boolean.valueOf(z)}) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.a(i2, i3, com.ss.android.socialbase.downloader.i.g.a(iVar), com.ss.android.socialbase.downloader.i.f.e(i4), z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i2, int i3, com.ss.android.socialbase.downloader.depend.i iVar, int i4, boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iVar, Integer.valueOf(i4), Boolean.valueOf(z)}) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.b(i2, i3, com.ss.android.socialbase.downloader.i.g.a(iVar), com.ss.android.socialbase.downloader.i.f.e(i4), z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean b(DownloadInfo downloadInfo) throws RemoteException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, downloadInfo)) == null) {
            com.ss.android.socialbase.downloader.downloader.m mVar = this.f69569b;
            if (mVar == null) {
                return false;
            }
            return mVar.c(downloadInfo);
        }
        return invokeL.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i2, int i3, com.ss.android.socialbase.downloader.depend.i iVar, int i4, boolean z, boolean z2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iVar, Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.a(i2, i3, com.ss.android.socialbase.downloader.i.g.a(iVar), com.ss.android.socialbase.downloader.i.f.e(i4), z, z2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048601, this, i2, list) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.a(i2, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public boolean a(DownloadInfo downloadInfo) throws RemoteException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, downloadInfo)) == null) {
            com.ss.android.socialbase.downloader.downloader.m mVar = this.f69569b;
            if (mVar == null) {
                return false;
            }
            return mVar.a(downloadInfo);
        }
        return invokeL.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i2, Notification notification) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048587, this, i2, notification) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.a(i2, notification);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(boolean z) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.a(true, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i2, long j) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.a(i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(com.ss.android.socialbase.downloader.model.b bVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.a(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i2, int i3, long j) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)}) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.a(i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i2, int i3, int i4, long j) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j)}) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.a(i2, i3, i4, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i2, int i3, int i4, int i5) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.a(i2, i3, i4, i5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048589, this, i2, list) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.b(i2, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(aj ajVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, ajVar) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.a(com.ss.android.socialbase.downloader.i.g.a(ajVar));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i2, int i3) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.a(i2, i3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.i
    public void a(int i2, y yVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048588, this, i2, yVar) == null) || (mVar = this.f69569b) == null) {
            return;
        }
        mVar.a(i2, com.ss.android.socialbase.downloader.i.g.a(yVar));
    }
}
