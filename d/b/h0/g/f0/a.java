package d.b.h0.g.f0;

import android.text.TextUtils;
import android.util.Log;
import d.b.h0.a.k;
import d.b.h0.a.r1.e;
import d.b.h0.g.z.a.a;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f48857b = k.f45772a;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f48858c;

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.g.z.a.a f48859a;

    public static a b() {
        if (f48858c == null) {
            synchronized (a.class) {
                if (f48858c == null) {
                    f48858c = new a();
                }
            }
        }
        return f48858c;
    }

    public String a(String str) {
        d.b.h0.g.z.a.a aVar;
        a.c cVar;
        HashMap<String, String> hashMap;
        String c2 = c(str, 1);
        if (TextUtils.isEmpty(c2) || (aVar = this.f48859a) == null || (cVar = aVar.f49418d) == null || (hashMap = cVar.f49428a) == null) {
            return null;
        }
        return hashMap.get(c2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String c(String str, int i) {
        d.b.h0.g.z.a.a aVar;
        a.b bVar;
        List<a.C1036a> list;
        if (!TextUtils.isEmpty(str) && (aVar = this.f48859a) != null && (bVar = aVar.f49417c) != null && (list = bVar.f49426a) != null) {
            for (a.C1036a c1036a : list) {
                if (TextUtils.equals(c1036a.f49422a, str) || TextUtils.equals(c1036a.f49423b, str)) {
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
                                if (i != 3) {
                                    return c1036a.f49423b;
                                }
                                return c1036a.f49425d;
                            }
                            return c1036a.f49424c;
                        }
                        return c1036a.f49423b;
                    }
                    return c1036a.f49422a;
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
        d.b.h0.g.z.a.a aVar = this.f48859a;
        if (aVar != null && (bVar = aVar.f49417c) != null && (hashMap = bVar.f49427b) != null && hashMap.containsKey(c2)) {
            if (f48857b) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.f48859a.f49417c.f49427b.get(c2).booleanValue();
        }
        if (f48857b) {
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
        boolean m = d.b.h0.l.i.a.h().m(T, W, c2);
        if (m) {
            f(c2, true);
        }
        return m;
    }

    public void e(d.b.h0.g.z.a.a aVar) {
        this.f48859a = aVar;
    }

    public void f(String str, boolean z) {
        d.b.h0.g.z.a.a aVar;
        a.b bVar;
        if (TextUtils.isEmpty(str) || (aVar = this.f48859a) == null || (bVar = aVar.f49417c) == null || bVar.f49427b == null) {
            return;
        }
        if (f48857b) {
            Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
        }
        this.f48859a.f49417c.f49427b.put(str, Boolean.valueOf(z));
    }
}
