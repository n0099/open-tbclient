package d.a.m0.a.l2;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.webkit.net.WebAddress;
import d.a.m0.a.e0.d;
import d.a.m0.a.k;
import d.a.m0.a.l2.a;
import d.a.m0.a.v2.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
@Autowired
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: g  reason: collision with root package name */
    public static volatile b f47173g;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, ArrayList<d.a.m0.a.l2.a>> f47175a = new LinkedHashMap(32, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    public final d.a.m0.a.l2.e.a f47176b;

    /* renamed from: c  reason: collision with root package name */
    public volatile Boolean f47177c;

    /* renamed from: d  reason: collision with root package name */
    public volatile Boolean f47178d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f47179e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f47172f = k.f46983a;

    /* renamed from: h  reason: collision with root package name */
    public static final a.C0792a f47174h = new a.C0792a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f47176b.l();
            b.this.q().a(b.this);
        }
    }

    /* renamed from: d.a.m0.a.l2.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0793b {
        public void a(@NonNull b bVar) {
        }
    }

    public b() {
        d.a.m0.a.c1.a.Z().getSwitch("swan_cookie_enable", false);
        this.f47179e = false;
        this.f47176b = new d.a.m0.a.l2.e.a(this);
    }

    public static synchronized b l() {
        b bVar;
        synchronized (b.class) {
            if (f47173g == null) {
                f47173g = new b();
            }
            bVar = f47173g;
        }
        return bVar;
    }

    public static synchronized void u(boolean z) {
        synchronized (b.class) {
            if (f47173g != null) {
                f47173g.r(z);
            }
            f47173g = null;
        }
    }

    public synchronized boolean a() {
        if (this.f47177c != null) {
            d.h("SwanCookieManager", "acceptCookie =" + this.f47177c);
            return this.f47177c.booleanValue();
        }
        h();
        boolean z = false;
        if (this.f47178d == null) {
            return false;
        }
        if (this.f47178d.booleanValue() && this.f47179e) {
            z = true;
        }
        this.f47177c = Boolean.valueOf(z);
        d.h("SwanCookieManager", "mEnableStore =" + this.f47178d + "; mCookieABSwitch=" + this.f47179e);
        return this.f47177c.booleanValue();
    }

    public final synchronized void d(ArrayList<d.a.m0.a.l2.a> arrayList, d.a.m0.a.l2.a aVar) {
        if (arrayList == null || aVar == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (aVar.f47167e < 0 || aVar.f47167e > currentTimeMillis) {
            if (arrayList.size() >= 50) {
                d.a.m0.a.l2.a aVar2 = new d.a.m0.a.l2.a();
                aVar2.f47169g = currentTimeMillis;
                Iterator<d.a.m0.a.l2.a> it = arrayList.iterator();
                while (it.hasNext()) {
                    d.a.m0.a.l2.a next = it.next();
                    if (next != null && next.f47169g < aVar2.f47169g && next.f47171i != 2) {
                        aVar2 = next;
                    }
                }
                aVar2.f47171i = 2;
            }
            aVar.f47169g = currentTimeMillis;
            aVar.f47170h = currentTimeMillis;
            aVar.f47171i = 0;
            arrayList.add(aVar);
        }
    }

    public final synchronized void e(String str, String str2, ArrayList<d.a.m0.a.l2.a> arrayList) {
        if (!TextUtils.isEmpty(str2) && arrayList != null && !arrayList.isEmpty()) {
            String d2 = c.d(str2);
            if (d2 == null) {
                return;
            }
            ArrayList<d.a.m0.a.l2.a> arrayList2 = this.f47175a.get(d2);
            if (arrayList2 == null) {
                arrayList2 = this.f47176b.k(d2);
                this.f47175a.put(d2, arrayList2);
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                d.a.m0.a.l2.a aVar = arrayList.get(i2);
                if (!p(arrayList2, aVar, str)) {
                    d(arrayList2, aVar);
                }
            }
        }
    }

    public String f(String str, @Nullable String str2) {
        if (f47172f) {
            Log.d("SwanCookieManager", "getCookie url: " + str + "; defaultCookie=" + str2);
        }
        if (d.a.m0.a.a2.d.g().C() && a() && c.a(str)) {
            try {
                return i(new WebAddress(str), str2);
            } catch (Exception unused) {
                if (f47172f) {
                    Log.e("SwanCookieManager", "Bad address: " + str);
                }
                return str2;
            }
        }
        return str2;
    }

    public synchronized void g(d.a.m0.a.l2.a aVar) {
        if (aVar == null) {
            return;
        }
        if (aVar.f47171i == 2) {
            String d2 = c.d(aVar.f47163a);
            if (d2 == null) {
                return;
            }
            ArrayList<d.a.m0.a.l2.a> arrayList = this.f47175a.get(d2);
            if (arrayList != null) {
                arrayList.remove(aVar);
                if (arrayList.isEmpty()) {
                    this.f47175a.remove(d2);
                }
            }
        }
    }

    public void h() {
        SwanAppConfigData F;
        SwanAppConfigData.c cVar;
        if (this.f47178d != null || (F = d.a.m0.a.a2.d.g().r().F()) == null || (cVar = F.q) == null) {
            return;
        }
        this.f47178d = Boolean.valueOf(cVar.f11400a);
        d.h("SwanCookieManager", "enableStore =" + this.f47178d);
    }

    public final synchronized String i(WebAddress webAddress, String str) {
        String[] e2 = c.e(webAddress);
        if (e2 == null) {
            return str;
        }
        String d2 = c.d(e2[0]);
        if (d2 == null) {
            return str;
        }
        ArrayList<d.a.m0.a.l2.a> arrayList = this.f47175a.get(d2);
        if (arrayList == null) {
            arrayList = this.f47176b.k(d2);
            this.f47175a.put(d2, arrayList);
        }
        SortedSet<d.a.m0.a.l2.a> m = m(arrayList, webAddress.getScheme(), e2);
        if (m != null && !m.isEmpty()) {
            String b2 = c.b(m, str);
            if (f47172f) {
                Log.d("SwanCookieManager", "getCookie result:" + b2 + ";defaultCookie=" + str);
            }
            return b2;
        }
        return str;
    }

    public String j(String str) {
        return f(str, null);
    }

    public final long k(Collection<String> collection) {
        long j = 0;
        if (collection != null && !collection.isEmpty()) {
            for (String str : collection) {
                if (str != null) {
                    j += str.length();
                }
            }
        }
        return j;
    }

    public final synchronized SortedSet<d.a.m0.a.l2.a> m(ArrayList<d.a.m0.a.l2.a> arrayList, String str, String[] strArr) {
        if (arrayList != null) {
            if (!arrayList.isEmpty() && strArr != null) {
                long currentTimeMillis = System.currentTimeMillis();
                TreeSet treeSet = new TreeSet(f47174h);
                Iterator<d.a.m0.a.l2.a> it = arrayList.iterator();
                while (it.hasNext()) {
                    d.a.m0.a.l2.a next = it.next();
                    if (next != null && next.a(strArr[0]) && next.c(strArr[1]) && (next.f47167e < 0 || next.f47167e > currentTimeMillis)) {
                        if (!next.f47168f || "https".equals(str)) {
                            if (next.f47171i != 2) {
                                next.f47169g = currentTimeMillis;
                                treeSet.add(next);
                            }
                        }
                    }
                }
                return treeSet;
            }
        }
        return null;
    }

    public synchronized ArrayList<d.a.m0.a.l2.a> n() {
        ArrayList<d.a.m0.a.l2.a> arrayList;
        arrayList = new ArrayList<>();
        for (ArrayList<d.a.m0.a.l2.a> arrayList2 : this.f47175a.values()) {
            if (arrayList2 != null) {
                Iterator<d.a.m0.a.l2.a> it = arrayList2.iterator();
                while (it.hasNext()) {
                    d.a.m0.a.l2.a next = it.next();
                    if (next != null && next.f47171i != 1) {
                        arrayList.add(next);
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean o() {
        return this.f47179e;
    }

    public final synchronized boolean p(ArrayList<d.a.m0.a.l2.a> arrayList, d.a.m0.a.l2.a aVar, String str) {
        if (arrayList == null || aVar == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<d.a.m0.a.l2.a> it = arrayList.iterator();
        while (it.hasNext()) {
            d.a.m0.a.l2.a next = it.next();
            if (aVar.b(next)) {
                if (aVar.f47167e >= 0 && aVar.f47167e <= currentTimeMillis) {
                    next.f47170h = currentTimeMillis;
                    next.f47171i = 2;
                    return true;
                }
                if (!next.f47168f || "https".equals(str)) {
                    next.f47166d = aVar.f47166d;
                    next.f47167e = aVar.f47167e;
                    next.f47168f = aVar.f47168f;
                    next.f47169g = currentTimeMillis;
                    next.f47170h = currentTimeMillis;
                    next.f47171i = 3;
                }
                return true;
            }
        }
        return false;
    }

    @Inject(force = false)
    public final synchronized C0793b q() {
        return new C0793b();
    }

    public final synchronized void r(boolean z) {
        if (z) {
            this.f47176b.c();
        }
        this.f47176b.e();
        d.h("SwanCookieManager", "onRelease");
    }

    public final ArrayList<d.a.m0.a.l2.a> s(String[] strArr, String str) {
        if (strArr == null || TextUtils.isEmpty(str)) {
            return null;
        }
        if (strArr[1].length() > 1) {
            int lastIndexOf = strArr[1].lastIndexOf(47);
            String str2 = strArr[1];
            if (lastIndexOf <= 0) {
                lastIndexOf++;
            }
            strArr[1] = str2.substring(0, lastIndexOf);
        }
        try {
            return c.g(strArr[0], strArr[1], str);
        } catch (Exception unused) {
            if (f47172f) {
                Log.e("SwanCookieManager", "parse cookie failed: " + str);
                return null;
            }
            return null;
        }
    }

    public void t() {
        if (d.a.m0.a.a2.d.g().C() && a()) {
            q.j(new a(), "preInitCookieDb");
        }
    }

    public final synchronized void v(WebAddress webAddress, String str) {
        if (webAddress != null) {
            if (!TextUtils.isEmpty(str)) {
                if (str.length() > 4096) {
                    d.l("SwanCookieManager", "setCookie value is too large");
                    return;
                }
                String[] e2 = c.e(webAddress);
                if (e2 == null) {
                    return;
                }
                e(webAddress.getScheme(), e2[0], s(e2, str));
                this.f47176b.g();
            }
        }
    }

    public void w(String str, String str2) {
        if (d.a.m0.a.a2.d.g().C() && a() && c.a(str)) {
            try {
                v(new WebAddress(str), str2);
            } catch (Exception unused) {
                if (f47172f) {
                    Log.e("SwanCookieManager", "setCookie with bad address: " + str);
                }
            }
        }
    }

    public void x(String str, Collection<String> collection) {
        if (TextUtils.isEmpty(str) || collection == null || collection.isEmpty()) {
            return;
        }
        if (k(collection) > 4096) {
            d.l("SwanCookieManager", "setCookie values is too large");
            return;
        }
        if (f47172f) {
            Log.d("SwanCookieManager", "setCookie: url=" + str + "; values=" + collection);
        }
        for (String str2 : collection) {
            w(str, str2);
        }
    }

    public synchronized void y(d.a.m0.a.l2.a aVar) {
        aVar.f47171i = 1;
    }
}
