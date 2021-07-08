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
/* loaded from: classes6.dex */
public class ad extends ai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f39764a;

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
        this.f39764a = context;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo184a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "2" : (String) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            com.xiaomi.push.service.aq a2 = com.xiaomi.push.service.aq.a(this.f39764a);
            hx hxVar = new hx();
            hxVar.a(com.xiaomi.push.service.ar.a(a2, hl.f40289a));
            hxVar.b(com.xiaomi.push.service.ar.a(a2, hl.f40290b));
            ie ieVar = new ie("-1", false);
            ieVar.c(hp.p.f509a);
            ieVar.a(ip.a(hxVar));
            an.a(this.f39764a).a((an) ieVar, hf.f40258i, (hs) null);
        }
    }
}
