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
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public Class<?> f115a;

    /* renamed from: a  reason: collision with other field name */
    public Object f116a;

    /* renamed from: a  reason: collision with other field name */
    public Method f117a;
    public Method b;
    public Method c;
    public Method d;

    public av(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f117a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.a = context;
        a(context);
    }

    private String a(Context context, Method method) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, context, method)) == null) {
            Object obj = this.f116a;
            if (obj == null || method == null) {
                return null;
            }
            try {
                Object invoke = method.invoke(obj, context);
                if (invoke != null) {
                    return (String) invoke;
                }
                return null;
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a("miui invoke error", e);
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
            try {
                Class<?> a = t.a(context, "com.android.id.impl.IdProviderImpl");
                this.f115a = a;
                this.f116a = a.newInstance();
                this.f117a = this.f115a.getMethod("getUDID", Context.class);
                this.b = this.f115a.getMethod("getOAID", Context.class);
                this.c = this.f115a.getMethod("getVAID", Context.class);
                this.d = this.f115a.getMethod("getAAID", Context.class);
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.a("miui load class error", e);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m191a(Context context) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.f115a == null || this.f116a == null) ? false : true : invokeV.booleanValue;
    }

    @Override // com.xiaomi.push.ar
    /* renamed from: b */
    public String mo188b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? a(this.a, this.b) : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.ar
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? a(this.a, this.c) : (String) invokeV.objValue;
    }

    @Override // com.xiaomi.push.ar
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? a(this.a, this.d) : (String) invokeV.objValue;
    }
}
