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
import com.vivo.push.util.aa;
/* loaded from: classes10.dex */
public class c extends com.vivo.push.o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public long c;
    public int d;
    public int e;
    public String f;
    public String g;
    public String h;

    @Override // com.vivo.push.o
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "BaseAppCommand" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(int i, String str) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = -1L;
        this.d = -1;
        this.a = null;
        this.b = str;
    }

    public final int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            if (this.d == -1) {
                String str = this.b;
                if (TextUtils.isEmpty(str)) {
                    com.vivo.push.util.u.a("BaseAppCommand", "pkg name is null");
                    String a = a();
                    if (TextUtils.isEmpty(a)) {
                        com.vivo.push.util.u.a("BaseAppCommand", "src is null");
                        return -1;
                    }
                    str = a;
                }
                this.d = aa.b(context, str);
                if (!TextUtils.isEmpty(this.f)) {
                    this.d = 2;
                }
            }
            return this.d;
        }
        return invokeL.intValue;
    }

    @Override // com.vivo.push.o
    public void c(com.vivo.push.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            aVar.a("req_id", this.a);
            aVar.a("package_name", this.b);
            aVar.a("sdk_version", 334L);
            aVar.a("PUSH_APP_STATUS", this.d);
            if (!TextUtils.isEmpty(this.f)) {
                aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f);
            }
            aVar.a("BaseAppCommand.EXTRA_APPID", this.h);
            aVar.a("BaseAppCommand.EXTRA_APPKEY", this.g);
        }
    }

    @Override // com.vivo.push.o
    public void d(com.vivo.push.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            this.a = aVar.a("req_id");
            this.b = aVar.a("package_name");
            this.c = aVar.b("sdk_version", 0L);
            this.d = aVar.b("PUSH_APP_STATUS", 0);
            this.f = aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
            this.h = aVar.a("BaseAppCommand.EXTRA_APPID");
            this.g = aVar.a("BaseAppCommand.EXTRA_APPKEY");
        }
    }

    public final void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.e = i;
        }
    }

    public final void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.a = str;
        }
    }

    public final void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.h = str;
        }
    }

    public final void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.g = str;
        }
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.f = null;
        }
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }
}
