package com.ksad.lottie.c;

import android.util.JsonReader;
import androidx.appcompat.widget.SearchView;
import com.fun.ad.sdk.FunAdSdk;
/* loaded from: classes6.dex */
public class ag {
    public static com.ksad.lottie.model.content.k a(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        String str = null;
        com.ksad.lottie.model.a.h hVar = null;
        int i2 = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 3432) {
                if (hashCode != 3519) {
                    if (hashCode == 104415 && nextName.equals("ind")) {
                        c2 = 1;
                    }
                } else if (nextName.equals(SearchView.IME_OPTION_NO_MICROPHONE)) {
                    c2 = 0;
                }
            } else if (nextName.equals(FunAdSdk.PLATFORM_KS)) {
                c2 = 2;
            }
            if (c2 == 0) {
                str = jsonReader.nextString();
            } else if (c2 == 1) {
                i2 = jsonReader.nextInt();
            } else if (c2 != 2) {
                jsonReader.skipValue();
            } else {
                hVar = d.e(jsonReader, dVar);
            }
        }
        return new com.ksad.lottie.model.content.k(str, i2, hVar);
    }
}
