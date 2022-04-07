package com.kwai.filedownloader.services;

import android.util.SparseArray;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.download.DownloadLaunchRunnable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes5.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SparseArray<DownloadLaunchRunnable> a;
    public ThreadPoolExecutor b;
    public final String c;
    public int d;
    public int e;

    public h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new SparseArray<>();
        this.c = "Network";
        this.e = 0;
        this.b = com.kwai.filedownloader.e.b.a(i, "Network");
        this.d = i;
    }

    private synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            synchronized (this) {
                SparseArray<DownloadLaunchRunnable> sparseArray = new SparseArray<>();
                int size = this.a.size();
                for (int i = 0; i < size; i++) {
                    int keyAt = this.a.keyAt(i);
                    DownloadLaunchRunnable downloadLaunchRunnable = this.a.get(keyAt);
                    if (downloadLaunchRunnable.e()) {
                        sparseArray.put(keyAt, downloadLaunchRunnable);
                    }
                }
                this.a = sparseArray;
            }
        }
    }

    public synchronized int a() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                c();
                size = this.a.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public int a(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            if (str == null) {
                return 0;
            }
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                DownloadLaunchRunnable valueAt = this.a.valueAt(i2);
                if (valueAt != null && valueAt.e() && valueAt.d() != i && str.equals(valueAt.f())) {
                    return valueAt.d();
                }
            }
            return 0;
        }
        return invokeLI.intValue;
    }

    public void a(DownloadLaunchRunnable downloadLaunchRunnable) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadLaunchRunnable) == null) {
            downloadLaunchRunnable.b();
            synchronized (this) {
                this.a.put(downloadLaunchRunnable.d(), downloadLaunchRunnable);
            }
            this.b.execute(downloadLaunchRunnable);
            int i2 = this.e;
            if (i2 >= 600) {
                c();
                i = 0;
            } else {
                i = i2 + 1;
            }
            this.e = i;
        }
    }

    public synchronized boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            synchronized (this) {
                if (a() > 0) {
                    com.kwai.filedownloader.e.d.d(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
                    return false;
                }
                int a = com.kwai.filedownloader.e.e.a(i);
                if (com.kwai.filedownloader.e.d.a) {
                    com.kwai.filedownloader.e.d.c(this, "change the max network thread count, from %d to %d", Integer.valueOf(this.d), Integer.valueOf(a));
                }
                List<Runnable> shutdownNow = this.b.shutdownNow();
                this.b = com.kwai.filedownloader.e.b.a(a, "Network");
                if (shutdownNow.size() > 0) {
                    com.kwai.filedownloader.e.d.d(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(shutdownNow.size()));
                }
                this.d = a;
                return true;
            }
        }
        return invokeI.booleanValue;
    }

    public synchronized List<Integer> b() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                c();
                arrayList = new ArrayList();
                for (int i = 0; i < this.a.size(); i++) {
                    arrayList.add(Integer.valueOf(this.a.get(this.a.keyAt(i)).d()));
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            c();
            synchronized (this) {
                DownloadLaunchRunnable downloadLaunchRunnable = this.a.get(i);
                if (downloadLaunchRunnable != null) {
                    downloadLaunchRunnable.a();
                    boolean remove = this.b.remove(downloadLaunchRunnable);
                    if (com.kwai.filedownloader.e.d.a) {
                        com.kwai.filedownloader.e.d.c(this, "successful cancel %d %B", Integer.valueOf(i), Boolean.valueOf(remove));
                    }
                }
                this.a.remove(i);
            }
        }
    }

    public boolean c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            DownloadLaunchRunnable downloadLaunchRunnable = this.a.get(i);
            return downloadLaunchRunnable != null && downloadLaunchRunnable.e();
        }
        return invokeI.booleanValue;
    }
}
