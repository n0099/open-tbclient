package d.a.a.w;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobstat.Config;
import java.io.IOException;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static JsonReader.a f41737a = JsonReader.a.a("a");

    /* renamed from: b  reason: collision with root package name */
    public static JsonReader.a f41738b = JsonReader.a.a("fc", Config.STAT_SDK_CHANNEL, "sw", "t");

    public static d.a.a.u.i.k a(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        jsonReader.o();
        d.a.a.u.i.k kVar = null;
        while (jsonReader.t()) {
            if (jsonReader.D(f41737a) != 0) {
                jsonReader.E();
                jsonReader.F();
            } else {
                kVar = b(jsonReader, dVar);
            }
        }
        jsonReader.r();
        return kVar == null ? new d.a.a.u.i.k(null, null, null, null) : kVar;
    }

    public static d.a.a.u.i.k b(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        jsonReader.o();
        d.a.a.u.i.a aVar = null;
        d.a.a.u.i.a aVar2 = null;
        d.a.a.u.i.b bVar = null;
        d.a.a.u.i.b bVar2 = null;
        while (jsonReader.t()) {
            int D = jsonReader.D(f41738b);
            if (D == 0) {
                aVar = d.c(jsonReader, dVar);
            } else if (D == 1) {
                aVar2 = d.c(jsonReader, dVar);
            } else if (D == 2) {
                bVar = d.e(jsonReader, dVar);
            } else if (D != 3) {
                jsonReader.E();
                jsonReader.F();
            } else {
                bVar2 = d.e(jsonReader, dVar);
            }
        }
        jsonReader.r();
        return new d.a.a.u.i.k(aVar, aVar2, bVar, bVar2);
    }
}
