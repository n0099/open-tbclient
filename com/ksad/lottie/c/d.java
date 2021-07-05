package com.ksad.lottie.c;

import android.util.JsonReader;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes7.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static com.ksad.lottie.model.a.b a(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, jsonReader, dVar)) == null) ? a(jsonReader, dVar, true) : (com.ksad.lottie.model.a.b) invokeLL.objValue;
    }

    public static com.ksad.lottie.model.a.b a(JsonReader jsonReader, com.ksad.lottie.d dVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65537, null, jsonReader, dVar, z)) == null) {
            return new com.ksad.lottie.model.a.b(a(jsonReader, z ? com.ksad.lottie.d.f.a() : 1.0f, dVar, i.f33728a));
        }
        return (com.ksad.lottie.model.a.b) invokeLLZ.objValue;
    }

    public static com.ksad.lottie.model.a.c a(JsonReader jsonReader, com.ksad.lottie.d dVar, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, jsonReader, dVar, i2)) == null) ? new com.ksad.lottie.model.a.c(a(jsonReader, dVar, new l(i2))) : (com.ksad.lottie.model.a.c) invokeLLI.objValue;
    }

    @Nullable
    public static <T> List<com.ksad.lottie.e.a<T>> a(JsonReader jsonReader, float f2, com.ksad.lottie.d dVar, aj<T> ajVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{jsonReader, Float.valueOf(f2), dVar, ajVar})) == null) ? r.a(jsonReader, dVar, f2, ajVar) : (List) invokeCommon.objValue;
    }

    @Nullable
    public static <T> List<com.ksad.lottie.e.a<T>> a(JsonReader jsonReader, com.ksad.lottie.d dVar, aj<T> ajVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65540, null, jsonReader, dVar, ajVar)) == null) ? r.a(jsonReader, dVar, 1.0f, ajVar) : (List) invokeLLL.objValue;
    }

    public static com.ksad.lottie.model.a.d b(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, jsonReader, dVar)) == null) ? new com.ksad.lottie.model.a.d(a(jsonReader, dVar, o.f33730a)) : (com.ksad.lottie.model.a.d) invokeLL.objValue;
    }

    public static com.ksad.lottie.model.a.f c(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, jsonReader, dVar)) == null) ? new com.ksad.lottie.model.a.f(a(jsonReader, com.ksad.lottie.d.f.a(), dVar, y.f33735a)) : (com.ksad.lottie.model.a.f) invokeLL.objValue;
    }

    public static com.ksad.lottie.model.a.g d(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, jsonReader, dVar)) == null) ? new com.ksad.lottie.model.a.g(a(jsonReader, dVar, ac.f33724a)) : (com.ksad.lottie.model.a.g) invokeLL.objValue;
    }

    public static com.ksad.lottie.model.a.h e(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, jsonReader, dVar)) == null) ? new com.ksad.lottie.model.a.h(a(jsonReader, com.ksad.lottie.d.f.a(), dVar, ad.f33725a)) : (com.ksad.lottie.model.a.h) invokeLL.objValue;
    }

    public static com.ksad.lottie.model.a.j f(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, jsonReader, dVar)) == null) ? new com.ksad.lottie.model.a.j(a(jsonReader, dVar, h.f33727a)) : (com.ksad.lottie.model.a.j) invokeLL.objValue;
    }

    public static com.ksad.lottie.model.a.a g(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, jsonReader, dVar)) == null) ? new com.ksad.lottie.model.a.a(a(jsonReader, dVar, f.f33726a)) : (com.ksad.lottie.model.a.a) invokeLL.objValue;
    }
}
