package com.ksad.lottie.c;

import android.util.JsonReader;
import android.util.JsonToken;
/* loaded from: classes6.dex */
public class ac implements aj<com.ksad.lottie.e.d> {

    /* renamed from: a  reason: collision with root package name */
    public static final ac f31335a = new ac();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.c.aj
    /* renamed from: a */
    public com.ksad.lottie.e.d b(JsonReader jsonReader, float f2) {
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
        return new com.ksad.lottie.e.d((nextDouble / 100.0f) * f2, (nextDouble2 / 100.0f) * f2);
    }
}
