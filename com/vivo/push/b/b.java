package com.vivo.push.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
/* loaded from: classes10.dex */
public final class b extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f76322a;

    /* renamed from: b  reason: collision with root package name */
    public String f76323b;

    /* renamed from: c  reason: collision with root package name */
    public String f76324c;

    /* renamed from: d  reason: collision with root package name */
    public String f76325d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(boolean z, String str) {
        super(z ? 2006 : 2007, null, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.c(aVar);
            aVar.a("sdk_clients", this.f76322a);
            aVar.a(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, 293L);
            aVar.a("BaseAppCommand.EXTRA_APPID", this.f76324c);
            aVar.a("BaseAppCommand.EXTRA_APPKEY", this.f76323b);
            aVar.a("PUSH_REGID", this.f76325d);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f76324c = null;
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f76323b = null;
        }
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "AppCommand:" + b();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            super.d(aVar);
            this.f76322a = aVar.a("sdk_clients");
            this.f76324c = aVar.a("BaseAppCommand.EXTRA_APPID");
            this.f76323b = aVar.a("BaseAppCommand.EXTRA_APPKEY");
            this.f76325d = aVar.a("PUSH_REGID");
        }
    }
}
