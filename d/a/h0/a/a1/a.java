package d.a.h0.a.a1;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.a.h0.a.a1.c.f;
import d.a.h0.a.a1.c.g;
import d.a.h0.a.c0.c;
import d.a.h0.a.i2.k0;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends a0 {
    public a(j jVar) {
        super(jVar, "/swanAPI/map");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (a0.f44398b) {
            Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // d.a.h0.a.t1.k.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        boolean g2;
        if (a0.f44398b) {
            Log.d("MapAction", "handleSubAction subAction: " + str);
        }
        c.g("map", "handleSubAction " + str);
        b a2 = b.a(unitedSchemeEntity, callbackHandler);
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2079680864:
                if (str.equals("/swanAPI/map/translateMarker")) {
                    c2 = 3;
                    break;
                }
                break;
            case -2068557416:
                if (str.equals("/swanAPI/map/getCenterLocation")) {
                    c2 = '\t';
                    break;
                }
                break;
            case -398143716:
                if (str.equals("/swanAPI/map/getScale")) {
                    c2 = 7;
                    break;
                }
                break;
            case 51993511:
                if (str.equals("/swanAPI/map/openLocation")) {
                    c2 = 4;
                    break;
                }
                break;
            case 379323012:
                if (str.equals("/swanAPI/map/create")) {
                    c2 = 0;
                    break;
                }
                break;
            case 515840866:
                if (str.equals("/swanAPI/map/getRegion")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 797006348:
                if (str.equals("/swanAPI/map/remove")) {
                    c2 = 2;
                    break;
                }
                break;
            case 892770897:
                if (str.equals("/swanAPI/map/update")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1007473955:
                if (str.equals("/swanAPI/map/includePoints")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1142165295:
                if (str.equals("/swanAPI/map/openWalkNavigation")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1256916873:
                if (str.equals("/swanAPI/map/moveToLocation")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1475857524:
                if (str.equals("/swanAPI/map/chooseLocation")) {
                    c2 = '\n';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                d.a.h0.a.a1.c.c j = j(unitedSchemeEntity, d.a.h0.a.a1.c.c.class);
                if (!k(j, a2)) {
                    g2 = d.a.h0.a.w0.a.x().g(context, j, a2, eVar);
                    break;
                }
                g2 = false;
                break;
            case 1:
                d.a.h0.a.a1.c.c j2 = j(unitedSchemeEntity, d.a.h0.a.a1.c.c.class);
                if (!k(j2, a2)) {
                    g2 = d.a.h0.a.w0.a.x().o(context, j2, a2, eVar);
                    break;
                }
                g2 = false;
                break;
            case 2:
                d.a.h0.a.a1.c.c j3 = j(unitedSchemeEntity, d.a.h0.a.a1.c.c.class);
                if (!k(j3, a2)) {
                    g2 = d.a.h0.a.w0.a.x().l(context, j3, a2, eVar);
                    break;
                }
                g2 = false;
                break;
            case 3:
                f fVar = (f) j(unitedSchemeEntity, f.class);
                if (!k(fVar, a2)) {
                    g2 = d.a.h0.a.w0.a.x().j(context, fVar, a2, eVar);
                    break;
                }
                g2 = false;
                break;
            case 4:
                d.a.h0.a.a1.c.e eVar2 = (d.a.h0.a.a1.c.e) j(unitedSchemeEntity, d.a.h0.a.a1.c.e.class);
                if (!k(eVar2, a2)) {
                    g2 = d.a.h0.a.w0.a.x().h(context, eVar2, a2, eVar);
                    break;
                }
                g2 = false;
                break;
            case 5:
                d.a.h0.a.a1.c.c j4 = j(unitedSchemeEntity, d.a.h0.a.a1.c.c.class);
                if (!k(j4, a2)) {
                    g2 = d.a.h0.a.w0.a.x().m(context, j4, a2, eVar);
                    break;
                }
                g2 = false;
                break;
            case 6:
                d.a.h0.a.a1.c.b bVar = (d.a.h0.a.a1.c.b) j(unitedSchemeEntity, d.a.h0.a.a1.c.b.class);
                if (!k(bVar, a2)) {
                    g2 = d.a.h0.a.w0.a.x().b(context, bVar, a2, eVar);
                    break;
                }
                g2 = false;
                break;
            case 7:
                d.a.h0.a.a1.c.c j5 = j(unitedSchemeEntity, d.a.h0.a.a1.c.c.class);
                if (!k(j5, a2)) {
                    g2 = d.a.h0.a.w0.a.x().c(context, j5, a2, eVar);
                    break;
                }
                g2 = false;
                break;
            case '\b':
                d.a.h0.a.a1.c.c j6 = j(unitedSchemeEntity, d.a.h0.a.a1.c.c.class);
                if (!k(j6, a2)) {
                    g2 = d.a.h0.a.w0.a.x().n(context, j6, a2, eVar);
                    break;
                }
                g2 = false;
                break;
            case '\t':
                d.a.h0.a.a1.c.c j7 = j(unitedSchemeEntity, d.a.h0.a.a1.c.c.class);
                if (!k(j7, a2)) {
                    g2 = d.a.h0.a.w0.a.x().k(context, j7, a2, eVar);
                    break;
                }
                g2 = false;
                break;
            case '\n':
                d.a.h0.a.a1.c.a aVar = (d.a.h0.a.a1.c.a) j(unitedSchemeEntity, d.a.h0.a.a1.c.a.class);
                if (!k(aVar, a2)) {
                    g2 = d.a.h0.a.w0.a.x().e(context, aVar, a2, eVar);
                    break;
                }
                g2 = false;
                break;
            case 11:
                g gVar = (g) j(unitedSchemeEntity, g.class);
                if (!k(gVar, a2)) {
                    g2 = d.a.h0.a.w0.a.x().a(context, gVar, a2, eVar);
                    break;
                }
                g2 = false;
                break;
            default:
                g2 = false;
                break;
        }
        return g2 || super.i(context, unitedSchemeEntity, callbackHandler, str, eVar);
    }

    public <T extends d.a.h0.a.a1.c.c> T j(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
        JSONObject jSONObject;
        T newInstance;
        T t = null;
        if (unitedSchemeEntity == null) {
            return null;
        }
        HashMap<String, String> params = unitedSchemeEntity.getParams();
        if (params != null && !params.isEmpty()) {
            String str = params.get("params");
            if (str == null) {
                c.b("map", "params string is empty");
                return null;
            }
            try {
                jSONObject = new JSONObject(str);
                newInstance = cls.newInstance();
            } catch (Exception e2) {
                e = e2;
            }
            try {
                newInstance.a(jSONObject);
                return newInstance;
            } catch (Exception e3) {
                e = e3;
                t = newInstance;
                e.printStackTrace();
                c.b("map", "params json parse error");
                return t;
            }
        }
        c.b("map", "entity get Params is empty");
        return null;
    }

    public final boolean k(d.a.h0.a.a1.c.c cVar, b bVar) {
        if (cVar == null) {
            c.b("map", "parse error, model is null");
            bVar.d(202);
            return true;
        }
        if (TextUtils.isEmpty(cVar.f41093g)) {
            String x = k0.x();
            if (!TextUtils.isEmpty(x)) {
                cVar.f41093g = x;
            }
            c.l("map", "webView id is empty, use current webView");
        }
        if (k0.m(cVar.f41093g) == null) {
            bVar.d(202);
            c.b("map", "can not find weiView by id " + cVar.f41093g);
            return true;
        }
        return false;
    }
}
