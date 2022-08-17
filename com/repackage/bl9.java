package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.repackage.cl9;
import com.repackage.fg9;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class bl9 implements cl9.a<cg9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ cl9 a;

    public bl9(cl9 cl9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cl9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cl9Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.repackage.cl9.a
    public void a(cg9 cg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cg9Var) == null) {
            LogPrinter.v("SerialSlotId:%s is totally same with oldOne", cg9Var.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.repackage.cl9.a
    public void b(cg9 cg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cg9Var) == null) {
            cg9 cg9Var2 = cg9Var;
            LogPrinter.v("Update SerialSlotId:%s", cg9Var2.a);
            HashMap<String, hg9> hashMap = this.a.c;
            String str = cg9Var2.a;
            hashMap.put(str, new hg9(str, new og9(this, cg9Var2)));
            fg9 fg9Var = this.a.b;
            synchronized (fg9Var.a) {
                fg9Var.a(cg9Var2.a).add(new fg9.b(cg9Var2));
            }
        }
    }
}
