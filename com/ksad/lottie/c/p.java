package com.ksad.lottie.c;

import android.graphics.Color;
import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import androidx.annotation.ColorInt;
import com.baidu.android.imsdk.internal.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
class p {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ksad.lottie.c.p$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8276a = new int[JsonToken.values().length];

        static {
            try {
                f8276a[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8276a[JsonToken.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8276a[JsonToken.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<PointF> a(JsonReader jsonReader, float f) {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            arrayList.add(b(jsonReader, f));
            jsonReader.endArray();
        }
        jsonReader.endArray();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float b(JsonReader jsonReader) {
        JsonToken peek = jsonReader.peek();
        switch (AnonymousClass1.f8276a[peek.ordinal()]) {
            case 1:
                return (float) jsonReader.nextDouble();
            case 2:
                jsonReader.beginArray();
                float nextDouble = (float) jsonReader.nextDouble();
                while (jsonReader.hasNext()) {
                    jsonReader.skipValue();
                }
                jsonReader.endArray();
                return nextDouble;
            default:
                throw new IllegalArgumentException("Unknown value for token of type " + peek);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PointF b(JsonReader jsonReader, float f) {
        switch (AnonymousClass1.f8276a[jsonReader.peek().ordinal()]) {
            case 1:
                return c(jsonReader, f);
            case 2:
                return d(jsonReader, f);
            case 3:
                return e(jsonReader, f);
            default:
                throw new IllegalArgumentException("Unknown point starts with " + jsonReader.peek());
        }
    }

    private static PointF c(JsonReader jsonReader, float f) {
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.hasNext()) {
            jsonReader.skipValue();
        }
        return new PointF(nextDouble * f, nextDouble2 * f);
    }

    private static PointF d(JsonReader jsonReader, float f) {
        jsonReader.beginArray();
        float nextDouble = (float) jsonReader.nextDouble();
        float nextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.peek() != JsonToken.END_ARRAY) {
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return new PointF(nextDouble * f, nextDouble2 * f);
    }

    private static PointF e(JsonReader jsonReader, float f) {
        float f2 = 0.0f;
        jsonReader.beginObject();
        float f3 = 0.0f;
        while (true) {
            float f4 = f2;
            if (!jsonReader.hasNext()) {
                jsonReader.endObject();
                return new PointF(f4 * f, f3 * f);
            }
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 120:
                    if (nextName.equals("x")) {
                        c = 0;
                        break;
                    }
                    break;
                case Constants.METHOD_IM_FRIEND_GROUP_DROP /* 121 */:
                    if (nextName.equals("y")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    f4 = b(jsonReader);
                    break;
                case 1:
                    f3 = b(jsonReader);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
            f2 = f4;
        }
    }
}
