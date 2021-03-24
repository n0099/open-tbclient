package d.a.a.u;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
/* loaded from: classes.dex */
public class y implements j0<PointF> {

    /* renamed from: a  reason: collision with root package name */
    public static final y f41436a = new y();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.u.j0
    /* renamed from: b */
    public PointF a(JsonReader jsonReader, float f2) throws IOException {
        JsonToken peek = jsonReader.peek();
        if (peek == JsonToken.BEGIN_ARRAY) {
            return p.e(jsonReader, f2);
        }
        if (peek == JsonToken.BEGIN_OBJECT) {
            return p.e(jsonReader, f2);
        }
        if (peek == JsonToken.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.nextDouble()) * f2, ((float) jsonReader.nextDouble()) * f2);
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + peek);
    }
}
