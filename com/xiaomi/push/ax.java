package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes6.dex */
public class ax implements ar {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile ax f40137a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f137a;

    /* renamed from: a  reason: collision with other field name */
    public ar f138a;

    public ax(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f138a = aw.a(context);
        this.f137a = aw.f40136a;
        com.xiaomi.channel.commonutils.logger.b.m70a("create id manager is: " + this.f137a);
    }

    public static ax a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f40137a == null) {
                synchronized (ax.class) {
                    if (f40137a == null) {
                        f40137a = new ax(context.getApplicationContext());
                    }
                }
            }
            return f40137a;
        }
        return (ax) invokeL.objValue;
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) ? str == null ? "" : str : (String) invokeL.objValue;
    }

    private String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) ? TextUtils.isEmpty(str) ? "" : str.length() > 5 ? str.substring(str.length() - 5) : str : (String) invokeL.objValue;
    }

    @Override // com.xiaomi.push.ar
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a(this.f138a.a()) : (String) invokeV.objValue;
    }

    public void a(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) || map == null) {
            return;
        }
        String a2 = a();
        if (!TextUtils.isEmpty(a2)) {
            map.put("udid", a2);
        }
        String mo149b = mo149b();
        if (!TextUtils.isEmpty(mo149b)) {
            map.put("oaid", mo149b);
        }
        String c2 = c();
        if (!TextUtils.isEmpty(c2)) {
            map.put("vaid", c2);
        }
        String d2 = d();
        if (!TextUtils.isEmpty(d2)) {
            map.put("aaid", d2);
        }
        map.put("oaid_type", String.valueOf(this.f137a));
    }

    @Override // com.xiaomi.push.ar
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f138a.m151a() : invokeV.booleanValue;
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo149b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? a(this.f138a.mo149b()) : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? a(this.f138a.c()) : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? a(this.f138a.d()) : (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return "t:" + this.f137a + " s:" + a() + " d:" + b(a()) + " | " + b(mo149b()) + " | " + b(c()) + " | " + b(d());
        }
        return (String) invokeV.objValue;
    }
}
