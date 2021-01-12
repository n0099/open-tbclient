package com.ksad.lottie.c;

import android.util.JsonReader;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.ksad.lottie.model.content.GradientType;
import com.ksad.lottie.model.content.ShapeStroke;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class n {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.ksad.lottie.model.content.e a(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        String str = null;
        com.ksad.lottie.model.a.c cVar = null;
        com.ksad.lottie.model.a.d dVar2 = null;
        GradientType gradientType = null;
        com.ksad.lottie.model.a.f fVar = null;
        com.ksad.lottie.model.a.f fVar2 = null;
        com.ksad.lottie.model.a.b bVar = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        com.ksad.lottie.model.a.b bVar2 = null;
        float f = 0.0f;
        ArrayList arrayList = new ArrayList();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case 100:
                    if (nextName.equals("d")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 101:
                    if (nextName.equals("e")) {
                        c = 5;
                        break;
                    }
                    break;
                case 103:
                    if (nextName.equals(IXAdRequestInfo.GPS)) {
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
                case 115:
                    if (nextName.equals("s")) {
                        c = 4;
                        break;
                    }
                    break;
                case 116:
                    if (nextName.equals("t")) {
                        c = 3;
                        break;
                    }
                    break;
                case 119:
                    if (nextName.equals("w")) {
                        c = 6;
                        break;
                    }
                    break;
                case 3447:
                    if (nextName.equals(com.baidu.fsg.base.statistics.j.g)) {
                        c = 7;
                        break;
                    }
                    break;
                case 3454:
                    if (nextName.equals("lj")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 3487:
                    if (nextName.equals("ml")) {
                        c = '\t';
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
                    int i = -1;
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        char c2 = 65535;
                        switch (nextName2.hashCode()) {
                            case 107:
                                if (nextName2.equals("k")) {
                                    c2 = 1;
                                    break;
                                }
                                break;
                            case 112:
                                if (nextName2.equals("p")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                        }
                        switch (c2) {
                            case 0:
                                i = jsonReader.nextInt();
                                break;
                            case 1:
                                cVar = d.a(jsonReader, dVar, i);
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                        }
                    }
                    jsonReader.endObject();
                    break;
                case 2:
                    dVar2 = d.b(jsonReader, dVar);
                    break;
                case 3:
                    if (jsonReader.nextInt() != 1) {
                        gradientType = GradientType.Radial;
                        break;
                    } else {
                        gradientType = GradientType.Linear;
                        break;
                    }
                case 4:
                    fVar = d.c(jsonReader, dVar);
                    break;
                case 5:
                    fVar2 = d.c(jsonReader, dVar);
                    break;
                case 6:
                    bVar = d.a(jsonReader, dVar);
                    break;
                case 7:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.nextInt() - 1];
                    break;
                case '\b':
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.nextInt() - 1];
                    break;
                case '\t':
                    f = (float) jsonReader.nextDouble();
                    break;
                case '\n':
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        String str2 = null;
                        com.ksad.lottie.model.a.b bVar3 = null;
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String nextName3 = jsonReader.nextName();
                            char c3 = 65535;
                            switch (nextName3.hashCode()) {
                                case 110:
                                    if (nextName3.equals("n")) {
                                        c3 = 0;
                                        break;
                                    }
                                    break;
                                case 118:
                                    if (nextName3.equals("v")) {
                                        c3 = 1;
                                        break;
                                    }
                                    break;
                            }
                            switch (c3) {
                                case 0:
                                    str2 = jsonReader.nextString();
                                    break;
                                case 1:
                                    bVar3 = d.a(jsonReader, dVar);
                                    break;
                                default:
                                    jsonReader.skipValue();
                                    break;
                            }
                        }
                        jsonReader.endObject();
                        if (str2.equals(Config.OS)) {
                            bVar2 = bVar3;
                        } else if (str2.equals("d") || str2.equals(IXAdRequestInfo.GPS)) {
                            arrayList.add(bVar3);
                        }
                    }
                    jsonReader.endArray();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                        break;
                    }
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new com.ksad.lottie.model.content.e(str, gradientType, cVar, dVar2, fVar, fVar2, bVar, lineCapType, lineJoinType, f, arrayList, bVar2);
    }
}
