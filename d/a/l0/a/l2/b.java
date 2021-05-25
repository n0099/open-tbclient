package d.a.l0.a.l2;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.webkit.net.WebAddress;
import d.a.l0.a.e0.d;
import d.a.l0.a.k;
import d.a.l0.a.l2.a;
import d.a.l0.a.v2.q;
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
    public static volatile b f43389g;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, ArrayList<d.a.l0.a.l2.a>> f43391a = new LinkedHashMap(32, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    public final d.a.l0.a.l2.e.a f43392b;

    /* renamed from: c  reason: collision with root package name */
    public volatile Boolean f43393c;

    /* renamed from: d  reason: collision with root package name */
    public volatile Boolean f43394d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f43395e;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f43388f = k.f43199a;

    /* renamed from: h  reason: collision with root package name */
    public static final a.C0733a f43390h = new a.C0733a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f43392b.l();
            b.this.q().a(b.this);
        }
    }

    /* renamed from: d.a.l0.a.l2.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0734b {
        public void a(@NonNull b bVar) {
        }
    }

    public b() {
        d.a.l0.a.c1.a.Z().getSwitch("swan_cookie_enable", false);
        this.f43395e = false;
        this.f43392b = new d.a.l0.a.l2.e.a(this);
    }

    public static synchronized b l() {
        b bVar;
        synchronized (b.class) {
            if (f43389g == null) {
                f43389g = new b();
            }
            bVar = f43389g;
        }
        return bVar;
    }

    public static synchronized void u(boolean z) {
        synchronized (b.class) {
            if (f43389g != null) {
                f43389g.r(z);
            }
            f43389g = null;
        }
    }

    public synchronized boolean a() {
        if (this.f43393c != null) {
            d.h("SwanCookieManager", "acceptCookie =" + this.f43393c);
            return this.f43393c.booleanValue();
        }
        h();
        boolean z = false;
        if (this.f43394d == null) {
            return false;
        }
        if (this.f43394d.booleanValue() && this.f43395e) {
            z = true;
        }
        this.f43393c = Boolean.valueOf(z);
        d.h("SwanCookieManager", "mEnableStore =" + this.f43394d + "; mCookieABSwitch=" + this.f43395e);
        return this.f43393c.booleanValue();
    }

    public final synchronized void d(ArrayList<d.a.l0.a.l2.a> arrayList, d.a.l0.a.l2.a aVar) {
        if (arrayList == null || aVar == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (aVar.f43383e < 0 || aVar.f43383e > currentTimeMillis) {
            if (arrayList.size() >= 50) {
                d.a.l0.a.l2.a aVar2 = new d.a.l0.a.l2.a();
                aVar2.f43385g = currentTimeMillis;
                Iterator<d.a.l0.a.l2.a> it = arrayList.iterator();
                while (it.hasNext()) {
                    d.a.l0.a.l2.a next = it.next();
                    if (next != null && next.f43385g < aVar2.f43385g && next.f43387i != 2) {
                        aVar2 = next;
                    }
                }
                aVar2.f43387i = 2;
            }
            aVar.f43385g = currentTimeMillis;
            aVar.f43386h = currentTimeMillis;
            aVar.f43387i = 0;
            arrayList.add(aVar);
        }
    }

    public final synchronized void e(String str, String str2, ArrayList<d.a.l0.a.l2.a> arrayList) {
        if (!TextUtils.isEmpty(str2) && arrayList != null && !arrayList.isEmpty()) {
            String d2 = c.d(str2);
            if (d2 == null) {
                return;
            }
            ArrayList<d.a.l0.a.l2.a> arrayList2 = this.f43391a.get(d2);
            if (arrayList2 == null) {
                arrayList2 = this.f43392b.k(d2);
                this.f43391a.put(d2, arrayList2);
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                d.a.l0.a.l2.a aVar = arrayList.get(i2);
                if (!p(arrayList2, aVar, str)) {
                    d(arrayList2, aVar);
                }
            }
        }
    }

    public String f(String str, @Nullable String str2) {
        if (f43388f) {
            Log.d("SwanCookieManager", "getCookie url: " + str + "; defaultCookie=" + str2);
        }
        if (d.a.l0.a.a2.d.g().C() && a() && c.a(str)) {
            try {
                return i(new WebAddress(str), str2);
            } catch (Exception unused) {
                if (f43388f) {
                    Log.e("SwanCookieManager", "Bad address: " + str);
                }
                return str2;
            }
        }
        return str2;
    }

    public synchronized void g(d.a.l0.a.l2.a aVar) {
        if (aVar == null) {
            return;
        }
        if (aVar.f43387i == 2) {
            String d2 = c.d(aVar.f43379a);
            if (d2 == null) {
                return;
            }
            ArrayList<d.a.l0.a.l2.a> arrayList = this.f43391a.get(d2);
            if (arrayList != null) {
                arrayList.remove(aVar);
                if (arrayList.isEmpty()) {
                    this.f43391a.remove(d2);
                }
            }
        }
    }

    public void h() {
        SwanAppConfigData F;
        SwanAppConfigData.c cVar;
        if (this.f43394d != null || (F = d.a.l0.a.a2.d.g().r().F()) == null || (cVar = F.q) == null) {
            return;
        }
        this.f43394d = Boolean.valueOf(cVar.f11256a);
        d.h("SwanCookieManager", "enableStore =" + this.f43394d);
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
        ArrayList<d.a.l0.a.l2.a> arrayList = this.f43391a.get(d2);
        if (arrayList == null) {
            arrayList = this.f43392b.k(d2);
            this.f43391a.put(d2, arrayList);
        }
        SortedSet<d.a.l0.a.l2.a> m = m(arrayList, webAddress.getScheme(), e2);
        if (m != null && !m.isEmpty()) {
            String b2 = c.b(m, str);
            if (f43388f) {
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

    public final synchronized SortedSet<d.a.l0.a.l2.a> m(ArrayList<d.a.l0.a.l2.a> arrayList, String str, String[] strArr) {
        if (arrayList != null) {
            if (!arrayList.isEmpty() && strArr != null) {
                long currentTimeMillis = System.currentTimeMillis();
                TreeSet treeSet = new TreeSet(f43390h);
                Iterator<d.a.l0.a.l2.a> it = arrayList.iterator();
                while (it.hasNext()) {
                    d.a.l0.a.l2.a next = it.next();
                    if (next != null && next.a(strArr[0]) && next.c(strArr[1]) && (next.f43383e < 0 || next.f43383e > currentTimeMillis)) {
                        if (!next.f43384f || "https".equals(str)) {
                            if (next.f43387i != 2) {
                                next.f43385g = currentTimeMillis;
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

    public synchronized ArrayList<d.a.l0.a.l2.a> n() {
        ArrayList<d.a.l0.a.l2.a> arrayList;
        arrayList = new ArrayList<>();
        for (ArrayList<d.a.l0.a.l2.a> arrayList2 : this.f43391a.values()) {
            if (arrayList2 != null) {
                Iterator<d.a.l0.a.l2.a> it = arrayList2.iterator();
                while (it.hasNext()) {
                    d.a.l0.a.l2.a next = it.next();
                    if (next != null && next.f43387i != 1) {
                        arrayList.add(next);
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean o() {
        return this.f43395e;
    }

    public final synchronized boolean p(ArrayList<d.a.l0.a.l2.a> arrayList, d.a.l0.a.l2.a aVar, String str) {
        if (arrayList == null || aVar == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<d.a.l0.a.l2.a> it = arrayList.iterator();
        while (it.hasNext()) {
            d.a.l0.a.l2.a next = it.next();
            if (aVar.b(next)) {
                if (aVar.f43383e >= 0 && aVar.f43383e <= currentTimeMillis) {
                    next.f43386h = currentTimeMillis;
                    next.f43387i = 2;
                    return true;
                }
                if (!next.f43384f || "https".equals(str)) {
                    next.f43382d = aVar.f43382d;
                    next.f43383e = aVar.f43383e;
                    next.f43384f = aVar.f43384f;
                    next.f43385g = currentTimeMillis;
                    next.f43386h = currentTimeMillis;
                    next.f43387i = 3;
                }
                return true;
            }
        }
        return false;
    }

    @Inject(force = false)
    public final synchronized C0734b q() {
        return new C0734b();
    }

    public final synchronized void r(boolean z) {
        if (z) {
            this.f43392b.c();
        }
        this.f43392b.e();
        d.h("SwanCookieManager", "onRelease");
    }

    public final ArrayList<d.a.l0.a.l2.a> s(String[] strArr, String str) {
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
            if (f43388f) {
                Log.e("SwanCookieManager", "parse cookie failed: " + str);
                return null;
            }
            return null;
        }
    }

    public void t() {
        if (d.a.l0.a.a2.d.g().C() && a()) {
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
                this.f43392b.g();
            }
        }
    }

    public void w(String str, String str2) {
        if (d.a.l0.a.a2.d.g().C() && a() && c.a(str)) {
            try {
                v(new WebAddress(str), str2);
            } catch (Exception unused) {
                if (f43388f) {
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
        if (f43388f) {
            Log.d("SwanCookieManager", "setCookie: url=" + str + "; values=" + collection);
        }
        for (String str2 : collection) {
            w(str, str2);
        }
    }

    public synchronized void y(d.a.l0.a.l2.a aVar) {
        aVar.f43387i = 1;
    }
}
