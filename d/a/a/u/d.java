package d.a.a.u;

import android.util.JsonReader;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    @Nullable
    public static <T> List<d.a.a.w.a<T>> a(JsonReader jsonReader, float f2, d.a.a.d dVar, j0<T> j0Var) throws IOException {
        return r.a(jsonReader, dVar, f2, j0Var);
    }

    @Nullable
    public static <T> List<d.a.a.w.a<T>> b(JsonReader jsonReader, d.a.a.d dVar, j0<T> j0Var) throws IOException {
        return r.a(jsonReader, dVar, 1.0f, j0Var);
    }

    public static d.a.a.s.i.a c(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        return new d.a.a.s.i.a(b(jsonReader, dVar, f.f41428a));
    }

    public static d.a.a.s.i.j d(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        return new d.a.a.s.i.j(b(jsonReader, dVar, h.f41429a));
    }

    public static d.a.a.s.i.b e(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        return f(jsonReader, dVar, true);
    }

    public static d.a.a.s.i.b f(JsonReader jsonReader, d.a.a.d dVar, boolean z) throws IOException {
        return new d.a.a.s.i.b(a(jsonReader, z ? d.a.a.v.f.e() : 1.0f, dVar, i.f41430a));
    }

    public static d.a.a.s.i.c g(JsonReader jsonReader, d.a.a.d dVar, int i) throws IOException {
        return new d.a.a.s.i.c(b(jsonReader, dVar, new l(i)));
    }

    public static d.a.a.s.i.d h(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        return new d.a.a.s.i.d(b(jsonReader, dVar, o.f41432a));
    }

    public static d.a.a.s.i.f i(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        return new d.a.a.s.i.f(a(jsonReader, d.a.a.v.f.e(), dVar, y.f41437a));
    }

    public static d.a.a.s.i.g j(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        return new d.a.a.s.i.g(b(jsonReader, dVar, c0.f41426a));
    }

    public static d.a.a.s.i.h k(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        return new d.a.a.s.i.h(a(jsonReader, d.a.a.v.f.e(), dVar, d0.f41427a));
    }
}
