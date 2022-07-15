package com.repackage;

import android.util.Pair;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.utils.AdReporter;
import com.repackage.ne9;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class oe9<A extends ne9> extends AdReporter<A> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oe9(String str, String str2, String str3) {
        super(str, str2, str3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.utils.AdReporter
    public List onReport(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, str)) == null) {
            ne9 ne9Var = (ne9) obj;
            if (ne9Var == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Pair.create("csj_rq_id", ne9Var.a()));
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}
