package com.xiaomi.push.service;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.dy;
import com.xiaomi.push.ed;
import com.xiaomi.push.eh;
import com.xiaomi.push.hg;
import com.xiaomi.push.hj;
import com.xiaomi.push.ht;
import com.xiaomi.push.ii;
import com.xiaomi.push.it;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class bm implements eh {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bm() {
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

    @Override // com.xiaomi.push.eh
    public void a(Context context, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, hashMap) == null) {
            ii iiVar = new ii();
            iiVar.b(ed.a(context).m307a());
            iiVar.d(ed.a(context).b());
            iiVar.c(ht.I.f505a);
            iiVar.a(bd.a());
            iiVar.f644a = hashMap;
            byte[] a = it.a(ah.a(iiVar.c(), iiVar.b(), iiVar, hj.i));
            if (!(context instanceof XMPushService)) {
                com.xiaomi.channel.commonutils.logger.b.m89a("MoleInfo : context is not correct in pushLayer " + iiVar.m480a());
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m89a("MoleInfo : send data directly in pushLayer " + iiVar.m480a());
            ((XMPushService) context).a(context.getPackageName(), a, true);
        }
    }

    @Override // com.xiaomi.push.eh
    public void b(Context context, HashMap<String, String> hashMap) {
        hg a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, hashMap) == null) || (a = hg.a(context)) == null) {
            return;
        }
        a.a("category_awake_app", "wake_up_app", 1L, dy.a(hashMap));
    }

    @Override // com.xiaomi.push.eh
    public void c(Context context, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, hashMap) == null) {
            com.xiaomi.channel.commonutils.logger.b.m89a("MoleInfo：\u3000" + dy.b(hashMap));
        }
    }
}
