package com.ss.android.socialbase.downloader.impls;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes2.dex */
public class e extends a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static com.ss.android.socialbase.downloader.h.d f69549b;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        f69549b = new com.ss.android.socialbase.downloader.h.d();
    }

    public static void c(List<Callable<Object>> list) throws InterruptedException {
        ExecutorService q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, list) == null) || (q = com.ss.android.socialbase.downloader.downloader.c.q()) == null) {
            return;
        }
        q.invokeAll(list);
    }

    public static List<Future> d(List<Runnable> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            ExecutorService q = com.ss.android.socialbase.downloader.downloader.c.q();
            ArrayList arrayList = new ArrayList(list.size());
            for (Runnable runnable : list) {
                arrayList.add(q.submit(runnable));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static Runnable e(List<Future> list) {
        InterceptResult invokeL;
        BlockingQueue<Runnable> queue;
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            if (list != null && !list.isEmpty()) {
                try {
                    ExecutorService q = com.ss.android.socialbase.downloader.downloader.c.q();
                    if ((q instanceof ThreadPoolExecutor) && (queue = ((ThreadPoolExecutor) q).getQueue()) != null && !queue.isEmpty()) {
                        Iterator<Future> it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                runnable = null;
                                break;
                            }
                            Future next = it.next();
                            if ((next instanceof Runnable) && queue.remove(next)) {
                                runnable = (Runnable) next;
                                break;
                            }
                        }
                        if (runnable != null) {
                            list.remove(runnable);
                            return runnable;
                        }
                    }
                } catch (Throwable th) {
                    com.ss.android.socialbase.downloader.c.a.d("DefaultDownloadEngine", "getUnstartedTask() error: " + th.toString());
                }
            }
            return null;
        }
        return (Runnable) invokeL.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public boolean a(int i2) {
        InterceptResult invokeI;
        DownloadInfo d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            com.ss.android.socialbase.downloader.h.d dVar = f69549b;
            if (dVar == null || !dVar.a(i2) || (d2 = d(i2)) == null) {
                return false;
            }
            if (DownloadStatus.isDownloading(d2.getStatus())) {
                return true;
            }
            b(i2);
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void b(int i2) {
        com.ss.android.socialbase.downloader.h.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (dVar = f69549b) == null) {
            return;
        }
        dVar.c(i2);
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public com.ss.android.socialbase.downloader.h.c c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            com.ss.android.socialbase.downloader.h.d dVar = f69549b;
            if (dVar == null) {
                return null;
            }
            return dVar.b(i2);
        }
        return (com.ss.android.socialbase.downloader.h.c) invokeI.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(com.ss.android.socialbase.downloader.h.c cVar) {
        com.ss.android.socialbase.downloader.h.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) || (dVar = f69549b) == null) {
            return;
        }
        dVar.b(cVar);
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(int i2, DownloadTask downloadTask) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, downloadTask) == null) || downloadTask == null) {
            return;
        }
        com.ss.android.socialbase.downloader.c.a.b("DownloadTask", "start doDownload for task : " + i2);
        f69549b.a(new com.ss.android.socialbase.downloader.h.c(downloadTask, this.f69511a));
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public List<Integer> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? f69549b.a() : (List) invokeV.objValue;
    }

    @Override // com.ss.android.socialbase.downloader.impls.a
    public void a(int i2, long j) {
        com.ss.android.socialbase.downloader.h.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) || (dVar = f69549b) == null) {
            return;
        }
        dVar.a(i2, j);
    }
}
