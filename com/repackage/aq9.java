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
/* loaded from: classes5.dex */
public class aq9 implements fm9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ eq9 a;

    public aq9(eq9 eq9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eq9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = eq9Var;
    }

    @Override // com.repackage.fm9
    public void a() {
        fm9 fm9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (fm9Var = this.a.a.d) == null) {
            return;
        }
        fm9Var.a();
    }

    @Override // com.repackage.fm9
    public void a(int i, String str) {
        fm9 fm9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) || (fm9Var = this.a.a.d) == null) {
            return;
        }
        fm9Var.a(i, str);
    }

    @Override // com.repackage.fm9
    public void a(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            dl9 a = mq9.a(((qq9) obj).c, this.a.a.a);
            iq9 iq9Var = this.a.a;
            fm9 fm9Var = iq9Var.d;
            if (fm9Var != null) {
                if (a == null) {
                    fm9Var.a(101, "");
                } else if (!TextUtils.isEmpty(iq9Var.b) && this.a.a.b.equalsIgnoreCase(a.a())) {
                    this.a.a.d.a(a);
                    List<Info> list = a.a;
                    if (list != null) {
                        for (Info info : list) {
                            Context context = this.a.a.a;
                            List material = info.getMaterial();
                            if (!material.isEmpty()) {
                                en9.b(context, ll9.I(context), material, new um9(context, info));
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
