package d.a.a.w;

import android.graphics.Path;
import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobstat.Config;
import java.io.IOException;
import java.util.Collections;
/* loaded from: classes.dex */
public class e0 {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonReader.a f41746a = JsonReader.a.a(SearchView.IME_OPTION_NO_MICROPHONE, "c", Config.OS, "fillEnabled", com.baidu.mapsdkplatform.comapi.map.r.f7699a, "hd");

    public static d.a.a.u.j.i a(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        d.a.a.u.i.d dVar2 = null;
        String str = null;
        d.a.a.u.i.a aVar = null;
        int i = 1;
        boolean z = false;
        boolean z2 = false;
        while (jsonReader.t()) {
            int D = jsonReader.D(f41746a);
            if (D == 0) {
                str = jsonReader.z();
            } else if (D == 1) {
                aVar = d.c(jsonReader, dVar);
            } else if (D == 2) {
                dVar2 = d.h(jsonReader, dVar);
            } else if (D == 3) {
                z = jsonReader.v();
            } else if (D == 4) {
                i = jsonReader.x();
            } else if (D != 5) {
                jsonReader.E();
                jsonReader.F();
            } else {
                z2 = jsonReader.v();
            }
        }
        return new d.a.a.u.j.i(str, z, i == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVar, dVar2 == null ? new d.a.a.u.i.d(Collections.singletonList(new d.a.a.y.a(100))) : dVar2, z2);
    }
}
