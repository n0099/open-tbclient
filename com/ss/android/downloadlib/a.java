package com.ss.android.downloadlib;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.cyberplayer.sdk.CyberRuntimeInfo;
import com.baidu.cyberplayer.sdk.utils.ZipUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.pms.db.PackageTable;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.ss.android.downloadlib.addownload.b.d;
import com.ss.android.downloadlib.addownload.b.i;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.c.h;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.appdownloader.b;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.ag;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.k;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a implements com.ss.android.downloadad.api.a, b.c, a.InterfaceC0743a, ag {
    public static String a = "a";
    public static volatile a d;
    public long b;
    public b c;

    @WorkerThread
    /* renamed from: com.ss.android.downloadlib.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class RunnableC0726a implements Runnable {
        public final int b;

        public RunnableC0726a(int i) {
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.downloadlib.addownload.b.f.a().b();
                ConcurrentHashMap<Long, com.ss.android.downloadad.api.a.b> c = com.ss.android.downloadlib.addownload.b.f.a().c();
                if (c == null || c.isEmpty()) {
                    return;
                }
                a.this.a(c, this.b);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class b implements Runnable {
        public long a;
        public int b;
        public long c;
        public int d;
        public long e;

        public b(long j, int i, long j2, int i2) {
            this.a = j;
            this.b = i;
            this.c = j2;
            this.d = i2;
        }

        private int a(boolean z, com.ss.android.downloadad.api.a.b bVar, DownloadInfo downloadInfo, boolean z2, JSONObject jSONObject) {
            com.ss.android.socialbase.downloader.g.a a = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
            int i = 1;
            if (a.a("install_failed_check_ttmd5", 1) == 1) {
                int checkMd5Status = downloadInfo.checkMd5Status();
                try {
                    jSONObject.put("ttmd5_status", checkMd5Status);
                } catch (Throwable unused) {
                }
                if (!com.ss.android.socialbase.downloader.i.f.a(checkMd5Status)) {
                    return 2005;
                }
            }
            int i2 = this.d;
            if (i2 != 2000) {
                return i2;
            }
            if (a.a("install_failed_check_signature", 1) == 1 && l.d(j.getContext(), bVar.e())) {
                if (!l.a(l.h(j.getContext(), downloadInfo.getTargetFilePath()), l.g(j.getContext(), bVar.e()))) {
                    return 2006;
                }
            }
            if (!z) {
                return 2002;
            }
            long j = this.e;
            long j2 = this.c;
            if (j <= j2) {
                return 2000;
            }
            try {
                jSONObject.put("install_time", j - j2);
                if (bVar.C() <= this.c) {
                    i = 0;
                }
                jSONObject.put("install_again", i);
            } catch (Throwable unused2) {
            }
            if (!z2) {
                return 2003;
            }
            return 2004;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.e = System.currentTimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (a()) {
                    a.a().a(this.a, this.b);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0064, code lost:
            if (r9 < r1) goto L18;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a() {
            DownloadInfo downloadInfo;
            double d;
            JSONObject jSONObject;
            int i;
            int i2;
            com.ss.android.downloadad.api.a.b d2 = com.ss.android.downloadlib.addownload.b.f.a().d(this.a);
            boolean z = false;
            if (d2 == null || l.b(d2) || d2.c.get() || (downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(d2.s())) == null) {
                return false;
            }
            long M = d2.M();
            long a = l.a(Environment.getDataDirectory());
            long min = Math.min((long) ZipUtils.MAX_ZIP_FILE_LENGTH, a / 10);
            long totalBytes = downloadInfo.getTotalBytes();
            double d3 = totalBytes;
            double d4 = min + (2.5d * d3);
            if (M > -1 && totalBytes > -1) {
                d = d3;
            } else {
                d = d3;
            }
            z = true;
            boolean a2 = com.ss.android.socialbase.appdownloader.b.a(j.getContext());
            JSONObject jSONObject2 = new JSONObject();
            int a3 = a(z, d2, downloadInfo, a2, jSONObject2);
            this.d = a3;
            try {
                jSONObject = jSONObject2;
            } catch (Exception e) {
                e = e;
                jSONObject = jSONObject2;
            }
            try {
                jSONObject.putOpt("fail_status", Integer.valueOf(a3));
                jSONObject.putOpt("available_space", Long.valueOf(M / 1048576));
                jSONObject.putOpt("total_space", Long.valueOf(a / 1048576));
                int i3 = (totalBytes > 0L ? 1 : (totalBytes == 0L ? 0 : -1));
                if (i3 > 0) {
                    jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.PACKAGE_SIZE, Long.valueOf(totalBytes / 1048576));
                }
                int i4 = 2;
                if (z) {
                    i = 1;
                } else {
                    i = 2;
                }
                jSONObject.putOpt("space_enough", Integer.valueOf(i));
                if (M > 0 && i3 > 0) {
                    jSONObject.put("available_space_ratio", M / d);
                }
                if (a2) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                jSONObject.putOpt("permission_unknown_source_install", Integer.valueOf(i2));
                if (d2.V()) {
                    i4 = 1;
                }
                jSONObject.put("is_update_download", i4);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                com.ss.android.downloadlib.d.a.a().b("install_failed", jSONObject, d2);
                return true;
            }
            com.ss.android.downloadlib.d.a.a().b("install_failed", jSONObject, d2);
            return true;
        }
    }

    /* loaded from: classes10.dex */
    public class c implements Runnable {
        public final com.ss.android.downloadad.api.a.b b;

        public c(com.ss.android.downloadad.api.a.b bVar) {
            this.b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    this.b.j(true);
                    a.this.c(this.b);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } finally {
                this.b.j(false);
            }
        }
    }

    public a() {
        com.ss.android.socialbase.appdownloader.b.a(this);
        com.ss.android.socialbase.downloader.a.a.a().a(this);
    }

    public static a a() {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a();
                }
            }
        }
        return d;
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0743a
    public void b() {
        com.ss.android.socialbase.downloader.c.a.b(a, "onAppForeground()");
        d();
        a(5);
    }

    @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC0743a
    public void c() {
        com.ss.android.socialbase.downloader.c.a.b(a, "onAppBackground()");
        a(6);
    }

    public synchronized void d() {
        b bVar = this.c;
        if (bVar != null) {
            bVar.b();
            this.c = null;
        }
    }

    private int a(com.ss.android.downloadad.api.a.b bVar, DownloadInfo downloadInfo, String str, JSONObject jSONObject) {
        int b2 = com.ss.android.socialbase.appdownloader.c.b(j.getContext(), downloadInfo);
        int b3 = l.b(j.getContext(), str);
        if (b2 > 0 && b3 > 0 && b2 != b3) {
            if (b3 > b2) {
                return 3011;
            }
            return 3010;
        } else if (com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("install_finish_check_ttmd5", 1) == 1) {
            String string = j.getContext().getSharedPreferences("sp_ttdownloader_md5", 0).getString(String.valueOf(bVar.b()), null);
            if (TextUtils.isEmpty(string) && downloadInfo != null) {
                string = com.ss.android.downloadlib.g.a.a(downloadInfo.getTargetFilePath());
            }
            int a2 = com.ss.android.downloadlib.g.a.a(string, com.ss.android.downloadlib.g.a.b(str));
            try {
                jSONObject.put("ttmd5_status", a2);
            } catch (Throwable unused) {
            }
            if (a2 == 0) {
                return 3000;
            }
            if (a2 == 1) {
                return 3002;
            }
            return 3001;
        } else {
            return 3001;
        }
    }

    public static DownloadInfo a(List<DownloadInfo> list, String str) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null) {
                    if (str.equals(downloadInfo.getPackageName())) {
                        return downloadInfo;
                    }
                    if (l.a(j.getContext(), downloadInfo.getTargetFilePath(), str)) {
                        return downloadInfo;
                    }
                }
            }
        }
        return null;
    }

    private JSONObject b(@NonNull DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.a aVar) {
        com.ss.android.downloadad.api.a.b a2 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
        if (a2 == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        aVar.a(jSONObject);
        try {
            jSONObject.put("download_id", downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        com.ss.android.downloadlib.g.f.a(jSONObject, downloadInfo.getId());
        com.ss.android.downloadlib.d.a.a().a("embeded_ad", "ah_result", jSONObject, a2);
        return jSONObject;
    }

    private JSONObject a(com.ss.android.downloadad.api.a.b bVar, String str, int i) {
        int i2;
        int i3;
        String str2;
        com.ss.android.socialbase.appdownloader.a a2;
        JSONObject jSONObject = new JSONObject();
        try {
            DownloadInfo downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(bVar.s());
            jSONObject.putOpt("scene", Integer.valueOf(i));
            com.ss.android.downloadlib.g.f.a(jSONObject, bVar.s());
            com.ss.android.downloadlib.g.f.a(bVar, jSONObject);
            if (bVar.V()) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            jSONObject.put("is_update_download", i2);
            if (bVar.ab()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            jSONObject.put("install_after_back_app", i3);
            if (bVar.R()) {
                str2 = "1";
            } else {
                str2 = "2";
            }
            jSONObject.putOpt("clean_space_install_params", str2);
            if (downloadInfo != null) {
                a(jSONObject, downloadInfo);
                try {
                    jSONObject.put("uninstall_resume_count", downloadInfo.getUninstallResumeCount());
                    if (bVar.C() > 0) {
                        jSONObject.put("install_time", System.currentTimeMillis() - bVar.C());
                    }
                } catch (Throwable unused) {
                }
                String a3 = com.ss.android.socialbase.downloader.i.f.a(downloadInfo.getTempCacheData().get("ah_attempt"), (String) null);
                if (!TextUtils.isEmpty(a3) && (a2 = com.ss.android.socialbase.appdownloader.a.a(a3)) != null) {
                    a2.a(jSONObject);
                }
            }
            int a4 = a(bVar, downloadInfo, str, jSONObject);
            jSONObject.put("fail_status", a4);
            if (a4 == 3000) {
                jSONObject.put("hijack", 2);
            } else if (a4 == 3001) {
                jSONObject.put("hijack", 0);
            } else {
                jSONObject.put("hijack", 1);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public static JSONObject a(JSONObject jSONObject, DownloadInfo downloadInfo) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        String str;
        int i6;
        int i7;
        int i8;
        int i9;
        if (jSONObject != null && downloadInfo != null) {
            int i10 = 1;
            if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("download_event_opt", 1) == 0) {
                return jSONObject;
            }
            try {
                jSONObject.put("download_id", downloadInfo.getId());
                jSONObject.put("name", downloadInfo.getName());
                jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
                jSONObject.put("network_quality", downloadInfo.getNetworkQuality());
                jSONObject.put("current_network_quality", k.a().b().name());
                int i11 = 0;
                if (downloadInfo.isOnlyWifi()) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put("only_wifi", i);
                if (downloadInfo.isNeedHttpsToHttpRetry()) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                jSONObject.put("need_https_degrade", i2);
                if (downloadInfo.isHttpsToHttpRetryUsed()) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                jSONObject.put("https_degrade_retry_used", i3);
                jSONObject.put("chunk_count", downloadInfo.getChunkCount());
                jSONObject.put("retry_count", downloadInfo.getRetryCount());
                jSONObject.put("cur_retry_time", downloadInfo.getCurRetryTime());
                if (downloadInfo.isNeedRetryDelay()) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                jSONObject.put("need_retry_delay", i4);
                if (downloadInfo.isBackUpUrlUsed()) {
                    i5 = 1;
                } else {
                    i5 = 0;
                }
                jSONObject.put("backup_url_used", i5);
                if (downloadInfo.getHeadConnectionException() != null) {
                    str = downloadInfo.getHeadConnectionException();
                } else {
                    str = "";
                }
                jSONObject.put("head_connection_error_msg", str);
                if (downloadInfo.isNeedIndependentProcess()) {
                    i6 = 1;
                } else {
                    i6 = 0;
                }
                jSONObject.put("need_independent_process", i6);
                jSONObject.put("total_retry_count", downloadInfo.getTotalRetryCount());
                jSONObject.put("cur_retry_time_in_total", downloadInfo.getCurRetryTimeInTotal());
                jSONObject.put("real_download_time", downloadInfo.getRealDownloadTime());
                jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
                jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
                jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
                jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
                if (downloadInfo.isChunkDowngradeRetryUsed()) {
                    i7 = 1;
                } else {
                    i7 = 0;
                }
                jSONObject.put("chunk_downgrade_retry_used", i7);
                if (downloadInfo.isNeedChunkDowngradeRetry()) {
                    i8 = 1;
                } else {
                    i8 = 0;
                }
                jSONObject.put("need_chunk_downgrade_retry", i8);
                jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
                jSONObject.put("preconnect_level", downloadInfo.getPreconnectLevel());
                jSONObject.put(PackageTable.MD5, downloadInfo.getMd5());
                jSONObject.put("expect_file_length", downloadInfo.getExpectFileLength());
                jSONObject.put("retry_schedule_count", downloadInfo.getRetryScheduleCount());
                if (downloadInfo.isRwConcurrent()) {
                    i9 = 1;
                } else {
                    i9 = 0;
                }
                jSONObject.put("rw_concurrent", i9);
                double curBytes = downloadInfo.getCurBytes() / 1048576.0d;
                double realDownloadTime = downloadInfo.getRealDownloadTime() / 1000.0d;
                if (curBytes > 0.0d && realDownloadTime > 0.0d) {
                    double d2 = curBytes / realDownloadTime;
                    try {
                        jSONObject.put(CyberRuntimeInfo.DP_RUNTIME_DOWNLOAD_SPEED, d2);
                    } catch (Exception unused) {
                    }
                    String str2 = a;
                    com.ss.android.socialbase.downloader.c.a.b(str2, "download speed : " + d2 + "MB/s");
                }
                try {
                    if (Downloader.getInstance(j.getContext()).isDownloadServiceForeground(downloadInfo.getId())) {
                        i11 = 1;
                    }
                    jSONObject.put("is_download_service_foreground", i11);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (downloadInfo.getBackUpUrls() != null) {
                    jSONObject.put("backup_url_count", downloadInfo.getBackUpUrls().size());
                    jSONObject.put("cur_backup_url_index", downloadInfo.getCurBackUpUrlIndex());
                }
                jSONObject.put("clear_space_restart_times", com.ss.android.downloadlib.addownload.c.d.a().b(downloadInfo.getUrl()));
                jSONObject.put("mime_type", downloadInfo.getMimeType());
                if (!com.ss.android.socialbase.downloader.i.f.c(j.getContext())) {
                    i10 = 2;
                }
                jSONObject.put("network_available", i10);
                jSONObject.put("status_code", downloadInfo.getHttpStatusCode());
                b(jSONObject, downloadInfo);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return jSONObject;
    }

    public void b(DownloadInfo downloadInfo, final com.ss.android.downloadad.api.a.b bVar) {
        if (downloadInfo == null || bVar == null || com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("install_finish_check_ttmd5", 1) == 0) {
            return;
        }
        final String targetFilePath = downloadInfo.getTargetFilePath();
        if (TextUtils.isEmpty(targetFilePath)) {
            return;
        }
        d.a().b(new Runnable() { // from class: com.ss.android.downloadlib.a.3
            @Override // java.lang.Runnable
            public void run() {
                String a2 = com.ss.android.downloadlib.g.a.a(targetFilePath);
                if (TextUtils.isEmpty(a2)) {
                    return;
                }
                j.getContext().getSharedPreferences("sp_ttdownloader_md5", 0).edit().putString(String.valueOf(bVar.b()), a2).apply();
            }
        });
    }

    @WorkerThread
    public static synchronized void a(DownloadInfo downloadInfo, com.ss.android.downloadad.api.a.b bVar) {
        synchronized (a.class) {
            if (downloadInfo == null) {
                com.ss.android.downloadlib.e.c.a().a("onDownloadFinish info null");
            } else if (bVar == null) {
                com.ss.android.downloadlib.e.c.a().a("onDownloadFinish nativeModel null");
            } else if (bVar.G() != 1) {
            } else {
                h.a().d(bVar);
                String c2 = c(downloadInfo, bVar);
                com.ss.android.downloadlib.addownload.b.f.a().b(downloadInfo.getUrl(), c2);
                Map<Long, com.ss.android.downloadad.api.a.b> a2 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo.getUrl(), c2);
                bVar.f(System.currentTimeMillis());
                bVar.e(2);
                bVar.b(c2);
                a2.put(Long.valueOf(bVar.b()), bVar);
                i.a().a(a2.values());
                b(bVar);
                f.a().a(downloadInfo, c2);
                if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType())) {
                    a().a(bVar);
                    a().b(downloadInfo, bVar);
                    if (bVar.L()) {
                        com.ss.android.downloadlib.addownload.a.a.a().a(downloadInfo.getId(), bVar.b(), bVar.l(), c2, downloadInfo.getTitle(), bVar.d(), downloadInfo.getTargetFilePath());
                    }
                    com.ss.android.downloadlib.addownload.e.a.a(downloadInfo, bVar.b(), bVar.d(), c2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void a(@NonNull ConcurrentHashMap<Long, com.ss.android.downloadad.api.a.b> concurrentHashMap, int i) {
        ArrayList arrayList = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        for (com.ss.android.downloadad.api.a.b bVar : concurrentHashMap.values()) {
            if (bVar.c.get()) {
                if (currentTimeMillis - bVar.H() >= com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(bVar.b()));
                }
            } else if (bVar.G() == 1) {
                if (d(bVar) <= 0 && currentTimeMillis - bVar.H() >= com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(bVar.b()));
                }
            } else if (bVar.G() == 2) {
                if (!bVar.Y()) {
                    if (l.b(bVar)) {
                        if (bVar.K() == 4) {
                            i = bVar.K();
                        }
                        com.ss.android.downloadlib.d.a.a().a(a(bVar, bVar.e(), i), bVar);
                        arrayList.add(Long.valueOf(bVar.b()));
                        com.ss.android.downloadlib.addownload.c.d.a(bVar);
                    } else if (currentTimeMillis - bVar.H() >= com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("finish_event_expire_hours", 168) * 60 * 60 * 1000) {
                        arrayList.add(Long.valueOf(bVar.b()));
                    } else if (TextUtils.isEmpty(bVar.e())) {
                        arrayList.add(Long.valueOf(bVar.b()));
                    }
                }
            } else {
                arrayList.add(Long.valueOf(bVar.b()));
            }
        }
        com.ss.android.downloadlib.addownload.b.f.a().a(arrayList);
    }

    public static JSONObject b(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject != null && downloadInfo != null) {
            if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("download_event_opt", 1) == 0) {
                return jSONObject;
            }
            try {
                long a2 = l.a(0L);
                double d2 = a2;
                jSONObject.put("available_space", d2 / 1048576.0d);
                long totalBytes = downloadInfo.getTotalBytes();
                double d3 = totalBytes;
                jSONObject.put("apk_size", d3 / 1048576.0d);
                if (a2 > 0 && totalBytes > 0) {
                    jSONObject.put("available_space_ratio", d2 / d3);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static void b(com.ss.android.downloadad.api.a.b bVar) {
        String P;
        int i;
        int i2;
        int i3;
        if (bVar == null) {
            return;
        }
        if (TextUtils.isEmpty(bVar.P())) {
            P = "";
        } else {
            P = bVar.P();
        }
        DownloadInfo downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(bVar.s());
        bVar.l("");
        i.a().a(bVar);
        JSONObject a2 = a(new JSONObject(), downloadInfo);
        int i4 = 1;
        try {
            a2.putOpt("finish_reason", P);
            if (downloadInfo.isDownloadFromReserveWifi()) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            a2.putOpt("finish_from_reserve_wifi", Integer.valueOf(i3));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.ss.android.downloadad.api.a.b a3 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
        com.ss.android.downloadlib.g.f.a(a2, downloadInfo.getId());
        try {
            a2.put("download_failed_times", a3.x());
            if (com.ss.android.socialbase.appdownloader.e.d.a()) {
                i = 1;
            } else {
                i = 2;
            }
            a2.put("can_show_notification", i);
            if (downloadInfo.getExpectFileLength() > 0 && downloadInfo.getTotalBytes() > 0) {
                a2.put("file_length_gap", downloadInfo.getExpectFileLength() - downloadInfo.getTotalBytes());
            }
            a2.put("ttmd5_status", downloadInfo.getTTMd5CheckStatus());
            if (a3.d.get()) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            a2.put("has_send_download_failed_finally", i2);
            if (!a3.V()) {
                i4 = 2;
            }
            a2.put("is_update_download", i4);
            com.ss.android.downloadlib.g.f.a(a3, a2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().b("download_finish", a2, bVar);
    }

    private int d(com.ss.android.downloadad.api.a.b bVar) {
        int realStatus;
        int i;
        double a2 = com.ss.android.socialbase.downloader.g.a.a(bVar.s()).a("download_failed_finally_hours", 48.0d);
        if (a2 <= 0.0d) {
            return -1;
        }
        if (System.currentTimeMillis() - bVar.H() < a2 * 60.0d * 60.0d * 1000.0d) {
            return 1;
        }
        if (bVar.d.get()) {
            return 0;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(j.getContext()).getDownloadInfo(bVar.s());
        if (downloadInfo == null || (realStatus = downloadInfo.getRealStatus()) == -3 || realStatus == -4) {
            return -1;
        }
        if (!DownloadStatus.isDownloading(realStatus) && bVar.d.compareAndSet(false, true)) {
            try {
                JSONObject jSONObject = new JSONObject();
                a(jSONObject, downloadInfo);
                jSONObject.putOpt("download_status", Integer.valueOf(realStatus));
                jSONObject.putOpt("fail_status", Integer.valueOf(bVar.E()));
                jSONObject.putOpt("fail_msg", bVar.F());
                jSONObject.put("download_failed_times", bVar.x());
                if (downloadInfo.getTotalBytes() > 0) {
                    jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
                }
                if (bVar.V()) {
                    i = 1;
                } else {
                    i = 2;
                }
                jSONObject.put("is_update_download", i);
                com.ss.android.downloadlib.d.a.a().a(bVar.j(), "download_failed_finally", jSONObject, bVar);
                i.a().a(bVar);
                return 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return 1;
    }

    @WorkerThread
    public synchronized void a(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!l.a()) {
            final com.ss.android.downloadad.api.a.b a2 = com.ss.android.downloadlib.addownload.b.f.a().a(str);
            if (a2 == null) {
                com.ss.android.downloadlib.addownload.b.d.a().a(str);
                return;
            }
            com.ss.android.downloadlib.addownload.e a3 = f.a().a(a2.a());
            if (a3 != null) {
                a3.f();
            }
            if (a2.c.get()) {
                return;
            }
            if (com.ss.android.socialbase.downloader.g.a.a(a2.s()).b("notification_opt_2") == 1) {
                com.ss.android.socialbase.downloader.notification.b.a().f(a2.s());
            }
            new com.ss.android.downloadlib.b.b().a(a2, new com.ss.android.downloadlib.b.g() { // from class: com.ss.android.downloadlib.a.1
                @Override // com.ss.android.downloadlib.b.g
                public void a(boolean z) {
                    String str2 = a.a;
                    com.ss.android.socialbase.downloader.c.a.b(str2, "appBackForeground->" + z);
                    if (z) {
                        boolean z2 = false;
                        if (com.ss.android.downloadlib.b.f.c(a2)) {
                            z2 = com.ss.android.downloadlib.b.a.a(str, a2);
                        }
                        if (!z2 && com.ss.android.downloadlib.b.f.d(a2) && a2.K() == 4) {
                            com.ss.android.downloadlib.addownload.a.a.a().a(a2);
                        }
                    } else if (!com.ss.android.downloadlib.b.a.a(str, a2) && a2.K() == 4) {
                        com.ss.android.downloadlib.addownload.a.a.a().a(a2);
                    }
                }
            }, com.ss.android.downloadlib.g.e.a(a2).a("try_applink_delay_after_installed", 0));
            h.a().f(a2);
            a(str, a2);
            com.ss.android.downloadlib.addownload.a.a.a().b(str);
            DownloadInfo a4 = a(Downloader.getInstance(j.getContext()).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive"), str);
            if (a4 != null) {
                if (com.ss.android.socialbase.downloader.g.a.a(a4.getId()).b("no_hide_notification") != 1) {
                    com.ss.android.socialbase.downloader.notification.b.a().a(a4.getId());
                }
                f.a().b(a4, str);
                com.ss.android.downloadlib.addownload.c.d.a(a4);
            } else {
                f.a().b(null, str);
            }
            return;
        }
        throw new RuntimeException("handleAppInstalled in main thread.");
    }

    public static String c(@NonNull DownloadInfo downloadInfo, @NonNull com.ss.android.downloadad.api.a.b bVar) {
        File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        String str = null;
        if (file.exists()) {
            try {
                PackageInfo packageArchiveInfo = j.getContext().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), com.ss.android.socialbase.appdownloader.c.a());
                if (packageArchiveInfo != null) {
                    str = packageArchiveInfo.packageName;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str) && !str.equals(downloadInfo.getPackageName())) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("real_package_name", str);
                jSONObject.put("input_package_name", downloadInfo.getPackageName());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            com.ss.android.downloadlib.d.a.a().a("embeded_ad", "package_name_error", jSONObject, bVar);
            return str;
        }
        return downloadInfo.getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void c(com.ss.android.downloadad.api.a.b bVar) {
        SystemClock.sleep(20000L);
        int i = 15;
        while (i > 0) {
            if (l.b(bVar)) {
                a(bVar.e());
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

    @Override // com.ss.android.downloadad.api.a
    public void a(int i) {
        long j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.b < AppConfig.TIMESTAMP_AVAILABLE_DURATION) {
            return;
        }
        d a2 = d.a();
        RunnableC0726a runnableC0726a = new RunnableC0726a(i);
        if (this.b > 0) {
            j = 2000;
        } else {
            j = 8000;
        }
        a2.a(runnableC0726a, j);
        this.b = currentTimeMillis;
    }

    public void a(long j) {
        d.a a2;
        int i;
        try {
            com.ss.android.downloadad.api.a.b d2 = com.ss.android.downloadlib.addownload.b.f.a().d(j);
            if (d2 != null && !l.b(d2) && !d2.c.get()) {
                Pair<d.a, Integer> b2 = com.ss.android.downloadlib.addownload.b.d.a().b(d2);
                if (b2 != null) {
                    a2 = (d.a) b2.first;
                    i = ((Integer) b2.second).intValue();
                } else {
                    a2 = com.ss.android.downloadlib.addownload.b.d.a().a(d2);
                    i = -1;
                }
                if (a2 == null) {
                    return;
                }
                com.ss.android.downloadlib.addownload.b.d.a().b(a2.a);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("installed_app_name", a2.d);
                jSONObject.put("installed_pkg_name", a2.a);
                if (i != -1) {
                    jSONObject.put("error_code", i);
                    com.ss.android.downloadlib.g.f.a(jSONObject, d2.s());
                    com.ss.android.downloadlib.d.a.a().b("install_finish_hijack", jSONObject, d2);
                    return;
                }
                com.ss.android.downloadlib.d.a.a().b("install_finish_may_hijack", jSONObject, d2);
            }
        } catch (Throwable th) {
            com.ss.android.downloadlib.e.c.a().a(th, "trySendInstallFinishHijack");
        }
    }

    public void a(final long j, int i) {
        long a2 = com.ss.android.socialbase.downloader.g.a.a(i).a("check_install_finish_hijack_delay_time", com.heytap.mcssdk.constant.a.h);
        if (a2 < 0) {
            return;
        }
        d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.a().a(j);
            }
        }, Math.max(a2, 300000L));
    }

    public void a(com.ss.android.downloadad.api.a.b bVar) {
        d.a().a(new c(bVar));
    }

    public void a(DownloadInfo downloadInfo, long j, long j2, long j3, long j4, long j5, boolean z) {
        int i;
        com.ss.android.downloadad.api.a.b a2 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
        if (a2 == null) {
            com.ss.android.downloadlib.e.c.a().a("trySendClearSpaceEvent nativeModel null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("space_before", Double.valueOf(j / 1048576.0d));
            jSONObject.putOpt("space_cleaned", Double.valueOf((j2 - j) / 1048576.0d));
            jSONObject.putOpt("clean_up_time_cost", Long.valueOf(j4));
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            jSONObject.putOpt("is_download_restarted", Integer.valueOf(i));
            jSONObject.putOpt("byte_required", Long.valueOf(j3));
            jSONObject.putOpt("byte_required_after", Double.valueOf((j3 - j2) / 1048576.0d));
            jSONObject.putOpt("clear_sleep_time", Long.valueOf(j5));
            com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
            com.ss.android.downloadlib.d.a.a().a("cleanup", jSONObject, a2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(DownloadInfo downloadInfo, com.ss.android.downloadad.api.a.b bVar, int i) {
        long max;
        if (downloadInfo != null && bVar != null) {
            d();
            long currentTimeMillis = System.currentTimeMillis();
            bVar.b(currentTimeMillis);
            bVar.g(l.a(Environment.getDataDirectory(), -1L));
            if (i != 2000) {
                max = 2000;
            } else {
                long a2 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("check_install_failed_delay_time", AppConfig.TIMESTAMP_AVAILABLE_DURATION);
                if (a2 < 0) {
                    return;
                }
                max = Math.max(a2, 30000L);
            }
            long j = max;
            b bVar2 = new b(bVar.b(), downloadInfo.getId(), currentTimeMillis, i);
            d.a().a(bVar2, j);
            this.c = bVar2;
            i.a().a(bVar);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.b.c
    public void a(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.a aVar) {
        JSONObject b2;
        if (downloadInfo != null && aVar != null) {
            JSONArray e = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).e("ah_report_config");
            if (aVar.b != 0) {
                downloadInfo.getTempCacheData().remove("intent");
            }
            if (e != null && (b2 = b(downloadInfo, aVar)) != null) {
                downloadInfo.getTempCacheData().put("ah_ext_json", b2);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.ag
    public void a(@Nullable final DownloadInfo downloadInfo, @Nullable String str) {
        if (downloadInfo == null) {
            com.ss.android.downloadlib.e.c.a().a("info is null");
        } else if ((com.ss.android.socialbase.downloader.g.a.a(downloadInfo).b("check_applink_mode") & 2) != 0) {
            final JSONObject jSONObject = (JSONObject) downloadInfo.getTempCacheData().get("ah_ext_json");
            com.ss.android.downloadlib.b.e.a().b(new com.ss.android.downloadlib.b.d() { // from class: com.ss.android.downloadlib.a.4
                @Override // com.ss.android.downloadlib.b.d
                public void a(boolean z) {
                    String str2;
                    if (!z) {
                        Intent intent = (Intent) downloadInfo.getTempCacheData().get("intent");
                        if (intent != null) {
                            downloadInfo.getTempCacheData().remove("intent");
                            com.ss.android.socialbase.appdownloader.c.a(j.getContext(), intent);
                            l.a(jSONObject, "backup", (Object) 1);
                        } else {
                            l.a(jSONObject, "backup", (Object) 2);
                        }
                    }
                    com.ss.android.downloadad.api.a.b a2 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
                    if (a2 != null) {
                        com.ss.android.downloadlib.d.a a3 = com.ss.android.downloadlib.d.a.a();
                        if (z) {
                            str2 = "installer_delay_success";
                        } else {
                            str2 = "installer_delay_failed";
                        }
                        a3.a(str2, jSONObject, a2);
                    } else {
                        com.ss.android.downloadlib.e.c.a().b("ah nativeModel=null");
                    }
                    if (z) {
                        j.t().a(j.getContext(), null, null, null, null, 1);
                    }
                }
            });
        }
    }

    public void a(String str, com.ss.android.downloadad.api.a.b bVar) {
        if (bVar != null && l.b(bVar) && bVar.c.compareAndSet(false, true)) {
            int i = 4;
            if (bVar.K() != 4) {
                i = 3;
            }
            com.ss.android.downloadlib.d.a.a().a(bVar.j(), "install_finish", a(bVar, str, i), bVar);
            i.a().a(bVar);
        }
    }
}
