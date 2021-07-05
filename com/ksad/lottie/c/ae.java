package com.ksad.lottie.c;

import android.graphics.Path;
import android.util.JsonReader;
import androidx.appcompat.widget.SearchView;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ae {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static com.ksad.lottie.model.content.i a(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, jsonReader, dVar)) == null) {
            String str = null;
            com.ksad.lottie.model.a.a aVar = null;
            com.ksad.lottie.model.a.d dVar2 = null;
            int i2 = 1;
            boolean z = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                char c2 = 65535;
                int hashCode = nextName.hashCode();
                if (hashCode != -396065730) {
                    if (hashCode != 99) {
                        if (hashCode != 111) {
                            if (hashCode != 114) {
                                if (hashCode == 3519 && nextName.equals(SearchView.IME_OPTION_NO_MICROPHONE)) {
                                    c2 = 0;
                                }
                            } else if (nextName.equals(com.baidu.mapsdkplatform.comapi.map.r.f7745a)) {
                                c2 = 4;
                            }
                        } else if (nextName.equals(Config.OS)) {
                            c2 = 2;
                        }
                    } else if (nextName.equals("c")) {
                        c2 = 1;
                    }
                } else if (nextName.equals("fillEnabled")) {
                    c2 = 3;
                }
                if (c2 == 0) {
                    str = jsonReader.nextString();
                } else if (c2 == 1) {
                    aVar = d.g(jsonReader, dVar);
                } else if (c2 == 2) {
                    dVar2 = d.b(jsonReader, dVar);
                } else if (c2 == 3) {
                    z = jsonReader.nextBoolean();
                } else if (c2 != 4) {
                    jsonReader.skipValue();
                } else {
                    i2 = jsonReader.nextInt();
                }
            }
            return new com.ksad.lottie.model.content.i(str, z, i2 == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVar, dVar2);
        }
        return (com.ksad.lottie.model.content.i) invokeLL.objValue;
    }
}
