package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public final class x implements c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f70411a = "SpCache";

    /* renamed from: b  reason: collision with root package name */
    public static String f70412b = "com.vivo.push.cache";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f70413c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(744178852, "Lcom/vivo/push/util/x;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(744178852, "Lcom/vivo/push/util/x;");
        }
    }

    public x() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.vivo.push.util.c
    public final boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            if (this.f70413c == null) {
                this.f70413c = context.getSharedPreferences(f70412b, 0);
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.vivo.push.util.c
    public final void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            SharedPreferences.Editor edit = this.f70413c.edit();
            if (edit != null) {
                edit.putString(str, str2);
                a.a(edit);
                String str3 = f70411a;
                p.d(str3, "putString by " + str);
                return;
            }
            String str4 = f70411a;
            p.b(str4, "putString error by " + str);
        }
    }

    @Override // com.vivo.push.util.c
    public final String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            String string = this.f70413c.getString(str, str2);
            String str3 = f70411a;
            p.d(str3, "getString " + str + " is " + string);
            return string;
        }
        return (String) invokeLL.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SharedPreferences.Editor edit = this.f70413c.edit();
            if (edit != null) {
                edit.clear();
                a.a(edit);
            }
            p.d(f70411a, "system cache is cleared");
        }
    }
}
