package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.ai;
import com.xiaomi.push.hf;
import com.xiaomi.push.hl;
import com.xiaomi.push.hp;
import com.xiaomi.push.hs;
import com.xiaomi.push.hx;
import com.xiaomi.push.ie;
import com.xiaomi.push.ip;
/* loaded from: classes4.dex */
public class ad extends ai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public ad(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo236a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "2" : (String) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            com.xiaomi.push.service.aq a = com.xiaomi.push.service.aq.a(this.a);
            hx hxVar = new hx();
            hxVar.a(com.xiaomi.push.service.ar.a(a, hl.a));
            hxVar.b(com.xiaomi.push.service.ar.a(a, hl.f63590b));
            ie ieVar = new ie("-1", false);
            ieVar.c(hp.p.f514a);
            ieVar.a(ip.a(hxVar));
            an.a(this.a).a((an) ieVar, hf.f63556i, (hs) null);
        }
    }
}
