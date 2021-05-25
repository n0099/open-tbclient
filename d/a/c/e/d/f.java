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
        public final int f38520a;

        /* renamed from: b  reason: collision with root package name */
        public LinkedList<g<?>> f38521b;

        public a(int i2) {
            this.f38520a = i2;
        }

        @Override // d.a.c.e.d.e
        public boolean a() {
            return true;
        }

        @Override // d.a.c.e.d.e.a
        public void b() {
            this.f38521b.clear();
            this.f38521b = null;
        }

        @Override // d.a.c.e.d.e.a
        public void c() {
            this.f38521b = new LinkedList<>();
        }

        @Override // d.a.c.e.d.e
        public int getMaxSize() {
            return this.f38520a;
        }

        @Override // d.a.c.e.d.e.a
        public String h(g<?> gVar) {
            if (gVar.f38529f < System.currentTimeMillis()) {
                return gVar.f38524a;
            }
            this.f38521b.add(gVar);
            String str = null;
            if (this.f38521b.size() > getMaxSize()) {
                long j = 0;
                int i2 = -1;
                for (int i3 = 0; i3 < this.f38521b.size(); i3++) {
                    g<?> gVar2 = this.f38521b.get(i3);
                    if (i2 == -1 || gVar2.f38528e < j) {
                        str = gVar2.f38524a;
                        j = gVar2.f38528e;
                        i2 = i3;
                    }
                }
                this.f38521b.remove(i2);
            }
            return str;
        }
    }

    /* loaded from: classes.dex */
    public static class b implements e.b {

        /* renamed from: a  reason: collision with root package name */
        public final int f38522a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, Long> f38523b = new HashMap<>();

        public b(int i2) {
            this.f38522a = i2;
        }

        @Override // d.a.c.e.d.e
        public boolean a() {
            return true;
        }

        @Override // d.a.c.e.d.e.b
        public String d(g<?> gVar) {
            String i2 = i(gVar.f38524a);
            synchronized (this) {
                this.f38523b.put(gVar.f38524a, Long.valueOf(gVar.f38528e));
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
            if (gVar.f38529f < System.currentTimeMillis()) {
                return gVar.f38524a;
            }
            return d(gVar);
        }

        @Override // d.a.c.e.d.e
        public int getMaxSize() {
            return this.f38522a;
        }

        public String i(String str) {
            String str2 = null;
            if (!this.f38523b.containsKey(str) && this.f38523b.size() >= this.f38522a) {
                synchronized (this) {
                    long j = -1;
                    for (Map.Entry<String, Long> entry : this.f38523b.entrySet()) {
                        long longValue = entry.getValue().longValue();
                        if (j == -1 || j > longValue) {
                            str2 = entry.getKey();
                            j = longValue;
                        }
                    }
                    if (str2 != null) {
                        this.f38523b.remove(str2);
                    }
                }
                return str2;
            }
            return null;
        }

        @Override // d.a.c.e.d.e.b
        public void release() {
            synchronized (this) {
                this.f38523b.clear();
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
