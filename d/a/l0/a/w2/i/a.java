package d.a.l0.a.w2.i;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c0.c.a.c;
import d.a.l0.a.c2.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.c2.f.b;
import d.a.l0.a.e0.d;
import d.a.l0.a.g1.f;
import java.io.File;
import java.net.URI;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends b {
    public a(e eVar) {
        super(eVar, "/swanAPI/animView");
    }

    @Override // d.a.l0.a.c2.f.b
    @NonNull
    public String j() {
        return "/swanAPI/animView";
    }

    @Override // d.a.l0.a.c2.f.b
    public boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.l0.a.a2.e eVar) {
        c q = q(unitedSchemeEntity);
        if (q == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b("AbsSwanAppWidget", "model is null");
            return false;
        } else if (!q.j()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b("AbsSwanAppWidget", "parse insert params, but invalid");
            return false;
        } else {
            String r = r(q.x, eVar);
            if (TextUtils.isEmpty(r)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "parse insert params, anim data is null");
                return false;
            }
            if (f.V().O()) {
                try {
                    new JSONObject(r);
                } catch (Throwable th) {
                    if (a0.f44625b) {
                        th.printStackTrace();
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "parse insert params, anim data is not json");
                    return false;
                }
            }
            d.a.l0.a.c0.b.c w = new d.a.l0.a.c0.c.a.b(context, q, r).w();
            boolean a2 = w.a();
            d.g("AbsSwanAppWidget", "insert anim view success = " + a2);
            if (a2) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, w.f44526b);
                d.b("AbsSwanAppWidget", "insert anim view, but failure: " + w.f44526b);
            }
            return a2;
        }
    }

    @Override // d.a.l0.a.c2.f.b
    public boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.l0.a.a2.e eVar) {
        c q = q(unitedSchemeEntity);
        if (q == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b("AbsSwanAppWidget", "model is null");
            return false;
        } else if (!q.isValid()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b("AbsSwanAppWidget", "parse remove params, but invalid");
            return false;
        } else {
            d.a.l0.a.c0.c.a.b bVar = (d.a.l0.a.c0.c.a.b) d.a.l0.a.c0.d.a.a(q);
            if (bVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                d.b("AbsSwanAppWidget", "get component is null");
                return false;
            }
            d.a.l0.a.c0.b.c C = bVar.C();
            boolean a2 = C.a();
            d.g("AbsSwanAppWidget", "remove anim view success = " + a2);
            if (a2) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, C.f44526b);
                d.b("AbsSwanAppWidget", "remove anim view, but failure: " + C.f44526b);
            }
            return a2;
        }
    }

    @Override // d.a.l0.a.c2.f.b
    public boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.l0.a.a2.e eVar) {
        c q = q(unitedSchemeEntity);
        if (q == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b("AbsSwanAppWidget", "model is null");
            return false;
        } else if (!q.isValid()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b("AbsSwanAppWidget", "parse update params, but invalid");
            return false;
        } else {
            d.a.l0.a.c0.c.a.b bVar = (d.a.l0.a.c0.c.a.b) d.a.l0.a.c0.d.a.a(q);
            if (bVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                d.b("AbsSwanAppWidget", "get component is null");
                return false;
            }
            d.a.l0.a.c0.b.c G = bVar.G(q);
            boolean a2 = G.a();
            d.a("AbsSwanAppWidget", "update anim view success = " + a2);
            if (a2) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, G.f44526b);
                d.b("AbsSwanAppWidget", "update anim view, but failure: " + G.f44526b);
            }
            return a2;
        }
    }

    @Nullable
    public final c q(UnitedSchemeEntity unitedSchemeEntity) {
        if (unitedSchemeEntity == null) {
            return null;
        }
        JSONObject k = k(unitedSchemeEntity);
        if (k == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b("SwanAppAction", "params is null");
            return null;
        }
        c cVar = new c();
        try {
            cVar.a(k);
        } catch (JSONException e2) {
            e2.printStackTrace();
            d.c("SwanAppAction", "model parse exception:", e2);
        }
        return cVar;
    }

    public final String r(String str, d.a.l0.a.a2.e eVar) {
        String L;
        if (!TextUtils.isEmpty(str) && eVar != null) {
            try {
                if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                    L = d.a.l0.a.k2.b.M(str, eVar.f44425f);
                } else {
                    L = d.a.l0.a.k2.b.L(str, eVar, eVar.Z());
                }
                if (TextUtils.isEmpty(L)) {
                    return null;
                }
                File file = new File(L);
                if (d.a.l0.t.d.x(file)) {
                    return d.a.l0.t.d.D(file);
                }
                return null;
            } catch (Exception e2) {
                if (a0.f44625b) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }
}
