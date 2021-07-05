package d.a.q0.a.l2;

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
import d.a.q0.a.e0.d;
import d.a.q0.a.k;
import d.a.q0.a.l2.a;
import d.a.q0.a.v2.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
@Autowired
/* loaded from: classes8.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f49322f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile b f49323g;

    /* renamed from: h  reason: collision with root package name */
    public static final a.C0852a f49324h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, ArrayList<d.a.q0.a.l2.a>> f49325a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.q0.a.l2.e.a f49326b;

    /* renamed from: c  reason: collision with root package name */
    public volatile Boolean f49327c;

    /* renamed from: d  reason: collision with root package name */
    public volatile Boolean f49328d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f49329e;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f49330e;

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
            this.f49330e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49330e.f49326b.l();
                this.f49330e.q().a(this.f49330e);
            }
        }
    }

    /* renamed from: d.a.q0.a.l2.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0853b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0853b() {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(120688553, "Ld/a/q0/a/l2/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(120688553, "Ld/a/q0/a/l2/b;");
                return;
            }
        }
        f49322f = k.f49133a;
        f49324h = new a.C0852a();
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
        this.f49325a = new LinkedHashMap(32, 0.75f, true);
        d.a.q0.a.c1.a.Z().getSwitch("swan_cookie_enable", false);
        this.f49329e = false;
        this.f49326b = new d.a.q0.a.l2.e.a(this);
    }

    public static synchronized b l() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
            synchronized (b.class) {
                if (f49323g == null) {
                    f49323g = new b();
                }
                bVar = f49323g;
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public static synchronized void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.AD_TEXT_ID, null, z) == null) {
            synchronized (b.class) {
                if (f49323g != null) {
                    f49323g.r(z);
                }
                f49323g = null;
            }
        }
    }

    public synchronized boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.f49327c != null) {
                    d.h("SwanCookieManager", "acceptCookie =" + this.f49327c);
                    return this.f49327c.booleanValue();
                }
                h();
                boolean z = false;
                if (this.f49328d == null) {
                    return false;
                }
                if (this.f49328d.booleanValue() && this.f49329e) {
                    z = true;
                }
                this.f49327c = Boolean.valueOf(z);
                d.h("SwanCookieManager", "mEnableStore =" + this.f49328d + "; mCookieABSwitch=" + this.f49329e);
                return this.f49327c.booleanValue();
            }
        }
        return invokeV.booleanValue;
    }

    public final synchronized void d(ArrayList<d.a.q0.a.l2.a> arrayList, d.a.q0.a.l2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, aVar) == null) {
            synchronized (this) {
                if (arrayList == null || aVar == null) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (aVar.f49317e < 0 || aVar.f49317e > currentTimeMillis) {
                    if (arrayList.size() >= 50) {
                        d.a.q0.a.l2.a aVar2 = new d.a.q0.a.l2.a();
                        aVar2.f49319g = currentTimeMillis;
                        Iterator<d.a.q0.a.l2.a> it = arrayList.iterator();
                        while (it.hasNext()) {
                            d.a.q0.a.l2.a next = it.next();
                            if (next != null && next.f49319g < aVar2.f49319g && next.f49321i != 2) {
                                aVar2 = next;
                            }
                        }
                        aVar2.f49321i = 2;
                    }
                    aVar.f49319g = currentTimeMillis;
                    aVar.f49320h = currentTimeMillis;
                    aVar.f49321i = 0;
                    arrayList.add(aVar);
                }
            }
        }
    }

    public final synchronized void e(String str, String str2, ArrayList<d.a.q0.a.l2.a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, arrayList) == null) {
            synchronized (this) {
                if (!TextUtils.isEmpty(str2) && arrayList != null && !arrayList.isEmpty()) {
                    String d2 = c.d(str2);
                    if (d2 == null) {
                        return;
                    }
                    ArrayList<d.a.q0.a.l2.a> arrayList2 = this.f49325a.get(d2);
                    if (arrayList2 == null) {
                        arrayList2 = this.f49326b.k(d2);
                        this.f49325a.put(d2, arrayList2);
                    }
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        d.a.q0.a.l2.a aVar = arrayList.get(i2);
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
            if (f49322f) {
                Log.d("SwanCookieManager", "getCookie url: " + str + "; defaultCookie=" + str2);
            }
            if (d.a.q0.a.a2.d.g().C() && a() && c.a(str)) {
                try {
                    return i(new WebAddress(str), str2);
                } catch (Exception unused) {
                    if (f49322f) {
                        Log.e("SwanCookieManager", "Bad address: " + str);
                    }
                    return str2;
                }
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public synchronized void g(d.a.q0.a.l2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            synchronized (this) {
                if (aVar == null) {
                    return;
                }
                if (aVar.f49321i == 2) {
                    String d2 = c.d(aVar.f49313a);
                    if (d2 == null) {
                        return;
                    }
                    ArrayList<d.a.q0.a.l2.a> arrayList = this.f49325a.get(d2);
                    if (arrayList != null) {
                        arrayList.remove(aVar);
                        if (arrayList.isEmpty()) {
                            this.f49325a.remove(d2);
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
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.f49328d != null || (F = d.a.q0.a.a2.d.g().r().F()) == null || (cVar = F.q) == null) {
            return;
        }
        this.f49328d = Boolean.valueOf(cVar.f11467a);
        d.h("SwanCookieManager", "enableStore =" + this.f49328d);
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
                ArrayList<d.a.q0.a.l2.a> arrayList = this.f49325a.get(d2);
                if (arrayList == null) {
                    arrayList = this.f49326b.k(d2);
                    this.f49325a.put(d2, arrayList);
                }
                SortedSet<d.a.q0.a.l2.a> m = m(arrayList, webAddress.getScheme(), e2);
                if (m != null && !m.isEmpty()) {
                    String b2 = c.b(m, str);
                    if (f49322f) {
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

    public final synchronized SortedSet<d.a.q0.a.l2.a> m(ArrayList<d.a.q0.a.l2.a> arrayList, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, arrayList, str, strArr)) == null) {
            synchronized (this) {
                if (arrayList != null) {
                    if (!arrayList.isEmpty() && strArr != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        TreeSet treeSet = new TreeSet(f49324h);
                        Iterator<d.a.q0.a.l2.a> it = arrayList.iterator();
                        while (it.hasNext()) {
                            d.a.q0.a.l2.a next = it.next();
                            if (next != null && next.a(strArr[0]) && next.c(strArr[1]) && (next.f49317e < 0 || next.f49317e > currentTimeMillis)) {
                                if (!next.f49318f || "https".equals(str)) {
                                    if (next.f49321i != 2) {
                                        next.f49319g = currentTimeMillis;
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

    public synchronized ArrayList<d.a.q0.a.l2.a> n() {
        InterceptResult invokeV;
        ArrayList<d.a.q0.a.l2.a> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList<>();
                for (ArrayList<d.a.q0.a.l2.a> arrayList2 : this.f49325a.values()) {
                    if (arrayList2 != null) {
                        Iterator<d.a.q0.a.l2.a> it = arrayList2.iterator();
                        while (it.hasNext()) {
                            d.a.q0.a.l2.a next = it.next();
                            if (next != null && next.f49321i != 1) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f49329e : invokeV.booleanValue;
    }

    public final synchronized boolean p(ArrayList<d.a.q0.a.l2.a> arrayList, d.a.q0.a.l2.a aVar, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, arrayList, aVar, str)) == null) {
            synchronized (this) {
                if (arrayList == null || aVar == null) {
                    return false;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Iterator<d.a.q0.a.l2.a> it = arrayList.iterator();
                while (it.hasNext()) {
                    d.a.q0.a.l2.a next = it.next();
                    if (aVar.b(next)) {
                        if (aVar.f49317e >= 0 && aVar.f49317e <= currentTimeMillis) {
                            next.f49320h = currentTimeMillis;
                            next.f49321i = 2;
                            return true;
                        }
                        if (!next.f49318f || "https".equals(str)) {
                            next.f49316d = aVar.f49316d;
                            next.f49317e = aVar.f49317e;
                            next.f49318f = aVar.f49318f;
                            next.f49319g = currentTimeMillis;
                            next.f49320h = currentTimeMillis;
                            next.f49321i = 3;
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
    public final synchronized C0853b q() {
        InterceptResult invokeV;
        C0853b c0853b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            synchronized (this) {
                c0853b = new C0853b();
            }
            return c0853b;
        }
        return (C0853b) invokeV.objValue;
    }

    public final synchronized void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            synchronized (this) {
                if (z) {
                    this.f49326b.c();
                }
                this.f49326b.e();
                d.h("SwanCookieManager", "onRelease");
            }
        }
    }

    public final ArrayList<d.a.q0.a.l2.a> s(String[] strArr, String str) {
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
                if (f49322f) {
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
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && d.a.q0.a.a2.d.g().C() && a()) {
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
                        this.f49326b.g();
                    }
                }
            }
        }
    }

    public void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, str, str2) == null) && d.a.q0.a.a2.d.g().C() && a() && c.a(str)) {
            try {
                v(new WebAddress(str), str2);
            } catch (Exception unused) {
                if (f49322f) {
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
        if (f49322f) {
            Log.d("SwanCookieManager", "setCookie: url=" + str + "; values=" + collection);
        }
        for (String str2 : collection) {
            w(str, str2);
        }
    }

    public synchronized void y(d.a.q0.a.l2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) {
            synchronized (this) {
                aVar.f49321i = 1;
            }
        }
    }
}
