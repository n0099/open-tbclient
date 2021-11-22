package com.xiaomi.push.service;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.fm;
import com.xiaomi.push.service.XMPushService;
/* loaded from: classes2.dex */
public class cc extends XMPushService.i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f72407a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f952a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ byte[] f953a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f72408b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cc(XMPushService xMPushService, int i2, int i3, byte[] bArr, String str) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xMPushService, Integer.valueOf(i2), Integer.valueOf(i3), bArr, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72407a = xMPushService;
        this.f72408b = i3;
        this.f953a = bArr;
        this.f952a = str;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "clear account cache." : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.service.XMPushService.i
    public void a() {
        fm fmVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            m.m634a((Context) this.f72407a);
            av.a().m607a("5");
            com.xiaomi.push.ab.a(this.f72408b);
            fmVar = this.f72407a.f849a;
            fmVar.c(fm.a());
            this.f72407a.a(this.f953a, this.f952a);
        }
    }
}
