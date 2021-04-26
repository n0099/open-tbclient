package d.a.h0.n;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    public static volatile d m;

    /* renamed from: a  reason: collision with root package name */
    public Context f47467a;

    /* renamed from: b  reason: collision with root package name */
    public HashSet<String> f47468b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f47469c = new HashSet<>();

    /* renamed from: d  reason: collision with root package name */
    public HashSet<String> f47470d = new HashSet<>();

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f47471e = new HashSet<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f47472f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, String> f47473g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, h> f47474h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    public HashSet<String> f47475i = new HashSet<>();
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
        return this.f47470d.contains(str);
    }

    public boolean b(String str) {
        if (e.g().q()) {
            return true;
        }
        return this.f47469c.contains(str);
    }

    public boolean c(String str, int i2) {
        if (this.f47468b.contains(str)) {
            return false;
        }
        if ((i2 & 16) == 0 && (i2 & 32) == 0) {
            return true;
        }
        return this.f47471e.contains(str);
    }

    public String d(String str) {
        return this.f47473g.containsKey(str) ? this.f47473g.get(str) : "";
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
        if (e.g().p() || TextUtils.isEmpty(str) || !this.f47472f.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.f47472f.get(str));
    }

    public String j(String str) {
        return (TextUtils.isEmpty(str) || !this.f47475i.contains(str)) ? "0" : "1";
    }

    public void k(c cVar, Context context) {
        this.f47467a = context;
        this.j = 360000;
        t f2 = t.f();
        this.k = f2.getInt("ubc_data_expire_time", 259200000);
        this.l = f2.getInt("ubc_database_limit", 4000);
        cVar.e().v(this.f47468b, this.f47471e, this.f47469c, this.f47470d, this.f47472f, this.f47473g, this.f47474h, this.f47475i);
    }

    public boolean l(String str) {
        HashMap<String, h> hashMap = this.f47474h;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return false;
        }
        return this.f47474h.get(str).b();
    }

    public boolean m(String str) {
        HashMap<String, h> hashMap = this.f47474h;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return false;
        }
        return this.f47474h.get(str).c();
    }

    public void n(int i2) {
        if (i2 < this.k) {
            return;
        }
        this.k = i2;
        t.f().putInt("ubc_data_expire_time", i2);
    }

    public void o(int i2) {
        if (i2 < this.l) {
            return;
        }
        this.l = i2;
        t.f().putInt("ubc_database_limit", i2);
    }

    public void p(int i2) {
        int i3 = i2 * 60000;
        if (i3 < this.j) {
            return;
        }
        this.j = i3;
    }

    public void q(List<g> list) {
        for (g gVar : list) {
            if ("0".equals(gVar.i())) {
                this.f47468b.add(gVar.c());
            } else {
                this.f47468b.remove(gVar.c());
            }
            if ("1".equals(gVar.e())) {
                this.f47469c.add(gVar.c());
            } else {
                this.f47469c.remove(gVar.c());
            }
            if ("1".equals(gVar.a())) {
                this.f47470d.add(gVar.c());
            } else {
                this.f47470d.remove(gVar.c());
            }
            if (gVar.h() >= 1 && gVar.h() <= 100) {
                this.f47472f.put(gVar.c(), String.valueOf(gVar.h()));
            } else {
                this.f47472f.remove(gVar.c());
            }
            if (!TextUtils.isEmpty(gVar.b())) {
                this.f47473g.put(gVar.c(), gVar.b());
            } else {
                this.f47473g.remove(gVar.c());
            }
            if (gVar.f() != 0 && gVar.g() != 0) {
                h hVar = new h(gVar.c(), gVar.f(), gVar.g());
                this.f47474h.put(hVar.a(), hVar);
            }
            if (TextUtils.equals(gVar.d(), "1")) {
                this.f47475i.add(gVar.c());
            } else {
                this.f47475i.remove(gVar.c());
            }
        }
    }
}
