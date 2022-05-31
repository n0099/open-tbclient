package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class yt2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yt2 d;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, zt2> a;
    public HashMap<String, zt2> b;
    public HashMap<String, zt2> c;

    public yt2() {
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
        c();
    }

    public static yt2 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (d == null) {
                synchronized (yt2.class) {
                    if (d == null) {
                        d = new yt2();
                    }
                }
            }
            return d;
        }
        return (yt2) invokeV.objValue;
    }

    public static synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (yt2.class) {
                if (d != null) {
                    d.e();
                    d = null;
                }
            }
        }
    }

    public final void a(String str, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048576, this, str, j) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != 767526192) {
            if (hashCode != 1331686101) {
                if (hashCode == 1390184462 && str.equals("PageUpdateRender")) {
                    c = 2;
                }
            } else if (str.equals("PageInitRender")) {
                c = 1;
            }
        } else if (str.equals("PageSwitchCost")) {
            c = 0;
        }
        if (c == 0) {
            db3.d.update((cb3<Long>) Long.valueOf(j));
        } else if (c == 1) {
            db3.e.update((cb3<Long>) Long.valueOf(j));
        } else if (c != 2) {
        } else {
            db3.f.update((cb3<Long>) Long.valueOf(j));
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.a == null) {
                this.a = new HashMap<>();
            }
            if (this.b == null) {
                this.b = new HashMap<>();
            }
            if (this.c == null) {
                this.c = new HashMap<>();
            }
        }
    }

    public void d(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Long.valueOf(j)}) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || j < 0) {
            return;
        }
        c();
        char c = 65535;
        switch (str2.hashCode()) {
            case -1880922749:
                if (str2.equals("pageUpdateEnd")) {
                    c = 5;
                    break;
                }
                break;
            case -964566145:
                if (str2.equals("pageSwitchStart")) {
                    c = 0;
                    break;
                }
                break;
            case -410083667:
                if (str2.equals("pageInitRenderStart")) {
                    c = 1;
                    break;
                }
                break;
            case 4028902:
                if (str2.equals("pageInitRenderEnd")) {
                    c = 4;
                    break;
                }
                break;
            case 627578634:
                if (str2.equals("pageUpdateStart")) {
                    c = 2;
                    break;
                }
                break;
            case 1719651128:
                if (str2.equals("pageSwitchEnd")) {
                    c = 3;
                    break;
                }
                break;
        }
        if (c == 0 || c == 1 || c == 2) {
            h(str, str2, j);
        } else if (c == 3 || c == 4 || c == 5) {
            g(str, str2, j);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            HashMap<String, zt2> hashMap = this.a;
            if (hashMap != null) {
                hashMap.clear();
            }
            HashMap<String, zt2> hashMap2 = this.b;
            if (hashMap2 != null) {
                hashMap2.clear();
            }
            HashMap<String, zt2> hashMap3 = this.c;
            if (hashMap3 != null) {
                hashMap3.clear();
            }
        }
    }

    public final void g(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Long.valueOf(j)}) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        zt2 zt2Var = null;
        char c = 65535;
        int hashCode = str2.hashCode();
        if (hashCode != -1880922749) {
            if (hashCode != 4028902) {
                if (hashCode == 1719651128 && str2.equals("pageSwitchEnd")) {
                    c = 0;
                }
            } else if (str2.equals("pageInitRenderEnd")) {
                c = 1;
            }
        } else if (str2.equals("pageUpdateEnd")) {
            c = 2;
        }
        if (c == 0) {
            zt2Var = this.a.remove(str);
        } else if (c == 1) {
            zt2Var = this.b.remove(str);
        } else if (c == 2) {
            zt2Var = this.c.remove(str);
        }
        if (zt2Var == null) {
            return;
        }
        zt2Var.b(j);
        a(zt2Var.getType(), zt2Var.a());
    }

    public final void h(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, Long.valueOf(j)}) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        zt2 zt2Var = null;
        char c = 65535;
        int hashCode = str2.hashCode();
        if (hashCode != -964566145) {
            if (hashCode != -410083667) {
                if (hashCode == 627578634 && str2.equals("pageUpdateStart")) {
                    c = 2;
                }
            } else if (str2.equals("pageInitRenderStart")) {
                c = 1;
            }
        } else if (str2.equals("pageSwitchStart")) {
            c = 0;
        }
        if (c == 0) {
            zt2Var = this.a.get(str);
            if (zt2Var == null) {
                zt2Var = new wt2();
                this.a.put(str, zt2Var);
            }
        } else if (c == 1) {
            zt2Var = this.b.get(str);
            if (zt2Var == null) {
                zt2Var = new vt2();
                this.b.put(str, zt2Var);
            }
        } else if (c == 2 && (zt2Var = this.c.get(str)) == null) {
            zt2Var = new xt2();
            this.c.put(str, zt2Var);
        }
        if (zt2Var != null) {
            zt2Var.c(j);
        }
    }
}
