package d.o.a.d.n;

import androidx.annotation.NonNull;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.d.f.c;
import d.o.a.d.f.n;
import d.o.a.e.a.j;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {
    public static JSONObject a(@NonNull JSONObject jSONObject, d.o.a.b.a.c.a aVar) {
        k.r(jSONObject, "open_url", k.m(aVar.f(), "open_url_not_exist"));
        return jSONObject;
    }

    public static void b(d.o.a.b.a.c.b bVar, JSONObject jSONObject) {
        if (jSONObject == null || bVar == null) {
            return;
        }
        try {
            jSONObject.put("is_patch_apply_handled", bVar.S() ? 1 : 0);
            jSONObject.put("origin_mime_type", bVar.R());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void c(DownloadInfo downloadInfo, JSONObject jSONObject) {
        try {
            g(downloadInfo, jSONObject);
            d.o.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
            if (c2 == null) {
                return;
            }
            jSONObject.put("is_update_download", c2.Q() ? 1 : 2);
            b(c2, jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void d(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return;
        }
        JSONArray v = d.o.a.e.b.j.a.d(i).v("ah_report_config");
        if (v != null) {
            for (int i2 = 0; i2 < v.length(); i2++) {
                try {
                    String string = v.getString(i2);
                    j.a d2 = d.o.a.e.a.c.d(string);
                    if (d2 != null) {
                        jSONObject.put(string, d2.m() + "_" + d2.n());
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        try {
            jSONObject.put("is_unknown_source_enabled", d.o.a.e.a.c.l(d.o.a.e.b.g.d.l()) ? 1 : 2);
        } catch (Throwable unused) {
        }
    }

    public static JSONObject e(@NonNull JSONObject jSONObject, d.o.a.b.a.c.a aVar) {
        k.r(jSONObject, d.o.a.e.a.h.c.k(), Integer.valueOf(k.z(n.a(), d.o.a.e.a.h.c.k())));
        return jSONObject;
    }

    public static void f(DownloadInfo downloadInfo, JSONObject jSONObject) {
        d.o.a.b.a.c.b c2;
        if (jSONObject == null || (c2 = c.g.e().c(downloadInfo)) == null) {
            return;
        }
        try {
            g(downloadInfo, jSONObject);
            jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - c2.O()));
            jSONObject.putOpt("click_download_size", Long.valueOf(c2.P()));
            jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.E()));
            jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.Q0()));
            c2.i1();
            c.j.b().c(c2);
            jSONObject.put("click_pause_times", c2.h1());
            long Q0 = downloadInfo.Q0();
            long E = downloadInfo.E();
            jSONObject.put("download_percent", (E < 0 || Q0 <= 0) ? 0.0d : E / Q0);
            jSONObject.put("download_status", downloadInfo.z0());
            long currentTimeMillis = System.currentTimeMillis();
            long C = c2.C();
            if (C > 0) {
                jSONObject.put("time_from_start_download", currentTimeMillis - C);
            }
            long w = c2.w();
            if (w > 0) {
                jSONObject.put("time_from_download_resume", currentTimeMillis - w);
            }
            jSONObject.putOpt("fail_status", Integer.valueOf(c2.z()));
            jSONObject.putOpt("fail_msg", c2.A());
            jSONObject.put("download_failed_times", c2.f1());
            jSONObject.put("can_show_notification", d.o.a.e.a.f.c.d() ? 1 : 2);
            jSONObject.put("first_speed_time", downloadInfo.X());
            jSONObject.put("all_connect_time", downloadInfo.r());
            jSONObject.put("download_prepare_time", downloadInfo.J());
            jSONObject.put("download_time", downloadInfo.y0() + downloadInfo.r() + downloadInfo.J());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void g(DownloadInfo downloadInfo, JSONObject jSONObject) {
        if (downloadInfo != null) {
            try {
                jSONObject.putOpt("total_bytes", Long.valueOf(downloadInfo.Q0()));
                jSONObject.putOpt("cur_bytes", Long.valueOf(downloadInfo.E()));
                jSONObject.putOpt("chunk_count", Integer.valueOf(downloadInfo.B()));
                jSONObject.putOpt(DpStatConstants.KEY_APP_NAME, downloadInfo.P0());
                jSONObject.putOpt("network_quality", downloadInfo.r0());
                jSONObject.putOpt("save_path", downloadInfo.F0());
                jSONObject.putOpt("file_name", downloadInfo.q0());
                jSONObject.putOpt("download_status", Integer.valueOf(downloadInfo.z0()));
                d.o.a.b.a.c.b b2 = c.g.e().b(downloadInfo.c0());
                if (b2 != null) {
                    jSONObject.putOpt("click_download_time", Long.valueOf(b2.O()));
                    jSONObject.putOpt("click_download_size", Long.valueOf(b2.P()));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        int i = 1;
        jSONObject.putOpt("permission_notification", Integer.valueOf(d.o.a.e.a.f.c.d() ? 1 : 2));
        jSONObject.putOpt("network_available", Integer.valueOf(d.o.a.e.b.l.e.p0(n.a()) ? 1 : 2));
        if (!d.o.a.e.b.l.e.d0(n.a())) {
            i = 2;
        }
        jSONObject.putOpt("network_is_wifi", Integer.valueOf(i));
    }
}
