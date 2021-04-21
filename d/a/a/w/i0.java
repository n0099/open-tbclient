package d.a.a.w;

import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobstat.Config;
import java.io.IOException;
/* loaded from: classes.dex */
public class i0 {

    /* renamed from: a  reason: collision with root package name */
    public static JsonReader.a f41851a = JsonReader.a.a("s", "e", Config.OS, SearchView.IME_OPTION_NO_MICROPHONE, "m", "hd");

    public static ShapeTrimPath a(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        String str = null;
        ShapeTrimPath.Type type = null;
        d.a.a.u.i.b bVar = null;
        d.a.a.u.i.b bVar2 = null;
        d.a.a.u.i.b bVar3 = null;
        boolean z = false;
        while (jsonReader.t()) {
            int D = jsonReader.D(f41851a);
            if (D == 0) {
                bVar = d.f(jsonReader, dVar, false);
            } else if (D == 1) {
                bVar2 = d.f(jsonReader, dVar, false);
            } else if (D == 2) {
                bVar3 = d.f(jsonReader, dVar, false);
            } else if (D == 3) {
                str = jsonReader.z();
            } else if (D == 4) {
                type = ShapeTrimPath.Type.forId(jsonReader.x());
            } else if (D != 5) {
                jsonReader.F();
            } else {
                z = jsonReader.v();
            }
        }
        return new ShapeTrimPath(str, type, bVar, bVar2, bVar3, z);
    }
}
