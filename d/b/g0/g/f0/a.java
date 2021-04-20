package d.b.g0.g.f0;

import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.k;
import d.b.g0.a.r1.e;
import d.b.g0.g.z.a.a;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f48528b = k.f45443a;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f48529c;

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.g.z.a.a f48530a;

    public static a b() {
        if (f48529c == null) {
            synchronized (a.class) {
                if (f48529c == null) {
                    f48529c = new a();
                }
            }
        }
        return f48529c;
    }

    public String a(String str) {
        d.b.g0.g.z.a.a aVar;
        a.c cVar;
        HashMap<String, String> hashMap;
        String c2 = c(str, 1);
        if (TextUtils.isEmpty(c2) || (aVar = this.f48530a) == null || (cVar = aVar.f49089d) == null || (hashMap = cVar.f49099a) == null) {
            return null;
        }
        return hashMap.get(c2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String c(String str, int i) {
        d.b.g0.g.z.a.a aVar;
        a.b bVar;
        List<a.C1016a> list;
        if (!TextUtils.isEmpty(str) && (aVar = this.f48530a) != null && (bVar = aVar.f49088c) != null && (list = bVar.f49097a) != null) {
            for (a.C1016a c1016a : list) {
                if (TextUtils.equals(c1016a.f49093a, str) || TextUtils.equals(c1016a.f49094b, str)) {
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    return c1016a.f49094b;
                                }
                                return c1016a.f49096d;
                            }
                            return c1016a.f49095c;
                        }
                        return c1016a.f49094b;
                    }
                    return c1016a.f49093a;
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
        d.b.g0.g.z.a.a aVar = this.f48530a;
        if (aVar != null && (bVar = aVar.f49088c) != null && (hashMap = bVar.f49098b) != null && hashMap.containsKey(c2)) {
            if (f48528b) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.f48530a.f49088c.f49098b.get(c2).booleanValue();
        }
        if (f48528b) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String T = e.T();
        if (e.y() == null) {
            return false;
        }
        String W = e.y().W();
        if (TextUtils.isEmpty(T) || TextUtils.isEmpty(W)) {
            return false;
        }
        boolean m = d.b.g0.l.i.a.h().m(T, W, c2);
        if (m) {
            f(c2, true);
        }
        return m;
    }

    public void e(d.b.g0.g.z.a.a aVar) {
        this.f48530a = aVar;
    }

    public void f(String str, boolean z) {
        d.b.g0.g.z.a.a aVar;
        a.b bVar;
        if (TextUtils.isEmpty(str) || (aVar = this.f48530a) == null || (bVar = aVar.f49088c) == null || bVar.f49098b == null) {
            return;
        }
        if (f48528b) {
            Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
        }
        this.f48530a.f49088c.f49098b.put(str, Boolean.valueOf(z));
    }
}
