package com.vivo.push.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
/* loaded from: classes10.dex */
public class c extends com.vivo.push.y {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f76860a;

    /* renamed from: b  reason: collision with root package name */
    public String f76861b;

    /* renamed from: c  reason: collision with root package name */
    public long f76862c;

    /* renamed from: d  reason: collision with root package name */
    public int f76863d;

    /* renamed from: e  reason: collision with root package name */
    public int f76864e;

    /* renamed from: f  reason: collision with root package name */
    public String f76865f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(int i2, String str, String str2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str, str2};
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
        this.f76862c = -1L;
        this.f76863d = -1;
        this.f76860a = str;
        this.f76861b = str2;
    }

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f76864e = i2;
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.f76860a = str;
        }
    }

    @Override // com.vivo.push.y
    public void c(com.vivo.push.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            aVar.a(IAdRequestParam.REQ_ID, this.f76860a);
            aVar.a("package_name", this.f76861b);
            aVar.a(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, 293L);
            aVar.a("PUSH_APP_STATUS", this.f76863d);
            if (TextUtils.isEmpty(this.f76865f)) {
                return;
            }
            aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f76865f);
        }
    }

    @Override // com.vivo.push.y
    public void d(com.vivo.push.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.f76860a = aVar.a(IAdRequestParam.REQ_ID);
            this.f76861b = aVar.a("package_name");
            this.f76862c = aVar.b(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, 0L);
            this.f76863d = aVar.b("PUSH_APP_STATUS", 0);
            this.f76865f = aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
        }
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f76864e : invokeV.intValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f76865f = null;
        }
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f76860a : (String) invokeV.objValue;
    }

    @Override // com.vivo.push.y
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "BaseAppCommand" : (String) invokeV.objValue;
    }
}
