package com.ss.android.downloadlib.c;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static h f69679a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-465347831, "Lcom/ss/android/downloadlib/c/h$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-465347831, "Lcom/ss/android/downloadlib/c/h$a;");
                    return;
                }
            }
            f69679a = new h();
        }
    }

    public void b(com.ss.android.downloadad.api.a.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || bVar == null) {
            return;
        }
        b(bVar, com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("noti_continue_delay_secs", 5));
    }

    public void c(@NonNull com.ss.android.downloadad.api.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            c(bVar, 5L);
        }
    }

    public void d(@NonNull com.ss.android.downloadad.api.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            c(bVar, com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("noti_install_delay_secs", 5));
        }
    }

    public void e(@NonNull com.ss.android.downloadad.api.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            a(bVar, 5L);
        }
    }

    public void f(@NonNull com.ss.android.downloadad.api.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            a(bVar, com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("noti_open_delay_secs", 5));
        }
    }

    public h() {
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

    public static h a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f69679a : (h) invokeV.objValue;
    }

    private void b(@NonNull com.ss.android.downloadad.api.a.b bVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(AdIconUtil.AD_TEXT_ID, this, bVar, j) == null) {
            int s = bVar.s();
            if (com.ss.android.socialbase.downloader.g.a.a(s).b("notification_opt_2") != 1) {
                return;
            }
            a(s);
            com.ss.android.downloadlib.d.a().a(new Runnable(this, s, bVar) { // from class: com.ss.android.downloadlib.c.h.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f69670a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ com.ss.android.downloadad.api.a.b f69671b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ h f69672c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(s), bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f69672c = this;
                    this.f69670a = s;
                    this.f69671b = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        DownloadInfo downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(this.f69670a);
                        JSONObject jSONObject = new JSONObject();
                        l.a(jSONObject, "ttdownloader_type", (Object) 1);
                        com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
                        if (downloadInfo != null && -2 == downloadInfo.getRealStatus() && !downloadInfo.isPauseReserveOnWifi()) {
                            this.f69672c.a(this.f69670a, this.f69671b, jSONObject);
                        } else {
                            l.a(jSONObject, "error_code", (Object) 1001);
                        }
                        com.ss.android.downloadlib.d.a.a().b("download_notification_try_show", jSONObject, this.f69671b);
                    }
                }
            }, j * 1000);
        }
    }

    private void c(@NonNull com.ss.android.downloadad.api.a.b bVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(AdIconUtil.BAIDU_LOGO_ID, this, bVar, j) == null) {
            int s = bVar.s();
            if (com.ss.android.socialbase.downloader.g.a.a(s).b("notification_opt_2") != 1) {
                return;
            }
            a(s);
            com.ss.android.downloadlib.d.a().a(new Runnable(this, s, bVar) { // from class: com.ss.android.downloadlib.c.h.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f69673a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ com.ss.android.downloadad.api.a.b f69674b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ h f69675c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(s), bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f69675c = this;
                    this.f69673a = s;
                    this.f69674b = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        DownloadInfo downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(this.f69673a);
                        JSONObject jSONObject = new JSONObject();
                        l.a(jSONObject, "ttdownloader_type", (Object) 2);
                        com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
                        if (!l.b(this.f69674b)) {
                            this.f69675c.a(this.f69673a, this.f69674b, jSONObject);
                        } else {
                            l.a(jSONObject, "error_code", (Object) 1002);
                        }
                        com.ss.android.downloadlib.d.a.a().b("download_notification_try_show", jSONObject, this.f69674b);
                    }
                }
            }, j * 1000);
        }
    }

    public void a(com.ss.android.downloadad.api.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            b(bVar, 5L);
        }
    }

    public void a(@NonNull com.ss.android.downloadad.api.a.b bVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, bVar, j) == null) {
            int s = bVar.s();
            if (com.ss.android.socialbase.downloader.g.a.a(s).b("notification_opt_2") != 1) {
                return;
            }
            a(s);
            com.ss.android.downloadlib.d.a().a(new Runnable(this, s, bVar) { // from class: com.ss.android.downloadlib.c.h.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ int f69676a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ com.ss.android.downloadad.api.a.b f69677b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ h f69678c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Integer.valueOf(s), bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f69678c = this;
                    this.f69676a = s;
                    this.f69677b = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        DownloadInfo downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(this.f69676a);
                        JSONObject jSONObject = new JSONObject();
                        l.a(jSONObject, "ttdownloader_type", (Object) 3);
                        com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
                        if (!l.c(this.f69677b.e())) {
                            this.f69678c.a(this.f69676a, this.f69677b, jSONObject);
                        } else {
                            l.a(jSONObject, "error_code", (Object) 1003);
                        }
                        com.ss.android.downloadlib.d.a.a().b("download_notification_try_show", jSONObject, this.f69677b);
                    }
                }
            }, j * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, com.ss.android.downloadad.api.a.b bVar, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65539, this, i2, bVar, jSONObject) == null) {
            if (!com.ss.android.socialbase.appdownloader.e.d.a()) {
                l.a(jSONObject, "error_code", (Object) 1004);
                return;
            }
            DownloadInfo downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(i2);
            if (downloadInfo == null) {
                l.a(jSONObject, "error_code", (Object) 1005);
                return;
            }
            if (com.ss.android.socialbase.downloader.notification.b.a().e(i2) != null) {
                com.ss.android.socialbase.downloader.notification.b.a().f(i2);
            }
            com.ss.android.socialbase.appdownloader.e.a aVar = new com.ss.android.socialbase.appdownloader.e.a(j.getContext(), i2, downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
            aVar.a(downloadInfo.getCurBytes());
            aVar.b(downloadInfo.getTotalBytes());
            aVar.a(downloadInfo.getStatus(), null, false, false);
            com.ss.android.socialbase.downloader.notification.b.a().a(aVar);
            aVar.a((BaseException) null, false);
            com.ss.android.downloadlib.d.a.a().b("download_notification_show", jSONObject, bVar);
        }
    }

    public void a(int i2) {
        DownloadInfo downloadInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048576, this, i2) == null) && com.ss.android.socialbase.appdownloader.e.c.a().a(i2) == null && (downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(i2)) != null) {
            com.ss.android.socialbase.appdownloader.e.c.a().a(i2, downloadInfo.getIconUrl());
        }
    }
}
