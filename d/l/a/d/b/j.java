package d.l.a.d.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.l.a.d.b.c;
import d.l.a.d.d;
import d.l.a.e.a.e;
import d.l.a.e.b.j.a;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(@NonNull c.f fVar, boolean z, d.l.a.e.a.i iVar) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{fVar, Boolean.valueOf(z), iVar})) == null) {
            if (iVar == null || TextUtils.isEmpty(iVar.a0()) || iVar.S() == null) {
                return 0;
            }
            try {
                i2 = b(iVar, iVar.a0());
            } catch (Throwable th) {
                l.F().a(th, "redirectSavePathIfPossible");
                i2 = 4;
            }
            iVar.L(i2);
            if (i2 == 0) {
                iVar.E(new d.C2060d());
            }
            if (!iVar.N()) {
                iVar.E(new d.e());
            }
            int a2 = e.G().a(iVar);
            d.l.a.b.a.c.b c2 = c(fVar, a2);
            c.g.e().j(c2);
            c2.F0(a2);
            c2.K0(System.currentTimeMillis());
            c2.O0(0L);
            a g2 = a.g(iVar.R());
            if (!g(iVar, g2, a2) && fVar.f74225b.k()) {
                String H = fVar.f74225b.H();
                if (TextUtils.isEmpty(H)) {
                    H = g2.t("download_start_toast_text");
                }
                if (TextUtils.isEmpty(H)) {
                    H = z ? "已开始下载，可在\"我的\"里查看管理" : "已开始下载";
                }
                l.p().a(2, iVar.S(), fVar.f74225b, H, null, 0);
            }
            return a2;
        }
        return invokeCommon.intValue;
    }

    public static int b(d.l.a.e.a.i iVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, iVar, str)) == null) {
            a g2 = a.g(iVar.R());
            JSONObject u = g2.u("download_dir");
            if (u == null || TextUtils.isEmpty(u.optString("dir_name"))) {
                return -1;
            }
            String e0 = iVar.e0();
            String n = iVar.n();
            if (TextUtils.isEmpty(n)) {
                n = d.l.a.e.a.d.p(str, e0, iVar.G0(), true);
            }
            if (n.length() > 255) {
                n = n.substring(n.length() - 255);
            }
            if (TextUtils.isEmpty(e0)) {
                e0 = n;
            }
            String i0 = iVar.i0();
            if (TextUtils.isEmpty(i0)) {
                i0 = d.l.a.e.a.d.F();
            }
            String str2 = i0 + File.separator + d.l.a.e.a.d.o(e0, g2);
            DownloadInfo e2 = e.G().e(iVar.S(), str);
            if (e2 != null && e2.isSavePathRedirected()) {
                iVar.Y(e2.getSavePath());
                try {
                    iVar.J(new JSONObject(e2.getDownloadSettingString()));
                    return 0;
                } catch (Throwable unused) {
                    return 0;
                }
            } else if (e2 != null || !"application/vnd.android.package-archive".equalsIgnoreCase(e.G().g(n, iVar.G0()))) {
                return e2 != null ? 8 : 9;
            } else {
                int a2 = d.l.a.e.a.c.a(g2);
                if (a2 == 0) {
                    iVar.Y(str2);
                    return a2;
                }
                return a2;
            }
        }
        return invokeLL.intValue;
    }

    public static d.l.a.b.a.c.b c(c.f fVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, fVar, i2)) == null) {
            d.l.a.b.a.c.b bVar = new d.l.a.b.a.c.b(fVar.f74225b, fVar.f74226c, fVar.f74227d, i2);
            boolean z = true;
            if (a.d(i2).b("download_event_opt", 1) > 1) {
                try {
                    String v = fVar.f74225b.v();
                    if (!TextUtils.isEmpty(v)) {
                        if (l.a().getPackageManager().getPackageInfo(v, 0) == null) {
                            z = false;
                        }
                        bVar.M0(z);
                    }
                } catch (Throwable unused) {
                }
            }
            return bVar;
        }
        return (d.l.a.b.a.c.b) invokeLI.objValue;
    }

    public static String d(DownloadInfo downloadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, downloadInfo)) == null) {
            if (downloadInfo == null) {
                return null;
            }
            try {
                String extra = downloadInfo.getExtra();
                if (!TextUtils.isEmpty(extra)) {
                    return new JSONObject(extra).optString("notification_jump_url", null);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static boolean e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65540, null, i2)) == null) ? i2 == 0 || i2 == 1 : invokeI.booleanValue;
    }

    public static boolean f(d.l.a.a.a.d.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, dVar)) == null) ? dVar.t() && (dVar instanceof d.l.a.b.a.a.c) && dVar.A() == 1 : invokeL.booleanValue;
    }

    public static boolean g(d.l.a.e.a.i iVar, @NonNull a aVar, int i2) {
        InterceptResult invokeLLI;
        String optString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(AdIconUtil.BAIDU_LOGO_ID, null, iVar, aVar, i2)) == null) {
            JSONArray v = aVar.v("ah_plans");
            if (v != null && v.length() != 0) {
                int length = v.length();
                JSONObject jSONObject = null;
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        JSONObject optJSONObject = v.optJSONObject(i3);
                        if (optJSONObject != null && ((optString = optJSONObject.optString("type")) == "plan_c" || d.l.a.e.a.h.b.e(optJSONObject))) {
                            char c2 = 65535;
                            switch (optString.hashCode()) {
                                case -985763637:
                                    if (optString.equals("plan_a")) {
                                        c2 = 0;
                                        break;
                                    }
                                    break;
                                case -985763636:
                                    if (optString.equals("plan_b")) {
                                        c2 = 1;
                                        break;
                                    }
                                    break;
                                case -985763635:
                                    if (optString.equals("plan_c")) {
                                        c2 = 7;
                                        break;
                                    }
                                    break;
                                case -985763634:
                                    if (optString.equals("plan_d")) {
                                        c2 = 4;
                                        break;
                                    }
                                    break;
                                case -985763633:
                                    if (optString.equals("plan_e")) {
                                        c2 = 2;
                                        break;
                                    }
                                    break;
                                case -985763632:
                                    if (optString.equals("plan_f")) {
                                        c2 = 3;
                                        break;
                                    }
                                    break;
                                case -985763631:
                                    if (optString.equals("plan_g")) {
                                        c2 = 6;
                                        break;
                                    }
                                    break;
                                case -985763630:
                                    if (optString.equals("plan_h")) {
                                        c2 = 5;
                                        break;
                                    }
                                    break;
                            }
                            switch (c2) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                    if (d.l.a.e.a.c.b(optJSONObject, aVar).f74523b == 0) {
                                        break;
                                    } else {
                                        continue;
                                    }
                                case 6:
                                    if (d.l.a.e.a.c.v(optJSONObject, aVar).f74523b == 0) {
                                        break;
                                    } else {
                                        continue;
                                    }
                                case 7:
                                    jSONObject = optJSONObject;
                                    continue;
                            }
                        }
                        i3++;
                    }
                }
                if (jSONObject != null) {
                    if (jSONObject.optInt("show_unknown_source_on_startup") == 1) {
                        return d.l.a.e.a.c.o(d.l.a.e.b.g.e.n(), null, jSONObject, i2, new d.l.a.e.a.b());
                    }
                }
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public static boolean h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) ? i2 == 2 || i2 == 1 : invokeI.booleanValue;
    }

    public static boolean i(d.l.a.a.a.d.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, dVar)) == null) ? dVar != null && dVar.A() == 2 : invokeL.booleanValue;
    }
}
