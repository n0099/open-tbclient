package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.repackage.ub9;
import com.repackage.ug9;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class ac9 implements ug9.a<sb9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ug9 a;

    public ac9(ug9 ug9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ug9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ug9Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.repackage.ug9.a
    public void a(sb9 sb9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sb9Var) == null) {
            LogPrinter.v("SlotId:%s is totally same with oldOne", sb9Var.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.repackage.ug9.a
    public void b(sb9 sb9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sb9Var) == null) {
            sb9 sb9Var2 = sb9Var;
            LogPrinter.v("Update SlotId:%s", sb9Var2.a);
            HashMap<String, wb9> hashMap = this.a.c;
            String str = sb9Var2.a;
            hashMap.put(str, new wb9(str, new yb9(this, sb9Var2)));
            ub9 ub9Var = this.a.b;
            synchronized (ub9Var.a) {
                ub9Var.a(sb9Var2.a).add(new ub9.a(sb9Var2));
            }
        }
    }
}
