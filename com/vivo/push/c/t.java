package com.vivo.push.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.restnet.http.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.c.r;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class t implements r.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ s a;

    public t(s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = sVar;
    }

    @Override // com.vivo.push.c.r.a
    public final void a() {
        Context context;
        Context context2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long l = com.vivo.push.e.a().l();
            if (l < 1400 && l != 1340) {
                com.vivo.push.util.p.b("OnNotificationArrivedTask", "引擎版本太低，不支持正向展示功能，pushEngineSDKVersion：".concat(String.valueOf(l)));
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(b.c.f31220e, "1");
            hashMap.put("message_id", String.valueOf(this.a.f59240b.f()));
            context = this.a.f59241c.a;
            context2 = this.a.f59241c.a;
            String b2 = com.vivo.push.util.aa.b(context, context2.getPackageName());
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("app_id", b2);
            }
            hashMap.put("type", "1");
            hashMap.put("dtp", "1");
            com.vivo.push.util.e.a(6L, hashMap);
        }
    }

    @Override // com.vivo.push.c.r.a
    public final void b() {
        Context context;
        Context context2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("messageID", String.valueOf(this.a.f59240b.f()));
            context = this.a.f59241c.a;
            context2 = this.a.f59241c.a;
            String b2 = com.vivo.push.util.aa.b(context, context2.getPackageName());
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("remoteAppId", b2);
            }
            com.vivo.push.util.e.a(2122L, hashMap);
        }
    }
}
