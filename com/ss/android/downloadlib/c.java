package com.ss.android.downloadlib;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.k;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.appdownloader.c.h;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c implements h {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f68725a = "c";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Handler f68726b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1020732127, "Lcom/ss/android/downloadlib/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1020732127, "Lcom/ss/android/downloadlib/c;");
        }
    }

    public c() {
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
        this.f68726b = new Handler(Looper.getMainLooper());
    }

    @Override // com.ss.android.socialbase.appdownloader.c.h
    public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) {
        DownloadModel a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048576, this, downloadInfo, baseException, i2) == null) || downloadInfo == null) {
            return;
        }
        if (i2 == -1 && baseException != null) {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
            a.a(jSONObject, downloadInfo);
            k.a("download_failed", jSONObject.toString());
        }
        com.ss.android.downloadad.api.a.b a3 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
        if (a3 == null) {
            return;
        }
        try {
            if (i2 != -1) {
                if (i2 == -3) {
                    a.a(downloadInfo, a3);
                    return;
                } else if (i2 == 2001) {
                    a.a().a(downloadInfo, a3, 2001);
                    return;
                } else if (i2 == 11) {
                    a.a().a(downloadInfo, a3, 2000);
                    if (a3.S()) {
                        return;
                    }
                    a(downloadInfo, a3);
                    return;
                } else {
                    return;
                }
            }
            BaseException baseException2 = null;
            if (baseException != null) {
                if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("toast_without_network", 0) == 1 && baseException.getErrorCode() == 1049) {
                    this.f68726b.post(new Runnable(this) { // from class: com.ss.android.downloadlib.c.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ c f68727a;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i3 = newInitContext.flag;
                                if ((i3 & 1) != 0) {
                                    int i4 = i3 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f68727a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                j.c().a(5, j.getContext(), null, "无网络，请检查网络设置", null, 0);
                            }
                        }
                    });
                }
                if (com.ss.android.socialbase.downloader.i.f.h(baseException)) {
                    if (j.l() != null) {
                        j.l().a(a3.b());
                    }
                    com.ss.android.downloadlib.d.a.a().a("download_failed_for_space", a3);
                    if (!a3.Q()) {
                        com.ss.android.downloadlib.d.a.a().a("download_can_restart", a3);
                        a(downloadInfo);
                    }
                    if ((j.l() == null || !j.l().d()) && (a2 = com.ss.android.downloadlib.addownload.b.f.a().a(a3.b())) != null && a2.isShowToast()) {
                        com.ss.android.socialbase.downloader.g.a a4 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
                        if (a4.a("show_no_enough_space_toast", 0) == 1) {
                            this.f68726b.post(new Runnable(this, a4, a2) { // from class: com.ss.android.downloadlib.c.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ com.ss.android.socialbase.downloader.g.a f68728a;

                                /* renamed from: b  reason: collision with root package name */
                                public final /* synthetic */ DownloadModel f68729b;

                                /* renamed from: c  reason: collision with root package name */
                                public final /* synthetic */ c f68730c;

                                {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, a4, a2};
                                        interceptable2.invokeUnInit(65536, newInitContext);
                                        int i3 = newInitContext.flag;
                                        if ((i3 & 1) != 0) {
                                            int i4 = i3 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable2.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f68730c = this;
                                    this.f68728a = a4;
                                    this.f68729b = a2;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable2 = $ic;
                                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                        j.c().a(2, j.getContext(), this.f68729b, this.f68728a.a("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
                                    }
                                }
                            });
                        }
                    }
                }
                baseException2 = new BaseException(baseException.getErrorCode(), l.a(baseException.getMessage(), j.i().optInt("exception_msg_length", 500)));
            }
            com.ss.android.downloadlib.d.a.a().b(downloadInfo, baseException2);
            f.a().a(downloadInfo, baseException, "");
        } catch (Exception e2) {
            j.s().a(e2, "onAppDownloadMonitorSend");
        }
    }

    private void a(DownloadInfo downloadInfo, com.ss.android.downloadad.api.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, downloadInfo, bVar) == null) {
            long a2 = l.a(Environment.getDataDirectory(), -1L);
            long min = Math.min(524288000L, l.a(Environment.getDataDirectory()) / 10);
            long totalBytes = downloadInfo.getTotalBytes();
            double d2 = (totalBytes * 2.5d) + min;
            if (a2 > -1 && totalBytes > -1) {
                double d3 = a2;
                if (d3 < d2 && d2 - d3 > com.ss.android.downloadlib.addownload.d.b()) {
                    com.ss.android.downloadlib.addownload.d.a(downloadInfo.getId());
                }
            }
            com.ss.android.socialbase.downloader.a.a.a().a(new a.InterfaceC1983a(this, bVar, a2, totalBytes, d2, downloadInfo) { // from class: com.ss.android.downloadlib.c.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.ss.android.downloadad.api.a.b f68731a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ long f68732b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ long f68733c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ double f68734d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ DownloadInfo f68735e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ c f68736f;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bVar, Long.valueOf(a2), Long.valueOf(totalBytes), Double.valueOf(d2), downloadInfo};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f68736f = this;
                    this.f68731a = bVar;
                    this.f68732b = a2;
                    this.f68733c = totalBytes;
                    this.f68734d = d2;
                    this.f68735e = downloadInfo;
                }

                @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC1983a
                public void b() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (!l.b(this.f68731a)) {
                            long j = this.f68732b;
                            if (j <= -1 || this.f68733c <= -1 || j >= this.f68734d) {
                                return;
                            }
                            com.ss.android.downloadlib.d.a.a().a("clean_space_install", com.ss.android.downloadlib.addownload.d.a("install_no_enough_space"), this.f68731a);
                            if (com.ss.android.downloadlib.addownload.d.a(this.f68735e, ((long) this.f68734d) - this.f68732b)) {
                                com.ss.android.socialbase.downloader.a.a.a().b(this);
                                this.f68731a.g(true);
                                return;
                            }
                            return;
                        }
                        com.ss.android.socialbase.downloader.a.a.a().b(this);
                    }
                }

                @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC1983a
                public void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    }
                }
            });
        }
    }

    private void a(@NonNull DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, this, downloadInfo) == null) && com.ss.android.downloadlib.g.e.f(downloadInfo.getId())) {
            d.a().b(new com.ss.android.downloadlib.addownload.c.b(downloadInfo));
        }
    }
}
