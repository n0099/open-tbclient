package d.a.a.u;

import android.util.JsonReader;
import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.baidu.mobstat.Config;
import java.io.IOException;
/* loaded from: classes.dex */
public class i0 {
    public static ShapeTrimPath a(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        String str = null;
        ShapeTrimPath.Type type = null;
        d.a.a.s.i.b bVar = null;
        d.a.a.s.i.b bVar2 = null;
        d.a.a.s.i.b bVar3 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 101) {
                if (hashCode != 109) {
                    if (hashCode != 111) {
                        if (hashCode != 115) {
                            if (hashCode == 3519 && nextName.equals(SearchView.IME_OPTION_NO_MICROPHONE)) {
                                c2 = 3;
                            }
                        } else if (nextName.equals("s")) {
                            c2 = 0;
                        }
                    } else if (nextName.equals(Config.OS)) {
                        c2 = 2;
                    }
                } else if (nextName.equals("m")) {
                    c2 = 4;
                }
            } else if (nextName.equals("e")) {
                c2 = 1;
            }
            if (c2 == 0) {
                bVar = d.f(jsonReader, dVar, false);
            } else if (c2 == 1) {
                bVar2 = d.f(jsonReader, dVar, false);
            } else if (c2 == 2) {
                bVar3 = d.f(jsonReader, dVar, false);
            } else if (c2 == 3) {
                str = jsonReader.nextString();
            } else if (c2 != 4) {
                jsonReader.skipValue();
            } else {
                type = ShapeTrimPath.Type.forId(jsonReader.nextInt());
            }
        }
        return new ShapeTrimPath(str, type, bVar, bVar2, bVar3);
    }
}
