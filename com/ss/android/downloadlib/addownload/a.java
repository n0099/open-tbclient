package com.ss.android.downloadlib.addownload;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.g.m;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a implements m.a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f68442a = "a";

    /* renamed from: b  reason: collision with root package name */
    public static a f68443b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public m f68444c;

    /* renamed from: d  reason: collision with root package name */
    public long f68445d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-2001018409, "Lcom/ss/android/downloadlib/addownload/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-2001018409, "Lcom/ss/android/downloadlib/addownload/a;");
        }
    }

    public a() {
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
        this.f68444c = new m(Looper.getMainLooper(), this);
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f68443b == null) {
                synchronized (a.class) {
                    if (f68443b == null) {
                        f68443b = new a();
                    }
                }
            }
            return f68443b;
        }
        return (a) invokeV.objValue;
    }

    public void a(@NonNull DownloadInfo downloadInfo, long j, long j2, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{downloadInfo, Long.valueOf(j), Long.valueOf(j2), str, str2, str3, str4}) == null) {
            com.ss.android.downloadlib.addownload.b.a aVar = new com.ss.android.downloadlib.addownload.b.a(downloadInfo.getId(), j, j2, str, str2, str3, str4);
            com.ss.android.socialbase.downloader.g.a a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
            if (a2.a("back_miui_silent_install", 1) == 0 && ((com.ss.android.socialbase.appdownloader.f.d.l() || com.ss.android.socialbase.appdownloader.f.d.m()) && com.ss.android.socialbase.downloader.i.j.a(j.getContext(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"))) {
                if (com.ss.android.socialbase.downloader.i.f.a(downloadInfo.getTempCacheData().get("extra_silent_install_succeed"), false)) {
                    Message obtainMessage = this.f68444c.obtainMessage(200, aVar);
                    obtainMessage.arg1 = 2;
                    this.f68444c.sendMessageDelayed(obtainMessage, a2.a("check_silent_install_interval", 60000));
                    return;
                }
                com.ss.android.downloadad.api.a.b d2 = com.ss.android.downloadlib.addownload.b.f.a().d(aVar.f68479b);
                JSONObject jSONObject = new JSONObject();
                int i2 = -1;
                try {
                    jSONObject.put("ttdownloader_type", "miui_silent_install");
                    jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has not started service");
                    i2 = 5;
                } catch (Exception unused) {
                }
                j.f().a(null, new BaseException(i2, jSONObject.toString()), i2);
                com.ss.android.downloadlib.d.a.a().a("embeded_ad", "ah_result", jSONObject, d2);
            }
            if (com.ss.android.downloadlib.g.e.c()) {
                long currentTimeMillis = System.currentTimeMillis() - this.f68445d;
                long d3 = com.ss.android.downloadlib.g.e.d();
                if (currentTimeMillis < com.ss.android.downloadlib.g.e.e()) {
                    long e2 = com.ss.android.downloadlib.g.e.e() - currentTimeMillis;
                    d3 += e2;
                    this.f68445d = System.currentTimeMillis() + e2;
                } else {
                    this.f68445d = System.currentTimeMillis();
                }
                m mVar = this.f68444c;
                mVar.sendMessageDelayed(mVar.obtainMessage(200, aVar), d3);
            }
        }
    }

    private void a(com.ss.android.downloadlib.addownload.b.a aVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65539, this, aVar, i2) == null) || j.k() == null || j.k().a() || aVar == null) {
            return;
        }
        if (2 == i2) {
            com.ss.android.downloadad.api.a.b d2 = com.ss.android.downloadlib.addownload.b.f.a().d(aVar.f68479b);
            JSONObject jSONObject = new JSONObject();
            int i3 = -1;
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                if (com.ss.android.downloadlib.g.l.d(j.getContext(), aVar.f68481d)) {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_succeed");
                    i3 = 4;
                } else {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has started service");
                    i3 = 5;
                }
            } catch (Exception unused) {
            }
            j.f().a(null, new BaseException(i3, jSONObject.toString()), i3);
            com.ss.android.downloadlib.d.a.a().a("embeded_ad", "ah_result", jSONObject, d2);
        }
        if (com.ss.android.downloadlib.g.l.d(j.getContext(), aVar.f68481d)) {
            com.ss.android.downloadlib.d.a.a().a("delayinstall_installed", aVar.f68479b);
        } else if (!com.ss.android.downloadlib.g.l.a(aVar.f68484g)) {
            com.ss.android.downloadlib.d.a.a().a("delayinstall_file_lost", aVar.f68479b);
        } else if (com.ss.android.downloadlib.addownload.a.a.a().a(aVar.f68481d)) {
            com.ss.android.downloadlib.d.a.a().a("delayinstall_conflict_with_back_dialog", aVar.f68479b);
        } else {
            com.ss.android.downloadlib.d.a.a().a("delayinstall_install_start", aVar.f68479b);
            com.ss.android.socialbase.appdownloader.d.a(j.getContext(), (int) aVar.f68478a);
        }
    }

    @Override // com.ss.android.downloadlib.g.m.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 200) {
            a((com.ss.android.downloadlib.addownload.b.a) message.obj, message.arg1);
        }
    }
}
