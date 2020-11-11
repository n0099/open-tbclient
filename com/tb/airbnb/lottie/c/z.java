package com.tb.airbnb.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import com.tb.airbnb.lottie.model.content.PolystarShape;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes16.dex */
public class z {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static PolystarShape t(JsonReader jsonReader, com.tb.airbnb.lottie.e eVar) throws IOException {
        com.tb.airbnb.lottie.model.a.b bVar = null;
        com.tb.airbnb.lottie.model.a.b bVar2 = null;
        com.tb.airbnb.lottie.model.a.b bVar3 = null;
        com.tb.airbnb.lottie.model.a.b bVar4 = null;
        com.tb.airbnb.lottie.model.a.b bVar5 = null;
        com.tb.airbnb.lottie.model.a.m<PointF, PointF> mVar = null;
        com.tb.airbnb.lottie.model.a.b bVar6 = null;
        PolystarShape.Type type = null;
        String str = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 112:
                    if (nextName.equals("p")) {
                        c = 3;
                        break;
                    }
                    break;
                case 114:
                    if (nextName.equals("r")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3369:
                    if (nextName.equals("ir")) {
                        c = 7;
                        break;
                    }
                    break;
                case 3370:
                    if (nextName.equals("is")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3555:
                    if (nextName.equals("or")) {
                        c = 5;
                        break;
                    }
                    break;
                case 3556:
                    if (nextName.equals("os")) {
                        c = 6;
                        break;
                    }
                    break;
                case 3588:
                    if (nextName.equals("pt")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3686:
                    if (nextName.equals("sy")) {
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
                    type = PolystarShape.Type.forValue(jsonReader.nextInt());
                    break;
                case 2:
                    bVar6 = d.a(jsonReader, eVar, false);
                    break;
                case 3:
                    mVar = a.b(jsonReader, eVar);
                    break;
                case 4:
                    bVar5 = d.a(jsonReader, eVar, false);
                    break;
                case 5:
                    bVar4 = d.f(jsonReader, eVar);
                    break;
                case 6:
                    bVar3 = d.a(jsonReader, eVar, false);
                    break;
                case 7:
                    bVar2 = d.f(jsonReader, eVar);
                    break;
                case '\b':
                    bVar = d.a(jsonReader, eVar, false);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new PolystarShape(str, type, bVar6, mVar, bVar5, bVar2, bVar4, bVar, bVar3);
    }
}
