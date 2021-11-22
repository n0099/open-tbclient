package com.ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
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
import com.ss.android.socialbase.downloader.depend.ac;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f70184a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public volatile SparseArray<Boolean> f70185b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f70186c;

    /* renamed from: d  reason: collision with root package name */
    public volatile List<ac> f70187d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(326251539, "Lcom/ss/android/socialbase/downloader/downloader/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(326251539, "Lcom/ss/android/socialbase/downloader/downloader/d;");
        }
    }

    public d() {
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
        this.f70185b = new SparseArray<>();
        this.f70186c = new Handler(Looper.getMainLooper());
        this.f70187d = new ArrayList();
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f70184a == null) {
                synchronized (d.class) {
                    f70184a = new d();
                }
            }
            return f70184a;
        }
        return (d) invokeV.objValue;
    }

    public void b(ac acVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, acVar) == null) || acVar == null) {
            return;
        }
        synchronized (this.f70187d) {
            if (this.f70187d.contains(acVar)) {
                this.f70187d.remove(acVar);
            }
        }
    }

    public m c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            boolean z = true;
            return com.ss.android.socialbase.downloader.impls.l.a((a(i2) != 1 || com.ss.android.socialbase.downloader.i.f.c()) ? false : false);
        }
        return (m) invokeI.objValue;
    }

    public void d(int i2) {
        m c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048603, this, i2) == null) || (c2 = c(i2)) == null) {
            return;
        }
        c2.a(i2);
    }

    public boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i2)) == null) {
            m c2 = c(i2);
            if (c2 == null) {
                return false;
            }
            return c2.b(i2);
        }
        return invokeI.booleanValue;
    }

    public void f(int i2) {
        m c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048609, this, i2) == null) || (c2 = c(i2)) == null) {
            return;
        }
        c2.c(i2);
    }

    public void g(int i2) {
        m c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048611, this, i2) == null) || (c2 = c(i2)) == null) {
            return;
        }
        c2.d(i2);
    }

    public long h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i2)) == null) {
            m c2 = c(i2);
            if (c2 == null) {
                return 0L;
            }
            return c2.e(i2);
        }
        return invokeI.longValue;
    }

    public int i(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i2)) == null) {
            m c2 = c(i2);
            if (c2 == null) {
                return 0;
            }
            return c2.f(i2);
        }
        return invokeI.intValue;
    }

    public boolean j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048614, this, i2)) == null) {
            m c2 = c(i2);
            if (c2 == null) {
                return false;
            }
            return c2.g(i2);
        }
        return invokeI.booleanValue;
    }

    public DownloadInfo k(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i2)) == null) {
            m c2 = c(i2);
            if (c2 == null) {
                return null;
            }
            return c2.h(i2);
        }
        return (DownloadInfo) invokeI.objValue;
    }

    public z l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i2)) == null) {
            m c2 = c(i2);
            if (c2 == null) {
                return null;
            }
            return c2.q(i2);
        }
        return (z) invokeI.objValue;
    }

    public af m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048617, this, i2)) == null) {
            m c2 = c(i2);
            if (c2 == null) {
                return null;
            }
            return c2.r(i2);
        }
        return (af) invokeI.objValue;
    }

    public void n(int i2) {
        m c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048618, this, i2) == null) || (c2 = c(i2)) == null) {
            return;
        }
        c2.j(i2);
    }

    public boolean o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048619, this, i2)) == null) {
            m c2 = c(i2);
            if (c2 == null) {
                return false;
            }
            return c2.l(i2);
        }
        return invokeI.booleanValue;
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i2) == null) {
            m a2 = com.ss.android.socialbase.downloader.impls.l.a(false);
            if (a2 != null) {
                a2.k(i2);
            }
            m a3 = com.ss.android.socialbase.downloader.impls.l.a(true);
            if (a3 != null) {
                a3.k(i2);
            }
        }
    }

    public void q(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048621, this, i2) == null) || i2 == 0) {
            return;
        }
        b(i2, true);
        m a2 = com.ss.android.socialbase.downloader.impls.l.a(true);
        if (a2 == null) {
            return;
        }
        a2.startService();
    }

    public IDownloadFileUriProvider r(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048622, this, i2)) == null) {
            m c2 = c(i2);
            if (c2 == null) {
                return null;
            }
            return c2.s(i2);
        }
        return (IDownloadFileUriProvider) invokeI.objValue;
    }

    public void c(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (com.ss.android.socialbase.downloader.i.f.a()) {
                if (com.ss.android.socialbase.downloader.i.a.a(8388608)) {
                    m a2 = com.ss.android.socialbase.downloader.impls.l.a(true);
                    if (a2 != null) {
                        a2.a(i2, z);
                    }
                    m a3 = com.ss.android.socialbase.downloader.impls.l.a(false);
                    if (a3 != null) {
                        a3.a(i2, z);
                        return;
                    }
                    return;
                }
                m a4 = com.ss.android.socialbase.downloader.impls.l.a(false);
                if (a4 != null) {
                    a4.a(i2, z);
                }
                m a5 = com.ss.android.socialbase.downloader.impls.l.a(true);
                if (a5 != null) {
                    a5.a(i2, z);
                    return;
                }
                return;
            }
            m c2 = c(i2);
            if (c2 != null) {
                c2.a(i2, z);
            }
            com.ss.android.socialbase.downloader.impls.l.a(true).a(2, i2);
        }
    }

    public void d(int i2, boolean z) {
        m c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || (c2 = c(i2)) == null) {
            return;
        }
        c2.b(i2, z);
    }

    public List<DownloadInfo> e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
            m a2 = com.ss.android.socialbase.downloader.impls.l.a(false);
            List<DownloadInfo> e2 = a2 != null ? a2.e(str) : null;
            m a3 = com.ss.android.socialbase.downloader.impls.l.a(true);
            return a(e2, a3 != null ? a3.e(str) : null, sparseArray);
        }
        return (List) invokeL.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            m a2 = com.ss.android.socialbase.downloader.impls.l.a(false);
            if (a2 != null) {
                return a2.e();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (this.f70187d) {
                for (ac acVar : this.f70187d) {
                    if (acVar != null) {
                        acVar.a();
                    }
                }
            }
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? c.O() : invokeV.booleanValue;
    }

    public void a(ac acVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, acVar) == null) || acVar == null) {
            return;
        }
        if (com.ss.android.socialbase.downloader.i.f.c()) {
            acVar.a();
            return;
        }
        if (com.ss.android.socialbase.downloader.impls.l.a(true).g()) {
            acVar.a();
        }
        synchronized (this.f70187d) {
            if (!this.f70187d.contains(acVar)) {
                this.f70187d.add(acVar);
            }
        }
    }

    public List<DownloadInfo> d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
            m a2 = com.ss.android.socialbase.downloader.impls.l.a(false);
            List<DownloadInfo> d2 = a2 != null ? a2.d(str) : null;
            m a3 = com.ss.android.socialbase.downloader.impls.l.a(true);
            return a(d2, a3 != null ? a3.d(str) : null, sparseArray);
        }
        return (List) invokeL.objValue;
    }

    public List<DownloadInfo> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
            m a2 = com.ss.android.socialbase.downloader.impls.l.a(false);
            List<DownloadInfo> d2 = a2 != null ? a2.d() : null;
            m a3 = com.ss.android.socialbase.downloader.impls.l.a(true);
            return a(d2, a3 != null ? a3.d() : null, sparseArray);
        }
        return (List) invokeV.objValue;
    }

    public synchronized void b(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                this.f70185b.put(i2, z ? Boolean.TRUE : Boolean.FALSE);
            }
        }
    }

    public synchronized int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            synchronized (this) {
                if (this.f70185b.get(i2) == null) {
                    return -1;
                }
                return this.f70185b.get(i2).booleanValue() ? 1 : 0;
            }
        }
        return invokeI.intValue;
    }

    public void a(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            b(i2, z);
            if (c.S() && !com.ss.android.socialbase.downloader.i.f.c() && com.ss.android.socialbase.downloader.impls.l.a(true).g()) {
                com.ss.android.socialbase.downloader.impls.l.a(true).c(i2, z);
            }
            if (c.c() || com.ss.android.socialbase.downloader.i.f.c() || com.ss.android.socialbase.downloader.i.f.a()) {
                return;
            }
            try {
                Intent intent = new Intent(c.N(), DownloadHandleService.class);
                intent.setAction("com.ss.android.downloader.action.PROCESS_NOTIFY");
                intent.putExtra("extra_download_id", i2);
                c.N().startService(intent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            m a2 = com.ss.android.socialbase.downloader.impls.l.a(false);
            if (a2 != null) {
                a2.a();
            }
            m a3 = com.ss.android.socialbase.downloader.impls.l.a(true);
            if (a3 != null) {
                a3.a();
            }
        }
    }

    private m b(DownloadTask downloadTask) {
        InterceptResult invokeL;
        DownloadInfo downloadInfo;
        List<com.ss.android.socialbase.downloader.model.b> i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, downloadTask)) == null) {
            if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
                return null;
            }
            downloadInfo.isNeedIndependentProcess();
            boolean z = (com.ss.android.socialbase.downloader.i.f.c() || !com.ss.android.socialbase.downloader.i.f.a()) ? true : true;
            int a2 = a(downloadInfo.getId());
            if (a2 >= 0 && a2 != z) {
                try {
                    if (a2 == 1) {
                        if (com.ss.android.socialbase.downloader.i.f.a()) {
                            com.ss.android.socialbase.downloader.impls.l.a(true).a(downloadInfo.getId());
                            DownloadInfo h2 = com.ss.android.socialbase.downloader.impls.l.a(true).h(downloadInfo.getId());
                            if (h2 != null) {
                                com.ss.android.socialbase.downloader.impls.l.a(false).b(h2);
                            }
                            if (h2.getChunkCount() > 1 && (i2 = com.ss.android.socialbase.downloader.impls.l.a(true).i(downloadInfo.getId())) != null) {
                                com.ss.android.socialbase.downloader.impls.l.a(false).a(downloadInfo.getId(), com.ss.android.socialbase.downloader.i.f.a(i2));
                            }
                        }
                    } else if (com.ss.android.socialbase.downloader.i.f.a()) {
                        com.ss.android.socialbase.downloader.impls.l.a(false).a(downloadInfo.getId());
                        List<com.ss.android.socialbase.downloader.model.b> i3 = com.ss.android.socialbase.downloader.impls.l.a(false).i(downloadInfo.getId());
                        if (i3 != null) {
                            com.ss.android.socialbase.downloader.impls.l.a(true).a(downloadInfo.getId(), com.ss.android.socialbase.downloader.i.f.a(i3));
                        }
                    } else {
                        downloadTask.setNeedDelayForCacheSync(true);
                        com.ss.android.socialbase.downloader.impls.l.a(true).a(1, downloadInfo.getId());
                    }
                } catch (Throwable unused) {
                }
            }
            a(downloadInfo.getId(), z);
            return com.ss.android.socialbase.downloader.impls.l.a(z);
        }
        return (m) invokeL.objValue;
    }

    public List<DownloadInfo> c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
            m a2 = com.ss.android.socialbase.downloader.impls.l.a(false);
            List<DownloadInfo> c2 = a2 != null ? a2.c(str) : null;
            m a3 = com.ss.android.socialbase.downloader.impls.l.a(true);
            return a(c2, a3 != null ? a3.c(str) : null, sparseArray);
        }
        return (List) invokeL.objValue;
    }

    public int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            if (c.S()) {
                if (!com.ss.android.socialbase.downloader.i.f.c() && com.ss.android.socialbase.downloader.impls.l.a(true).g()) {
                    return com.ss.android.socialbase.downloader.impls.l.a(true).m(i2);
                }
                return b(i2);
            }
            return -1;
        }
        return invokeI.intValue;
    }

    public int a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) ? c.a(str, str2) : invokeLL.intValue;
    }

    public List<DownloadInfo> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            List<DownloadInfo> a2 = com.ss.android.socialbase.downloader.impls.l.a(false).a(str);
            List<DownloadInfo> a3 = com.ss.android.socialbase.downloader.impls.l.a(true).a(str);
            if (a2 == null && a3 == null) {
                return null;
            }
            if (a2 == null || a3 == null) {
                return a2 != null ? a2 : a3;
            }
            ArrayList arrayList = new ArrayList(a2);
            arrayList.addAll(a3);
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void a(int i2, z zVar) {
        m c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048582, this, i2, zVar) == null) || (c2 = c(i2)) == null) {
            return;
        }
        c2.a(i2, zVar);
    }

    private List<DownloadInfo> a(List<DownloadInfo> list, List<DownloadInfo> list2, SparseArray<DownloadInfo> sparseArray) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, this, list, list2, sparseArray)) == null) {
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (DownloadInfo downloadInfo : list) {
                    if (downloadInfo != null && sparseArray.get(downloadInfo.getId()) == null) {
                        sparseArray.put(downloadInfo.getId(), downloadInfo);
                    }
                }
            }
            if (list2 != null) {
                for (DownloadInfo downloadInfo2 : list2) {
                    if (downloadInfo2 != null && sparseArray.get(downloadInfo2.getId()) == null) {
                        sparseArray.put(downloadInfo2.getId(), downloadInfo2);
                    }
                }
            }
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                arrayList.add(sparseArray.get(sparseArray.keyAt(i2)));
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }

    public DownloadInfo b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, str, str2)) == null) {
            int a2 = a(str, str2);
            m c2 = c(a2);
            if (c2 == null) {
                return null;
            }
            return c2.h(a2);
        }
        return (DownloadInfo) invokeLL.objValue;
    }

    public List<DownloadInfo> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
            m a2 = com.ss.android.socialbase.downloader.impls.l.a(false);
            List<DownloadInfo> b2 = a2 != null ? a2.b(str) : null;
            m a3 = com.ss.android.socialbase.downloader.impls.l.a(true);
            return a(b2, a3 != null ? a3.b(str) : null, sparseArray);
        }
        return (List) invokeL.objValue;
    }

    public void a(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            m a2 = com.ss.android.socialbase.downloader.impls.l.a(false);
            if (a2 != null) {
                a2.a(list);
            }
            m a3 = com.ss.android.socialbase.downloader.impls.l.a(true);
            if (a3 != null) {
                a3.a(list);
            }
        }
    }

    public void b(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, list) == null) {
            m a2 = com.ss.android.socialbase.downloader.impls.l.a(false);
            if (a2 != null) {
                a2.b(list);
            }
            m a3 = com.ss.android.socialbase.downloader.impls.l.a(true);
            if (a3 != null) {
                a3.b(list);
            }
        }
    }

    public void a(int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        m c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), iDownloadListener, fVar, Boolean.valueOf(z)}) == null) || (c2 = c(i2)) == null) {
            return;
        }
        c2.b(i2, iDownloadListener == null ? 0 : iDownloadListener.hashCode(), iDownloadListener, fVar, z);
    }

    public void b(int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        m c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i2), iDownloadListener, fVar, Boolean.valueOf(z)}) == null) || (c2 = c(i2)) == null) {
            return;
        }
        c2.a(i2, iDownloadListener.hashCode(), iDownloadListener, fVar, z);
    }

    public void a(int i2, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z, boolean z2) {
        m c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), iDownloadListener, fVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || (c2 = c(i2)) == null) {
            return;
        }
        c2.a(i2, iDownloadListener.hashCode(), iDownloadListener, fVar, z, z2);
    }

    public void b(com.ss.android.socialbase.downloader.depend.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, kVar) == null) {
            c.b(kVar);
        }
    }

    public boolean a(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        m c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, downloadInfo)) == null) {
            if (downloadInfo == null || (c2 = c(downloadInfo.getId())) == null) {
                return false;
            }
            return c2.a(downloadInfo);
        }
        return invokeL.booleanValue;
    }

    public void a(DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, downloadTask) == null) {
            m b2 = b(downloadTask);
            if (b2 == null) {
                if (downloadTask != null) {
                    com.ss.android.socialbase.downloader.d.a.a(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "tryDownload but getDownloadHandler failed"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
                }
            } else if (downloadTask.isNeedDelayForCacheSync()) {
                this.f70186c.postDelayed(new Runnable(this, b2, downloadTask) { // from class: com.ss.android.socialbase.downloader.downloader.d.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ m f70188a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ DownloadTask f70189b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ d f70190c;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, b2, downloadTask};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f70190c = this;
                        this.f70188a = b2;
                        this.f70189b = downloadTask;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.f70188a.a(this.f70189b);
                        }
                    }
                }, 500L);
            } else {
                b2.a(downloadTask);
            }
        }
    }

    public void a(com.ss.android.socialbase.downloader.depend.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, kVar) == null) {
            c.a(kVar);
        }
    }

    public void a(int i2, long j) {
        m c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) || (c2 = c(i2)) == null) {
            return;
        }
        c2.a(i2, j);
    }
}
