package d.a.a.w;

import android.graphics.PointF;
import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static JsonReader.a f41840a = JsonReader.a.a(SearchView.IME_OPTION_NO_MICROPHONE, "p", "s", "hd", "d");

    public static d.a.a.u.j.a a(JsonReader jsonReader, d.a.a.d dVar, int i) throws IOException {
        boolean z = i == 3;
        String str = null;
        d.a.a.u.i.m<PointF, PointF> mVar = null;
        d.a.a.u.i.f fVar = null;
        boolean z2 = false;
        while (jsonReader.t()) {
            int D = jsonReader.D(f41840a);
            if (D == 0) {
                str = jsonReader.z();
            } else if (D == 1) {
                mVar = a.b(jsonReader, dVar);
            } else if (D == 2) {
                fVar = d.i(jsonReader, dVar);
            } else if (D == 3) {
                z2 = jsonReader.v();
            } else if (D != 4) {
                jsonReader.E();
                jsonReader.F();
            } else {
                z = jsonReader.x() == 3;
            }
        }
        return new d.a.a.u.j.a(str, mVar, fVar, z, z2);
    }
}
