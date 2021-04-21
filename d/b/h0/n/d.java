package d.b.h0.n;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    public static volatile d m;

    /* renamed from: a  reason: collision with root package name */
    public Context f49941a;

    /* renamed from: b  reason: collision with root package name */
    public HashSet<String> f49942b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    public HashSet<String> f49943c = new HashSet<>();

    /* renamed from: d  reason: collision with root package name */
    public HashSet<String> f49944d = new HashSet<>();

    /* renamed from: e  reason: collision with root package name */
    public HashSet<String> f49945e = new HashSet<>();

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, String> f49946f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, String> f49947g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public HashMap<String, h> f49948h = new HashMap<>();
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
        return this.f49944d.contains(str);
    }

    public boolean b(String str) {
        if (e.g().s()) {
            return true;
        }
        return this.f49943c.contains(str);
    }

    public boolean c(String str, int i) {
        if (this.f49942b.contains(str)) {
            return false;
        }
        if ((i & 16) == 0 && (i & 32) == 0) {
            return true;
        }
        return this.f49945e.contains(str);
    }

    public String d(String str) {
        return this.f49947g.containsKey(str) ? this.f49947g.get(str) : "";
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
        if (e.g().q() || TextUtils.isEmpty(str) || !this.f49946f.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.f49946f.get(str));
    }

    public String j(String str) {
        return (TextUtils.isEmpty(str) || !this.i.contains(str)) ? "0" : "1";
    }

    public void k(c cVar, Context context) {
        this.f49941a = context;
        this.j = 360000;
        t f2 = t.f();
        this.k = f2.getInt("ubc_data_expire_time", 259200000);
        this.l = f2.getInt("ubc_database_limit", 4000);
        cVar.e().v(this.f49942b, this.f49945e, this.f49943c, this.f49944d, this.f49946f, this.f49947g, this.f49948h, this.i);
    }

    public boolean l(String str) {
        HashMap<String, h> hashMap = this.f49948h;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return false;
        }
        return this.f49948h.get(str).b();
    }

    public boolean m(String str) {
        HashMap<String, h> hashMap = this.f49948h;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return false;
        }
        return this.f49948h.get(str).c();
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
                this.f49942b.add(gVar.c());
            } else {
                this.f49942b.remove(gVar.c());
            }
            if ("1".equals(gVar.e())) {
                this.f49943c.add(gVar.c());
            } else {
                this.f49943c.remove(gVar.c());
            }
            if ("1".equals(gVar.a())) {
                this.f49944d.add(gVar.c());
            } else {
                this.f49944d.remove(gVar.c());
            }
            if (gVar.h() >= 1 && gVar.h() <= 100) {
                this.f49946f.put(gVar.c(), String.valueOf(gVar.h()));
            } else {
                this.f49946f.remove(gVar.c());
            }
            if (!TextUtils.isEmpty(gVar.b())) {
                this.f49947g.put(gVar.c(), gVar.b());
            } else {
                this.f49947g.remove(gVar.c());
            }
            if (gVar.f() != 0 && gVar.g() != 0) {
                h hVar = new h(gVar.c(), gVar.f(), gVar.g());
                this.f49948h.put(hVar.a(), hVar);
            }
            if (TextUtils.equals(gVar.d(), "1")) {
                this.i.add(gVar.c());
            } else {
                this.i.remove(gVar.c());
            }
        }
    }
}
