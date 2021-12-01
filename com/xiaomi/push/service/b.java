package com.xiaomi.push.service;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.Constants;
import com.xiaomi.push.ai;
import com.xiaomi.push.hf;
import com.xiaomi.push.ie;
import com.xiaomi.push.ip;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class b extends ai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ie a;

    /* renamed from: a  reason: collision with other field name */
    public WeakReference<XMPushService> f925a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f926a;

    public b(ie ieVar, WeakReference<XMPushService> weakReference, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ieVar, weakReference, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f926a = false;
        this.a = ieVar;
        this.f925a = weakReference;
        this.f926a = z;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo236a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Constants.VIA_REPORT_TYPE_DATALINE : (String) invokeV.objValue;
    }

    @Override // java.lang.Runnable
    public void run() {
        WeakReference<XMPushService> weakReference;
        XMPushService xMPushService;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (weakReference = this.f925a) == null || this.a == null || (xMPushService = weakReference.get()) == null) {
            return;
        }
        this.a.a(at.a());
        this.a.a(false);
        com.xiaomi.channel.commonutils.logger.b.c("MoleInfo aw_ping : send aw_Ping msg " + this.a.m517a());
        try {
            String c2 = this.a.c();
            xMPushService.a(c2, ip.a(y.a(c2, this.a.b(), this.a, hf.f62975i)), this.f926a);
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.d("MoleInfo aw_ping : send help app ping error" + e2.toString());
        }
    }
}
