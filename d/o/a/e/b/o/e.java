package d.o.a.e.b.o;

import android.net.Uri;
import android.os.Handler;
import java.net.InetAddress;
import java.util.List;
/* loaded from: classes7.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public final com.ss.android.socialbase.downloader.i.g<String, d> f67442a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f67443b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f67444c;

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f67445e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f67446f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f67447g;

        public a(String str, c cVar, long j) {
            this.f67445e = str;
            this.f67446f = cVar;
            this.f67447g = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.e(this.f67445e, this.f67446f, this.f67447g);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f67449e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f67450f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f67451g;

        public b(e eVar, c cVar, String str, d dVar) {
            this.f67449e = cVar;
            this.f67450f = str;
            this.f67451g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = this.f67449e;
            if (cVar != null) {
                String str = this.f67450f;
                d dVar = this.f67451g;
                cVar.a(str, dVar == null ? null : dVar.f67452a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(String str, List<InetAddress> list);
    }

    /* loaded from: classes7.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public List<InetAddress> f67452a;

        /* renamed from: b  reason: collision with root package name */
        public long f67453b;

        public d() {
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* renamed from: d.o.a.e.b.o.e$e  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1892e {

        /* renamed from: a  reason: collision with root package name */
        public static final e f67454a = new e(null);
    }

    public /* synthetic */ e(a aVar) {
        this();
    }

    public static e a() {
        return C1892e.f67454a;
    }

    public void c(String str, c cVar, long j) {
        this.f67443b.post(new a(str, cVar, j));
    }

    public final void d(String str, List<InetAddress> list) {
        synchronized (this.f67442a) {
            d dVar = this.f67442a.get(str);
            if (dVar == null) {
                dVar = new d(null);
                this.f67442a.put(str, dVar);
            }
            dVar.f67452a = list;
            dVar.f67453b = System.currentTimeMillis();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0085, code lost:
        r10 = r2.f67452a;
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
            synchronized (this.f67442a) {
                dVar = this.f67442a.get(host);
            }
            if (dVar != null) {
                if (System.currentTimeMillis() - dVar.f67453b < d.o.a.e.b.j.a.r().b("dns_expire_min", 10) * 60 * 1000) {
                    if (cVar != null) {
                        cVar.a(str, dVar.f67452a);
                        return;
                    }
                    return;
                }
            }
            b bVar = new b(this, cVar, str, dVar);
            this.f67444c.postDelayed(bVar, j);
            List<InetAddress> list = null;
            if (d.o.a.e.b.j.a.r().b("use_host_dns", 1) == 1 && (F0 = d.o.a.e.b.g.d.F0()) != null) {
                list = F0.a(host);
            }
            if (list == null || list.isEmpty()) {
                list = d.o.a.e.b.g.d.G0().a(host);
            }
            if (list != null && !list.isEmpty()) {
                d(host, list);
                this.f67444c.removeCallbacks(bVar);
                if (cVar == null) {
                    cVar.a(str, list);
                    return;
                }
                return;
            }
            this.f67444c.removeCallbacks(bVar);
            if (cVar == null) {
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public e() {
        this.f67442a = new com.ss.android.socialbase.downloader.i.g<>(4, 16, false);
        this.f67443b = new Handler(d.o.a.e.b.o.b.b.a());
        this.f67444c = new Handler(d.o.a.e.b.k.e.a());
    }
}
