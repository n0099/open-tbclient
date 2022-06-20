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
public class ec9 implements ug9.a<qb9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ ug9 a;

    public ec9(ug9 ug9Var) {
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
    public void a(qb9 qb9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qb9Var) == null) {
            LogPrinter.v("SerialSlotId:%s is totally same with oldOne", qb9Var.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.repackage.ug9.a
    public void b(qb9 qb9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qb9Var) == null) {
            qb9 qb9Var2 = qb9Var;
            LogPrinter.v("Update SerialSlotId:%s", qb9Var2.a);
            HashMap<String, wb9> hashMap = this.a.c;
            String str = qb9Var2.a;
            hashMap.put(str, new wb9(str, new cc9(this, qb9Var2)));
            ub9 ub9Var = this.a.b;
            synchronized (ub9Var.a) {
                ub9Var.a(qb9Var2.a).add(new ub9.b(qb9Var2));
            }
        }
    }
}
