package com.ksad.lottie.model.content;

import android.graphics.Path;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class d implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final GradientType f33909a;

    /* renamed from: b  reason: collision with root package name */
    public final Path.FillType f33910b;

    /* renamed from: c  reason: collision with root package name */
    public final com.ksad.lottie.model.a.c f33911c;

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.a.d f33912d;

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.f f33913e;

    /* renamed from: f  reason: collision with root package name */
    public final com.ksad.lottie.model.a.f f33914f;

    /* renamed from: g  reason: collision with root package name */
    public final String f33915g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f33916h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final com.ksad.lottie.model.a.b f33917i;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.ksad.lottie.model.a.c cVar, com.ksad.lottie.model.a.d dVar, com.ksad.lottie.model.a.f fVar, com.ksad.lottie.model.a.f fVar2, com.ksad.lottie.model.a.b bVar, com.ksad.lottie.model.a.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, gradientType, fillType, cVar, dVar, fVar, fVar2, bVar, bVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33909a = gradientType;
        this.f33910b = fillType;
        this.f33911c = cVar;
        this.f33912d = dVar;
        this.f33913e = fVar;
        this.f33914f = fVar2;
        this.f33915g = str;
        this.f33916h = bVar;
        this.f33917i = bVar2;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fVar, aVar)) == null) ? new com.ksad.lottie.a.a.g(fVar, aVar, this) : (com.ksad.lottie.a.a.b) invokeLL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33915g : (String) invokeV.objValue;
    }

    public GradientType b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33909a : (GradientType) invokeV.objValue;
    }

    public Path.FillType c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33910b : (Path.FillType) invokeV.objValue;
    }

    public com.ksad.lottie.model.a.c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33911c : (com.ksad.lottie.model.a.c) invokeV.objValue;
    }

    public com.ksad.lottie.model.a.d e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f33912d : (com.ksad.lottie.model.a.d) invokeV.objValue;
    }

    public com.ksad.lottie.model.a.f f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f33913e : (com.ksad.lottie.model.a.f) invokeV.objValue;
    }

    public com.ksad.lottie.model.a.f g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f33914f : (com.ksad.lottie.model.a.f) invokeV.objValue;
    }
}
