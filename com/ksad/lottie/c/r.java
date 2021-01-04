package com.ksad.lottie.c;

import android.util.JsonReader;
import android.util.JsonToken;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
class r {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> List<com.ksad.lottie.e.a<T>> a(JsonReader jsonReader, com.ksad.lottie.d dVar, float f, aj<T> ajVar) {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            dVar.a("Lottie doesn't support expressions.");
        } else {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                char c = 65535;
                switch (nextName.hashCode()) {
                    case 107:
                        if (nextName.equals("k")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        if (jsonReader.peek() != JsonToken.BEGIN_ARRAY) {
                            arrayList.add(q.a(jsonReader, dVar, f, ajVar, false));
                            break;
                        } else {
                            jsonReader.beginArray();
                            if (jsonReader.peek() == JsonToken.NUMBER) {
                                arrayList.add(q.a(jsonReader, dVar, f, ajVar, false));
                            } else {
                                while (jsonReader.hasNext()) {
                                    arrayList.add(q.a(jsonReader, dVar, f, ajVar, true));
                                }
                            }
                            jsonReader.endArray();
                            break;
                        }
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            a(arrayList);
        }
        return arrayList;
    }

    public static void a(List<? extends com.ksad.lottie.e.a<?>> list) {
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size - 1) {
                break;
            }
            list.get(i2).e = Float.valueOf(list.get(i2 + 1).d);
            i = i2 + 1;
        }
        com.ksad.lottie.e.a<?> aVar = list.get(size - 1);
        if (aVar.f8300a == 0) {
            list.remove(aVar);
        }
    }
}
