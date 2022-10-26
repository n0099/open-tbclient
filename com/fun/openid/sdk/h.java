package com.fun.openid.sdk;

import android.content.Context;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.openid.sdk.f;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class h implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.fun.openid.sdk.f
    public void a(Context context, f.a aVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, aVar) == null) {
            if (n.b != null && n.a != null) {
                z = true;
            } else {
                z = false;
            }
            String str = null;
            if (!z) {
                if (FunOpenIDSdk.isLogEnabled()) {
                    Log.e(FunOpenIDSdk.TAG, "当前设备不支持获取OAID");
                }
                aVar.a(false, null);
                return;
            }
            Method method = n.c;
            Object obj = n.a;
            if (obj != null && method != null) {
                try {
                    Object invoke = method.invoke(obj, context);
                    if (invoke != null) {
                        str = (String) invoke;
                    }
                } catch (Exception e) {
                    Log.e("IdentifierManager", "invoke exception!", e);
                }
            }
            aVar.a(true, str);
        }
    }
}
