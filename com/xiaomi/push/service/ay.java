package com.xiaomi.push.service;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.av;
/* loaded from: classes10.dex */
public class ay extends XMPushService.i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ av.b.c f78503a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay(av.b.c cVar, int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f78503a = cVar;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "check peer job" : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            av a2 = av.a();
            av.b bVar = this.f78503a.f922a;
            if (a2.a(bVar.f78490g, bVar.f918b).f909a == null) {
                XMPushService xMPushService = this.f78503a.f78497b.f911a;
                av.b bVar2 = this.f78503a.f922a;
                xMPushService.a(bVar2.f78490g, bVar2.f918b, 2, null, null);
            }
        }
    }
}
