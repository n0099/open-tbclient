package d.a.f0.a.c;

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
public class d extends LruCache<String, d.a.f0.a.c.c<File>> {

    /* renamed from: a  reason: collision with root package name */
    public final List<e> f39774a;

    /* renamed from: b  reason: collision with root package name */
    public final String f39775b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<d.a.f0.a.c.c<File>, byte[]> f39776c;

    /* renamed from: d  reason: collision with root package name */
    public long f39777d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f39778e;

    /* renamed from: f  reason: collision with root package name */
    public int f39779f;

    /* renamed from: g  reason: collision with root package name */
    public long f39780g;

    /* loaded from: classes2.dex */
    public static class a extends d.a.f0.a.l.b {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f39781g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f39782h;

        public a(String str, d dVar) {
            this.f39781g = str;
            this.f39782h = dVar;
        }

        @Override // d.a.f0.a.l.b
        public Object b() {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                File file = new File(this.f39781g);
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.f39782h.r(file.listFiles(), currentTimeMillis);
                return null;
            } catch (Exception e2) {
                this.f39782h.f39778e = true;
                d.a.f0.a.k.b i2 = d.a.f0.a.k.b.i();
                i2.a("Disk cache initialize failed for " + e2.getMessage());
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.a.f0.a.l.b {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f39783g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.f0.a.c.c f39784h;

        public b(byte[] bArr, d.a.f0.a.c.c cVar) {
            this.f39783g = bArr;
            this.f39784h = cVar;
        }

        @Override // d.a.f0.a.l.b
        public Object b() {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                d.a.f0.a.k.d.b(this.f39783g, (File) this.f39784h.a());
                d.this.put(((File) this.f39784h.a()).getName(), this.f39784h);
                d.b(d.this);
                if (!d.this.f39774a.isEmpty()) {
                    for (e eVar : d.this.f39774a) {
                        eVar.c(((File) this.f39784h.a()).getName(), this.f39784h);
                    }
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                d dVar = d.this;
                dVar.m("File saved using " + currentTimeMillis2 + "ms: " + ((File) this.f39784h.a()).getName() + "\nStatus:" + d.this.t());
                d.this.g();
                return null;
            } catch (Throwable th) {
                if (!d.this.f39774a.isEmpty()) {
                    for (e eVar2 : d.this.f39774a) {
                        eVar2.b(((File) this.f39784h.a()).getName(), this.f39784h);
                    }
                }
                d.a.f0.a.k.b i2 = d.a.f0.a.k.b.i();
                i2.a("Failed to save file. " + th);
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d.a.f0.a.l.b {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.f0.a.c.c f39786g;

        public c(d.a.f0.a.c.c cVar) {
            this.f39786g = cVar;
        }

        @Override // d.a.f0.a.l.b
        public Object b() {
            try {
                if (this.f39786g != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    String name = ((File) this.f39786g.a()).getName();
                    d.c(d.this);
                    this.f39786g.e();
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    d dVar = d.this;
                    dVar.m("File deleted using " + currentTimeMillis2 + "ms: " + name);
                }
                d.this.g();
                return null;
            } catch (Throwable th) {
                d.a.f0.a.k.b i2 = d.a.f0.a.k.b.i();
                i2.a("Failed to delete file. " + th);
                return null;
            }
        }
    }

    /* renamed from: d.a.f0.a.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0527d implements Comparator<File> {
        public C0527d(d dVar) {
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
        void a(String str, d.a.f0.a.c.c<File> cVar);

        void b(String str, d.a.f0.a.c.c<File> cVar);

        void c(String str, d.a.f0.a.c.c<File> cVar);
    }

    public d(int i2, String str) {
        super(i2);
        this.f39774a = new ArrayList();
        this.f39778e = false;
        this.f39779f = 0;
        this.f39780g = 2592000000L;
        this.f39775b = str;
        this.f39776c = new HashMap<>();
    }

    public static /* synthetic */ int b(d dVar) {
        int i2 = dVar.f39779f;
        dVar.f39779f = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int c(d dVar) {
        int i2 = dVar.f39779f;
        dVar.f39779f = i2 - 1;
        return i2;
    }

    public static d o(String str, int i2) {
        d dVar = new d(i2, str);
        dVar.f39778e = false;
        d.a.f0.a.l.c.a().c(new a(str, dVar));
        return dVar;
    }

    public void f(e eVar) {
        this.f39774a.add(eVar);
    }

    public synchronized void g() {
        if (System.currentTimeMillis() - this.f39777d < this.f39780g) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Map snapshot = super.snapshot();
        this.f39777d = System.currentTimeMillis();
        for (String str : snapshot.keySet()) {
            d.a.f0.a.c.c cVar = (d.a.f0.a.c.c) snapshot.get(str);
            if (cVar.d(this.f39780g)) {
                ((File) ((d.a.f0.a.c.c) super.remove(str)).a()).delete();
                this.f39779f--;
            } else if (((File) cVar.a()).lastModified() < this.f39777d) {
                this.f39777d = ((File) cVar.a()).lastModified();
            }
        }
        m("Clear cache using " + (System.currentTimeMillis() - currentTimeMillis) + "ms: ");
    }

    public final void h(d.a.f0.a.c.c<File> cVar) {
        d.a.f0.a.l.c.a().c(new c(cVar));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    /* renamed from: i */
    public void entryRemoved(boolean z, String str, d.a.f0.a.c.c<File> cVar, d.a.f0.a.c.c<File> cVar2) {
        super.entryRemoved(z, str, cVar, cVar2);
        if (z && cVar != null) {
            h(cVar);
        }
        if (!z || this.f39774a.isEmpty()) {
            return;
        }
        for (e eVar : this.f39774a) {
            eVar.a(str, cVar);
        }
    }

    public d.a.f0.a.c.c<File> j(String str) {
        d.a.f0.a.c.c<File> cVar = (d.a.f0.a.c.c) super.get(str);
        if (cVar != null) {
            try {
                cVar.a().setLastModified(System.currentTimeMillis());
                m("Fetch resource for " + str + ",\nStatus:" + t());
            } catch (Throwable th) {
                d.a.f0.a.k.b i2 = d.a.f0.a.k.b.i();
                i2.a("Failed to update file. " + th);
            }
        }
        return cVar;
    }

    public String k() {
        return this.f39775b;
    }

    public long l() {
        return super.maxSize();
    }

    public final void m(String str) {
    }

    public final synchronized void n() {
        this.f39778e = true;
        if (this.f39776c != null) {
            for (d.a.f0.a.c.c<File> cVar : this.f39776c.keySet()) {
                v(cVar, this.f39776c.get(cVar));
            }
            this.f39776c.clear();
            this.f39776c = null;
        }
    }

    public final void p(String str, File file) {
        if (file.exists()) {
            super.put(str, new d.a.f0.a.c.c(file));
            this.f39779f++;
        }
    }

    public void q(e eVar) {
        if (this.f39774a.contains(eVar)) {
            this.f39774a.remove(eVar);
        }
    }

    public final void r(File[] fileArr, long j) {
        if (fileArr != null && fileArr.length > 0) {
            PriorityQueue priorityQueue = new PriorityQueue(11, new C0527d(this));
            if (priorityQueue.size() > 0) {
                this.f39777d = ((File) priorityQueue.peek()).lastModified();
            } else {
                this.f39777d = System.currentTimeMillis();
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
    public int sizeOf(String str, d.a.f0.a.c.c<File> cVar) {
        if (cVar == null) {
            return super.sizeOf(null, null);
        }
        return cVar.f();
    }

    public String t() {
        int hitCount = hitCount() + missCount();
        return String.format(Locale.CHINA, "LruDiskCache[count=%d,size=%d/%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f39779f), Integer.valueOf(size()), Integer.valueOf(maxSize()), Integer.valueOf(hitCount()), Integer.valueOf(missCount()), Integer.valueOf(hitCount != 0 ? (hitCount() * 100) / hitCount : 0));
    }

    @Override // android.util.LruCache
    public synchronized void trimToSize(int i2) {
        super.trimToSize(i2);
    }

    public void u(byte[] bArr, d.a.f0.a.c.c<File> cVar) {
        if (cVar != null) {
            if (this.f39778e) {
                v(cVar, bArr);
            } else {
                this.f39776c.put(cVar, bArr);
            }
        }
    }

    public final void v(d.a.f0.a.c.c<File> cVar, byte[] bArr) {
        d.a.f0.a.l.c.a().c(new b(bArr, cVar));
    }
}
