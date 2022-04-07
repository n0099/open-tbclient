package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.repackage.qf9;
import com.repackage.qk9;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class wf9 implements qk9.a<of9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ qk9 a;

    public wf9(qk9 qk9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qk9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = qk9Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.repackage.qk9.a
    public void a(of9 of9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, of9Var) == null) {
            LogPrinter.v("SlotId:%s is totally same with oldOne", of9Var.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.repackage.qk9.a
    public void b(of9 of9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, of9Var) == null) {
            of9 of9Var2 = of9Var;
            LogPrinter.v("Update SlotId:%s", of9Var2.a);
            HashMap<String, sf9> hashMap = this.a.c;
            String str = of9Var2.a;
            hashMap.put(str, new sf9(str, new uf9(this, of9Var2)));
            qf9 qf9Var = this.a.b;
            synchronized (qf9Var.a) {
                qf9Var.a(of9Var2.a).add(new qf9.a(of9Var2));
            }
        }
    }
}
