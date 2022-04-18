package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.core.Info;
import java.util.List;
/* loaded from: classes6.dex */
public class lu9 implements qq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ pu9 a;

    public lu9(pu9 pu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pu9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = pu9Var;
    }

    @Override // com.repackage.qq9
    public void a() {
        qq9 qq9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (qq9Var = this.a.a.d) == null) {
            return;
        }
        qq9Var.a();
    }

    @Override // com.repackage.qq9
    public void a(int i, String str) {
        qq9 qq9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) || (qq9Var = this.a.a.d) == null) {
            return;
        }
        qq9Var.a(i, str);
    }

    @Override // com.repackage.qq9
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            op9 a = xu9.a(((bv9) obj).c, this.a.a.a);
            tu9 tu9Var = this.a.a;
            qq9 qq9Var = tu9Var.d;
            if (qq9Var != null) {
                if (a == null) {
                    qq9Var.a(101, "");
                } else if (!TextUtils.isEmpty(tu9Var.b) && this.a.a.b.equalsIgnoreCase(a.a())) {
                    this.a.a.d.a(a);
                    List<Info> list = a.a;
                    if (list != null) {
                        for (Info info : list) {
                            Context context = this.a.a.a;
                            List material = info.getMaterial();
                            if (!material.isEmpty()) {
                                pr9.b(context, wp9.I(context), material, new fr9(context, info));
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
