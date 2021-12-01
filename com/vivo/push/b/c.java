package com.vivo.push.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c extends com.vivo.push.y {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f62433b;

    /* renamed from: c  reason: collision with root package name */
    public long f62434c;

    /* renamed from: d  reason: collision with root package name */
    public int f62435d;

    /* renamed from: e  reason: collision with root package name */
    public int f62436e;

    /* renamed from: f  reason: collision with root package name */
    public String f62437f;

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
        this.f62434c = -1L;
        this.f62435d = -1;
        this.a = str;
        this.f62433b = str2;
    }

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f62436e = i2;
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.a = str;
        }
    }

    @Override // com.vivo.push.y
    public void c(com.vivo.push.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            aVar.a("req_id", this.a);
            aVar.a("package_name", this.f62433b);
            aVar.a("sdk_version", 293L);
            aVar.a("PUSH_APP_STATUS", this.f62435d);
            if (TextUtils.isEmpty(this.f62437f)) {
                return;
            }
            aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f62437f);
        }
    }

    @Override // com.vivo.push.y
    public void d(com.vivo.push.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            this.a = aVar.a("req_id");
            this.f62433b = aVar.a("package_name");
            this.f62434c = aVar.b("sdk_version", 0L);
            this.f62435d = aVar.b("PUSH_APP_STATUS", 0);
            this.f62437f = aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
        }
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f62436e : invokeV.intValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f62437f = null;
        }
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    @Override // com.vivo.push.y
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "BaseAppCommand" : (String) invokeV.objValue;
    }
}
