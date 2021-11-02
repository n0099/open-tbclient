package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;
/* loaded from: classes2.dex */
public class p implements com.ss.android.socialbase.downloader.downloader.m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a f69579a;

    /* renamed from: b  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.downloader.j f69580b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.downloader.o f69581c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f69582d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public p() {
        this(false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (aVar = this.f69579a) == null) {
            return;
        }
        aVar.e(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) {
            a aVar = this.f69579a;
            if (aVar != null) {
                return aVar.n(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void c(int i2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048608, this, i2) == null) || (aVar = this.f69579a) == null) {
            return;
        }
        aVar.f(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void d(int i2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048614, this, i2) == null) || (aVar = this.f69579a) == null) {
            return;
        }
        aVar.g(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public long e(int i2) {
        InterceptResult invokeI;
        DownloadInfo b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i2)) == null) {
            com.ss.android.socialbase.downloader.downloader.j jVar = this.f69580b;
            if (jVar == null || (b2 = jVar.b(i2)) == null) {
                return 0L;
            }
            int chunkCount = b2.getChunkCount();
            if (chunkCount <= 1) {
                return b2.getCurBytes();
            }
            List<com.ss.android.socialbase.downloader.model.b> c2 = this.f69580b.c(i2);
            if (c2 == null || c2.size() != chunkCount) {
                return 0L;
            }
            return com.ss.android.socialbase.downloader.i.f.b(c2);
        }
        return invokeI.longValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public int f(int i2) {
        InterceptResult invokeI;
        DownloadInfo d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048619, this, i2)) == null) {
            a aVar = this.f69579a;
            if (aVar == null || (d2 = aVar.d(i2)) == null) {
                return 0;
            }
            return d2.getStatus();
        }
        return invokeI.intValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048622, this, i2)) == null) {
            a aVar = this.f69579a;
            if (aVar != null) {
                return aVar.a(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public DownloadInfo h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i2)) == null) {
            a aVar = this.f69579a;
            if (aVar != null) {
                return aVar.d(i2);
            }
            return null;
        }
        return (DownloadInfo) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<com.ss.android.socialbase.downloader.model.b> i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048624, this, i2)) == null) ? this.f69580b.c(i2) : (List) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void j(int i2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048625, this, i2) == null) || (aVar = this.f69579a) == null) {
            return;
        }
        aVar.m(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i2) == null) {
            com.ss.android.socialbase.downloader.c.a.a(i2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048627, this, i2)) == null) {
            a aVar = this.f69579a;
            if (aVar != null) {
                return aVar.k(i2);
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public int m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048628, this, i2)) == null) ? com.ss.android.socialbase.downloader.downloader.d.a().a(i2) : invokeI.intValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048629, this, i2)) == null) ? this.f69580b.e(i2) : invokeI.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
            this.f69580b.d(i2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048631, this, i2)) == null) ? this.f69580b.f(i2) : invokeI.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public z q(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048632, this, i2)) == null) {
            a aVar = this.f69579a;
            if (aVar != null) {
                return aVar.i(i2);
            }
            return null;
        }
        return (z) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public af r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048633, this, i2)) == null) {
            a aVar = this.f69579a;
            af h2 = aVar != null ? aVar.h(i2) : null;
            return h2 == null ? com.ss.android.socialbase.downloader.downloader.c.J() : h2;
        }
        return (af) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public IDownloadFileUriProvider s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048634, this, i2)) == null) {
            a aVar = this.f69579a;
            if (aVar != null) {
                return aVar.j(i2);
            }
            return null;
        }
        return (IDownloadFileUriProvider) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void startService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
        }
    }

    public p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f69579a = com.ss.android.socialbase.downloader.downloader.c.C();
        this.f69580b = com.ss.android.socialbase.downloader.downloader.c.x();
        if (!z) {
            this.f69581c = com.ss.android.socialbase.downloader.downloader.c.y();
        } else {
            this.f69581c = com.ss.android.socialbase.downloader.downloader.c.z();
        }
        this.f69582d = com.ss.android.socialbase.downloader.g.a.c().b("service_alive", false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (aVar = this.f69579a) == null) {
            return;
        }
        aVar.a(i2, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            com.ss.android.socialbase.downloader.downloader.j jVar = this.f69580b;
            if (jVar != null) {
                return jVar.b(str);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            com.ss.android.socialbase.downloader.downloader.j jVar = this.f69580b;
            if (jVar != null) {
                return jVar.c(str);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            com.ss.android.socialbase.downloader.downloader.j jVar = this.f69580b;
            if (jVar != null) {
                return jVar.b();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean g() {
        InterceptResult invokeV;
        com.ss.android.socialbase.downloader.downloader.o oVar;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.f69582d && (oVar = this.f69581c) != null && oVar.a() : invokeV.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.f69580b.c();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f69579a) == null) {
            return;
        }
        aVar.b();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(List<String> list) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, list) == null) || (aVar = this.f69579a) == null) {
            return;
        }
        aVar.b(list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? com.ss.android.socialbase.downloader.downloader.c.O() : invokeV.booleanValue;
    }

    public void d(int i2, boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (aVar = this.f69579a) == null) {
            return;
        }
        aVar.c(i2, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void c(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            com.ss.android.socialbase.downloader.downloader.d.a().a(i2, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(List<String> list) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, list) == null) || (aVar = this.f69579a) == null) {
            return;
        }
        aVar.a(list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public DownloadInfo b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, str, str2)) == null) ? h(com.ss.android.socialbase.downloader.downloader.c.a(str, str2)) : (DownloadInfo) invokeLL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean c(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, downloadInfo)) == null) ? this.f69580b.a(downloadInfo) : invokeL.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) {
            com.ss.android.socialbase.downloader.downloader.j jVar = this.f69580b;
            if (jVar != null) {
                return jVar.d(str);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, str)) == null) {
            a aVar = this.f69579a;
            if (aVar != null) {
                return aVar.b(str);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public List<DownloadInfo> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            a aVar = this.f69579a;
            if (aVar != null) {
                return aVar.a(str);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(int i2, boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (aVar = this.f69579a) == null) {
            return;
        }
        aVar.b(i2, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.f69580b.d() : invokeV.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public int a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) ? com.ss.android.socialbase.downloader.downloader.c.a(str, str2) : invokeLL.intValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iDownloadListener, fVar, Boolean.valueOf(z)}) == null) || (aVar = this.f69579a) == null) {
            return;
        }
        aVar.a(i2, i3, iDownloadListener, fVar, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iDownloadListener, fVar, Boolean.valueOf(z)}) == null) || (aVar = this.f69579a) == null) {
            return;
        }
        aVar.b(i2, i3, iDownloadListener, fVar, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            com.ss.android.socialbase.downloader.downloader.o oVar = this.f69581c;
            if (oVar != null) {
                return oVar.b();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z, boolean z2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), iDownloadListener, fVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (aVar = this.f69579a) == null) {
            return;
        }
        aVar.a(i2, i3, iDownloadListener, fVar, z, z2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.o oVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, downloadTask) == null) || (oVar = this.f69581c) == null) {
            return;
        }
        oVar.c(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public boolean a(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, downloadInfo)) == null) {
            if (downloadInfo == null) {
                return false;
            }
            boolean a2 = com.ss.android.socialbase.downloader.i.f.a(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName());
            if (a2) {
                if (com.ss.android.socialbase.downloader.i.a.a(33554432)) {
                    b(downloadInfo.getId(), true);
                } else {
                    d(downloadInfo.getId(), true);
                }
            }
            return a2;
        }
        return invokeL.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, downloadInfo) == null) {
            this.f69580b.b(downloadInfo);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048600, this, i2, list) == null) {
            this.f69580b.b(i2, list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, Notification notification) {
        com.ss.android.socialbase.downloader.downloader.o oVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048587, this, i2, notification) == null) || (oVar = this.f69581c) == null) {
            return;
        }
        oVar.a(i2, notification);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(boolean z, boolean z2) {
        com.ss.android.socialbase.downloader.downloader.o oVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (oVar = this.f69581c) == null) {
            return;
        }
        oVar.a(z2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, downloadTask) == null) {
            com.ss.android.socialbase.downloader.downloader.o oVar = this.f69581c;
            if (oVar != null) {
                oVar.b(downloadTask);
            } else if (downloadTask != null) {
                com.ss.android.socialbase.downloader.d.a.a(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "downloadServiceHandler is null"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i2, list) == null) {
            this.f69580b.a(i2, list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bVar) == null) {
            this.f69580b.a(bVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, int i3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)}) == null) {
            this.f69580b.a(i2, i3, j);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, int i3, int i4, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j)}) == null) {
            this.f69580b.a(i2, i3, i4, j);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) {
            this.f69580b.a(i2, i3, i4, i5);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(ak akVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, akVar) == null) {
            com.ss.android.socialbase.downloader.downloader.c.a(akVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) || com.ss.android.socialbase.downloader.downloader.c.e() == null) {
            return;
        }
        for (ak akVar : com.ss.android.socialbase.downloader.downloader.c.e()) {
            if (akVar != null) {
                akVar.a(i3, i2);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, z zVar) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048588, this, i2, zVar) == null) || (aVar = this.f69579a) == null) {
            return;
        }
        aVar.a(i2, zVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.m
    public void a(int i2, long j) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) || (aVar = this.f69579a) == null) {
            return;
        }
        aVar.b(i2, j);
    }
}
