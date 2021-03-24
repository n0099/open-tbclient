package d.a.a.u;

import android.graphics.PointF;
import android.util.JsonReader;
import androidx.appcompat.widget.SearchView;
import java.io.IOException;
/* loaded from: classes.dex */
public class e {
    public static d.a.a.s.j.a a(JsonReader jsonReader, d.a.a.d dVar, int i) throws IOException {
        boolean z = i == 3;
        String str = null;
        d.a.a.s.i.m<PointF, PointF> mVar = null;
        d.a.a.s.i.f fVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 100) {
                if (hashCode != 112) {
                    if (hashCode != 115) {
                        if (hashCode == 3519 && nextName.equals(SearchView.IME_OPTION_NO_MICROPHONE)) {
                            c2 = 0;
                        }
                    } else if (nextName.equals("s")) {
                        c2 = 2;
                    }
                } else if (nextName.equals("p")) {
                    c2 = 1;
                }
            } else if (nextName.equals("d")) {
                c2 = 3;
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
                z = jsonReader.nextInt() == 3;
            }
        }
        return new d.a.a.s.j.a(str, mVar, fVar, z);
    }
}
