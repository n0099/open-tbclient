package com.ss.android.downloadlib.d;

import android.content.Context;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.f.i;
import com.ss.android.downloadlib.h;
import com.ss.android.socialbase.downloader.downloader.f;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c implements com.ss.android.socialbase.appdownloader.c.d {

    /* renamed from: a  reason: collision with root package name */
    private Context f12980a;

    public c(Context context) {
        this.f12980a = context.getApplicationContext();
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public void a(Context context, String str) {
        com.ss.android.downloadlib.b.eEw().a(str);
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public void a(int i, int i2, String str, int i3, long j) {
        com.ss.android.socialbase.downloader.g.c h;
        Context context = this.f12980a;
        if (context != null && (h = f.iB(context).h(i)) != null && h.q() != 0) {
            com.ss.android.b.a.b.a j2 = com.ss.android.downloadlib.a.b.d.eEB().j(h);
            if (j2 == null) {
                i.b();
                return;
            }
            switch (i2) {
                case 1:
                    com.ss.android.downloadlib.b.a(h, j2);
                    if ("application/vnd.android.package-archive".equals(h.eHn())) {
                        com.ss.android.downloadlib.a.a.eEx().a(h, j2.j(), j2.k(), j2.m(), h.i(), j2.o(), h.n());
                        return;
                    }
                    return;
                case 2:
                case 4:
                default:
                    return;
                case 3:
                    com.ss.android.downloadlib.e.a.eFk().a("download_notification", "download_notification_install", com.ss.android.downloadlib.b.a(new JSONObject(), h), j2);
                    return;
                case 5:
                    com.ss.android.downloadlib.e.a.eFk().a("download_notification", "download_notification_pause", j2);
                    return;
                case 6:
                    com.ss.android.downloadlib.e.a.eFk().a("download_notification", "download_notification_continue", j2);
                    return;
                case 7:
                    com.ss.android.downloadlib.e.a.eFk().a("download_notification", "download_notification_click", j2);
                    return;
            }
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public boolean a(int i, boolean z) {
        if (j.eEX() == null) {
            return false;
        }
        return j.eEX().a(z);
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public void a(com.ss.android.socialbase.downloader.g.c cVar) {
        if (cVar != null) {
            h.eFl().a(cVar);
            if (com.ss.android.socialbase.downloader.k.a.RW(cVar.g()).a("report_download_cancel", 1) == 1) {
                com.ss.android.downloadlib.e.a.eFk().a(cVar, new com.ss.android.socialbase.downloader.e.a(1012, ""));
            } else {
                com.ss.android.downloadlib.e.a.eFk().b(cVar, new com.ss.android.socialbase.downloader.e.a(1012, ""));
            }
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public void a(int i, int i2, String str, String str2, String str3) {
        com.ss.android.socialbase.downloader.g.c h;
        if (this.f12980a != null && (h = f.iB(this.f12980a).h(i)) != null && h.q() == -3) {
            h.e(str2);
            com.ss.android.downloadlib.a.b.eEz().a(this.f12980a, h);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.c.d
    public boolean a() {
        return com.ss.android.downloadlib.a.b.eEz().b();
    }
}
