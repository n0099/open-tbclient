package com.ss.android.downloadlib;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.h;
import com.ss.android.download.api.config.i;
import com.ss.android.download.api.config.k;
import com.ss.android.download.api.config.p;
import com.ss.android.download.api.config.t;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
/* loaded from: classes7.dex */
public class e implements com.ss.android.download.api.a {
    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(@NonNull h hVar) {
        j.a(hVar);
        return this;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(@NonNull com.ss.android.download.api.config.f fVar) {
        j.a(fVar);
        return this;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(@NonNull k kVar) {
        j.a(kVar);
        return this;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(@NonNull com.ss.android.download.api.config.g gVar) {
        j.a(gVar);
        return this;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(@NonNull i iVar) {
        j.a(iVar);
        return this;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(@NonNull com.ss.android.download.api.model.a aVar) {
        j.a(aVar);
        return this;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(String str) {
        j.a(str);
        return this;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(@NonNull final com.ss.android.download.api.config.b bVar) {
        j.a(bVar);
        com.ss.android.socialbase.downloader.a.a.a().a(new a.c() { // from class: com.ss.android.downloadlib.e.1
        });
        return this;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder.getNotificationClickCallback() == null) {
            downloaderBuilder.notificationClickCallback(new af() { // from class: com.ss.android.downloadlib.e.2
                private boolean d(DownloadInfo downloadInfo) {
                    String a;
                    t r = j.r();
                    if (r != null) {
                        com.ss.android.downloadad.api.a.b a2 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
                        if (a2 != null && a2.c()) {
                            a = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("ad_notification_jump_url", (String) null);
                        } else {
                            a = com.ss.android.downloadlib.addownload.h.a(downloadInfo);
                        }
                        if (TextUtils.isEmpty(a)) {
                            return false;
                        }
                        return r.a(j.getContext(), a);
                    }
                    return false;
                }

                @Override // com.ss.android.socialbase.downloader.depend.af
                public boolean a(DownloadInfo downloadInfo) {
                    com.ss.android.socialbase.downloader.g.a a = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
                    if (a.b("notification_opt_2") == 1) {
                        if (downloadInfo.getStatus() == -2) {
                            DownloadHandlerService.a(j.getContext(), downloadInfo, com.ss.android.socialbase.appdownloader.d.j().b(), Downloader.getInstance(j.getContext()).getDownloadNotificationEventListener(downloadInfo.getId()));
                        }
                        return true;
                    }
                    boolean d2 = d(downloadInfo);
                    if (a.a("disable_delete_dialog", 0) == 1) {
                        return true;
                    }
                    return d2;
                }

                @Override // com.ss.android.socialbase.downloader.depend.af
                public boolean b(DownloadInfo downloadInfo) {
                    return false;
                }

                @Override // com.ss.android.socialbase.downloader.depend.af
                public boolean c(DownloadInfo downloadInfo) {
                    if (downloadInfo == null) {
                        return false;
                    }
                    com.ss.android.downloadad.api.a.b a = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
                    if (a != null) {
                        com.ss.android.downloadlib.b.a.a(a);
                    } else {
                        com.ss.android.downloadlib.g.i.b(j.getContext(), downloadInfo.getPackageName());
                    }
                    com.ss.android.socialbase.downloader.notification.b.a().f(downloadInfo.getId());
                    return true;
                }
            });
        }
        downloaderBuilder.addDownloadCompleteHandler(new com.ss.android.downloadlib.c.c());
        Downloader.initOrCover(downloaderBuilder, true);
        return this;
    }

    @Override // com.ss.android.download.api.a
    public com.ss.android.download.api.a a(p pVar) {
        j.a(pVar);
        return this;
    }

    @Override // com.ss.android.download.api.a
    public void a() {
        if (!j.v()) {
            com.ss.android.downloadlib.e.c.a().a("ttdownloader init error");
        }
        j.a(com.ss.android.downloadlib.e.c.a());
        try {
            com.ss.android.socialbase.appdownloader.d.j().b(j.u());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.appdownloader.d.j().a(a.a());
        d.a().b(new Runnable() { // from class: com.ss.android.downloadlib.e.3
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.f.d.a("");
                if (com.ss.android.socialbase.appdownloader.f.d.n()) {
                    com.ss.android.socialbase.downloader.downloader.c.a(true);
                }
                com.ss.android.socialbase.appdownloader.f.e.a(j.getContext());
            }
        });
    }
}
