package com.ss.android.downloadlib;

import android.content.pm.PackageInfo;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.fun.ad.sdk.FunAdConfig;
import com.ss.android.downloadlib.a.b.c;
import com.ss.android.downloadlib.a.j;
import com.ss.android.socialbase.appdownloader.b;
import com.ss.android.socialbase.downloader.a.a;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements com.ss.android.b.a.a, b.c, a.InterfaceC1233a {

    /* renamed from: a  reason: collision with root package name */
    private static String f12968a = b.class.getSimpleName();
    private static volatile b qbg;

    /* renamed from: b  reason: collision with root package name */
    private long f12969b;
    private RunnableC1223b qbf;

    private b() {
        com.ss.android.socialbase.appdownloader.b.a(this);
        com.ss.android.socialbase.downloader.a.a.eFY().a(this);
    }

    public static b eEw() {
        if (qbg == null) {
            synchronized (b.class) {
                if (qbg == null) {
                    qbg = new b();
                }
            }
        }
        return qbg;
    }

    @WorkerThread
    public static synchronized void a(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.b.a.b.a aVar) {
        synchronized (b.class) {
            if (cVar == null || aVar == null) {
                com.ss.android.downloadlib.f.i.b();
            } else if (aVar.l() == 1) {
                String c2 = c(cVar, aVar);
                com.ss.android.downloadlib.a.b.d.eEB().b(cVar.j(), c2);
                Map<Long, com.ss.android.b.a.b.a> K = com.ss.android.downloadlib.a.b.d.eEB().K(cVar.j(), c2);
                aVar.f(System.currentTimeMillis());
                aVar.e(2);
                aVar.b(c2);
                K.put(Long.valueOf(aVar.j()), aVar);
                com.ss.android.downloadlib.a.b.g.eEE().a(K.values());
                a(aVar);
                h.eFl().a(cVar, c2);
                if ("application/vnd.android.package-archive".equals(cVar.eHn())) {
                    eEw().d(aVar);
                    eEw().b(cVar, aVar);
                    if (aVar.w()) {
                        com.ss.android.downloadlib.a.a.a.eEy().a(cVar.g(), aVar.j(), aVar.k(), c2, cVar.i(), aVar.o(), cVar.n());
                    }
                    com.ss.android.downloadlib.a.d.a.a(cVar, aVar.j(), aVar.o(), c2);
                }
            }
        }
    }

    @WorkerThread
    public synchronized void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.ss.android.downloadlib.f.i.a()) {
                throw new RuntimeException("handleAppInstalled in main thread.");
            }
            com.ss.android.b.a.b.a aaS = com.ss.android.downloadlib.a.b.d.eEB().aaS(str);
            if (aaS == null) {
                com.ss.android.downloadlib.a.b.c.eEA().a(str);
            } else {
                com.ss.android.downloadlib.a.f aaZ = h.eFl().aaZ(aaS.z());
                if (aaZ != null) {
                    aaZ.e();
                }
                if (!aaS.f12922a.get()) {
                    a(str, aaS);
                    if (!com.ss.android.downloadlib.b.a.b(str, aaS) && aaS.v() == 4) {
                        com.ss.android.downloadlib.a.a.a.eEy().a(aaS.j());
                    }
                    com.ss.android.downloadlib.a.a.a.eEy().b(str);
                    com.ss.android.socialbase.downloader.g.c t = t(com.ss.android.socialbase.downloader.downloader.f.iB(j.a()).b("application/vnd.android.package-archive"), str);
                    if (t != null) {
                        if (com.ss.android.socialbase.downloader.k.a.RW(t.g()).b("no_hide_notification") != 1) {
                            com.ss.android.socialbase.downloader.notification.b.eIJ().a(t.g());
                        }
                        h.eFl().b(t, str);
                        com.ss.android.downloadlib.a.c.d.a(t);
                    } else {
                        h.eFl().b(null, str);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.b.a.b.a aVar, int i) {
        long max;
        if (cVar != null && aVar != null) {
            d();
            long currentTimeMillis = System.currentTimeMillis();
            aVar.b(currentTimeMillis);
            aVar.g(com.ss.android.downloadlib.f.i.a(Environment.getDataDirectory()));
            if (i != 2000) {
                max = 2000;
            } else {
                long a2 = com.ss.android.socialbase.downloader.k.a.RW(cVar.g()).a("check_install_failed_delay_time", 120000L);
                if (a2 >= 0) {
                    max = Math.max(a2, 30000L);
                } else {
                    return;
                }
            }
            RunnableC1223b runnableC1223b = new RunnableC1223b(aVar.j(), cVar.g(), currentTimeMillis, i);
            f.eFh().a(runnableC1223b, max);
            this.qbf = runnableC1223b;
            com.ss.android.downloadlib.a.b.g.eEE().d(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.downloadlib.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class RunnableC1223b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private long f12973a;

        /* renamed from: b  reason: collision with root package name */
        private int f12974b;
        private long c;
        private int d;
        private long e;

        private RunnableC1223b(long j, int i, long j2, int i2) {
            this.f12973a = j;
            this.f12974b = i;
            this.c = j2;
            this.d = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.e = System.currentTimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (a()) {
                    b.eEw().a(this.f12973a, this.f12974b);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        boolean a() {
            com.ss.android.socialbase.downloader.g.c h;
            com.ss.android.b.a.b.a je = com.ss.android.downloadlib.a.b.d.eEB().je(this.f12973a);
            if (je == null || com.ss.android.downloadlib.f.i.i(je) || je.f12922a.get() || (h = com.ss.android.socialbase.downloader.downloader.f.iB(j.a()).h(je.t())) == null) {
                return false;
            }
            long eEp = je.eEp();
            long b2 = com.ss.android.downloadlib.f.i.b(Environment.getDataDirectory());
            long min = Math.min(524288000L, b2 / 10);
            long eir = h.eir();
            boolean z = true;
            if (eEp > -1 && eir > -1 && eEp < min + (eir * 2.5d)) {
                z = false;
            }
            boolean a2 = com.ss.android.socialbase.appdownloader.b.a(j.a());
            JSONObject jSONObject = new JSONObject();
            this.d = a(z, je, h, a2, jSONObject);
            try {
                jSONObject.putOpt("fail_status", Integer.valueOf(this.d));
                jSONObject.putOpt("available_space", Long.valueOf(eEp / 1048576));
                jSONObject.putOpt("total_space", Long.valueOf(b2 / 1048576));
                if (eir > 0) {
                    jSONObject.putOpt("package_size", Long.valueOf(eir / 1048576));
                }
                jSONObject.putOpt("space_enough", Integer.valueOf(z ? 1 : 2));
                if (eEp > 0 && eir > 0) {
                    jSONObject.put("available_space_ratio", eEp / eir);
                }
                jSONObject.putOpt("permission_unknown_source_install", Integer.valueOf(a2 ? 1 : 2));
                jSONObject.put("is_update_download", je.I() ? 1 : 2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            com.ss.android.downloadlib.e.a.eFk().a("install_failed", jSONObject, je);
            return true;
        }

        private int a(boolean z, com.ss.android.b.a.b.a aVar, com.ss.android.socialbase.downloader.g.c cVar, boolean z2, JSONObject jSONObject) {
            com.ss.android.socialbase.downloader.k.a RW = com.ss.android.socialbase.downloader.k.a.RW(cVar.g());
            if (RW.a("install_failed_check_ttmd5", 1) == 1) {
                int eHS = cVar.eHS();
                try {
                    jSONObject.put("ttmd5_status", eHS);
                } catch (Throwable th) {
                }
                if (!com.ss.android.socialbase.downloader.m.d.a(eHS)) {
                    return 2005;
                }
            }
            if (this.d != 2000) {
                return this.d;
            }
            if (RW.a("install_failed_check_signature", 1) == 1 && com.ss.android.downloadlib.f.i.d(j.a(), aVar.m())) {
                if (!com.ss.android.downloadlib.f.i.b(com.ss.android.downloadlib.f.i.bD(j.a(), cVar.n()), com.ss.android.downloadlib.f.i.bC(j.a(), aVar.m()))) {
                    return 2006;
                }
            }
            if (!z) {
                return 2002;
            }
            if (this.e > this.c) {
                try {
                    jSONObject.put("install_time", this.e - this.c);
                    jSONObject.put("install_again", aVar.f() > this.c ? 1 : 0);
                } catch (Throwable th2) {
                }
                if (!z2) {
                    return 2003;
                }
                return 2004;
            }
            return 2000;
        }
    }

    public void a(final long j, int i) {
        long a2 = com.ss.android.socialbase.downloader.k.a.RW(i).a("check_install_finish_hijack_delay_time", FunAdConfig.Builder.AD_EXPIRED_INTERVAL);
        if (a2 >= 0) {
            f.eFh().a(new Runnable() { // from class: com.ss.android.downloadlib.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.eEw().a(j);
                }
            }, Math.max(a2, 300000L));
        }
    }

    public void a(long j) {
        c.a e;
        int i;
        try {
            com.ss.android.b.a.b.a je = com.ss.android.downloadlib.a.b.d.eEB().je(j);
            if (je != null && !com.ss.android.downloadlib.f.i.i(je) && !je.f12922a.get()) {
                Pair<c.a, Integer> f = com.ss.android.downloadlib.a.b.c.eEA().f(je);
                if (f != null) {
                    e = (c.a) f.first;
                    i = ((Integer) f.second).intValue();
                } else {
                    e = com.ss.android.downloadlib.a.b.c.eEA().e(je);
                    i = -1;
                }
                if (e != null) {
                    com.ss.android.downloadlib.a.b.c.eEA().b(e.f12936a);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("installed_app_name", e.d);
                    jSONObject.put("installed_pkg_name", e.f12936a);
                    if (i != -1) {
                        jSONObject.put("error_code", i);
                        com.ss.android.downloadlib.f.e.a(jSONObject, je.t());
                        com.ss.android.downloadlib.guide.install.c.a();
                        com.ss.android.downloadlib.e.a.eFk().a("install_finish_hijack", jSONObject, je);
                        return;
                    }
                    com.ss.android.downloadlib.e.a.eFk().a("install_finish_may_hijack", jSONObject, je);
                }
            }
        } catch (Throwable th) {
            com.ss.android.downloadlib.f.i.a(th);
        }
    }

    public void a(String str, com.ss.android.b.a.b.a aVar) {
        if (aVar != null && com.ss.android.downloadlib.f.i.i(aVar) && aVar.f12922a.compareAndSet(false, true)) {
            com.ss.android.downloadlib.e.a.eFk().a(aVar.x(), "install_finish", a(aVar, str, aVar.v() != 4 ? 3 : 4), aVar);
            com.ss.android.downloadlib.a.b.g.eEE().d(aVar);
        }
    }

    private static com.ss.android.socialbase.downloader.g.c t(List<com.ss.android.socialbase.downloader.g.c> list, String str) {
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        for (com.ss.android.socialbase.downloader.g.c cVar : list) {
            if (cVar != null) {
                if (!str.equals(cVar.D())) {
                    if (com.ss.android.downloadlib.f.i.a(j.a(), cVar.n(), str)) {
                        return cVar;
                    }
                } else {
                    return cVar;
                }
            }
        }
        return null;
    }

    public static JSONObject a(JSONObject jSONObject, com.ss.android.socialbase.downloader.g.c cVar, boolean z) {
        if (jSONObject != null && cVar != null && com.ss.android.socialbase.downloader.k.a.RW(cVar.g()).a("download_event_opt", 1) != 0) {
            try {
                jSONObject.put("download_id", cVar.g());
                jSONObject.put("name", cVar.h());
                jSONObject.put("url", cVar.j());
                jSONObject.put("cur_bytes", cVar.eHi());
                jSONObject.put("total_bytes", cVar.eir());
                jSONObject.put("network_quality", cVar.eHk());
                jSONObject.put("current_network_quality", com.ss.android.socialbase.downloader.i.j.eIw().eIx().name());
                jSONObject.put("only_wifi", cVar.x() ? 1 : 0);
                jSONObject.put("need_https_degrade", cVar.eHo() ? 1 : 0);
                jSONObject.put("https_degrade_retry_used", cVar.t() ? 1 : 0);
                jSONObject.put("chunk_count", cVar.eHU());
                jSONObject.put(DownloadDataConstants.Columns.COLUMN_RETRY_COUNT, cVar.J());
                jSONObject.put("cur_retry_time", cVar.ax());
                jSONObject.put("need_retry_delay", cVar.eHp() ? 1 : 0);
                jSONObject.put("backup_url_used", cVar.P() ? 1 : 0);
                jSONObject.put("head_connection_error_msg", cVar.c() != null ? cVar.c() : "");
                jSONObject.put("need_independent_process", cVar.ae() ? 1 : 0);
                jSONObject.put("total_retry_count", cVar.eHc());
                jSONObject.put("cur_retry_time_in_total", cVar.up());
                jSONObject.put("real_download_time", cVar.eHC());
                jSONObject.put("first_speed_time", cVar.eos());
                jSONObject.put("all_connect_time", cVar.eHa());
                jSONObject.put("download_prepare_time", cVar.eEp());
                jSONObject.put("download_time", cVar.eHC() + cVar.eHa() + cVar.eEp());
                jSONObject.put("chunk_downgrade_retry_used", cVar.eHv() ? 1 : 0);
                jSONObject.put("need_chunk_downgrade_retry", cVar.eHu() ? 1 : 0);
                jSONObject.put("failed_resume_count", cVar.eHX());
                jSONObject.put("preconnect_level", cVar.eId());
                jSONObject.put("md5", cVar.F());
                jSONObject.put("expect_file_length", cVar.eEq());
                jSONObject.put("retry_schedule_count", cVar.eHe());
                jSONObject.put("rw_concurrent", cVar.uv() ? 1 : 0);
                double eHi = cVar.eHi() / 1048576.0d;
                double eHC = cVar.eHC() / 1000.0d;
                if (eHi > 0.0d && eHC > 0.0d) {
                    double d = eHi / eHC;
                    try {
                        jSONObject.put("download_speed", d);
                    } catch (Exception e) {
                    }
                    com.ss.android.socialbase.downloader.f.a.b(f12968a, "download speed : " + d + "MB/s");
                }
                try {
                    jSONObject.put("is_download_service_foreground", com.ss.android.socialbase.downloader.downloader.f.iB(j.a()).Rr(cVar.g()) ? 1 : 0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (cVar.eHH() != null) {
                    jSONObject.put("backup_url_count", cVar.eHH().size());
                    jSONObject.put("cur_backup_url_index", cVar.s());
                }
                jSONObject.put("clear_space_restart_times", com.ss.android.downloadlib.a.c.d.eEG().b(cVar.j()));
                jSONObject.put("mime_type", cVar.eHn());
                jSONObject.put(AlaRecorderLog.KEY_NETWORK_AVAILABLE, com.ss.android.socialbase.downloader.m.d.b(j.a()) ? 1 : 2);
                jSONObject.put("status_code", cVar.aq());
                a(jSONObject, cVar);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static JSONObject a(JSONObject jSONObject, com.ss.android.socialbase.downloader.g.c cVar) {
        if (jSONObject != null && cVar != null && com.ss.android.socialbase.downloader.k.a.RW(cVar.g()).a("download_event_opt", 1) != 0) {
            try {
                long a2 = com.ss.android.downloadlib.f.i.a(Environment.getExternalStorageDirectory());
                jSONObject.put("available_space", a2 / 1048576.0d);
                long eir = cVar.eir();
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_SIZE, eir / 1048576.0d);
                if (a2 > 0 && eir > 0) {
                    jSONObject.put("available_space_ratio", a2 / eir);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return jSONObject;
    }

    public void b(com.ss.android.socialbase.downloader.g.c cVar, final com.ss.android.b.a.b.a aVar) {
        if (cVar != null && aVar != null && com.ss.android.socialbase.downloader.k.a.RW(cVar.g()).a("install_finish_check_ttmd5", 1) != 0) {
            final String n = cVar.n();
            if (!TextUtils.isEmpty(n)) {
                f.eFh().b(new Runnable() { // from class: com.ss.android.downloadlib.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        String a2 = com.ss.android.downloadlib.f.a.a(n);
                        if (!TextUtils.isEmpty(a2)) {
                            j.a().getSharedPreferences("sp_ttdownloader_md5", 0).edit().putString(String.valueOf(aVar.j()), a2).apply();
                        }
                    }
                });
            }
        }
    }

    private static void a(com.ss.android.b.a.b.a aVar) {
        if (aVar != null) {
            String E = TextUtils.isEmpty(aVar.E()) ? "" : aVar.E();
            com.ss.android.socialbase.downloader.g.c h = com.ss.android.socialbase.downloader.downloader.f.iB(j.a()).h(aVar.t());
            aVar.j("");
            com.ss.android.downloadlib.a.b.g.eEE().d(aVar);
            JSONObject a2 = a(new JSONObject(), h, false);
            try {
                a2.putOpt("finish_reason", E);
                a2.putOpt("finish_from_reserve_wifi", Integer.valueOf(h.T() ? 1 : 0));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            com.ss.android.b.a.b.a j = com.ss.android.downloadlib.a.b.d.eEB().j(h);
            com.ss.android.downloadlib.f.e.a(a2, h.g());
            try {
                a2.put("download_failed_times", j.a());
                a2.put("can_show_notification", com.ss.android.socialbase.appdownloader.e.d.a() ? 1 : 2);
                if (h.eEq() > 0 && h.eir() > 0) {
                    a2.put("file_length_gap", h.eEq() - h.eir());
                }
                a2.put("ttmd5_status", h.z());
                a2.put("has_send_download_failed_finally", j.f12923b.get() ? 1 : 2);
                a2.put("is_update_download", j.I() ? 1 : 2);
                com.ss.android.downloadlib.f.e.a(j, a2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            com.ss.android.downloadlib.e.a.eFk().a(a2, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void b(com.ss.android.b.a.b.a aVar) {
        int i = 15;
        SystemClock.sleep(20000L);
        while (i > 0) {
            if (com.ss.android.downloadlib.f.i.i(aVar)) {
                a(aVar.m());
                return;
            }
            i--;
            if (i != 0) {
                SystemClock.sleep(20000L);
            } else {
                return;
            }
        }
    }

    private int a(com.ss.android.b.a.b.a aVar, com.ss.android.socialbase.downloader.g.c cVar, String str, JSONObject jSONObject) {
        int c2 = com.ss.android.socialbase.appdownloader.c.c(j.a(), cVar);
        int b2 = com.ss.android.downloadlib.f.i.b(j.a(), str);
        if (c2 > 0 && b2 > 0 && c2 != b2) {
            return b2 > c2 ? 3011 : 3010;
        }
        if (com.ss.android.socialbase.downloader.k.a.RW(aVar.t()).a("install_finish_check_ttmd5", 1) == 1) {
            String string = j.a().getSharedPreferences("sp_ttdownloader_md5", 0).getString(String.valueOf(aVar.j()), null);
            if (TextUtils.isEmpty(string) && cVar != null) {
                string = com.ss.android.downloadlib.f.a.a(cVar.n());
            }
            int a2 = com.ss.android.downloadlib.f.a.a(string, com.ss.android.downloadlib.f.a.b(str));
            try {
                jSONObject.put("ttmd5_status", a2);
            } catch (Throwable th) {
            }
            if (a2 == 0) {
                return 3000;
            }
            if (a2 == 1) {
                return 3002;
            }
        }
        return 3001;
    }

    public static String c(@NonNull com.ss.android.socialbase.downloader.g.c cVar, @NonNull com.ss.android.b.a.b.a aVar) {
        String str = null;
        File file = new File(cVar.k(), cVar.h());
        if (file.exists()) {
            try {
                PackageInfo packageArchiveInfo = j.a().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), com.ss.android.socialbase.appdownloader.c.a());
                if (packageArchiveInfo != null) {
                    str = packageArchiveInfo.packageName;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str) && !str.equals(cVar.D())) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("real_package_name", str);
                jSONObject.put("input_package_name", cVar.D());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            com.ss.android.downloadlib.e.a.eFk().a("embeded_ad", "package_name_error", jSONObject, aVar);
            return str;
        }
        return cVar.D();
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC1233a
    public void b() {
        d();
        a(5);
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC1233a
    public void c() {
        a(6);
    }

    synchronized void d() {
        RunnableC1223b runnableC1223b = this.qbf;
        if (runnableC1223b != null) {
            runnableC1223b.b();
            this.qbf = null;
        }
    }

    @Override // com.ss.android.b.a.a
    public void a(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f12969b >= 120000) {
            f.eFh().a(new a(i), this.f12969b > 0 ? 2000L : 8000L);
            this.f12969b = currentTimeMillis;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void a(@NonNull ConcurrentHashMap<Long, com.ss.android.b.a.b.a> concurrentHashMap, int i) {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        for (com.ss.android.b.a.b.a aVar : concurrentHashMap.values()) {
            if (aVar.f12922a.get()) {
                if (currentTimeMillis - aVar.n() >= com.ss.android.socialbase.downloader.k.a.RW(aVar.t()).a("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(aVar.j()));
                }
            } else if (aVar.l() == 1) {
                if (c(aVar) <= 0 && currentTimeMillis - aVar.n() >= com.ss.android.socialbase.downloader.k.a.RW(aVar.t()).a("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(aVar.j()));
                }
            } else if (aVar.l() == 2) {
                if (!aVar.L()) {
                    if (com.ss.android.downloadlib.f.i.i(aVar)) {
                        if (aVar.v() == 4) {
                            i = aVar.v();
                        }
                        com.ss.android.downloadlib.e.a.eFk().b(a(aVar, aVar.m(), i), aVar);
                        arrayList.add(Long.valueOf(aVar.j()));
                        com.ss.android.downloadlib.a.c.d.d(aVar);
                    } else if (currentTimeMillis - aVar.n() >= com.ss.android.socialbase.downloader.k.a.RW(aVar.t()).a("finish_event_expire_hours", 168) * 60 * 60 * 1000) {
                        arrayList.add(Long.valueOf(aVar.j()));
                    } else if (TextUtils.isEmpty(aVar.m())) {
                        arrayList.add(Long.valueOf(aVar.j()));
                    }
                }
            } else {
                arrayList.add(Long.valueOf(aVar.j()));
            }
        }
        com.ss.android.downloadlib.a.b.d.eEB().a(arrayList);
    }

    @Override // com.ss.android.socialbase.appdownloader.b.c
    public void a(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.appdownloader.a aVar) {
        if (cVar != null && aVar != null && com.ss.android.socialbase.downloader.k.a.RW(cVar.g()).abH("anti_hijack_report_config") != null) {
            b(cVar, aVar);
        }
    }

    private int c(com.ss.android.b.a.b.a aVar) {
        int w;
        double e = com.ss.android.socialbase.downloader.k.a.RW(aVar.t()).e("download_failed_finally_hours", 48.0d);
        if (e <= 0.0d) {
            return -1;
        }
        if (System.currentTimeMillis() - aVar.n() < e * 60.0d * 60.0d * 1000.0d) {
            return 1;
        }
        if (aVar.f12923b.get()) {
            return 0;
        }
        com.ss.android.socialbase.downloader.g.c h = com.ss.android.socialbase.downloader.downloader.f.iB(j.a()).h(aVar.t());
        if (h == null || (w = h.w()) == -3 || w == -4) {
            return -1;
        }
        if (com.ss.android.socialbase.downloader.b.f.b(w)) {
            return 1;
        }
        if (aVar.f12923b.compareAndSet(false, true)) {
            try {
                JSONObject jSONObject = new JSONObject();
                a(jSONObject, h, true);
                jSONObject.putOpt("download_status", Integer.valueOf(w));
                jSONObject.putOpt("fail_status", Integer.valueOf(aVar.h()));
                jSONObject.putOpt("fail_msg", aVar.i());
                jSONObject.put("download_failed_times", aVar.a());
                if (h.eir() > 0) {
                    jSONObject.put("download_percent", h.eHi() / h.eir());
                }
                jSONObject.put("is_update_download", aVar.I() ? 1 : 2);
                com.ss.android.downloadlib.e.a.eFk().a(aVar.x(), "download_failed_finally", jSONObject, aVar);
                com.ss.android.downloadlib.a.b.g.eEE().d(aVar);
                return 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return 1;
    }

    private void b(@NonNull com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.appdownloader.a aVar) {
        com.ss.android.b.a.b.a j = com.ss.android.downloadlib.a.b.d.eEB().j(cVar);
        if (j != null) {
            JSONObject jSONObject = new JSONObject();
            aVar.a(jSONObject);
            try {
                jSONObject.put("download_id", cVar.g());
                jSONObject.put("name", cVar.h());
                jSONObject.put("url", cVar.j());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            com.ss.android.downloadlib.f.e.a(jSONObject, cVar.g());
            com.ss.android.downloadlib.e.a.eFk().a("embeded_ad", "anti_hijack_result", jSONObject, j);
        }
    }

    public void d(com.ss.android.b.a.b.a aVar) {
        f.eFh().a(new c(aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class c implements Runnable {
        private final com.ss.android.b.a.b.a qbi;

        public c(com.ss.android.b.a.b.a aVar) {
            this.qbi = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.qbi.h(true);
                b.this.b(this.qbi);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.qbi.h(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final int f12972b;

        public a(int i) {
            this.f12972b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.downloadlib.a.b.d.eEB().b();
                ConcurrentHashMap<Long, com.ss.android.b.a.b.a> eEC = com.ss.android.downloadlib.a.b.d.eEB().eEC();
                if (eEC != null && !eEC.isEmpty()) {
                    b.this.a(eEC, this.f12972b);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private JSONObject a(com.ss.android.b.a.b.a aVar, String str, int i) {
        com.ss.android.socialbase.appdownloader.a aba;
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.socialbase.downloader.g.c h = com.ss.android.socialbase.downloader.downloader.f.iB(j.a()).h(aVar.t());
            jSONObject.putOpt("scene", Integer.valueOf(i));
            com.ss.android.downloadlib.f.e.a(jSONObject, aVar.t());
            com.ss.android.downloadlib.f.e.a(aVar, jSONObject);
            jSONObject.put("is_update_download", aVar.I() ? 1 : 2);
            if (h != null) {
                try {
                    jSONObject.put("uninstall_resume_count", h.eHZ());
                    if (aVar.f() > 0) {
                        jSONObject.put("install_time", System.currentTimeMillis() - aVar.f());
                    }
                } catch (Throwable th) {
                }
                String string = h.eIf().getString("anti_hijack_attempt");
                if (!TextUtils.isEmpty(string) && (aba = com.ss.android.socialbase.appdownloader.a.aba(string)) != null) {
                    aba.a(jSONObject);
                }
            }
            int a2 = a(aVar, h, str, jSONObject);
            jSONObject.put("fail_status", a2);
            if (a2 == 3000) {
                jSONObject.put("hijack", 2);
            } else if (a2 == 3001) {
                jSONObject.put("hijack", 0);
            } else {
                jSONObject.put("hijack", 1);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return jSONObject;
    }

    public void a(com.ss.android.socialbase.downloader.g.c cVar, long j, long j2, long j3, long j4, long j5, boolean z) {
        com.ss.android.b.a.b.a j6 = com.ss.android.downloadlib.a.b.d.eEB().j(cVar);
        if (j6 == null) {
            com.ss.android.downloadlib.f.i.b();
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("space_before", Double.valueOf(j / 1048576.0d));
            jSONObject.putOpt("space_cleaned", Double.valueOf((j2 - j) / 1048576.0d));
            jSONObject.putOpt("clean_up_time_cost", Long.valueOf(j4));
            jSONObject.putOpt("is_download_restarted", Integer.valueOf(z ? 1 : 0));
            jSONObject.putOpt("byte_required", Long.valueOf(j3));
            jSONObject.putOpt("clear_sleep_time", Long.valueOf(j5));
            com.ss.android.downloadlib.e.a.eFk().c(cVar, jSONObject);
            com.ss.android.downloadlib.e.a.eFk().a("embeded_ad", "cleanup", jSONObject, j6);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
