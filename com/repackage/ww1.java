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
public final class ww1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public lf3 a;
    @NonNull
    public ArrayMap<String, wv1> b;
    @NonNull
    public ArrayMap<String, List<wv1>> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755187072, "Lcom/repackage/ww1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755187072, "Lcom/repackage/ww1;");
                return;
            }
        }
        d = rg1.a;
    }

    public ww1(@NonNull lf3 lf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lf3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = lf3Var;
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
            wv1 wv1Var = this.b.get(str);
            if (wv1Var == null) {
                hx1.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return wv1Var.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(wv1 wv1Var) {
        InterceptResult invokeL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wv1Var)) == null) {
            if (wv1Var == null) {
                ax1.a("Component-Container", "insert component with a null component");
                return false;
            }
            xv1 n = wv1Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = wv1Var.o();
            SwanAppComponentContainerView m = wv1Var.m();
            if (m == null) {
                ax1.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.b.containsKey(str2)) {
                hx1.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                ax1.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            nq2 nq2Var = n.h;
            if (nq2Var == null) {
                ax1.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!nq2Var.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                ax1.a("Component-Container", sb.toString());
                n.h = new nq2();
            }
            if (!vw1.c(n)) {
                if (TextUtils.isEmpty(n.d)) {
                    b = this.a.c(m, n.h);
                } else {
                    SwanAppComponentContainerView a = a(n.d);
                    if (a == null) {
                        hx1.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        ax1.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b = true;
                }
            } else {
                b = vw1.b(this, n, m);
                if (!b) {
                    ax1.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b) {
                this.b.put(n.b, wv1Var);
                if (wv1Var.s(2)) {
                    hx1.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<wv1> list = this.c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.c.put(str, list);
                    }
                    list.add(wv1Var);
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        wv1 value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry<String, wv1> entry : this.b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.y();
                }
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public final boolean d(@NonNull wv1 wv1Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull xv1 xv1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, wv1Var, swanAppComponentContainerView, xv1Var)) == null) {
            String o = wv1Var.o();
            if (d) {
                Log.d("Component-Container", o + " perform position update");
            }
            nq2 nq2Var = xv1Var.h;
            if (nq2Var != null && nq2Var.h()) {
                if (vw1.c(xv1Var) && !vw1.e(this, xv1Var, swanAppComponentContainerView)) {
                    ax1.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = xv1Var.d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, xv1Var.h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    hx1.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, xv1Var.b());
                    return true;
                } else {
                    ax1.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = xv1Var.h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            ax1.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(wv1 wv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, wv1Var)) == null) {
            boolean z = false;
            if (wv1Var == null) {
                ax1.a("Component-Container", "remove component with a null component");
                return false;
            }
            xv1 n = wv1Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = wv1Var.o();
            SwanAppComponentContainerView m = wv1Var.m();
            if (m == null) {
                ax1.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                ax1.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!vw1.c(n)) {
                    if (TextUtils.isEmpty(n.d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.d);
                        if (a == null) {
                            hx1.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            ax1.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = vw1.g(this, n, m);
                    if (!z) {
                        ax1.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || wv1Var.s(1)) {
                    this.b.remove(str2);
                    if (wv1Var.s(2)) {
                        hx1.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<wv1> list = this.c.get(str);
                        if (list != null) {
                            list.remove(wv1Var);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public boolean f(wv1 wv1Var, @NonNull zw1 zw1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, wv1Var, zw1Var)) == null) {
            if (wv1Var == null) {
                ax1.a("Component-Container", "update component with a null component");
                return false;
            }
            xv1 n = wv1Var.n();
            String o = wv1Var.o();
            SwanAppComponentContainerView m = wv1Var.m();
            if (m == null) {
                ax1.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.b.containsKey(n.b)) {
                hx1.c("Component-Container", "don't insert" + o);
            }
            if (wv1Var instanceof ow1) {
                if (zw1Var.a(7)) {
                    boolean d2 = vw1.d(this, wv1Var, n, m, zw1Var);
                    if (!d2) {
                        ax1.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (zw1Var.a(8)) {
                    vw1.f(this, wv1Var, n, m, zw1Var);
                }
            }
            if (zw1Var.a(3) && !d(wv1Var, m, n)) {
                hx1.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (wv1Var instanceof uv1) {
                uv1 uv1Var = (uv1) wv1Var;
                if (uv1Var.J()) {
                    if (d) {
                        Log.d("Component-Container", o + "perform position update with animation");
                    }
                    if (uv1Var.M()) {
                        return true;
                    }
                    hx1.c("Component-Container", o + " perform position update with animation fail");
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
