package d.a.a.w;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* loaded from: classes.dex */
public class o implements j0<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final o f41861a = new o();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.w.j0
    /* renamed from: b */
    public Integer a(JsonReader jsonReader, float f2) throws IOException {
        return Integer.valueOf(Math.round(p.g(jsonReader) * f2));
    }
}
