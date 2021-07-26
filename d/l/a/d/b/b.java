package d.l.a.d.b;

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
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.d.b.a.a;
import d.l.a.d.b.c;
import d.l.a.d.e;
import d.l.a.d.h;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b implements h.s.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static b f71694c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public h.s f71695a;

    /* renamed from: b  reason: collision with root package name */
    public long f71696b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(768773177, "Ld/l/a/d/b/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(768773177, "Ld/l/a/d/b/b;");
        }
    }

    public b() {
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
        this.f71695a = new h.s(Looper.getMainLooper(), this);
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f71694c == null) {
                synchronized (b.class) {
                    if (f71694c == null) {
                        f71694c = new b();
                    }
                }
            }
            return f71694c;
        }
        return (b) invokeV.objValue;
    }

    public final void b(c.b bVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, i2) == null) || l.x() == null || l.x().a() || bVar == null) {
            return;
        }
        if (2 == i2) {
            d.l.a.b.a.c.b u = c.g.e().u(bVar.f71701b);
            JSONObject jSONObject = new JSONObject();
            int i3 = -1;
            try {
                jSONObject.put("ttdownloader_type", "miui_silent_install");
                if (h.r.G(l.a(), bVar.f71703d)) {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_succeed");
                    i3 = 4;
                } else {
                    jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has started service");
                    i3 = 5;
                }
            } catch (Exception unused) {
            }
            l.s().a(null, new BaseException(i3, jSONObject.toString()), i3);
            e.c.a().p("embeded_ad", "ah_result", jSONObject, u);
        }
        if (h.r.G(l.a(), bVar.f71703d)) {
            e.c.a().k("delayinstall_installed", bVar.f71701b);
        } else if (!h.r.w(bVar.f71706g)) {
            e.c.a().k("delayinstall_file_lost", bVar.f71701b);
        } else if (a.a().i(bVar.f71703d)) {
            e.c.a().k("delayinstall_conflict_with_back_dialog", bVar.f71701b);
        } else {
            e.c.a().k("delayinstall_install_start", bVar.f71701b);
            d.l.a.e.a.e.t(l.a(), (int) bVar.f71700a);
        }
    }

    public void c(@NonNull DownloadInfo downloadInfo, long j, long j2, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{downloadInfo, Long.valueOf(j), Long.valueOf(j2), str, str2, str3, str4}) == null) {
            c.b bVar = new c.b(downloadInfo.getId(), j, j2, str, str2, str3, str4);
            d.l.a.e.b.j.a d2 = d.l.a.e.b.j.a.d(downloadInfo.getId());
            if (d2.b("back_miui_silent_install", 1) == 0 && ((d.l.a.e.a.h.e.p() || d.l.a.e.a.h.e.q()) && d.l.a.e.b.l.h.a(l.a(), "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"))) {
                if (d.l.a.e.b.l.f.Q(downloadInfo.getTempCacheData().get("extra_silent_install_succeed"), false)) {
                    Message obtainMessage = this.f71695a.obtainMessage(200, bVar);
                    obtainMessage.arg1 = 2;
                    this.f71695a.sendMessageDelayed(obtainMessage, d2.b("check_silent_install_interval", 60000));
                    return;
                }
                d.l.a.b.a.c.b u = c.g.e().u(bVar.f71701b);
                JSONObject jSONObject = new JSONObject();
                int i2 = -1;
                try {
                    jSONObject.put("ttdownloader_type", "miui_silent_install");
                    jSONObject.put("ttdownloader_message", "miui_silent_install_failed: has not started service");
                    i2 = 5;
                } catch (Exception unused) {
                }
                l.s().a(null, new BaseException(i2, jSONObject.toString()), i2);
                e.c.a().p("embeded_ad", "ah_result", jSONObject, u);
            }
            if (h.k.m()) {
                long currentTimeMillis = System.currentTimeMillis() - this.f71696b;
                long n = h.k.n();
                if (currentTimeMillis < h.k.p()) {
                    long p = h.k.p() - currentTimeMillis;
                    n += p;
                    this.f71696b = System.currentTimeMillis() + p;
                } else {
                    this.f71696b = System.currentTimeMillis();
                }
                h.s sVar = this.f71695a;
                sVar.sendMessageDelayed(sVar.obtainMessage(200, bVar), n);
            }
        }
    }

    @Override // d.l.a.d.h.s.a
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 200) {
            b((c.b) message.obj, message.arg1);
        }
    }
}
