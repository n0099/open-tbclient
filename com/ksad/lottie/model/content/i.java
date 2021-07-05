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
public class i implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f33938a;

    /* renamed from: b  reason: collision with root package name */
    public final Path.FillType f33939b;

    /* renamed from: c  reason: collision with root package name */
    public final String f33940c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final com.ksad.lottie.model.a.a f33941d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final com.ksad.lottie.model.a.d f33942e;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.ksad.lottie.model.a.a aVar, @Nullable com.ksad.lottie.model.a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z), fillType, aVar, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33940c = str;
        this.f33938a = z;
        this.f33939b = fillType;
        this.f33941d = aVar;
        this.f33942e = dVar;
    }

    @Override // com.ksad.lottie.model.content.b
    public com.ksad.lottie.a.a.b a(com.ksad.lottie.f fVar, com.ksad.lottie.model.layer.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fVar, aVar)) == null) ? new com.ksad.lottie.a.a.f(fVar, aVar, this) : (com.ksad.lottie.a.a.b) invokeLL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f33940c : (String) invokeV.objValue;
    }

    @Nullable
    public com.ksad.lottie.model.a.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f33941d : (com.ksad.lottie.model.a.a) invokeV.objValue;
    }

    @Nullable
    public com.ksad.lottie.model.a.d c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f33942e : (com.ksad.lottie.model.a.d) invokeV.objValue;
    }

    public Path.FillType d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f33939b : (Path.FillType) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return "ShapeFill{color=, fillEnabled=" + this.f33938a + '}';
        }
        return (String) invokeV.objValue;
    }
}
