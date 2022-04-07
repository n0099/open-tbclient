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
/* loaded from: classes5.dex */
public class ag9 implements qk9.a<mf9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ qk9 a;

    public ag9(qk9 qk9Var) {
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
    public void a(mf9 mf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mf9Var) == null) {
            LogPrinter.v("SerialSlotId:%s is totally same with oldOne", mf9Var.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.repackage.qk9.a
    public void b(mf9 mf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mf9Var) == null) {
            mf9 mf9Var2 = mf9Var;
            LogPrinter.v("Update SerialSlotId:%s", mf9Var2.a);
            HashMap<String, sf9> hashMap = this.a.c;
            String str = mf9Var2.a;
            hashMap.put(str, new sf9(str, new yf9(this, mf9Var2)));
            qf9 qf9Var = this.a.b;
            synchronized (qf9Var.a) {
                qf9Var.a(mf9Var2.a).add(new qf9.b(mf9Var2));
            }
        }
    }
}
