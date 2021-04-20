package d.a.a.w;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* loaded from: classes.dex */
public class c0 implements j0<d.a.a.y.d> {

    /* renamed from: a  reason: collision with root package name */
    public static final c0 f41742a = new c0();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.w.j0
    /* renamed from: b */
    public d.a.a.y.d a(JsonReader jsonReader, float f2) throws IOException {
        boolean z = jsonReader.B() == JsonReader.Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.n();
        }
        float w = (float) jsonReader.w();
        float w2 = (float) jsonReader.w();
        while (jsonReader.t()) {
            jsonReader.F();
        }
        if (z) {
            jsonReader.q();
        }
        return new d.a.a.y.d((w / 100.0f) * f2, (w2 / 100.0f) * f2);
    }
}
