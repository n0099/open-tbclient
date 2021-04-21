package d.a.a.w;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonReader.a f41862a = JsonReader.a.a("x", "y");

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41863a;

        static {
            int[] iArr = new int[JsonReader.Token.values().length];
            f41863a = iArr;
            try {
                iArr[JsonReader.Token.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41863a[JsonReader.Token.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41863a[JsonReader.Token.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static PointF a(JsonReader jsonReader, float f2) throws IOException {
        jsonReader.n();
        float w = (float) jsonReader.w();
        float w2 = (float) jsonReader.w();
        while (jsonReader.B() != JsonReader.Token.END_ARRAY) {
            jsonReader.F();
        }
        jsonReader.q();
        return new PointF(w * f2, w2 * f2);
    }

    public static PointF b(JsonReader jsonReader, float f2) throws IOException {
        float w = (float) jsonReader.w();
        float w2 = (float) jsonReader.w();
        while (jsonReader.t()) {
            jsonReader.F();
        }
        return new PointF(w * f2, w2 * f2);
    }

    public static PointF c(JsonReader jsonReader, float f2) throws IOException {
        jsonReader.o();
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (jsonReader.t()) {
            int D = jsonReader.D(f41862a);
            if (D == 0) {
                f3 = g(jsonReader);
            } else if (D != 1) {
                jsonReader.E();
                jsonReader.F();
            } else {
                f4 = g(jsonReader);
            }
        }
        jsonReader.r();
        return new PointF(f3 * f2, f4 * f2);
    }

    @ColorInt
    public static int d(JsonReader jsonReader) throws IOException {
        jsonReader.n();
        int w = (int) (jsonReader.w() * 255.0d);
        int w2 = (int) (jsonReader.w() * 255.0d);
        int w3 = (int) (jsonReader.w() * 255.0d);
        while (jsonReader.t()) {
            jsonReader.F();
        }
        jsonReader.q();
        return Color.argb(255, w, w2, w3);
    }

    public static PointF e(JsonReader jsonReader, float f2) throws IOException {
        int i = a.f41863a[jsonReader.B().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return c(jsonReader, f2);
                }
                throw new IllegalArgumentException("Unknown point starts with " + jsonReader.B());
            }
            return a(jsonReader, f2);
        }
        return b(jsonReader, f2);
    }

    public static List<PointF> f(JsonReader jsonReader, float f2) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.n();
        while (jsonReader.B() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.n();
            arrayList.add(e(jsonReader, f2));
            jsonReader.q();
        }
        jsonReader.q();
        return arrayList;
    }

    public static float g(JsonReader jsonReader) throws IOException {
        JsonReader.Token B = jsonReader.B();
        int i = a.f41863a[B.ordinal()];
        if (i != 1) {
            if (i == 2) {
                jsonReader.n();
                float w = (float) jsonReader.w();
                while (jsonReader.t()) {
                    jsonReader.F();
                }
                jsonReader.q();
                return w;
            }
            throw new IllegalArgumentException("Unknown value for token of type " + B);
        }
        return (float) jsonReader.w();
    }
}
