package d.p.a.d.f;

import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.p.a.d.f.g;
import d.p.a.d.j;
import d.p.a.e.b.m.q;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public static d.p.a.d.f.a.c f67801a;

    /* loaded from: classes6.dex */
    public static class a implements d.p.a.d.f.a.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f67802a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.p.a.b.a.c.b f67803b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g.InterfaceC1867g f67804c;

        public a(int i, d.p.a.b.a.c.b bVar, g.InterfaceC1867g interfaceC1867g) {
            this.f67802a = i;
            this.f67803b = bVar;
            this.f67804c = interfaceC1867g;
        }

        @Override // d.p.a.d.f.a.c
        public void a() {
            p.b(null);
            DownloadInfo f2 = d.p.a.e.b.g.a.l(n.a()).f(this.f67802a);
            if (f2 != null) {
                f2.j3();
                q.d().k(f2);
                j.c.a().n("pause_reserve_wifi_confirm", this.f67803b);
            }
            this.f67804c.a(this.f67803b);
        }

        @Override // d.p.a.d.f.a.c
        public void b() {
            p.b(null);
            DownloadInfo f2 = d.p.a.e.b.g.a.l(n.a()).f(this.f67802a);
            if (f2 != null) {
                f2.l3();
            }
            j.c.a().n("pause_reserve_wifi_cancel", this.f67803b);
            this.f67804c.a(this.f67803b);
        }
    }

    public static d.p.a.d.f.a.c a() {
        return f67801a;
    }

    public static void b(d.p.a.d.f.a.c cVar) {
        f67801a = cVar;
    }

    public static boolean c(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 7 || i == 8;
    }

    public static boolean d(d.p.a.b.a.c.b bVar, DownloadInfo downloadInfo, int i, g.InterfaceC1867g interfaceC1867g) {
        if (bVar != null && downloadInfo != null) {
            int c0 = downloadInfo.c0();
            boolean h2 = d.p.a.d.n.e.h(bVar);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("switch_status", Integer.valueOf(h2 ? 1 : 0));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            j.c.a().u("pause_reserve_wifi_switch_status", jSONObject, bVar);
            if (h2 && c(i)) {
                if (d.p.a.e.b.l.e.d0(n.a())) {
                    if (downloadInfo.L1()) {
                        downloadInfo.l3();
                        j.c.a().n("pause_reserve_wifi_cancel_on_wifi", bVar);
                    }
                } else if (!downloadInfo.X0()) {
                    b(new a(c0, bVar, interfaceC1867g));
                    TTDelegateActivity.b(bVar);
                    return true;
                }
                return false;
            }
            return false;
        }
        d.p.a.d.n.k.B();
        return false;
    }
}
