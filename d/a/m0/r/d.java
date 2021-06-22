package d.a.m0.r;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    public static volatile d m;

    /* renamed from: a  reason: collision with root package name */
    public Context f52152a;

    /* renamed from: b  reason: collision with root package name */
    public final HashSet<String> f52153b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    public final HashSet<String> f52154c = new HashSet<>();

    /* renamed from: d  reason: collision with root package name */
    public final HashSet<String> f52155d = new HashSet<>();

    /* renamed from: e  reason: collision with root package name */
    public final HashSet<String> f52156e = new HashSet<>();

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, String> f52157f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public final HashMap<String, String> f52158g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public final HashMap<String, h> f52159h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    public final HashSet<String> f52160i = new HashSet<>();
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
        return this.f52155d.contains(str);
    }

    public boolean b(String str) {
        if (e.h().s()) {
            return true;
        }
        return this.f52154c.contains(str);
    }

    public boolean c(String str, int i2) {
        if (this.f52153b.contains(str)) {
            return false;
        }
        if ((i2 & 16) == 0 && (i2 & 32) == 0) {
            return true;
        }
        return this.f52156e.contains(str);
    }

    public String d(String str) {
        return this.f52158g.containsKey(str) ? this.f52158g.get(str) : "";
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
        if (e.h().r() || TextUtils.isEmpty(str) || !this.f52157f.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.f52157f.get(str));
    }

    public String j(String str) {
        return (TextUtils.isEmpty(str) || !this.f52160i.contains(str)) ? "0" : "1";
    }

    public void k(c cVar, Context context) {
        this.f52152a = context;
        this.j = 360000;
        t g2 = t.g();
        this.k = g2.getInt("ubc_data_expire_time", 259200000);
        this.l = g2.getInt("ubc_database_limit", 4000);
        cVar.e().w(this.f52153b, this.f52156e, this.f52154c, this.f52155d, this.f52157f, this.f52158g, this.f52159h, this.f52160i);
    }

    public boolean l(String str) {
        h hVar = this.f52159h.get(str);
        return hVar != null && hVar.b();
    }

    public boolean m(String str) {
        h hVar = this.f52159h.get(str);
        return hVar != null && hVar.c();
    }

    public void n(int i2) {
        if (i2 < this.k) {
            return;
        }
        this.k = i2;
        t.g().putInt("ubc_data_expire_time", i2);
    }

    public void o(int i2) {
        if (i2 < this.l) {
            return;
        }
        this.l = i2;
        t.g().putInt("ubc_database_limit", i2);
    }

    public void p(int i2) {
        int i3 = i2 * 60000;
        if (i3 < this.j) {
            return;
        }
        this.j = i3;
    }

    public void q(List<g> list) {
        int i2;
        for (g gVar : list) {
            if ("0".equals(gVar.f52167b)) {
                this.f52153b.add(gVar.f52166a);
            } else {
                this.f52153b.remove(gVar.f52166a);
            }
            if ("1".equals(gVar.f52168c)) {
                this.f52154c.add(gVar.f52166a);
            } else {
                this.f52154c.remove(gVar.f52166a);
            }
            if ("1".equals(gVar.f52171f)) {
                this.f52155d.add(gVar.f52166a);
            } else {
                this.f52155d.remove(gVar.f52166a);
            }
            int i3 = gVar.f52172g;
            if (i3 >= 1 && i3 <= 100) {
                this.f52157f.put(gVar.f52166a, String.valueOf(i3));
            } else {
                this.f52157f.remove(gVar.f52166a);
            }
            if (!TextUtils.isEmpty(gVar.f52173h)) {
                this.f52158g.put(gVar.f52166a, gVar.f52173h);
            } else {
                this.f52158g.remove(gVar.f52166a);
            }
            int i4 = gVar.j;
            if (i4 != 0 && (i2 = gVar.f52174i) != 0) {
                h hVar = new h(gVar.f52166a, i4, i2);
                this.f52159h.put(hVar.a(), hVar);
            }
            if (TextUtils.equals(gVar.k, "1")) {
                this.f52160i.add(gVar.f52166a);
            } else {
                this.f52160i.remove(gVar.f52166a);
            }
        }
    }
}
