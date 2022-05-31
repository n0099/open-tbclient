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
public final class wv1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public le3 a;
    @NonNull
    public ArrayMap<String, wu1> b;
    @NonNull
    public ArrayMap<String, List<wu1>> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755188033, "Lcom/repackage/wv1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755188033, "Lcom/repackage/wv1;");
                return;
            }
        }
        d = rf1.a;
    }

    public wv1(@NonNull le3 le3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {le3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = le3Var;
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
            wu1 wu1Var = this.b.get(str);
            if (wu1Var == null) {
                hw1.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return wu1Var.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(wu1 wu1Var) {
        InterceptResult invokeL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wu1Var)) == null) {
            if (wu1Var == null) {
                aw1.a("Component-Container", "insert component with a null component");
                return false;
            }
            xu1 n = wu1Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = wu1Var.o();
            SwanAppComponentContainerView m = wu1Var.m();
            if (m == null) {
                aw1.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.b.containsKey(str2)) {
                hw1.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                aw1.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            np2 np2Var = n.h;
            if (np2Var == null) {
                aw1.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!np2Var.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                aw1.a("Component-Container", sb.toString());
                n.h = new np2();
            }
            if (!vv1.c(n)) {
                if (TextUtils.isEmpty(n.d)) {
                    b = this.a.c(m, n.h);
                } else {
                    SwanAppComponentContainerView a = a(n.d);
                    if (a == null) {
                        hw1.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        aw1.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b = true;
                }
            } else {
                b = vv1.b(this, n, m);
                if (!b) {
                    aw1.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b) {
                this.b.put(n.b, wu1Var);
                if (wu1Var.s(2)) {
                    hw1.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<wu1> list = this.c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.c.put(str, list);
                    }
                    list.add(wu1Var);
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        wu1 value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry<String, wu1> entry : this.b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.y();
                }
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public final boolean d(@NonNull wu1 wu1Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull xu1 xu1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, wu1Var, swanAppComponentContainerView, xu1Var)) == null) {
            String o = wu1Var.o();
            if (d) {
                Log.d("Component-Container", o + " perform position update");
            }
            np2 np2Var = xu1Var.h;
            if (np2Var != null && np2Var.h()) {
                if (vv1.c(xu1Var) && !vv1.e(this, xu1Var, swanAppComponentContainerView)) {
                    aw1.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = xu1Var.d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, xu1Var.h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    hw1.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, xu1Var.b());
                    return true;
                } else {
                    aw1.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = xu1Var.h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            aw1.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(wu1 wu1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, wu1Var)) == null) {
            boolean z = false;
            if (wu1Var == null) {
                aw1.a("Component-Container", "remove component with a null component");
                return false;
            }
            xu1 n = wu1Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = wu1Var.o();
            SwanAppComponentContainerView m = wu1Var.m();
            if (m == null) {
                aw1.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                aw1.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!vv1.c(n)) {
                    if (TextUtils.isEmpty(n.d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.d);
                        if (a == null) {
                            hw1.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            aw1.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = vv1.g(this, n, m);
                    if (!z) {
                        aw1.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || wu1Var.s(1)) {
                    this.b.remove(str2);
                    if (wu1Var.s(2)) {
                        hw1.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<wu1> list = this.c.get(str);
                        if (list != null) {
                            list.remove(wu1Var);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public boolean f(wu1 wu1Var, @NonNull zv1 zv1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, wu1Var, zv1Var)) == null) {
            if (wu1Var == null) {
                aw1.a("Component-Container", "update component with a null component");
                return false;
            }
            xu1 n = wu1Var.n();
            String o = wu1Var.o();
            SwanAppComponentContainerView m = wu1Var.m();
            if (m == null) {
                aw1.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.b.containsKey(n.b)) {
                hw1.c("Component-Container", "don't insert" + o);
            }
            if (wu1Var instanceof ov1) {
                if (zv1Var.a(7)) {
                    boolean d2 = vv1.d(this, wu1Var, n, m, zv1Var);
                    if (!d2) {
                        aw1.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (zv1Var.a(8)) {
                    vv1.f(this, wu1Var, n, m, zv1Var);
                }
            }
            if (zv1Var.a(3) && !d(wu1Var, m, n)) {
                hw1.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (wu1Var instanceof uu1) {
                uu1 uu1Var = (uu1) wu1Var;
                if (uu1Var.J()) {
                    if (d) {
                        Log.d("Component-Container", o + "perform position update with animation");
                    }
                    if (uu1Var.M()) {
                        return true;
                    }
                    hw1.c("Component-Container", o + " perform position update with animation fail");
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
