package com.ksad.lottie.c;

import android.graphics.Path;
import android.util.JsonReader;
import com.baidu.mobstat.Config;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ae {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.ksad.lottie.model.content.i a(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        int i = 1;
        String str = null;
        com.ksad.lottie.model.a.d dVar2 = null;
        boolean z = false;
        com.ksad.lottie.model.a.a aVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -396065730:
                    if (nextName.equals("fillEnabled")) {
                        c = 3;
                        break;
                    }
                    break;
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
                case 114:
                    if (nextName.equals("r")) {
                        c = 4;
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
                    aVar = d.g(jsonReader, dVar);
                    break;
                case 2:
                    dVar2 = d.b(jsonReader, dVar);
                    break;
                case 3:
                    z = jsonReader.nextBoolean();
                    break;
                case 4:
                    i = jsonReader.nextInt();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.ksad.lottie.model.content.i(str, z, i == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVar, dVar2);
    }
}
