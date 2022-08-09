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
public class lg0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<ng0> d;
    public static final List<pg0> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, ng0> a;
    public final Map<String, pg0> b;
    public final ArrayList<String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755530180, "Lcom/repackage/lg0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755530180, "Lcom/repackage/lg0;");
                return;
            }
        }
        wg0 wg0Var = new wg0();
        d = wg0Var.a.getList();
        e = wg0Var.b.getList();
    }

    public lg0() {
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
        synchronized (lg0.class) {
            if (d != null && this.a.isEmpty()) {
                for (ng0 ng0Var : d) {
                    if (ng0Var != null) {
                        if (yx0.b(this.a, ng0Var.a()) == null) {
                            yx0.e(this.a, ng0Var.a(), ng0Var);
                        }
                        if (!TextUtils.isEmpty(ng0Var.a())) {
                            wx0.b(this.c, ng0Var.a());
                        }
                    }
                }
            }
            if (e != null && this.b.isEmpty()) {
                for (pg0 pg0Var : e) {
                    this.b.put(pg0Var.b(), pg0Var);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull rg0 rg0Var, @Nullable Map<String, Object> map, @Nullable vg0 vg0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, rg0Var, map, vg0Var)) == null) {
            if (b(context, rg0Var, map, vg0Var)) {
                ah0.b(vg0Var, rg0Var, 403, false);
                return false;
            }
            ng0 ng0Var = ah0.f(rg0Var.a()) ? (ng0) yx0.b(this.a, rg0Var.a()) : null;
            if (ah0.g(rg0Var.c()) && ng0Var != null) {
                rg0Var.f();
                return ng0Var.b(context, rg0Var, map, vg0Var);
            }
            return sg0.a().a(context, rg0Var.b(), map, vg0Var);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, rg0 rg0Var, @Nullable Map<String, Object> map, @Nullable vg0 vg0Var) {
        InterceptResult invokeLLLL;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, rg0Var, map, vg0Var)) == null) {
            if (this.b.isEmpty()) {
                return false;
            }
            pg0 pg0Var = null;
            try {
                for (Map.Entry<String, pg0> entry : this.b.entrySet()) {
                    String a2 = rg0Var.a();
                    if (entry == null || ((pg0Var = entry.getValue()) != null && (a = pg0Var.a()) != null && TextUtils.equals(a2, a))) {
                        if (pg0Var != null && pg0Var.c(context, rg0Var, map, vg0Var)) {
                            return true;
                        }
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
