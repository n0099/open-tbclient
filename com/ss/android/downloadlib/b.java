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
/* loaded from: classes4.dex */
public class b implements com.ss.android.b.a.a, b.c, a.InterfaceC1227a {

    /* renamed from: a  reason: collision with root package name */
    private static String f12966a = b.class.getSimpleName();
    private static volatile b pQC;

    /* renamed from: b  reason: collision with root package name */
    private long f12967b;
    private RunnableC1217b pQB;

    private b() {
        com.ss.android.socialbase.appdownloader.b.a(this);
        com.ss.android.socialbase.downloader.a.a.eDz().a(this);
    }

    public static b eBX() {
        if (pQC == null) {
            synchronized (b.class) {
                if (pQC == null) {
                    pQC = new b();
                }
            }
        }
        return pQC;
    }

    @WorkerThread
    public static synchronized void a(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.b.a.b.a aVar) {
        synchronized (b.class) {
            if (cVar == null || aVar == null) {
                com.ss.android.downloadlib.f.i.b();
            } else if (aVar.l() == 1) {
                String c2 = c(cVar, aVar);
                com.ss.android.downloadlib.a.b.d.eCc().b(cVar.j(), c2);
                Map<Long, com.ss.android.b.a.b.a> M = com.ss.android.downloadlib.a.b.d.eCc().M(cVar.j(), c2);
                aVar.f(System.currentTimeMillis());
                aVar.e(2);
                aVar.b(c2);
                M.put(Long.valueOf(aVar.j()), aVar);
                com.ss.android.downloadlib.a.b.g.eCf().a(M.values());
                a(aVar);
                h.eCM().a(cVar, c2);
                if ("application/vnd.android.package-archive".equals(cVar.eEO())) {
                    eBX().d(aVar);
                    eBX().b(cVar, aVar);
                    if (aVar.w()) {
                        com.ss.android.downloadlib.a.a.a.eBZ().a(cVar.g(), aVar.j(), aVar.k(), c2, cVar.i(), aVar.o(), cVar.n());
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
            com.ss.android.b.a.b.a ZF = com.ss.android.downloadlib.a.b.d.eCc().ZF(str);
            if (ZF == null) {
                com.ss.android.downloadlib.a.b.c.eCb().a(str);
            } else {
                com.ss.android.downloadlib.a.f ZM = h.eCM().ZM(ZF.z());
                if (ZM != null) {
                    ZM.e();
                }
                if (!ZF.f12920a.get()) {
                    a(str, ZF);
                    if (!com.ss.android.downloadlib.b.a.b(str, ZF) && ZF.v() == 4) {
                        com.ss.android.downloadlib.a.a.a.eBZ().a(ZF.j());
                    }
                    com.ss.android.downloadlib.a.a.a.eBZ().b(str);
                    com.ss.android.socialbase.downloader.g.c v = v(com.ss.android.socialbase.downloader.downloader.f.iy(j.a()).b("application/vnd.android.package-archive"), str);
                    if (v != null) {
                        if (com.ss.android.socialbase.downloader.k.a.RA(v.g()).b("no_hide_notification") != 1) {
                            com.ss.android.socialbase.downloader.notification.b.eGk().a(v.g());
                        }
                        h.eCM().b(v, str);
                        com.ss.android.downloadlib.a.c.d.a(v);
                    } else {
                        h.eCM().b(null, str);
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
                long a2 = com.ss.android.socialbase.downloader.k.a.RA(cVar.g()).a("check_install_failed_delay_time", 120000L);
                if (a2 >= 0) {
                    max = Math.max(a2, 30000L);
                } else {
                    return;
                }
            }
            RunnableC1217b runnableC1217b = new RunnableC1217b(aVar.j(), cVar.g(), currentTimeMillis, i);
            f.eCI().a(runnableC1217b, max);
            this.pQB = runnableC1217b;
            com.ss.android.downloadlib.a.b.g.eCf().d(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.downloadlib.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class RunnableC1217b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private long f12971a;

        /* renamed from: b  reason: collision with root package name */
        private int f12972b;
        private long c;
        private int d;
        private long e;

        private RunnableC1217b(long j, int i, long j2, int i2) {
            this.f12971a = j;
            this.f12972b = i;
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
                    b.eBX().a(this.f12971a, this.f12972b);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        boolean a() {
            com.ss.android.socialbase.downloader.g.c h;
            com.ss.android.b.a.b.a jb = com.ss.android.downloadlib.a.b.d.eCc().jb(this.f12971a);
            if (jb == null || com.ss.android.downloadlib.f.i.i(jb) || jb.f12920a.get() || (h = com.ss.android.socialbase.downloader.downloader.f.iy(j.a()).h(jb.t())) == null) {
                return false;
            }
            long eBQ = jb.eBQ();
            long b2 = com.ss.android.downloadlib.f.i.b(Environment.getDataDirectory());
            long min = Math.min(524288000L, b2 / 10);
            long efR = h.efR();
            boolean z = true;
            if (eBQ > -1 && efR > -1 && eBQ < min + (efR * 2.5d)) {
                z = false;
            }
            boolean a2 = com.ss.android.socialbase.appdownloader.b.a(j.a());
            JSONObject jSONObject = new JSONObject();
            this.d = a(z, jb, h, a2, jSONObject);
            try {
                jSONObject.putOpt("fail_status", Integer.valueOf(this.d));
                jSONObject.putOpt("available_space", Long.valueOf(eBQ / 1048576));
                jSONObject.putOpt("total_space", Long.valueOf(b2 / 1048576));
                if (efR > 0) {
                    jSONObject.putOpt("package_size", Long.valueOf(efR / 1048576));
                }
                jSONObject.putOpt("space_enough", Integer.valueOf(z ? 1 : 2));
                if (eBQ > 0 && efR > 0) {
                    jSONObject.put("available_space_ratio", eBQ / efR);
                }
                jSONObject.putOpt("permission_unknown_source_install", Integer.valueOf(a2 ? 1 : 2));
                jSONObject.put("is_update_download", jb.I() ? 1 : 2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            com.ss.android.downloadlib.e.a.eCL().a("install_failed", jSONObject, jb);
            return true;
        }

        private int a(boolean z, com.ss.android.b.a.b.a aVar, com.ss.android.socialbase.downloader.g.c cVar, boolean z2, JSONObject jSONObject) {
            com.ss.android.socialbase.downloader.k.a RA = com.ss.android.socialbase.downloader.k.a.RA(cVar.g());
            if (RA.a("install_failed_check_ttmd5", 1) == 1) {
                int eFt = cVar.eFt();
                try {
                    jSONObject.put("ttmd5_status", eFt);
                } catch (Throwable th) {
                }
                if (!com.ss.android.socialbase.downloader.m.d.a(eFt)) {
                    return 2005;
                }
            }
            if (this.d != 2000) {
                return this.d;
            }
            if (RA.a("install_failed_check_signature", 1) == 1 && com.ss.android.downloadlib.f.i.d(j.a(), aVar.m())) {
                if (!com.ss.android.downloadlib.f.i.b(com.ss.android.downloadlib.f.i.bF(j.a(), cVar.n()), com.ss.android.downloadlib.f.i.bE(j.a(), aVar.m()))) {
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
        long a2 = com.ss.android.socialbase.downloader.k.a.RA(i).a("check_install_finish_hijack_delay_time", FunAdConfig.Builder.AD_EXPIRED_INTERVAL);
        if (a2 >= 0) {
            f.eCI().a(new Runnable() { // from class: com.ss.android.downloadlib.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.eBX().a(j);
                }
            }, Math.max(a2, 300000L));
        }
    }

    public void a(long j) {
        c.a e;
        int i;
        try {
            com.ss.android.b.a.b.a jb = com.ss.android.downloadlib.a.b.d.eCc().jb(j);
            if (jb != null && !com.ss.android.downloadlib.f.i.i(jb) && !jb.f12920a.get()) {
                Pair<c.a, Integer> f = com.ss.android.downloadlib.a.b.c.eCb().f(jb);
                if (f != null) {
                    e = (c.a) f.first;
                    i = ((Integer) f.second).intValue();
                } else {
                    e = com.ss.android.downloadlib.a.b.c.eCb().e(jb);
                    i = -1;
                }
                if (e != null) {
                    com.ss.android.downloadlib.a.b.c.eCb().b(e.f12934a);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("installed_app_name", e.d);
                    jSONObject.put("installed_pkg_name", e.f12934a);
                    if (i != -1) {
                        jSONObject.put("error_code", i);
                        com.ss.android.downloadlib.f.e.a(jSONObject, jb.t());
                        com.ss.android.downloadlib.guide.install.c.a();
                        com.ss.android.downloadlib.e.a.eCL().a("install_finish_hijack", jSONObject, jb);
                        return;
                    }
                    com.ss.android.downloadlib.e.a.eCL().a("install_finish_may_hijack", jSONObject, jb);
                }
            }
        } catch (Throwable th) {
            com.ss.android.downloadlib.f.i.a(th);
        }
    }

    public void a(String str, com.ss.android.b.a.b.a aVar) {
        if (aVar != null && com.ss.android.downloadlib.f.i.i(aVar) && aVar.f12920a.compareAndSet(false, true)) {
            com.ss.android.downloadlib.e.a.eCL().a(aVar.x(), "install_finish", a(aVar, str, aVar.v() != 4 ? 3 : 4), aVar);
            com.ss.android.downloadlib.a.b.g.eCf().d(aVar);
        }
    }

    private static com.ss.android.socialbase.downloader.g.c v(List<com.ss.android.socialbase.downloader.g.c> list, String str) {
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
        if (jSONObject != null && cVar != null && com.ss.android.socialbase.downloader.k.a.RA(cVar.g()).a("download_event_opt", 1) != 0) {
            try {
                jSONObject.put("download_id", cVar.g());
                jSONObject.put("name", cVar.h());
                jSONObject.put("url", cVar.j());
                jSONObject.put("cur_bytes", cVar.eEJ());
                jSONObject.put("total_bytes", cVar.efR());
                jSONObject.put("network_quality", cVar.eEL());
                jSONObject.put("current_network_quality", com.ss.android.socialbase.downloader.i.j.eFX().eFY().name());
                jSONObject.put("only_wifi", cVar.x() ? 1 : 0);
                jSONObject.put("need_https_degrade", cVar.eEP() ? 1 : 0);
                jSONObject.put("https_degrade_retry_used", cVar.t() ? 1 : 0);
                jSONObject.put("chunk_count", cVar.eFv());
                jSONObject.put(DownloadDataConstants.Columns.COLUMN_RETRY_COUNT, cVar.J());
                jSONObject.put("cur_retry_time", cVar.ax());
                jSONObject.put("need_retry_delay", cVar.eEQ() ? 1 : 0);
                jSONObject.put("backup_url_used", cVar.P() ? 1 : 0);
                jSONObject.put("head_connection_error_msg", cVar.c() != null ? cVar.c() : "");
                jSONObject.put("need_independent_process", cVar.ae() ? 1 : 0);
                jSONObject.put("total_retry_count", cVar.eED());
                jSONObject.put("cur_retry_time_in_total", cVar.us());
                jSONObject.put("real_download_time", cVar.eFd());
                jSONObject.put("first_speed_time", cVar.elQ());
                jSONObject.put("all_connect_time", cVar.eEB());
                jSONObject.put("download_prepare_time", cVar.eBQ());
                jSONObject.put("download_time", cVar.eFd() + cVar.eEB() + cVar.eBQ());
                jSONObject.put("chunk_downgrade_retry_used", cVar.eEW() ? 1 : 0);
                jSONObject.put("need_chunk_downgrade_retry", cVar.eEV() ? 1 : 0);
                jSONObject.put("failed_resume_count", cVar.eFy());
                jSONObject.put("preconnect_level", cVar.eFE());
                jSONObject.put("md5", cVar.F());
                jSONObject.put("expect_file_length", cVar.eBR());
                jSONObject.put("retry_schedule_count", cVar.eEF());
                jSONObject.put("rw_concurrent", cVar.uy() ? 1 : 0);
                double eEJ = cVar.eEJ() / 1048576.0d;
                double eFd = cVar.eFd() / 1000.0d;
                if (eEJ > 0.0d && eFd > 0.0d) {
                    double d = eEJ / eFd;
                    try {
                        jSONObject.put("download_speed", d);
                    } catch (Exception e) {
                    }
                    com.ss.android.socialbase.downloader.f.a.b(f12966a, "download speed : " + d + "MB/s");
                }
                try {
                    jSONObject.put("is_download_service_foreground", com.ss.android.socialbase.downloader.downloader.f.iy(j.a()).QV(cVar.g()) ? 1 : 0);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (cVar.eFi() != null) {
                    jSONObject.put("backup_url_count", cVar.eFi().size());
                    jSONObject.put("cur_backup_url_index", cVar.s());
                }
                jSONObject.put("clear_space_restart_times", com.ss.android.downloadlib.a.c.d.eCh().b(cVar.j()));
                jSONObject.put("mime_type", cVar.eEO());
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
        if (jSONObject != null && cVar != null && com.ss.android.socialbase.downloader.k.a.RA(cVar.g()).a("download_event_opt", 1) != 0) {
            try {
                long a2 = com.ss.android.downloadlib.f.i.a(Environment.getExternalStorageDirectory());
                jSONObject.put("available_space", a2 / 1048576.0d);
                long efR = cVar.efR();
                jSONObject.put(ConstantData.Logo.LOGO_AD_APK_SIZE, efR / 1048576.0d);
                if (a2 > 0 && efR > 0) {
                    jSONObject.put("available_space_ratio", a2 / efR);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return jSONObject;
    }

    public void b(com.ss.android.socialbase.downloader.g.c cVar, final com.ss.android.b.a.b.a aVar) {
        if (cVar != null && aVar != null && com.ss.android.socialbase.downloader.k.a.RA(cVar.g()).a("install_finish_check_ttmd5", 1) != 0) {
            final String n = cVar.n();
            if (!TextUtils.isEmpty(n)) {
                f.eCI().b(new Runnable() { // from class: com.ss.android.downloadlib.b.2
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
            com.ss.android.socialbase.downloader.g.c h = com.ss.android.socialbase.downloader.downloader.f.iy(j.a()).h(aVar.t());
            aVar.j("");
            com.ss.android.downloadlib.a.b.g.eCf().d(aVar);
            JSONObject a2 = a(new JSONObject(), h, false);
            try {
                a2.putOpt("finish_reason", E);
                a2.putOpt("finish_from_reserve_wifi", Integer.valueOf(h.T() ? 1 : 0));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            com.ss.android.b.a.b.a j = com.ss.android.downloadlib.a.b.d.eCc().j(h);
            com.ss.android.downloadlib.f.e.a(a2, h.g());
            try {
                a2.put("download_failed_times", j.a());
                a2.put("can_show_notification", com.ss.android.socialbase.appdownloader.e.d.a() ? 1 : 2);
                if (h.eBR() > 0 && h.efR() > 0) {
                    a2.put("file_length_gap", h.eBR() - h.efR());
                }
                a2.put("ttmd5_status", h.z());
                a2.put("has_send_download_failed_finally", j.f12921b.get() ? 1 : 2);
                a2.put("is_update_download", j.I() ? 1 : 2);
                com.ss.android.downloadlib.f.e.a(j, a2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            com.ss.android.downloadlib.e.a.eCL().a(a2, aVar);
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
        if (com.ss.android.socialbase.downloader.k.a.RA(aVar.t()).a("install_finish_check_ttmd5", 1) == 1) {
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
            com.ss.android.downloadlib.e.a.eCL().a("embeded_ad", "package_name_error", jSONObject, aVar);
            return str;
        }
        return cVar.D();
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC1227a
    public void b() {
        d();
        a(5);
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC1227a
    public void c() {
        a(6);
    }

    synchronized void d() {
        RunnableC1217b runnableC1217b = this.pQB;
        if (runnableC1217b != null) {
            runnableC1217b.b();
            this.pQB = null;
        }
    }

    @Override // com.ss.android.b.a.a
    public void a(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f12967b >= 120000) {
            f.eCI().a(new a(i), this.f12967b > 0 ? 2000L : 8000L);
            this.f12967b = currentTimeMillis;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void a(@NonNull ConcurrentHashMap<Long, com.ss.android.b.a.b.a> concurrentHashMap, int i) {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        for (com.ss.android.b.a.b.a aVar : concurrentHashMap.values()) {
            if (aVar.f12920a.get()) {
                if (currentTimeMillis - aVar.n() >= com.ss.android.socialbase.downloader.k.a.RA(aVar.t()).a("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(aVar.j()));
                }
            } else if (aVar.l() == 1) {
                if (c(aVar) <= 0 && currentTimeMillis - aVar.n() >= com.ss.android.socialbase.downloader.k.a.RA(aVar.t()).a("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(aVar.j()));
                }
            } else if (aVar.l() == 2) {
                if (!aVar.L()) {
                    if (com.ss.android.downloadlib.f.i.i(aVar)) {
                        if (aVar.v() == 4) {
                            i = aVar.v();
                        }
                        com.ss.android.downloadlib.e.a.eCL().b(a(aVar, aVar.m(), i), aVar);
                        arrayList.add(Long.valueOf(aVar.j()));
                        com.ss.android.downloadlib.a.c.d.d(aVar);
                    } else if (currentTimeMillis - aVar.n() >= com.ss.android.socialbase.downloader.k.a.RA(aVar.t()).a("finish_event_expire_hours", 168) * 60 * 60 * 1000) {
                        arrayList.add(Long.valueOf(aVar.j()));
                    } else if (TextUtils.isEmpty(aVar.m())) {
                        arrayList.add(Long.valueOf(aVar.j()));
                    }
                }
            } else {
                arrayList.add(Long.valueOf(aVar.j()));
            }
        }
        com.ss.android.downloadlib.a.b.d.eCc().a(arrayList);
    }

    @Override // com.ss.android.socialbase.appdownloader.b.c
    public void a(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.appdownloader.a aVar) {
        if (cVar != null && aVar != null && com.ss.android.socialbase.downloader.k.a.RA(cVar.g()).aau("anti_hijack_report_config") != null) {
            b(cVar, aVar);
        }
    }

    private int c(com.ss.android.b.a.b.a aVar) {
        int w;
        double e = com.ss.android.socialbase.downloader.k.a.RA(aVar.t()).e("download_failed_finally_hours", 48.0d);
        if (e <= 0.0d) {
            return -1;
        }
        if (System.currentTimeMillis() - aVar.n() < e * 60.0d * 60.0d * 1000.0d) {
            return 1;
        }
        if (aVar.f12921b.get()) {
            return 0;
        }
        com.ss.android.socialbase.downloader.g.c h = com.ss.android.socialbase.downloader.downloader.f.iy(j.a()).h(aVar.t());
        if (h == null || (w = h.w()) == -3 || w == -4) {
            return -1;
        }
        if (com.ss.android.socialbase.downloader.b.f.b(w)) {
            return 1;
        }
        if (aVar.f12921b.compareAndSet(false, true)) {
            try {
                JSONObject jSONObject = new JSONObject();
                a(jSONObject, h, true);
                jSONObject.putOpt("download_status", Integer.valueOf(w));
                jSONObject.putOpt("fail_status", Integer.valueOf(aVar.h()));
                jSONObject.putOpt("fail_msg", aVar.i());
                jSONObject.put("download_failed_times", aVar.a());
                if (h.efR() > 0) {
                    jSONObject.put("download_percent", h.eEJ() / h.efR());
                }
                jSONObject.put("is_update_download", aVar.I() ? 1 : 2);
                com.ss.android.downloadlib.e.a.eCL().a(aVar.x(), "download_failed_finally", jSONObject, aVar);
                com.ss.android.downloadlib.a.b.g.eCf().d(aVar);
                return 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return 1;
    }

    private void b(@NonNull com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.appdownloader.a aVar) {
        com.ss.android.b.a.b.a j = com.ss.android.downloadlib.a.b.d.eCc().j(cVar);
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
            com.ss.android.downloadlib.e.a.eCL().a("embeded_ad", "anti_hijack_result", jSONObject, j);
        }
    }

    public void d(com.ss.android.b.a.b.a aVar) {
        f.eCI().a(new c(aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class c implements Runnable {
        private final com.ss.android.b.a.b.a pQE;

        public c(com.ss.android.b.a.b.a aVar) {
            this.pQE = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.pQE.h(true);
                b.this.b(this.pQE);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.pQE.h(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    /* loaded from: classes4.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final int f12970b;

        public a(int i) {
            this.f12970b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.downloadlib.a.b.d.eCc().b();
                ConcurrentHashMap<Long, com.ss.android.b.a.b.a> eCd = com.ss.android.downloadlib.a.b.d.eCc().eCd();
                if (eCd != null && !eCd.isEmpty()) {
                    b.this.a(eCd, this.f12970b);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private JSONObject a(com.ss.android.b.a.b.a aVar, String str, int i) {
        com.ss.android.socialbase.appdownloader.a ZN;
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.socialbase.downloader.g.c h = com.ss.android.socialbase.downloader.downloader.f.iy(j.a()).h(aVar.t());
            jSONObject.putOpt("scene", Integer.valueOf(i));
            com.ss.android.downloadlib.f.e.a(jSONObject, aVar.t());
            com.ss.android.downloadlib.f.e.a(aVar, jSONObject);
            jSONObject.put("is_update_download", aVar.I() ? 1 : 2);
            if (h != null) {
                try {
                    jSONObject.put("uninstall_resume_count", h.eFA());
                    if (aVar.f() > 0) {
                        jSONObject.put("install_time", System.currentTimeMillis() - aVar.f());
                    }
                } catch (Throwable th) {
                }
                String string = h.eFG().getString("anti_hijack_attempt");
                if (!TextUtils.isEmpty(string) && (ZN = com.ss.android.socialbase.appdownloader.a.ZN(string)) != null) {
                    ZN.a(jSONObject);
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
        com.ss.android.b.a.b.a j6 = com.ss.android.downloadlib.a.b.d.eCc().j(cVar);
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
            com.ss.android.downloadlib.e.a.eCL().c(cVar, jSONObject);
            com.ss.android.downloadlib.e.a.eCL().a("embeded_ad", "cleanup", jSONObject, j6);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
