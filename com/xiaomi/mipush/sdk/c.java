package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.baidu.ar.pose.PoseAR;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.dy;
import com.xiaomi.push.ed;
import com.xiaomi.push.eh;
import com.xiaomi.push.hj;
import com.xiaomi.push.ht;
import com.xiaomi.push.hw;
import com.xiaomi.push.ii;
import com.xiaomi.push.service.bd;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class c implements eh {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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
            iiVar.b(ed.a(context).m302a());
            iiVar.d(ed.a(context).b());
            iiVar.c(ht.I.f498a);
            iiVar.a(bd.a());
            iiVar.f637a = hashMap;
            ao.a(context).a((ao) iiVar, hj.i, true, (hw) null, true);
            com.xiaomi.channel.commonutils.logger.b.m84a("MoleInfo：\u3000send data in app layer");
        }
    }

    @Override // com.xiaomi.push.eh
    public void b(Context context, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, hashMap) == null) {
            MiTinyDataClient.upload("category_awake_app", "wake_up_app", 1L, dy.a(hashMap));
            com.xiaomi.channel.commonutils.logger.b.m84a("MoleInfo：\u3000send data in app layer");
        }
    }

    @Override // com.xiaomi.push.eh
    public void c(Context context, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, context, hashMap) == null) {
            com.xiaomi.channel.commonutils.logger.b.m84a("MoleInfo：\u3000" + dy.b(hashMap));
            String str = hashMap.get("awake_info");
            if (String.valueOf(1007).equals(hashMap.get(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY))) {
                o.a(context, str);
            }
        }
    }
}
