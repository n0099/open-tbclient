package d.a.a.w;

import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobstat.Config;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes.dex */
public class h0 {

    /* renamed from: a  reason: collision with root package name */
    public static JsonReader.a f41753a = JsonReader.a.a(SearchView.IME_OPTION_NO_MICROPHONE, "c", "w", Config.OS, "lc", "lj", "ml", "hd", "d");

    /* renamed from: b  reason: collision with root package name */
    public static final JsonReader.a f41754b = JsonReader.a.a("n", "v");

    public static ShapeStroke a(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        char c2;
        ArrayList arrayList = new ArrayList();
        String str = null;
        d.a.a.u.i.b bVar = null;
        d.a.a.u.i.a aVar = null;
        d.a.a.u.i.b bVar2 = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        float f2 = 0.0f;
        boolean z = false;
        d.a.a.u.i.d dVar2 = null;
        while (true) {
            int i = 100;
            if (jsonReader.t()) {
                int i2 = 1;
                switch (jsonReader.D(f41753a)) {
                    case 0:
                        str = jsonReader.z();
                        break;
                    case 1:
                        aVar = d.c(jsonReader, dVar);
                        break;
                    case 2:
                        bVar2 = d.e(jsonReader, dVar);
                        break;
                    case 3:
                        dVar2 = d.h(jsonReader, dVar);
                        break;
                    case 4:
                        lineCapType = ShapeStroke.LineCapType.values()[jsonReader.x() - 1];
                        break;
                    case 5:
                        lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.x() - 1];
                        break;
                    case 6:
                        f2 = (float) jsonReader.w();
                        break;
                    case 7:
                        z = jsonReader.v();
                        break;
                    case 8:
                        jsonReader.n();
                        while (jsonReader.t()) {
                            jsonReader.o();
                            d.a.a.u.i.b bVar3 = null;
                            String str2 = null;
                            while (jsonReader.t()) {
                                int D = jsonReader.D(f41754b);
                                if (D == 0) {
                                    str2 = jsonReader.z();
                                } else if (D != i2) {
                                    jsonReader.E();
                                    jsonReader.F();
                                } else {
                                    bVar3 = d.e(jsonReader, dVar);
                                }
                            }
                            jsonReader.r();
                            int hashCode = str2.hashCode();
                            if (hashCode == i) {
                                if (str2.equals("d")) {
                                    c2 = 1;
                                }
                                c2 = 65535;
                            } else if (hashCode != 103) {
                                if (hashCode == 111 && str2.equals(Config.OS)) {
                                    c2 = 0;
                                }
                                c2 = 65535;
                            } else {
                                if (str2.equals("g")) {
                                    c2 = 2;
                                }
                                c2 = 65535;
                            }
                            if (c2 == 0) {
                                bVar = bVar3;
                            } else if (c2 == 1 || c2 == 2) {
                                dVar.t(true);
                                arrayList.add(bVar3);
                            }
                            i = 100;
                            i2 = 1;
                        }
                        jsonReader.q();
                        if (arrayList.size() != 1) {
                            break;
                        } else {
                            arrayList.add(arrayList.get(0));
                            break;
                        }
                    default:
                        jsonReader.F();
                        break;
                }
            } else {
                if (dVar2 == null) {
                    dVar2 = new d.a.a.u.i.d(Collections.singletonList(new d.a.a.y.a(100)));
                }
                return new ShapeStroke(str, bVar, arrayList, aVar, dVar2, bVar2, lineCapType, lineJoinType, f2, z);
            }
        }
    }
}
