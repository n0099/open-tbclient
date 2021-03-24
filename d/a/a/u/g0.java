package d.a.a.u;

import android.util.JsonReader;
import androidx.appcompat.widget.SearchView;
import com.fun.ad.sdk.FunAdSdk;
import java.io.IOException;
/* loaded from: classes.dex */
public class g0 {
    public static d.a.a.s.j.k a(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        String str = null;
        d.a.a.s.i.h hVar = null;
        int i = 0;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 3432) {
                if (hashCode != 3519) {
                    if (hashCode == 104415 && nextName.equals("ind")) {
                        c2 = 1;
                    }
                } else if (nextName.equals(SearchView.IME_OPTION_NO_MICROPHONE)) {
                    c2 = 0;
                }
            } else if (nextName.equals(FunAdSdk.PLATFORM_KS)) {
                c2 = 2;
            }
            if (c2 == 0) {
                str = jsonReader.nextString();
            } else if (c2 == 1) {
                i = jsonReader.nextInt();
            } else if (c2 != 2) {
                jsonReader.skipValue();
            } else {
                hVar = d.k(jsonReader, dVar);
            }
        }
        return new d.a.a.s.j.k(str, i, hVar);
    }
}
