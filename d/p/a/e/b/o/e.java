package d.p.a.e.b.o;

import android.net.Uri;
import android.os.Handler;
import java.net.InetAddress;
import java.util.List;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.i.g<String, d> f68379a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f68380b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f68381c;

    /* loaded from: classes6.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f68382e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f68383f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f68384g;

        public a(String str, c cVar, long j) {
            this.f68382e = str;
            this.f68383f = cVar;
            this.f68384g = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.e(this.f68382e, this.f68383f, this.f68384g);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f68386e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f68387f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f68388g;

        public b(e eVar, c cVar, String str, d dVar) {
            this.f68386e = cVar;
            this.f68387f = str;
            this.f68388g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = this.f68386e;
            if (cVar != null) {
                String str = this.f68387f;
                d dVar = this.f68388g;
                cVar.a(str, dVar == null ? null : dVar.f68389a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(String str, List<InetAddress> list);
    }

    /* loaded from: classes6.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public List<InetAddress> f68389a;

        /* renamed from: b  reason: collision with root package name */
        public long f68390b;

        public d() {
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* renamed from: d.p.a.e.b.o.e$e  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1893e {

        /* renamed from: a  reason: collision with root package name */
        public static final e f68391a = new e(null);
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static e a() {
        return C1893e.f68391a;
    }

    public void c(String str, c cVar, long j) {
        this.f68380b.post(new a(str, cVar, j));
    }

    public final void d(String str, List<InetAddress> list) {
        synchronized (this.f68379a) {
            d dVar = this.f68379a.get(str);
            if (dVar == null) {
                dVar = new d(null);
                this.f68379a.put(str, dVar);
            }
            dVar.f68389a = list;
            dVar.f68390b = System.currentTimeMillis();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0085, code lost:
        r10 = r2.f68389a;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008e A[Catch: all -> 0x0095, TRY_LEAVE, TryCatch #2 {all -> 0x0095, blocks: (B:2:0x0000, B:3:0x000a, B:7:0x0016, B:10:0x0034, B:12:0x003a, B:14:0x0052, B:21:0x0063, B:29:0x0078, B:32:0x007f, B:35:0x0087, B:37:0x008e, B:34:0x0085, B:23:0x0069, B:24:0x006d, B:4:0x000b, B:5:0x0013, B:16:0x0058), top: B:45:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(String str, c cVar, long j) {
        d dVar;
        h F0;
        try {
            String host = Uri.parse(str).getHost();
            synchronized (this.f68379a) {
                dVar = this.f68379a.get(host);
            }
            if (dVar != null) {
                if (System.currentTimeMillis() - dVar.f68390b < d.p.a.e.b.j.a.r().b("dns_expire_min", 10) * 60 * 1000) {
                    if (cVar != null) {
                        cVar.a(str, dVar.f68389a);
                        return;
                    }
                    return;
                }
            }
            b bVar = new b(this, cVar, str, dVar);
            this.f68381c.postDelayed(bVar, j);
            List<InetAddress> list = null;
            if (d.p.a.e.b.j.a.r().b("use_host_dns", 1) == 1 && (F0 = d.p.a.e.b.g.d.F0()) != null) {
                list = F0.a(host);
            }
            if (list == null || list.isEmpty()) {
                list = d.p.a.e.b.g.d.G0().a(host);
            }
            if (list != null && !list.isEmpty()) {
                d(host, list);
                this.f68381c.removeCallbacks(bVar);
                if (cVar == null) {
                    cVar.a(str, list);
                    return;
                }
                return;
            }
            this.f68381c.removeCallbacks(bVar);
            if (cVar == null) {
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public e() {
        this.f68379a = new com.ss.android.socialbase.downloader.i.g<>(4, 16, false);
        this.f68380b = new Handler(d.p.a.e.b.o.b.b.a());
        this.f68381c = new Handler(d.p.a.e.b.k.e.a());
    }
}
