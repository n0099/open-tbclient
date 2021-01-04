package com.ksad.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class aa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.ksad.lottie.model.content.f a(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        com.ksad.lottie.model.a.b bVar = null;
        com.ksad.lottie.model.a.f fVar = null;
        com.ksad.lottie.model.a.m<PointF, PointF> mVar = null;
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
                    fVar = d.c(jsonReader, dVar);
                    break;
                case 3:
                    bVar = d.a(jsonReader, dVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.ksad.lottie.model.content.f(str, mVar, fVar, bVar);
    }
}
