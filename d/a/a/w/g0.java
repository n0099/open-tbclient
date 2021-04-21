package d.a.a.w;

import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.fun.ad.sdk.FunAdSdk;
import java.io.IOException;
/* loaded from: classes.dex */
public class g0 {

    /* renamed from: a  reason: collision with root package name */
    public static JsonReader.a f41845a = JsonReader.a.a(SearchView.IME_OPTION_NO_MICROPHONE, "ind", FunAdSdk.PLATFORM_KS, "hd");

    public static d.a.a.u.j.k a(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        int i = 0;
        String str = null;
        d.a.a.u.i.h hVar = null;
        boolean z = false;
        while (jsonReader.t()) {
            int D = jsonReader.D(f41845a);
            if (D == 0) {
                str = jsonReader.z();
            } else if (D == 1) {
                i = jsonReader.x();
            } else if (D == 2) {
                hVar = d.k(jsonReader, dVar);
            } else if (D != 3) {
                jsonReader.F();
            } else {
                z = jsonReader.v();
            }
        }
        return new d.a.a.u.j.k(str, i, hVar, z);
    }
}
