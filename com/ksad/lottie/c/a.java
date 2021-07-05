package com.ksad.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static com.ksad.lottie.model.a.e a(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, jsonReader, dVar)) == null) {
            ArrayList arrayList = new ArrayList();
            if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    arrayList.add(w.a(jsonReader, dVar));
                }
                jsonReader.endArray();
                r.a(arrayList);
            } else {
                arrayList.add(new com.ksad.lottie.e.a(p.b(jsonReader, com.ksad.lottie.d.f.a())));
            }
            return new com.ksad.lottie.model.a.e(arrayList);
        }
        return (com.ksad.lottie.model.a.e) invokeLL.objValue;
    }

    public static com.ksad.lottie.model.a.m<PointF, PointF> b(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, jsonReader, dVar)) == null) {
            jsonReader.beginObject();
            com.ksad.lottie.model.a.e eVar = null;
            com.ksad.lottie.model.a.b bVar = null;
            com.ksad.lottie.model.a.b bVar2 = null;
            boolean z = false;
            while (jsonReader.peek() != JsonToken.END_OBJECT) {
                String nextName = jsonReader.nextName();
                char c2 = 65535;
                int hashCode = nextName.hashCode();
                if (hashCode != 107) {
                    if (hashCode != 120) {
                        if (hashCode == 121 && nextName.equals("y")) {
                            c2 = 2;
                        }
                    } else if (nextName.equals("x")) {
                        c2 = 1;
                    }
                } else if (nextName.equals(Config.APP_KEY)) {
                    c2 = 0;
                }
                if (c2 == 0) {
                    eVar = a(jsonReader, dVar);
                } else if (c2 != 1) {
                    if (c2 != 2) {
                        jsonReader.skipValue();
                    } else if (jsonReader.peek() == JsonToken.STRING) {
                        jsonReader.skipValue();
                        z = true;
                    } else {
                        bVar2 = d.a(jsonReader, dVar);
                    }
                } else if (jsonReader.peek() == JsonToken.STRING) {
                    jsonReader.skipValue();
                    z = true;
                } else {
                    bVar = d.a(jsonReader, dVar);
                }
            }
            jsonReader.endObject();
            if (z) {
                dVar.a("Lottie doesn't support expressions.");
            }
            return eVar != null ? eVar : new com.ksad.lottie.model.a.i(bVar, bVar2);
        }
        return (com.ksad.lottie.model.a.m) invokeLL.objValue;
    }
}
