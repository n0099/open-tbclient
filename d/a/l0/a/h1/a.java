package d.a.l0.a.h1;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.a.l0.a.c2.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e0.d;
import d.a.l0.a.h1.c.c;
import d.a.l0.a.h1.c.f;
import d.a.l0.a.h1.c.g;
import d.a.l0.a.v2.q0;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {
    public a(e eVar) {
        super(eVar, "/swanAPI/map");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (a0.f44625b) {
            Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
            return false;
        }
        return false;
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.l0.a.a2.e eVar) {
        if (a0.f44625b) {
            Log.d("MapAction", "handleSubAction subAction: " + str);
        }
        d.g("map", "handleSubAction " + str);
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
                c j = j(unitedSchemeEntity, c.class);
                if (k(j, a2)) {
                    return false;
                }
                return d.a.l0.a.c1.a.F().g(context, j, a2, eVar);
            case 1:
                c j2 = j(unitedSchemeEntity, c.class);
                if (k(j2, a2)) {
                    return false;
                }
                return d.a.l0.a.c1.a.F().o(context, j2, a2, eVar);
            case 2:
                c j3 = j(unitedSchemeEntity, c.class);
                if (k(j3, a2)) {
                    return false;
                }
                return d.a.l0.a.c1.a.F().l(context, j3, a2, eVar);
            case 3:
                f fVar = (f) j(unitedSchemeEntity, f.class);
                if (k(fVar, a2)) {
                    return false;
                }
                return d.a.l0.a.c1.a.F().j(context, fVar, a2, eVar);
            case 4:
                d.a.l0.a.h1.c.e eVar2 = (d.a.l0.a.h1.c.e) j(unitedSchemeEntity, d.a.l0.a.h1.c.e.class);
                if (k(eVar2, a2)) {
                    return false;
                }
                return d.a.l0.a.c1.a.F().h(context, eVar2, a2, eVar);
            case 5:
                c j4 = j(unitedSchemeEntity, c.class);
                if (k(j4, a2)) {
                    return false;
                }
                return d.a.l0.a.c1.a.F().m(context, j4, a2, eVar);
            case 6:
                d.a.l0.a.h1.c.b bVar = (d.a.l0.a.h1.c.b) j(unitedSchemeEntity, d.a.l0.a.h1.c.b.class);
                if (k(bVar, a2)) {
                    return false;
                }
                return d.a.l0.a.c1.a.F().b(context, bVar, a2, eVar);
            case 7:
                c j5 = j(unitedSchemeEntity, c.class);
                if (k(j5, a2)) {
                    return false;
                }
                return d.a.l0.a.c1.a.F().c(context, j5, a2, eVar);
            case '\b':
                c j6 = j(unitedSchemeEntity, c.class);
                if (k(j6, a2)) {
                    return false;
                }
                return d.a.l0.a.c1.a.F().n(context, j6, a2, eVar);
            case '\t':
                c j7 = j(unitedSchemeEntity, c.class);
                if (k(j7, a2)) {
                    return false;
                }
                return d.a.l0.a.c1.a.F().k(context, j7, a2, eVar);
            case '\n':
                d.a.l0.a.h1.c.a aVar = (d.a.l0.a.h1.c.a) j(unitedSchemeEntity, d.a.l0.a.h1.c.a.class);
                if (k(aVar, a2)) {
                    return false;
                }
                return d.a.l0.a.c1.a.F().e(context, aVar, a2, eVar);
            case 11:
                g gVar = (g) j(unitedSchemeEntity, g.class);
                if (k(gVar, a2)) {
                    return false;
                }
                return d.a.l0.a.c1.a.F().a(context, gVar, a2, eVar);
            default:
                return super.i(context, unitedSchemeEntity, callbackHandler, str, eVar);
        }
    }

    public <T extends c> T j(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
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
                d.b("map", "params string is empty");
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
                d.b("map", "params json parse error");
                return t;
            }
        }
        d.b("map", "entity get Params is empty");
        return null;
    }

    public final boolean k(c cVar, b bVar) {
        if (cVar == null) {
            d.b("map", "parse error, model is null");
            bVar.d(202);
            return true;
        }
        if (TextUtils.isEmpty(cVar.f44522g)) {
            String B = q0.B();
            if (!TextUtils.isEmpty(B)) {
                cVar.f44522g = B;
            }
            d.l("map", "webView id is empty, use current webView");
        }
        if (q0.m(cVar.f44522g) == null) {
            bVar.d(202);
            d.b("map", "can not find weiView by id " + cVar.f44522g);
            return true;
        }
        return false;
    }
}
