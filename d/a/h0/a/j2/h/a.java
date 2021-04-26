package d.a.h0.a.j2.h;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.c0.c;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.t1.k.b;
import d.a.h0.a.z0.f;
import d.a.h0.p.d;
import java.io.File;
import java.net.URI;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends b {
    public a(j jVar) {
        super(jVar, "/swanAPI/animView");
    }

    @Override // d.a.h0.a.t1.k.b
    @NonNull
    public String j() {
        return "/swanAPI/animView";
    }

    @Override // d.a.h0.a.t1.k.b
    public boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        d.a.h0.a.a0.c.a.b q = q(unitedSchemeEntity);
        if (q == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.b("AbsSwanAppWidget", "model is null");
            return false;
        } else if (!q.j()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.b("AbsSwanAppWidget", "parse insert params, but invalid");
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
                    if (a0.f44398b) {
                        th.printStackTrace();
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "parse insert params, anim data is not json");
                    return false;
                }
            }
            d.a.h0.a.a0.b.c w = new d.a.h0.a.a0.c.a.a(context, q, r).w();
            boolean a2 = w.a();
            c.g("AbsSwanAppWidget", "insert anim view success = " + a2);
            if (a2) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, w.f41097b);
                c.b("AbsSwanAppWidget", "insert anim view, but failure: " + w.f41097b);
            }
            return a2;
        }
    }

    @Override // d.a.h0.a.t1.k.b
    public boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        d.a.h0.a.a0.c.a.b q = q(unitedSchemeEntity);
        if (q == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.b("AbsSwanAppWidget", "model is null");
            return false;
        } else if (!q.isValid()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.b("AbsSwanAppWidget", "parse remove params, but invalid");
            return false;
        } else {
            d.a.h0.a.a0.c.a.a aVar = (d.a.h0.a.a0.c.a.a) d.a.h0.a.a0.d.a.a(q);
            if (aVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.b("AbsSwanAppWidget", "get component is null");
                return false;
            }
            d.a.h0.a.a0.b.c C = aVar.C();
            boolean a2 = C.a();
            c.g("AbsSwanAppWidget", "remove anim view success = " + a2);
            if (a2) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, C.f41097b);
                c.b("AbsSwanAppWidget", "remove anim view, but failure: " + C.f41097b);
            }
            return a2;
        }
    }

    @Override // d.a.h0.a.t1.k.b
    public boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        d.a.h0.a.a0.c.a.b q = q(unitedSchemeEntity);
        if (q == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.b("AbsSwanAppWidget", "model is null");
            return false;
        } else if (!q.isValid()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.b("AbsSwanAppWidget", "parse update params, but invalid");
            return false;
        } else {
            d.a.h0.a.a0.c.a.a aVar = (d.a.h0.a.a0.c.a.a) d.a.h0.a.a0.d.a.a(q);
            if (aVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                c.b("AbsSwanAppWidget", "get component is null");
                return false;
            }
            d.a.h0.a.a0.b.c G = aVar.G(q);
            boolean a2 = G.a();
            c.a("AbsSwanAppWidget", "update anim view success = " + a2);
            if (a2) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, G.f41097b);
                c.b("AbsSwanAppWidget", "update anim view, but failure: " + G.f41097b);
            }
            return a2;
        }
    }

    @Nullable
    public final d.a.h0.a.a0.c.a.b q(UnitedSchemeEntity unitedSchemeEntity) {
        if (unitedSchemeEntity == null) {
            return null;
        }
        JSONObject k = k(unitedSchemeEntity);
        if (k == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.b("SwanAppAction", "params is null");
            return null;
        }
        d.a.h0.a.a0.c.a.b bVar = new d.a.h0.a.a0.c.a.b();
        try {
            bVar.a(k);
        } catch (JSONException e2) {
            e2.printStackTrace();
            c.c("SwanAppAction", "model parse exception:", e2);
        }
        return bVar;
    }

    public final String r(String str, e eVar) {
        String t;
        if (!TextUtils.isEmpty(str) && eVar != null) {
            try {
                if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                    t = d.a.h0.a.a2.b.u(str, eVar.f43823f);
                } else {
                    t = d.a.h0.a.a2.b.t(str, eVar, eVar.W());
                }
                if (TextUtils.isEmpty(t)) {
                    return null;
                }
                File file = new File(t);
                if (d.p(file)) {
                    return d.r(file);
                }
                return null;
            } catch (Exception e2) {
                if (a0.f44398b) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }
}
