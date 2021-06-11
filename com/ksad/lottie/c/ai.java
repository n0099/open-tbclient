package com.ksad.lottie.c;

import android.util.JsonReader;
import androidx.appcompat.widget.SearchView;
import com.baidu.mobstat.Config;
import com.ksad.lottie.model.content.ShapeTrimPath;
/* loaded from: classes6.dex */
public class ai {
    public static ShapeTrimPath a(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        String str = null;
        ShapeTrimPath.Type type = null;
        com.ksad.lottie.model.a.b bVar = null;
        com.ksad.lottie.model.a.b bVar2 = null;
        com.ksad.lottie.model.a.b bVar3 = null;
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
                bVar = d.a(jsonReader, dVar, false);
            } else if (c2 == 1) {
                bVar2 = d.a(jsonReader, dVar, false);
            } else if (c2 == 2) {
                bVar3 = d.a(jsonReader, dVar, false);
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
