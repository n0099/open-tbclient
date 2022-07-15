package com.xiaomi.push.service;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.al;
import com.xiaomi.push.hj;
import com.xiaomi.push.ii;
import com.xiaomi.push.it;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class b extends al.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ii a;

    /* renamed from: a  reason: collision with other field name */
    public WeakReference<XMPushService> f1638a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1639a;

    public b(ii iiVar, WeakReference<XMPushService> weakReference, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iiVar, weakReference, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1639a = false;
        this.a = iiVar;
        this.f1638a = weakReference;
        this.f1639a = z;
    }

    @Override // com.xiaomi.push.al.a
    /* renamed from: a */
    public String mo1145a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "22" : (String) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        WeakReference<XMPushService> weakReference;
        XMPushService xMPushService;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (weakReference = this.f1638a) == null || this.a == null || (xMPushService = weakReference.get()) == null) {
            return;
        }
        this.a.a(bd.a());
        this.a.a(false);
        com.xiaomi.channel.commonutils.logger.b.c("MoleInfo aw_ping : send aw_Ping msg " + this.a.m1418a());
        try {
            String c = this.a.c();
            xMPushService.a(c, it.a(ah.a(c, this.a.b(), this.a, hj.i)), this.f1639a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("MoleInfo aw_ping : send help app ping error" + e.toString());
        }
    }
}
