package d.o.a.d;

import android.content.pm.PackageInfo;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.pms.db.PackageTable;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.d.f.c;
import d.o.a.d.f.h;
import d.o.a.d.f.n;
import d.o.a.d.g;
import d.o.a.d.i;
import d.o.a.d.j;
import d.o.a.e.a.c;
import d.o.a.e.b.a.a;
import d.o.a.e.b.o.m;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e implements d.o.a.b.a.b, c.e, a.b {

    /* renamed from: g  reason: collision with root package name */
    public static String f70556g = "e";

    /* renamed from: h  reason: collision with root package name */
    public static volatile e f70557h;

    /* renamed from: e  reason: collision with root package name */
    public long f70558e;

    /* renamed from: f  reason: collision with root package name */
    public RunnableC1927e f70559f;

    /* loaded from: classes7.dex */
    public class a implements g.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.o.a.b.a.c.b f70574a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f70575b;

        public a(e eVar, d.o.a.b.a.c.b bVar, String str) {
            this.f70574a = bVar;
            this.f70575b = str;
        }

        @Override // d.o.a.d.g.h
        public void a(boolean z) {
            String str = e.f70556g;
            d.o.a.e.b.c.a.g(str, "appBackForeground->" + z);
            if (z) {
                if (!(g.C1936g.f(this.f70574a) ? g.b.i(this.f70575b, this.f70574a) : false) && g.C1936g.g(this.f70574a) && this.f70574a.F() == 4) {
                    d.o.a.d.f.a.a.a().f(this.f70574a);
                }
            } else if (g.b.i(this.f70575b, this.f70574a) || this.f70574a.F() != 4) {
            } else {
                d.o.a.d.f.a.a.a().f(this.f70574a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f70576e;

        public b(e eVar, long j) {
            this.f70576e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.d().h(this.f70576e);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f70577e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.o.a.b.a.c.b f70578f;

        public c(e eVar, String str, d.o.a.b.a.c.b bVar) {
            this.f70577e = str;
            this.f70578f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String b2 = d.o.a.d.n.a.b(this.f70577e);
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            n.a().getSharedPreferences("sp_ttdownloader_md5", 0).edit().putString(String.valueOf(this.f70578f.b()), b2).apply();
        }
    }

    @WorkerThread
    /* loaded from: classes7.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final int f70579e;

        public d(int i2) {
            this.f70579e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                c.g.e().q();
                ConcurrentHashMap<Long, d.o.a.b.a.c.b> t = c.g.e().t();
                if (t == null || t.isEmpty()) {
                    return;
                }
                e.this.r(t, this.f70579e);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: d.o.a.d.e$e  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class RunnableC1927e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public long f70581e;

        /* renamed from: f  reason: collision with root package name */
        public int f70582f;

        /* renamed from: g  reason: collision with root package name */
        public long f70583g;

        /* renamed from: h  reason: collision with root package name */
        public int f70584h;

        /* renamed from: i  reason: collision with root package name */
        public long f70585i;

        public /* synthetic */ RunnableC1927e(long j, int i2, long j2, int i3, a aVar) {
            this(j, i2, j2, i3);
        }

        public final int a(boolean z, d.o.a.b.a.c.b bVar, DownloadInfo downloadInfo, boolean z2, JSONObject jSONObject) {
            d.o.a.e.b.j.a d2 = d.o.a.e.b.j.a.d(downloadInfo.c0());
            int i2 = 1;
            if (d2.b("install_failed_check_ttmd5", 1) == 1) {
                int i3 = downloadInfo.i();
                try {
                    jSONObject.put("ttmd5_status", i3);
                } catch (Throwable unused) {
                }
                if (!d.o.a.e.b.l.e.E(i3)) {
                    return 2005;
                }
            }
            int i4 = this.f70584h;
            if (i4 != 2000) {
                return i4;
            }
            if (d2.b("install_failed_check_signature", 1) == 1 && d.o.a.d.n.k.I(n.a(), bVar.e())) {
                if (!d.o.a.d.n.k.y(d.o.a.d.n.k.O(n.a(), downloadInfo.K0()), d.o.a.d.n.k.N(n.a(), bVar.e()))) {
                    return 2006;
                }
            }
            if (z) {
                long j = this.f70585i;
                long j2 = this.f70583g;
                if (j > j2) {
                    try {
                        jSONObject.put("install_time", j - j2);
                        if (bVar.x() <= this.f70583g) {
                            i2 = 0;
                        }
                        jSONObject.put("install_again", i2);
                    } catch (Throwable unused2) {
                    }
                    return !z2 ? 2003 : 2004;
                }
                return 2000;
            }
            return 2002;
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0064, code lost:
            if (r9 < r1) goto L18;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean c() {
            DownloadInfo f2;
            double d2;
            JSONObject jSONObject;
            d.o.a.b.a.c.b u = c.g.e().u(this.f70581e);
            boolean z = false;
            if (u == null || d.o.a.d.n.k.D(u) || u.K.get() || (f2 = d.o.a.e.b.g.a.l(n.a()).f(u.s())) == null) {
                return false;
            }
            long H = u.H();
            long e2 = d.o.a.d.n.k.e(Environment.getDataDirectory());
            long min = Math.min(524288000L, e2 / 10);
            long Q0 = f2.Q0();
            double d3 = Q0;
            double d4 = min + (2.5d * d3);
            if (H <= -1 || Q0 <= -1) {
                d2 = d3;
            } else {
                d2 = d3;
            }
            z = true;
            boolean l = d.o.a.e.a.c.l(n.a());
            JSONObject jSONObject2 = new JSONObject();
            int a2 = a(z, u, f2, l, jSONObject2);
            this.f70584h = a2;
            try {
                jSONObject = jSONObject2;
            } catch (Exception e3) {
                e = e3;
                jSONObject = jSONObject2;
            }
            try {
                jSONObject.putOpt("fail_status", Integer.valueOf(a2));
                jSONObject.putOpt("available_space", Long.valueOf(H / 1048576));
                jSONObject.putOpt("total_space", Long.valueOf(e2 / 1048576));
                int i2 = (Q0 > 0L ? 1 : (Q0 == 0L ? 0 : -1));
                if (i2 > 0) {
                    jSONObject.putOpt("package_size", Long.valueOf(Q0 / 1048576));
                }
                jSONObject.putOpt("space_enough", Integer.valueOf(z ? 1 : 2));
                if (H > 0 && i2 > 0) {
                    jSONObject.put("available_space_ratio", H / d2);
                }
                jSONObject.putOpt("permission_unknown_source_install", Integer.valueOf(l ? 1 : 2));
                jSONObject.put("is_update_download", u.Q() ? 1 : 2);
            } catch (Exception e4) {
                e = e4;
                e.printStackTrace();
                j.c.a().t("install_failed", jSONObject, u);
                return true;
            }
            j.c.a().t("install_failed", jSONObject, u);
            return true;
        }

        public final void d() {
            this.f70585i = System.currentTimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (c()) {
                    e.d().i(this.f70581e, this.f70582f);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public RunnableC1927e(long j, int i2, long j2, int i3) {
            this.f70581e = j;
            this.f70582f = i2;
            this.f70583g = j2;
            this.f70584h = i3;
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final d.o.a.b.a.c.b f70586e;

        public f(d.o.a.b.a.c.b bVar) {
            this.f70586e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    this.f70586e.R0(true);
                    e.this.x(this.f70586e);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } finally {
                this.f70586e.R0(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h {
        public static boolean a(JSONArray jSONArray, String str) {
            if (jSONArray != null && !TextUtils.isEmpty(str)) {
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null && str.equals(optJSONObject.optString("type")) && b(optJSONObject)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public static boolean b(@NonNull JSONObject jSONObject) {
            return d.o.a.e.a.c.y(jSONObject) && d.o.a.e.a.c.v(jSONObject.optJSONArray("device_requirements")) && d.o.a.e.a.c.G(jSONObject);
        }
    }

    public e() {
        d.o.a.e.a.c.j(this);
        d.o.a.e.b.a.a.c().f(this);
    }

    public static e d() {
        if (f70557h == null) {
            synchronized (e.class) {
                if (f70557h == null) {
                    f70557h = new e();
                }
            }
        }
        return f70557h;
    }

    public static DownloadInfo e(List<DownloadInfo> list, String str) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null) {
                    if (str.equals(downloadInfo.v0())) {
                        return downloadInfo;
                    }
                    if (d.o.a.d.n.k.v(n.a(), downloadInfo.K0(), str)) {
                        return downloadInfo;
                    }
                }
            }
        }
        return null;
    }

    public static JSONObject g(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject != null && downloadInfo != null) {
            int i2 = 1;
            if (d.o.a.e.b.j.a.d(downloadInfo.c0()).b("download_event_opt", 1) == 0) {
                return jSONObject;
            }
            try {
                jSONObject.put("download_id", downloadInfo.c0());
                jSONObject.put("name", downloadInfo.q0());
                jSONObject.put("cur_bytes", downloadInfo.E());
                jSONObject.put("total_bytes", downloadInfo.Q0());
                jSONObject.put("network_quality", downloadInfo.r0());
                jSONObject.put("current_network_quality", m.a().d().name());
                jSONObject.put("only_wifi", downloadInfo.K1() ? 1 : 0);
                jSONObject.put("need_https_degrade", downloadInfo.B1() ? 1 : 0);
                jSONObject.put("https_degrade_retry_used", downloadInfo.x1() ? 1 : 0);
                jSONObject.put("chunk_count", downloadInfo.B());
                jSONObject.put("retry_count", downloadInfo.B0());
                jSONObject.put("cur_retry_time", downloadInfo.F());
                jSONObject.put("need_retry_delay", downloadInfo.E1() ? 1 : 0);
                jSONObject.put("backup_url_used", downloadInfo.e1() ? 1 : 0);
                jSONObject.put("head_connection_error_msg", downloadInfo.Z() != null ? downloadInfo.Z() : "");
                jSONObject.put("need_independent_process", downloadInfo.C1() ? 1 : 0);
                jSONObject.put("total_retry_count", downloadInfo.R0());
                jSONObject.put("cur_retry_time_in_total", downloadInfo.G());
                jSONObject.put("real_download_time", downloadInfo.y0());
                jSONObject.put("first_speed_time", downloadInfo.X());
                jSONObject.put("all_connect_time", downloadInfo.r());
                jSONObject.put("download_prepare_time", downloadInfo.J());
                jSONObject.put("download_time", downloadInfo.y0() + downloadInfo.r() + downloadInfo.J());
                jSONObject.put("chunk_downgrade_retry_used", downloadInfo.i1() ? 1 : 0);
                jSONObject.put("need_chunk_downgrade_retry", downloadInfo.z1() ? 1 : 0);
                jSONObject.put("failed_resume_count", downloadInfo.V());
                jSONObject.put("preconnect_level", downloadInfo.x0());
                jSONObject.put(PackageTable.MD5, downloadInfo.l0());
                jSONObject.put("expect_file_length", downloadInfo.Q());
                jSONObject.put("retry_schedule_count", downloadInfo.E0());
                jSONObject.put("rw_concurrent", downloadInfo.N1() ? 1 : 0);
                double E = downloadInfo.E() / 1048576.0d;
                double y0 = downloadInfo.y0() / 1000.0d;
                if (E > 0.0d && y0 > 0.0d) {
                    double d2 = E / y0;
                    try {
                        jSONObject.put("download_speed", d2);
                    } catch (Exception unused) {
                    }
                    String str = f70556g;
                    d.o.a.e.b.c.a.g(str, "download speed : " + d2 + "MB/s");
                }
                try {
                    jSONObject.put("is_download_service_foreground", d.o.a.e.b.g.a.l(n.a()).s(downloadInfo.c0()) ? 1 : 0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (downloadInfo.w() != null) {
                    jSONObject.put("backup_url_count", downloadInfo.w().size());
                    jSONObject.put("cur_backup_url_index", downloadInfo.D());
                }
                jSONObject.put("clear_space_restart_times", d.o.a.d.f.d.d.a().f(downloadInfo.T0()));
                jSONObject.put("mime_type", downloadInfo.m0());
                if (!d.o.a.e.b.l.e.p0(n.a())) {
                    i2 = 2;
                }
                jSONObject.put("network_available", i2);
                jSONObject.put("status_code", downloadInfo.a0());
                s(jSONObject, downloadInfo);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return jSONObject;
    }

    @WorkerThread
    public static synchronized void n(DownloadInfo downloadInfo, d.o.a.b.a.c.b bVar) {
        synchronized (e.class) {
            if (downloadInfo != null && bVar != null) {
                if (bVar.B() != 1) {
                    return;
                }
                i.C1939i.a().k(bVar);
                String w = w(downloadInfo, bVar);
                c.g.e().r(downloadInfo.T0(), w);
                Map<Long, d.o.a.b.a.c.b> f2 = c.g.e().f(downloadInfo.T0(), w);
                bVar.A0(System.currentTimeMillis());
                bVar.v0(2);
                bVar.l0(w);
                f2.put(Long.valueOf(bVar.b()), bVar);
                c.j.b().d(f2.values());
                t(bVar);
                k.b().i(downloadInfo, w);
                if ("application/vnd.android.package-archive".equals(downloadInfo.m0())) {
                    d().j(bVar);
                    d().u(downloadInfo, bVar);
                    if (bVar.G()) {
                        d.o.a.d.f.a.a.a().c(downloadInfo.c0(), bVar.b(), bVar.l(), w, downloadInfo.P0(), bVar.d(), downloadInfo.K0());
                    }
                    h.g.a(downloadInfo, bVar.b(), bVar.d(), w);
                }
                return;
            }
            d.o.a.d.n.k.B();
        }
    }

    public static JSONObject s(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject == null || downloadInfo == null || d.o.a.e.b.j.a.d(downloadInfo.c0()).b("download_event_opt", 1) == 0) {
            return jSONObject;
        }
        try {
            long d2 = d.o.a.d.n.k.d(0L);
            double d3 = d2;
            jSONObject.put("available_space", d3 / 1048576.0d);
            long Q0 = downloadInfo.Q0();
            double d4 = Q0;
            jSONObject.put("apk_size", d4 / 1048576.0d);
            if (d2 > 0 && Q0 > 0) {
                jSONObject.put("available_space_ratio", d3 / d4);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public static void t(d.o.a.b.a.c.b bVar) {
        if (bVar == null) {
            return;
        }
        String K = TextUtils.isEmpty(bVar.K()) ? "" : bVar.K();
        DownloadInfo f2 = d.o.a.e.b.g.a.l(n.a()).f(bVar.s());
        bVar.W0("");
        c.j.b().c(bVar);
        JSONObject jSONObject = new JSONObject();
        g(jSONObject, f2);
        int i2 = 1;
        try {
            jSONObject.putOpt("finish_reason", K);
            jSONObject.putOpt("finish_from_reserve_wifi", Integer.valueOf(f2.l1() ? 1 : 0));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        d.o.a.b.a.c.b c2 = c.g.e().c(f2);
        d.o.a.d.n.f.d(jSONObject, f2.c0());
        try {
            jSONObject.put("download_failed_times", c2.f1());
            jSONObject.put("can_show_notification", d.o.a.e.a.f.c.d() ? 1 : 2);
            if (f2.Q() > 0 && f2.Q0() > 0) {
                jSONObject.put("file_length_gap", f2.Q() - f2.Q0());
            }
            jSONObject.put("ttmd5_status", f2.J0());
            jSONObject.put("has_send_download_failed_finally", c2.L.get() ? 1 : 2);
            if (!c2.Q()) {
                i2 = 2;
            }
            jSONObject.put("is_update_download", i2);
            d.o.a.d.n.f.b(c2, jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        j.c.a().t("download_finish", jSONObject, bVar);
    }

    public static String w(@NonNull DownloadInfo downloadInfo, @NonNull d.o.a.b.a.c.b bVar) {
        File file = new File(downloadInfo.F0(), downloadInfo.q0());
        String str = null;
        if (file.exists()) {
            try {
                PackageInfo packageArchiveInfo = n.a().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), d.o.a.e.a.d.a());
                if (packageArchiveInfo != null) {
                    str = packageArchiveInfo.packageName;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str) && !str.equals(downloadInfo.v0())) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("real_package_name", str);
                jSONObject.put("input_package_name", downloadInfo.v0());
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            j.c.a().r("embeded_ad", "package_name_error", jSONObject, bVar);
            return str;
        }
        return downloadInfo.v0();
    }

    @Override // d.o.a.b.a.b
    public void a(int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f70558e < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
            return;
        }
        i.a().c(new d(i2), this.f70558e > 0 ? 2000L : 8000L);
        this.f70558e = currentTimeMillis;
    }

    public final int b(d.o.a.b.a.c.b bVar, DownloadInfo downloadInfo, String str, JSONObject jSONObject) {
        int E = d.o.a.e.a.d.E(n.a(), downloadInfo);
        int z = d.o.a.d.n.k.z(n.a(), str);
        if (E > 0 && z > 0 && E != z) {
            return z > E ? 3011 : 3010;
        } else if (d.o.a.e.b.j.a.d(bVar.s()).b("install_finish_check_ttmd5", 1) == 1) {
            String string = n.a().getSharedPreferences("sp_ttdownloader_md5", 0).getString(String.valueOf(bVar.b()), null);
            if (TextUtils.isEmpty(string) && downloadInfo != null) {
                string = d.o.a.d.n.a.b(downloadInfo.K0());
            }
            int a2 = d.o.a.d.n.a.a(string, d.o.a.d.n.a.e(str));
            try {
                jSONObject.put("ttmd5_status", a2);
            } catch (Throwable unused) {
            }
            if (a2 == 0) {
                return 3000;
            }
            return a2 == 1 ? 3002 : 3001;
        } else {
            return 3001;
        }
    }

    @Override // d.o.a.e.b.a.a.b
    public void c() {
        d.o.a.e.b.c.a.g(f70556g, "onAppBackground()");
        a(6);
    }

    public final JSONObject f(d.o.a.b.a.c.b bVar, String str, int i2) {
        d.o.a.e.a.b a2;
        JSONObject jSONObject = new JSONObject();
        try {
            DownloadInfo f2 = d.o.a.e.b.g.a.l(n.a()).f(bVar.s());
            jSONObject.putOpt("scene", Integer.valueOf(i2));
            d.o.a.d.n.f.d(jSONObject, bVar.s());
            d.o.a.d.n.f.b(bVar, jSONObject);
            jSONObject.put("is_update_download", bVar.Q() ? 1 : 2);
            jSONObject.put("install_after_back_app", bVar.b0() ? 1 : 2);
            jSONObject.putOpt("clean_space_install_params", bVar.M() ? "1" : "2");
            if (f2 != null) {
                g(jSONObject, f2);
                try {
                    jSONObject.put("uninstall_resume_count", f2.S0());
                    if (bVar.x() > 0) {
                        jSONObject.put("install_time", System.currentTimeMillis() - bVar.x());
                    }
                } catch (Throwable unused) {
                }
                String h2 = d.o.a.e.b.l.e.h(f2.L0().get("ah_attempt"), null);
                if (!TextUtils.isEmpty(h2) && (a2 = d.o.a.e.a.b.a(h2)) != null) {
                    a2.c(jSONObject);
                }
            }
            int b2 = b(bVar, f2, str, jSONObject);
            jSONObject.put("fail_status", b2);
            if (b2 == 3000) {
                jSONObject.put("hijack", 2);
            } else if (b2 == 3001) {
                jSONObject.put("hijack", 0);
            } else {
                jSONObject.put("hijack", 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public void h(long j) {
        c.e.b a2;
        int i2;
        try {
            d.o.a.b.a.c.b u = c.g.e().u(j);
            if (u != null && !d.o.a.d.n.k.D(u) && !u.K.get()) {
                Pair<c.e.b, Integer> e2 = c.e.b().e(u);
                if (e2 != null) {
                    a2 = (c.e.b) e2.first;
                    i2 = ((Integer) e2.second).intValue();
                } else {
                    a2 = c.e.b().a(u);
                    i2 = -1;
                }
                if (a2 == null) {
                    return;
                }
                c.e.b().g(a2.f70643a);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("installed_app_name", a2.f70646d);
                jSONObject.put("installed_pkg_name", a2.f70643a);
                if (i2 != -1) {
                    jSONObject.put("error_code", i2);
                    d.o.a.d.n.f.d(jSONObject, u.s());
                    j.c.a().t("install_finish_hijack", jSONObject, u);
                    return;
                }
                j.c.a().t("install_finish_may_hijack", jSONObject, u);
            }
        } catch (Throwable th) {
            d.o.a.d.n.k.q(th);
        }
    }

    public void i(long j, int i2) {
        long c2 = d.o.a.e.b.j.a.d(i2).c("check_install_finish_hijack_delay_time", 900000L);
        if (c2 < 0) {
            return;
        }
        i.a().c(new b(this, j), Math.max(c2, 300000L));
    }

    public void j(d.o.a.b.a.c.b bVar) {
        i.a().b(new f(bVar));
    }

    public void m(DownloadInfo downloadInfo, long j, long j2, long j3, long j4, long j5, boolean z) {
        d.o.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
        if (c2 == null) {
            d.o.a.d.n.k.B();
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("space_before", Double.valueOf(j / 1048576.0d));
            jSONObject.putOpt("space_cleaned", Double.valueOf((j2 - j) / 1048576.0d));
            jSONObject.putOpt("clean_up_time_cost", Long.valueOf(j4));
            jSONObject.putOpt("is_download_restarted", Integer.valueOf(z ? 1 : 0));
            jSONObject.putOpt("byte_required", Long.valueOf(j3));
            jSONObject.putOpt("byte_required_after", Double.valueOf((j3 - j2) / 1048576.0d));
            jSONObject.putOpt("clear_sleep_time", Long.valueOf(j5));
            d.o.a.d.n.f.g(downloadInfo, jSONObject);
            j.c.a().u("cleanup", jSONObject, c2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void o(DownloadInfo downloadInfo, d.o.a.b.a.c.b bVar, int i2) {
        long max;
        if (downloadInfo == null || bVar == null) {
            return;
        }
        z();
        long currentTimeMillis = System.currentTimeMillis();
        bVar.k0(currentTimeMillis);
        bVar.E0(d.o.a.d.n.k.f(Environment.getDataDirectory(), -1L));
        if (i2 != 2000) {
            max = 2000;
        } else {
            long c2 = d.o.a.e.b.j.a.d(downloadInfo.c0()).c("check_install_failed_delay_time", AppConfig.TIMESTAMP_AVAILABLE_DURATION);
            if (c2 < 0) {
                return;
            }
            max = Math.max(c2, 30000L);
        }
        long j = max;
        RunnableC1927e runnableC1927e = new RunnableC1927e(bVar.b(), downloadInfo.c0(), currentTimeMillis, i2, null);
        i.a().c(runnableC1927e, j);
        this.f70559f = runnableC1927e;
        c.j.b().c(bVar);
    }

    @WorkerThread
    public synchronized void p(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!d.o.a.d.n.k.s()) {
            d.o.a.b.a.c.b d2 = c.g.e().d(str);
            if (d2 == null) {
                c.e.b().c(str);
                return;
            }
            d.o.a.d.f.i a2 = k.b().a(d2.a());
            if (a2 != null) {
                a2.x();
            }
            if (d2.K.get()) {
                return;
            }
            if (d.o.a.e.b.j.a.d(d2.s()).m("notification_opt_2") == 1) {
                d.o.a.e.b.p.b.a().m(d2.s());
            }
            new g.c().a(d2, new a(this, d2, str), d.o.a.d.n.e.c(d2).b("try_applink_delay_after_installed", 0));
            i.C1939i.a().m(d2);
            q(str, d2);
            d.o.a.d.f.a.a.a().j(str);
            DownloadInfo e2 = e(d.o.a.e.b.g.a.l(n.a()).o("application/vnd.android.package-archive"), str);
            if (e2 != null) {
                if (d.o.a.e.b.j.a.d(e2.c0()).m("no_hide_notification") != 1) {
                    d.o.a.e.b.p.b.a().b(e2.c0());
                }
                k.b().p(e2, str);
                d.o.a.d.f.d.d.c(e2);
            } else {
                k.b().p(null, str);
            }
            return;
        }
        throw new RuntimeException("handleAppInstalled in main thread.");
    }

    public void q(String str, d.o.a.b.a.c.b bVar) {
        if (bVar != null && d.o.a.d.n.k.D(bVar) && bVar.K.compareAndSet(false, true)) {
            j.c.a().r(bVar.j(), "install_finish", f(bVar, str, bVar.F() != 4 ? 3 : 4), bVar);
            c.j.b().c(bVar);
        }
    }

    @WorkerThread
    public final void r(@NonNull ConcurrentHashMap<Long, d.o.a.b.a.c.b> concurrentHashMap, int i2) {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        for (d.o.a.b.a.c.b bVar : concurrentHashMap.values()) {
            if (bVar.K.get()) {
                if (currentTimeMillis - bVar.C() >= d.o.a.e.b.j.a.d(bVar.s()).b("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(bVar.b()));
                }
            } else if (bVar.B() == 1) {
                if (y(bVar) <= 0 && currentTimeMillis - bVar.C() >= d.o.a.e.b.j.a.d(bVar.s()).b("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(bVar.b()));
                }
            } else if (bVar.B() == 2) {
                if (!bVar.T()) {
                    if (d.o.a.d.n.k.D(bVar)) {
                        if (bVar.F() == 4) {
                            i2 = bVar.F();
                        }
                        j.c.a().w(f(bVar, bVar.e(), i2), bVar);
                        arrayList.add(Long.valueOf(bVar.b()));
                        d.o.a.d.f.d.d.b(bVar);
                    } else if (currentTimeMillis - bVar.C() >= d.o.a.e.b.j.a.d(bVar.s()).b("finish_event_expire_hours", 168) * 60 * 60 * 1000) {
                        arrayList.add(Long.valueOf(bVar.b()));
                    } else if (TextUtils.isEmpty(bVar.e())) {
                        arrayList.add(Long.valueOf(bVar.b()));
                    }
                }
            } else {
                arrayList.add(Long.valueOf(bVar.b()));
            }
        }
        c.g.e().k(arrayList);
    }

    public void u(DownloadInfo downloadInfo, d.o.a.b.a.c.b bVar) {
        if (downloadInfo == null || bVar == null || d.o.a.e.b.j.a.d(downloadInfo.c0()).b("install_finish_check_ttmd5", 1) == 0) {
            return;
        }
        String K0 = downloadInfo.K0();
        if (TextUtils.isEmpty(K0)) {
            return;
        }
        i.a().f(new c(this, K0, bVar));
    }

    public final void v(@NonNull DownloadInfo downloadInfo, d.o.a.e.a.b bVar) {
        d.o.a.b.a.c.b c2 = c.g.e().c(downloadInfo);
        if (c2 == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        bVar.c(jSONObject);
        try {
            jSONObject.put("download_id", downloadInfo.c0());
            jSONObject.put("name", downloadInfo.q0());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        d.o.a.d.n.f.d(jSONObject, downloadInfo.c0());
        j.c.a().r("embeded_ad", "ah_result", jSONObject, c2);
    }

    @WorkerThread
    public final void x(d.o.a.b.a.c.b bVar) {
        SystemClock.sleep(20000L);
        int i2 = 15;
        while (i2 > 0) {
            if (d.o.a.d.n.k.D(bVar)) {
                p(bVar.e());
                return;
            }
            i2--;
            if (i2 == 0) {
                return;
            }
            SystemClock.sleep(20000L);
        }
    }

    public final int y(d.o.a.b.a.c.b bVar) {
        int z0;
        double a2 = d.o.a.e.b.j.a.d(bVar.s()).a("download_failed_finally_hours", 48.0d);
        if (a2 <= 0.0d) {
            return -1;
        }
        if (System.currentTimeMillis() - bVar.C() < a2 * 60.0d * 60.0d * 1000.0d) {
            return 1;
        }
        if (bVar.L.get()) {
            return 0;
        }
        DownloadInfo f2 = d.o.a.e.b.g.a.l(n.a()).f(bVar.s());
        if (f2 == null || (z0 = f2.z0()) == -3 || z0 == -4) {
            return -1;
        }
        if (!d.o.a.e.b.d.a.b(z0) && bVar.L.compareAndSet(false, true)) {
            try {
                JSONObject jSONObject = new JSONObject();
                g(jSONObject, f2);
                jSONObject.putOpt("download_status", Integer.valueOf(z0));
                jSONObject.putOpt("fail_status", Integer.valueOf(bVar.z()));
                jSONObject.putOpt("fail_msg", bVar.A());
                jSONObject.put("download_failed_times", bVar.f1());
                if (f2.Q0() > 0) {
                    jSONObject.put("download_percent", f2.E() / f2.Q0());
                }
                jSONObject.put("is_update_download", bVar.Q() ? 1 : 2);
                j.c.a().r(bVar.j(), "download_failed_finally", jSONObject, bVar);
                c.j.b().c(bVar);
                return 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return 1;
    }

    public synchronized void z() {
        RunnableC1927e runnableC1927e = this.f70559f;
        if (runnableC1927e != null) {
            runnableC1927e.d();
            this.f70559f = null;
        }
    }

    @Override // d.o.a.e.a.c.e
    public void a(DownloadInfo downloadInfo, d.o.a.e.a.b bVar) {
        if (downloadInfo == null || bVar == null || d.o.a.e.b.j.a.d(downloadInfo.c0()).u("ah_report_config") == null) {
            return;
        }
        v(downloadInfo, bVar);
    }

    @Override // d.o.a.e.b.a.a.b
    public void b() {
        d.o.a.e.b.c.a.g(f70556g, "onAppForeground()");
        z();
        a(5);
    }
}
