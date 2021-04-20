package d.b.g0.a.a0.c.e.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.a0.c.e.b.c;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.b.g0.a.t1.k.b {

    /* loaded from: classes2.dex */
    public class a implements d.b.g0.a.a0.c.e.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.a0.c.e.b.b f43514a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43515b;

        public a(d.b.g0.a.a0.c.e.b.b bVar, CallbackHandler callbackHandler) {
            this.f43514a = bVar;
            this.f43515b = callbackHandler;
        }

        @Override // d.b.g0.a.a0.c.e.b.a
        public void a(int i, View view, @Nullable Object obj) {
            c cVar = (c) this.f43514a.n();
            if (i == 0 || i == 1) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "loadState");
                    jSONObject.put("parentId", cVar.f43507h);
                    jSONObject.put("viewId", cVar.f43505f);
                    jSONObject.put("loadState", i == 1 ? "finish" : "error");
                } catch (JSONException e2) {
                    d.b.g0.a.c0.c.c("Component-Action-ImageCover", "loadState callback error", e2);
                }
                b.this.s(this.f43515b, jSONObject, cVar.i);
            }
        }
    }

    public b(j jVar) {
        super(jVar, "/swanAPI/coverimage");
    }

    @Override // d.b.g0.a.t1.k.b
    @NonNull
    public String j() {
        return "/swanAPI/coverimage";
    }

    @Override // d.b.g0.a.t1.k.b
    public boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        if (a0.f46680b) {
            Log.d("Component-Action-ImageCover", "insert");
        }
        c r = r(unitedSchemeEntity);
        if (r == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b.g0.a.c0.c.b("Component-Action-ImageCover", "model is null");
            return false;
        }
        d.b.g0.a.a0.c.e.b.b bVar = new d.b.g0.a.a0.c.e.b.b(context, r);
        bVar.g0(new a(bVar, callbackHandler));
        d.b.g0.a.a0.b.c w = bVar.w();
        boolean a2 = w.a();
        if (a2) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, w.f43509b);
        }
        return a2;
    }

    @Override // d.b.g0.a.t1.k.b
    public boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        if (a0.f46680b) {
            Log.d("Component-Action-ImageCover", "remove");
        }
        c r = r(unitedSchemeEntity);
        if (r == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b.g0.a.c0.c.b("Component-Action-ImageCover", "model is null");
            return false;
        }
        d.b.g0.a.a0.c.e.b.b bVar = (d.b.g0.a.a0.c.e.b.b) d.b.g0.a.a0.d.a.a(r);
        if (bVar == null) {
            String str2 = "can't find imageCoverView component:#" + r.f43505f;
            d.b.g0.a.c0.c.b("Component-Action-ImageCover", str2);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
            return false;
        }
        d.b.g0.a.a0.b.c C = bVar.C();
        boolean a2 = C.a();
        if (a2) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, C.f43509b);
        }
        return a2;
    }

    @Override // d.b.g0.a.t1.k.b
    public boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, e eVar) {
        if (a0.f46680b) {
            Log.d("Component-Action-ImageCover", IMTrack.DbBuilder.ACTION_UPDATE);
        }
        c r = r(unitedSchemeEntity);
        if (r == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b.g0.a.c0.c.b("Component-Action-ImageCover", "model is null");
            return false;
        }
        d.b.g0.a.a0.c.e.b.b bVar = (d.b.g0.a.a0.c.e.b.b) d.b.g0.a.a0.d.a.a(r);
        if (bVar == null) {
            String str2 = "can't find imageCoverView component:#" + r.f43505f;
            d.b.g0.a.c0.c.b("Component-Action-ImageCover", str2);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
            return false;
        }
        d.b.g0.a.a0.b.c G = bVar.G(r);
        boolean a2 = G.a();
        if (a2) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, G.f43509b);
        }
        return a2;
    }

    @Nullable
    public final c r(UnitedSchemeEntity unitedSchemeEntity) {
        if (unitedSchemeEntity == null) {
            return null;
        }
        JSONObject k = k(unitedSchemeEntity);
        if (k == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b.g0.a.c0.c.b("Component-Action-ImageCover", "params is null");
            return null;
        }
        c cVar = new c();
        try {
            cVar.a(k);
        } catch (JSONException e2) {
            e2.printStackTrace();
            d.b.g0.a.c0.c.c("Component-Action-ImageCover", "model parse exception:", e2);
        }
        return cVar;
    }

    public final void s(@NonNull CallbackHandler callbackHandler, JSONObject jSONObject, String str) {
        d.b.g0.a.c0.c.g("Component-Action-ImageCover", "sendAsyncCallback info: " + jSONObject);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
    }
}
