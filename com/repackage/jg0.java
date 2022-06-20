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
public class jg0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<lg0> d;
    public static final List<ng0> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, lg0> a;
    public final Map<String, ng0> b;
    public final ArrayList<String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755589762, "Lcom/repackage/jg0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755589762, "Lcom/repackage/jg0;");
                return;
            }
        }
        ug0 ug0Var = new ug0();
        d = ug0Var.a.getList();
        e = ug0Var.b.getList();
    }

    public jg0() {
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
        synchronized (jg0.class) {
            if (d != null && this.a.isEmpty()) {
                for (lg0 lg0Var : d) {
                    if (lg0Var != null) {
                        if (mx0.b(this.a, lg0Var.a()) == null) {
                            mx0.e(this.a, lg0Var.a(), lg0Var);
                        }
                        if (!TextUtils.isEmpty(lg0Var.a())) {
                            kx0.b(this.c, lg0Var.a());
                        }
                    }
                }
            }
            if (e != null && this.b.isEmpty()) {
                for (ng0 ng0Var : e) {
                    this.b.put(ng0Var.a(), ng0Var);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull pg0 pg0Var, @Nullable Map<String, Object> map, @Nullable tg0 tg0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, pg0Var, map, tg0Var)) == null) {
            if (b(context, pg0Var)) {
                yg0.b(tg0Var, pg0Var, 403, false);
                return false;
            }
            lg0 lg0Var = yg0.f(pg0Var.a()) ? (lg0) mx0.b(this.a, pg0Var.a()) : null;
            if (yg0.g(pg0Var.c()) && lg0Var != null) {
                pg0Var.f();
                return lg0Var.b(context, pg0Var, map, tg0Var);
            }
            return qg0.a().a(context, pg0Var.b(), map, tg0Var);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, pg0 pg0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, pg0Var)) == null) {
            if (this.b.isEmpty()) {
                return false;
            }
            ng0 ng0Var = null;
            try {
                for (Map.Entry<String, ng0> entry : this.b.entrySet()) {
                    if (entry != null) {
                        ng0Var = entry.getValue();
                    }
                    if (ng0Var != null && ng0Var.b(context, pg0Var)) {
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
