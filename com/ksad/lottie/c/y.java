package com.ksad.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
/* loaded from: classes6.dex */
public class y implements aj<PointF> {

    /* renamed from: a  reason: collision with root package name */
    public static final y f31346a = new y();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.ksad.lottie.c.aj
    /* renamed from: a */
    public PointF b(JsonReader jsonReader, float f2) {
        JsonToken peek = jsonReader.peek();
        if (peek != JsonToken.BEGIN_ARRAY && peek != JsonToken.BEGIN_OBJECT) {
            if (peek == JsonToken.NUMBER) {
                PointF pointF = new PointF(((float) jsonReader.nextDouble()) * f2, ((float) jsonReader.nextDouble()) * f2);
                while (jsonReader.hasNext()) {
                    jsonReader.skipValue();
                }
                return pointF;
            }
            throw new IllegalArgumentException("Cannot convert json to point. Next token is " + peek);
        }
        return p.b(jsonReader, f2);
    }
}
