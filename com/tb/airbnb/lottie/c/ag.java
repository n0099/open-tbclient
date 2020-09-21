package com.tb.airbnb.lottie.c;

import android.util.JsonReader;
import java.io.IOException;
/* loaded from: classes17.dex */
class ag {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.tb.airbnb.lottie.model.content.k y(JsonReader jsonReader, com.tb.airbnb.lottie.d dVar) throws IOException {
        com.tb.airbnb.lottie.model.a.h hVar = null;
        int i = 0;
        String str = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 3432:
                    if (nextName.equals("ks")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c = 0;
                        break;
                    }
                    break;
                case 104415:
                    if (nextName.equals("ind")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    i = jsonReader.nextInt();
                    break;
                case 2:
                    hVar = d.j(jsonReader, dVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.tb.airbnb.lottie.model.content.k(str, i, hVar);
    }
}
