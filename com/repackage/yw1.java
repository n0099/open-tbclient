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
public final class yw1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public nf3 a;
    @NonNull
    public ArrayMap<String, yv1> b;
    @NonNull
    public ArrayMap<String, List<yv1>> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755127490, "Lcom/repackage/yw1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755127490, "Lcom/repackage/yw1;");
                return;
            }
        }
        d = tg1.a;
    }

    public yw1(@NonNull nf3 nf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nf3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = nf3Var;
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
            yv1 yv1Var = this.b.get(str);
            if (yv1Var == null) {
                jx1.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return yv1Var.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(yv1 yv1Var) {
        InterceptResult invokeL;
        boolean b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, yv1Var)) == null) {
            if (yv1Var == null) {
                cx1.a("Component-Container", "insert component with a null component");
                return false;
            }
            zv1 n = yv1Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = yv1Var.o();
            SwanAppComponentContainerView m = yv1Var.m();
            if (m == null) {
                cx1.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.b.containsKey(str2)) {
                jx1.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                cx1.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            pq2 pq2Var = n.h;
            if (pq2Var == null) {
                cx1.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!pq2Var.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                cx1.a("Component-Container", sb.toString());
                n.h = new pq2();
            }
            if (!xw1.c(n)) {
                if (TextUtils.isEmpty(n.d)) {
                    b = this.a.c(m, n.h);
                } else {
                    SwanAppComponentContainerView a = a(n.d);
                    if (a == null) {
                        jx1.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        cx1.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b = true;
                }
            } else {
                b = xw1.b(this, n, m);
                if (!b) {
                    cx1.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b) {
                this.b.put(n.b, yv1Var);
                if (yv1Var.s(2)) {
                    jx1.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<yv1> list = this.c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.c.put(str, list);
                    }
                    list.add(yv1Var);
                }
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        yv1 value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry<String, yv1> entry : this.b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.y();
                }
            }
            this.b.clear();
            this.c.clear();
        }
    }

    public final boolean d(@NonNull yv1 yv1Var, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull zv1 zv1Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, yv1Var, swanAppComponentContainerView, zv1Var)) == null) {
            String o = yv1Var.o();
            if (d) {
                Log.d("Component-Container", o + " perform position update");
            }
            pq2 pq2Var = zv1Var.h;
            if (pq2Var != null && pq2Var.h()) {
                if (xw1.c(zv1Var) && !xw1.e(this, zv1Var, swanAppComponentContainerView)) {
                    cx1.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = zv1Var.d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, zv1Var.h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    jx1.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, zv1Var.b());
                    return true;
                } else {
                    cx1.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = zv1Var.h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            cx1.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(yv1 yv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, yv1Var)) == null) {
            boolean z = false;
            if (yv1Var == null) {
                cx1.a("Component-Container", "remove component with a null component");
                return false;
            }
            zv1 n = yv1Var.n();
            String str = n.a;
            String str2 = n.b;
            String o = yv1Var.o();
            SwanAppComponentContainerView m = yv1Var.m();
            if (m == null) {
                cx1.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                cx1.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!xw1.c(n)) {
                    if (TextUtils.isEmpty(n.d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.d);
                        if (a == null) {
                            jx1.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            cx1.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = xw1.g(this, n, m);
                    if (!z) {
                        cx1.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || yv1Var.s(1)) {
                    this.b.remove(str2);
                    if (yv1Var.s(2)) {
                        jx1.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<yv1> list = this.c.get(str);
                        if (list != null) {
                            list.remove(yv1Var);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public boolean f(yv1 yv1Var, @NonNull bx1 bx1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, yv1Var, bx1Var)) == null) {
            if (yv1Var == null) {
                cx1.a("Component-Container", "update component with a null component");
                return false;
            }
            zv1 n = yv1Var.n();
            String o = yv1Var.o();
            SwanAppComponentContainerView m = yv1Var.m();
            if (m == null) {
                cx1.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.b.containsKey(n.b)) {
                jx1.c("Component-Container", "don't insert" + o);
            }
            if (yv1Var instanceof qw1) {
                if (bx1Var.a(7)) {
                    boolean d2 = xw1.d(this, yv1Var, n, m, bx1Var);
                    if (!d2) {
                        cx1.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (bx1Var.a(8)) {
                    xw1.f(this, yv1Var, n, m, bx1Var);
                }
            }
            if (bx1Var.a(3) && !d(yv1Var, m, n)) {
                jx1.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (yv1Var instanceof wv1) {
                wv1 wv1Var = (wv1) yv1Var;
                if (wv1Var.J()) {
                    if (d) {
                        Log.d("Component-Container", o + "perform position update with animation");
                    }
                    if (wv1Var.M()) {
                        return true;
                    }
                    jx1.c("Component-Container", o + " perform position update with animation fail");
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
