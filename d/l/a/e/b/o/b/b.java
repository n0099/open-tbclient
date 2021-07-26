package d.l.a.e.b.o.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.e.b.l.f;
import d.l.a.e.b.o.l;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final HandlerThread f72477a;

    /* renamed from: b  reason: collision with root package name */
    public static final Handler f72478b;

    /* renamed from: c  reason: collision with root package name */
    public static long f72479c;

    /* renamed from: d  reason: collision with root package name */
    public static long f72480d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Process.setThreadPriority(10);
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* renamed from: d.l.a.e.b.o.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class RunnableC2047b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f72481e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l f72482f;

        public RunnableC2047b(String str, l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f72481e = str;
            this.f72482f = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            if (!TextUtils.isEmpty(this.f72481e)) {
                try {
                    try {
                        List<com.ss.android.socialbase.downloader.model.c> d2 = b.d(0L, null, null);
                        r1 = d.l.a.e.b.o.b.a.a().e(this.f72481e) ? d.l.a.e.b.o.b.a.a().b(this.f72481e, d2) : null;
                        if (r1 == null) {
                            c cVar = new c(this.f72481e, d2, 0L);
                            try {
                                cVar.e();
                                if (cVar.h()) {
                                    d.l.a.e.b.o.b.a.a().d(this.f72481e, cVar);
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
                        Map<String, String> l = r1.l();
                        if (this.f72482f != null) {
                            this.f72482f.a(l);
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
                l lVar = this.f72482f;
                if (lVar != null) {
                    lVar.a(null);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1228118075, "Ld/l/a/e/b/o/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1228118075, "Ld/l/a/e/b/o/b/b;");
                return;
            }
        }
        f72477a = new HandlerThread("Downloader-preconnecter");
        e();
        f72477a.start();
        Handler handler = new Handler(f72477a.getLooper());
        f72478b = handler;
        handler.post(new a());
    }

    public static Looper a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f72477a.getLooper() : (Looper) invokeV.objValue;
    }

    public static void c(String str, l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, lVar) == null) {
            f72478b.post(new RunnableC2047b(str, lVar));
        }
    }

    public static List<com.ss.android.socialbase.downloader.model.c> d(long j, DownloadInfo downloadInfo, List<com.ss.android.socialbase.downloader.model.c> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j), downloadInfo, list})) == null) {
            return f.s(list, downloadInfo == null ? null : downloadInfo.geteTag(), j, 0L);
        }
        return (List) invokeCommon.objValue;
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            f72479c = d.l.a.e.b.j.a.r().c("preconnect_connection_outdate_time", 300000L);
            f72480d = d.l.a.e.b.j.a.r().c("preconnect_head_info_outdate_time", 300000L);
            d.l.a.e.b.o.b.a.a().c(d.l.a.e.b.j.a.r().b("preconnect_max_cache_size", 3));
        }
    }
}
