package com.ksad.lottie.c;

import android.graphics.Path;
import android.util.JsonReader;
import androidx.appcompat.widget.SearchView;
import com.baidu.mobstat.Config;
import com.ksad.lottie.model.content.GradientType;
/* loaded from: classes6.dex */
public class m {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static com.ksad.lottie.model.content.d a(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        char c2;
        char c3;
        String str = null;
        GradientType gradientType = null;
        Path.FillType fillType = null;
        com.ksad.lottie.model.a.c cVar = null;
        com.ksad.lottie.model.a.d dVar2 = null;
        com.ksad.lottie.model.a.f fVar = null;
        com.ksad.lottie.model.a.f fVar2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            if (hashCode == 101) {
                if (nextName.equals("e")) {
                    c2 = 5;
                }
                c2 = 65535;
            } else if (hashCode == 103) {
                if (nextName.equals("g")) {
                    c2 = 1;
                }
                c2 = 65535;
            } else if (hashCode == 111) {
                if (nextName.equals(Config.OS)) {
                    c2 = 2;
                }
                c2 = 65535;
            } else if (hashCode != 3519) {
                switch (hashCode) {
                    case 114:
                        if (nextName.equals(com.baidu.mapsdkplatform.comapi.map.r.f7699a)) {
                            c2 = 6;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 115:
                        if (nextName.equals("s")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 116:
                        if (nextName.equals("t")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
            } else {
                if (nextName.equals(SearchView.IME_OPTION_NO_MICROPHONE)) {
                    c2 = 0;
                }
                c2 = 65535;
            }
            switch (c2) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    jsonReader.beginObject();
                    int i = -1;
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        int hashCode2 = nextName2.hashCode();
                        if (hashCode2 != 107) {
                            if (hashCode2 == 112 && nextName2.equals("p")) {
                                c3 = 0;
                            }
                            c3 = 65535;
                        } else {
                            if (nextName2.equals(Config.APP_KEY)) {
                                c3 = 1;
                            }
                            c3 = 65535;
                        }
                        if (c3 == 0) {
                            i = jsonReader.nextInt();
                        } else if (c3 != 1) {
                            jsonReader.skipValue();
                        } else {
                            cVar = d.a(jsonReader, dVar, i);
                        }
                    }
                    jsonReader.endObject();
                    break;
                case 2:
                    dVar2 = d.b(jsonReader, dVar);
                    break;
                case 3:
                    gradientType = jsonReader.nextInt() == 1 ? GradientType.Linear : GradientType.Radial;
                    break;
                case 4:
                    fVar = d.c(jsonReader, dVar);
                    break;
                case 5:
                    fVar2 = d.c(jsonReader, dVar);
                    break;
                case 6:
                    fillType = jsonReader.nextInt() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.ksad.lottie.model.content.d(str, gradientType, fillType, cVar, dVar2, fVar, fVar2, null, null);
    }
}
