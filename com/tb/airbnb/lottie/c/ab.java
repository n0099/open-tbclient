package com.tb.airbnb.lottie.c;

import android.util.JsonReader;
import com.baidu.mobstat.Config;
import java.io.IOException;
/* loaded from: classes17.dex */
class ab {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.tb.airbnb.lottie.model.content.g v(JsonReader jsonReader, com.tb.airbnb.lottie.e eVar) throws IOException {
        com.tb.airbnb.lottie.model.a.l lVar = null;
        com.tb.airbnb.lottie.model.a.b bVar = null;
        com.tb.airbnb.lottie.model.a.b bVar2 = null;
        String str = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 99:
                    if (nextName.equals("c")) {
                        c = 1;
                        break;
                    }
                    break;
                case 111:
                    if (nextName.equals(Config.OS)) {
                        c = 2;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c = 0;
                        break;
                    }
                    break;
                case 3710:
                    if (nextName.equals("tr")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    bVar2 = d.a(jsonReader, eVar, false);
                    break;
                case 2:
                    bVar = d.a(jsonReader, eVar, false);
                    break;
                case 3:
                    lVar = c.e(jsonReader, eVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.tb.airbnb.lottie.model.content.g(str, bVar2, bVar, lVar);
    }
}
