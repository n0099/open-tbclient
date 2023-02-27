package com.vivo.push.f;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.f.u;
import java.util.HashMap;
/* loaded from: classes8.dex */
public final class w implements u.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ v a;

    public w(v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = vVar;
    }

    @Override // com.vivo.push.f.u.a
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            long l = com.vivo.push.e.a().l();
            if (l < 1400 && l != 1340) {
                com.vivo.push.util.u.b("OnNotificationArrivedTask", "引擎版本太低，不支持正向展示功能，pushEngineSDKVersion：".concat(String.valueOf(l)));
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("srt", "1");
            hashMap.put("message_id", String.valueOf(this.a.b.f()));
            String a = com.vivo.push.d.a.a().e().a();
            if (!TextUtils.isEmpty(a)) {
                hashMap.put("app_id", a);
            }
            hashMap.put("type", "1");
            hashMap.put("dtp", "1");
            com.vivo.push.util.f.a(6L, hashMap);
        }
    }

    @Override // com.vivo.push.f.u.a
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("messageID", String.valueOf(this.a.b.f()));
            String a = com.vivo.push.d.a.a().e().a();
            if (!TextUtils.isEmpty(a)) {
                hashMap.put("remoteAppId", a);
            }
            com.vivo.push.util.f.a(2122L, hashMap);
        }
    }
}
