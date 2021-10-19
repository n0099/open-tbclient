package com.fun.openid.sdk;

import android.content.Context;
import android.net.Uri;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.openid.sdk.f;
/* loaded from: classes9.dex */
public class m implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public m() {
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
            q.a(context).getClass();
            String str = null;
            if (!q.f70397b) {
                FunOpenIDSdk.isLogEnabled();
                aVar.a(false, null);
                return;
            }
            q a2 = q.a(context);
            a2.getClass();
            if (q.f70397b) {
                String str2 = q.f70403h;
                if (str2 != null) {
                    str = str2;
                } else {
                    a2.a(0, null);
                    if (q.f70398c == null) {
                        Context context2 = q.f70396a;
                        q.f70398c = new s(q.f70404i, 0, null);
                        context2.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, q.f70398c);
                    }
                    str = q.f70403h;
                }
            }
            aVar.a(true, str);
        }
    }
}
