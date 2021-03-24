package d.a.a.u;

import android.graphics.PointF;
import android.util.JsonReader;
import androidx.appcompat.widget.SearchView;
import java.io.IOException;
/* loaded from: classes.dex */
public class a0 {
    public static d.a.a.s.j.f a(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        String str = null;
        d.a.a.s.i.m<PointF, PointF> mVar = null;
        d.a.a.s.i.f fVar = null;
        d.a.a.s.i.b bVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 112) {
                if (hashCode != 3519) {
                    if (hashCode != 114) {
                        if (hashCode == 115 && nextName.equals("s")) {
                            c2 = 2;
                        }
                    } else if (nextName.equals(com.baidu.mapsdkplatform.comapi.map.r.f7663a)) {
                        c2 = 3;
                    }
                } else if (nextName.equals(SearchView.IME_OPTION_NO_MICROPHONE)) {
                    c2 = 0;
                }
            } else if (nextName.equals("p")) {
                c2 = 1;
            }
            if (c2 == 0) {
                str = jsonReader.nextString();
            } else if (c2 == 1) {
                mVar = a.b(jsonReader, dVar);
            } else if (c2 == 2) {
                fVar = d.i(jsonReader, dVar);
            } else if (c2 != 3) {
                jsonReader.skipValue();
            } else {
                bVar = d.e(jsonReader, dVar);
            }
        }
        return new d.a.a.s.j.f(str, mVar, fVar, bVar);
    }
}
