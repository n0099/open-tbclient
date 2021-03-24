package com.ksad.lottie.c;

import android.util.JsonReader;
import com.baidu.mobstat.Config;
/* loaded from: classes6.dex */
public class b {
    public static com.ksad.lottie.model.a.k a(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        jsonReader.beginObject();
        com.ksad.lottie.model.a.k kVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            if (nextName.hashCode() == 97 && nextName.equals("a")) {
                c2 = 0;
            }
            if (c2 != 0) {
                jsonReader.skipValue();
            } else {
                kVar = b(jsonReader, dVar);
            }
        }
        jsonReader.endObject();
        return kVar == null ? new com.ksad.lottie.model.a.k(null, null, null, null) : kVar;
    }

    public static com.ksad.lottie.model.a.k b(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        jsonReader.beginObject();
        com.ksad.lottie.model.a.a aVar = null;
        com.ksad.lottie.model.a.a aVar2 = null;
        com.ksad.lottie.model.a.b bVar = null;
        com.ksad.lottie.model.a.b bVar2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 116) {
                if (hashCode != 3261) {
                    if (hashCode != 3664) {
                        if (hashCode == 3684 && nextName.equals("sw")) {
                            c2 = 2;
                        }
                    } else if (nextName.equals(Config.STAT_SDK_CHANNEL)) {
                        c2 = 1;
                    }
                } else if (nextName.equals("fc")) {
                    c2 = 0;
                }
            } else if (nextName.equals("t")) {
                c2 = 3;
            }
            if (c2 == 0) {
                aVar = d.g(jsonReader, dVar);
            } else if (c2 == 1) {
                aVar2 = d.g(jsonReader, dVar);
            } else if (c2 == 2) {
                bVar = d.a(jsonReader, dVar);
            } else if (c2 != 3) {
                jsonReader.skipValue();
            } else {
                bVar2 = d.a(jsonReader, dVar);
            }
        }
        jsonReader.endObject();
        return new com.ksad.lottie.model.a.k(aVar, aVar2, bVar, bVar2);
    }
}
