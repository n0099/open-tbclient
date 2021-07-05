package com.ksad.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import androidx.appcompat.widget.SearchView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class aa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static com.ksad.lottie.model.content.f a(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, jsonReader, dVar)) == null) {
            String str = null;
            com.ksad.lottie.model.a.m<PointF, PointF> mVar = null;
            com.ksad.lottie.model.a.f fVar = null;
            com.ksad.lottie.model.a.b bVar = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                char c2 = 65535;
                int hashCode = nextName.hashCode();
                if (hashCode != 112) {
                    if (hashCode != 3519) {
                        if (hashCode != 114) {
                            if (hashCode == 115 && nextName.equals("s")) {
                                c2 = 2;
                            }
                        } else if (nextName.equals(com.baidu.mapsdkplatform.comapi.map.r.f7745a)) {
                            c2 = 3;
                        }
                    } else if (nextName.equals(SearchView.IME_OPTION_NO_MICROPHONE)) {
                        c2 = 0;
                    }
                } else if (nextName.equals("p")) {
                    c2 = 1;
                }
                if (c2 == 0) {
                    str = jsonReader.nextString();
                } else if (c2 == 1) {
                    mVar = a.b(jsonReader, dVar);
                } else if (c2 == 2) {
                    fVar = d.c(jsonReader, dVar);
                } else if (c2 != 3) {
                    jsonReader.skipValue();
                } else {
                    bVar = d.a(jsonReader, dVar);
                }
            }
            return new com.ksad.lottie.model.content.f(str, mVar, fVar, bVar);
        }
        return (com.ksad.lottie.model.content.f) invokeLL.objValue;
    }
}
