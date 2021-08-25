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
/* loaded from: classes10.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<DownloadLaunchRunnable> f74169a;

    /* renamed from: b  reason: collision with root package name */
    public ThreadPoolExecutor f74170b;

    /* renamed from: c  reason: collision with root package name */
    public final String f74171c;

    /* renamed from: d  reason: collision with root package name */
    public int f74172d;

    /* renamed from: e  reason: collision with root package name */
    public int f74173e;

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
        this.f74169a = new SparseArray<>();
        this.f74171c = "Network";
        this.f74173e = 0;
        this.f74170b = com.kwai.filedownloader.f.b.a(i2, "Network");
        this.f74172d = i2;
    }

    private synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            synchronized (this) {
                SparseArray<DownloadLaunchRunnable> sparseArray = new SparseArray<>();
                int size = this.f74169a.size();
                for (int i2 = 0; i2 < size; i2++) {
                    int keyAt = this.f74169a.keyAt(i2);
                    DownloadLaunchRunnable downloadLaunchRunnable = this.f74169a.get(keyAt);
                    if (downloadLaunchRunnable.e()) {
                        sparseArray.put(keyAt, downloadLaunchRunnable);
                    }
                }
                this.f74169a = sparseArray;
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
                size = this.f74169a.size();
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
            int size = this.f74169a.size();
            for (int i3 = 0; i3 < size; i3++) {
                DownloadLaunchRunnable valueAt = this.f74169a.valueAt(i3);
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
                this.f74169a.put(downloadLaunchRunnable.d(), downloadLaunchRunnable);
            }
            this.f74170b.execute(downloadLaunchRunnable);
            int i3 = this.f74173e;
            if (i3 >= 600) {
                c();
                i2 = 0;
            } else {
                i2 = i3 + 1;
            }
            this.f74173e = i2;
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
                if (com.kwai.filedownloader.f.d.f74064a) {
                    com.kwai.filedownloader.f.d.c(this, "change the max network thread count, from %d to %d", Integer.valueOf(this.f74172d), Integer.valueOf(a2));
                }
                List<Runnable> shutdownNow = this.f74170b.shutdownNow();
                this.f74170b = com.kwai.filedownloader.f.b.a(a2, "Network");
                if (shutdownNow.size() > 0) {
                    com.kwai.filedownloader.f.d.d(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(shutdownNow.size()));
                }
                this.f74172d = a2;
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
                for (int i2 = 0; i2 < this.f74169a.size(); i2++) {
                    arrayList.add(Integer.valueOf(this.f74169a.get(this.f74169a.keyAt(i2)).d()));
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
                DownloadLaunchRunnable downloadLaunchRunnable = this.f74169a.get(i2);
                if (downloadLaunchRunnable != null) {
                    downloadLaunchRunnable.a();
                    boolean remove = this.f74170b.remove(downloadLaunchRunnable);
                    if (com.kwai.filedownloader.f.d.f74064a) {
                        com.kwai.filedownloader.f.d.c(this, "successful cancel %d %B", Integer.valueOf(i2), Boolean.valueOf(remove));
                    }
                }
                this.f74169a.remove(i2);
            }
        }
    }

    public boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            DownloadLaunchRunnable downloadLaunchRunnable = this.f74169a.get(i2);
            return downloadLaunchRunnable != null && downloadLaunchRunnable.e();
        }
        return invokeI.booleanValue;
    }
}
