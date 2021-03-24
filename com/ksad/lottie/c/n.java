package com.ksad.lottie.c;

import android.util.JsonReader;
import androidx.appcompat.widget.SearchView;
import com.baidu.mobstat.Config;
import com.ksad.lottie.model.content.GradientType;
import com.ksad.lottie.model.content.ShapeStroke;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class n {
    public static com.ksad.lottie.model.content.e a(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        char c2;
        ShapeStroke.LineCapType lineCapType;
        ShapeStroke.LineJoinType lineJoinType;
        char c3;
        char c4;
        ArrayList arrayList = new ArrayList();
        String str = null;
        GradientType gradientType = null;
        com.ksad.lottie.model.a.c cVar = null;
        com.ksad.lottie.model.a.d dVar2 = null;
        com.ksad.lottie.model.a.f fVar = null;
        com.ksad.lottie.model.a.f fVar2 = null;
        com.ksad.lottie.model.a.b bVar = null;
        ShapeStroke.LineCapType lineCapType2 = null;
        ShapeStroke.LineJoinType lineJoinType2 = null;
        float f2 = 0.0f;
        com.ksad.lottie.model.a.b bVar2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            int hashCode = nextName.hashCode();
            com.ksad.lottie.model.a.b bVar3 = bVar2;
            float f3 = f2;
            if (hashCode == 100) {
                if (nextName.equals("d")) {
                    c2 = '\n';
                }
                c2 = 65535;
            } else if (hashCode == 101) {
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
            } else if (hashCode == 119) {
                if (nextName.equals("w")) {
                    c2 = 6;
                }
                c2 = 65535;
            } else if (hashCode == 3447) {
                if (nextName.equals("lc")) {
                    c2 = 7;
                }
                c2 = 65535;
            } else if (hashCode == 3454) {
                if (nextName.equals("lj")) {
                    c2 = '\b';
                }
                c2 = 65535;
            } else if (hashCode == 3487) {
                if (nextName.equals("ml")) {
                    c2 = '\t';
                }
                c2 = 65535;
            } else if (hashCode == 3519) {
                if (nextName.equals(SearchView.IME_OPTION_NO_MICROPHONE)) {
                    c2 = 0;
                }
                c2 = 65535;
            } else if (hashCode != 115) {
                if (hashCode == 116 && nextName.equals("t")) {
                    c2 = 3;
                }
                c2 = 65535;
            } else {
                if (nextName.equals("s")) {
                    c2 = 4;
                }
                c2 = 65535;
            }
            switch (c2) {
                case 0:
                    lineCapType = lineCapType2;
                    str = jsonReader.nextString();
                    break;
                case 1:
                    lineCapType = lineCapType2;
                    lineJoinType = lineJoinType2;
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
                    lineJoinType2 = lineJoinType;
                    break;
                case 2:
                    lineCapType = lineCapType2;
                    dVar2 = d.b(jsonReader, dVar);
                    break;
                case 3:
                    lineCapType = lineCapType2;
                    lineJoinType = lineJoinType2;
                    gradientType = jsonReader.nextInt() == 1 ? GradientType.Linear : GradientType.Radial;
                    lineJoinType2 = lineJoinType;
                    break;
                case 4:
                    lineCapType = lineCapType2;
                    fVar = d.c(jsonReader, dVar);
                    break;
                case 5:
                    lineCapType = lineCapType2;
                    fVar2 = d.c(jsonReader, dVar);
                    break;
                case 6:
                    lineCapType = lineCapType2;
                    bVar = d.a(jsonReader, dVar);
                    break;
                case 7:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.nextInt() - 1];
                    lineJoinType2 = lineJoinType2;
                    f2 = f3;
                    continue;
                    bVar2 = bVar3;
                    lineCapType2 = lineCapType;
                case '\b':
                    lineCapType = lineCapType2;
                    lineJoinType2 = ShapeStroke.LineJoinType.values()[jsonReader.nextInt() - 1];
                    break;
                case '\t':
                    lineCapType = lineCapType2;
                    f2 = (float) jsonReader.nextDouble();
                    lineJoinType2 = lineJoinType2;
                    continue;
                    bVar2 = bVar3;
                    lineCapType2 = lineCapType;
                case '\n':
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String str2 = null;
                        com.ksad.lottie.model.a.b bVar4 = null;
                        while (jsonReader.hasNext()) {
                            String nextName3 = jsonReader.nextName();
                            ShapeStroke.LineJoinType lineJoinType3 = lineJoinType2;
                            int hashCode3 = nextName3.hashCode();
                            ShapeStroke.LineCapType lineCapType3 = lineCapType2;
                            if (hashCode3 != 110) {
                                if (hashCode3 == 118 && nextName3.equals("v")) {
                                    c4 = 1;
                                }
                                c4 = 65535;
                            } else {
                                if (nextName3.equals("n")) {
                                    c4 = 0;
                                }
                                c4 = 65535;
                            }
                            if (c4 == 0) {
                                str2 = jsonReader.nextString();
                            } else if (c4 != 1) {
                                jsonReader.skipValue();
                            } else {
                                bVar4 = d.a(jsonReader, dVar);
                            }
                            lineJoinType2 = lineJoinType3;
                            lineCapType2 = lineCapType3;
                        }
                        ShapeStroke.LineCapType lineCapType4 = lineCapType2;
                        ShapeStroke.LineJoinType lineJoinType4 = lineJoinType2;
                        jsonReader.endObject();
                        if (str2.equals(Config.OS)) {
                            bVar3 = bVar4;
                        } else if (str2.equals("d") || str2.equals("g")) {
                            arrayList.add(bVar4);
                        }
                        lineJoinType2 = lineJoinType4;
                        lineCapType2 = lineCapType4;
                    }
                    lineCapType = lineCapType2;
                    lineJoinType = lineJoinType2;
                    jsonReader.endArray();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    lineJoinType2 = lineJoinType;
                    break;
                default:
                    lineCapType = lineCapType2;
                    jsonReader.skipValue();
                    break;
            }
            f2 = f3;
            bVar2 = bVar3;
            lineCapType2 = lineCapType;
        }
        return new com.ksad.lottie.model.content.e(str, gradientType, cVar, dVar2, fVar, fVar2, bVar, lineCapType2, lineJoinType2, f2, arrayList, bVar2);
    }
}
