package com.ksad.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {
    public static com.ksad.lottie.model.a.e a(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(w.a(jsonReader, dVar));
            }
            jsonReader.endArray();
            r.a(arrayList);
        } else {
            arrayList.add(new com.ksad.lottie.e.a(p.b(jsonReader, com.ksad.lottie.d.f.a())));
        }
        return new com.ksad.lottie.model.a.e(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.ksad.lottie.model.a.m<PointF, PointF> b(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        jsonReader.beginObject();
        boolean z = false;
        com.ksad.lottie.model.a.b bVar = null;
        com.ksad.lottie.model.a.b bVar2 = null;
        com.ksad.lottie.model.a.e eVar = null;
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
                case Constants.METHOD_IM_FRIEND_GROUP_DROP /* 121 */:
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
                    if (jsonReader.peek() != JsonToken.STRING) {
                        bVar2 = d.a(jsonReader, dVar);
                        break;
                    } else {
                        jsonReader.skipValue();
                        z = true;
                        break;
                    }
                case 2:
                    if (jsonReader.peek() != JsonToken.STRING) {
                        bVar = d.a(jsonReader, dVar);
                        break;
                    } else {
                        jsonReader.skipValue();
                        z = true;
                        break;
                    }
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            dVar.a("Lottie doesn't support expressions.");
        }
        return eVar != null ? eVar : new com.ksad.lottie.model.a.i(bVar2, bVar);
    }
}
