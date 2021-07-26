package d.a.o0.a.l2;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.net.WebAddress;
import d.a.o0.a.e0.d;
import d.a.o0.a.k;
import d.a.o0.a.l2.a;
import d.a.o0.a.v2.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
@Autowired
/* loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f46524f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile b f46525g;

    /* renamed from: h  reason: collision with root package name */
    public static final a.C0810a f46526h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, ArrayList<d.a.o0.a.l2.a>> f46527a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.o0.a.l2.e.a f46528b;

    /* renamed from: c  reason: collision with root package name */
    public volatile Boolean f46529c;

    /* renamed from: d  reason: collision with root package name */
    public volatile Boolean f46530d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f46531e;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f46532e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46532e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46532e.f46528b.l();
                this.f46532e.q().a(this.f46532e);
            }
        }
    }

    /* renamed from: d.a.o0.a.l2.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0811b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0811b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a(@NonNull b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(513715563, "Ld/a/o0/a/l2/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(513715563, "Ld/a/o0/a/l2/b;");
                return;
            }
        }
        f46524f = k.f46335a;
        f46526h = new a.C0810a();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f46527a = new LinkedHashMap(32, 0.75f, true);
        d.a.o0.a.c1.a.Z().getSwitch("swan_cookie_enable", false);
        this.f46531e = false;
        this.f46528b = new d.a.o0.a.l2.e.a(this);
    }

    public static synchronized b l() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (b.class) {
                if (f46525g == null) {
                    f46525g = new b();
                }
                bVar = f46525g;
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public static synchronized void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, null, z) == null) {
            synchronized (b.class) {
                if (f46525g != null) {
                    f46525g.r(z);
                }
                f46525g = null;
            }
        }
    }

    public synchronized boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.f46529c != null) {
                    d.h("SwanCookieManager", "acceptCookie =" + this.f46529c);
                    return this.f46529c.booleanValue();
                }
                h();
                boolean z = false;
                if (this.f46530d == null) {
                    return false;
                }
                if (this.f46530d.booleanValue() && this.f46531e) {
                    z = true;
                }
                this.f46529c = Boolean.valueOf(z);
                d.h("SwanCookieManager", "mEnableStore =" + this.f46530d + "; mCookieABSwitch=" + this.f46531e);
                return this.f46529c.booleanValue();
            }
        }
        return invokeV.booleanValue;
    }

    public final synchronized void d(ArrayList<d.a.o0.a.l2.a> arrayList, d.a.o0.a.l2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, aVar) == null) {
            synchronized (this) {
                if (arrayList == null || aVar == null) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (aVar.f46519e < 0 || aVar.f46519e > currentTimeMillis) {
                    if (arrayList.size() >= 50) {
                        d.a.o0.a.l2.a aVar2 = new d.a.o0.a.l2.a();
                        aVar2.f46521g = currentTimeMillis;
                        Iterator<d.a.o0.a.l2.a> it = arrayList.iterator();
                        while (it.hasNext()) {
                            d.a.o0.a.l2.a next = it.next();
                            if (next != null && next.f46521g < aVar2.f46521g && next.f46523i != 2) {
                                aVar2 = next;
                            }
                        }
                        aVar2.f46523i = 2;
                    }
                    aVar.f46521g = currentTimeMillis;
                    aVar.f46522h = currentTimeMillis;
                    aVar.f46523i = 0;
                    arrayList.add(aVar);
                }
            }
        }
    }

    public final synchronized void e(String str, String str2, ArrayList<d.a.o0.a.l2.a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, arrayList) == null) {
            synchronized (this) {
                if (!TextUtils.isEmpty(str2) && arrayList != null && !arrayList.isEmpty()) {
                    String d2 = c.d(str2);
                    if (d2 == null) {
                        return;
                    }
                    ArrayList<d.a.o0.a.l2.a> arrayList2 = this.f46527a.get(d2);
                    if (arrayList2 == null) {
                        arrayList2 = this.f46528b.k(d2);
                        this.f46527a.put(d2, arrayList2);
                    }
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        d.a.o0.a.l2.a aVar = arrayList.get(i2);
                        if (!p(arrayList2, aVar, str)) {
                            d(arrayList2, aVar);
                        }
                    }
                }
            }
        }
    }

    public String f(String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            if (f46524f) {
                Log.d("SwanCookieManager", "getCookie url: " + str + "; defaultCookie=" + str2);
            }
            if (d.a.o0.a.a2.d.g().C() && a() && c.a(str)) {
                try {
                    return i(new WebAddress(str), str2);
                } catch (Exception unused) {
                    if (f46524f) {
                        Log.e("SwanCookieManager", "Bad address: " + str);
                    }
                    return str2;
                }
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public synchronized void g(d.a.o0.a.l2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            synchronized (this) {
                if (aVar == null) {
                    return;
                }
                if (aVar.f46523i == 2) {
                    String d2 = c.d(aVar.f46515a);
                    if (d2 == null) {
                        return;
                    }
                    ArrayList<d.a.o0.a.l2.a> arrayList = this.f46527a.get(d2);
                    if (arrayList != null) {
                        arrayList.remove(aVar);
                        if (arrayList.isEmpty()) {
                            this.f46527a.remove(d2);
                        }
                    }
                }
            }
        }
    }

    public void h() {
        SwanAppConfigData F;
        SwanAppConfigData.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f46530d != null || (F = d.a.o0.a.a2.d.g().r().F()) == null || (cVar = F.q) == null) {
            return;
        }
        this.f46530d = Boolean.valueOf(cVar.f11510a);
        d.h("SwanCookieManager", "enableStore =" + this.f46530d);
    }

    public final synchronized String i(WebAddress webAddress, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, webAddress, str)) == null) {
            synchronized (this) {
                String[] e2 = c.e(webAddress);
                if (e2 == null) {
                    return str;
                }
                String d2 = c.d(e2[0]);
                if (d2 == null) {
                    return str;
                }
                ArrayList<d.a.o0.a.l2.a> arrayList = this.f46527a.get(d2);
                if (arrayList == null) {
                    arrayList = this.f46528b.k(d2);
                    this.f46527a.put(d2, arrayList);
                }
                SortedSet<d.a.o0.a.l2.a> m = m(arrayList, webAddress.getScheme(), e2);
                if (m != null && !m.isEmpty()) {
                    String b2 = c.b(m, str);
                    if (f46524f) {
                        Log.d("SwanCookieManager", "getCookie result:" + b2 + ";defaultCookie=" + str);
                    }
                    return b2;
                }
                return str;
            }
        }
        return (String) invokeLL.objValue;
    }

    public String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? f(str, null) : (String) invokeL.objValue;
    }

    public final long k(Collection<String> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, collection)) == null) {
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
        return invokeL.longValue;
    }

    public final synchronized SortedSet<d.a.o0.a.l2.a> m(ArrayList<d.a.o0.a.l2.a> arrayList, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, arrayList, str, strArr)) == null) {
            synchronized (this) {
                if (arrayList != null) {
                    if (!arrayList.isEmpty() && strArr != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        TreeSet treeSet = new TreeSet(f46526h);
                        Iterator<d.a.o0.a.l2.a> it = arrayList.iterator();
                        while (it.hasNext()) {
                            d.a.o0.a.l2.a next = it.next();
                            if (next != null && next.a(strArr[0]) && next.c(strArr[1]) && (next.f46519e < 0 || next.f46519e > currentTimeMillis)) {
                                if (!next.f46520f || "https".equals(str)) {
                                    if (next.f46523i != 2) {
                                        next.f46521g = currentTimeMillis;
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
        }
        return (SortedSet) invokeLLL.objValue;
    }

    public synchronized ArrayList<d.a.o0.a.l2.a> n() {
        InterceptResult invokeV;
        ArrayList<d.a.o0.a.l2.a> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList<>();
                for (ArrayList<d.a.o0.a.l2.a> arrayList2 : this.f46527a.values()) {
                    if (arrayList2 != null) {
                        Iterator<d.a.o0.a.l2.a> it = arrayList2.iterator();
                        while (it.hasNext()) {
                            d.a.o0.a.l2.a next = it.next();
                            if (next != null && next.f46523i != 1) {
                                arrayList.add(next);
                            }
                        }
                    }
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f46531e : invokeV.booleanValue;
    }

    public final synchronized boolean p(ArrayList<d.a.o0.a.l2.a> arrayList, d.a.o0.a.l2.a aVar, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, arrayList, aVar, str)) == null) {
            synchronized (this) {
                if (arrayList == null || aVar == null) {
                    return false;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Iterator<d.a.o0.a.l2.a> it = arrayList.iterator();
                while (it.hasNext()) {
                    d.a.o0.a.l2.a next = it.next();
                    if (aVar.b(next)) {
                        if (aVar.f46519e >= 0 && aVar.f46519e <= currentTimeMillis) {
                            next.f46522h = currentTimeMillis;
                            next.f46523i = 2;
                            return true;
                        }
                        if (!next.f46520f || "https".equals(str)) {
                            next.f46518d = aVar.f46518d;
                            next.f46519e = aVar.f46519e;
                            next.f46520f = aVar.f46520f;
                            next.f46521g = currentTimeMillis;
                            next.f46522h = currentTimeMillis;
                            next.f46523i = 3;
                        }
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    @Inject(force = false)
    public final synchronized C0811b q() {
        InterceptResult invokeV;
        C0811b c0811b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            synchronized (this) {
                c0811b = new C0811b();
            }
            return c0811b;
        }
        return (C0811b) invokeV.objValue;
    }

    public final synchronized void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            synchronized (this) {
                if (z) {
                    this.f46528b.c();
                }
                this.f46528b.e();
                d.h("SwanCookieManager", "onRelease");
            }
        }
    }

    public final ArrayList<d.a.o0.a.l2.a> s(String[] strArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, strArr, str)) == null) {
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
                if (f46524f) {
                    Log.e("SwanCookieManager", "parse cookie failed: " + str);
                    return null;
                }
                return null;
            }
        }
        return (ArrayList) invokeLL.objValue;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && d.a.o0.a.a2.d.g().C() && a()) {
            q.j(new a(this), "preInitCookieDb");
        }
    }

    public final synchronized void v(WebAddress webAddress, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, webAddress, str) == null) {
            synchronized (this) {
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
                        this.f46528b.g();
                    }
                }
            }
        }
    }

    public void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, str, str2) == null) && d.a.o0.a.a2.d.g().C() && a() && c.a(str)) {
            try {
                v(new WebAddress(str), str2);
            } catch (Exception unused) {
                if (f46524f) {
                    Log.e("SwanCookieManager", "setCookie with bad address: " + str);
                }
            }
        }
    }

    public void x(String str, Collection<String> collection) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, str, collection) == null) || TextUtils.isEmpty(str) || collection == null || collection.isEmpty()) {
            return;
        }
        if (k(collection) > 4096) {
            d.l("SwanCookieManager", "setCookie values is too large");
            return;
        }
        if (f46524f) {
            Log.d("SwanCookieManager", "setCookie: url=" + str + "; values=" + collection);
        }
        for (String str2 : collection) {
            w(str, str2);
        }
    }

    public synchronized void y(d.a.o0.a.l2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) {
            synchronized (this) {
                aVar.f46523i = 1;
            }
        }
    }
}
