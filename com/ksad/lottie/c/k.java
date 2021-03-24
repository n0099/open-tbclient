package com.ksad.lottie.c;

import android.util.JsonReader;
/* loaded from: classes6.dex */
public class k {
    public static com.ksad.lottie.model.c a(JsonReader jsonReader) {
        jsonReader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        float f2 = 0.0f;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case -1866931350:
                    if (nextName.equals("fFamily")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1408684838:
                    if (nextName.equals("ascent")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1294566165:
                    if (nextName.equals("fStyle")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 96619537:
                    if (nextName.equals("fName")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                str = jsonReader.nextString();
            } else if (c2 == 1) {
                str2 = jsonReader.nextString();
            } else if (c2 == 2) {
                str3 = jsonReader.nextString();
            } else if (c2 != 3) {
                jsonReader.skipValue();
            } else {
                f2 = (float) jsonReader.nextDouble();
            }
        }
        jsonReader.endObject();
        return new com.ksad.lottie.model.c(str, str2, str3, f2);
    }
}
