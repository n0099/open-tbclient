package com.xiaomi.push.service;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.dv;
import com.xiaomi.push.ea;
import com.xiaomi.push.ee;
import com.xiaomi.push.hd;
import com.xiaomi.push.hf;
import com.xiaomi.push.hp;
import com.xiaomi.push.ie;
import com.xiaomi.push.ip;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class bb implements ee {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bb() {
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

    @Override // com.xiaomi.push.ee
    public void a(Context context, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, hashMap) == null) {
            ie ieVar = new ie();
            ieVar.b(ea.a(context).m322a());
            ieVar.d(ea.a(context).b());
            ieVar.c(hp.I.f490a);
            ieVar.a(at.a());
            ieVar.f631a = hashMap;
            byte[] a = ip.a(y.a(ieVar.c(), ieVar.b(), ieVar, hf.i));
            if (!(context instanceof XMPushService)) {
                com.xiaomi.channel.commonutils.logger.b.m108a("MoleInfo : context is not correct in pushLayer " + ieVar.m503a());
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m108a("MoleInfo : send data directly in pushLayer " + ieVar.m503a());
            ((XMPushService) context).a(context.getPackageName(), a, true);
        }
    }

    @Override // com.xiaomi.push.ee
    public void b(Context context, HashMap<String, String> hashMap) {
        hd a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, hashMap) == null) || (a = hd.a(context)) == null) {
            return;
        }
        a.a("category_awake_app", "wake_up_app", 1L, dv.a(hashMap));
    }

    @Override // com.xiaomi.push.ee
    public void c(Context context, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, hashMap) == null) {
            com.xiaomi.channel.commonutils.logger.b.m108a("MoleInfo：\u3000" + dv.b(hashMap));
        }
    }
}
