package d.b.g0.a.a0.c.b;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends d.b.g0.a.t1.k.b {
    public b(j jVar) {
        super(jVar, "/swanAPI/button");
    }

    @Override // d.b.g0.a.t1.k.b
    @NonNull
    public String j() {
        return "/swanAPI/button";
    }

    @Override // d.b.g0.a.t1.k.b
    public boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        if (a0.f46287b) {
            Log.d("Component-Action-Button", "insert");
        }
        c q = q(unitedSchemeEntity);
        if (q == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b.g0.a.c0.c.b("Component-Action-Button", "model is null");
            return false;
        }
        d.b.g0.a.a0.b.c w = new a(context, q).w();
        boolean a2 = w.a();
        if (a2) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, w.f43116b);
        }
        return a2;
    }

    @Override // d.b.g0.a.t1.k.b
    public boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        if (a0.f46287b) {
            Log.d("Component-Action-Button", "remove");
        }
        c q = q(unitedSchemeEntity);
        if (q == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b.g0.a.c0.c.b("Component-Action-Button", "model is null");
            return false;
        }
        a aVar = (a) d.b.g0.a.a0.d.a.a(q);
        if (aVar == null) {
            String str2 = "can't find button component:#" + q.f43112f;
            d.b.g0.a.c0.c.b("Component-Action-Button", str2);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
            return false;
        }
        d.b.g0.a.a0.b.c C = aVar.C();
        boolean a2 = C.a();
        if (a2) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, C.f43116b);
        }
        return a2;
    }

    @Override // d.b.g0.a.t1.k.b
    public boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        if (a0.f46287b) {
            Log.d("Component-Action-Button", IMTrack.DbBuilder.ACTION_UPDATE);
        }
        c q = q(unitedSchemeEntity);
        if (q == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b.g0.a.c0.c.b("Component-Action-Button", "model is null");
            return false;
        }
        a aVar = (a) d.b.g0.a.a0.d.a.a(q);
        if (aVar == null) {
            String str2 = "can't find button component:#" + q.f43112f;
            d.b.g0.a.c0.c.b("Component-Action-Button", str2);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
            return false;
        }
        d.b.g0.a.a0.b.c G = aVar.G(q);
        boolean a2 = G.a();
        if (a2) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, G.f43116b);
        }
        return a2;
    }

    @Nullable
    public final c q(UnitedSchemeEntity unitedSchemeEntity) {
        if (unitedSchemeEntity == null) {
            return null;
        }
        JSONObject k = k(unitedSchemeEntity);
        if (k == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b.g0.a.c0.c.b("Component-Action-Button", "params is null");
            return null;
        }
        c cVar = new c();
        try {
            cVar.a(k);
        } catch (JSONException e2) {
            e2.printStackTrace();
            d.b.g0.a.c0.c.c("Component-Action-Button", "model parse exception:", e2);
        }
        return cVar;
    }
}
