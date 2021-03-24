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
    public static final boolean f48135b = k.f45050a;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f48136c;

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.g.z.a.a f48137a;

    public static a b() {
        if (f48136c == null) {
            synchronized (a.class) {
                if (f48136c == null) {
                    f48136c = new a();
                }
            }
        }
        return f48136c;
    }

    public String a(String str) {
        d.b.g0.g.z.a.a aVar;
        a.c cVar;
        HashMap<String, String> hashMap;
        String c2 = c(str, 1);
        if (TextUtils.isEmpty(c2) || (aVar = this.f48137a) == null || (cVar = aVar.f48696d) == null || (hashMap = cVar.f48706a) == null) {
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
        List<a.C1003a> list;
        if (!TextUtils.isEmpty(str) && (aVar = this.f48137a) != null && (bVar = aVar.f48695c) != null && (list = bVar.f48704a) != null) {
            for (a.C1003a c1003a : list) {
                if (TextUtils.equals(c1003a.f48700a, str) || TextUtils.equals(c1003a.f48701b, str)) {
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    return c1003a.f48701b;
                                }
                                return c1003a.f48703d;
                            }
                            return c1003a.f48702c;
                        }
                        return c1003a.f48701b;
                    }
                    return c1003a.f48700a;
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
        d.b.g0.g.z.a.a aVar = this.f48137a;
        if (aVar != null && (bVar = aVar.f48695c) != null && (hashMap = bVar.f48705b) != null && hashMap.containsKey(c2)) {
            if (f48135b) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.f48137a.f48695c.f48705b.get(c2).booleanValue();
        }
        if (f48135b) {
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
        this.f48137a = aVar;
    }

    public void f(String str, boolean z) {
        d.b.g0.g.z.a.a aVar;
        a.b bVar;
        if (TextUtils.isEmpty(str) || (aVar = this.f48137a) == null || (bVar = aVar.f48695c) == null || bVar.f48705b == null) {
            return;
        }
        if (f48135b) {
            Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
        }
        this.f48137a.f48695c.f48705b.put(str, Boolean.valueOf(z));
    }
}
