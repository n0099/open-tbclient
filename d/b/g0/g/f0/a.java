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
    public static final boolean f48136b = k.f45051a;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f48137c;

    /* renamed from: a  reason: collision with root package name */
    public d.b.g0.g.z.a.a f48138a;

    public static a b() {
        if (f48137c == null) {
            synchronized (a.class) {
                if (f48137c == null) {
                    f48137c = new a();
                }
            }
        }
        return f48137c;
    }

    public String a(String str) {
        d.b.g0.g.z.a.a aVar;
        a.c cVar;
        HashMap<String, String> hashMap;
        String c2 = c(str, 1);
        if (TextUtils.isEmpty(c2) || (aVar = this.f48138a) == null || (cVar = aVar.f48697d) == null || (hashMap = cVar.f48707a) == null) {
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
        List<a.C1004a> list;
        if (!TextUtils.isEmpty(str) && (aVar = this.f48138a) != null && (bVar = aVar.f48696c) != null && (list = bVar.f48705a) != null) {
            for (a.C1004a c1004a : list) {
                if (TextUtils.equals(c1004a.f48701a, str) || TextUtils.equals(c1004a.f48702b, str)) {
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    return c1004a.f48702b;
                                }
                                return c1004a.f48704d;
                            }
                            return c1004a.f48703c;
                        }
                        return c1004a.f48702b;
                    }
                    return c1004a.f48701a;
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
        d.b.g0.g.z.a.a aVar = this.f48138a;
        if (aVar != null && (bVar = aVar.f48696c) != null && (hashMap = bVar.f48706b) != null && hashMap.containsKey(c2)) {
            if (f48136b) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.f48138a.f48696c.f48706b.get(c2).booleanValue();
        }
        if (f48136b) {
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
        this.f48138a = aVar;
    }

    public void f(String str, boolean z) {
        d.b.g0.g.z.a.a aVar;
        a.b bVar;
        if (TextUtils.isEmpty(str) || (aVar = this.f48138a) == null || (bVar = aVar.f48696c) == null || bVar.f48706b == null) {
            return;
        }
        if (f48136b) {
            Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
        }
        this.f48138a.f48696c.f48706b.put(str, Boolean.valueOf(z));
    }
}
