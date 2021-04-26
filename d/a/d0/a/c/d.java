package d.a.d0.a.c;

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
public class d extends LruCache<String, d.a.d0.a.c.c<File>> {

    /* renamed from: a  reason: collision with root package name */
    public final List<e> f40543a;

    /* renamed from: b  reason: collision with root package name */
    public final String f40544b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<d.a.d0.a.c.c<File>, byte[]> f40545c;

    /* renamed from: d  reason: collision with root package name */
    public long f40546d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f40547e;

    /* renamed from: f  reason: collision with root package name */
    public int f40548f;

    /* renamed from: g  reason: collision with root package name */
    public long f40549g;

    /* loaded from: classes2.dex */
    public static class a extends d.a.d0.a.l.b {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f40550g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f40551h;

        public a(String str, d dVar) {
            this.f40550g = str;
            this.f40551h = dVar;
        }

        @Override // d.a.d0.a.l.b
        public Object b() {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                File file = new File(this.f40550g);
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.f40551h.r(file.listFiles(), currentTimeMillis);
                return null;
            } catch (Exception e2) {
                this.f40551h.f40547e = true;
                d.a.d0.a.k.b i2 = d.a.d0.a.k.b.i();
                i2.a("Disk cache initialize failed for " + e2.getMessage());
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends d.a.d0.a.l.b {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ byte[] f40552g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.d0.a.c.c f40553h;

        public b(byte[] bArr, d.a.d0.a.c.c cVar) {
            this.f40552g = bArr;
            this.f40553h = cVar;
        }

        @Override // d.a.d0.a.l.b
        public Object b() {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                d.a.d0.a.k.d.b(this.f40552g, (File) this.f40553h.a());
                d.this.put(((File) this.f40553h.a()).getName(), this.f40553h);
                d.b(d.this);
                if (!d.this.f40543a.isEmpty()) {
                    for (e eVar : d.this.f40543a) {
                        eVar.c(((File) this.f40553h.a()).getName(), this.f40553h);
                    }
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                d dVar = d.this;
                dVar.m("File saved using " + currentTimeMillis2 + "ms: " + ((File) this.f40553h.a()).getName() + "\nStatus:" + d.this.t());
                d.this.g();
                return null;
            } catch (Throwable th) {
                if (!d.this.f40543a.isEmpty()) {
                    for (e eVar2 : d.this.f40543a) {
                        eVar2.b(((File) this.f40553h.a()).getName(), this.f40553h);
                    }
                }
                d.a.d0.a.k.b i2 = d.a.d0.a.k.b.i();
                i2.a("Failed to save file. " + th);
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d.a.d0.a.l.b {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.d0.a.c.c f40555g;

        public c(d.a.d0.a.c.c cVar) {
            this.f40555g = cVar;
        }

        @Override // d.a.d0.a.l.b
        public Object b() {
            try {
                if (this.f40555g != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    String name = ((File) this.f40555g.a()).getName();
                    d.c(d.this);
                    this.f40555g.e();
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    d dVar = d.this;
                    dVar.m("File deleted using " + currentTimeMillis2 + "ms: " + name);
                }
                d.this.g();
                return null;
            } catch (Throwable th) {
                d.a.d0.a.k.b i2 = d.a.d0.a.k.b.i();
                i2.a("Failed to delete file. " + th);
                return null;
            }
        }
    }

    /* renamed from: d.a.d0.a.c.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0534d implements Comparator<File> {
        public C0534d(d dVar) {
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
        void a(String str, d.a.d0.a.c.c<File> cVar);

        void b(String str, d.a.d0.a.c.c<File> cVar);

        void c(String str, d.a.d0.a.c.c<File> cVar);
    }

    public d(int i2, String str) {
        super(i2);
        this.f40543a = new ArrayList();
        this.f40547e = false;
        this.f40548f = 0;
        this.f40549g = 2592000000L;
        this.f40544b = str;
        this.f40545c = new HashMap<>();
    }

    public static /* synthetic */ int b(d dVar) {
        int i2 = dVar.f40548f;
        dVar.f40548f = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int c(d dVar) {
        int i2 = dVar.f40548f;
        dVar.f40548f = i2 - 1;
        return i2;
    }

    public static d o(String str, int i2) {
        d dVar = new d(i2, str);
        dVar.f40547e = false;
        d.a.d0.a.l.c.a().c(new a(str, dVar));
        return dVar;
    }

    public void f(e eVar) {
        this.f40543a.add(eVar);
    }

    public synchronized void g() {
        if (System.currentTimeMillis() - this.f40546d < this.f40549g) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Map snapshot = super.snapshot();
        this.f40546d = System.currentTimeMillis();
        for (String str : snapshot.keySet()) {
            d.a.d0.a.c.c cVar = (d.a.d0.a.c.c) snapshot.get(str);
            if (cVar.d(this.f40549g)) {
                ((File) ((d.a.d0.a.c.c) super.remove(str)).a()).delete();
                this.f40548f--;
            } else if (((File) cVar.a()).lastModified() < this.f40546d) {
                this.f40546d = ((File) cVar.a()).lastModified();
            }
        }
        m("Clear cache using " + (System.currentTimeMillis() - currentTimeMillis) + "ms: ");
    }

    public final void h(d.a.d0.a.c.c<File> cVar) {
        d.a.d0.a.l.c.a().c(new c(cVar));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.LruCache
    /* renamed from: i */
    public void entryRemoved(boolean z, String str, d.a.d0.a.c.c<File> cVar, d.a.d0.a.c.c<File> cVar2) {
        super.entryRemoved(z, str, cVar, cVar2);
        if (z && cVar != null) {
            h(cVar);
        }
        if (!z || this.f40543a.isEmpty()) {
            return;
        }
        for (e eVar : this.f40543a) {
            eVar.a(str, cVar);
        }
    }

    public d.a.d0.a.c.c<File> j(String str) {
        d.a.d0.a.c.c<File> cVar = (d.a.d0.a.c.c) super.get(str);
        if (cVar != null) {
            try {
                cVar.a().setLastModified(System.currentTimeMillis());
                m("Fetch resource for " + str + ",\nStatus:" + t());
            } catch (Throwable th) {
                d.a.d0.a.k.b i2 = d.a.d0.a.k.b.i();
                i2.a("Failed to update file. " + th);
            }
        }
        return cVar;
    }

    public String k() {
        return this.f40544b;
    }

    public long l() {
        return super.maxSize();
    }

    public final void m(String str) {
    }

    public final synchronized void n() {
        this.f40547e = true;
        if (this.f40545c != null) {
            for (d.a.d0.a.c.c<File> cVar : this.f40545c.keySet()) {
                v(cVar, this.f40545c.get(cVar));
            }
            this.f40545c.clear();
            this.f40545c = null;
        }
    }

    public final void p(String str, File file) {
        if (file.exists()) {
            super.put(str, new d.a.d0.a.c.c(file));
            this.f40548f++;
        }
    }

    public void q(e eVar) {
        if (this.f40543a.contains(eVar)) {
            this.f40543a.remove(eVar);
        }
    }

    public final void r(File[] fileArr, long j) {
        if (fileArr != null && fileArr.length > 0) {
            PriorityQueue priorityQueue = new PriorityQueue(11, new C0534d(this));
            if (priorityQueue.size() > 0) {
                this.f40546d = ((File) priorityQueue.peek()).lastModified();
            } else {
                this.f40546d = System.currentTimeMillis();
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
    public int sizeOf(String str, d.a.d0.a.c.c<File> cVar) {
        if (cVar == null) {
            return super.sizeOf(null, null);
        }
        return cVar.f();
    }

    public String t() {
        int hitCount = hitCount() + missCount();
        return String.format(Locale.CHINA, "LruDiskCache[count=%d,size=%d/%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f40548f), Integer.valueOf(size()), Integer.valueOf(maxSize()), Integer.valueOf(hitCount()), Integer.valueOf(missCount()), Integer.valueOf(hitCount != 0 ? (hitCount() * 100) / hitCount : 0));
    }

    @Override // android.util.LruCache
    public synchronized void trimToSize(int i2) {
        super.trimToSize(i2);
    }

    public void u(byte[] bArr, d.a.d0.a.c.c<File> cVar) {
        if (cVar != null) {
            if (this.f40547e) {
                v(cVar, bArr);
            } else {
                this.f40545c.put(cVar, bArr);
            }
        }
    }

    public final void v(d.a.d0.a.c.c<File> cVar, byte[] bArr) {
        d.a.d0.a.l.c.a().c(new b(bArr, cVar));
    }
}
