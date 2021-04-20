package d.a.a.w;

import android.graphics.Path;
import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobstat.Config;
import java.io.IOException;
import java.util.Collections;
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonReader.a f41761a = JsonReader.a.a(SearchView.IME_OPTION_NO_MICROPHONE, "g", Config.OS, "t", "s", "e", com.baidu.mapsdkplatform.comapi.map.r.f7699a, "hd");

    /* renamed from: b  reason: collision with root package name */
    public static final JsonReader.a f41762b = JsonReader.a.a("p", Config.APP_KEY);

    public static d.a.a.u.j.d a(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        d.a.a.u.i.d dVar2 = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String str = null;
        GradientType gradientType = null;
        d.a.a.u.i.c cVar = null;
        d.a.a.u.i.f fVar = null;
        d.a.a.u.i.f fVar2 = null;
        boolean z = false;
        while (jsonReader.t()) {
            switch (jsonReader.D(f41761a)) {
                case 0:
                    str = jsonReader.z();
                    break;
                case 1:
                    int i = -1;
                    jsonReader.o();
                    while (jsonReader.t()) {
                        int D = jsonReader.D(f41762b);
                        if (D == 0) {
                            i = jsonReader.x();
                        } else if (D != 1) {
                            jsonReader.E();
                            jsonReader.F();
                        } else {
                            cVar = d.g(jsonReader, dVar, i);
                        }
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
                    fillType = jsonReader.x() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    z = jsonReader.v();
                    break;
                default:
                    jsonReader.E();
                    jsonReader.F();
                    break;
            }
        }
        return new d.a.a.u.j.d(str, gradientType, fillType, cVar, dVar2 == null ? new d.a.a.u.i.d(Collections.singletonList(new d.a.a.y.a(100))) : dVar2, fVar, fVar2, null, null, z);
    }
}
