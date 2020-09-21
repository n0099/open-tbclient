package com.tb.airbnb.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;
/* loaded from: classes17.dex */
class aa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.tb.airbnb.lottie.model.content.f u(JsonReader jsonReader, com.tb.airbnb.lottie.d dVar) throws IOException {
        com.tb.airbnb.lottie.model.a.b bVar = null;
        com.tb.airbnb.lottie.model.a.f fVar = null;
        com.tb.airbnb.lottie.model.a.m<PointF, PointF> mVar = null;
        String str = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 112:
                    if (nextName.equals("p")) {
                        c = 1;
                        break;
                    }
                    break;
                case 114:
                    if (nextName.equals("r")) {
                        c = 3;
                        break;
                    }
                    break;
                case 115:
                    if (nextName.equals("s")) {
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
            }
            switch (c) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    mVar = a.b(jsonReader, dVar);
                    break;
                case 2:
                    fVar = d.h(jsonReader, dVar);
                    break;
                case 3:
                    bVar = d.f(jsonReader, dVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.tb.airbnb.lottie.model.content.f(str, mVar, fVar, bVar);
    }
}
