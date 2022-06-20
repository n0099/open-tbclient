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
public class hq9 implements mm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ lq9 a;

    public hq9(lq9 lq9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lq9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = lq9Var;
    }

    @Override // com.repackage.mm9
    public void a() {
        mm9 mm9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (mm9Var = this.a.a.d) == null) {
            return;
        }
        mm9Var.a();
    }

    @Override // com.repackage.mm9
    public void a(int i, String str) {
        mm9 mm9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) || (mm9Var = this.a.a.d) == null) {
            return;
        }
        mm9Var.a(i, str);
    }

    @Override // com.repackage.mm9
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            kl9 a = tq9.a(((xq9) obj).c, this.a.a.a);
            pq9 pq9Var = this.a.a;
            mm9 mm9Var = pq9Var.d;
            if (mm9Var != null) {
                if (a == null) {
                    mm9Var.a(101, "");
                } else if (!TextUtils.isEmpty(pq9Var.b) && this.a.a.b.equalsIgnoreCase(a.a())) {
                    this.a.a.d.a(a);
                    List<Info> list = a.a;
                    if (list != null) {
                        for (Info info : list) {
                            Context context = this.a.a.a;
                            List material = info.getMaterial();
                            if (!material.isEmpty()) {
                                ln9.b(context, sl9.I(context), material, new bn9(context, info));
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
