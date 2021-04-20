package d.a.a.w;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobstat.Config;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class d0 implements j0<d.a.a.u.j.h> {

    /* renamed from: a  reason: collision with root package name */
    public static final d0 f41743a = new d0();

    /* renamed from: b  reason: collision with root package name */
    public static final JsonReader.a f41744b = JsonReader.a.a("c", "v", "i", Config.OS);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.a.w.j0
    /* renamed from: b */
    public d.a.a.u.j.h a(JsonReader jsonReader, float f2) throws IOException {
        if (jsonReader.B() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.n();
        }
        jsonReader.o();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z = false;
        while (jsonReader.t()) {
            int D = jsonReader.D(f41744b);
            if (D == 0) {
                z = jsonReader.v();
            } else if (D == 1) {
                list = p.f(jsonReader, f2);
            } else if (D == 2) {
                list2 = p.f(jsonReader, f2);
            } else if (D != 3) {
                jsonReader.E();
                jsonReader.F();
            } else {
                list3 = p.f(jsonReader, f2);
            }
        }
        jsonReader.r();
        if (jsonReader.B() == JsonReader.Token.END_ARRAY) {
            jsonReader.q();
        }
        if (list != null && list2 != null && list3 != null) {
            if (list.isEmpty()) {
                return new d.a.a.u.j.h(new PointF(), false, Collections.emptyList());
            }
            int size = list.size();
            PointF pointF = list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i = 1; i < size; i++) {
                PointF pointF2 = list.get(i);
                int i2 = i - 1;
                arrayList.add(new d.a.a.u.a(d.a.a.x.g.a(list.get(i2), list3.get(i2)), d.a.a.x.g.a(pointF2, list2.get(i)), pointF2));
            }
            if (z) {
                PointF pointF3 = list.get(0);
                int i3 = size - 1;
                arrayList.add(new d.a.a.u.a(d.a.a.x.g.a(list.get(i3), list3.get(i3)), d.a.a.x.g.a(pointF3, list2.get(0)), pointF3));
            }
            return new d.a.a.u.j.h(pointF, z, arrayList);
        }
        throw new IllegalArgumentException("Shape data was missing information.");
    }
}
