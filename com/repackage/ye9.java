package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.repackage.se9;
import com.repackage.sj9;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class ye9 implements sj9.a<qe9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ sj9 a;

    public ye9(sj9 sj9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sj9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = sj9Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.repackage.sj9.a
    public void a(qe9 qe9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, qe9Var) == null) {
            LogPrinter.v("SlotId:%s is totally same with oldOne", qe9Var.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.repackage.sj9.a
    public void b(qe9 qe9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qe9Var) == null) {
            qe9 qe9Var2 = qe9Var;
            LogPrinter.v("Update SlotId:%s", qe9Var2.a);
            HashMap<String, ue9> hashMap = this.a.c;
            String str = qe9Var2.a;
            hashMap.put(str, new ue9(str, new we9(this, qe9Var2)));
            se9 se9Var = this.a.b;
            synchronized (se9Var.a) {
                se9Var.a(qe9Var2.a).add(new se9.a(qe9Var2));
            }
        }
    }
}
