package d.a.a.w;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* loaded from: classes.dex */
public class y implements j0<PointF> {

    /* renamed from: a  reason: collision with root package name */
    public static final y f41878a = new y();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.w.j0
    /* renamed from: b */
    public PointF a(JsonReader jsonReader, float f2) throws IOException {
        JsonReader.Token B = jsonReader.B();
        if (B == JsonReader.Token.BEGIN_ARRAY) {
            return p.e(jsonReader, f2);
        }
        if (B == JsonReader.Token.BEGIN_OBJECT) {
            return p.e(jsonReader, f2);
        }
        if (B == JsonReader.Token.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.w()) * f2, ((float) jsonReader.w()) * f2);
            while (jsonReader.t()) {
                jsonReader.F();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + B);
    }
}
