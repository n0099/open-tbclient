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
public class pg0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<rg0> d;
    public static final List<tg0> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, rg0> a;
    public final Map<String, tg0> b;
    public final ArrayList<String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755411016, "Lcom/repackage/pg0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755411016, "Lcom/repackage/pg0;");
                return;
            }
        }
        ah0 ah0Var = new ah0();
        d = ah0Var.a.getList();
        e = ah0Var.b.getList();
    }

    public pg0() {
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
        synchronized (pg0.class) {
            if (d != null && this.a.isEmpty()) {
                for (rg0 rg0Var : d) {
                    if (rg0Var != null) {
                        if (zx0.b(this.a, rg0Var.a()) == null) {
                            zx0.e(this.a, rg0Var.a(), rg0Var);
                        }
                        if (!TextUtils.isEmpty(rg0Var.a())) {
                            xx0.b(this.c, rg0Var.a());
                        }
                    }
                }
            }
            if (e != null && this.b.isEmpty()) {
                for (tg0 tg0Var : e) {
                    this.b.put(tg0Var.a(), tg0Var);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull vg0 vg0Var, @Nullable Map<String, Object> map, @Nullable zg0 zg0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, vg0Var, map, zg0Var)) == null) {
            if (b(context, vg0Var, map, zg0Var)) {
                eh0.b(zg0Var, vg0Var, 403, false);
                return false;
            }
            rg0 rg0Var = eh0.f(vg0Var.a()) ? (rg0) zx0.b(this.a, vg0Var.a()) : null;
            if (eh0.g(vg0Var.c()) && rg0Var != null) {
                vg0Var.f();
                return rg0Var.b(context, vg0Var, map, zg0Var);
            }
            return wg0.a().a(context, vg0Var.b(), map, zg0Var);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, vg0 vg0Var, @Nullable Map<String, Object> map, @Nullable zg0 zg0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, vg0Var, map, zg0Var)) == null) {
            if (this.b.isEmpty()) {
                return false;
            }
            tg0 tg0Var = null;
            try {
                for (Map.Entry<String, tg0> entry : this.b.entrySet()) {
                    if (entry != null) {
                        tg0Var = entry.getValue();
                    }
                    if (tg0Var != null && tg0Var.b(context, vg0Var, map, zg0Var)) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
