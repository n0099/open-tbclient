package d.a.a.w;

import android.graphics.Color;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* loaded from: classes.dex */
public class f implements j0<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final f f41747a = new f();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.w.j0
    /* renamed from: b */
    public Integer a(JsonReader jsonReader, float f2) throws IOException {
        boolean z = jsonReader.B() == JsonReader.Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.n();
        }
        double w = jsonReader.w();
        double w2 = jsonReader.w();
        double w3 = jsonReader.w();
        double w4 = jsonReader.B() == JsonReader.Token.NUMBER ? jsonReader.w() : 1.0d;
        if (z) {
            jsonReader.q();
        }
        if (w <= 1.0d && w2 <= 1.0d && w3 <= 1.0d) {
            w *= 255.0d;
            w2 *= 255.0d;
            w3 *= 255.0d;
            if (w4 <= 1.0d) {
                w4 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) w4, (int) w, (int) w2, (int) w3));
    }
}
