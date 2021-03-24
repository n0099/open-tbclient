package d.a.a.u;

import android.util.JsonReader;
import androidx.appcompat.widget.SearchView;
import com.baidu.mobstat.Config;
import java.io.IOException;
/* loaded from: classes.dex */
public class b0 {
    public static d.a.a.s.j.g a(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        String str = null;
        d.a.a.s.i.b bVar = null;
        d.a.a.s.i.b bVar2 = null;
        d.a.a.s.i.l lVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 99) {
                if (hashCode != 111) {
                    if (hashCode != 3519) {
                        if (hashCode == 3710 && nextName.equals("tr")) {
                            c2 = 3;
                        }
                    } else if (nextName.equals(SearchView.IME_OPTION_NO_MICROPHONE)) {
                        c2 = 0;
                    }
                } else if (nextName.equals(Config.OS)) {
                    c2 = 2;
                }
            } else if (nextName.equals("c")) {
                c2 = 1;
            }
            if (c2 == 0) {
                str = jsonReader.nextString();
            } else if (c2 == 1) {
                bVar = d.f(jsonReader, dVar, false);
            } else if (c2 == 2) {
                bVar2 = d.f(jsonReader, dVar, false);
            } else if (c2 != 3) {
                jsonReader.skipValue();
            } else {
                lVar = c.a(jsonReader, dVar);
            }
        }
        return new d.a.a.s.j.g(str, bVar, bVar2, lVar);
    }
}
