package com.repackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
/* loaded from: classes6.dex */
public class d49 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d49 s;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public int l;
    public int m;
    public boolean n;
    public long o;
    public boolean p;
    public c49 q;
    public e59 r;

    public d49() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = 614400;
        this.f = 153600;
        this.g = 614400;
        this.h = 614400;
        this.i = 100;
        this.j = 180;
        this.k = false;
        this.l = 819200;
        this.m = 60;
        this.n = false;
        this.o = 0L;
        this.p = false;
        this.q = new c49();
        this.r = new e59();
    }

    public static d49 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (s == null) {
                synchronized (b49.class) {
                    if (s == null) {
                        s = new d49();
                    }
                }
            }
            return s;
        }
        return (d49) invokeV.objValue;
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.i : invokeV.intValue;
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.j : invokeV.intValue;
    }

    public int C(String str) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!this.q.n.containsKey(str) || (num = this.q.n.get(str)) == null) {
                return -1;
            }
            return num.intValue();
        }
        return invokeL.intValue;
    }

    public void D(z39 z39Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, z39Var, context) == null) {
            this.a = context;
            this.b = 60000;
            h59 a = h59.a();
            this.c = a.b("ubc_data_expire_time", 604800000);
            this.d = a.b("ubc_database_limit", 10000);
            z39Var.n().y(this.q);
            this.e = a.b("ubc_launch_upload_max_limit", 614400);
            this.f = a.b("ubc_single_log_max_limit", 153600);
            this.g = a.b("ubc_real_upload_max_limit", 614400);
            this.h = a.b("ubc_non_real_upload_max_limit", 614400);
            this.i = a.b("ubc_upload_trigger_num", 100);
            this.j = a.b("ubc_upload_trigger_time", 180);
            this.k = y49.i().q();
            this.l = y49.i().g();
            this.m = y49.i().b();
            this.n = y49.i().i();
            this.p = y49.i().l();
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            n49 i = y49.i();
            if (i != null) {
                return i.n();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            HashMap<String, i49> hashMap = this.q.j;
            if (hashMap == null || !hashMap.containsKey(str)) {
                return false;
            }
            return this.q.j.get(str).a();
        }
        return invokeL.booleanValue;
    }

    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.q.a.b : invokeV.booleanValue;
    }

    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.q.a.d : invokeV.booleanValue;
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public boolean J(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            HashMap<String, i49> hashMap = this.q.j;
            if (hashMap == null || !hashMap.containsKey(str)) {
                return false;
            }
            return this.q.j.get(str).b();
        }
        return invokeL.booleanValue;
    }

    public boolean K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            Context context = this.a;
            return context == null || L(context) || !c(str);
        }
        return invokeL.booleanValue;
    }

    public boolean L(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, context)) == null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
        }
        return invokeL.booleanValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public boolean O(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) ? this.q.c.contains(str) : invokeL.booleanValue;
    }

    public void P(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i) == null) || i < 604800000) {
            return;
        }
        this.c = i;
        h59.a().d("ubc_data_expire_time", i);
    }

    public void Q(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i) == null) || i < 10000) {
            return;
        }
        this.d = i;
        h59.a().d("ubc_database_limit", i);
    }

    public void R(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i) == null) || i < 153600) {
            return;
        }
        this.e = i;
        h59.a().d("ubc_launch_upload_max_limit", i);
    }

    public void S(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048594, this, i) == null) || i < 153600) {
            return;
        }
        this.h = i;
        h59.a().d("ubc_non_real_upload_max_limit", i);
    }

    public void T(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048595, this, i) == null) || i < 153600) {
            return;
        }
        this.g = i;
        h59.a().d("ubc_real_upload_max_limit", i);
    }

    public void U(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048596, this, i) == null) || i < 30720) {
            return;
        }
        this.f = i;
        h59.a().d("ubc_single_log_max_limit", i);
    }

    public void V(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i) == null) || i < 1) {
            return;
        }
        this.b = i * 60000;
    }

    public void W(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048598, this, i) == null) || i <= 0) {
            return;
        }
        this.i = i;
        h59.a().d("ubc_upload_trigger_num", i);
    }

    public void X(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048599, this, i) == null) || i <= 0) {
            return;
        }
        this.j = i;
        h59.a().d("ubc_upload_trigger_time", i);
    }

    public void Y(List<g49> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, list) == null) {
            for (g49 g49Var : list) {
                String c = g49Var.c();
                if (!TextUtils.isEmpty(c)) {
                    if (!g49Var.s()) {
                        this.q.b.add(c);
                        this.q.f.remove(c);
                    } else {
                        this.q.b.remove(c);
                        this.q.f.add(c);
                    }
                    if (g49Var.o()) {
                        this.q.c.add(c);
                        this.q.d.remove(c);
                    } else {
                        this.q.c.remove(c);
                        this.q.d.add(c);
                    }
                    if (g49Var.k()) {
                        this.q.e.add(c);
                    } else {
                        this.q.e.remove(c);
                    }
                    if (g49Var.n()) {
                        this.q.g.add(c);
                    } else {
                        this.q.g.remove(c);
                    }
                    int g = g49Var.g();
                    if (g >= 1 && g <= 100) {
                        this.q.h.put(c, Integer.valueOf(g));
                    } else {
                        this.q.h.remove(c);
                    }
                    String a = g49Var.a();
                    if (!TextUtils.isEmpty(a)) {
                        this.q.i.put(c, a);
                    } else {
                        this.q.i.remove(c);
                    }
                    int d = g49Var.d();
                    int e = g49Var.e();
                    if (d != 0 && e != 0) {
                        this.q.j.put(c, new i49(c, e, d));
                    }
                    if (g49Var.m()) {
                        this.q.k.add(c);
                    } else {
                        this.q.k.remove(c);
                    }
                    if (g49Var.p()) {
                        this.q.l.add(c);
                    } else {
                        this.q.l.remove(c);
                    }
                    int b = g49Var.b();
                    if (g49Var.r()) {
                        this.q.m.put(c, Integer.valueOf(b));
                    } else {
                        this.q.m.remove(c);
                    }
                    if (g49Var.t()) {
                        this.q.n.remove(c);
                    } else {
                        this.q.n.put(c, Integer.valueOf(g49Var.i()));
                    }
                    int f = g49Var.f();
                    if (f != 2) {
                        this.q.o.put(c, Integer.valueOf(f));
                    } else {
                        this.q.o.remove(c);
                    }
                }
            }
        }
    }

    public void Z(long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048601, this, j) == null) || this.o >= j) {
            return;
        }
        this.o = j;
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) ? this.q.e.contains(str) : invokeL.booleanValue;
    }

    public int b(String str) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            if (!this.q.o.containsKey(str) || (num = this.q.o.get(str)) == null) {
                return 2;
            }
            return num.intValue();
        }
        return invokeL.intValue;
    }

    public boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) ? this.q.g.contains(str) : invokeL.booleanValue;
    }

    public boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) ? C(str) == 0 : invokeL.booleanValue;
    }

    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, str)) == null) {
            if (this.r.isUBCDebug() || this.q.c.contains(str)) {
                return true;
            }
            return this.q.a.b;
        }
        return invokeL.booleanValue;
    }

    public boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) ? this.q.l.contains(str) : invokeL.booleanValue;
    }

    public boolean g(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048608, this, str, i)) == null) {
            if (this.q.b.contains(str)) {
                return false;
            }
            if ((i & 16) != 0 || (i & 32) != 0) {
                return this.q.f.contains(str);
            } else if (this.q.f.contains(str)) {
                return true;
            } else {
                return this.q.a.a;
            }
        }
        return invokeLI.booleanValue;
    }

    public boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) {
            if (!E() && this.r.isUBCSample() && y(str) > 0) {
                if (new Random().nextInt(100) >= y(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
            if (this.q.b.contains(str)) {
                return false;
            }
            if (this.q.f.contains(str)) {
                return true;
            }
            return this.q.a.d;
        }
        return invokeL.booleanValue;
    }

    public String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) ? this.q.i.containsKey(str) ? this.q.i.get(str) : "" : (String) invokeL.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.c : invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.d : invokeV.intValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.q.a.c : invokeV.intValue;
    }

    public int n(String str) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, str)) == null) {
            if (!this.q.m.containsKey(str) || (num = this.q.m.get(str)) == null) {
                return 0;
            }
            return num.intValue();
        }
        return invokeL.intValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.e : invokeV.intValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.h : invokeV.intValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.g : invokeV.intValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.f : invokeV.intValue;
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.b : invokeV.intValue;
    }

    public HashSet<String> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.q.d : (HashSet) invokeV.objValue;
    }

    public long v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.o : invokeV.longValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.m : invokeV.intValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.l : invokeV.intValue;
    }

    public int y(String str) {
        InterceptResult invokeL;
        Integer num;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, str)) == null) {
            if (TextUtils.isEmpty(str) || !this.q.h.containsKey(str) || (num = this.q.h.get(str)) == null) {
                return 0;
            }
            return num.intValue();
        }
        return invokeL.intValue;
    }

    public String z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, str)) == null) ? !TextUtils.isEmpty(str) ? (this.q.k.contains(str) || TextUtils.equals(str, "1876") || TextUtils.equals(str, "2980")) ? "1" : "0" : "0" : (String) invokeL.objValue;
    }
}
