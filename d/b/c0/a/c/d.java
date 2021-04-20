package d.b.c0.a.c;

import android.util.LruCache;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
/* loaded from: classes2.dex */
public class d extends LruCache<String, d.b.c0.a.c.c<File>> {

    /* renamed from: a  reason: collision with root package name */
    public final List<e> f42983a;

    /* renamed from: b  reason: collision with root package name */
    public final String f42984b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<d.b.c0.a.c.c<File>, byte[]> f42985c;

    /* renamed from: d  reason: collision with root package name */
    public long f42986d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f42987e;

    /* renamed from: f  reason: collision with root package name */
    public int f42988f;

    /* renamed from: g  reason: collision with root package name */
    public long f42989g;

    /* loaded from: classes2.dex */
    public static class a extends d.b.c0.a.l.b {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f42990g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f42991h;

        public a(String str, d dVar) {
            this.f42990g = str;
            this.f42991h = dVar;
        }

        @Override // d.b.c0.a.l.b
        public Object b() {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                File file = new File(this.f42990g);
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.f42991h.r(file.listFiles(), currentTimeMillis);
                return null;
            } catch (Exception e2) {
                this.f42991h.f42987e = true;
                d.b.c0.a.k.b i = d.b.c0.a.k.b.i();
                i.a("Disk cache initialize failed for " + e2.getMessage());
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.b.c0.a.l.b {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f42992g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.c0.a.c.c f42993h;

        public b(byte[] bArr, d.b.c0.a.c.c cVar) {
            this.f42992g = bArr;
            this.f42993h = cVar;
        }

        @Override // d.b.c0.a.l.b
        public Object b() {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                d.b.c0.a.k.d.b(this.f42992g, (File) this.f42993h.a());
                d.this.put(((File) this.f42993h.a()).getName(), this.f42993h);
                d.b(d.this);
                if (!d.this.f42983a.isEmpty()) {
                    for (e eVar : d.this.f42983a) {
                        eVar.b(((File) this.f42993h.a()).getName(), this.f42993h);
                    }
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                d dVar = d.this;
                dVar.m("File saved using " + currentTimeMillis2 + "ms: " + ((File) this.f42993h.a()).getName() + "\nStatus:" + d.this.t());
                d.this.g();
                return null;
            } catch (Throwable th) {
                if (!d.this.f42983a.isEmpty()) {
                    for (e eVar2 : d.this.f42983a) {
                        eVar2.a(((File) this.f42993h.a()).getName(), this.f42993h);
                    }
                }
                d.b.c0.a.k.b i = d.b.c0.a.k.b.i();
                i.a("Failed to save file. " + th);
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d.b.c0.a.l.b {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.b.c0.a.c.c f42994g;

        public c(d.b.c0.a.c.c cVar) {
            this.f42994g = cVar;
        }

        @Override // d.b.c0.a.l.b
        public Object b() {
            try {
                if (this.f42994g != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    String name = ((File) this.f42994g.a()).getName();
                    d.c(d.this);
                    this.f42994g.e();
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    d dVar = d.this;
                    dVar.m("File deleted using " + currentTimeMillis2 + "ms: " + name);
                }
                d.this.g();
                return null;
            } catch (Throwable th) {
                d.b.c0.a.k.b i = d.b.c0.a.k.b.i();
                i.a("Failed to delete file. " + th);
                return null;
            }
        }
    }

    /* renamed from: d.b.c0.a.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0573d implements Comparator<File> {
        public C0573d(d dVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return Long.valueOf(file.lastModified()).compareTo(Long.valueOf(file2.lastModified()));
        }
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a(String str, d.b.c0.a.c.c<File> cVar);

        void b(String str, d.b.c0.a.c.c<File> cVar);

        void c(String str, d.b.c0.a.c.c<File> cVar);
    }

    public d(int i, String str) {
        super(i);
        this.f42983a = new ArrayList();
        this.f42987e = false;
        this.f42988f = 0;
        this.f42989g = 2592000000L;
        this.f42984b = str;
        this.f42985c = new HashMap<>();
    }

    public static /* synthetic */ int b(d dVar) {
        int i = dVar.f42988f;
        dVar.f42988f = i + 1;
        return i;
    }

    public static /* synthetic */ int c(d dVar) {
        int i = dVar.f42988f;
        dVar.f42988f = i - 1;
        return i;
    }

    public static d o(String str, int i) {
        d dVar = new d(i, str);
        dVar.f42987e = false;
        d.b.c0.a.l.c.a().c(new a(str, dVar));
        return dVar;
    }

    public void f(e eVar) {
        this.f42983a.add(eVar);
    }

    public synchronized void g() {
        if (System.currentTimeMillis() - this.f42986d < this.f42989g) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Map snapshot = super.snapshot();
        this.f42986d = System.currentTimeMillis();
        for (String str : snapshot.keySet()) {
            d.b.c0.a.c.c cVar = (d.b.c0.a.c.c) snapshot.get(str);
            if (cVar.d(this.f42989g)) {
                ((File) ((d.b.c0.a.c.c) super.remove(str)).a()).delete();
                this.f42988f--;
            } else if (((File) cVar.a()).lastModified() < this.f42986d) {
                this.f42986d = ((File) cVar.a()).lastModified();
            }
        }
        m("Clear cache using " + (System.currentTimeMillis() - currentTimeMillis) + "ms: ");
    }

    public final void h(d.b.c0.a.c.c<File> cVar) {
        d.b.c0.a.l.c.a().c(new c(cVar));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    /* renamed from: i */
    public void entryRemoved(boolean z, String str, d.b.c0.a.c.c<File> cVar, d.b.c0.a.c.c<File> cVar2) {
        super.entryRemoved(z, str, cVar, cVar2);
        if (z && cVar != null) {
            h(cVar);
        }
        if (!z || this.f42983a.isEmpty()) {
            return;
        }
        for (e eVar : this.f42983a) {
            eVar.c(str, cVar);
        }
    }

    public d.b.c0.a.c.c<File> j(String str) {
        d.b.c0.a.c.c<File> cVar = (d.b.c0.a.c.c) super.get(str);
        if (cVar != null) {
            try {
                cVar.a().setLastModified(System.currentTimeMillis());
                m("Fetch resource for " + str + ",\nStatus:" + t());
            } catch (Throwable th) {
                d.b.c0.a.k.b i = d.b.c0.a.k.b.i();
                i.a("Failed to update file. " + th);
            }
        }
        return cVar;
    }

    public String k() {
        return this.f42984b;
    }

    public long l() {
        return super.maxSize();
    }

    public final void m(String str) {
    }

    public final synchronized void n() {
        this.f42987e = true;
        if (this.f42985c != null) {
            for (d.b.c0.a.c.c<File> cVar : this.f42985c.keySet()) {
                v(cVar, this.f42985c.get(cVar));
            }
            this.f42985c.clear();
            this.f42985c = null;
        }
    }

    public final void p(String str, File file) {
        if (file.exists()) {
            super.put(str, new d.b.c0.a.c.c(file));
            this.f42988f++;
        }
    }

    public void q(e eVar) {
        if (this.f42983a.contains(eVar)) {
            this.f42983a.remove(eVar);
        }
    }

    public final void r(File[] fileArr, long j) {
        if (fileArr != null && fileArr.length > 0) {
            PriorityQueue priorityQueue = new PriorityQueue(11, new C0573d(this));
            if (priorityQueue.size() > 0) {
                this.f42986d = ((File) priorityQueue.peek()).lastModified();
            } else {
                this.f42986d = System.currentTimeMillis();
            }
            priorityQueue.addAll(Arrays.asList(fileArr));
            while (!priorityQueue.isEmpty()) {
                File file = (File) priorityQueue.poll();
                p(file.getName(), file);
            }
        }
        m("Complete restore cache using " + (System.currentTimeMillis() - j) + "ms: ");
        n();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    /* renamed from: s */
    public int sizeOf(String str, d.b.c0.a.c.c<File> cVar) {
        if (cVar == null) {
            return super.sizeOf(null, null);
        }
        return cVar.f();
    }

    public String t() {
        int hitCount = hitCount() + missCount();
        return String.format(Locale.CHINA, "LruDiskCache[count=%d,size=%d/%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f42988f), Integer.valueOf(size()), Integer.valueOf(maxSize()), Integer.valueOf(hitCount()), Integer.valueOf(missCount()), Integer.valueOf(hitCount != 0 ? (hitCount() * 100) / hitCount : 0));
    }

    @Override // android.util.LruCache
    public synchronized void trimToSize(int i) {
        super.trimToSize(i);
    }

    public void u(byte[] bArr, d.b.c0.a.c.c<File> cVar) {
        if (cVar != null) {
            if (this.f42987e) {
                v(cVar, bArr);
            } else {
                this.f42985c.put(cVar, bArr);
            }
        }
    }

    public final void v(d.b.c0.a.c.c<File> cVar, byte[] bArr) {
        d.b.c0.a.l.c.a().c(new b(bArr, cVar));
    }
}
