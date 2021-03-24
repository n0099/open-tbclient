package d.a.a.u;

import android.util.JsonReader;
import java.io.IOException;
/* loaded from: classes.dex */
public class i implements j0<Float> {

    /* renamed from: a  reason: collision with root package name */
    public static final i f41429a = new i();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.u.j0
    /* renamed from: b */
    public Float a(JsonReader jsonReader, float f2) throws IOException {
        return Float.valueOf(p.g(jsonReader) * f2);
    }
}
