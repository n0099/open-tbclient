package com.ksad.lottie.c;

import android.util.JsonReader;
import android.util.JsonToken;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static com.ksad.lottie.a.b.h a(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, jsonReader, dVar)) == null) {
            return new com.ksad.lottie.a.b.h(dVar, q.a(jsonReader, dVar, com.ksad.lottie.d.f.a(), x.f33734a, jsonReader.peek() == JsonToken.BEGIN_OBJECT));
        }
        return (com.ksad.lottie.a.b.h) invokeLL.objValue;
    }
}
