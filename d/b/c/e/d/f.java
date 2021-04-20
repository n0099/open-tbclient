package d.b.c.e.d;

import d.b.c.e.d.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class f {

    /* loaded from: classes.dex */
    public static class a implements e.a {

        /* renamed from: a  reason: collision with root package name */
        public final int f42177a;

        /* renamed from: b  reason: collision with root package name */
        public LinkedList<g<?>> f42178b;

        public a(int i) {
            this.f42177a = i;
        }

        @Override // d.b.c.e.d.e
        public boolean b() {
            return true;
        }

        @Override // d.b.c.e.d.e.a
        public void c() {
            this.f42178b.clear();
            this.f42178b = null;
        }

        @Override // d.b.c.e.d.e.a
        public void g() {
            this.f42178b = new LinkedList<>();
        }

        @Override // d.b.c.e.d.e
        public int getMaxSize() {
            return this.f42177a;
        }

        @Override // d.b.c.e.d.e.a
        public String h(g<?> gVar) {
            if (gVar.f42186f < System.currentTimeMillis()) {
                return gVar.f42181a;
            }
            this.f42178b.add(gVar);
            String str = null;
            if (this.f42178b.size() > getMaxSize()) {
                long j = 0;
                int i = -1;
                for (int i2 = 0; i2 < this.f42178b.size(); i2++) {
                    g<?> gVar2 = this.f42178b.get(i2);
                    if (i == -1 || gVar2.f42185e < j) {
                        str = gVar2.f42181a;
                        j = gVar2.f42185e;
                        i = i2;
                    }
                }
                this.f42178b.remove(i);
            }
            return str;
        }
    }

    /* loaded from: classes.dex */
    public static class b implements e.b {

        /* renamed from: a  reason: collision with root package name */
        public final int f42179a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, Long> f42180b = new HashMap<>();

        public b(int i) {
            this.f42179a = i;
        }

        @Override // d.b.c.e.d.e.b
        public String a(g<?> gVar) {
            String i = i(gVar.f42181a);
            synchronized (this) {
                this.f42180b.put(gVar.f42181a, Long.valueOf(gVar.f42185e));
            }
            return i;
        }

        @Override // d.b.c.e.d.e
        public boolean b() {
            return true;
        }

        @Override // d.b.c.e.d.e.b
        public void d() {
        }

        @Override // d.b.c.e.d.e.b
        public void e() {
        }

        @Override // d.b.c.e.d.e.b
        public String f(g<?> gVar) {
            if (gVar.f42186f < System.currentTimeMillis()) {
                return gVar.f42181a;
            }
            return a(gVar);
        }

        @Override // d.b.c.e.d.e
        public int getMaxSize() {
            return this.f42179a;
        }

        public String i(String str) {
            String str2 = null;
            if (!this.f42180b.containsKey(str) && this.f42180b.size() >= this.f42179a) {
                synchronized (this) {
                    long j = -1;
                    for (Map.Entry<String, Long> entry : this.f42180b.entrySet()) {
                        long longValue = entry.getValue().longValue();
                        if (j == -1 || j > longValue) {
                            str2 = entry.getKey();
                            j = longValue;
                        }
                    }
                    if (str2 != null) {
                        this.f42180b.remove(str2);
                    }
                }
                return str2;
            }
            return null;
        }

        @Override // d.b.c.e.d.e.b
        public void release() {
            synchronized (this) {
                this.f42180b.clear();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements e {
        @Override // d.b.c.e.d.e
        public boolean b() {
            return false;
        }

        @Override // d.b.c.e.d.e
        public int getMaxSize() {
            return 1;
        }
    }

    public static e a(int i, boolean z) {
        if (z) {
            return new b(i);
        }
        return new a(i);
    }

    public static e b() {
        return new c();
    }
}
