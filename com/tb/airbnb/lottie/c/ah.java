package com.tb.airbnb.lottie.c;

import android.util.JsonReader;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
import java.io.IOException;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes16.dex */
public class ah {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static ShapeStroke z(JsonReader jsonReader, com.tb.airbnb.lottie.e eVar) throws IOException {
        char c;
        String str = null;
        com.tb.airbnb.lottie.model.a.a aVar = null;
        com.tb.airbnb.lottie.model.a.b bVar = null;
        com.tb.airbnb.lottie.model.a.d dVar = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        com.tb.airbnb.lottie.model.a.b bVar2 = null;
        float f = 0.0f;
        ArrayList arrayList = new ArrayList();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            switch (nextName.hashCode()) {
                case 99:
                    if (nextName.equals("c")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 100:
                    if (nextName.equals("d")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 111:
                    if (nextName.equals(Config.OS)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 119:
                    if (nextName.equals("w")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3447:
                    if (nextName.equals(com.baidu.fsg.base.statistics.j.g)) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 3454:
                    if (nextName.equals("lj")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 3487:
                    if (nextName.equals("ml")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    aVar = d.l(jsonReader, eVar);
                    break;
                case 2:
                    bVar = d.f(jsonReader, eVar);
                    break;
                case 3:
                    dVar = d.g(jsonReader, eVar);
                    break;
                case 4:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.nextInt() - 1];
                    break;
                case 5:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.nextInt() - 1];
                    break;
                case 6:
                    f = (float) jsonReader.nextDouble();
                    break;
                case 7:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        String str2 = null;
                        com.tb.airbnb.lottie.model.a.b bVar3 = null;
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String nextName2 = jsonReader.nextName();
                            char c3 = 65535;
                            switch (nextName2.hashCode()) {
                                case 110:
                                    if (nextName2.equals("n")) {
                                        c3 = 0;
                                        break;
                                    }
                                    break;
                                case 118:
                                    if (nextName2.equals("v")) {
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
                                    bVar3 = d.f(jsonReader, eVar);
                                    break;
                                default:
                                    jsonReader.skipValue();
                                    break;
                            }
                        }
                        jsonReader.endObject();
                        switch (str2.hashCode()) {
                            case 100:
                                if (str2.equals("d")) {
                                    c = 1;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 103:
                                if (str2.equals(IXAdRequestInfo.GPS)) {
                                    c = 2;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 111:
                                if (str2.equals(Config.OS)) {
                                    c = 0;
                                    break;
                                }
                                c = 65535;
                                break;
                            default:
                                c = 65535;
                                break;
                        }
                        switch (c) {
                            case 0:
                                bVar2 = bVar3;
                                break;
                            case 1:
                            case 2:
                                arrayList.add(bVar3);
                                break;
                        }
                    }
                    jsonReader.endArray();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                        break;
                    }
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new ShapeStroke(str, bVar2, arrayList, aVar, dVar, bVar, lineCapType, lineJoinType, f);
    }
}
