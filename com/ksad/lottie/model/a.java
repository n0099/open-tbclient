package com.ksad.lottie.model;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final PointF f33842a;

    /* renamed from: b  reason: collision with root package name */
    public final PointF f33843b;

    /* renamed from: c  reason: collision with root package name */
    public final PointF f33844c;

    public a() {
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
        this.f33842a = new PointF();
        this.f33843b = new PointF();
        this.f33844c = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pointF, pointF2, pointF3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f33842a = pointF;
        this.f33843b = pointF2;
        this.f33844c = pointF3;
    }

    public PointF a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f33842a : (PointF) invokeV.objValue;
    }

    public void a(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.f33842a.set(f2, f3);
        }
    }

    public PointF b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33843b : (PointF) invokeV.objValue;
    }

    public void b(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.f33843b.set(f2, f3);
        }
    }

    public PointF c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33844c : (PointF) invokeV.objValue;
    }

    public void c(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.f33844c.set(f2, f3);
        }
    }
}
