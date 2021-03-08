package com.ss.android.downloadlib;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.a.j;
/* loaded from: classes6.dex */
public class e implements com.ss.android.socialbase.appdownloader.c.h {

    /* renamed from: a  reason: collision with root package name */
    private static String f7730a = e.class.getSimpleName();
    private Handler b = new Handler(Looper.getMainLooper());

    @Override // com.ss.android.socialbase.appdownloader.c.h
    public void a(com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar, int i) {
        com.ss.android.b.a.b.a j;
        final com.ss.android.a.a.b.c jb;
        if (cVar != null && (j = com.ss.android.downloadlib.a.b.d.eEF().j(cVar)) != null) {
            try {
                if (i == -1) {
                    com.ss.android.socialbase.downloader.e.a aVar2 = null;
                    if (aVar != null) {
                        if (com.ss.android.socialbase.downloader.m.d.I(aVar)) {
                            if (j.eEZ() != null) {
                                j.eEZ().a(j.j());
                            }
                            com.ss.android.downloadlib.e.a.eFo().a("download_failed_for_space", j);
                            if (!j.F()) {
                                j.e(true);
                                com.ss.android.downloadlib.e.a.eFo().a("download_can_restart", j);
                                a(cVar, j);
                            }
                            if ((j.eEZ() == null || !j.eEZ().a()) && (jb = com.ss.android.downloadlib.a.b.d.eEF().jb(j.j())) != null && jb.k()) {
                                final com.ss.android.socialbase.downloader.k.a Sa = com.ss.android.socialbase.downloader.k.a.Sa(cVar.g());
                                if (Sa.a("show_no_enough_space_toast", 0) == 1) {
                                    this.b.post(new Runnable() { // from class: com.ss.android.downloadlib.e.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            j.eER().a(2, j.a(), jb, Sa.a("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
                                        }
                                    });
                                }
                            }
                        }
                        aVar2 = new com.ss.android.socialbase.downloader.e.a(aVar.a(), com.ss.android.downloadlib.f.i.a(aVar.getMessage(), j.i().optInt("exception_msg_length", 500)));
                    }
                    com.ss.android.downloadlib.e.a.eFo().b(cVar, aVar2);
                    h.eFp().a(cVar, aVar, "");
                } else if (i == -3) {
                    b.a(cVar, j);
                } else if (i == 2001) {
                    b.eEA().a(cVar, j, 2001);
                } else if (i == 11) {
                    b.eEA().a(cVar, j, 2000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void a(@NonNull com.ss.android.socialbase.downloader.g.c cVar, @NonNull com.ss.android.b.a.b.a aVar) {
        if (!com.ss.android.downloadlib.f.d.Rj(cVar.g())) {
            com.ss.android.downloadlib.e.a.eFo().a("clean_space_switch_closed", aVar);
            return;
        }
        com.ss.android.downloadlib.e.a.eFo().a("cleanspace_switch_open", aVar);
        f.eFl().b(new com.ss.android.downloadlib.a.c.b(cVar));
    }
}
