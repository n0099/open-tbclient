package com.ksad.lottie.c;

import android.util.JsonReader;
import androidx.appcompat.widget.SearchView;
import com.baidu.mobstat.Config;
/* loaded from: classes6.dex */
public class ab {
    public static com.ksad.lottie.model.content.g a(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        String str = null;
        com.ksad.lottie.model.a.b bVar = null;
        com.ksad.lottie.model.a.b bVar2 = null;
        com.ksad.lottie.model.a.l lVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 99) {
                if (hashCode != 111) {
                    if (hashCode != 3519) {
                        if (hashCode == 3710 && nextName.equals("tr")) {
                            c2 = 3;
                        }
                    } else if (nextName.equals(SearchView.IME_OPTION_NO_MICROPHONE)) {
                        c2 = 0;
                    }
                } else if (nextName.equals(Config.OS)) {
                    c2 = 2;
                }
            } else if (nextName.equals("c")) {
                c2 = 1;
            }
            if (c2 == 0) {
                str = jsonReader.nextString();
            } else if (c2 == 1) {
                bVar = d.a(jsonReader, dVar, false);
            } else if (c2 == 2) {
                bVar2 = d.a(jsonReader, dVar, false);
            } else if (c2 != 3) {
                jsonReader.skipValue();
            } else {
                lVar = c.a(jsonReader, dVar);
            }
        }
        return new com.ksad.lottie.model.content.g(str, bVar, bVar2, lVar);
    }
}
