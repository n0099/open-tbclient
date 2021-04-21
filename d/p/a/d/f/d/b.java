package d.p.a.d.f.d;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.p.a.d.f.c;
import d.p.a.d.f.n;
import d.p.a.d.j;
import d.p.a.d.n.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public DownloadInfo f67704e;

    /* loaded from: classes6.dex */
    public class a implements e {
        public a(b bVar, d.p.a.b.a.c.b bVar2) {
        }
    }

    public b(DownloadInfo downloadInfo) {
        this.f67704e = downloadInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        d.p.a.b.a.c.b c2;
        if (this.f67704e == null || (c2 = c.g.e().c(this.f67704e)) == null) {
            return;
        }
        j.c.a().o("cleanspace_task", c2);
        long longValue = Double.valueOf((d.p.a.d.n.e.a(this.f67704e.c0()) + 1.0d) * this.f67704e.Q0()).longValue() - this.f67704e.E();
        long d2 = k.d(0L);
        if (n.v() != null) {
            n.v().e();
        }
        c.a();
        c.e();
        if (d.p.a.d.n.e.o(c2.s())) {
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
            d.p.a.e.b.g.a.l(n.a()).z(this.f67704e.c0());
        } else if (n.v() != null) {
            c2.u0(false);
            d.a().e(c2.a(), new a(this, c2));
            if (n.v().a(this.f67704e.c0(), this.f67704e.T0(), true, longValue)) {
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
