package d.a.a.u;

import android.util.JsonReader;
import androidx.appcompat.widget.SearchView;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f0 {
    public static d.a.a.s.j.j a(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String str = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 3371) {
                if (hashCode == 3519 && nextName.equals(SearchView.IME_OPTION_NO_MICROPHONE)) {
                    c2 = 0;
                }
            } else if (nextName.equals(AdvanceSetting.NETWORK_TYPE)) {
                c2 = 1;
            }
            if (c2 == 0) {
                str = jsonReader.nextString();
            } else if (c2 != 1) {
                jsonReader.skipValue();
            } else {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    d.a.a.s.j.b a2 = g.a(jsonReader, dVar);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                jsonReader.endArray();
            }
        }
        return new d.a.a.s.j.j(str, arrayList);
    }
}
