package com.ss.android.socialbase.downloader.network.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.j;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static long a;

    /* renamed from: b  reason: collision with root package name */
    public static long f62018b;

    /* renamed from: c  reason: collision with root package name */
    public static final HandlerThread f62019c;

    /* renamed from: d  reason: collision with root package name */
    public static final Handler f62020d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1746012390, "Lcom/ss/android/socialbase/downloader/network/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1746012390, "Lcom/ss/android/socialbase/downloader/network/a/b;");
                return;
            }
        }
        f62019c = new HandlerThread("Downloader-preconnecter");
        b();
        f62019c.start();
        Handler handler = new Handler(f62019c.getLooper());
        f62020d = handler;
        handler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.a.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        Process.setThreadPriority(10);
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            a = com.ss.android.socialbase.downloader.g.a.c().a("preconnect_connection_outdate_time", 300000L);
            f62018b = com.ss.android.socialbase.downloader.g.a.c().a("preconnect_head_info_outdate_time", 300000L);
            a.a().a(com.ss.android.socialbase.downloader.g.a.c().a("preconnect_max_cache_size", 3));
        }
    }

    public static Looper a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f62019c.getLooper() : (Looper) invokeV.objValue;
    }

    public static void a(String str, j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, jVar) == null) {
            f62020d.post(new Runnable(str, jVar) { // from class: com.ss.android.socialbase.downloader.network.a.b.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ String a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ j f62021b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {str, jVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = str;
                    this.f62021b = jVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                        return;
                    }
                    if (!TextUtils.isEmpty(this.a)) {
                        try {
                            try {
                                List<com.ss.android.socialbase.downloader.model.c> b2 = b.b(0L, null, null);
                                r1 = a.a().a(this.a) ? a.a().a(this.a, b2) : null;
                                if (r1 == null) {
                                    c cVar = new c(this.a, b2, 0L);
                                    try {
                                        cVar.a();
                                        if (cVar.e()) {
                                            a.a().a(this.a, cVar);
                                        }
                                        r1 = cVar;
                                    } catch (Exception e2) {
                                        e = e2;
                                        r1 = cVar;
                                        e.printStackTrace();
                                        r1.c();
                                    } catch (Throwable th) {
                                        th = th;
                                        r1 = cVar;
                                        try {
                                            r1.c();
                                        } catch (Throwable unused) {
                                        }
                                        throw th;
                                    }
                                }
                                Map<String, String> i2 = r1.i();
                                if (this.f62021b != null) {
                                    this.f62021b.a(i2);
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        } catch (Exception e3) {
                            e = e3;
                        }
                        try {
                            r1.c();
                        } catch (Throwable unused2) {
                        }
                    } else {
                        j jVar2 = this.f62021b;
                        if (jVar2 != null) {
                            jVar2.a(null);
                        }
                    }
                }
            });
        }
    }

    public static List<com.ss.android.socialbase.downloader.model.c> b(long j2, DownloadInfo downloadInfo, List<com.ss.android.socialbase.downloader.model.c> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j2), downloadInfo, list})) == null) {
            return f.a(list, downloadInfo == null ? null : downloadInfo.geteTag(), j2, 0L);
        }
        return (List) invokeCommon.objValue;
    }
}
