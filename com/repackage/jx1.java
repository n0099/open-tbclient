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
/* loaded from: classes6.dex */
public final class jx1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public yf3 a;
    @NonNull
    public ArrayMap<String, jw1> b;
    @NonNull
    public ArrayMap<String, List<jw1>> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755573394, "Lcom/repackage/jx1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755573394, "Lcom/repackage/jx1;");
                return;
            }
        }
        d = eh1.a;
    }

    public jx1(@NonNull yf3 yf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yf3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = yf3Var;
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
            jw1 jw1Var = this.b.get(str);
            if (jw1Var == null) {
                ux1.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return jw1Var.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(jw1 jw1Var) {
        InterceptResult invokeL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jw1Var)) == null) {
            if (jw1Var == null) {
                nx1.a("Component-Container", "insert component with a null component");
                return false;
            }
            kw1 n = jw1Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = jw1Var.o();
            SwanAppComponentContainerView m = jw1Var.m();
            if (m == null) {
                nx1.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.b.containsKey(str2)) {
                ux1.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                nx1.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            ar2 ar2Var = n.h;
            if (ar2Var == null) {
                nx1.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!ar2Var.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                nx1.a("Component-Container", sb.toString());
                n.h = new ar2();
            }
            if (!ix1.c(n)) {
                if (TextUtils.isEmpty(n.d)) {
                    b = this.a.c(m, n.h);
                } else {
                    SwanAppComponentContainerView a = a(n.d);
                    if (a == null) {
                        ux1.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        nx1.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b = true;
                }
            } else {
                b = ix1.b(this, n, m);
                if (!b) {
                    nx1.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b) {
                this.b.put(n.b, jw1Var);
                if (jw1Var.s(2)) {
                    ux1.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<jw1> list = this.c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.c.put(str, list);
                    }
                    list.add(jw1Var);
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        jw1 value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry<String, jw1> entry : this.b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.y();
                }
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public final boolean d(@NonNull jw1 jw1Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull kw1 kw1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, jw1Var, swanAppComponentContainerView, kw1Var)) == null) {
            String o = jw1Var.o();
            if (d) {
                Log.d("Component-Container", o + " perform position update");
            }
            ar2 ar2Var = kw1Var.h;
            if (ar2Var != null && ar2Var.h()) {
                if (ix1.c(kw1Var) && !ix1.e(this, kw1Var, swanAppComponentContainerView)) {
                    nx1.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = kw1Var.d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, kw1Var.h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    ux1.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, kw1Var.b());
                    return true;
                } else {
                    nx1.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = kw1Var.h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            nx1.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(jw1 jw1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, jw1Var)) == null) {
            boolean z = false;
            if (jw1Var == null) {
                nx1.a("Component-Container", "remove component with a null component");
                return false;
            }
            kw1 n = jw1Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = jw1Var.o();
            SwanAppComponentContainerView m = jw1Var.m();
            if (m == null) {
                nx1.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                nx1.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!ix1.c(n)) {
                    if (TextUtils.isEmpty(n.d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.d);
                        if (a == null) {
                            ux1.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            nx1.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = ix1.g(this, n, m);
                    if (!z) {
                        nx1.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || jw1Var.s(1)) {
                    this.b.remove(str2);
                    if (jw1Var.s(2)) {
                        ux1.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<jw1> list = this.c.get(str);
                        if (list != null) {
                            list.remove(jw1Var);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public boolean f(jw1 jw1Var, @NonNull mx1 mx1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, jw1Var, mx1Var)) == null) {
            if (jw1Var == null) {
                nx1.a("Component-Container", "update component with a null component");
                return false;
            }
            kw1 n = jw1Var.n();
            String o = jw1Var.o();
            SwanAppComponentContainerView m = jw1Var.m();
            if (m == null) {
                nx1.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.b.containsKey(n.b)) {
                ux1.c("Component-Container", "don't insert" + o);
            }
            if (jw1Var instanceof bx1) {
                if (mx1Var.a(7)) {
                    boolean d2 = ix1.d(this, jw1Var, n, m, mx1Var);
                    if (!d2) {
                        nx1.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (mx1Var.a(8)) {
                    ix1.f(this, jw1Var, n, m, mx1Var);
                }
            }
            if (mx1Var.a(3) && !d(jw1Var, m, n)) {
                ux1.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (jw1Var instanceof hw1) {
                hw1 hw1Var = (hw1) jw1Var;
                if (hw1Var.J()) {
                    if (d) {
                        Log.d("Component-Container", o + "perform position update with animation");
                    }
                    if (hw1Var.M()) {
                        return true;
                    }
                    ux1.c("Component-Container", o + " perform position update with animation fail");
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
