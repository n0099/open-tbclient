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
    public static final boolean f47398b = k.f43199a;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f47399c;

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.h.c0.a.a f47400a;

    public static a b() {
        if (f47399c == null) {
            synchronized (a.class) {
                if (f47399c == null) {
                    f47399c = new a();
                }
            }
        }
        return f47399c;
    }

    public String a(String str) {
        d.a.l0.h.c0.a.a aVar;
        a.c cVar;
        HashMap<String, String> hashMap;
        String c2 = c(str, 1);
        if (TextUtils.isEmpty(c2) || (aVar = this.f47400a) == null || (cVar = aVar.f47259d) == null || (hashMap = cVar.f47269a) == null) {
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
        List<a.C1018a> list;
        if (!TextUtils.isEmpty(str) && (aVar = this.f47400a) != null && (bVar = aVar.f47258c) != null && (list = bVar.f47267a) != null) {
            for (a.C1018a c1018a : list) {
                if (TextUtils.equals(c1018a.f47263a, str) || TextUtils.equals(c1018a.f47264b, str)) {
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                if (i2 != 3) {
                                    return c1018a.f47264b;
                                }
                                return c1018a.f47266d;
                            }
                            return c1018a.f47265c;
                        }
                        return c1018a.f47264b;
                    }
                    return c1018a.f47263a;
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
        d.a.l0.h.c0.a.a aVar = this.f47400a;
        if (aVar != null && (bVar = aVar.f47258c) != null && (hashMap = bVar.f47268b) != null && hashMap.containsKey(c2)) {
            if (f47398b) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.f47400a.f47258c.f47268b.get(c2).booleanValue();
        }
        if (f47398b) {
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
        this.f47400a = aVar;
    }

    public void f(String str, boolean z) {
        d.a.l0.h.c0.a.a aVar;
        a.b bVar;
        if (TextUtils.isEmpty(str) || (aVar = this.f47400a) == null || (bVar = aVar.f47258c) == null || bVar.f47268b == null) {
            return;
        }
        if (f47398b) {
            Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
        }
        this.f47400a.f47258c.f47268b.put(str, Boolean.valueOf(z));
    }
}
