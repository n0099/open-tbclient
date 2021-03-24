package d.a.a.u;

import android.graphics.Path;
import android.util.JsonReader;
import androidx.appcompat.widget.SearchView;
import com.baidu.mobstat.Config;
import java.io.IOException;
/* loaded from: classes.dex */
public class e0 {
    public static d.a.a.s.j.i a(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        String str = null;
        d.a.a.s.i.a aVar = null;
        d.a.a.s.i.d dVar2 = null;
        int i = 1;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -396065730) {
                if (hashCode != 99) {
                    if (hashCode != 111) {
                        if (hashCode != 114) {
                            if (hashCode == 3519 && nextName.equals(SearchView.IME_OPTION_NO_MICROPHONE)) {
                                c2 = 0;
                            }
                        } else if (nextName.equals(com.baidu.mapsdkplatform.comapi.map.r.f7663a)) {
                            c2 = 4;
                        }
                    } else if (nextName.equals(Config.OS)) {
                        c2 = 2;
                    }
                } else if (nextName.equals("c")) {
                    c2 = 1;
                }
            } else if (nextName.equals("fillEnabled")) {
                c2 = 3;
            }
            if (c2 == 0) {
                str = jsonReader.nextString();
            } else if (c2 == 1) {
                aVar = d.c(jsonReader, dVar);
            } else if (c2 == 2) {
                dVar2 = d.h(jsonReader, dVar);
            } else if (c2 == 3) {
                z = jsonReader.nextBoolean();
            } else if (c2 != 4) {
                jsonReader.skipValue();
            } else {
                i = jsonReader.nextInt();
            }
        }
        return new d.a.a.s.j.i(str, z, i == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVar, dVar2);
    }
}
