package com.ss.android.downloadlib;

import android.content.SharedPreferences;
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
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.j;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ExecutorService f68761a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f68762b;

    /* renamed from: c  reason: collision with root package name */
    public ScheduledExecutorService f68763c;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static d f68765a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1671041313, "Lcom/ss/android/downloadlib/d$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1671041313, "Lcom/ss/android/downloadlib/d$a;");
                    return;
                }
            }
            f68765a = new d();
        }
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f68765a : (d) invokeV.objValue;
    }

    public void b(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, runnable) == null) {
            b(runnable, false);
        }
    }

    public ExecutorService c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f68762b == null) {
                synchronized (d.class) {
                    if (this.f68762b == null) {
                        TimeUnit timeUnit = TimeUnit.SECONDS;
                        SynchronousQueue synchronousQueue = new SynchronousQueue();
                        this.f68762b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, timeUnit, synchronousQueue, new com.ss.android.socialbase.downloader.h.a(g.class.getName() + "-IOThreadPool"));
                    }
                }
            }
            return this.f68762b;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public ScheduledExecutorService d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f68763c == null) {
                synchronized (d.class) {
                    if (this.f68763c == null) {
                        this.f68763c = new ScheduledThreadPoolExecutor(0, new com.ss.android.socialbase.downloader.h.a(g.class.getName() + "-ScheduledThreadPool"));
                    }
                }
            }
            return this.f68763c;
        }
        return (ScheduledExecutorService) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            a(new Runnable(this) { // from class: com.ss.android.downloadlib.d.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f68764a;

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
                    this.f68764a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    j x;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (d.class) {
                            try {
                                String[] strArr = {"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_ttdownloader_clean", "sp_order_download", "sp_a_b_c", "sp_ah_config", "sp_download_info", "sp_appdownloader"};
                                for (int i2 = 0; i2 < 13; i2++) {
                                    SharedPreferences sharedPreferences = com.ss.android.downloadlib.addownload.j.getContext().getSharedPreferences(strArr[i2], 0);
                                    if (sharedPreferences != null) {
                                        sharedPreferences.edit().clear().apply();
                                    }
                                }
                                x = com.ss.android.socialbase.downloader.downloader.c.x();
                            } catch (Throwable unused) {
                            }
                            if (x instanceof com.ss.android.socialbase.downloader.impls.d) {
                                SparseArray<DownloadInfo> a2 = ((com.ss.android.socialbase.downloader.impls.d) x).a().a();
                                for (int size = a2.size() - 1; size >= 0; size--) {
                                    DownloadInfo downloadInfo = a2.get(a2.keyAt(size));
                                    if (downloadInfo != null) {
                                        Downloader.getInstance(com.ss.android.downloadlib.addownload.j.getContext()).clearDownloadData(downloadInfo.getId());
                                    }
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
            a(runnable, false);
        }
    }

    public void b(Runnable runnable, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, runnable, z) == null) || runnable == null) {
            return;
        }
        if (z && !l.a()) {
            runnable.run();
        } else {
            c().execute(runnable);
        }
    }

    public void a(Runnable runnable, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, runnable, z) == null) || runnable == null) {
            return;
        }
        if (z && !l.a()) {
            runnable.run();
        } else {
            b().execute(runnable);
        }
    }

    public ExecutorService b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f68761a == null) {
                synchronized (d.class) {
                    if (this.f68761a == null) {
                        TimeUnit timeUnit = TimeUnit.SECONDS;
                        SynchronousQueue synchronousQueue = new SynchronousQueue();
                        this.f68761a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, timeUnit, synchronousQueue, new com.ss.android.socialbase.downloader.h.a(g.class.getName() + "-CPUThreadPool"));
                    }
                }
            }
            return this.f68761a;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public void a(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable, j) == null) {
            try {
                d().schedule(runnable, j, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
