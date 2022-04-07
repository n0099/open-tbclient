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
public class eu9 implements jq9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ iu9 a;

    public eu9(iu9 iu9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iu9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = iu9Var;
    }

    @Override // com.repackage.jq9
    public void a() {
        jq9 jq9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (jq9Var = this.a.a.d) == null) {
            return;
        }
        jq9Var.a();
    }

    @Override // com.repackage.jq9
    public void a(int i, String str) {
        jq9 jq9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) || (jq9Var = this.a.a.d) == null) {
            return;
        }
        jq9Var.a(i, str);
    }

    @Override // com.repackage.jq9
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            hp9 a = qu9.a(((uu9) obj).c, this.a.a.a);
            mu9 mu9Var = this.a.a;
            jq9 jq9Var = mu9Var.d;
            if (jq9Var != null) {
                if (a == null) {
                    jq9Var.a(101, "");
                } else if (!TextUtils.isEmpty(mu9Var.b) && this.a.a.b.equalsIgnoreCase(a.a())) {
                    this.a.a.d.a(a);
                    List<Info> list = a.a;
                    if (list != null) {
                        for (Info info : list) {
                            Context context = this.a.a.a;
                            List material = info.getMaterial();
                            if (!material.isEmpty()) {
                                ir9.b(context, pp9.I(context), material, new yq9(context, info));
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
