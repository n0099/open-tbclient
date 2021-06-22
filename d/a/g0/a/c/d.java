package d.a.g0.a.c;

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
public class d extends LruCache<String, d.a.g0.a.c.c<File>> {

    /* renamed from: a  reason: collision with root package name */
    public final List<e> f43591a;

    /* renamed from: b  reason: collision with root package name */
    public final String f43592b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<d.a.g0.a.c.c<File>, byte[]> f43593c;

    /* renamed from: d  reason: collision with root package name */
    public long f43594d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f43595e;

    /* renamed from: f  reason: collision with root package name */
    public int f43596f;

    /* renamed from: g  reason: collision with root package name */
    public long f43597g;

    /* loaded from: classes2.dex */
    public static class a extends d.a.g0.a.l.b {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43598g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f43599h;

        public a(String str, d dVar) {
            this.f43598g = str;
            this.f43599h = dVar;
        }

        @Override // d.a.g0.a.l.b
        public Object b() {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                File file = new File(this.f43598g);
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.f43599h.r(file.listFiles(), currentTimeMillis);
                return null;
            } catch (Exception e2) {
                this.f43599h.f43595e = true;
                d.a.g0.a.k.b i2 = d.a.g0.a.k.b.i();
                i2.a("Disk cache initialize failed for " + e2.getMessage());
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.a.g0.a.l.b {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f43600g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.g0.a.c.c f43601h;

        public b(byte[] bArr, d.a.g0.a.c.c cVar) {
            this.f43600g = bArr;
            this.f43601h = cVar;
        }

        @Override // d.a.g0.a.l.b
        public Object b() {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                d.a.g0.a.k.d.b(this.f43600g, (File) this.f43601h.a());
                d.this.put(((File) this.f43601h.a()).getName(), this.f43601h);
                d.b(d.this);
                if (!d.this.f43591a.isEmpty()) {
                    for (e eVar : d.this.f43591a) {
                        eVar.c(((File) this.f43601h.a()).getName(), this.f43601h);
                    }
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                d dVar = d.this;
                dVar.m("File saved using " + currentTimeMillis2 + "ms: " + ((File) this.f43601h.a()).getName() + "\nStatus:" + d.this.t());
                d.this.g();
                return null;
            } catch (Throwable th) {
                if (!d.this.f43591a.isEmpty()) {
                    for (e eVar2 : d.this.f43591a) {
                        eVar2.b(((File) this.f43601h.a()).getName(), this.f43601h);
                    }
                }
                d.a.g0.a.k.b i2 = d.a.g0.a.k.b.i();
                i2.a("Failed to save file. " + th);
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d.a.g0.a.l.b {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.g0.a.c.c f43603g;

        public c(d.a.g0.a.c.c cVar) {
            this.f43603g = cVar;
        }

        @Override // d.a.g0.a.l.b
        public Object b() {
            try {
                if (this.f43603g != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    String name = ((File) this.f43603g.a()).getName();
                    d.c(d.this);
                    this.f43603g.e();
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    d dVar = d.this;
                    dVar.m("File deleted using " + currentTimeMillis2 + "ms: " + name);
                }
                d.this.g();
                return null;
            } catch (Throwable th) {
                d.a.g0.a.k.b i2 = d.a.g0.a.k.b.i();
                i2.a("Failed to delete file. " + th);
                return null;
            }
        }
    }

    /* renamed from: d.a.g0.a.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0586d implements Comparator<File> {
        public C0586d(d dVar) {
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
        void a(String str, d.a.g0.a.c.c<File> cVar);

        void b(String str, d.a.g0.a.c.c<File> cVar);

        void c(String str, d.a.g0.a.c.c<File> cVar);
    }

    public d(int i2, String str) {
        super(i2);
        this.f43591a = new ArrayList();
        this.f43595e = false;
        this.f43596f = 0;
        this.f43597g = 2592000000L;
        this.f43592b = str;
        this.f43593c = new HashMap<>();
    }

    public static /* synthetic */ int b(d dVar) {
        int i2 = dVar.f43596f;
        dVar.f43596f = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int c(d dVar) {
        int i2 = dVar.f43596f;
        dVar.f43596f = i2 - 1;
        return i2;
    }

    public static d o(String str, int i2) {
        d dVar = new d(i2, str);
        dVar.f43595e = false;
        d.a.g0.a.l.c.a().c(new a(str, dVar));
        return dVar;
    }

    public void f(e eVar) {
        this.f43591a.add(eVar);
    }

    public synchronized void g() {
        if (System.currentTimeMillis() - this.f43594d < this.f43597g) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Map snapshot = super.snapshot();
        this.f43594d = System.currentTimeMillis();
        for (String str : snapshot.keySet()) {
            d.a.g0.a.c.c cVar = (d.a.g0.a.c.c) snapshot.get(str);
            if (cVar.d(this.f43597g)) {
                ((File) ((d.a.g0.a.c.c) super.remove(str)).a()).delete();
                this.f43596f--;
            } else if (((File) cVar.a()).lastModified() < this.f43594d) {
                this.f43594d = ((File) cVar.a()).lastModified();
            }
        }
        m("Clear cache using " + (System.currentTimeMillis() - currentTimeMillis) + "ms: ");
    }

    public final void h(d.a.g0.a.c.c<File> cVar) {
        d.a.g0.a.l.c.a().c(new c(cVar));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    /* renamed from: i */
    public void entryRemoved(boolean z, String str, d.a.g0.a.c.c<File> cVar, d.a.g0.a.c.c<File> cVar2) {
        super.entryRemoved(z, str, cVar, cVar2);
        if (z && cVar != null) {
            h(cVar);
        }
        if (!z || this.f43591a.isEmpty()) {
            return;
        }
        for (e eVar : this.f43591a) {
            eVar.a(str, cVar);
        }
    }

    public d.a.g0.a.c.c<File> j(String str) {
        d.a.g0.a.c.c<File> cVar = (d.a.g0.a.c.c) super.get(str);
        if (cVar != null) {
            try {
                cVar.a().setLastModified(System.currentTimeMillis());
                m("Fetch resource for " + str + ",\nStatus:" + t());
            } catch (Throwable th) {
                d.a.g0.a.k.b i2 = d.a.g0.a.k.b.i();
                i2.a("Failed to update file. " + th);
            }
        }
        return cVar;
    }

    public String k() {
        return this.f43592b;
    }

    public long l() {
        return super.maxSize();
    }

    public final void m(String str) {
    }

    public final synchronized void n() {
        this.f43595e = true;
        if (this.f43593c != null) {
            for (d.a.g0.a.c.c<File> cVar : this.f43593c.keySet()) {
                v(cVar, this.f43593c.get(cVar));
            }
            this.f43593c.clear();
            this.f43593c = null;
        }
    }

    public final void p(String str, File file) {
        if (file.exists()) {
            super.put(str, new d.a.g0.a.c.c(file));
            this.f43596f++;
        }
    }

    public void q(e eVar) {
        if (this.f43591a.contains(eVar)) {
            this.f43591a.remove(eVar);
        }
    }

    public final void r(File[] fileArr, long j) {
        if (fileArr != null && fileArr.length > 0) {
            PriorityQueue priorityQueue = new PriorityQueue(11, new C0586d(this));
            if (priorityQueue.size() > 0) {
                this.f43594d = ((File) priorityQueue.peek()).lastModified();
            } else {
                this.f43594d = System.currentTimeMillis();
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
    public int sizeOf(String str, d.a.g0.a.c.c<File> cVar) {
        if (cVar == null) {
            return super.sizeOf(null, null);
        }
        return cVar.f();
    }

    public String t() {
        int hitCount = hitCount() + missCount();
        return String.format(Locale.CHINA, "LruDiskCache[count=%d,size=%d/%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f43596f), Integer.valueOf(size()), Integer.valueOf(maxSize()), Integer.valueOf(hitCount()), Integer.valueOf(missCount()), Integer.valueOf(hitCount != 0 ? (hitCount() * 100) / hitCount : 0));
    }

    @Override // android.util.LruCache
    public synchronized void trimToSize(int i2) {
        super.trimToSize(i2);
    }

    public void u(byte[] bArr, d.a.g0.a.c.c<File> cVar) {
        if (cVar != null) {
            if (this.f43595e) {
                v(cVar, bArr);
            } else {
                this.f43593c.put(cVar, bArr);
            }
        }
    }

    public final void v(d.a.g0.a.c.c<File> cVar, byte[] bArr) {
        d.a.g0.a.l.c.a().c(new b(bArr, cVar));
    }
}
