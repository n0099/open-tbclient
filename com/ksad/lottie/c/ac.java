package com.ksad.lottie.c;

import android.util.JsonReader;
import android.util.JsonToken;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class ac implements aj<com.ksad.lottie.e.d> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final ac f33724a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2130155417, "Lcom/ksad/lottie/c/ac;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2130155417, "Lcom/ksad/lottie/c/ac;");
                return;
            }
        }
        f33724a = new ac();
    }

    public ac() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.c.aj
    /* renamed from: a */
    public com.ksad.lottie.e.d b(JsonReader jsonReader, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048576, this, jsonReader, f2)) == null) {
            boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
            if (z) {
                jsonReader.beginArray();
            }
            float nextDouble = (float) jsonReader.nextDouble();
            float nextDouble2 = (float) jsonReader.nextDouble();
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            if (z) {
                jsonReader.endArray();
            }
            return new com.ksad.lottie.e.d((nextDouble / 100.0f) * f2, (nextDouble2 / 100.0f) * f2);
        }
        return (com.ksad.lottie.e.d) invokeLF.objValue;
    }
}
