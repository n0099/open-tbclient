package d.a.h0.g.f0;

import android.text.TextUtils;
import android.util.Log;
import d.a.h0.a.k;
import d.a.h0.a.r1.e;
import d.a.h0.g.z.a.a;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f46329b = k.f43101a;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f46330c;

    /* renamed from: a  reason: collision with root package name */
    public d.a.h0.g.z.a.a f46331a;

    public static a b() {
        if (f46330c == null) {
            synchronized (a.class) {
                if (f46330c == null) {
                    f46330c = new a();
                }
            }
        }
        return f46330c;
    }

    public String a(String str) {
        d.a.h0.g.z.a.a aVar;
        a.c cVar;
        HashMap<String, String> hashMap;
        String c2 = c(str, 1);
        if (TextUtils.isEmpty(c2) || (aVar = this.f46331a) == null || (cVar = aVar.f46918d) == null || (hashMap = cVar.f46928a) == null) {
            return null;
        }
        return hashMap.get(c2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String c(String str, int i2) {
        d.a.h0.g.z.a.a aVar;
        a.b bVar;
        List<a.C0975a> list;
        if (!TextUtils.isEmpty(str) && (aVar = this.f46331a) != null && (bVar = aVar.f46917c) != null && (list = bVar.f46926a) != null) {
            for (a.C0975a c0975a : list) {
                if (TextUtils.equals(c0975a.f46922a, str) || TextUtils.equals(c0975a.f46923b, str)) {
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                if (i2 != 3) {
                                    return c0975a.f46923b;
                                }
                                return c0975a.f46925d;
                            }
                            return c0975a.f46924c;
                        }
                        return c0975a.f46923b;
                    }
                    return c0975a.f46922a;
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
        d.a.h0.g.z.a.a aVar = this.f46331a;
        if (aVar != null && (bVar = aVar.f46917c) != null && (hashMap = bVar.f46927b) != null && hashMap.containsKey(c2)) {
            if (f46329b) {
                Log.i("SubPackageDataHelper", "内存中查询分包是否存在信息");
            }
            return this.f46331a.f46917c.f46927b.get(c2).booleanValue();
        }
        if (f46329b) {
            Log.i("SubPackageDataHelper", "DB中查询分包是否存在信息");
        }
        String T = e.T();
        if (e.h() == null) {
            return false;
        }
        String W = e.h().W();
        if (TextUtils.isEmpty(T) || TextUtils.isEmpty(W)) {
            return false;
        }
        boolean m = d.a.h0.l.i.a.h().m(T, W, c2);
        if (m) {
            f(c2, true);
        }
        return m;
    }

    public void e(d.a.h0.g.z.a.a aVar) {
        this.f46331a = aVar;
    }

    public void f(String str, boolean z) {
        d.a.h0.g.z.a.a aVar;
        a.b bVar;
        if (TextUtils.isEmpty(str) || (aVar = this.f46331a) == null || (bVar = aVar.f46917c) == null || bVar.f46927b == null) {
            return;
        }
        if (f46329b) {
            Log.i("SubPackageDataHelper", "更新内存缓存信息: " + str + ": " + z);
        }
        this.f46331a.f46917c.f46927b.put(str, Boolean.valueOf(z));
    }
}
