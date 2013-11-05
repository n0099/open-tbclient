package javassist.bytecode.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import javassist.NotFoundException;
/* loaded from: classes.dex */
public class h {
    private final javassist.h r;
    private final boolean s;
    private static final Map t = new IdentityHashMap();

    /* renamed from: a  reason: collision with root package name */
    public static final h f2726a = new h(javassist.h.k);
    public static final h b = new h(javassist.h.d);
    public static final h c = new h(javassist.h.i);
    public static final h d = new h(javassist.h.e);
    public static final h e = new h(javassist.h.f);
    public static final h f = new h(javassist.h.g);
    public static final h g = new h(javassist.h.h);
    public static final h h = new h(javassist.h.j);
    public static final h i = new h(javassist.h.l);
    public static final h j = new h(null);
    public static final h k = new h(null, true);
    public static final h l = new h(null, true);
    public static final h m = new h(null, true);
    public static final h n = a("java.lang.Object");
    public static final h o = a("java.io.Serializable");
    public static final h p = a("java.lang.Cloneable");
    public static final h q = a("java.lang.Throwable");

    static {
        t.put(javassist.h.k, f2726a);
        t.put(javassist.h.i, c);
        t.put(javassist.h.e, d);
        t.put(javassist.h.g, f);
        t.put(javassist.h.h, g);
        t.put(javassist.h.j, h);
        t.put(javassist.h.f, e);
        t.put(javassist.h.d, b);
        t.put(javassist.h.l, i);
    }

    public static h a(javassist.h hVar) {
        h hVar2 = (h) t.get(hVar);
        return hVar2 != null ? hVar2 : new h(hVar);
    }

    private static h a(String str) {
        try {
            return new h(javassist.c.a().c(str));
        } catch (NotFoundException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(javassist.h hVar) {
        this(hVar, false);
    }

    private h(javassist.h hVar, boolean z) {
        this.r = hVar;
        this.s = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return false;
    }

    public int e() {
        return (this.r == javassist.h.k || this.r == javassist.h.i || this == l) ? 2 : 1;
    }

    public javassist.h a() {
        return this.r;
    }

    public boolean g() {
        return !this.s && (this.r == null || !this.r.m());
    }

    public boolean f() {
        return this.r != null && this.r.b();
    }

    public int c() {
        int i2 = 0;
        if (f()) {
            String n2 = this.r.n();
            int length = n2.length() - 1;
            while (n2.charAt(length) == ']') {
                length -= 2;
                i2++;
            }
        }
        return i2;
    }

    public h d() {
        if (this.r == null || !this.r.b()) {
            return null;
        }
        try {
            javassist.h e2 = this.r.e();
            h hVar = (h) t.get(e2);
            return hVar == null ? new h(e2) : hVar;
        } catch (NotFoundException e3) {
            throw new RuntimeException(e3);
        }
    }

    public boolean a(h hVar) {
        if (this == hVar) {
            return true;
        }
        if (hVar == j && g()) {
            return true;
        }
        if (this == j && hVar.g()) {
            return true;
        }
        if (hVar instanceof MultiType) {
            return ((MultiType) hVar).b(this);
        }
        if (hVar instanceof MultiArrayType) {
            return ((MultiArrayType) hVar).b(this);
        }
        if (this.r == null || this.r.m()) {
            return false;
        }
        try {
            return hVar.r.a(this.r);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public h c(h hVar) {
        if (hVar != this && hVar != null && hVar != j) {
            if (this == j) {
                return hVar;
            }
            if (!hVar.g() || !g()) {
                return m;
            }
            if (hVar instanceof MultiType) {
                return hVar.c(this);
            }
            if (hVar.f() && f()) {
                return e(hVar);
            }
            try {
                return f(hVar);
            } catch (NotFoundException e2) {
                throw new RuntimeException(e2);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h d(h hVar) {
        while (hVar.f()) {
            hVar = hVar.d();
        }
        return hVar;
    }

    private h a(h hVar, int i2) {
        if (hVar instanceof MultiType) {
            return new MultiArrayType((MultiType) hVar, i2);
        }
        try {
            return a(b(hVar).c(a(hVar.r.n(), i2)));
        } catch (NotFoundException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str, int i2) {
        int length = str.length();
        int i3 = (i2 * 2) + length;
        char[] cArr = new char[i3];
        str.getChars(0, length, cArr, 0);
        while (length < i3) {
            int i4 = length + 1;
            cArr[length] = '[';
            length = i4 + 1;
            cArr[i4] = ']';
        }
        return new String(cArr);
    }

    private javassist.c b(h hVar) {
        javassist.c a2 = hVar.r.a();
        return a2 != null ? a2 : javassist.c.a();
    }

    private h e(h hVar) {
        h hVar2;
        h d2 = d(hVar);
        h d3 = d(this);
        int c2 = hVar.c();
        int c3 = c();
        if (c2 == c3) {
            h c4 = d3.c(d2);
            if (c4 == m) {
                return n;
            }
            return a(c4, c3);
        }
        if (c2 < c3) {
            hVar2 = d2;
        } else {
            c2 = c3;
            hVar2 = d3;
        }
        if (a(p.r, hVar2.r) || a(o.r, hVar2.r)) {
            return a(hVar2, c2);
        }
        return a(n, c2);
    }

    private static javassist.h b(javassist.h hVar, javassist.h hVar2) {
        javassist.h hVar3 = hVar2;
        javassist.h hVar4 = hVar;
        while (true) {
            if (!a(hVar4, hVar3) || hVar4.f() == null) {
                javassist.h f2 = hVar4.f();
                javassist.h f3 = hVar3.f();
                if (f3 == null) {
                    break;
                } else if (f2 == null) {
                    hVar4 = hVar3;
                    hVar = hVar2;
                    hVar2 = hVar;
                    break;
                } else {
                    hVar3 = f3;
                    hVar4 = f2;
                }
            } else {
                return hVar4;
            }
        }
        while (true) {
            hVar4 = hVar4.f();
            if (hVar4 == null) {
                break;
            }
            hVar = hVar.f();
        }
        while (!a(hVar, hVar2)) {
            hVar = hVar.f();
            hVar2 = hVar2.f();
        }
        return hVar;
    }

    private h f(h hVar) {
        javassist.h b2 = b(this.r, hVar.r);
        if (b2.f() == null) {
            Map g2 = g(hVar);
            if (g2.size() == 1) {
                return new h((javassist.h) g2.values().iterator().next());
            }
            if (g2.size() > 1) {
                return new MultiType(g2);
            }
            return new h(b2);
        }
        Map a2 = a(hVar, b2);
        if (a2.size() > 0) {
            return new MultiType(a2, new h(b2));
        }
        return new h(b2);
    }

    private Map g(h hVar) {
        return a(a(hVar.r, (Map) null), a(this.r, (Map) null));
    }

    private Map a(h hVar, javassist.h hVar2) {
        Map b2 = b(hVar.r, (Map) null);
        Map b3 = b(this.r, (Map) null);
        for (Object obj : a(hVar2, (Map) null).keySet()) {
            b2.remove(obj);
            b3.remove(obj);
        }
        return a(b2, b3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map a(Map map, Map map2) {
        Iterator it = map2.keySet().iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                it.remove();
            }
        }
        Iterator it2 = new ArrayList(map2.values()).iterator();
        while (it2.hasNext()) {
            try {
                for (javassist.h hVar : ((javassist.h) it2.next()).d()) {
                    map2.remove(hVar.n());
                }
            } catch (NotFoundException e2) {
                throw new RuntimeException(e2);
            }
        }
        return map2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map a(javassist.h hVar, Map map) {
        javassist.h[] d2;
        if (map == null) {
            map = new HashMap();
        }
        if (hVar.q()) {
            map.put(hVar.n(), hVar);
        }
        do {
            try {
                for (javassist.h hVar2 : hVar.d()) {
                    map.put(hVar2.n(), hVar2);
                    a(hVar2, map);
                }
                hVar = hVar.f();
            } catch (NotFoundException e2) {
                throw new RuntimeException(e2);
            }
        } while (hVar != null);
        return map;
    }

    Map b(javassist.h hVar, Map map) {
        javassist.h[] d2;
        if (map == null) {
            map = new HashMap();
        }
        if (hVar.q()) {
            map.put(hVar.n(), hVar);
        }
        try {
            for (javassist.h hVar2 : hVar.d()) {
                map.put(hVar2.n(), hVar2);
                b(hVar2, map);
            }
            return map;
        } catch (NotFoundException e2) {
            throw new RuntimeException(e2);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof h) && obj.getClass() == getClass() && a(this.r, ((h) obj).r);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(javassist.h hVar, javassist.h hVar2) {
        return hVar == hVar2 || !(hVar == null || hVar2 == null || !hVar.n().equals(hVar2.n()));
    }

    public String toString() {
        if (this == m) {
            return "BOGUS";
        }
        if (this == j) {
            return "UNINIT";
        }
        if (this == k) {
            return "RETURN ADDRESS";
        }
        if (this == l) {
            return "TOP";
        }
        return this.r == null ? "null" : this.r.n();
    }
}
