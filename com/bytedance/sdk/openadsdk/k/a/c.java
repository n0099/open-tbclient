package com.bytedance.sdk.openadsdk.k.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.image.ImageResponse;
import com.bytedance.sdk.component.image.b.e;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.e.t;
import com.bytedance.sdk.openadsdk.k.a.a;
/* loaded from: classes9.dex */
public class c extends a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f68316a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public t f68317b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-378033249, "Lcom/bytedance/sdk/openadsdk/k/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-378033249, "Lcom/bytedance/sdk/openadsdk/k/a/c;");
        }
    }

    public c() {
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

    private void a(ImageResponse imageResponse) {
        e httpTime;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, this, imageResponse) == null) && (httpTime = imageResponse.getHttpTime()) != null && d()) {
            if (imageResponse.isLocal()) {
                k.b("splashLoadAd", " GiftLoader doTask  缓存存在，直接返回缓存数据");
                f68316a = 1;
                a(true);
            } else {
                k.b("splashLoadAd", " GiftLoader doTask  缓存存在，直接返回缓存数据");
                f68316a = 2;
                a(false);
            }
            a(httpTime.a());
        }
    }

    private boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            t tVar = this.f68317b;
            return tVar != null && tVar.z();
        }
        return invokeV.booleanValue;
    }

    private void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) && d()) {
            long currentTimeMillis = System.currentTimeMillis();
            t tVar = this.f68317b;
            tVar.g(currentTimeMillis - tVar.t());
            this.f68317b.l(currentTimeMillis);
        }
    }

    public t c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f68317b : (t) invokeV.objValue;
    }

    private void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j2) == null) {
            this.f68317b.n(j2);
            t tVar = this.f68317b;
            tVar.h(j2 - tVar.v());
        }
    }

    private void a(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z) == null) && d()) {
            this.f68317b.a(z);
        }
    }

    public void a(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tVar) == null) {
            this.f68317b = tVar;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.k.a.a
    public void a(ImageResponse imageResponse, a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imageResponse, bVar) == null) {
            a(imageResponse);
            super.a(imageResponse, bVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.k.a.a
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e();
        }
    }
}
