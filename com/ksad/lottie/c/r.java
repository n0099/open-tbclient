package com.ksad.lottie.c;

import android.util.JsonReader;
import android.util.JsonToken;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class r {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> List<com.ksad.lottie.e.a<T>> a(JsonReader jsonReader, com.ksad.lottie.d dVar, float f2, aj<T> ajVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{jsonReader, dVar, Float.valueOf(f2), ajVar})) == null) {
            ArrayList arrayList = new ArrayList();
            if (jsonReader.peek() == JsonToken.STRING) {
                dVar.a("Lottie doesn't support expressions.");
                return arrayList;
            }
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                char c2 = 65535;
                if (nextName.hashCode() == 107 && nextName.equals(Config.APP_KEY)) {
                    c2 = 0;
                }
                if (c2 != 0) {
                    jsonReader.skipValue();
                } else if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                    jsonReader.beginArray();
                    if (jsonReader.peek() == JsonToken.NUMBER) {
                        arrayList.add(q.a(jsonReader, dVar, f2, ajVar, false));
                    } else {
                        while (jsonReader.hasNext()) {
                            arrayList.add(q.a(jsonReader, dVar, f2, ajVar, true));
                        }
                    }
                    jsonReader.endArray();
                } else {
                    arrayList.add(q.a(jsonReader, dVar, f2, ajVar, false));
                }
            }
            jsonReader.endObject();
            a(arrayList);
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public static void a(List<? extends com.ksad.lottie.e.a<?>> list) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, list) == null) {
            int size = list.size();
            int i3 = 0;
            while (true) {
                i2 = size - 1;
                if (i3 >= i2) {
                    break;
                }
                i3++;
                list.get(i3).f33778e = Float.valueOf(list.get(i3).f33777d);
            }
            com.ksad.lottie.e.a<?> aVar = list.get(i2);
            if (aVar.f33774a == 0) {
                list.remove(aVar);
            }
        }
    }
}
