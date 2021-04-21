package d.a.a.w;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonReader.a f41854a = JsonReader.a.a("fFamily", "fName", "fStyle", "ascent");

    public static d.a.a.u.b a(JsonReader jsonReader) throws IOException {
        jsonReader.o();
        String str = null;
        String str2 = null;
        String str3 = null;
        float f2 = 0.0f;
        while (jsonReader.t()) {
            int D = jsonReader.D(f41854a);
            if (D == 0) {
                str = jsonReader.z();
            } else if (D == 1) {
                str2 = jsonReader.z();
            } else if (D == 2) {
                str3 = jsonReader.z();
            } else if (D != 3) {
                jsonReader.E();
                jsonReader.F();
            } else {
                f2 = (float) jsonReader.w();
            }
        }
        jsonReader.r();
        return new d.a.a.u.b(str, str2, str3, f2);
    }
}
