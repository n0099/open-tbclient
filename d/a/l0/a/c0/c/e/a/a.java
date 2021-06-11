package d.a.l0.a.c0.c.e.a;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c0.b.c;
import d.a.l0.a.c2.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e0.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.a.l0.a.c2.f.b {
    public a(e eVar) {
        super(eVar, "/swanAPI/coverview");
    }

    @Override // d.a.l0.a.c2.f.b
    @NonNull
    public String j() {
        return "/swanAPI/coverview";
    }

    @Override // d.a.l0.a.c2.f.b
    public boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.l0.a.a2.e eVar) {
        if (a0.f44625b) {
            Log.d("Component-Action-CoverView", "insert");
        }
        d.a.l0.a.c0.c.e.c.b q = q(unitedSchemeEntity);
        if (q == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b("Component-Action-CoverView", "model is null");
            return false;
        }
        c w = new d.a.l0.a.c0.c.e.c.a(context, q).w();
        boolean a2 = w.a();
        if (a2) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, w.f44526b);
        }
        return a2;
    }

    @Override // d.a.l0.a.c2.f.b
    public boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.l0.a.a2.e eVar) {
        if (a0.f44625b) {
            Log.d("Component-Action-CoverView", "remove");
        }
        d.a.l0.a.c0.c.e.c.b q = q(unitedSchemeEntity);
        if (q == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b("Component-Action-CoverView", "model is null");
            return false;
        }
        d.a.l0.a.c0.c.e.c.a aVar = (d.a.l0.a.c0.c.e.c.a) d.a.l0.a.c0.d.a.a(q);
        if (aVar == null) {
            String str2 = "can't find coverView component:#" + q.f44521f;
            d.b("Component-Action-CoverView", str2);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
            return false;
        }
        c C = aVar.C();
        boolean a2 = C.a();
        if (a2) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, C.f44526b);
        }
        return a2;
    }

    @Override // d.a.l0.a.c2.f.b
    public boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.l0.a.a2.e eVar) {
        if (a0.f44625b) {
            Log.d("Component-Action-CoverView", IMTrack.DbBuilder.ACTION_UPDATE);
        }
        d.a.l0.a.c0.c.e.c.b q = q(unitedSchemeEntity);
        if (q == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b("Component-Action-CoverView", "model is null");
            return false;
        }
        d.a.l0.a.c0.c.e.c.a aVar = (d.a.l0.a.c0.c.e.c.a) d.a.l0.a.c0.d.a.a(q);
        if (aVar == null) {
            String str2 = "can't find coverView component:#" + q.f44521f;
            d.b("Component-Action-CoverView", str2);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
            return false;
        }
        c G = aVar.G(q);
        boolean a2 = G.a();
        if (a2) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, G.f44526b);
        }
        return a2;
    }

    @Nullable
    public final d.a.l0.a.c0.c.e.c.b q(UnitedSchemeEntity unitedSchemeEntity) {
        if (unitedSchemeEntity == null) {
            return null;
        }
        JSONObject k = k(unitedSchemeEntity);
        if (k == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b("Component-Action-CoverView", "params is null");
            return null;
        }
        d.a.l0.a.c0.c.e.c.b bVar = new d.a.l0.a.c0.c.e.c.b();
        try {
            bVar.a(k);
        } catch (JSONException e2) {
            e2.printStackTrace();
            d.c("Component-Action-CoverView", "model parse exception:", e2);
        }
        return bVar;
    }
}
