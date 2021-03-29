package d.a.a.u;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import com.baidu.mobstat.Config;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class d0 implements j0<d.a.a.s.j.h> {

    /* renamed from: a  reason: collision with root package name */
    public static final d0 f41427a = new d0();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.u.j0
    /* renamed from: b */
    public d.a.a.s.j.h a(JsonReader jsonReader, float f2) throws IOException {
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
        }
        jsonReader.beginObject();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 99) {
                if (hashCode != 105) {
                    if (hashCode != 111) {
                        if (hashCode == 118 && nextName.equals("v")) {
                            c2 = 1;
                        }
                    } else if (nextName.equals(Config.OS)) {
                        c2 = 3;
                    }
                } else if (nextName.equals("i")) {
                    c2 = 2;
                }
            } else if (nextName.equals("c")) {
                c2 = 0;
            }
            if (c2 == 0) {
                z = jsonReader.nextBoolean();
            } else if (c2 == 1) {
                list = p.f(jsonReader, f2);
            } else if (c2 == 2) {
                list2 = p.f(jsonReader, f2);
            } else if (c2 == 3) {
                list3 = p.f(jsonReader, f2);
            }
        }
        jsonReader.endObject();
        if (jsonReader.peek() == JsonToken.END_ARRAY) {
            jsonReader.endArray();
        }
        if (list != null && list2 != null && list3 != null) {
            if (list.isEmpty()) {
                return new d.a.a.s.j.h(new PointF(), false, Collections.emptyList());
            }
            int size = list.size();
            PointF pointF = list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i = 1; i < size; i++) {
                PointF pointF2 = list.get(i);
                int i2 = i - 1;
                arrayList.add(new d.a.a.s.a(d.a.a.v.e.a(list.get(i2), list3.get(i2)), d.a.a.v.e.a(pointF2, list2.get(i)), pointF2));
            }
            if (z) {
                PointF pointF3 = list.get(0);
                int i3 = size - 1;
                arrayList.add(new d.a.a.s.a(d.a.a.v.e.a(list.get(i3), list3.get(i3)), d.a.a.v.e.a(pointF3, list2.get(0)), pointF3));
            }
            return new d.a.a.s.j.h(pointF, z, arrayList);
        }
        throw new IllegalArgumentException("Shape data was missing information.");
    }
}
