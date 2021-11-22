package com.xiaomi.push;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public class av implements ar {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f71600a;

    /* renamed from: a  reason: collision with other field name */
    public Class<?> f139a;

    /* renamed from: a  reason: collision with other field name */
    public Object f140a;

    /* renamed from: a  reason: collision with other field name */
    public Method f141a;

    /* renamed from: b  reason: collision with root package name */
    public Method f71601b;

    /* renamed from: c  reason: collision with root package name */
    public Method f71602c;

    /* renamed from: d  reason: collision with root package name */
    public Method f71603d;

    public av(Context context) {
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
        this.f141a = null;
        this.f71601b = null;
        this.f71602c = null;
        this.f71603d = null;
        this.f71600a = context;
        a(context);
    }

    private String a(Context context, Method method) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, context, method)) == null) {
            Object obj = this.f140a;
            if (obj == null || method == null) {
                return null;
            }
            try {
                Object invoke = method.invoke(obj, context);
                if (invoke != null) {
                    return (String) invoke;
                }
                return null;
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a("miui invoke error", e2);
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
            try {
                Class<?> a2 = t.a(context, "com.android.id.impl.IdProviderImpl");
                this.f139a = a2;
                this.f140a = a2.newInstance();
                this.f141a = this.f139a.getMethod("getUDID", Context.class);
                this.f71601b = this.f139a.getMethod("getOAID", Context.class);
                this.f71602c = this.f139a.getMethod("getVAID", Context.class);
                this.f71603d = this.f139a.getMethod("getAAID", Context.class);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a("miui load class error", e2);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m155a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? "com.xiaomi.xmsf".equals(context.getPackageName()) : invokeL.booleanValue;
    }

    @Override // com.xiaomi.push.ar
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.ar
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f139a == null || this.f140a == null) ? false : true : invokeV.booleanValue;
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo152b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? a(this.f71600a, this.f71601b) : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? a(this.f71600a, this.f71602c) : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? a(this.f71600a, this.f71603d) : (String) invokeV.objValue;
    }
}
