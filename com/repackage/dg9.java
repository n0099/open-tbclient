package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.repackage.xf9;
import com.repackage.xk9;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class dg9 implements xk9.a<vf9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ xk9 a;

    public dg9(xk9 xk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xk9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = xk9Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.repackage.xk9.a
    public void a(vf9 vf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, vf9Var) == null) {
            LogPrinter.v("SlotId:%s is totally same with oldOne", vf9Var.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.repackage.xk9.a
    public void b(vf9 vf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vf9Var) == null) {
            vf9 vf9Var2 = vf9Var;
            LogPrinter.v("Update SlotId:%s", vf9Var2.a);
            HashMap<String, zf9> hashMap = this.a.c;
            String str = vf9Var2.a;
            hashMap.put(str, new zf9(str, new bg9(this, vf9Var2)));
            xf9 xf9Var = this.a.b;
            synchronized (xf9Var.a) {
                xf9Var.a(vf9Var2.a).add(new xf9.a(vf9Var2));
            }
        }
    }
}
