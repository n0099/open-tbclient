package com.tb.airbnb.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.tb.airbnb.lottie.model.content.a b(JsonReader jsonReader, com.tb.airbnb.lottie.d dVar, int i) throws IOException {
        com.tb.airbnb.lottie.model.a.f fVar = null;
        boolean z = i == 3;
        com.tb.airbnb.lottie.model.a.m<PointF, PointF> mVar = null;
        String str = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 100:
                    if (nextName.equals("d")) {
                        c = 3;
                        break;
                    }
                    break;
                case 112:
                    if (nextName.equals("p")) {
                        c = 1;
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
                    if (jsonReader.nextInt() != 3) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.tb.airbnb.lottie.model.content.a(str, mVar, fVar, z);
    }
}
