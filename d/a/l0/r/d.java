package d.a.l0.r;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    public static volatile d m;

    /* renamed from: a  reason: collision with root package name */
    public Context f48370a;

    /* renamed from: b  reason: collision with root package name */
    public final HashSet<String> f48371b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    public final HashSet<String> f48372c = new HashSet<>();

    /* renamed from: d  reason: collision with root package name */
    public final HashSet<String> f48373d = new HashSet<>();

    /* renamed from: e  reason: collision with root package name */
    public final HashSet<String> f48374e = new HashSet<>();

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, String> f48375f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public final HashMap<String, String> f48376g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public final HashMap<String, h> f48377h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    public final HashSet<String> f48378i = new HashSet<>();
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
        return this.f48373d.contains(str);
    }

    public boolean b(String str) {
        if (e.h().s()) {
            return true;
        }
        return this.f48372c.contains(str);
    }

    public boolean c(String str, int i2) {
        if (this.f48371b.contains(str)) {
            return false;
        }
        if ((i2 & 16) == 0 && (i2 & 32) == 0) {
            return true;
        }
        return this.f48374e.contains(str);
    }

    public String d(String str) {
        return this.f48376g.containsKey(str) ? this.f48376g.get(str) : "";
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
        if (e.h().r() || TextUtils.isEmpty(str) || !this.f48375f.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.f48375f.get(str));
    }

    public String j(String str) {
        return (TextUtils.isEmpty(str) || !this.f48378i.contains(str)) ? "0" : "1";
    }

    public void k(c cVar, Context context) {
        this.f48370a = context;
        this.j = 360000;
        t g2 = t.g();
        this.k = g2.getInt("ubc_data_expire_time", 259200000);
        this.l = g2.getInt("ubc_database_limit", 4000);
        cVar.e().w(this.f48371b, this.f48374e, this.f48372c, this.f48373d, this.f48375f, this.f48376g, this.f48377h, this.f48378i);
    }

    public boolean l(String str) {
        h hVar = this.f48377h.get(str);
        return hVar != null && hVar.b();
    }

    public boolean m(String str) {
        h hVar = this.f48377h.get(str);
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
            if ("0".equals(gVar.f48385b)) {
                this.f48371b.add(gVar.f48384a);
            } else {
                this.f48371b.remove(gVar.f48384a);
            }
            if ("1".equals(gVar.f48386c)) {
                this.f48372c.add(gVar.f48384a);
            } else {
                this.f48372c.remove(gVar.f48384a);
            }
            if ("1".equals(gVar.f48389f)) {
                this.f48373d.add(gVar.f48384a);
            } else {
                this.f48373d.remove(gVar.f48384a);
            }
            int i3 = gVar.f48390g;
            if (i3 >= 1 && i3 <= 100) {
                this.f48375f.put(gVar.f48384a, String.valueOf(i3));
            } else {
                this.f48375f.remove(gVar.f48384a);
            }
            if (!TextUtils.isEmpty(gVar.f48391h)) {
                this.f48376g.put(gVar.f48384a, gVar.f48391h);
            } else {
                this.f48376g.remove(gVar.f48384a);
            }
            int i4 = gVar.j;
            if (i4 != 0 && (i2 = gVar.f48392i) != 0) {
                h hVar = new h(gVar.f48384a, i4, i2);
                this.f48377h.put(hVar.a(), hVar);
            }
            if (TextUtils.equals(gVar.k, "1")) {
                this.f48378i.add(gVar.f48384a);
            } else {
                this.f48378i.remove(gVar.f48384a);
            }
        }
    }
}
