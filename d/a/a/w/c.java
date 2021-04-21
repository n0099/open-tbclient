package d.a.a.w;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import java.io.IOException;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static JsonReader.a f41835a = JsonReader.a.a("a", "p", "s", "rz", com.baidu.mapsdkplatform.comapi.map.r.f7699a, Config.OS, "so", "eo", ContentUtil.RESULT_KEY_SK, "sa");

    /* renamed from: b  reason: collision with root package name */
    public static JsonReader.a f41836b = JsonReader.a.a(Config.APP_KEY);

    public static boolean a(d.a.a.u.i.e eVar) {
        return eVar == null || (eVar.c() && eVar.b().get(0).f41896b.equals(0.0f, 0.0f));
    }

    public static boolean b(d.a.a.u.i.m<PointF, PointF> mVar) {
        return mVar == null || (!(mVar instanceof d.a.a.u.i.i) && mVar.c() && mVar.b().get(0).f41896b.equals(0.0f, 0.0f));
    }

    public static boolean c(d.a.a.u.i.b bVar) {
        return bVar == null || (bVar.c() && bVar.b().get(0).f41896b.floatValue() == 0.0f);
    }

    public static boolean d(d.a.a.u.i.g gVar) {
        return gVar == null || (gVar.c() && gVar.b().get(0).f41896b.a(1.0f, 1.0f));
    }

    public static boolean e(d.a.a.u.i.b bVar) {
        return bVar == null || (bVar.c() && bVar.b().get(0).f41896b.floatValue() == 0.0f);
    }

    public static boolean f(d.a.a.u.i.b bVar) {
        return bVar == null || (bVar.c() && bVar.b().get(0).f41896b.floatValue() == 0.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static d.a.a.u.i.l g(JsonReader jsonReader, d.a.a.d dVar) throws IOException {
        d.a.a.u.i.b f2;
        boolean z = false;
        boolean z2 = jsonReader.B() == JsonReader.Token.BEGIN_OBJECT;
        if (z2) {
            jsonReader.o();
        }
        d.a.a.u.i.b bVar = null;
        d.a.a.u.i.e eVar = null;
        d.a.a.u.i.m<PointF, PointF> mVar = null;
        d.a.a.u.i.g gVar = null;
        d.a.a.u.i.b bVar2 = null;
        d.a.a.u.i.b bVar3 = null;
        d.a.a.u.i.d dVar2 = null;
        d.a.a.u.i.b bVar4 = null;
        d.a.a.u.i.b bVar5 = null;
        while (jsonReader.t()) {
            switch (jsonReader.D(f41835a)) {
                case 0:
                    jsonReader.o();
                    while (jsonReader.t()) {
                        if (jsonReader.D(f41836b) != 0) {
                            jsonReader.E();
                            jsonReader.F();
                        } else {
                            eVar = a.a(jsonReader, dVar);
                        }
                    }
                    jsonReader.r();
                    break;
                case 1:
                    mVar = a.b(jsonReader, dVar);
                    break;
                case 2:
                    gVar = d.j(jsonReader, dVar);
                    break;
                case 3:
                    dVar.a("Lottie doesn't support 3D layers.");
                    f2 = d.f(jsonReader, dVar, z);
                    if (!f2.b().isEmpty()) {
                        f2.b().add(new d.a.a.y.a<>(dVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(dVar.f())));
                    } else if (f2.b().get(0).f41896b == null) {
                        f2.b().set(0, new d.a.a.y.a<>(dVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(dVar.f())));
                        bVar = f2;
                        break;
                    }
                    bVar = f2;
                case 4:
                    f2 = d.f(jsonReader, dVar, z);
                    if (!f2.b().isEmpty()) {
                    }
                    bVar = f2;
                    break;
                case 5:
                    dVar2 = d.h(jsonReader, dVar);
                    continue;
                case 6:
                    bVar4 = d.f(jsonReader, dVar, z);
                    continue;
                case 7:
                    bVar5 = d.f(jsonReader, dVar, z);
                    continue;
                case 8:
                    bVar2 = d.f(jsonReader, dVar, z);
                    continue;
                case 9:
                    bVar3 = d.f(jsonReader, dVar, z);
                    continue;
                default:
                    jsonReader.E();
                    jsonReader.F();
                    break;
            }
            z = false;
        }
        if (z2) {
            jsonReader.r();
        }
        d.a.a.u.i.e eVar2 = a(eVar) ? null : eVar;
        d.a.a.u.i.m<PointF, PointF> mVar2 = b(mVar) ? null : mVar;
        d.a.a.u.i.b bVar6 = c(bVar) ? null : bVar;
        if (d(gVar)) {
            gVar = null;
        }
        return new d.a.a.u.i.l(eVar2, mVar2, gVar, bVar6, dVar2, bVar4, bVar5, f(bVar2) ? null : bVar2, e(bVar3) ? null : bVar3);
    }
}
