package com.tb.airbnb.lottie.c;

import android.util.JsonReader;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.io.IOException;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes17.dex */
public class af {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.tb.airbnb.lottie.model.content.j x(JsonReader jsonReader, com.tb.airbnb.lottie.e eVar) throws IOException {
        String str = null;
        ArrayList arrayList = new ArrayList();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 3371:
                    if (nextName.equals(AdvanceSetting.NETWORK_TYPE)) {
                        c = 1;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.tb.airbnb.lottie.model.content.b m = g.m(jsonReader, eVar);
                        if (m != null) {
                            arrayList.add(m);
                        }
                    }
                    jsonReader.endArray();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.tb.airbnb.lottie.model.content.j(str, arrayList);
    }
}
