package com.ss.android.downloadlib.a;

import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.impls.r;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l {
    private static com.ss.android.downloadlib.a.a.d qch;

    public static com.ss.android.downloadlib.a.a.d eEU() {
        return qch;
    }

    public static void a(com.ss.android.downloadlib.a.a.d dVar) {
        qch = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final com.ss.android.b.a.b.a aVar, com.ss.android.socialbase.downloader.g.c cVar, int i) {
        if (aVar == null || cVar == null) {
            com.ss.android.downloadlib.f.i.b();
            return;
        }
        final int g = cVar.g();
        boolean n = com.ss.android.downloadlib.f.d.n(g);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("switch_status", Integer.valueOf(n ? 1 : 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.ss.android.downloadlib.e.a.eFc().a("pause_reserve_wifi_switch_status", jSONObject, aVar);
        if (n && a(i)) {
            if (com.ss.android.socialbase.downloader.m.d.a(j.a())) {
                if (cVar.U()) {
                    cVar.Y();
                    com.ss.android.downloadlib.e.a.eFc().a("pause_reserve_wifi_cancel_on_wifi", aVar);
                }
            } else if (!cVar.V()) {
                a(new com.ss.android.downloadlib.a.a.d() { // from class: com.ss.android.downloadlib.a.l.1
                    @Override // com.ss.android.downloadlib.a.a.d
                    public void a() {
                        l.a((com.ss.android.downloadlib.a.a.d) null);
                        com.ss.android.socialbase.downloader.g.c h = com.ss.android.socialbase.downloader.downloader.f.iB(j.a()).h(g);
                        if (h != null) {
                            h.X();
                            r.eIt().a(h);
                            com.ss.android.downloadlib.e.a.eFc().a("pause_reserve_wifi_confirm", aVar);
                        }
                    }

                    @Override // com.ss.android.downloadlib.a.a.d
                    public void b() {
                        l.a((com.ss.android.downloadlib.a.a.d) null);
                        com.ss.android.socialbase.downloader.g.c h = com.ss.android.socialbase.downloader.downloader.f.iB(j.a()).h(g);
                        if (h != null) {
                            h.Y();
                        }
                        com.ss.android.downloadlib.e.a.eFc().a("pause_reserve_wifi_cancel", aVar);
                    }
                });
                TTDelegateActivity.b(aVar.j());
            }
        }
    }

    public static boolean a(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 7 || i == 8;
    }
}
