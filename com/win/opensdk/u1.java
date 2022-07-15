package com.win.opensdk;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import java.util.List;
/* loaded from: classes8.dex */
public class u1 implements S0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ v1 a;

    public u1(v1 v1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = v1Var;
    }

    @Override // com.win.opensdk.S0
    public void a() {
        S0 s0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (s0 = this.a.a.d) == null) {
            return;
        }
        s0.a();
    }

    @Override // com.win.opensdk.S0
    public void a(int i, String str) {
        S0 s0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) || (s0 = this.a.a.d) == null) {
            return;
        }
        s0.a(i, str);
    }

    @Override // com.win.opensdk.S0
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            J a = x1.a(((y1) obj).c, this.a.a.a);
            w1 w1Var = this.a.a;
            S0 s0 = w1Var.d;
            if (s0 != null) {
                if (a == null) {
                    s0.a(101, "");
                } else if (!TextUtils.isEmpty(w1Var.b) && this.a.a.b.equalsIgnoreCase(a.a())) {
                    this.a.a.d.a(a);
                    List<Info> list = a.a;
                    if (list != null) {
                        for (Info info : list) {
                            Context context = this.a.a.a;
                            List material = info.getMaterial();
                            if (!material.isEmpty()) {
                                a1.a(context, M.f(context), material, new X0(context, info));
                            }
                        }
                    }
                } else {
                    this.a.a.d.a(2003, "");
                }
            }
        }
    }
}
