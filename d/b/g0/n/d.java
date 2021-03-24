package d.b.g0.n;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    public static volatile d m;

    /* renamed from: a  reason: collision with root package name */
    public Context f49219a;

    /* renamed from: b  reason: collision with root package name */
    public HashSet<String> f49220b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f49221c = new HashSet<>();

    /* renamed from: d  reason: collision with root package name */
    public HashSet<String> f49222d = new HashSet<>();

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f49223e = new HashSet<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f49224f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, String> f49225g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, h> f49226h = new HashMap<>();
    public HashSet<String> i = new HashSet<>();
    public int j;
    public int k;
    public int l;

    public static d g() {
        if (m == null) {
            synchronized (d.class) {
                if (m == null) {
                    m = new d();
                }
            }
        }
        return m;
    }

    public boolean a(String str) {
        return this.f49222d.contains(str);
    }

    public boolean b(String str) {
        if (e.g().r()) {
            return true;
        }
        return this.f49221c.contains(str);
    }

    public boolean c(String str, int i) {
        if (this.f49220b.contains(str)) {
            return false;
        }
        if ((i & 16) == 0 && (i & 32) == 0) {
            return true;
        }
        return this.f49223e.contains(str);
    }

    public String d(String str) {
        return this.f49225g.containsKey(str) ? this.f49225g.get(str) : "";
    }

    public int e() {
        return this.k;
    }

    public int f() {
        return this.l;
    }

    public int h() {
        return this.j;
    }

    public int i(String str) {
        if (e.g().p() || TextUtils.isEmpty(str) || !this.f49224f.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.f49224f.get(str));
    }

    public String j(String str) {
        return (TextUtils.isEmpty(str) || !this.i.contains(str)) ? "0" : "1";
    }

    public void k(c cVar, Context context) {
        this.f49219a = context;
        this.j = 360000;
        t f2 = t.f();
        this.k = f2.getInt("ubc_data_expire_time", 259200000);
        this.l = f2.getInt("ubc_database_limit", 4000);
        cVar.e().v(this.f49220b, this.f49223e, this.f49221c, this.f49222d, this.f49224f, this.f49225g, this.f49226h, this.i);
    }

    public boolean l(String str) {
        HashMap<String, h> hashMap = this.f49226h;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return false;
        }
        return this.f49226h.get(str).b();
    }

    public boolean m(String str) {
        HashMap<String, h> hashMap = this.f49226h;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return false;
        }
        return this.f49226h.get(str).c();
    }

    public void n(int i) {
        if (i < this.k) {
            return;
        }
        this.k = i;
        t.f().putInt("ubc_data_expire_time", i);
    }

    public void o(int i) {
        if (i < this.l) {
            return;
        }
        this.l = i;
        t.f().putInt("ubc_database_limit", i);
    }

    public void p(int i) {
        int i2 = i * 60000;
        if (i2 < this.j) {
            return;
        }
        this.j = i2;
    }

    public void q(List<g> list) {
        for (g gVar : list) {
            if ("0".equals(gVar.i())) {
                this.f49220b.add(gVar.c());
            } else {
                this.f49220b.remove(gVar.c());
            }
            if ("1".equals(gVar.e())) {
                this.f49221c.add(gVar.c());
            } else {
                this.f49221c.remove(gVar.c());
            }
            if ("1".equals(gVar.a())) {
                this.f49222d.add(gVar.c());
            } else {
                this.f49222d.remove(gVar.c());
            }
            if (gVar.h() >= 1 && gVar.h() <= 100) {
                this.f49224f.put(gVar.c(), String.valueOf(gVar.h()));
            } else {
                this.f49224f.remove(gVar.c());
            }
            if (!TextUtils.isEmpty(gVar.b())) {
                this.f49225g.put(gVar.c(), gVar.b());
            } else {
                this.f49225g.remove(gVar.c());
            }
            if (gVar.f() != 0 && gVar.g() != 0) {
                h hVar = new h(gVar.c(), gVar.f(), gVar.g());
                this.f49226h.put(hVar.a(), hVar);
            }
            if (TextUtils.equals(gVar.d(), "1")) {
                this.i.add(gVar.c());
            } else {
                this.i.remove(gVar.c());
            }
        }
    }
}
