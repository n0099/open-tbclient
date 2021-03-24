package com.ksad.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import androidx.appcompat.widget.SearchView;
/* loaded from: classes6.dex */
public class e {
    public static com.ksad.lottie.model.content.a a(JsonReader jsonReader, com.ksad.lottie.d dVar, int i) {
        boolean z = i == 3;
        String str = null;
        com.ksad.lottie.model.a.m<PointF, PointF> mVar = null;
        com.ksad.lottie.model.a.f fVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 100) {
                if (hashCode != 112) {
                    if (hashCode != 115) {
                        if (hashCode == 3519 && nextName.equals(SearchView.IME_OPTION_NO_MICROPHONE)) {
                            c2 = 0;
                        }
                    } else if (nextName.equals("s")) {
                        c2 = 2;
                    }
                } else if (nextName.equals("p")) {
                    c2 = 1;
                }
            } else if (nextName.equals("d")) {
                c2 = 3;
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
                z = jsonReader.nextInt() == 3;
            }
        }
        return new com.ksad.lottie.model.content.a(str, mVar, fVar, z);
    }
}
