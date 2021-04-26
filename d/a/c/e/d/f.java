package d.a.c.e.d;

import d.a.c.e.d.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class f {

    /* loaded from: classes.dex */
    public static class a implements e.a {

        /* renamed from: a  reason: collision with root package name */
        public final int f39611a;

        /* renamed from: b  reason: collision with root package name */
        public LinkedList<g<?>> f39612b;

        public a(int i2) {
            this.f39611a = i2;
        }

        @Override // d.a.c.e.d.e
        public boolean a() {
            return true;
        }

        @Override // d.a.c.e.d.e.a
        public void b() {
            this.f39612b.clear();
            this.f39612b = null;
        }

        @Override // d.a.c.e.d.e.a
        public void c() {
            this.f39612b = new LinkedList<>();
        }

        @Override // d.a.c.e.d.e
        public int getMaxSize() {
            return this.f39611a;
        }

        @Override // d.a.c.e.d.e.a
        public String h(g<?> gVar) {
            if (gVar.f39620f < System.currentTimeMillis()) {
                return gVar.f39615a;
            }
            this.f39612b.add(gVar);
            String str = null;
            if (this.f39612b.size() > getMaxSize()) {
                long j = 0;
                int i2 = -1;
                for (int i3 = 0; i3 < this.f39612b.size(); i3++) {
                    g<?> gVar2 = this.f39612b.get(i3);
                    if (i2 == -1 || gVar2.f39619e < j) {
                        str = gVar2.f39615a;
                        j = gVar2.f39619e;
                        i2 = i3;
                    }
                }
                this.f39612b.remove(i2);
            }
            return str;
        }
    }

    /* loaded from: classes.dex */
    public static class b implements e.b {

        /* renamed from: a  reason: collision with root package name */
        public final int f39613a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, Long> f39614b = new HashMap<>();

        public b(int i2) {
            this.f39613a = i2;
        }

        @Override // d.a.c.e.d.e
        public boolean a() {
            return true;
        }

        @Override // d.a.c.e.d.e.b
        public String d(g<?> gVar) {
            String i2 = i(gVar.f39615a);
            synchronized (this) {
                this.f39614b.put(gVar.f39615a, Long.valueOf(gVar.f39619e));
            }
            return i2;
        }

        @Override // d.a.c.e.d.e.b
        public void e() {
        }

        @Override // d.a.c.e.d.e.b
        public void f() {
        }

        @Override // d.a.c.e.d.e.b
        public String g(g<?> gVar) {
            if (gVar.f39620f < System.currentTimeMillis()) {
                return gVar.f39615a;
            }
            return d(gVar);
        }

        @Override // d.a.c.e.d.e
        public int getMaxSize() {
            return this.f39613a;
        }

        public String i(String str) {
            String str2 = null;
            if (!this.f39614b.containsKey(str) && this.f39614b.size() >= this.f39613a) {
                synchronized (this) {
                    long j = -1;
                    for (Map.Entry<String, Long> entry : this.f39614b.entrySet()) {
                        long longValue = entry.getValue().longValue();
                        if (j == -1 || j > longValue) {
                            str2 = entry.getKey();
                            j = longValue;
                        }
                    }
                    if (str2 != null) {
                        this.f39614b.remove(str2);
                    }
                }
                return str2;
            }
            return null;
        }

        @Override // d.a.c.e.d.e.b
        public void release() {
            synchronized (this) {
                this.f39614b.clear();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements e {
        @Override // d.a.c.e.d.e
        public boolean a() {
            return false;
        }

        @Override // d.a.c.e.d.e
        public int getMaxSize() {
            return 1;
        }
    }

    public static e a(int i2, boolean z) {
        if (z) {
            return new b(i2);
        }
        return new a(i2);
    }

    public static e b() {
        return new c();
    }
}
