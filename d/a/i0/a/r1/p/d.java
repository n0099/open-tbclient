package d.a.i0.a.r1.p;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: d  reason: collision with root package name */
    public static volatile d f44384d;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, e> f44385a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, e> f44386b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, e> f44387c;

    public d() {
        c();
    }

    public static d b() {
        if (f44384d == null) {
            synchronized (d.class) {
                if (f44384d == null) {
                    f44384d = new d();
                }
            }
        }
        return f44384d;
    }

    public static synchronized void f() {
        synchronized (d.class) {
            if (f44384d != null) {
                f44384d.e();
                f44384d = null;
            }
        }
    }

    public final void a(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        char c2 = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 767526192) {
            if (hashCode != 1331686101) {
                if (hashCode == 1390184462 && str.equals("PageUpdateRender")) {
                    c2 = 2;
                }
            } else if (str.equals("PageInitRender")) {
                c2 = 1;
            }
        } else if (str.equals("PageSwitchCost")) {
            c2 = 0;
        }
        if (c2 == 0) {
            d.a.i0.a.q2.d.f44055d.d(Long.valueOf(j));
        } else if (c2 == 1) {
            d.a.i0.a.q2.d.f44056e.d(Long.valueOf(j));
        } else if (c2 != 2) {
        } else {
            d.a.i0.a.q2.d.f44057f.d(Long.valueOf(j));
        }
    }

    public final void c() {
        if (this.f44385a == null) {
            this.f44385a = new HashMap<>();
        }
        if (this.f44386b == null) {
            this.f44386b = new HashMap<>();
        }
        if (this.f44387c == null) {
            this.f44387c = new HashMap<>();
        }
    }

    public void d(String str, String str2, long j) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || j < 0) {
            return;
        }
        c();
        char c2 = 65535;
        switch (str2.hashCode()) {
            case -1880922749:
                if (str2.equals("pageUpdateEnd")) {
                    c2 = 5;
                    break;
                }
                break;
            case -964566145:
                if (str2.equals("pageSwitchStart")) {
                    c2 = 0;
                    break;
                }
                break;
            case -410083667:
                if (str2.equals("pageInitRenderStart")) {
                    c2 = 1;
                    break;
                }
                break;
            case 4028902:
                if (str2.equals("pageInitRenderEnd")) {
                    c2 = 4;
                    break;
                }
                break;
            case 627578634:
                if (str2.equals("pageUpdateStart")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1719651128:
                if (str2.equals("pageSwitchEnd")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        if (c2 == 0 || c2 == 1 || c2 == 2) {
            h(str, str2, j);
        } else if (c2 == 3 || c2 == 4 || c2 == 5) {
            g(str, str2, j);
        }
    }

    public final void e() {
        HashMap<String, e> hashMap = this.f44385a;
        if (hashMap != null) {
            hashMap.clear();
        }
        HashMap<String, e> hashMap2 = this.f44386b;
        if (hashMap2 != null) {
            hashMap2.clear();
        }
        HashMap<String, e> hashMap3 = this.f44387c;
        if (hashMap3 != null) {
            hashMap3.clear();
        }
    }

    public final void g(String str, String str2, long j) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        e eVar = null;
        char c2 = 65535;
        int hashCode = str2.hashCode();
        if (hashCode != -1880922749) {
            if (hashCode != 4028902) {
                if (hashCode == 1719651128 && str2.equals("pageSwitchEnd")) {
                    c2 = 0;
                }
            } else if (str2.equals("pageInitRenderEnd")) {
                c2 = 1;
            }
        } else if (str2.equals("pageUpdateEnd")) {
            c2 = 2;
        }
        if (c2 == 0) {
            eVar = this.f44385a.remove(str);
        } else if (c2 == 1) {
            eVar = this.f44386b.remove(str);
        } else if (c2 == 2) {
            eVar = this.f44387c.remove(str);
        }
        if (eVar == null) {
            return;
        }
        eVar.b(j);
        a(eVar.getType(), eVar.a());
    }

    public final void h(String str, String str2, long j) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        e eVar = null;
        char c2 = 65535;
        int hashCode = str2.hashCode();
        if (hashCode != -964566145) {
            if (hashCode != -410083667) {
                if (hashCode == 627578634 && str2.equals("pageUpdateStart")) {
                    c2 = 2;
                }
            } else if (str2.equals("pageInitRenderStart")) {
                c2 = 1;
            }
        } else if (str2.equals("pageSwitchStart")) {
            c2 = 0;
        }
        if (c2 == 0) {
            eVar = this.f44385a.get(str);
            if (eVar == null) {
                eVar = new b();
                this.f44385a.put(str, eVar);
            }
        } else if (c2 == 1) {
            eVar = this.f44386b.get(str);
            if (eVar == null) {
                eVar = new a();
                this.f44386b.put(str, eVar);
            }
        } else if (c2 == 2 && (eVar = this.f44387c.get(str)) == null) {
            eVar = new c();
            this.f44387c.put(str, eVar);
        }
        if (eVar != null) {
            eVar.c(j);
        }
    }
}
