package com.repackage;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public final class xw1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public mf3 a;
    @NonNull
    public ArrayMap<String, xv1> b;
    @NonNull
    public ArrayMap<String, List<xv1>> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755157281, "Lcom/repackage/xw1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755157281, "Lcom/repackage/xw1;");
                return;
            }
        }
        d = sg1.a;
    }

    public xw1(@NonNull mf3 mf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mf3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = mf3Var;
        this.b = new ArrayMap<>();
        this.c = new ArrayMap<>();
    }

    @Nullable
    public SwanAppComponentContainerView a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            xv1 xv1Var = this.b.get(str);
            if (xv1Var == null) {
                ix1.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return xv1Var.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(xv1 xv1Var) {
        InterceptResult invokeL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xv1Var)) == null) {
            if (xv1Var == null) {
                bx1.a("Component-Container", "insert component with a null component");
                return false;
            }
            yv1 n = xv1Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = xv1Var.o();
            SwanAppComponentContainerView m = xv1Var.m();
            if (m == null) {
                bx1.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.b.containsKey(str2)) {
                ix1.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                bx1.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            oq2 oq2Var = n.h;
            if (oq2Var == null) {
                bx1.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!oq2Var.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                bx1.a("Component-Container", sb.toString());
                n.h = new oq2();
            }
            if (!ww1.c(n)) {
                if (TextUtils.isEmpty(n.d)) {
                    b = this.a.c(m, n.h);
                } else {
                    SwanAppComponentContainerView a = a(n.d);
                    if (a == null) {
                        ix1.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        bx1.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b = true;
                }
            } else {
                b = ww1.b(this, n, m);
                if (!b) {
                    bx1.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b) {
                this.b.put(n.b, xv1Var);
                if (xv1Var.s(2)) {
                    ix1.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<xv1> list = this.c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.c.put(str, list);
                    }
                    list.add(xv1Var);
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        xv1 value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry<String, xv1> entry : this.b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.y();
                }
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public final boolean d(@NonNull xv1 xv1Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull yv1 yv1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, xv1Var, swanAppComponentContainerView, yv1Var)) == null) {
            String o = xv1Var.o();
            if (d) {
                Log.d("Component-Container", o + " perform position update");
            }
            oq2 oq2Var = yv1Var.h;
            if (oq2Var != null && oq2Var.h()) {
                if (ww1.c(yv1Var) && !ww1.e(this, yv1Var, swanAppComponentContainerView)) {
                    bx1.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = yv1Var.d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, yv1Var.h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    ix1.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, yv1Var.b());
                    return true;
                } else {
                    bx1.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = yv1Var.h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            bx1.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(xv1 xv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, xv1Var)) == null) {
            boolean z = false;
            if (xv1Var == null) {
                bx1.a("Component-Container", "remove component with a null component");
                return false;
            }
            yv1 n = xv1Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = xv1Var.o();
            SwanAppComponentContainerView m = xv1Var.m();
            if (m == null) {
                bx1.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                bx1.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!ww1.c(n)) {
                    if (TextUtils.isEmpty(n.d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.d);
                        if (a == null) {
                            ix1.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            bx1.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = ww1.g(this, n, m);
                    if (!z) {
                        bx1.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || xv1Var.s(1)) {
                    this.b.remove(str2);
                    if (xv1Var.s(2)) {
                        ix1.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<xv1> list = this.c.get(str);
                        if (list != null) {
                            list.remove(xv1Var);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public boolean f(xv1 xv1Var, @NonNull ax1 ax1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, xv1Var, ax1Var)) == null) {
            if (xv1Var == null) {
                bx1.a("Component-Container", "update component with a null component");
                return false;
            }
            yv1 n = xv1Var.n();
            String o = xv1Var.o();
            SwanAppComponentContainerView m = xv1Var.m();
            if (m == null) {
                bx1.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.b.containsKey(n.b)) {
                ix1.c("Component-Container", "don't insert" + o);
            }
            if (xv1Var instanceof pw1) {
                if (ax1Var.a(7)) {
                    boolean d2 = ww1.d(this, xv1Var, n, m, ax1Var);
                    if (!d2) {
                        bx1.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (ax1Var.a(8)) {
                    ww1.f(this, xv1Var, n, m, ax1Var);
                }
            }
            if (ax1Var.a(3) && !d(xv1Var, m, n)) {
                ix1.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (xv1Var instanceof vv1) {
                vv1 vv1Var = (vv1) xv1Var;
                if (vv1Var.J()) {
                    if (d) {
                        Log.d("Component-Container", o + "perform position update with animation");
                    }
                    if (vv1Var.M()) {
                        return true;
                    }
                    ix1.c("Component-Container", o + " perform position update with animation fail");
                    return false;
                }
                return true;
            } else {
                return true;
            }
        }
        return invokeLL.booleanValue;
    }
}
