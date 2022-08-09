package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.repackage.al9;
import com.repackage.dg9;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class zk9 implements al9.a<ag9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ al9 a;

    public zk9(al9 al9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {al9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = al9Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.repackage.al9.a
    public void a(ag9 ag9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ag9Var) == null) {
            LogPrinter.v("SerialSlotId:%s is totally same with oldOne", ag9Var.a);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.repackage.al9.a
    public void b(ag9 ag9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ag9Var) == null) {
            ag9 ag9Var2 = ag9Var;
            LogPrinter.v("Update SerialSlotId:%s", ag9Var2.a);
            HashMap<String, fg9> hashMap = this.a.c;
            String str = ag9Var2.a;
            hashMap.put(str, new fg9(str, new mg9(this, ag9Var2)));
            dg9 dg9Var = this.a.b;
            synchronized (dg9Var.a) {
                dg9Var.a(ag9Var2.a).add(new dg9.b(ag9Var2));
            }
        }
    }
}
