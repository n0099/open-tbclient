package com.ksad.lottie.c;

import android.util.JsonReader;
import com.baidu.mobstat.Config;
/* loaded from: classes5.dex */
public class b {
    public static com.ksad.lottie.model.a.k a(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        jsonReader.beginObject();
        com.ksad.lottie.model.a.k kVar = null;
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
            }
            switch (c) {
                case 0:
                    kVar = b(jsonReader, dVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return kVar == null ? new com.ksad.lottie.model.a.k(null, null, null, null) : kVar;
    }

    private static com.ksad.lottie.model.a.k b(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        jsonReader.beginObject();
        com.ksad.lottie.model.a.b bVar = null;
        com.ksad.lottie.model.a.b bVar2 = null;
        com.ksad.lottie.model.a.a aVar = null;
        com.ksad.lottie.model.a.a aVar2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 116:
                    if (nextName.equals("t")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3261:
                    if (nextName.equals("fc")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3664:
                    if (nextName.equals(Config.STAT_SDK_CHANNEL)) {
                        c = 1;
                        break;
                    }
                    break;
                case 3684:
                    if (nextName.equals("sw")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    aVar2 = d.g(jsonReader, dVar);
                    break;
                case 1:
                    aVar = d.g(jsonReader, dVar);
                    break;
                case 2:
                    bVar2 = d.a(jsonReader, dVar);
                    break;
                case 3:
                    bVar = d.a(jsonReader, dVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return new com.ksad.lottie.model.a.k(aVar2, aVar, bVar2, bVar);
    }
}
