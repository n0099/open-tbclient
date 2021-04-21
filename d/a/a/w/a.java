package d.a.a.w;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobstat.Config;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static JsonReader.a f41830a = JsonReader.a.a(Config.APP_KEY, "x", "y");

    public static d.a.a.u.i.e a(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.B() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.n();
            while (jsonReader.t()) {
                arrayList.add(w.a(jsonReader, dVar));
            }
            jsonReader.q();
            r.b(arrayList);
        } else {
            arrayList.add(new d.a.a.y.a(p.e(jsonReader, d.a.a.x.h.e())));
        }
        return new d.a.a.u.i.e(arrayList);
    }

    public static d.a.a.u.i.m<PointF, PointF> b(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        jsonReader.o();
        d.a.a.u.i.e eVar = null;
        d.a.a.u.i.b bVar = null;
        d.a.a.u.i.b bVar2 = null;
        boolean z = false;
        while (jsonReader.B() != JsonReader.Token.END_OBJECT) {
            int D = jsonReader.D(f41830a);
            if (D == 0) {
                eVar = a(jsonReader, dVar);
            } else if (D != 1) {
                if (D != 2) {
                    jsonReader.E();
                    jsonReader.F();
                } else if (jsonReader.B() == JsonReader.Token.STRING) {
                    jsonReader.F();
                    z = true;
                } else {
                    bVar2 = d.e(jsonReader, dVar);
                }
            } else if (jsonReader.B() == JsonReader.Token.STRING) {
                jsonReader.F();
                z = true;
            } else {
                bVar = d.e(jsonReader, dVar);
            }
        }
        jsonReader.r();
        if (z) {
            dVar.a("Lottie doesn't support expressions.");
        }
        return eVar != null ? eVar : new d.a.a.u.i.i(bVar, bVar2);
    }
}
