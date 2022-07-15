package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.repackage.fi9;
import com.repackage.id9;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class ei9 implements fi9.a<fd9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ fi9 a;

    public ei9(fi9 fi9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fi9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = fi9Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.repackage.fi9.a
    public void a(fd9 fd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fd9Var) == null) {
            LogPrinter.v("SerialSlotId:%s is totally same with oldOne", fd9Var.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.repackage.fi9.a
    public void b(fd9 fd9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fd9Var) == null) {
            fd9 fd9Var2 = fd9Var;
            LogPrinter.v("Update SerialSlotId:%s", fd9Var2.a);
            HashMap<String, kd9> hashMap = this.a.c;
            String str = fd9Var2.a;
            hashMap.put(str, new kd9(str, new rd9(this, fd9Var2)));
            id9 id9Var = this.a.b;
            synchronized (id9Var.a) {
                id9Var.a(fd9Var2.a).add(new id9.b(fd9Var2));
            }
        }
    }
}
