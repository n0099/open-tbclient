package d.o.a.d.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.d.f.c;
import d.o.a.d.i;
import d.o.a.e.a.d;
import d.o.a.e.b.c.a;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class l {
    public static int a(@NonNull c.f fVar, boolean z, d.o.a.e.a.i iVar) {
        int i2;
        if (iVar == null || TextUtils.isEmpty(iVar.a0()) || iVar.S() == null) {
            return 0;
        }
        try {
            i2 = b(iVar, iVar.a0());
        } catch (Throwable th) {
            a.i("TAG", "redirectSavePathIfEmpty: throwable = " + th);
            i2 = 4;
        }
        iVar.N(i2);
        if (i2 == 0) {
            iVar.E(new i.c());
        }
        int a2 = d.o.a.e.a.e.F().a(iVar);
        d.o.a.b.a.c.b c2 = c(fVar, a2);
        c.g.e().j(c2);
        c2.D0(a2);
        c2.I0(System.currentTimeMillis());
        c2.M0(0L);
        d.o.a.e.b.j.a g2 = d.o.a.e.b.j.a.g(iVar.R());
        if (!g(iVar, g2, a2) && fVar.f70545b.k()) {
            String H = fVar.f70545b.H();
            if (TextUtils.isEmpty(H)) {
                H = g2.t("download_start_toast_text");
            }
            if (TextUtils.isEmpty(H)) {
                H = z ? "已开始下载，可在\"我的\"里查看管理" : "已开始下载";
            }
            n.n().a(2, iVar.S(), fVar.f70545b, H, null, 0);
        }
        return a2;
    }

    public static int b(d.o.a.e.a.i iVar, String str) {
        d.o.a.e.b.j.a g2 = d.o.a.e.b.j.a.g(iVar.R());
        JSONObject u = g2.u("download_dir");
        if (u == null || TextUtils.isEmpty(u.optString("dir_name"))) {
            return -1;
        }
        String e0 = iVar.e0();
        String n = iVar.n();
        if (TextUtils.isEmpty(n)) {
            n = d.p(str, e0, iVar.G0(), true);
        }
        if (n.length() > 255) {
            n = n.substring(n.length() - 255);
        }
        if (TextUtils.isEmpty(e0)) {
            e0 = n;
        }
        String i0 = iVar.i0();
        if (TextUtils.isEmpty(i0)) {
            i0 = d.F();
        }
        String str2 = i0 + File.separator + d.o(e0, g2);
        DownloadInfo e2 = d.o.a.e.a.e.F().e(iVar.S(), str);
        if (e2 != null && e2.O1()) {
            iVar.Y(e2.F0());
            try {
                iVar.L(new JSONObject(e2.K()));
                return 0;
            } catch (Throwable unused) {
                return 0;
            }
        } else if (e2 != null || !"application/vnd.android.package-archive".equalsIgnoreCase(d.o.a.e.a.e.F().g(n, iVar.G0()))) {
            return e2 != null ? 8 : 9;
        } else {
            int a2 = d.o.a.e.a.c.a(g2);
            if (a2 == 0) {
                iVar.Y(str2);
                return a2;
            }
            return a2;
        }
    }

    public static d.o.a.b.a.c.b c(c.f fVar, int i2) {
        d.o.a.b.a.c.b bVar = new d.o.a.b.a.c.b(fVar.f70545b, fVar.f70546c, fVar.f70547d, i2);
        boolean z = true;
        if (d.o.a.e.b.j.a.d(i2).b("download_event_opt", 1) > 1) {
            try {
                String v = fVar.f70545b.v();
                if (!TextUtils.isEmpty(v)) {
                    if (n.a().getPackageManager().getPackageInfo(v, 0) == null) {
                        z = false;
                    }
                    bVar.K0(z);
                }
            } catch (Throwable unused) {
            }
        }
        return bVar;
    }

    public static String d(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        try {
            String R = downloadInfo.R();
            if (!TextUtils.isEmpty(R)) {
                return new JSONObject(R).optString("notification_jump_url", null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public static boolean e(int i2) {
        return i2 == 0 || i2 == 1;
    }

    public static boolean f(d.o.a.a.a.c.d dVar) {
        return dVar.t() && (dVar instanceof d.o.a.b.a.a.c) && dVar.A() == 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0096, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean g(d.o.a.e.a.i iVar, @NonNull d.o.a.e.b.j.a aVar, int i2) {
        JSONArray v = aVar.v("ah_plans");
        if (v != null && v.length() != 0) {
            int length = v.length();
            JSONObject jSONObject = null;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    JSONObject optJSONObject = v.optJSONObject(i3);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("type");
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
                                    c2 = 6;
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
                                if (d.o.a.e.a.c.b(optJSONObject, aVar).f70802b == 0) {
                                    break;
                                } else {
                                    continue;
                                }
                            case 4:
                                if (d.o.a.e.a.c.H(optJSONObject).f70802b == 0) {
                                    break;
                                } else {
                                    continue;
                                }
                            case 5:
                                if (d.o.a.e.a.c.z(optJSONObject, aVar).f70802b == 0) {
                                    break;
                                } else {
                                    continue;
                                }
                            case 6:
                                jSONObject = optJSONObject;
                                continue;
                        }
                    }
                    i3++;
                }
            }
            if (jSONObject != null) {
                if (jSONObject.optInt("show_unknown_source_on_startup") == 1) {
                    return d.o.a.e.a.c.o(d.o.a.e.b.g.d.l(), null, jSONObject, i2, new d.o.a.e.a.b());
                }
            }
        }
        return false;
    }

    public static boolean h(int i2) {
        return i2 == 2 || i2 == 1;
    }

    public static boolean i(d.o.a.a.a.c.d dVar) {
        return dVar != null && dVar.A() == 2;
    }
}
