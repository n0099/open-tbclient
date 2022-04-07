package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class ph0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<rh0> d;
    public static final List<th0> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, rh0> a;
    public final Map<String, th0> b;
    public final ArrayList<String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755410055, "Lcom/repackage/ph0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755410055, "Lcom/repackage/ph0;");
                return;
            }
        }
        ai0 ai0Var = new ai0();
        d = ai0Var.a.getList();
        e = ai0Var.b.getList();
    }

    public ph0() {
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
        this.a = new HashMap();
        this.b = Collections.synchronizedMap(new LinkedHashMap());
        this.c = new ArrayList<>();
        synchronized (ph0.class) {
            if (d != null && this.a.isEmpty()) {
                for (rh0 rh0Var : d) {
                    if (rh0Var != null) {
                        if (vy0.b(this.a, rh0Var.a()) == null) {
                            vy0.e(this.a, rh0Var.a(), rh0Var);
                        }
                        if (!TextUtils.isEmpty(rh0Var.a())) {
                            ty0.b(this.c, rh0Var.a());
                        }
                    }
                }
            }
            if (e != null && this.b.isEmpty()) {
                for (th0 th0Var : e) {
                    this.b.put(th0Var.a(), th0Var);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull vh0 vh0Var, @Nullable Map<String, Object> map, @Nullable zh0 zh0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, vh0Var, map, zh0Var)) == null) {
            if (b(context, vh0Var)) {
                ei0.b(zh0Var, vh0Var, 403, false);
                return false;
            }
            rh0 rh0Var = ei0.f(vh0Var.a()) ? (rh0) vy0.b(this.a, vh0Var.a()) : null;
            if (ei0.g(vh0Var.c()) && rh0Var != null) {
                vh0Var.f();
                return rh0Var.b(context, vh0Var, map, zh0Var);
            }
            return wh0.a().a(context, vh0Var.b(), map, zh0Var);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, vh0 vh0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, vh0Var)) == null) {
            if (this.b.isEmpty()) {
                return false;
            }
            th0 th0Var = null;
            try {
                for (Map.Entry<String, th0> entry : this.b.entrySet()) {
                    if (entry != null) {
                        th0Var = entry.getValue();
                    }
                    if (th0Var != null && th0Var.b(context, vh0Var)) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
