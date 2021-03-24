package d.b.g0.a.a0.c.e.a;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.c0.c;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.b.g0.a.t1.k.b {
    public a(j jVar) {
        super(jVar, "/swanAPI/coverview");
    }

    @Override // d.b.g0.a.t1.k.b
    @NonNull
    public String j() {
        return "/swanAPI/coverview";
    }

    @Override // d.b.g0.a.t1.k.b
    public boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        if (a0.f46287b) {
            Log.d("Component-Action-CoverView", "insert");
        }
        d.b.g0.a.a0.c.e.c.b q = q(unitedSchemeEntity);
        if (q == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.b("Component-Action-CoverView", "model is null");
            return false;
        }
        d.b.g0.a.a0.b.c w = new d.b.g0.a.a0.c.e.c.a(context, q).w();
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
            Log.d("Component-Action-CoverView", "remove");
        }
        d.b.g0.a.a0.c.e.c.b q = q(unitedSchemeEntity);
        if (q == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.b("Component-Action-CoverView", "model is null");
            return false;
        }
        d.b.g0.a.a0.c.e.c.a aVar = (d.b.g0.a.a0.c.e.c.a) d.b.g0.a.a0.d.a.a(q);
        if (aVar == null) {
            String str2 = "can't find coverView component:#" + q.f43112f;
            c.b("Component-Action-CoverView", str2);
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
            Log.d("Component-Action-CoverView", IMTrack.DbBuilder.ACTION_UPDATE);
        }
        d.b.g0.a.a0.c.e.c.b q = q(unitedSchemeEntity);
        if (q == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.b("Component-Action-CoverView", "model is null");
            return false;
        }
        d.b.g0.a.a0.c.e.c.a aVar = (d.b.g0.a.a0.c.e.c.a) d.b.g0.a.a0.d.a.a(q);
        if (aVar == null) {
            String str2 = "can't find coverView component:#" + q.f43112f;
            c.b("Component-Action-CoverView", str2);
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
    public final d.b.g0.a.a0.c.e.c.b q(UnitedSchemeEntity unitedSchemeEntity) {
        if (unitedSchemeEntity == null) {
            return null;
        }
        JSONObject k = k(unitedSchemeEntity);
        if (k == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            c.b("Component-Action-CoverView", "params is null");
            return null;
        }
        d.b.g0.a.a0.c.e.c.b bVar = new d.b.g0.a.a0.c.e.c.b();
        try {
            bVar.a(k);
        } catch (JSONException e2) {
            e2.printStackTrace();
            c.c("Component-Action-CoverView", "model parse exception:", e2);
        }
        return bVar;
    }
}
