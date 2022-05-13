package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.repackage.p93;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
@Autowired
/* loaded from: classes6.dex */
public final class q93 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public static volatile q93 g;
    public static final p93.a h;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, ArrayList<p93>> a;
    public final u93 b;
    public volatile Boolean c;
    public volatile Boolean d;
    public final boolean e;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q93 a;

        public a(q93 q93Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {q93Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q93Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b.l();
                this.a.q().a(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a(@NonNull q93 q93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, q93Var) == null) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755425338, "Lcom/repackage/q93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755425338, "Lcom/repackage/q93;");
                return;
            }
        }
        f = eh1.a;
        h = new p93.a();
    }

    public q93() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new LinkedHashMap(32, 0.75f, true);
        bk2.g0().getSwitch("swan_cookie_enable", false);
        this.e = false;
        this.b = new u93(this);
    }

    public static synchronized q93 l() {
        InterceptResult invokeV;
        q93 q93Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            synchronized (q93.class) {
                if (g == null) {
                    g = new q93();
                }
                q93Var = g;
            }
            return q93Var;
        }
        return (q93) invokeV.objValue;
    }

    public static synchronized void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, null, z) == null) {
            synchronized (q93.class) {
                if (g != null) {
                    g.r(z);
                }
                g = null;
            }
        }
    }

    public synchronized boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.c != null) {
                    ux1.k("SwanCookieManager", "acceptCookie =" + this.c);
                    return this.c.booleanValue();
                }
                h();
                boolean z = false;
                if (this.d == null) {
                    return false;
                }
                if (this.d.booleanValue() && this.e) {
                    z = true;
                }
                this.c = Boolean.valueOf(z);
                ux1.k("SwanCookieManager", "mEnableStore =" + this.d + "; mCookieABSwitch=" + this.e);
                return this.c.booleanValue();
            }
        }
        return invokeV.booleanValue;
    }

    public final synchronized void d(ArrayList<p93> arrayList, p93 p93Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, p93Var) == null) {
            synchronized (this) {
                if (arrayList == null || p93Var == null) {
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (p93Var.e < 0 || p93Var.e > currentTimeMillis) {
                    if (arrayList.size() >= 50) {
                        p93 p93Var2 = new p93();
                        p93Var2.g = currentTimeMillis;
                        Iterator<p93> it = arrayList.iterator();
                        while (it.hasNext()) {
                            p93 next = it.next();
                            if (next != null && next.g < p93Var2.g && next.i != 2) {
                                p93Var2 = next;
                            }
                        }
                        p93Var2.i = 2;
                    }
                    p93Var.g = currentTimeMillis;
                    p93Var.h = currentTimeMillis;
                    p93Var.i = 0;
                    arrayList.add(p93Var);
                }
            }
        }
    }

    public final synchronized void e(String str, String str2, ArrayList<p93> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, arrayList) == null) {
            synchronized (this) {
                if (!TextUtils.isEmpty(str2) && arrayList != null && !arrayList.isEmpty()) {
                    String d = r93.d(str2);
                    if (d == null) {
                        return;
                    }
                    ArrayList<p93> arrayList2 = this.a.get(d);
                    if (arrayList2 == null) {
                        arrayList2 = this.b.k(d);
                        this.a.put(d, arrayList2);
                    }
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        p93 p93Var = arrayList.get(i);
                        if (!p(arrayList2, p93Var, str)) {
                            d(arrayList2, p93Var);
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
            if (f) {
                Log.d("SwanCookieManager", "getCookie url: " + str + "; defaultCookie=" + str2);
            }
            if (t03.J().D() && a() && r93.a(str)) {
                try {
                    return i(new WebAddress(str), str2);
                } catch (Exception unused) {
                    if (f) {
                        Log.e("SwanCookieManager", "Bad address: " + str);
                    }
                    return str2;
                }
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public synchronized void g(p93 p93Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, p93Var) == null) {
            synchronized (this) {
                if (p93Var == null) {
                    return;
                }
                if (p93Var.i == 2) {
                    String d = r93.d(p93Var.a);
                    if (d == null) {
                        return;
                    }
                    ArrayList<p93> arrayList = this.a.get(d);
                    if (arrayList != null) {
                        arrayList.remove(p93Var);
                        if (arrayList.isEmpty()) {
                            this.a.remove(d);
                        }
                    }
                }
            }
        }
    }

    public void h() {
        SwanAppConfigData P;
        SwanAppConfigData.c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || this.d != null || (P = t03.J().r().P()) == null || (cVar = P.r) == null) {
            return;
        }
        this.d = Boolean.valueOf(cVar.a);
        ux1.k("SwanCookieManager", "enableStore =" + this.d);
    }

    public final synchronized String i(WebAddress webAddress, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, webAddress, str)) == null) {
            synchronized (this) {
                String[] e = r93.e(webAddress);
                if (e == null) {
                    return str;
                }
                String d = r93.d(e[0]);
                if (d == null) {
                    return str;
                }
                ArrayList<p93> arrayList = this.a.get(d);
                if (arrayList == null) {
                    arrayList = this.b.k(d);
                    this.a.put(d, arrayList);
                }
                SortedSet<p93> m = m(arrayList, webAddress.getScheme(), e);
                if (m != null && !m.isEmpty()) {
                    String b2 = r93.b(m, str);
                    if (f) {
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

    public final synchronized SortedSet<p93> m(ArrayList<p93> arrayList, String str, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, arrayList, str, strArr)) == null) {
            synchronized (this) {
                if (arrayList != null) {
                    if (!arrayList.isEmpty() && strArr != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        TreeSet treeSet = new TreeSet(h);
                        Iterator<p93> it = arrayList.iterator();
                        while (it.hasNext()) {
                            p93 next = it.next();
                            if (next != null && next.a(strArr[0]) && next.c(strArr[1]) && (next.e < 0 || next.e > currentTimeMillis)) {
                                if (!next.f || "https".equals(str)) {
                                    if (next.i != 2) {
                                        next.g = currentTimeMillis;
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

    public synchronized ArrayList<p93> n() {
        InterceptResult invokeV;
        ArrayList<p93> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                arrayList = new ArrayList<>();
                for (ArrayList<p93> arrayList2 : this.a.values()) {
                    if (arrayList2 != null) {
                        Iterator<p93> it = arrayList2.iterator();
                        while (it.hasNext()) {
                            p93 next = it.next();
                            if (next != null && next.i != 1) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.e : invokeV.booleanValue;
    }

    public final synchronized boolean p(ArrayList<p93> arrayList, p93 p93Var, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, arrayList, p93Var, str)) == null) {
            synchronized (this) {
                if (arrayList == null || p93Var == null) {
                    return false;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Iterator<p93> it = arrayList.iterator();
                while (it.hasNext()) {
                    p93 next = it.next();
                    if (p93Var.b(next)) {
                        if (p93Var.e >= 0 && p93Var.e <= currentTimeMillis) {
                            next.h = currentTimeMillis;
                            next.i = 2;
                            return true;
                        }
                        if (!next.f || "https".equals(str)) {
                            next.d = p93Var.d;
                            next.e = p93Var.e;
                            next.f = p93Var.f;
                            next.g = currentTimeMillis;
                            next.h = currentTimeMillis;
                            next.i = 3;
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
    public final synchronized b q() {
        InterceptResult invokeV;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            synchronized (this) {
                bVar = new b();
            }
            return bVar;
        }
        return (b) invokeV.objValue;
    }

    public final synchronized void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            synchronized (this) {
                if (z) {
                    this.b.c();
                }
                this.b.e();
                ux1.k("SwanCookieManager", "onRelease");
            }
        }
    }

    public final ArrayList<p93> s(String[] strArr, String str) {
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
                return r93.g(strArr[0], strArr[1], str);
            } catch (Exception unused) {
                if (f) {
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
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && t03.J().D() && a()) {
            od3.k(new a(this), "preInitCookieDb");
        }
    }

    public final synchronized void v(WebAddress webAddress, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, webAddress, str) == null) {
            synchronized (this) {
                if (webAddress != null) {
                    if (!TextUtils.isEmpty(str)) {
                        if (str.length() > 4096) {
                            ux1.o("SwanCookieManager", "setCookie value is too large");
                            return;
                        }
                        String[] e = r93.e(webAddress);
                        if (e == null) {
                            return;
                        }
                        e(webAddress.getScheme(), e[0], s(e, str));
                        this.b.g();
                    }
                }
            }
        }
    }

    public void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, str, str2) == null) && t03.J().D() && a() && r93.a(str)) {
            try {
                v(new WebAddress(str), str2);
            } catch (Exception unused) {
                if (f) {
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
            ux1.o("SwanCookieManager", "setCookie values is too large");
            return;
        }
        if (f) {
            Log.d("SwanCookieManager", "setCookie: url=" + str + "; values=" + collection);
        }
        for (String str2 : collection) {
            w(str, str2);
        }
    }

    public synchronized void y(p93 p93Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, p93Var) == null) {
            synchronized (this) {
                p93Var.i = 1;
            }
        }
    }
}
