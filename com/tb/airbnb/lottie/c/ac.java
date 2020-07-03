package com.tb.airbnb.lottie.c;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
/* loaded from: classes6.dex */
public class ac implements aj<com.tb.airbnb.lottie.e.d> {
    public static final ac nHD = new ac();

    private ac() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.tb.airbnb.lottie.c.aj
    /* renamed from: p */
    public com.tb.airbnb.lottie.e.d b(JsonReader jsonReader, float f) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        if (z) {
            jsonReader.endArray();
        }
        return new com.tb.airbnb.lottie.e.d((nextDouble / 100.0f) * f, (nextDouble2 / 100.0f) * f);
    }
}
