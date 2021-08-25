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
/* loaded from: classes10.dex */
public class cc extends XMPushService.i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ XMPushService f78016a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f951a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ byte[] f952a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f78017b;

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
        this.f78016a = xMPushService;
        this.f78017b = i3;
        this.f952a = bArr;
        this.f951a = str;
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
            m.m634a((Context) this.f78016a);
            av.a().m607a("5");
            com.xiaomi.push.ab.a(this.f78017b);
            fmVar = this.f78016a.f848a;
            fmVar.c(fm.a());
            this.f78016a.a(this.f952a, this.f951a);
        }
    }
}
