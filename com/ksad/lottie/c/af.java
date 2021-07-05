package com.ksad.lottie.c;

import android.util.JsonReader;
import androidx.appcompat.widget.SearchView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class af {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static com.ksad.lottie.model.content.j a(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, jsonReader, dVar)) == null) {
            ArrayList arrayList = new ArrayList();
            String str = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                char c2 = 65535;
                int hashCode = nextName.hashCode();
                if (hashCode != 3371) {
                    if (hashCode == 3519 && nextName.equals(SearchView.IME_OPTION_NO_MICROPHONE)) {
                        c2 = 0;
                    }
                } else if (nextName.equals(AdvanceSetting.NETWORK_TYPE)) {
                    c2 = 1;
                }
                if (c2 == 0) {
                    str = jsonReader.nextString();
                } else if (c2 != 1) {
                    jsonReader.skipValue();
                } else {
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.ksad.lottie.model.content.b a2 = g.a(jsonReader, dVar);
                        if (a2 != null) {
                            arrayList.add(a2);
                        }
                    }
                    jsonReader.endArray();
                }
            }
            return new com.ksad.lottie.model.content.j(str, arrayList);
        }
        return (com.ksad.lottie.model.content.j) invokeLL.objValue;
    }
}
