package com.sdk.mobile.a;

import android.content.Context;
import com.baidu.sapi2.activity.social.YYInnerSSOLoginActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.base.framework.a.a.c;
import com.sdk.base.framework.a.f;
import com.sdk.base.framework.a.j;
import com.sdk.base.framework.b.b;
import com.sdk.base.framework.bean.DataInfo;
/* loaded from: classes2.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static <T> f a(Context context, String str, String str2, com.sdk.base.framework.b.a<T> aVar) {
        InterceptResult invokeLLLL;
        DataInfo dataInfo;
        String str3;
        b<T> a;
        j jVar;
        int i2;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, context, str, str2, aVar)) == null) {
            com.sdk.mobile.c.a aVar2 = new com.sdk.mobile.c.a(context, aVar);
            if (c.a(str2).booleanValue()) {
                dataInfo = new DataInfo();
                dataInfo.putData(YYInnerSSOLoginActivity.o, str);
                str3 = aVar2.f60995b;
                a = aVar2.a();
                jVar = j.f60954b;
                i2 = 0;
                str4 = "/api/netm/v1.0/qhbt";
            } else {
                dataInfo = new DataInfo();
                dataInfo.putData(YYInnerSSOLoginActivity.o, str);
                dataInfo.putData("mobile", str2);
                str3 = aVar2.f60995b;
                a = aVar2.a();
                jVar = j.f60954b;
                i2 = 0;
                str4 = "/api/netm/v1.0/qhbv";
            }
            return aVar2.a(str3, str4, dataInfo, a, i2, jVar);
        }
        return (f) invokeLLLL.objValue;
    }
}
