package com.fun.openid.sdk;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.openid.sdk.f;
import java.lang.reflect.Method;
/* loaded from: classes9.dex */
public class h implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public h() {
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

    @Override // com.fun.openid.sdk.f
    public void a(Context context, f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, aVar) == null) {
            String str = null;
            if (!((n.f70393b == null || n.f70392a == null) ? false : true)) {
                FunOpenIDSdk.isLogEnabled();
                aVar.a(false, null);
                return;
            }
            Method method = n.f70394c;
            Object obj = n.f70392a;
            if (obj != null && method != null) {
                try {
                    Object invoke = method.invoke(obj, context);
                    if (invoke != null) {
                        str = (String) invoke;
                    }
                } catch (Exception unused) {
                }
            }
            aVar.a(true, str);
        }
    }
}
