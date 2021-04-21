package d.a.a.w;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonReader.a f41852a = JsonReader.a.a("ch", "size", "w", "style", "fFamily", "data");

    /* renamed from: b  reason: collision with root package name */
    public static final JsonReader.a f41853b = JsonReader.a.a("shapes");

    public static d.a.a.u.c a(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.o();
        String str = null;
        String str2 = null;
        double d2 = 0.0d;
        double d3 = 0.0d;
        char c2 = 0;
        while (jsonReader.t()) {
            int D = jsonReader.D(f41852a);
            if (D == 0) {
                c2 = jsonReader.z().charAt(0);
            } else if (D == 1) {
                d2 = jsonReader.w();
            } else if (D == 2) {
                d3 = jsonReader.w();
            } else if (D == 3) {
                str = jsonReader.z();
            } else if (D == 4) {
                str2 = jsonReader.z();
            } else if (D != 5) {
                jsonReader.E();
                jsonReader.F();
            } else {
                jsonReader.o();
                while (jsonReader.t()) {
                    if (jsonReader.D(f41853b) != 0) {
                        jsonReader.E();
                        jsonReader.F();
                    } else {
                        jsonReader.n();
                        while (jsonReader.t()) {
                            arrayList.add((d.a.a.u.j.j) g.a(jsonReader, dVar));
                        }
                        jsonReader.q();
                    }
                }
                jsonReader.r();
            }
        }
        jsonReader.r();
        return new d.a.a.u.c(arrayList, c2, d2, d3, str, str2);
    }
}
