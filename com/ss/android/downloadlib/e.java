package com.ss.android.downloadlib;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.a.j;
/* loaded from: classes4.dex */
public class e implements com.ss.android.socialbase.appdownloader.c.h {

    /* renamed from: a  reason: collision with root package name */
    private static String f12982a = e.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private Handler f12983b = new Handler(Looper.getMainLooper());

    @Override // com.ss.android.socialbase.appdownloader.c.h
    public void a(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar, int i) {
        com.ss.android.b.a.b.a j;
        final com.ss.android.a.a.b.c iY;
        if (cVar != null && (j = com.ss.android.downloadlib.a.b.d.eCc().j(cVar)) != null) {
            try {
                if (i == -1) {
                    com.ss.android.socialbase.downloader.e.a aVar2 = null;
                    if (aVar != null) {
                        if (com.ss.android.socialbase.downloader.m.d.J(aVar)) {
                            if (j.eCw() != null) {
                                j.eCw().a(j.j());
                            }
                            com.ss.android.downloadlib.e.a.eCL().a("download_failed_for_space", j);
                            if (!j.F()) {
                                j.e(true);
                                com.ss.android.downloadlib.e.a.eCL().a("download_can_restart", j);
                                a(cVar, j);
                            }
                            if ((j.eCw() == null || !j.eCw().a()) && (iY = com.ss.android.downloadlib.a.b.d.eCc().iY(j.j())) != null && iY.k()) {
                                final com.ss.android.socialbase.downloader.k.a RA = com.ss.android.socialbase.downloader.k.a.RA(cVar.g());
                                if (RA.a("show_no_enough_space_toast", 0) == 1) {
                                    this.f12983b.post(new Runnable() { // from class: com.ss.android.downloadlib.e.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            j.eCo().a(2, j.a(), iY, RA.a("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
                                        }
                                    });
                                }
                            }
                        }
                        aVar2 = new com.ss.android.socialbase.downloader.e.a(aVar.a(), com.ss.android.downloadlib.f.i.a(aVar.getMessage(), j.i().optInt("exception_msg_length", 500)));
                    }
                    com.ss.android.downloadlib.e.a.eCL().b(cVar, aVar2);
                    h.eCM().a(cVar, aVar, "");
                } else if (i == -3) {
                    b.a(cVar, j);
                } else if (i == 2001) {
                    b.eBX().a(cVar, j, 2001);
                } else if (i == 11) {
                    b.eBX().a(cVar, j, 2000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void a(@NonNull com.ss.android.socialbase.downloader.g.c cVar, @NonNull com.ss.android.b.a.b.a aVar) {
        if (!com.ss.android.downloadlib.f.d.QJ(cVar.g())) {
            com.ss.android.downloadlib.e.a.eCL().a("clean_space_switch_closed", aVar);
            return;
        }
        com.ss.android.downloadlib.e.a.eCL().a("cleanspace_switch_open", aVar);
        f.eCI().b(new com.ss.android.downloadlib.a.c.b(cVar));
    }
}
