package d.a.a.u;

import android.util.JsonReader;
import com.baidu.mobstat.Config;
import java.io.IOException;
/* loaded from: classes.dex */
public class b {
    public static d.a.a.s.i.k a(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        jsonReader.beginObject();
        d.a.a.s.i.k kVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            if (nextName.hashCode() == 97 && nextName.equals("a")) {
                c2 = 0;
            }
            if (c2 != 0) {
                jsonReader.skipValue();
            } else {
                kVar = b(jsonReader, dVar);
            }
        }
        jsonReader.endObject();
        return kVar == null ? new d.a.a.s.i.k(null, null, null, null) : kVar;
    }

    public static d.a.a.s.i.k b(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        jsonReader.beginObject();
        d.a.a.s.i.a aVar = null;
        d.a.a.s.i.a aVar2 = null;
        d.a.a.s.i.b bVar = null;
        d.a.a.s.i.b bVar2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 116) {
                if (hashCode != 3261) {
                    if (hashCode != 3664) {
                        if (hashCode == 3684 && nextName.equals("sw")) {
                            c2 = 2;
                        }
                    } else if (nextName.equals(Config.STAT_SDK_CHANNEL)) {
                        c2 = 1;
                    }
                } else if (nextName.equals("fc")) {
                    c2 = 0;
                }
            } else if (nextName.equals("t")) {
                c2 = 3;
            }
            if (c2 == 0) {
                aVar = d.c(jsonReader, dVar);
            } else if (c2 == 1) {
                aVar2 = d.c(jsonReader, dVar);
            } else if (c2 == 2) {
                bVar = d.e(jsonReader, dVar);
            } else if (c2 != 3) {
                jsonReader.skipValue();
            } else {
                bVar2 = d.e(jsonReader, dVar);
            }
        }
        jsonReader.endObject();
        return new d.a.a.s.i.k(aVar, aVar2, bVar, bVar2);
    }
}
