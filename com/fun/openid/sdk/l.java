package com.fun.openid.sdk;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.openid.sdk.e;
import com.fun.openid.sdk.f;
/* loaded from: classes6.dex */
public class l implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public l() {
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
            p.a(context).getClass();
            String str = null;
            if (!p.f32675b) {
                if (FunOpenIDSdk.isLogEnabled()) {
                    Log.e(FunOpenIDSdk.TAG, "当前设备不支持获取OAID");
                }
                ((e.a) aVar).a(false, null);
                return;
            }
            p a2 = p.a(context);
            a2.getClass();
            if (p.f32675b) {
                String str2 = p.f32681h;
                if (str2 != null) {
                    str = str2;
                } else {
                    a2.a(0, null);
                    if (p.f32676c == null) {
                        Context context2 = p.f32674a;
                        p.f32676c = new q(p.f32682i, 0, null);
                        context2.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, p.f32676c);
                    }
                    str = p.f32681h;
                }
            }
            ((e.a) aVar).a(true, str);
        }
    }
}
