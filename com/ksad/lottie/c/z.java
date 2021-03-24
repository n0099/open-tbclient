package com.ksad.lottie.c;

import android.graphics.PointF;
import android.util.JsonReader;
import androidx.appcompat.widget.SearchView;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.ksad.lottie.model.content.PolystarShape;
/* loaded from: classes6.dex */
public class z {
    public static PolystarShape a(JsonReader jsonReader, com.ksad.lottie.d dVar) {
        String str = null;
        PolystarShape.Type type = null;
        com.ksad.lottie.model.a.b bVar = null;
        com.ksad.lottie.model.a.m<PointF, PointF> mVar = null;
        com.ksad.lottie.model.a.b bVar2 = null;
        com.ksad.lottie.model.a.b bVar3 = null;
        com.ksad.lottie.model.a.b bVar4 = null;
        com.ksad.lottie.model.a.b bVar5 = null;
        com.ksad.lottie.model.a.b bVar6 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 112) {
                if (hashCode != 114) {
                    if (hashCode != 3519) {
                        if (hashCode != 3588) {
                            if (hashCode != 3686) {
                                if (hashCode != 3369) {
                                    if (hashCode != 3370) {
                                        if (hashCode != 3555) {
                                            if (hashCode == 3556 && nextName.equals(IXAdRequestInfo.OS)) {
                                                c2 = 6;
                                            }
                                        } else if (nextName.equals("or")) {
                                            c2 = 5;
                                        }
                                    } else if (nextName.equals("is")) {
                                        c2 = '\b';
                                    }
                                } else if (nextName.equals("ir")) {
                                    c2 = 7;
                                }
                            } else if (nextName.equals("sy")) {
                                c2 = 1;
                            }
                        } else if (nextName.equals(Config.PLATFORM_TYPE)) {
                            c2 = 2;
                        }
                    } else if (nextName.equals(SearchView.IME_OPTION_NO_MICROPHONE)) {
                        c2 = 0;
                    }
                } else if (nextName.equals(com.baidu.mapsdkplatform.comapi.map.r.f7663a)) {
                    c2 = 4;
                }
            } else if (nextName.equals("p")) {
                c2 = 3;
            }
            switch (c2) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    type = PolystarShape.Type.forValue(jsonReader.nextInt());
                    break;
                case 2:
                    bVar = d.a(jsonReader, dVar, false);
                    break;
                case 3:
                    mVar = a.b(jsonReader, dVar);
                    break;
                case 4:
                    bVar2 = d.a(jsonReader, dVar, false);
                    break;
                case 5:
                    bVar4 = d.a(jsonReader, dVar);
                    break;
                case 6:
                    bVar6 = d.a(jsonReader, dVar, false);
                    break;
                case 7:
                    bVar3 = d.a(jsonReader, dVar);
                    break;
                case '\b':
                    bVar5 = d.a(jsonReader, dVar, false);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new PolystarShape(str, type, bVar, mVar, bVar2, bVar3, bVar4, bVar5, bVar6);
    }
}
