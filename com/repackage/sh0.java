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
/* loaded from: classes7.dex */
public class sh0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<uh0> d;
    public static final List<wh0> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, uh0> a;
    public final Map<String, wh0> b;
    public final ArrayList<String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755320682, "Lcom/repackage/sh0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755320682, "Lcom/repackage/sh0;");
                return;
            }
        }
        di0 di0Var = new di0();
        d = di0Var.a.getList();
        e = di0Var.b.getList();
    }

    public sh0() {
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
        synchronized (sh0.class) {
            if (d != null && this.a.isEmpty()) {
                for (uh0 uh0Var : d) {
                    if (uh0Var != null) {
                        if (vy0.b(this.a, uh0Var.a()) == null) {
                            vy0.e(this.a, uh0Var.a(), uh0Var);
                        }
                        if (!TextUtils.isEmpty(uh0Var.a())) {
                            ty0.b(this.c, uh0Var.a());
                        }
                    }
                }
            }
            if (e != null && this.b.isEmpty()) {
                for (wh0 wh0Var : e) {
                    this.b.put(wh0Var.a(), wh0Var);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull yh0 yh0Var, @Nullable Map<String, Object> map, @Nullable ci0 ci0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, yh0Var, map, ci0Var)) == null) {
            if (b(context, yh0Var)) {
                hi0.b(ci0Var, yh0Var, 403, false);
                return false;
            }
            uh0 uh0Var = hi0.f(yh0Var.a()) ? (uh0) vy0.b(this.a, yh0Var.a()) : null;
            if (hi0.g(yh0Var.c()) && uh0Var != null) {
                yh0Var.f();
                return uh0Var.b(context, yh0Var, map, ci0Var);
            }
            return zh0.a().a(context, yh0Var.b(), map, ci0Var);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, yh0 yh0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, yh0Var)) == null) {
            if (this.b.isEmpty()) {
                return false;
            }
            wh0 wh0Var = null;
            try {
                for (Map.Entry<String, wh0> entry : this.b.entrySet()) {
                    if (entry != null) {
                        wh0Var = entry.getValue();
                    }
                    if (wh0Var != null && wh0Var.b(context, yh0Var)) {
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
