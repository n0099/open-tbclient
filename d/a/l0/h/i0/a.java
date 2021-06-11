package d.a.l0.h.i0;

import android.text.TextUtils;
import android.util.Log;
import d.a.l0.a.a2.e;
import d.a.l0.a.k;
import d.a.l0.h.c0.a.a;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f51072b = k.f46875a;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f51073c;

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.h.c0.a.a f51074a;

    public static a b() {
        if (f51073c == null) {
            synchronized (a.class) {
                if (f51073c == null) {
                    f51073c = new a();
                }
            }
        }
        return f51073c;
    }

    public String a(String str) {
        d.a.l0.h.c0.a.a aVar;
        a.c cVar;
        HashMap<String, String> hashMap;
        String c2 = c(str, 1);
        if (TextUtils.isEmpty(c2) || (aVar = this.f51074a) == null || (cVar = aVar.f50933d) == null || (hashMap = cVar.f50943a) == null) {
            return null;
        }
        return hashMap.get(c2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String c(String str, int i2) {
        d.a.l0.h.c0.a.a aVar;
        a.b bVar;
        List<a.C1074a> list;
        if (!TextUtils.isEmpty(str) && (aVar = this.f51074a) != null && (bVar = aVar.f50932c) != null && (list = bVar.f50941a) != null) {
            for (a.C1074a c1074a : list) {
                if (TextUtils.equals(c1074a.f50937a, str) || TextUtils.equals(c1074a.f50938b, str)) {
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                if (i2 != 3) {
                                    return c1074a.f50938b;
                                }
                                return c1074a.f50940d;
                            }
                            return c1074a.f50939c;
                        }
                        return c1074a.f50938b;
                    }
                    return c1074a.f50937a;
                }
                while (r0.hasNext()) {
                }
            }
        }
        return null;
    }

    public boolean d(String str) {
        a.b bVar;
        HashMap<String, Boolean> hashMap;
        String c2 = c(str, 1);
        if (TextUtils.isEmpty(c2)) {
            return false;
        }
        d.a.l0.h.c0.a.a aVar = this.f51074a;
        if (aVar != null && (bVar = aVar.f50932c) != null && (hashMap = bVar.f50942b) != null && hashMap.containsKey(c2)) {
            if (f51072b) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.f51074a.f50932c.f50942b.get(c2).booleanValue();
        }
        if (f51072b) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String V = e.V();
        if (e.i() == null) {
            return false;
        }
        String Z = e.i().Z();
        if (TextUtils.isEmpty(V) || TextUtils.isEmpty(Z)) {
            return false;
        }
        boolean m = d.a.l0.n.g.a.h().m(V, Z, c2);
        if (m) {
            f(c2, true);
        }
        return m;
    }

    public void e(d.a.l0.h.c0.a.a aVar) {
        this.f51074a = aVar;
    }

    public void f(String str, boolean z) {
        d.a.l0.h.c0.a.a aVar;
        a.b bVar;
        if (TextUtils.isEmpty(str) || (aVar = this.f51074a) == null || (bVar = aVar.f50932c) == null || bVar.f50942b == null) {
            return;
        }
        if (f51072b) {
            Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
        }
        this.f51074a.f50932c.f50942b.put(str, Boolean.valueOf(z));
    }
}
