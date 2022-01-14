package com.vivo.push.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c extends com.vivo.push.o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f60635b;

    /* renamed from: c  reason: collision with root package name */
    public long f60636c;

    /* renamed from: d  reason: collision with root package name */
    public int f60637d;

    /* renamed from: e  reason: collision with root package name */
    public int f60638e;

    /* renamed from: f  reason: collision with root package name */
    public String f60639f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(int i2, String str) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), str};
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
        this.f60636c = -1L;
        this.f60637d = -1;
        this.a = null;
        this.f60635b = str;
    }

    public final void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f60638e = i2;
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.a = str;
        }
    }

    @Override // com.vivo.push.o
    public void c(com.vivo.push.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            aVar.a("req_id", this.a);
            aVar.a("package_name", this.f60635b);
            aVar.a("sdk_version", 800L);
            aVar.a("PUSH_APP_STATUS", this.f60637d);
            if (TextUtils.isEmpty(this.f60639f)) {
                return;
            }
            aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f60639f);
        }
    }

    @Override // com.vivo.push.o
    public void d(com.vivo.push.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.a = aVar.a("req_id");
            this.f60635b = aVar.a("package_name");
            this.f60636c = aVar.b("sdk_version", 0L);
            this.f60637d = aVar.b("PUSH_APP_STATUS", 0);
            this.f60639f = aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
        }
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f60638e : invokeV.intValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f60639f = null;
        }
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (String) invokeV.objValue;
    }

    @Override // com.vivo.push.o
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "BaseAppCommand" : (String) invokeV.objValue;
    }

    public final int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (this.f60637d == -1) {
                String str = this.f60635b;
                if (TextUtils.isEmpty(str)) {
                    com.vivo.push.util.p.a("BaseAppCommand", "pkg name is null");
                    String a = a();
                    if (TextUtils.isEmpty(a)) {
                        com.vivo.push.util.p.a("BaseAppCommand", "src is null");
                        return -1;
                    }
                    str = a;
                }
                this.f60637d = com.vivo.push.util.t.b(context, str);
                if (!TextUtils.isEmpty(this.f60639f)) {
                    this.f60637d = 2;
                }
            }
            return this.f60637d;
        }
        return invokeL.intValue;
    }
}
