package d.a.a.w;

import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobstat.Config;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public static JsonReader.a f41763a = JsonReader.a.a(SearchView.IME_OPTION_NO_MICROPHONE, "g", Config.OS, "t", "s", "e", "w", "lc", "lj", "ml", "hd", "d");

    /* renamed from: b  reason: collision with root package name */
    public static final JsonReader.a f41764b = JsonReader.a.a("p", Config.APP_KEY);

    /* renamed from: c  reason: collision with root package name */
    public static final JsonReader.a f41765c = JsonReader.a.a("n", "v");

    public static d.a.a.u.j.e a(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        d.a.a.u.i.c cVar;
        ArrayList arrayList = new ArrayList();
        String str = null;
        GradientType gradientType = null;
        d.a.a.u.i.c cVar2 = null;
        d.a.a.u.i.f fVar = null;
        d.a.a.u.i.f fVar2 = null;
        d.a.a.u.i.b bVar = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        float f2 = 0.0f;
        d.a.a.u.i.b bVar2 = null;
        boolean z = false;
        d.a.a.u.i.d dVar2 = null;
        while (jsonReader.t()) {
            switch (jsonReader.D(f41763a)) {
                case 0:
                    str = jsonReader.z();
                    break;
                case 1:
                    int i = -1;
                    jsonReader.o();
                    while (jsonReader.t()) {
                        int D = jsonReader.D(f41764b);
                        if (D != 0) {
                            cVar = cVar2;
                            if (D != 1) {
                                jsonReader.E();
                                jsonReader.F();
                            } else {
                                cVar2 = d.g(jsonReader, dVar, i);
                            }
                        } else {
                            cVar = cVar2;
                            i = jsonReader.x();
                        }
                        cVar2 = cVar;
                    }
                    jsonReader.r();
                    break;
                case 2:
                    dVar2 = d.h(jsonReader, dVar);
                    break;
                case 3:
                    gradientType = jsonReader.x() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    break;
                case 4:
                    fVar = d.i(jsonReader, dVar);
                    break;
                case 5:
                    fVar2 = d.i(jsonReader, dVar);
                    break;
                case 6:
                    bVar = d.e(jsonReader, dVar);
                    break;
                case 7:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.x() - 1];
                    break;
                case 8:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.x() - 1];
                    break;
                case 9:
                    f2 = (float) jsonReader.w();
                    break;
                case 10:
                    z = jsonReader.v();
                    break;
                case 11:
                    jsonReader.n();
                    while (jsonReader.t()) {
                        jsonReader.o();
                        String str2 = null;
                        d.a.a.u.i.b bVar3 = null;
                        while (jsonReader.t()) {
                            int D2 = jsonReader.D(f41765c);
                            if (D2 != 0) {
                                d.a.a.u.i.b bVar4 = bVar2;
                                if (D2 != 1) {
                                    jsonReader.E();
                                    jsonReader.F();
                                } else {
                                    bVar3 = d.e(jsonReader, dVar);
                                }
                                bVar2 = bVar4;
                            } else {
                                str2 = jsonReader.z();
                            }
                        }
                        d.a.a.u.i.b bVar5 = bVar2;
                        jsonReader.r();
                        if (str2.equals(Config.OS)) {
                            bVar2 = bVar3;
                        } else {
                            if (str2.equals("d") || str2.equals("g")) {
                                dVar.t(true);
                                arrayList.add(bVar3);
                            }
                            bVar2 = bVar5;
                        }
                    }
                    d.a.a.u.i.b bVar6 = bVar2;
                    jsonReader.q();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    bVar2 = bVar6;
                    break;
                default:
                    jsonReader.E();
                    jsonReader.F();
                    break;
            }
        }
        if (dVar2 == null) {
            dVar2 = new d.a.a.u.i.d(Collections.singletonList(new d.a.a.y.a(100)));
        }
        return new d.a.a.u.j.e(str, gradientType, cVar2, dVar2, fVar, fVar2, bVar, lineCapType, lineJoinType, f2, arrayList, bVar2, z);
    }
}
