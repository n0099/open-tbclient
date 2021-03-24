package d.b.b.e.d;

import d.b.b.e.d.e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
/* loaded from: classes.dex */
public class f {

    /* loaded from: classes.dex */
    public static class a implements e.a {

        /* renamed from: a  reason: collision with root package name */
        public final int f41679a;

        /* renamed from: b  reason: collision with root package name */
        public LinkedList<g<?>> f41680b;

        public a(int i) {
            this.f41679a = i;
        }

        @Override // d.b.b.e.d.e
        public boolean b() {
            return true;
        }

        @Override // d.b.b.e.d.e.a
        public void c() {
            this.f41680b.clear();
            this.f41680b = null;
        }

        @Override // d.b.b.e.d.e.a
        public void g() {
            this.f41680b = new LinkedList<>();
        }

        @Override // d.b.b.e.d.e
        public int getMaxSize() {
            return this.f41679a;
        }

        @Override // d.b.b.e.d.e.a
        public String h(g<?> gVar) {
            if (gVar.f41688f < System.currentTimeMillis()) {
                return gVar.f41683a;
            }
            this.f41680b.add(gVar);
            String str = null;
            if (this.f41680b.size() > getMaxSize()) {
                long j = 0;
                int i = -1;
                for (int i2 = 0; i2 < this.f41680b.size(); i2++) {
                    g<?> gVar2 = this.f41680b.get(i2);
                    if (i == -1 || gVar2.f41687e < j) {
                        str = gVar2.f41683a;
                        j = gVar2.f41687e;
                        i = i2;
                    }
                }
                this.f41680b.remove(i);
            }
            return str;
        }
    }

    /* loaded from: classes.dex */
    public static class b implements e.b {

        /* renamed from: a  reason: collision with root package name */
        public final int f41681a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, Long> f41682b = new HashMap<>();

        public b(int i) {
            this.f41681a = i;
        }

        @Override // d.b.b.e.d.e.b
        public String a(g<?> gVar) {
            String i = i(gVar.f41683a);
            synchronized (this) {
                this.f41682b.put(gVar.f41683a, Long.valueOf(gVar.f41687e));
            }
            return i;
        }

        @Override // d.b.b.e.d.e
        public boolean b() {
            return true;
        }

        @Override // d.b.b.e.d.e.b
        public void d() {
        }

        @Override // d.b.b.e.d.e.b
        public void e() {
        }

        @Override // d.b.b.e.d.e.b
        public String f(g<?> gVar) {
            if (gVar.f41688f < System.currentTimeMillis()) {
                return gVar.f41683a;
            }
            return a(gVar);
        }

        @Override // d.b.b.e.d.e
        public int getMaxSize() {
            return this.f41681a;
        }

        public String i(String str) {
            String str2 = null;
            if (!this.f41682b.containsKey(str) && this.f41682b.size() >= this.f41681a) {
                synchronized (this) {
                    long j = -1;
                    for (Map.Entry<String, Long> entry : this.f41682b.entrySet()) {
                        long longValue = entry.getValue().longValue();
                        if (j == -1 || j > longValue) {
                            str2 = entry.getKey();
                            j = longValue;
                        }
                    }
                    if (str2 != null) {
                        this.f41682b.remove(str2);
                    }
                }
                return str2;
            }
            return null;
        }

        @Override // d.b.b.e.d.e.b
        public void release() {
            synchronized (this) {
                this.f41682b.clear();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements e {
        @Override // d.b.b.e.d.e
        public boolean b() {
            return false;
        }

        @Override // d.b.b.e.d.e
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
