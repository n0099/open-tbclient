package d.a.i0.r;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    public static volatile d m;

    /* renamed from: a  reason: collision with root package name */
    public Context f48194a;

    /* renamed from: b  reason: collision with root package name */
    public final HashSet<String> f48195b = new HashSet<>();

    /* renamed from: c  reason: collision with root package name */
    public final HashSet<String> f48196c = new HashSet<>();

    /* renamed from: d  reason: collision with root package name */
    public final HashSet<String> f48197d = new HashSet<>();

    /* renamed from: e  reason: collision with root package name */
    public final HashSet<String> f48198e = new HashSet<>();

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, String> f48199f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    public final HashMap<String, String> f48200g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public final HashMap<String, h> f48201h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    public final HashSet<String> f48202i = new HashSet<>();
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
        return this.f48197d.contains(str);
    }

    public boolean b(String str) {
        if (e.h().s()) {
            return true;
        }
        return this.f48196c.contains(str);
    }

    public boolean c(String str, int i2) {
        if (this.f48195b.contains(str)) {
            return false;
        }
        if ((i2 & 16) == 0 && (i2 & 32) == 0) {
            return true;
        }
        return this.f48198e.contains(str);
    }

    public String d(String str) {
        return this.f48200g.containsKey(str) ? this.f48200g.get(str) : "";
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
        if (e.h().r() || TextUtils.isEmpty(str) || !this.f48199f.containsKey(str)) {
            return 0;
        }
        return Integer.parseInt(this.f48199f.get(str));
    }

    public String j(String str) {
        return (TextUtils.isEmpty(str) || !this.f48202i.contains(str)) ? "0" : "1";
    }

    public void k(c cVar, Context context) {
        this.f48194a = context;
        this.j = 360000;
        t g2 = t.g();
        this.k = g2.getInt("ubc_data_expire_time", 259200000);
        this.l = g2.getInt("ubc_database_limit", 4000);
        cVar.e().w(this.f48195b, this.f48198e, this.f48196c, this.f48197d, this.f48199f, this.f48200g, this.f48201h, this.f48202i);
    }

    public boolean l(String str) {
        h hVar = this.f48201h.get(str);
        return hVar != null && hVar.b();
    }

    public boolean m(String str) {
        h hVar = this.f48201h.get(str);
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
            if ("0".equals(gVar.f48209b)) {
                this.f48195b.add(gVar.f48208a);
            } else {
                this.f48195b.remove(gVar.f48208a);
            }
            if ("1".equals(gVar.f48210c)) {
                this.f48196c.add(gVar.f48208a);
            } else {
                this.f48196c.remove(gVar.f48208a);
            }
            if ("1".equals(gVar.f48213f)) {
                this.f48197d.add(gVar.f48208a);
            } else {
                this.f48197d.remove(gVar.f48208a);
            }
            int i3 = gVar.f48214g;
            if (i3 >= 1 && i3 <= 100) {
                this.f48199f.put(gVar.f48208a, String.valueOf(i3));
            } else {
                this.f48199f.remove(gVar.f48208a);
            }
            if (!TextUtils.isEmpty(gVar.f48215h)) {
                this.f48200g.put(gVar.f48208a, gVar.f48215h);
            } else {
                this.f48200g.remove(gVar.f48208a);
            }
            int i4 = gVar.j;
            if (i4 != 0 && (i2 = gVar.f48216i) != 0) {
                h hVar = new h(gVar.f48208a, i4, i2);
                this.f48201h.put(hVar.a(), hVar);
            }
            if (TextUtils.equals(gVar.k, "1")) {
                this.f48202i.add(gVar.f48208a);
            } else {
                this.f48202i.remove(gVar.f48208a);
            }
        }
    }
}
