package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.repackage.mb9;
import com.repackage.mg9;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class wb9 implements mg9.a<ib9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ mg9 a;

    public wb9(mg9 mg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mg9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mg9Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.repackage.mg9.a
    public void a(ib9 ib9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ib9Var) == null) {
            LogPrinter.v("SerialSlotId:%s is totally same with oldOne", ib9Var.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.repackage.mg9.a
    public void b(ib9 ib9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ib9Var) == null) {
            ib9 ib9Var2 = ib9Var;
            LogPrinter.v("Update SerialSlotId:%s", ib9Var2.a);
            HashMap<String, ob9> hashMap = this.a.c;
            String str = ib9Var2.a;
            hashMap.put(str, new ob9(str, new ub9(this, ib9Var2)));
            mb9 mb9Var = this.a.b;
            synchronized (mb9Var.a) {
                mb9Var.a(ib9Var2.a).add(new mb9.b(ib9Var2));
            }
        }
    }
}
