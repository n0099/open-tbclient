package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.baidu.ar.pose.PoseAR;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.dv;
import com.xiaomi.push.ea;
import com.xiaomi.push.ee;
import com.xiaomi.push.hf;
import com.xiaomi.push.hp;
import com.xiaomi.push.hs;
import com.xiaomi.push.ie;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class c implements ee {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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

    @Override // com.xiaomi.push.ee
    public void a(Context context, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, hashMap) == null) {
            ie ieVar = new ie();
            ieVar.b(ea.a(context).m287a());
            ieVar.d(ea.a(context).b());
            ieVar.c(hp.I.f513a);
            ieVar.a(com.xiaomi.push.service.at.a());
            ieVar.f654a = hashMap;
            an.a(context).a((an) ieVar, hf.f77389i, true, (hs) null, true);
            com.xiaomi.channel.commonutils.logger.b.m73a("MoleInfo：\u3000send data in app layer");
        }
    }

    @Override // com.xiaomi.push.ee
    public void b(Context context, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, hashMap) == null) {
            MiTinyDataClient.upload("category_awake_app", "wake_up_app", 1L, dv.a(hashMap));
            com.xiaomi.channel.commonutils.logger.b.m73a("MoleInfo：\u3000send data in app layer");
        }
    }

    @Override // com.xiaomi.push.ee
    public void c(Context context, HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, context, hashMap) == null) {
            com.xiaomi.channel.commonutils.logger.b.m73a("MoleInfo：\u3000" + dv.b(hashMap));
            String str = hashMap.get("awake_info");
            if (String.valueOf(1007).equals(hashMap.get(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY))) {
                o.a(context, str);
            }
        }
    }
}
