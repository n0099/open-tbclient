package d.a.a.w;

import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobstat.Config;
import java.io.IOException;
/* loaded from: classes.dex */
public class b0 {

    /* renamed from: a  reason: collision with root package name */
    public static JsonReader.a f41834a = JsonReader.a.a(SearchView.IME_OPTION_NO_MICROPHONE, "c", Config.OS, "tr", "hd");

    public static d.a.a.u.j.g a(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        String str = null;
        d.a.a.u.i.b bVar = null;
        d.a.a.u.i.b bVar2 = null;
        d.a.a.u.i.l lVar = null;
        boolean z = false;
        while (jsonReader.t()) {
            int D = jsonReader.D(f41834a);
            if (D == 0) {
                str = jsonReader.z();
            } else if (D == 1) {
                bVar = d.f(jsonReader, dVar, false);
            } else if (D == 2) {
                bVar2 = d.f(jsonReader, dVar, false);
            } else if (D == 3) {
                lVar = c.g(jsonReader, dVar);
            } else if (D != 4) {
                jsonReader.F();
            } else {
                z = jsonReader.v();
            }
        }
        return new d.a.a.u.j.g(str, bVar, bVar2, lVar, z);
    }
}
