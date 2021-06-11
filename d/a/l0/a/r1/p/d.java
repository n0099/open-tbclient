package d.a.l0.a.r1.p;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: d  reason: collision with root package name */
    public static volatile d f48234d;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, e> f48235a;

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, e> f48236b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, e> f48237c;

    public d() {
        c();
    }

    public static d b() {
        if (f48234d == null) {
            synchronized (d.class) {
                if (f48234d == null) {
                    f48234d = new d();
                }
            }
        }
        return f48234d;
    }

    public static synchronized void f() {
        synchronized (d.class) {
            if (f48234d != null) {
                f48234d.e();
                f48234d = null;
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
            d.a.l0.a.q2.d.f47905d.d(Long.valueOf(j));
        } else if (c2 == 1) {
            d.a.l0.a.q2.d.f47906e.d(Long.valueOf(j));
        } else if (c2 != 2) {
        } else {
            d.a.l0.a.q2.d.f47907f.d(Long.valueOf(j));
        }
    }

    public final void c() {
        if (this.f48235a == null) {
            this.f48235a = new HashMap<>();
        }
        if (this.f48236b == null) {
            this.f48236b = new HashMap<>();
        }
        if (this.f48237c == null) {
            this.f48237c = new HashMap<>();
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
        HashMap<String, e> hashMap = this.f48235a;
        if (hashMap != null) {
            hashMap.clear();
        }
        HashMap<String, e> hashMap2 = this.f48236b;
        if (hashMap2 != null) {
            hashMap2.clear();
        }
        HashMap<String, e> hashMap3 = this.f48237c;
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
            eVar = this.f48235a.remove(str);
        } else if (c2 == 1) {
            eVar = this.f48236b.remove(str);
        } else if (c2 == 2) {
            eVar = this.f48237c.remove(str);
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
            eVar = this.f48235a.get(str);
            if (eVar == null) {
                eVar = new b();
                this.f48235a.put(str, eVar);
            }
        } else if (c2 == 1) {
            eVar = this.f48236b.get(str);
            if (eVar == null) {
                eVar = new a();
                this.f48236b.put(str, eVar);
            }
        } else if (c2 == 2 && (eVar = this.f48237c.get(str)) == null) {
            eVar = new c();
            this.f48237c.put(str, eVar);
        }
        if (eVar != null) {
            eVar.c(j);
        }
    }
}
