package com.ss.android.downloadlib.addownload;

import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class c {
    public static String a = "c";

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f59520b;

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<Long, Runnable> f59521c;

    public c() {
        this.f59521c = null;
        this.f59521c = new ConcurrentHashMap<>();
    }

    public static c a() {
        if (f59520b == null) {
            synchronized (c.class) {
                if (f59520b == null) {
                    f59520b = new c();
                }
            }
        }
        return f59520b;
    }

    public long b() {
        return j.i().optLong("quick_app_check_internal", IMLikeRequest.TIME_INTERVAL);
    }

    public void a(e eVar, boolean z, int i2, DownloadModel downloadModel) {
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        long id = downloadModel.getId();
        if (i2 == 4) {
            if (!z) {
                a(id, false, 2);
                eVar.b(false);
                return;
            }
            a(id, true, 2);
        } else if (i2 == 5) {
            if (!z) {
                a(id, false, 1);
                eVar.c(false);
                return;
            }
            a(id, true, 1);
        } else if (i2 != 7) {
        } else {
            Runnable remove = this.f59521c.remove(Long.valueOf(id));
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

    private void a(long j2, boolean z, int i2) {
        com.ss.android.downloadlib.d.a.a().a(j2, z, i2);
        if (z) {
            j.t().a(null, null, null, null, null, 3);
        }
    }

    public void a(final e eVar, final int i2, final DownloadModel downloadModel) {
        com.ss.android.downloadlib.b.e.a().a(new com.ss.android.downloadlib.b.d() { // from class: com.ss.android.downloadlib.addownload.c.1
            @Override // com.ss.android.downloadlib.b.d
            public void a(boolean z) {
                c.this.a(eVar, z, i2, downloadModel);
            }
        }, b());
    }

    public static boolean a(DownloadInfo downloadInfo) {
        return downloadInfo == null || downloadInfo.getStatus() == 0 || downloadInfo.getStatus() == -4;
    }
}
