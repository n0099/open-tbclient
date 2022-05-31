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
/* loaded from: classes5.dex */
public class fg0 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<hg0> d;
    public static final List<jg0> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, hg0> a;
    public final Map<String, jg0> b;
    public final ArrayList<String> c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755708926, "Lcom/repackage/fg0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755708926, "Lcom/repackage/fg0;");
                return;
            }
        }
        qg0 qg0Var = new qg0();
        d = qg0Var.a.getList();
        e = qg0Var.b.getList();
    }

    public fg0() {
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
        synchronized (fg0.class) {
            if (d != null && this.a.isEmpty()) {
                for (hg0 hg0Var : d) {
                    if (hg0Var != null) {
                        if (ix0.b(this.a, hg0Var.a()) == null) {
                            ix0.e(this.a, hg0Var.a(), hg0Var);
                        }
                        if (!TextUtils.isEmpty(hg0Var.a())) {
                            gx0.b(this.c, hg0Var.a());
                        }
                    }
                }
            }
            if (e != null && this.b.isEmpty()) {
                for (jg0 jg0Var : e) {
                    this.b.put(jg0Var.a(), jg0Var);
                }
            }
        }
    }

    public boolean a(@NonNull Context context, @NonNull lg0 lg0Var, @Nullable Map<String, Object> map, @Nullable pg0 pg0Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, lg0Var, map, pg0Var)) == null) {
            if (b(context, lg0Var)) {
                ug0.b(pg0Var, lg0Var, 403, false);
                return false;
            }
            hg0 hg0Var = ug0.f(lg0Var.a()) ? (hg0) ix0.b(this.a, lg0Var.a()) : null;
            if (ug0.g(lg0Var.c()) && hg0Var != null) {
                lg0Var.f();
                return hg0Var.b(context, lg0Var, map, pg0Var);
            }
            return mg0.a().a(context, lg0Var.b(), map, pg0Var);
        }
        return invokeLLLL.booleanValue;
    }

    public boolean b(Context context, lg0 lg0Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, lg0Var)) == null) {
            if (this.b.isEmpty()) {
                return false;
            }
            jg0 jg0Var = null;
            try {
                for (Map.Entry<String, jg0> entry : this.b.entrySet()) {
                    if (entry != null) {
                        jg0Var = entry.getValue();
                    }
                    if (jg0Var != null && jg0Var.b(context, lg0Var)) {
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
