package com.ksad.lottie.c;

import android.graphics.Color;
import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import androidx.annotation.ColorInt;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: com.ksad.lottie.c.p$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31631a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f31631a = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31631a[JsonToken.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31631a[JsonToken.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @ColorInt
    public static int a(JsonReader jsonReader) {
        jsonReader.beginArray();
        int nextDouble = (int) (jsonReader.nextDouble() * 255.0d);
        int nextDouble2 = (int) (jsonReader.nextDouble() * 255.0d);
        int nextDouble3 = (int) (jsonReader.nextDouble() * 255.0d);
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return Color.argb(255, nextDouble, nextDouble2, nextDouble3);
    }

    public static List<PointF> a(JsonReader jsonReader, float f2) {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            arrayList.add(b(jsonReader, f2));
            jsonReader.endArray();
        }
        jsonReader.endArray();
        return arrayList;
    }

    public static float b(JsonReader jsonReader) {
        JsonToken peek = jsonReader.peek();
        int i = AnonymousClass1.f31631a[peek.ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new IllegalArgumentException("Unknown value for token of type " + peek);
            }
            jsonReader.beginArray();
            float nextDouble = (float) jsonReader.nextDouble();
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            jsonReader.endArray();
            return nextDouble;
        }
        return (float) jsonReader.nextDouble();
    }

    public static PointF b(JsonReader jsonReader, float f2) {
        int i = AnonymousClass1.f31631a[jsonReader.peek().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return e(jsonReader, f2);
                }
                throw new IllegalArgumentException("Unknown point starts with " + jsonReader.peek());
            }
            return d(jsonReader, f2);
        }
        return c(jsonReader, f2);
    }

    public static PointF c(JsonReader jsonReader, float f2) {
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        return new PointF(nextDouble * f2, nextDouble2 * f2);
    }

    public static PointF d(JsonReader jsonReader, float f2) {
        jsonReader.beginArray();
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.peek() != JsonToken.END_ARRAY) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return new PointF(nextDouble * f2, nextDouble2 * f2);
    }

    public static PointF e(JsonReader jsonReader, float f2) {
        jsonReader.beginObject();
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 120) {
                if (hashCode == 121 && nextName.equals("y")) {
                    c2 = 1;
                }
            } else if (nextName.equals("x")) {
                c2 = 0;
            }
            if (c2 == 0) {
                f3 = b(jsonReader);
            } else if (c2 != 1) {
                jsonReader.skipValue();
            } else {
                f4 = b(jsonReader);
            }
        }
        jsonReader.endObject();
        return new PointF(f3 * f2, f4 * f2);
    }
}
