package d.a.a.u;

import android.util.JsonReader;
import java.io.IOException;
/* loaded from: classes.dex */
public class o implements j0<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final o f41431a = new o();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.u.j0
    /* renamed from: b */
    public Integer a(JsonReader jsonReader, float f2) throws IOException {
        return Integer.valueOf(Math.round(p.g(jsonReader) * f2));
    }
}
