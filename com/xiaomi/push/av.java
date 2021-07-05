package com.xiaomi.push;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes8.dex */
public class av implements ar {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f42846a;

    /* renamed from: a  reason: collision with other field name */
    public Class<?> f134a;

    /* renamed from: a  reason: collision with other field name */
    public Object f135a;

    /* renamed from: a  reason: collision with other field name */
    public Method f136a;

    /* renamed from: b  reason: collision with root package name */
    public Method f42847b;

    /* renamed from: c  reason: collision with root package name */
    public Method f42848c;

    /* renamed from: d  reason: collision with root package name */
    public Method f42849d;

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
        this.f136a = null;
        this.f42847b = null;
        this.f42848c = null;
        this.f42849d = null;
        this.f42846a = context;
        a(context);
    }

    private String a(Context context, Method method) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, context, method)) == null) {
            Object obj = this.f135a;
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
                this.f134a = a2;
                this.f135a = a2.newInstance();
                this.f136a = this.f134a.getMethod("getUDID", Context.class);
                this.f42847b = this.f134a.getMethod("getOAID", Context.class);
                this.f42848c = this.f134a.getMethod("getVAID", Context.class);
                this.f42849d = this.f134a.getMethod("getAAID", Context.class);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a("miui load class error", e2);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m152a(Context context) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f134a == null || this.f135a == null) ? false : true : invokeV.booleanValue;
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo149b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? a(this.f42846a, this.f42847b) : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? a(this.f42846a, this.f42848c) : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? a(this.f42846a, this.f42849d) : (String) invokeV.objValue;
    }
}
