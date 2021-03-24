package d.a.a.u;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.baidu.mobstat.Config;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    public static d.a.a.s.i.e a(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                arrayList.add(w.a(jsonReader, dVar));
            }
            jsonReader.endArray();
            r.b(arrayList);
        } else {
            arrayList.add(new d.a.a.w.a(p.e(jsonReader, d.a.a.v.f.e())));
        }
        return new d.a.a.s.i.e(arrayList);
    }

    public static d.a.a.s.i.m<PointF, PointF> b(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        jsonReader.beginObject();
        d.a.a.s.i.e eVar = null;
        d.a.a.s.i.b bVar = null;
        d.a.a.s.i.b bVar2 = null;
        boolean z = false;
        while (jsonReader.peek() != JsonToken.END_OBJECT) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 107) {
                if (hashCode != 120) {
                    if (hashCode == 121 && nextName.equals("y")) {
                        c2 = 2;
                    }
                } else if (nextName.equals("x")) {
                    c2 = 1;
                }
            } else if (nextName.equals(Config.APP_KEY)) {
                c2 = 0;
            }
            if (c2 == 0) {
                eVar = a(jsonReader, dVar);
            } else if (c2 != 1) {
                if (c2 != 2) {
                    jsonReader.skipValue();
                } else if (jsonReader.peek() == JsonToken.STRING) {
                    jsonReader.skipValue();
                    z = true;
                } else {
                    bVar2 = d.e(jsonReader, dVar);
                }
            } else if (jsonReader.peek() == JsonToken.STRING) {
                jsonReader.skipValue();
                z = true;
            } else {
                bVar = d.e(jsonReader, dVar);
            }
        }
        jsonReader.endObject();
        if (z) {
            dVar.a("Lottie doesn't support expressions.");
        }
        return eVar != null ? eVar : new d.a.a.s.i.i(bVar, bVar2);
    }
}
