package d.o.a.d.f.d;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.d.f.c;
import d.o.a.d.f.n;
import d.o.a.d.j;
import d.o.a.d.n.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public DownloadInfo f66736e;

    /* loaded from: classes7.dex */
    public class a implements e {
        public a(b bVar, d.o.a.b.a.c.b bVar2) {
        }
    }

    public b(DownloadInfo downloadInfo) {
        this.f66736e = downloadInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        d.o.a.b.a.c.b c2;
        if (this.f66736e == null || (c2 = c.g.e().c(this.f66736e)) == null) {
            return;
        }
        j.c.a().o("cleanspace_task", c2);
        long longValue = Double.valueOf((d.o.a.d.n.e.a(this.f66736e.c0()) + 1.0d) * this.f66736e.Q0()).longValue() - this.f66736e.E();
        long d2 = k.d(0L);
        if (n.v() != null) {
            n.v().e();
        }
        c.a();
        c.e();
        if (d.o.a.d.n.e.o(c2.s())) {
            c.b(n.a());
        }
        long d3 = k.d(0L);
        if (d3 >= longValue) {
            c2.W0("1");
            c.j.b().c(c2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("quite_clean_size", Long.valueOf(d3 - d2));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            j.c.a().u("cleanspace_download_after_quite_clean", jSONObject, c2);
            d.o.a.e.b.g.a.l(n.a()).z(this.f66736e.c0());
        } else if (n.v() != null) {
            c2.u0(false);
            d.a().e(c2.a(), new a(this, c2));
            if (n.v().a(this.f66736e.c0(), this.f66736e.T0(), true, longValue)) {
                c2.y0(true);
            }
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.putOpt("show_dialog_result", 3);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            j.c.a().u("cleanspace_window_show", jSONObject2, c2);
        }
    }
}
