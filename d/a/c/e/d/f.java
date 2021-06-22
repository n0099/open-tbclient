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
        public final int f42276a;

        /* renamed from: b  reason: collision with root package name */
        public LinkedList<g<?>> f42277b;

        public a(int i2) {
            this.f42276a = i2;
        }

        @Override // d.a.c.e.d.e
        public boolean a() {
            return true;
        }

        @Override // d.a.c.e.d.e.a
        public void b() {
            this.f42277b.clear();
            this.f42277b = null;
        }

        @Override // d.a.c.e.d.e.a
        public void c() {
            this.f42277b = new LinkedList<>();
        }

        @Override // d.a.c.e.d.e
        public int getMaxSize() {
            return this.f42276a;
        }

        @Override // d.a.c.e.d.e.a
        public String h(g<?> gVar) {
            if (gVar.f42285f < System.currentTimeMillis()) {
                return gVar.f42280a;
            }
            this.f42277b.add(gVar);
            String str = null;
            if (this.f42277b.size() > getMaxSize()) {
                long j = 0;
                int i2 = -1;
                for (int i3 = 0; i3 < this.f42277b.size(); i3++) {
                    g<?> gVar2 = this.f42277b.get(i3);
                    if (i2 == -1 || gVar2.f42284e < j) {
                        str = gVar2.f42280a;
                        j = gVar2.f42284e;
                        i2 = i3;
                    }
                }
                this.f42277b.remove(i2);
            }
            return str;
        }
    }

    /* loaded from: classes.dex */
    public static class b implements e.b {

        /* renamed from: a  reason: collision with root package name */
        public final int f42278a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, Long> f42279b = new HashMap<>();

        public b(int i2) {
            this.f42278a = i2;
        }

        @Override // d.a.c.e.d.e
        public boolean a() {
            return true;
        }

        @Override // d.a.c.e.d.e.b
        public String d(g<?> gVar) {
            String i2 = i(gVar.f42280a);
            synchronized (this) {
                this.f42279b.put(gVar.f42280a, Long.valueOf(gVar.f42284e));
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
            if (gVar.f42285f < System.currentTimeMillis()) {
                return gVar.f42280a;
            }
            return d(gVar);
        }

        @Override // d.a.c.e.d.e
        public int getMaxSize() {
            return this.f42278a;
        }

        public String i(String str) {
            String str2 = null;
            if (!this.f42279b.containsKey(str) && this.f42279b.size() >= this.f42278a) {
                synchronized (this) {
                    long j = -1;
                    for (Map.Entry<String, Long> entry : this.f42279b.entrySet()) {
                        long longValue = entry.getValue().longValue();
                        if (j == -1 || j > longValue) {
                            str2 = entry.getKey();
                            j = longValue;
                        }
                    }
                    if (str2 != null) {
                        this.f42279b.remove(str2);
                    }
                }
                return str2;
            }
            return null;
        }

        @Override // d.a.c.e.d.e.b
        public void release() {
            synchronized (this) {
                this.f42279b.clear();
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
