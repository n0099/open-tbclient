package d.a.m0.h.i0;

import android.text.TextUtils;
import android.util.Log;
import d.a.m0.a.a2.e;
import d.a.m0.a.k;
import d.a.m0.h.c0.a.a;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f51180b = k.f46983a;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f51181c;

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.h.c0.a.a f51182a;

    public static a b() {
        if (f51181c == null) {
            synchronized (a.class) {
                if (f51181c == null) {
                    f51181c = new a();
                }
            }
        }
        return f51181c;
    }

    public String a(String str) {
        d.a.m0.h.c0.a.a aVar;
        a.c cVar;
        HashMap<String, String> hashMap;
        String c2 = c(str, 1);
        if (TextUtils.isEmpty(c2) || (aVar = this.f51182a) == null || (cVar = aVar.f51041d) == null || (hashMap = cVar.f51051a) == null) {
            return null;
        }
        return hashMap.get(c2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String c(String str, int i2) {
        d.a.m0.h.c0.a.a aVar;
        a.b bVar;
        List<a.C1077a> list;
        if (!TextUtils.isEmpty(str) && (aVar = this.f51182a) != null && (bVar = aVar.f51040c) != null && (list = bVar.f51049a) != null) {
            for (a.C1077a c1077a : list) {
                if (TextUtils.equals(c1077a.f51045a, str) || TextUtils.equals(c1077a.f51046b, str)) {
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                if (i2 != 3) {
                                    return c1077a.f51046b;
                                }
                                return c1077a.f51048d;
                            }
                            return c1077a.f51047c;
                        }
                        return c1077a.f51046b;
                    }
                    return c1077a.f51045a;
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
        d.a.m0.h.c0.a.a aVar = this.f51182a;
        if (aVar != null && (bVar = aVar.f51040c) != null && (hashMap = bVar.f51050b) != null && hashMap.containsKey(c2)) {
            if (f51180b) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.f51182a.f51040c.f51050b.get(c2).booleanValue();
        }
        if (f51180b) {
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
        boolean m = d.a.m0.n.g.a.h().m(V, Z, c2);
        if (m) {
            f(c2, true);
        }
        return m;
    }

    public void e(d.a.m0.h.c0.a.a aVar) {
        this.f51182a = aVar;
    }

    public void f(String str, boolean z) {
        d.a.m0.h.c0.a.a aVar;
        a.b bVar;
        if (TextUtils.isEmpty(str) || (aVar = this.f51182a) == null || (bVar = aVar.f51040c) == null || bVar.f51050b == null) {
            return;
        }
        if (f51180b) {
            Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
        }
        this.f51182a.f51040c.f51050b.put(str, Boolean.valueOf(z));
    }
}
