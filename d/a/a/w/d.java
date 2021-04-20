package d.a.a.w;

import androidx.annotation.Nullable;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    @Nullable
    public static <T> List<d.a.a.y.a<T>> a(JsonReader jsonReader, float f2, d.a.a.d dVar, j0<T> j0Var) throws IOException {
        return r.a(jsonReader, dVar, f2, j0Var);
    }

    @Nullable
    public static <T> List<d.a.a.y.a<T>> b(JsonReader jsonReader, d.a.a.d dVar, j0<T> j0Var) throws IOException {
        return r.a(jsonReader, dVar, 1.0f, j0Var);
    }

    public static d.a.a.u.i.a c(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        return new d.a.a.u.i.a(b(jsonReader, dVar, f.f41747a));
    }

    public static d.a.a.u.i.j d(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        return new d.a.a.u.i.j(b(jsonReader, dVar, h.f41751a));
    }

    public static d.a.a.u.i.b e(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        return f(jsonReader, dVar, true);
    }

    public static d.a.a.u.i.b f(JsonReader jsonReader, d.a.a.d dVar, boolean z) throws IOException {
        return new d.a.a.u.i.b(a(jsonReader, z ? d.a.a.x.h.e() : 1.0f, dVar, i.f41755a));
    }

    public static d.a.a.u.i.c g(JsonReader jsonReader, d.a.a.d dVar, int i) throws IOException {
        return new d.a.a.u.i.c(b(jsonReader, dVar, new l(i)));
    }

    public static d.a.a.u.i.d h(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        return new d.a.a.u.i.d(b(jsonReader, dVar, o.f41766a));
    }

    public static d.a.a.u.i.f i(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        return new d.a.a.u.i.f(a(jsonReader, d.a.a.x.h.e(), dVar, y.f41783a));
    }

    public static d.a.a.u.i.g j(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        return new d.a.a.u.i.g(b(jsonReader, dVar, c0.f41742a));
    }

    public static d.a.a.u.i.h k(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        return new d.a.a.u.i.h(a(jsonReader, d.a.a.x.h.e(), dVar, d0.f41743a));
    }
}
