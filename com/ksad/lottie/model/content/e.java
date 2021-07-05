package com.ksad.lottie.model.content;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes7.dex */
public class e implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f33918a;

    /* renamed from: b  reason: collision with root package name */
    public final GradientType f33919b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.c f33920c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.a.d f33921d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.f f33922e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.model.a.f f33923f;

    /* renamed from: g  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f33924g;

    /* renamed from: h  reason: collision with root package name */
    public final ShapeStroke.LineCapType f33925h;

    /* renamed from: i  reason: collision with root package name */
    public final ShapeStroke.LineJoinType f33926i;
    public final float j;
    public final List<com.ksad.lottie.model.a.b> k;
    @Nullable
    public final com.ksad.lottie.model.a.b l;

    public e(String str, GradientType gradientType, com.ksad.lottie.model.a.c cVar, com.ksad.lottie.model.a.d dVar, com.ksad.lottie.model.a.f fVar, com.ksad.lottie.model.a.f fVar2, com.ksad.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f2, List<com.ksad.lottie.model.a.b> list, @Nullable com.ksad.lottie.model.a.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {str, gradientType, cVar, dVar, fVar, fVar2, bVar, lineCapType, lineJoinType, Float.valueOf(f2), list, bVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33918a = str;
        this.f33919b = gradientType;
        this.f33920c = cVar;
        this.f33921d = dVar;
        this.f33922e = fVar;
        this.f33923f = fVar2;
        this.f33924g = bVar;
        this.f33925h = lineCapType;
        this.f33926i = lineJoinType;
        this.j = f2;
        this.k = list;
        this.l = bVar2;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fVar, aVar)) == null) ? new com.ksad.lottie.a.a.h(fVar, aVar, this) : (com.ksad.lottie.a.a.b) invokeLL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33918a : (String) invokeV.objValue;
    }

    public GradientType b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33919b : (GradientType) invokeV.objValue;
    }

    public com.ksad.lottie.model.a.c c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33920c : (com.ksad.lottie.model.a.c) invokeV.objValue;
    }

    public com.ksad.lottie.model.a.d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33921d : (com.ksad.lottie.model.a.d) invokeV.objValue;
    }

    public com.ksad.lottie.model.a.f e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f33922e : (com.ksad.lottie.model.a.f) invokeV.objValue;
    }

    public com.ksad.lottie.model.a.f f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f33923f : (com.ksad.lottie.model.a.f) invokeV.objValue;
    }

    public com.ksad.lottie.model.a.b g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f33924g : (com.ksad.lottie.model.a.b) invokeV.objValue;
    }

    public ShapeStroke.LineCapType h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f33925h : (ShapeStroke.LineCapType) invokeV.objValue;
    }

    public ShapeStroke.LineJoinType i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f33926i : (ShapeStroke.LineJoinType) invokeV.objValue;
    }

    public List<com.ksad.lottie.model.a.b> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.k : (List) invokeV.objValue;
    }

    @Nullable
    public com.ksad.lottie.model.a.b k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.l : (com.ksad.lottie.model.a.b) invokeV.objValue;
    }

    public float l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.j : invokeV.floatValue;
    }
}
