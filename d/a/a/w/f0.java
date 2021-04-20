package d.a.a.w;

import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f0 {

    /* renamed from: a  reason: collision with root package name */
    public static JsonReader.a f41748a = JsonReader.a.a(SearchView.IME_OPTION_NO_MICROPHONE, "hd", AdvanceSetting.NETWORK_TYPE);

    public static d.a.a.u.j.j a(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z = false;
        while (jsonReader.t()) {
            int D = jsonReader.D(f41748a);
            if (D == 0) {
                str = jsonReader.z();
            } else if (D == 1) {
                z = jsonReader.v();
            } else if (D != 2) {
                jsonReader.F();
            } else {
                jsonReader.n();
                while (jsonReader.t()) {
                    d.a.a.u.j.b a2 = g.a(jsonReader, dVar);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                jsonReader.q();
            }
        }
        return new d.a.a.u.j.j(str, arrayList, z);
    }
}
