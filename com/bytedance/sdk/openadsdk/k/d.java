package com.bytedance.sdk.openadsdk.k;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.face.IHttpStack;
import com.bytedance.sdk.component.net.NetClient;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f68322a;

    /* renamed from: c  reason: collision with root package name */
    public static IHttpStack f68323c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f68324b;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.k.a.c f68325d;

    /* renamed from: e  reason: collision with root package name */
    public final NetClient f68326e;

    public d(Context context) {
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
        this.f68324b = context == null ? o.a() : context.getApplicationContext();
        this.f68326e = new NetClient.Builder().connectTimeout(10000L, TimeUnit.MILLISECONDS).readTimeout(10000L, TimeUnit.MILLISECONDS).writeTimeout(10000L, TimeUnit.MILLISECONDS).enableTNC(true).build();
    }

    public static IHttpStack a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f68323c : (IHttpStack) invokeV.objValue;
    }

    public static d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f68322a == null) {
                synchronized (d.class) {
                    if (f68322a == null) {
                        f68322a = new d(o.a());
                    }
                }
            }
            return f68322a;
        }
        return (d) invokeV.objValue;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && this.f68325d == null) {
            this.f68325d = new com.bytedance.sdk.openadsdk.k.a.c();
        }
    }

    public NetClient c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f68326e : (NetClient) invokeV.objValue;
    }

    public com.bytedance.sdk.openadsdk.k.a.c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            e();
            return this.f68325d;
        }
        return (com.bytedance.sdk.openadsdk.k.a.c) invokeV.objValue;
    }

    public static void a(IHttpStack iHttpStack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, iHttpStack) == null) {
            f68323c = iHttpStack;
        }
    }
}
