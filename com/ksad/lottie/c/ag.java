package com.ksad.lottie.c;

import android.util.JsonReader;
import com.fun.ad.sdk.FunAdSdk;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ag {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.ksad.lottie.model.content.k a(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        com.ksad.lottie.model.a.h hVar = null;
        int i = 0;
        String str = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 3432:
                    if (nextName.equals(FunAdSdk.PLATFORM_KS)) {
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
                case 104415:
                    if (nextName.equals("ind")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    i = jsonReader.nextInt();
                    break;
                case 2:
                    hVar = d.e(jsonReader, dVar);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.ksad.lottie.model.content.k(str, i, hVar);
    }
}
