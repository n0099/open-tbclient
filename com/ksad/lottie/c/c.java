package com.ksad.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;
import com.baidu.mobstat.Config;
/* loaded from: classes3.dex */
public class c {
    public static com.ksad.lottie.model.a.l a(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        com.ksad.lottie.model.a.e eVar;
        com.ksad.lottie.model.a.g gVar;
        boolean z = jsonReader.peek() == JsonToken.BEGIN_OBJECT;
        if (z) {
            jsonReader.beginObject();
        }
        com.ksad.lottie.model.a.b bVar = null;
        com.ksad.lottie.model.a.b bVar2 = null;
        com.ksad.lottie.model.a.d dVar2 = null;
        com.ksad.lottie.model.a.b bVar3 = null;
        com.ksad.lottie.model.a.g gVar2 = null;
        com.ksad.lottie.model.a.m<PointF, PointF> mVar = null;
        com.ksad.lottie.model.a.e eVar2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 97:
                    if (nextName.equals("a")) {
                        c = 0;
                        break;
                    }
                    break;
                case 111:
                    if (nextName.equals(Config.OS)) {
                        c = 5;
                        break;
                    }
                    break;
                case 112:
                    if (nextName.equals("p")) {
                        c = 1;
                        break;
                    }
                    break;
                case 114:
                    if (nextName.equals("r")) {
                        c = 4;
                        break;
                    }
                    break;
                case 115:
                    if (nextName.equals("s")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3242:
                    if (nextName.equals("eo")) {
                        c = 7;
                        break;
                    }
                    break;
                case 3656:
                    if (nextName.equals("rz")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3676:
                    if (nextName.equals("so")) {
                        c = 6;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if (jsonReader.nextName().equals("k")) {
                            eVar2 = a.a(jsonReader, dVar);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    gVar = gVar2;
                    continue;
                    gVar2 = gVar;
                case 1:
                    mVar = a.b(jsonReader, dVar);
                    gVar = gVar2;
                    continue;
                    gVar2 = gVar;
                case 2:
                    gVar = d.d(jsonReader, dVar);
                    continue;
                    gVar2 = gVar;
                case 3:
                    dVar.a("Lottie doesn't support 3D layers.");
                    break;
                case 4:
                    break;
                case 5:
                    dVar2 = d.b(jsonReader, dVar);
                    gVar = gVar2;
                    continue;
                    gVar2 = gVar;
                case 6:
                    bVar2 = d.a(jsonReader, dVar, false);
                    gVar = gVar2;
                    continue;
                    gVar2 = gVar;
                case 7:
                    bVar = d.a(jsonReader, dVar, false);
                    gVar = gVar2;
                    continue;
                    gVar2 = gVar;
                default:
                    jsonReader.skipValue();
                    gVar = gVar2;
                    continue;
                    gVar2 = gVar;
            }
            bVar3 = d.a(jsonReader, dVar, false);
            gVar = gVar2;
            gVar2 = gVar;
        }
        if (z) {
            jsonReader.endObject();
        }
        if (eVar2 == null) {
            Log.w("LOTTIE", "Layer has no transform property. You may be using an unsupported layer type such as a camera.");
            eVar = new com.ksad.lottie.model.a.e();
        } else {
            eVar = eVar2;
        }
        if (gVar2 == null) {
            gVar2 = new com.ksad.lottie.model.a.g(new com.ksad.lottie.e.d(1.0f, 1.0f));
        }
        return new com.ksad.lottie.model.a.l(eVar, mVar, gVar2, bVar3, dVar2 == null ? new com.ksad.lottie.model.a.d() : dVar2, bVar2, bVar);
    }
}
