package d.o.a.d.f;

import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.d.f.g;
import d.o.a.d.j;
import d.o.a.e.b.m.q;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public static d.o.a.d.f.a.c f66836a;

    /* loaded from: classes7.dex */
    public static class a implements d.o.a.d.f.a.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f66837a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.o.a.b.a.c.b f66838b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g.InterfaceC1866g f66839c;

        public a(int i2, d.o.a.b.a.c.b bVar, g.InterfaceC1866g interfaceC1866g) {
            this.f66837a = i2;
            this.f66838b = bVar;
            this.f66839c = interfaceC1866g;
        }

        @Override // d.o.a.d.f.a.c
        public void a() {
            p.b(null);
            DownloadInfo f2 = d.o.a.e.b.g.a.l(n.a()).f(this.f66837a);
            if (f2 != null) {
                f2.j3();
                q.d().k(f2);
                j.c.a().n("pause_reserve_wifi_confirm", this.f66838b);
            }
            this.f66839c.a(this.f66838b);
        }

        @Override // d.o.a.d.f.a.c
        public void b() {
            p.b(null);
            DownloadInfo f2 = d.o.a.e.b.g.a.l(n.a()).f(this.f66837a);
            if (f2 != null) {
                f2.l3();
            }
            j.c.a().n("pause_reserve_wifi_cancel", this.f66838b);
            this.f66839c.a(this.f66838b);
        }
    }

    public static d.o.a.d.f.a.c a() {
        return f66836a;
    }

    public static void b(d.o.a.d.f.a.c cVar) {
        f66836a = cVar;
    }

    public static boolean c(int i2) {
        return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 7 || i2 == 8;
    }

    public static boolean d(d.o.a.b.a.c.b bVar, DownloadInfo downloadInfo, int i2, g.InterfaceC1866g interfaceC1866g) {
        if (bVar != null && downloadInfo != null) {
            int c0 = downloadInfo.c0();
            boolean h2 = d.o.a.d.n.e.h(bVar);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("switch_status", Integer.valueOf(h2 ? 1 : 0));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            j.c.a().u("pause_reserve_wifi_switch_status", jSONObject, bVar);
            if (h2 && c(i2)) {
                if (d.o.a.e.b.l.e.d0(n.a())) {
                    if (downloadInfo.L1()) {
                        downloadInfo.l3();
                        j.c.a().n("pause_reserve_wifi_cancel_on_wifi", bVar);
                    }
                } else if (!downloadInfo.X0()) {
                    b(new a(c0, bVar, interfaceC1866g));
                    TTDelegateActivity.b(bVar);
                    return true;
                }
                return false;
            }
            return false;
        }
        d.o.a.d.n.k.B();
        return false;
    }
}
