package d.a.a.w;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobstat.Config;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public static JsonReader.a f41867a = JsonReader.a.a(Config.APP_KEY);

    public static <T> List<d.a.a.y.a<T>> a(JsonReader jsonReader, d.a.a.d dVar, float f2, j0<T> j0Var) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.B() == JsonReader.Token.STRING) {
            dVar.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.o();
        while (jsonReader.t()) {
            if (jsonReader.D(f41867a) != 0) {
                jsonReader.F();
            } else if (jsonReader.B() == JsonReader.Token.BEGIN_ARRAY) {
                jsonReader.n();
                if (jsonReader.B() == JsonReader.Token.NUMBER) {
                    arrayList.add(q.b(jsonReader, dVar, f2, j0Var, false));
                } else {
                    while (jsonReader.t()) {
                        arrayList.add(q.b(jsonReader, dVar, f2, j0Var, true));
                    }
                }
                jsonReader.q();
            } else {
                arrayList.add(q.b(jsonReader, dVar, f2, j0Var, false));
            }
        }
        jsonReader.r();
        b(arrayList);
        return arrayList;
    }

    public static <T> void b(List<? extends d.a.a.y.a<T>> list) {
        int i;
        T t;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            d.a.a.y.a<T> aVar = list.get(i2);
            i2++;
            d.a.a.y.a<T> aVar2 = list.get(i2);
            aVar.f41900f = Float.valueOf(aVar2.f41899e);
            if (aVar.f41897c == null && (t = aVar2.f41896b) != null) {
                aVar.f41897c = t;
                if (aVar instanceof d.a.a.s.c.h) {
                    ((d.a.a.s.c.h) aVar).i();
                }
            }
        }
        d.a.a.y.a<T> aVar3 = list.get(i);
        if ((aVar3.f41896b == null || aVar3.f41897c == null) && list.size() > 1) {
            list.remove(aVar3);
        }
    }
}
