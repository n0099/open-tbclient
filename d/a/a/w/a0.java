package d.a.a.w;

import android.graphics.PointF;
import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* loaded from: classes.dex */
public class a0 {

    /* renamed from: a  reason: collision with root package name */
    public static JsonReader.a f41736a = JsonReader.a.a(SearchView.IME_OPTION_NO_MICROPHONE, "p", "s", com.baidu.mapsdkplatform.comapi.map.r.f7699a, "hd");

    public static d.a.a.u.j.f a(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        String str = null;
        d.a.a.u.i.m<PointF, PointF> mVar = null;
        d.a.a.u.i.f fVar = null;
        d.a.a.u.i.b bVar = null;
        boolean z = false;
        while (jsonReader.t()) {
            int D = jsonReader.D(f41736a);
            if (D == 0) {
                str = jsonReader.z();
            } else if (D == 1) {
                mVar = a.b(jsonReader, dVar);
            } else if (D == 2) {
                fVar = d.i(jsonReader, dVar);
            } else if (D == 3) {
                bVar = d.e(jsonReader, dVar);
            } else if (D != 4) {
                jsonReader.F();
            } else {
                z = jsonReader.v();
            }
        }
        return new d.a.a.u.j.f(str, mVar, fVar, bVar, z);
    }
}
