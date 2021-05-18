package d.o.a.d.f;

import android.net.http.Headers;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.d.f.c;
import d.o.a.d.f.i;
import d.o.a.d.j;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public Handler f66783a;

    /* renamed from: b  reason: collision with root package name */
    public c.f f66784b;

    /* renamed from: c  reason: collision with root package name */
    public AtomicBoolean f66785c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    public AtomicBoolean f66786d = new AtomicBoolean(false);

    /* loaded from: classes7.dex */
    public class a implements i.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f66787a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f66788b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.o.a.b.a.c.b f66789c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f66790d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.f f66791e;

        public a(int i2, String str, d.o.a.b.a.c.b bVar, long j, i.f fVar) {
            this.f66787a = i2;
            this.f66788b = str;
            this.f66789c = bVar;
            this.f66790d = j;
            this.f66791e = fVar;
        }

        @Override // d.o.a.d.f.i.g
        public void a(long j) {
            h.this.g(this.f66787a, this.f66788b, j, this.f66789c, this.f66790d, this.f66791e);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.f f66793e;

        public b(i.f fVar) {
            this.f66793e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f66785c.get()) {
                return;
            }
            h.this.f66785c.set(true);
            this.f66793e.a();
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.o.a.e.b.o.l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i.g f66795a;

        public c(i.g gVar) {
            this.f66795a = gVar;
        }

        @Override // d.o.a.e.b.o.l
        public void a(Map<String, String> map) {
            if (h.this.f66785c.get()) {
                return;
            }
            h.this.f66785c.set(true);
            long b2 = h.this.b(map);
            if (b2 > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("apk_size", Long.valueOf(b2));
                    jSONObject.putOpt("available_space", Long.valueOf(h.t()));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            this.f66795a.a(b2);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements d.o.a.d.f.d.e {
        public d(h hVar, d.o.a.b.a.c.b bVar, i.f fVar, String str) {
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.f f66797e;

        public e(h hVar, i.f fVar) {
            this.f66797e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f66797e.a();
        }
    }

    /* loaded from: classes7.dex */
    public static class f implements d.o.a.d.f.d.e {
        public f(DownloadInfo downloadInfo) {
        }
    }

    /* loaded from: classes7.dex */
    public class g {
        public static void a(DownloadInfo downloadInfo, long j, String str, String str2) {
        }
    }

    public h(Handler handler) {
        this.f66783a = handler;
    }

    public static JSONObject d(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("clean_space_install_params", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public static void e(int i2) {
        if (d.o.a.d.n.e.n(i2) && n.v() != null && n.v().b()) {
            n.v().c();
        }
    }

    public static void h(d.o.a.b.a.c.b bVar) {
        long t = t();
        if (n.v() != null) {
            n.v().e();
        }
        d.o.a.d.f.d.c.a();
        d.o.a.d.f.d.c.e();
        if (d.o.a.d.n.e.o(bVar.s())) {
            d.o.a.d.f.d.c.b(n.a());
        }
        long t2 = t();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(t2 - t));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        j.c.a().u("clean_quite_finish", jSONObject, bVar);
    }

    public static boolean p(DownloadInfo downloadInfo, long j) {
        int c0 = downloadInfo.c0();
        boolean z = false;
        if (d.o.a.d.n.e.n(c0)) {
            if (n.v() != null && (z = n.v().a(c0, downloadInfo.T0(), false, j))) {
                d.o.a.d.f.d.d.a().e(downloadInfo.T0(), new f(downloadInfo));
            }
            return z;
        }
        return false;
    }

    public static long q() {
        if (n.v() != null) {
            return n.v().a();
        }
        return 0L;
    }

    public static long t() {
        return d.o.a.d.n.k.d(0L);
    }

    public final long b(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String value = entry.getValue();
                    if (Headers.CONTENT_LEN.equalsIgnoreCase(entry.getKey())) {
                        return Long.parseLong(value);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 0L;
    }

    public void f(int i2, long j, long j2, i.f fVar) {
        this.f66786d.set(false);
        if (fVar == null) {
            return;
        }
        if (d.o.a.d.n.e.n(i2) && d.o.a.d.n.e.m(i2)) {
            long k = d.o.a.d.n.e.k(i2);
            this.f66785c.set(false);
            String a2 = this.f66784b.f66716b.a();
            d.o.a.b.a.c.b o = c.g.e().o(a2);
            if (o == null) {
                c.f fVar2 = this.f66784b;
                o = new d.o.a.b.a.c.b(fVar2.f66716b, fVar2.f66717c, fVar2.f66718d, 0);
                c.g.e().j(o);
            }
            d.o.a.b.a.c.b bVar = o;
            bVar.y0(false);
            if (n.v() != null) {
                n.v().a(bVar.b());
            }
            d.o.a.d.f.d.d.a().d(bVar.a());
            boolean l = d.o.a.d.n.e.l(i2);
            if (j2 > 0) {
                g(i2, a2, j2, bVar, j, fVar);
            } else if (l) {
                l(a2, bVar, new a(i2, a2, bVar, j, fVar));
            } else {
                k = 0;
            }
            this.f66783a.postDelayed(new b(fVar), k);
            return;
        }
        fVar.a();
    }

    public final void g(int i2, String str, long j, d.o.a.b.a.c.b bVar, long j2, i.f fVar) {
        this.f66785c.set(true);
        boolean z = false;
        if (j > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("apk_size", Long.valueOf(j));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            long longValue = (Double.valueOf((d.o.a.d.n.e.a(i2) + 1.0d) * j).longValue() + d.o.a.d.n.e.f(i2)) - j2;
            long t = t();
            if (t < longValue) {
                i(bVar, jSONObject, longValue, t);
                h(bVar);
                long t2 = t();
                if (t2 < longValue) {
                    bVar.u0(true);
                    String a2 = bVar.a();
                    d.o.a.d.f.d.d.a().e(a2, new d(this, bVar, fVar, a2));
                    z = o(i2, bVar, str, longValue);
                    if (z) {
                        bVar.y0(true);
                    }
                } else {
                    r(bVar, jSONObject, t, t2);
                }
            }
        }
        if (z) {
            return;
        }
        this.f66783a.post(new e(this, fVar));
    }

    public final void i(d.o.a.b.a.c.b bVar, JSONObject jSONObject, long j, long j2) {
        try {
            jSONObject.putOpt("available_space", Long.valueOf(j2));
            jSONObject.putOpt("apk_download_need_size", Long.valueOf(j));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        j.c.a().u("clean_space_no_enough_for_download", jSONObject, bVar);
    }

    public void j(c.f fVar) {
        this.f66784b = fVar;
    }

    public final void l(String str, d.o.a.b.a.c.b bVar, i.g gVar) {
        if (gVar == null) {
            return;
        }
        d.o.a.e.b.o.b.b.c(str, new c(gVar));
    }

    public void m(boolean z) {
        this.f66786d.set(z);
    }

    public boolean n() {
        return this.f66786d.get();
    }

    public final boolean o(int i2, @NonNull d.o.a.b.a.c.b bVar, String str, long j) {
        if (d.o.a.d.n.e.n(i2)) {
            if (n.v() != null) {
                return n.v().a(i2, str, true, j);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("show_dialog_result", 3);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            j.c.a().u("cleanspace_window_show", jSONObject, bVar);
            return false;
        }
        return false;
    }

    public final void r(d.o.a.b.a.c.b bVar, JSONObject jSONObject, long j, long j2) {
        bVar.W0("1");
        c.j.b().c(bVar);
        try {
            jSONObject.putOpt("quite_clean_size", Long.valueOf(j2 - j));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        j.c.a().u("cleanspace_download_after_quite_clean", jSONObject, bVar);
    }
}
