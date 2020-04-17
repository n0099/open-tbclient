package com.tb.airbnb.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.baidu.mobstat.Config;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a {
    public static com.tb.airbnb.lottie.model.a.e a(JsonReader jsonReader, com.tb.airbnb.lottie.d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(w.s(jsonReader, dVar));
            }
            jsonReader.endArray();
            r.j(arrayList);
        } else {
            arrayList.add(new com.tb.airbnb.lottie.e.a(p.g(jsonReader, com.tb.airbnb.lottie.d.f.jk())));
        }
        return new com.tb.airbnb.lottie.model.a.e(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.tb.airbnb.lottie.model.a.m<PointF, PointF> b(JsonReader jsonReader, com.tb.airbnb.lottie.d dVar) throws IOException {
        com.tb.airbnb.lottie.model.a.b bVar = null;
        jsonReader.beginObject();
        boolean z = false;
        com.tb.airbnb.lottie.model.a.b bVar2 = null;
        com.tb.airbnb.lottie.model.a.e eVar = null;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 107:
                    if (nextName.equals("k")) {
                        c = 0;
                        break;
                    }
                    break;
                case 120:
                    if (nextName.equals(Config.EVENT_HEAT_X)) {
                        c = 1;
                        break;
                    }
                    break;
                case 121:
                    if (nextName.equals("y")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    eVar = a(jsonReader, dVar);
                    break;
                case 1:
                    if (jsonReader.peek() == JsonToken.STRING) {
                        jsonReader.skipValue();
                        z = true;
                        break;
                    } else {
                        bVar2 = d.f(jsonReader, dVar);
                        break;
                    }
                case 2:
                    if (jsonReader.peek() == JsonToken.STRING) {
                        jsonReader.skipValue();
                        z = true;
                        break;
                    } else {
                        bVar = d.f(jsonReader, dVar);
                        break;
                    }
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            dVar.aW("Lottie doesn't support expressions.");
        }
        return eVar != null ? eVar : new com.tb.airbnb.lottie.model.a.i(bVar2, bVar);
    }
}
