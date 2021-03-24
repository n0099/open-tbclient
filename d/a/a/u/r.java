package d.a.a.u;

import android.util.JsonReader;
import android.util.JsonToken;
import com.baidu.mobstat.Config;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    public static <T> List<d.a.a.w.a<T>> a(JsonReader jsonReader, d.a.a.d dVar, float f2, j0<T> j0Var) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.peek() == JsonToken.STRING) {
            dVar.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            if (nextName.hashCode() == 107 && nextName.equals(Config.APP_KEY)) {
                c2 = 0;
            }
            if (c2 != 0) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                if (jsonReader.peek() == JsonToken.NUMBER) {
                    arrayList.add(q.b(jsonReader, dVar, f2, j0Var, false));
                } else {
                    while (jsonReader.hasNext()) {
                        arrayList.add(q.b(jsonReader, dVar, f2, j0Var, true));
                    }
                }
                jsonReader.endArray();
            } else {
                arrayList.add(q.b(jsonReader, dVar, f2, j0Var, false));
            }
        }
        jsonReader.endObject();
        b(arrayList);
        return arrayList;
    }

    public static void b(List<? extends d.a.a.w.a<?>> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            i2++;
            list.get(i2).f41454f = Float.valueOf(list.get(i2).f41453e);
        }
        d.a.a.w.a<?> aVar = list.get(i);
        if (aVar.f41450b == 0) {
            list.remove(aVar);
        }
    }
}
