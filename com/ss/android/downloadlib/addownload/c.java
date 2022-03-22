package com.ss.android.downloadlib.addownload;

import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class c {
    public static String a = "c";

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f42785b;

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<Long, Runnable> f42786c;

    public c() {
        this.f42786c = null;
        this.f42786c = new ConcurrentHashMap<>();
    }

    public static c a() {
        if (f42785b == null) {
            synchronized (c.class) {
                if (f42785b == null) {
                    f42785b = new c();
                }
            }
        }
        return f42785b;
    }

    public long b() {
        return j.i().optLong("quick_app_check_internal", IMLikeRequest.TIME_INTERVAL);
    }

    public void a(e eVar, boolean z, int i, DownloadModel downloadModel) {
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        long id = downloadModel.getId();
        if (i == 4) {
            if (!z) {
                a(id, false, 2);
                eVar.b(false);
                return;
            }
            a(id, true, 2);
        } else if (i == 5) {
            if (!z) {
                a(id, false, 1);
                eVar.c(false);
                return;
            }
            a(id, true, 1);
        } else if (i != 7) {
        } else {
            Runnable remove = this.f42786c.remove(Long.valueOf(id));
            if (z) {
                com.ss.android.downloadlib.d.a.a().a(id, 1);
                a(id, true, 1);
                return;
            }
            if (remove != null) {
                com.ss.android.downloadlib.f.a().b().post(remove);
            }
            a(id, false, 1);
        }
    }

    private void a(long j, boolean z, int i) {
        com.ss.android.downloadlib.d.a.a().a(j, z, i);
        if (z) {
            j.t().a(null, null, null, null, null, 3);
        }
    }

    public void a(final e eVar, final int i, final DownloadModel downloadModel) {
        com.ss.android.downloadlib.b.e.a().a(new com.ss.android.downloadlib.b.d() { // from class: com.ss.android.downloadlib.addownload.c.1
            @Override // com.ss.android.downloadlib.b.d
            public void a(boolean z) {
                c.this.a(eVar, z, i, downloadModel);
            }
        }, b());
    }

    public static boolean a(DownloadInfo downloadInfo) {
        return downloadInfo == null || downloadInfo.getStatus() == 0 || downloadInfo.getStatus() == -4;
    }
}
