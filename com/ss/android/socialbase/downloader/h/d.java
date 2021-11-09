package com.ss.android.socialbase.downloader.h;

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
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static ExecutorService f69415a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public volatile SparseArray<c> f69416b;

    /* renamed from: c  reason: collision with root package name */
    public int f69417c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(479400572, "Lcom/ss/android/socialbase/downloader/h/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(479400572, "Lcom/ss/android/socialbase/downloader/h/d;");
                return;
            }
        }
        f69415a = new ThreadPoolExecutor(2, 2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a("Download_OP_Thread"));
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
        this.f69417c = 0;
        this.f69416b = new SparseArray<>();
    }

    public static void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, runnable) == null) {
            f69415a.execute(runnable);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            try {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < this.f69416b.size(); i2++) {
                    int keyAt = this.f69416b.keyAt(i2);
                    if (!this.f69416b.get(keyAt).d()) {
                        arrayList.add(Integer.valueOf(keyAt));
                    }
                }
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    Integer num = (Integer) arrayList.get(i3);
                    if (num != null) {
                        this.f69416b.remove(num.intValue());
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            synchronized (d.class) {
                b();
                c cVar = this.f69416b.get(i2);
                if (cVar != null) {
                    cVar.a();
                    c(cVar);
                    this.f69416b.remove(i2);
                }
            }
        }
    }

    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            cVar.f();
            synchronized (d.class) {
                if (this.f69417c >= 500) {
                    b();
                    this.f69417c = 0;
                } else {
                    this.f69417c++;
                }
                this.f69416b.put(cVar.e(), cVar);
            }
            DownloadTask c2 = cVar.c();
            try {
                ExecutorService p = com.ss.android.socialbase.downloader.downloader.c.p();
                if (c2 != null && c2.getDownloadInfo() != null) {
                    if ("mime_type_plg".equals(c2.getDownloadInfo().getMimeType()) && com.ss.android.socialbase.downloader.g.a.c().a("divide_plugin", 1) == 1) {
                        c2.getDownloadInfo().safePutToDBJsonData("executor_group", 3);
                    }
                    int executorGroup = c2.getDownloadInfo().getExecutorGroup();
                    if (executorGroup == 3) {
                        p = com.ss.android.socialbase.downloader.downloader.c.n();
                    } else if (executorGroup == 4) {
                        p = com.ss.android.socialbase.downloader.downloader.c.o();
                    }
                }
                if (p != null) {
                    if (com.ss.android.socialbase.downloader.g.a.a(cVar.e()).b("pause_with_interrupt", false)) {
                        cVar.a(p.submit(cVar));
                        return;
                    } else {
                        p.execute(cVar);
                        return;
                    }
                }
                com.ss.android.socialbase.downloader.d.a.a(c2.getMonitorDepend(), c2.getDownloadInfo(), new BaseException(1003, "execute failed cpu thread executor service is null"), c2.getDownloadInfo() != null ? c2.getDownloadInfo().getStatus() : 0);
            } catch (Exception e2) {
                if (c2 != null) {
                    com.ss.android.socialbase.downloader.d.a.a(c2.getMonitorDepend(), c2.getDownloadInfo(), new BaseException(1003, com.ss.android.socialbase.downloader.i.f.b(e2, "DownloadThreadPoolExecute")), c2.getDownloadInfo() != null ? c2.getDownloadInfo().getStatus() : 0);
                }
                e2.printStackTrace();
            } catch (OutOfMemoryError e3) {
                if (c2 != null) {
                    com.ss.android.socialbase.downloader.d.a.a(c2.getMonitorDepend(), c2.getDownloadInfo(), new BaseException(1003, "execute OOM"), c2.getDownloadInfo() != null ? c2.getDownloadInfo().getStatus() : 0);
                }
                e3.printStackTrace();
            }
        }
    }

    private void c(c cVar) {
        Future g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, cVar) == null) || cVar == null) {
            return;
        }
        try {
            ExecutorService p = com.ss.android.socialbase.downloader.downloader.c.p();
            DownloadTask c2 = cVar.c();
            if (c2 != null && c2.getDownloadInfo() != null) {
                int executorGroup = c2.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    p = com.ss.android.socialbase.downloader.downloader.c.n();
                } else if (executorGroup == 4) {
                    p = com.ss.android.socialbase.downloader.downloader.c.o();
                }
            }
            if (p == null || !(p instanceof ThreadPoolExecutor)) {
                return;
            }
            ((ThreadPoolExecutor) p).remove(cVar);
            if (!com.ss.android.socialbase.downloader.g.a.a(cVar.e()).b("pause_with_interrupt", false) || (g2 = cVar.g()) == null) {
                return;
            }
            g2.cancel(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) || cVar == null) {
            return;
        }
        synchronized (d.class) {
            try {
                if (com.ss.android.socialbase.downloader.i.a.a(524288)) {
                    int indexOfValue = this.f69416b.indexOfValue(cVar);
                    if (indexOfValue >= 0) {
                        this.f69416b.removeAt(indexOfValue);
                    }
                } else {
                    this.f69416b.remove(cVar.e());
                }
            }
        }
    }

    public c b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            synchronized (d.class) {
                b();
                c cVar = this.f69416b.get(i2);
                if (cVar != null) {
                    cVar.b();
                    c(cVar);
                    this.f69416b.remove(i2);
                    return cVar;
                }
                return null;
            }
        }
        return (c) invokeI.objValue;
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            synchronized (d.class) {
                boolean z = false;
                if (this.f69416b != null && this.f69416b.size() > 0) {
                    c cVar = this.f69416b.get(i2);
                    if (cVar != null && cVar.d()) {
                        z = true;
                    }
                    return z;
                }
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    public List<Integer> a() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (d.class) {
                b();
                arrayList = new ArrayList();
                for (int i2 = 0; i2 < this.f69416b.size(); i2++) {
                    c cVar = this.f69416b.get(this.f69416b.keyAt(i2));
                    if (cVar != null) {
                        arrayList.add(Integer.valueOf(cVar.e()));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void a(int i2, long j) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) || (cVar = this.f69416b.get(i2)) == null) {
            return;
        }
        cVar.c(j);
    }
}
