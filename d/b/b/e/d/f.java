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
        public final int f41680a;

        /* renamed from: b  reason: collision with root package name */
        public LinkedList<g<?>> f41681b;

        public a(int i) {
            this.f41680a = i;
        }

        @Override // d.b.b.e.d.e
        public boolean b() {
            return true;
        }

        @Override // d.b.b.e.d.e.a
        public void c() {
            this.f41681b.clear();
            this.f41681b = null;
        }

        @Override // d.b.b.e.d.e.a
        public void g() {
            this.f41681b = new LinkedList<>();
        }

        @Override // d.b.b.e.d.e
        public int getMaxSize() {
            return this.f41680a;
        }

        @Override // d.b.b.e.d.e.a
        public String h(g<?> gVar) {
            if (gVar.f41689f < System.currentTimeMillis()) {
                return gVar.f41684a;
            }
            this.f41681b.add(gVar);
            String str = null;
            if (this.f41681b.size() > getMaxSize()) {
                long j = 0;
                int i = -1;
                for (int i2 = 0; i2 < this.f41681b.size(); i2++) {
                    g<?> gVar2 = this.f41681b.get(i2);
                    if (i == -1 || gVar2.f41688e < j) {
                        str = gVar2.f41684a;
                        j = gVar2.f41688e;
                        i = i2;
                    }
                }
                this.f41681b.remove(i);
            }
            return str;
        }
    }

    /* loaded from: classes.dex */
    public static class b implements e.b {

        /* renamed from: a  reason: collision with root package name */
        public final int f41682a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, Long> f41683b = new HashMap<>();

        public b(int i) {
            this.f41682a = i;
        }

        @Override // d.b.b.e.d.e.b
        public String a(g<?> gVar) {
            String i = i(gVar.f41684a);
            synchronized (this) {
                this.f41683b.put(gVar.f41684a, Long.valueOf(gVar.f41688e));
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
            if (gVar.f41689f < System.currentTimeMillis()) {
                return gVar.f41684a;
            }
            return a(gVar);
        }

        @Override // d.b.b.e.d.e
        public int getMaxSize() {
            return this.f41682a;
        }

        public String i(String str) {
            String str2 = null;
            if (!this.f41683b.containsKey(str) && this.f41683b.size() >= this.f41682a) {
                synchronized (this) {
                    long j = -1;
                    for (Map.Entry<String, Long> entry : this.f41683b.entrySet()) {
                        long longValue = entry.getValue().longValue();
                        if (j == -1 || j > longValue) {
                            str2 = entry.getKey();
                            j = longValue;
                        }
                    }
                    if (str2 != null) {
                        this.f41683b.remove(str2);
                    }
                }
                return str2;
            }
            return null;
        }

        @Override // d.b.b.e.d.e.b
        public void release() {
            synchronized (this) {
                this.f41683b.clear();
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
