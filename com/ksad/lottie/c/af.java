package com.ksad.lottie.c;

import android.util.JsonReader;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class af {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.ksad.lottie.model.content.j a(JsonReader jsonReader, com.ksad.lottie.d dVar) {
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
                        com.ksad.lottie.model.content.b a2 = g.a(jsonReader, dVar);
                        if (a2 != null) {
                            arrayList.add(a2);
                        }
                    }
                    jsonReader.endArray();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.ksad.lottie.model.content.j(str, arrayList);
    }
}
