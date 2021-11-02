package com.xiaomi.push.service;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.fw;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes2.dex */
public class bs extends XMPushService.i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f71477a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f948a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ byte[] f949a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bs(XMPushService xMPushService, int i2, String str, byte[] bArr) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xMPushService, Integer.valueOf(i2), str, bArr};
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
        this.f71477a = xMPushService;
        this.f948a = str;
        this.f949a = bArr;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "send mi push message" : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                y.a(this.f71477a, this.f948a, this.f949a);
            } catch (fw e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                this.f71477a.a(10, e2);
            }
        }
    }
}
