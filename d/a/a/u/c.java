package d.a.a.u;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;
import com.baidu.mobstat.Config;
import java.io.IOException;
/* loaded from: classes.dex */
public class c {
    public static d.a.a.s.i.l a(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        boolean z = jsonReader.peek() == JsonToken.BEGIN_OBJECT;
        if (z) {
            jsonReader.beginObject();
        }
        d.a.a.s.i.e eVar = null;
        d.a.a.s.i.g gVar = null;
        d.a.a.s.i.d dVar2 = null;
        d.a.a.s.i.m<PointF, PointF> mVar = null;
        d.a.a.s.i.b bVar = null;
        d.a.a.s.i.b bVar2 = null;
        d.a.a.s.i.b bVar3 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c2 = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 97) {
                if (hashCode != 3242) {
                    if (hashCode != 3656) {
                        if (hashCode != 3676) {
                            if (hashCode != 111) {
                                if (hashCode != 112) {
                                    if (hashCode != 114) {
                                        if (hashCode == 115 && nextName.equals("s")) {
                                            c2 = 2;
                                        }
                                    } else if (nextName.equals(com.baidu.mapsdkplatform.comapi.map.r.f7664a)) {
                                        c2 = 4;
                                    }
                                } else if (nextName.equals("p")) {
                                    c2 = 1;
                                }
                            } else if (nextName.equals(Config.OS)) {
                                c2 = 5;
                            }
                        } else if (nextName.equals("so")) {
                            c2 = 6;
                        }
                    } else if (nextName.equals("rz")) {
                        c2 = 3;
                    }
                } else if (nextName.equals("eo")) {
                    c2 = 7;
                }
            } else if (nextName.equals("a")) {
                c2 = 0;
            }
            switch (c2) {
                case 0:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if (jsonReader.nextName().equals(Config.APP_KEY)) {
                            eVar = a.a(jsonReader, dVar);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    continue;
                case 1:
                    mVar = a.b(jsonReader, dVar);
                    continue;
                case 2:
                    gVar = d.j(jsonReader, dVar);
                    continue;
                case 3:
                    dVar.a("Lottie doesn't support 3D layers.");
                    break;
                case 4:
                    break;
                case 5:
                    dVar2 = d.h(jsonReader, dVar);
                    continue;
                case 6:
                    bVar2 = d.f(jsonReader, dVar, false);
                    continue;
                case 7:
                    bVar3 = d.f(jsonReader, dVar, false);
                    continue;
                default:
                    jsonReader.skipValue();
                    continue;
            }
            bVar = d.f(jsonReader, dVar, false);
        }
        if (z) {
            jsonReader.endObject();
        }
        if (eVar == null) {
            Log.w("LOTTIE", "Layer has no transform property. You may be using an unsupported layer type such as a camera.");
            eVar = new d.a.a.s.i.e();
        }
        d.a.a.s.i.e eVar2 = eVar;
        if (gVar == null) {
            gVar = new d.a.a.s.i.g(new d.a.a.w.d(1.0f, 1.0f));
        }
        d.a.a.s.i.g gVar2 = gVar;
        if (dVar2 == null) {
            dVar2 = new d.a.a.s.i.d();
        }
        return new d.a.a.s.i.l(eVar2, mVar, gVar2, bVar, dVar2, bVar2, bVar3);
    }
}
