package com.ksad.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;
import com.airbnb.lottie.L;
import com.baidu.mobstat.Config;
/* loaded from: classes6.dex */
public class c {
    public static com.ksad.lottie.model.a.l a(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_OBJECT;
        if (z) {
            jsonReader.beginObject();
        }
        com.ksad.lottie.model.a.e eVar = null;
        com.ksad.lottie.model.a.g gVar = null;
        com.ksad.lottie.model.a.d dVar2 = null;
        com.ksad.lottie.model.a.m<PointF, PointF> mVar = null;
        com.ksad.lottie.model.a.b bVar = null;
        com.ksad.lottie.model.a.b bVar2 = null;
        com.ksad.lottie.model.a.b bVar3 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 97) {
                if (hashCode != 3242) {
                    if (hashCode != 3656) {
                        if (hashCode != 3676) {
                            if (hashCode != 111) {
                                if (hashCode != 112) {
                                    if (hashCode != 114) {
                                        if (hashCode == 115 && nextName.equals("s")) {
                                            c2 = 2;
                                        }
                                    } else if (nextName.equals(com.baidu.mapsdkplatform.comapi.map.r.f7715a)) {
                                        c2 = 4;
                                    }
                                } else if (nextName.equals("p")) {
                                    c2 = 1;
                                }
                            } else if (nextName.equals(Config.OS)) {
                                c2 = 5;
                            }
                        } else if (nextName.equals("so")) {
                            c2 = 6;
                        }
                    } else if (nextName.equals("rz")) {
                        c2 = 3;
                    }
                } else if (nextName.equals("eo")) {
                    c2 = 7;
                }
            } else if (nextName.equals("a")) {
                c2 = 0;
            }
            switch (c2) {
                case 0:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if (jsonReader.nextName().equals(Config.APP_KEY)) {
                            eVar = a.a(jsonReader, dVar);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    continue;
                case 1:
                    mVar = a.b(jsonReader, dVar);
                    continue;
                case 2:
                    gVar = d.d(jsonReader, dVar);
                    continue;
                case 3:
                    dVar.a("Lottie doesn't support 3D layers.");
                    break;
                case 4:
                    break;
                case 5:
                    dVar2 = d.b(jsonReader, dVar);
                    continue;
                case 6:
                    bVar2 = d.a(jsonReader, dVar, false);
                    continue;
                case 7:
                    bVar3 = d.a(jsonReader, dVar, false);
                    continue;
                default:
                    jsonReader.skipValue();
                    continue;
            }
            bVar = d.a(jsonReader, dVar, false);
        }
        if (z) {
            jsonReader.endObject();
        }
        if (eVar == null) {
            Log.w(L.TAG, "Layer has no transform property. You may be using an unsupported layer type such as a camera.");
            eVar = new com.ksad.lottie.model.a.e();
        }
        com.ksad.lottie.model.a.e eVar2 = eVar;
        if (gVar == null) {
            gVar = new com.ksad.lottie.model.a.g(new com.ksad.lottie.e.d(1.0f, 1.0f));
        }
        com.ksad.lottie.model.a.g gVar2 = gVar;
        if (dVar2 == null) {
            dVar2 = new com.ksad.lottie.model.a.d();
        }
        return new com.ksad.lottie.model.a.l(eVar2, mVar, gVar2, bVar, dVar2, bVar2, bVar3);
    }
}
