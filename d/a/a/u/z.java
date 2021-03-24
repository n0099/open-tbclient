package d.a.a.u;

import android.graphics.PointF;
import android.util.JsonReader;
import androidx.appcompat.widget.SearchView;
import com.airbnb.lottie.model.content.PolystarShape;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import java.io.IOException;
/* loaded from: classes.dex */
public class z {
    public static PolystarShape a(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        String str = null;
        PolystarShape.Type type = null;
        d.a.a.s.i.b bVar = null;
        d.a.a.s.i.m<PointF, PointF> mVar = null;
        d.a.a.s.i.b bVar2 = null;
        d.a.a.s.i.b bVar3 = null;
        d.a.a.s.i.b bVar4 = null;
        d.a.a.s.i.b bVar5 = null;
        d.a.a.s.i.b bVar6 = null;
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
                    bVar = d.f(jsonReader, dVar, false);
                    break;
                case 3:
                    mVar = a.b(jsonReader, dVar);
                    break;
                case 4:
                    bVar2 = d.f(jsonReader, dVar, false);
                    break;
                case 5:
                    bVar4 = d.e(jsonReader, dVar);
                    break;
                case 6:
                    bVar6 = d.f(jsonReader, dVar, false);
                    break;
                case 7:
                    bVar3 = d.e(jsonReader, dVar);
                    break;
                case '\b':
                    bVar5 = d.f(jsonReader, dVar, false);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        return new PolystarShape(str, type, bVar, mVar, bVar2, bVar3, bVar4, bVar5, bVar6);
    }
}
