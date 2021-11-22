package com.ss.android.downloadlib.d;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.c;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.b.e;
import com.ss.android.downloadlib.addownload.b.f;
import com.ss.android.downloadlib.addownload.b.i;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.appdownloader.e.d;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.ss.android.downloadlib.d.a$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.ss.android.downloadlib.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C2012a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static a f69685a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-436927217, "Lcom/ss/android/downloadlib/d/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-436927217, "Lcom/ss/android/downloadlib/d/a$a;");
                    return;
                }
            }
            f69685a = new a(null);
        }
    }

    public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C2012a.f69685a : (a) invokeV.objValue;
    }

    public void b(long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            a(j, i2, (DownloadInfo) null);
        }
    }

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

    public void a(long j, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2)}) == null) {
            e e2 = f.a().e(j);
            if (e2.x()) {
                com.ss.android.downloadlib.e.c.a().a("sendClickEvent ModelBox notValid");
            } else if (e2.f69435c.isEnableClickEvent()) {
                int i3 = 1;
                DownloadEventConfig downloadEventConfig = e2.f69435c;
                String clickItemTag = i2 == 1 ? downloadEventConfig.getClickItemTag() : downloadEventConfig.getClickButtonTag();
                String a2 = l.a(e2.f69435c.getClickLabel(), PrefetchEvent.STATE_CLICK);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("download_click_type", Integer.valueOf(i2));
                    jSONObject.putOpt("permission_notification", Integer.valueOf(d.a() ? 1 : 2));
                    if (!com.ss.android.socialbase.downloader.i.f.c(j.getContext())) {
                        i3 = 2;
                    }
                    jSONObject.putOpt("network_available", Integer.valueOf(i3));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                a(clickItemTag, a2, jSONObject, e2);
                if (!PrefetchEvent.STATE_CLICK.equals(a2) || e2.f69434b == null) {
                    return;
                }
                c.a().a(j, e2.f69434b.getLogExtra());
            }
        }
    }

    public void b(DownloadInfo downloadInfo, BaseException baseException) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, downloadInfo, baseException) == null) || downloadInfo == null) {
            return;
        }
        com.ss.android.downloadad.api.a.b a2 = f.a().a(downloadInfo);
        if (a2 == null) {
            com.ss.android.downloadlib.e.c.a().a("sendDownloadFailedEvent nativeModel null");
        } else if (a2.f69301c.get()) {
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
                com.ss.android.downloadlib.a.a(jSONObject, downloadInfo);
                if (baseException != null) {
                    jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                    jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
                    a2.d(baseException.getErrorCode());
                    a2.a(baseException.getErrorMessage());
                }
                a2.y();
                jSONObject.put("download_failed_times", a2.x());
                if (downloadInfo.getTotalBytes() > 0) {
                    jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
                }
                int i2 = 1;
                jSONObject.put("has_send_download_failed_finally", a2.f69302d.get() ? 1 : 2);
                com.ss.android.downloadlib.g.f.a(a2, jSONObject);
                if (!a2.V()) {
                    i2 = 2;
                }
                jSONObject.put("is_update_download", i2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            a(a2.j(), "download_failed", jSONObject, a2);
            i.a().a(a2);
        }
    }

    public void a(long j, int i2, DownloadInfo downloadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Integer.valueOf(i2), downloadInfo}) == null) {
            e e2 = f.a().e(j);
            if (e2.x()) {
                com.ss.android.downloadlib.e.c.a().a("sendEvent ModelBox notValid");
                return;
            }
            String str = null;
            JSONObject jSONObject = new JSONObject();
            l.a(jSONObject, "download_scene", Integer.valueOf(e2.t()));
            if (i2 == 1) {
                str = l.a(e2.f69435c.getStorageDenyLabel(), "storage_deny");
            } else if (i2 == 2) {
                str = l.a(e2.f69435c.getClickStartLabel(), "click_start");
                com.ss.android.downloadlib.g.f.a(downloadInfo, jSONObject);
            } else if (i2 == 3) {
                str = l.a(e2.f69435c.getClickPauseLabel(), "click_pause");
                com.ss.android.downloadlib.g.f.b(downloadInfo, jSONObject);
            } else if (i2 == 4) {
                str = l.a(e2.f69435c.getClickContinueLabel(), "click_continue");
                com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
            } else if (i2 == 5) {
                if (downloadInfo != null) {
                    try {
                        com.ss.android.downloadlib.g.f.a(jSONObject, downloadInfo.getId());
                        com.ss.android.downloadlib.a.b(jSONObject, downloadInfo);
                    } catch (Throwable unused) {
                    }
                }
                str = l.a(e2.f69435c.getClickInstallLabel(), "click_install");
            }
            a(null, str, jSONObject, 0L, 1, e2);
        }
    }

    public void b(String str, com.ss.android.downloadad.api.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, aVar) == null) {
            a((String) null, str, aVar);
        }
    }

    public void b(String str, JSONObject jSONObject, com.ss.android.downloadad.api.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, str, jSONObject, aVar) == null) {
            a((String) null, str, jSONObject, aVar);
        }
    }

    public void a(String str, int i2, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i2, eVar) == null) {
            a(null, str, null, i2, 0, eVar);
        }
    }

    public void a(long j, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            e e2 = f.a().e(j);
            if (e2.x()) {
                com.ss.android.downloadlib.e.c.a().a("sendQuickAppEvent ModelBox notValid");
            } else if (e2.f69434b.getQuickAppModel() == null) {
            } else {
                DownloadModel downloadModel = e2.f69434b;
                if (downloadModel instanceof AdDownloadModel) {
                    ((AdDownloadModel) downloadModel).setFunnelType(3);
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("download_click_type", Integer.valueOf(i2));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                b(z ? "deeplink_quickapp_success" : "deeplink_quickapp_failed", jSONObject, e2);
            }
        }
    }

    public void a(long j, BaseException baseException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j, baseException) == null) {
            e e2 = f.a().e(j);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_time", 0);
                if (baseException != null) {
                    jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                    jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            b("download_failed", jSONObject, e2);
        }
    }

    public void a(DownloadInfo downloadInfo) {
        com.ss.android.downloadad.api.a.b a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, downloadInfo) == null) || (a2 = f.a().a(downloadInfo)) == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
            a2.a(System.currentTimeMillis());
            a(a2.j(), "download_resume", jSONObject, a2);
            i.a().a(a2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, jSONObject, bVar) == null) {
            a(bVar.j(), "install_finish", jSONObject, bVar);
        }
    }

    public void a(DownloadInfo downloadInfo, BaseException baseException) {
        com.ss.android.downloadad.api.a.b a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, downloadInfo, baseException) == null) || downloadInfo == null || (a2 = f.a().a(downloadInfo)) == null || a2.f69301c.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.a.a(jSONObject, downloadInfo);
            jSONObject.putOpt("fail_status", Integer.valueOf(a2.E()));
            jSONObject.putOpt("fail_msg", a2.F());
            jSONObject.put("download_failed_times", a2.x());
            if (downloadInfo.getTotalBytes() > 0) {
                jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
            }
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long currentTimeMillis = System.currentTimeMillis();
            if (a2.H() > 0) {
                jSONObject.put("time_from_start_download", currentTimeMillis - a2.H());
            }
            if (a2.B() > 0) {
                jSONObject.put("time_from_download_resume", currentTimeMillis - a2.B());
            }
            int i2 = 1;
            jSONObject.put("is_update_download", a2.V() ? 1 : 2);
            jSONObject.put("can_show_notification", d.a() ? 1 : 2);
            if (!a2.f69302d.get()) {
                i2 = 2;
            }
            jSONObject.put("has_send_download_failed_finally", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a(a2.j(), "download_cancel", jSONObject, a2);
    }

    public void a(String str, com.ss.android.downloadad.api.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, aVar) == null) {
            a(str, (JSONObject) null, aVar);
        }
    }

    public void a(String str, JSONObject jSONObject, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, jSONObject, Long.valueOf(j)}) == null) {
            com.ss.android.downloadad.api.a.a d2 = f.a().d(j);
            if (d2 != null) {
                a(str, jSONObject, d2);
                return;
            }
            e e2 = f.a().e(j);
            if (e2.x()) {
                com.ss.android.downloadlib.e.c.a().a("sendUnityEvent ModelBox notValid");
            } else {
                a(str, jSONObject, e2);
            }
        }
    }

    public void a(String str, JSONObject jSONObject, com.ss.android.downloadad.api.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, str, jSONObject, aVar) == null) {
            JSONObject jSONObject2 = new JSONObject();
            l.a(jSONObject2, "unity_label", str);
            a("embeded_ad", "ttdownloader_unity", l.a(jSONObject, jSONObject2), aVar);
        }
    }

    public void a(String str, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, downloadModel, downloadEventConfig, downloadController) == null) {
            b(str, new e(downloadModel.getId(), downloadModel, downloadEventConfig, downloadController));
        }
    }

    public void a(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048583, this, str, j) == null) {
            com.ss.android.downloadad.api.a.b d2 = f.a().d(j);
            if (d2 != null) {
                b(str, d2);
            } else {
                b(str, f.a().e(j));
            }
        }
    }

    public void a(String str, String str2, com.ss.android.downloadad.api.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, str, str2, aVar) == null) {
            a(str, str2, (JSONObject) null, aVar);
        }
    }

    public void a(String str, String str2, JSONObject jSONObject, com.ss.android.downloadad.api.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048587, this, str, str2, jSONObject, aVar) == null) {
            a(str, str2, jSONObject, 0L, 0, aVar);
        }
    }

    private void a(String str, String str2, JSONObject jSONObject, long j, int i2, com.ss.android.downloadad.api.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{str, str2, jSONObject, Long.valueOf(j), Integer.valueOf(i2), aVar}) == null) {
            if (aVar == null) {
                com.ss.android.downloadlib.e.c.a().a("onEvent data null");
            } else if ((aVar instanceof e) && ((e) aVar).x()) {
                com.ss.android.downloadlib.e.c.a().a("onEvent ModelBox notValid");
            } else {
                try {
                    c.a c2 = new c.a().a(l.a(str, aVar.j(), "embeded_ad")).b(str2).b(aVar.c()).a(aVar.b()).c(aVar.d());
                    if (j <= 0) {
                        j = aVar.l();
                    }
                    c.a a2 = c2.b(j).d(aVar.i()).a(aVar.n()).a(l.a(a(aVar), jSONObject)).b(aVar.k()).a(aVar.o());
                    if (i2 <= 0) {
                        i2 = 2;
                    }
                    a(a2.a(i2).a(aVar.m()).a());
                } catch (Exception e2) {
                    com.ss.android.downloadlib.e.c.a().a(e2, "onEvent");
                }
            }
        }
    }

    private JSONObject a(com.ss.android.downloadad.api.a.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, aVar)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                l.a(aVar.g(), jSONObject);
                l.a(aVar.p(), jSONObject);
                jSONObject.putOpt("download_url", aVar.a());
                jSONObject.putOpt("package_name", aVar.e());
                jSONObject.putOpt("android_int", Integer.valueOf(Build.VERSION.SDK_INT));
                jSONObject.putOpt("rom_name", com.ss.android.socialbase.appdownloader.f.d.g());
                jSONObject.putOpt("rom_version", com.ss.android.socialbase.appdownloader.f.d.h());
                jSONObject.putOpt("ttdownloader", 1);
                jSONObject.putOpt("funnel_type", Integer.valueOf(aVar.h()));
                if (aVar.h() == 2) {
                    com.ss.android.downloadlib.g.f.b(jSONObject, aVar);
                }
            } catch (Exception e2) {
                j.s().a(e2, "getBaseJson");
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    private void a(com.ss.android.download.api.model.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, cVar) == null) || j.a() == null) {
            return;
        }
        if (cVar.m()) {
            j.a().a(cVar);
        } else {
            j.a().b(cVar);
        }
    }
}
