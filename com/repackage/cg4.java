package com.repackage;

import android.content.Context;
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
/* loaded from: classes6.dex */
public class cg4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cg4 m;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public final HashSet<String> b;
    public final HashSet<String> c;
    public final HashSet<String> d;
    public final HashSet<String> e;
    public final HashMap<String, String> f;
    public final HashMap<String, String> g;
    public final HashMap<String, gg4> h;
    public final HashSet<String> i;
    public int j;
    public int k;
    public int l;

    public cg4() {
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
        this.b = new HashSet<>();
        this.c = new HashSet<>();
        this.d = new HashSet<>();
        this.e = new HashSet<>();
        this.f = new HashMap<>();
        this.g = new HashMap<>();
        this.h = new HashMap<>();
        this.i = new HashSet<>();
    }

    public static cg4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (m == null) {
                synchronized (cg4.class) {
                    if (m == null) {
                        m = new cg4();
                    }
                }
            }
            return m;
        }
        return (cg4) invokeV.objValue;
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.d.contains(str) : invokeL.booleanValue;
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (dg4.g().r()) {
                return true;
            }
            return this.c.contains(str);
        }
        return invokeL.booleanValue;
    }

    public boolean c(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i)) == null) {
            if (this.b.contains(str)) {
                return false;
            }
            if ((i & 16) == 0 && (i & 32) == 0) {
                return true;
            }
            return this.e.contains(str);
        }
        return invokeLI.booleanValue;
    }

    public String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.g.containsKey(str) ? this.g.get(str) : "" : (String) invokeL.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : invokeV.intValue;
    }

    public int i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (dg4.g().q() || TextUtils.isEmpty(str) || !this.f.containsKey(str)) {
                return 0;
            }
            return Integer.parseInt(this.f.get(str));
        }
        return invokeL.intValue;
    }

    public String j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? (TextUtils.isEmpty(str) || !this.i.contains(str)) ? "0" : "1" : (String) invokeL.objValue;
    }

    public void k(bg4 bg4Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bg4Var, context) == null) {
            this.a = context;
            this.j = 360000;
            sg4 f = sg4.f();
            this.k = f.getInt("ubc_data_expire_time", 259200000);
            this.l = f.getInt("ubc_database_limit", 4000);
            bg4Var.e().w(this.b, this.e, this.c, this.d, this.f, this.g, this.h, this.i);
        }
    }

    public boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            gg4 gg4Var = this.h.get(str);
            return gg4Var != null && gg4Var.b();
        }
        return invokeL.booleanValue;
    }

    public boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            gg4 gg4Var = this.h.get(str);
            return gg4Var != null && gg4Var.c();
        }
        return invokeL.booleanValue;
    }

    public void n(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || i < this.k) {
            return;
        }
        this.k = i;
        sg4.f().putInt("ubc_data_expire_time", i);
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i) == null) || i < this.l) {
            return;
        }
        this.l = i;
        sg4.f().putInt("ubc_database_limit", i);
    }

    public void p(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i) == null) || (i2 = i * 60000) < this.j) {
            return;
        }
        this.j = i2;
    }

    public void q(List<fg4> list) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            for (fg4 fg4Var : list) {
                if ("0".equals(fg4Var.b)) {
                    this.b.add(fg4Var.a);
                } else {
                    this.b.remove(fg4Var.a);
                }
                if ("1".equals(fg4Var.c)) {
                    this.c.add(fg4Var.a);
                } else {
                    this.c.remove(fg4Var.a);
                }
                if ("1".equals(fg4Var.f)) {
                    this.d.add(fg4Var.a);
                } else {
                    this.d.remove(fg4Var.a);
                }
                int i2 = fg4Var.g;
                if (i2 >= 1 && i2 <= 100) {
                    this.f.put(fg4Var.a, String.valueOf(i2));
                } else {
                    this.f.remove(fg4Var.a);
                }
                if (!TextUtils.isEmpty(fg4Var.h)) {
                    this.g.put(fg4Var.a, fg4Var.h);
                } else {
                    this.g.remove(fg4Var.a);
                }
                int i3 = fg4Var.j;
                if (i3 != 0 && (i = fg4Var.i) != 0) {
                    gg4 gg4Var = new gg4(fg4Var.a, i3, i);
                    this.h.put(gg4Var.a(), gg4Var);
                }
                if (TextUtils.equals(fg4Var.k, "1")) {
                    this.i.add(fg4Var.a);
                } else {
                    this.i.remove(fg4Var.a);
                }
            }
        }
    }
}
