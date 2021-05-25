package d.a.l0.a.c0.c.b;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e0.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.a.l0.a.c2.f.b {
    public b(e eVar) {
        super(eVar, "/swanAPI/button");
    }

    @Override // d.a.l0.a.c2.f.b
    @NonNull
    public String j() {
        return "/swanAPI/button";
    }

    @Override // d.a.l0.a.c2.f.b
    public boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.l0.a.a2.e eVar) {
        if (a0.f40949b) {
            Log.d("Component-Action-Button", "insert");
        }
        c q = q(unitedSchemeEntity);
        if (q == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b("Component-Action-Button", "model is null");
            return false;
        }
        d.a.l0.a.c0.b.c w = new a(context, q).w();
        boolean a2 = w.a();
        if (a2) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, w.f40850b);
        }
        return a2;
    }

    @Override // d.a.l0.a.c2.f.b
    public boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.l0.a.a2.e eVar) {
        if (a0.f40949b) {
            Log.d("Component-Action-Button", "remove");
        }
        c q = q(unitedSchemeEntity);
        if (q == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b("Component-Action-Button", "model is null");
            return false;
        }
        a aVar = (a) d.a.l0.a.c0.d.a.a(q);
        if (aVar == null) {
            String str2 = "can't find button component:#" + q.f40845f;
            d.b("Component-Action-Button", str2);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
            return false;
        }
        d.a.l0.a.c0.b.c C = aVar.C();
        boolean a2 = C.a();
        if (a2) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, C.f40850b);
        }
        return a2;
    }

    @Override // d.a.l0.a.c2.f.b
    public boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.l0.a.a2.e eVar) {
        if (a0.f40949b) {
            Log.d("Component-Action-Button", IMTrack.DbBuilder.ACTION_UPDATE);
        }
        c q = q(unitedSchemeEntity);
        if (q == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b("Component-Action-Button", "model is null");
            return false;
        }
        a aVar = (a) d.a.l0.a.c0.d.a.a(q);
        if (aVar == null) {
            String str2 = "can't find button component:#" + q.f40845f;
            d.b("Component-Action-Button", str2);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
            return false;
        }
        d.a.l0.a.c0.b.c G = aVar.G(q);
        boolean a2 = G.a();
        if (a2) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, G.f40850b);
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
            d.b("Component-Action-Button", "params is null");
            return null;
        }
        c cVar = new c();
        try {
            cVar.a(k);
        } catch (JSONException e2) {
            e2.printStackTrace();
            d.c("Component-Action-Button", "model parse exception:", e2);
        }
        return cVar;
    }
}
