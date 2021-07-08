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
/* loaded from: classes6.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<DownloadLaunchRunnable> f36950a;

    /* renamed from: b  reason: collision with root package name */
    public ThreadPoolExecutor f36951b;

    /* renamed from: c  reason: collision with root package name */
    public final String f36952c;

    /* renamed from: d  reason: collision with root package name */
    public int f36953d;

    /* renamed from: e  reason: collision with root package name */
    public int f36954e;

    public h(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f36950a = new SparseArray<>();
        this.f36952c = "Network";
        this.f36954e = 0;
        this.f36951b = com.kwai.filedownloader.f.b.a(i2, "Network");
        this.f36953d = i2;
    }

    private synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            synchronized (this) {
                SparseArray<DownloadLaunchRunnable> sparseArray = new SparseArray<>();
                int size = this.f36950a.size();
                for (int i2 = 0; i2 < size; i2++) {
                    int keyAt = this.f36950a.keyAt(i2);
                    DownloadLaunchRunnable downloadLaunchRunnable = this.f36950a.get(keyAt);
                    if (downloadLaunchRunnable.e()) {
                        sparseArray.put(keyAt, downloadLaunchRunnable);
                    }
                }
                this.f36950a = sparseArray;
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
                size = this.f36950a.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public int a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2)) == null) {
            if (str == null) {
                return 0;
            }
            int size = this.f36950a.size();
            for (int i3 = 0; i3 < size; i3++) {
                DownloadLaunchRunnable valueAt = this.f36950a.valueAt(i3);
                if (valueAt != null && valueAt.e() && valueAt.d() != i2 && str.equals(valueAt.f())) {
                    return valueAt.d();
                }
            }
            return 0;
        }
        return invokeLI.intValue;
    }

    public void a(DownloadLaunchRunnable downloadLaunchRunnable) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, downloadLaunchRunnable) == null) {
            downloadLaunchRunnable.b();
            synchronized (this) {
                this.f36950a.put(downloadLaunchRunnable.d(), downloadLaunchRunnable);
            }
            this.f36951b.execute(downloadLaunchRunnable);
            int i3 = this.f36954e;
            if (i3 >= 600) {
                c();
                i2 = 0;
            } else {
                i2 = i3 + 1;
            }
            this.f36954e = i2;
        }
    }

    public synchronized boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            synchronized (this) {
                if (a() > 0) {
                    com.kwai.filedownloader.f.d.d(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
                    return false;
                }
                int a2 = com.kwai.filedownloader.f.e.a(i2);
                if (com.kwai.filedownloader.f.d.f36845a) {
                    com.kwai.filedownloader.f.d.c(this, "change the max network thread count, from %d to %d", Integer.valueOf(this.f36953d), Integer.valueOf(a2));
                }
                List<Runnable> shutdownNow = this.f36951b.shutdownNow();
                this.f36951b = com.kwai.filedownloader.f.b.a(a2, "Network");
                if (shutdownNow.size() > 0) {
                    com.kwai.filedownloader.f.d.d(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(shutdownNow.size()));
                }
                this.f36953d = a2;
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
                for (int i2 = 0; i2 < this.f36950a.size(); i2++) {
                    arrayList.add(Integer.valueOf(this.f36950a.get(this.f36950a.keyAt(i2)).d()));
                }
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            c();
            synchronized (this) {
                DownloadLaunchRunnable downloadLaunchRunnable = this.f36950a.get(i2);
                if (downloadLaunchRunnable != null) {
                    downloadLaunchRunnable.a();
                    boolean remove = this.f36951b.remove(downloadLaunchRunnable);
                    if (com.kwai.filedownloader.f.d.f36845a) {
                        com.kwai.filedownloader.f.d.c(this, "successful cancel %d %B", Integer.valueOf(i2), Boolean.valueOf(remove));
                    }
                }
                this.f36950a.remove(i2);
            }
        }
    }

    public boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            DownloadLaunchRunnable downloadLaunchRunnable = this.f36950a.get(i2);
            return downloadLaunchRunnable != null && downloadLaunchRunnable.e();
        }
        return invokeI.booleanValue;
    }
}
