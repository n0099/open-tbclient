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
/* loaded from: classes6.dex */
public class hg9 implements xk9.a<tf9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ xk9 a;

    public hg9(xk9 xk9Var) {
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
    public void a(tf9 tf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, tf9Var) == null) {
            LogPrinter.v("SerialSlotId:%s is totally same with oldOne", tf9Var.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.repackage.xk9.a
    public void b(tf9 tf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tf9Var) == null) {
            tf9 tf9Var2 = tf9Var;
            LogPrinter.v("Update SerialSlotId:%s", tf9Var2.a);
            HashMap<String, zf9> hashMap = this.a.c;
            String str = tf9Var2.a;
            hashMap.put(str, new zf9(str, new fg9(this, tf9Var2)));
            xf9 xf9Var = this.a.b;
            synchronized (xf9Var.a) {
                xf9Var.a(tf9Var2.a).add(new xf9.b(tf9Var2));
            }
        }
    }
}
