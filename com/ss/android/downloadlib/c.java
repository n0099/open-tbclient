package com.ss.android.downloadlib;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.k;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.appdownloader.c.h;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c implements h {
    public static String a = "c";

    /* renamed from: b  reason: collision with root package name */
    public Handler f59809b = new Handler(Looper.getMainLooper());

    @Override // com.ss.android.socialbase.appdownloader.c.h
    public void a(DownloadInfo downloadInfo, BaseException baseException, int i2) {
        final DownloadModel a2;
        if (downloadInfo == null) {
            return;
        }
        if (i2 == -1 && baseException != null) {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.g.f.c(downloadInfo, jSONObject);
            a.a(jSONObject, downloadInfo);
            k.a("download_failed", jSONObject.toString());
        }
        com.ss.android.downloadad.api.a.b a3 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
        if (a3 == null) {
            return;
        }
        try {
            if (i2 != -1) {
                if (i2 == -3) {
                    a.a(downloadInfo, a3);
                    return;
                } else if (i2 == 2001) {
                    a.a().a(downloadInfo, a3, 2001);
                    return;
                } else if (i2 == 11) {
                    a.a().a(downloadInfo, a3, 2000);
                    if (a3.S()) {
                        return;
                    }
                    a(downloadInfo, a3);
                    return;
                } else {
                    return;
                }
            }
            BaseException baseException2 = null;
            if (baseException != null) {
                if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("toast_without_network", 0) == 1 && baseException.getErrorCode() == 1049) {
                    this.f59809b.post(new Runnable() { // from class: com.ss.android.downloadlib.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            j.c().a(5, j.getContext(), null, "无网络，请检查网络设置", null, 0);
                        }
                    });
                }
                if (com.ss.android.socialbase.downloader.i.f.h(baseException)) {
                    if (j.l() != null) {
                        j.l().a(a3.b());
                    }
                    com.ss.android.downloadlib.d.a.a().a("download_failed_for_space", a3);
                    if (!a3.Q()) {
                        com.ss.android.downloadlib.d.a.a().a("download_can_restart", a3);
                        a(downloadInfo);
                    }
                    if ((j.l() == null || !j.l().d()) && (a2 = com.ss.android.downloadlib.addownload.b.f.a().a(a3.b())) != null && a2.isShowToast()) {
                        final com.ss.android.socialbase.downloader.g.a a4 = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
                        if (a4.a("show_no_enough_space_toast", 0) == 1) {
                            this.f59809b.post(new Runnable() { // from class: com.ss.android.downloadlib.c.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    j.c().a(2, j.getContext(), a2, a4.a("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
                                }
                            });
                        }
                    }
                }
                baseException2 = new BaseException(baseException.getErrorCode(), l.a(baseException.getMessage(), j.i().optInt("exception_msg_length", 500)));
            }
            com.ss.android.downloadlib.d.a.a().b(downloadInfo, baseException2);
            f.a().a(downloadInfo, baseException, "");
        } catch (Exception e2) {
            j.s().a(e2, "onAppDownloadMonitorSend");
        }
    }

    private void a(final DownloadInfo downloadInfo, final com.ss.android.downloadad.api.a.b bVar) {
        final long a2 = l.a(Environment.getDataDirectory(), -1L);
        long min = Math.min(524288000L, l.a(Environment.getDataDirectory()) / 10);
        final long totalBytes = downloadInfo.getTotalBytes();
        final double d2 = (totalBytes * 2.5d) + min;
        if (a2 > -1 && totalBytes > -1) {
            double d3 = a2;
            if (d3 < d2 && d2 - d3 > com.ss.android.downloadlib.addownload.d.b()) {
                com.ss.android.downloadlib.addownload.d.a(downloadInfo.getId());
            }
        }
        com.ss.android.socialbase.downloader.a.a.a().a(new a.InterfaceC2213a() { // from class: com.ss.android.downloadlib.c.3
            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC2213a
            public void b() {
                if (!l.b(bVar)) {
                    long j2 = a2;
                    if (j2 <= -1 || totalBytes <= -1 || j2 >= d2) {
                        return;
                    }
                    com.ss.android.downloadlib.d.a.a().a("clean_space_install", com.ss.android.downloadlib.addownload.d.a("install_no_enough_space"), bVar);
                    if (com.ss.android.downloadlib.addownload.d.a(downloadInfo, ((long) d2) - a2)) {
                        com.ss.android.socialbase.downloader.a.a.a().b(this);
                        bVar.g(true);
                        return;
                    }
                    return;
                }
                com.ss.android.socialbase.downloader.a.a.a().b(this);
            }

            @Override // com.ss.android.socialbase.downloader.a.a.InterfaceC2213a
            public void c() {
            }
        });
    }

    private void a(@NonNull DownloadInfo downloadInfo) {
        if (com.ss.android.downloadlib.g.e.f(downloadInfo.getId())) {
            d.a().b(new com.ss.android.downloadlib.addownload.c.b(downloadInfo));
        }
    }
}
