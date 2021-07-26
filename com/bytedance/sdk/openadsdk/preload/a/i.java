package com.bytedance.sdk.openadsdk.preload.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public final class i extends l implements Iterable<l> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<l> f32262a;

    public i() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32262a = new ArrayList();
    }

    public void a(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
            if (lVar == null) {
                lVar = n.f32263a;
            }
            this.f32262a.add(lVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f32262a.size() == 1) {
                return this.f32262a.get(0).b();
            }
            throw new IllegalStateException();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public double c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f32262a.size() == 1) {
                return this.f32262a.get(0).c();
            }
            throw new IllegalStateException();
        }
        return invokeV.doubleValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f32262a.size() == 1) {
                return this.f32262a.get(0).d();
            }
            throw new IllegalStateException();
        }
        return invokeV.longValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f32262a.size() == 1) {
                return this.f32262a.get(0).e();
            }
            throw new IllegalStateException();
        }
        return invokeV.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) ? obj == this || ((obj instanceof i) && ((i) obj).f32262a.equals(this.f32262a)) : invokeL.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f32262a.size() == 1) {
                return this.f32262a.get(0).f();
            }
            throw new IllegalStateException();
        }
        return invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f32262a.hashCode() : invokeV.intValue;
    }

    @Override // java.lang.Iterable
    public Iterator<l> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f32262a.iterator() : (Iterator) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public Number a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f32262a.size() == 1) {
                return this.f32262a.get(0).a();
            }
            throw new IllegalStateException();
        }
        return (Number) invokeV.objValue;
    }
}
