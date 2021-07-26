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
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f31652a;

    /* renamed from: c  reason: collision with root package name */
    public static IHttpStack f31653c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f31654b;

    /* renamed from: d  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.k.a.c f31655d;

    /* renamed from: e  reason: collision with root package name */
    public final NetClient f31656e;

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
        this.f31654b = context == null ? o.a() : context.getApplicationContext();
        this.f31656e = new NetClient.Builder().connectTimeout(10000L, TimeUnit.MILLISECONDS).readTimeout(10000L, TimeUnit.MILLISECONDS).writeTimeout(10000L, TimeUnit.MILLISECONDS).enableTNC(true).build();
    }

    public static IHttpStack a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? f31653c : (IHttpStack) invokeV.objValue;
    }

    public static d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f31652a == null) {
                synchronized (d.class) {
                    if (f31652a == null) {
                        f31652a = new d(o.a());
                    }
                }
            }
            return f31652a;
        }
        return (d) invokeV.objValue;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && this.f31655d == null) {
            this.f31655d = new com.bytedance.sdk.openadsdk.k.a.c();
        }
    }

    public NetClient c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f31656e : (NetClient) invokeV.objValue;
    }

    public com.bytedance.sdk.openadsdk.k.a.c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            e();
            return this.f31655d;
        }
        return (com.bytedance.sdk.openadsdk.k.a.c) invokeV.objValue;
    }

    public static void a(IHttpStack iHttpStack) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, iHttpStack) == null) {
            f31653c = iHttpStack;
        }
    }
}
