package com.ksad.lottie.c;

import android.util.JsonReader;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static com.ksad.lottie.model.d a(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        InterceptResult invokeLL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, jsonReader, dVar)) == null) {
            ArrayList arrayList = new ArrayList();
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            double d2 = 0.0d;
            double d3 = 0.0d;
            char c3 = 0;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                switch (nextName.hashCode()) {
                    case -1866931350:
                        if (nextName.equals("fFamily")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 119:
                        if (nextName.equals("w")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3173:
                        if (nextName.equals("ch")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3076010:
                        if (nextName.equals("data")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 3530753:
                        if (nextName.equals("size")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 109780401:
                        if (nextName.equals("style")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                if (c2 == 0) {
                    c3 = jsonReader.nextString().charAt(0);
                } else if (c2 == 1) {
                    d2 = jsonReader.nextDouble();
                } else if (c2 == 2) {
                    d3 = jsonReader.nextDouble();
                } else if (c2 == 3) {
                    str = jsonReader.nextString();
                } else if (c2 == 4) {
                    str2 = jsonReader.nextString();
                } else if (c2 != 5) {
                    jsonReader.skipValue();
                } else {
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if ("shapes".equals(jsonReader.nextName())) {
                            jsonReader.beginArray();
                            while (jsonReader.hasNext()) {
                                arrayList.add((com.ksad.lottie.model.content.j) g.a(jsonReader, dVar));
                            }
                            jsonReader.endArray();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                }
            }
            jsonReader.endObject();
            return new com.ksad.lottie.model.d(arrayList, c3, d2, d3, str, str2);
        }
        return (com.ksad.lottie.model.d) invokeLL.objValue;
    }
}
