package com.fun.openid.sdk;

import android.content.Context;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.openid.sdk.e;
import com.fun.openid.sdk.f;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
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
            if (!((m.f32970b == null || m.f32969a == null) ? false : true)) {
                if (FunOpenIDSdk.isLogEnabled()) {
                    Log.e(FunOpenIDSdk.TAG, "当前设备不支持获取OAID");
                }
                ((e.a) aVar).a(false, null);
                return;
            }
            Method method = m.f32971c;
            Object obj = m.f32969a;
            if (obj != null && method != null) {
                try {
                    Object invoke = method.invoke(obj, context);
                    if (invoke != null) {
                        str = (String) invoke;
                    }
                } catch (Exception e2) {
                    Log.e("IdentifierManager", "invoke exception!", e2);
                }
            }
            ((e.a) aVar).a(true, str);
        }
    }
}
