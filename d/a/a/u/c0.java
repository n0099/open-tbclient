package d.a.a.u;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
/* loaded from: classes.dex */
public class c0 implements j0<d.a.a.w.d> {

    /* renamed from: a  reason: collision with root package name */
    public static final c0 f41425a = new c0();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.u.j0
    /* renamed from: b */
    public d.a.a.w.d a(JsonReader jsonReader, float f2) throws IOException {
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
        return new d.a.a.w.d((nextDouble / 100.0f) * f2, (nextDouble2 / 100.0f) * f2);
    }
}
