package d.a.i0.a.c0.c.e.a;

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
import d.a.i0.a.c0.c.e.b.c;
import d.a.i0.a.c2.e;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.e0.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends d.a.i0.a.c2.f.b {

    /* loaded from: classes2.dex */
    public class a implements d.a.i0.a.c0.c.e.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.c0.c.e.b.b f40684a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f40685b;

        public a(d.a.i0.a.c0.c.e.b.b bVar, CallbackHandler callbackHandler) {
            this.f40684a = bVar;
            this.f40685b = callbackHandler;
        }

        @Override // d.a.i0.a.c0.c.e.b.a
        public void a(int i2, View view, @Nullable Object obj) {
            c cVar = (c) this.f40684a.n();
            if (i2 == 0 || i2 == 1) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "loadState");
                    jSONObject.put("parentId", cVar.f40673h);
                    jSONObject.put("viewId", cVar.f40671f);
                    jSONObject.put("loadState", i2 == 1 ? "finish" : "error");
                } catch (JSONException e2) {
                    d.c("Component-Action-ImageCover", "loadState callback error", e2);
                }
                b.this.s(this.f40685b, jSONObject, cVar.f40674i);
            }
        }
    }

    public b(e eVar) {
        super(eVar, "/swanAPI/coverimage");
    }

    @Override // d.a.i0.a.c2.f.b
    @NonNull
    public String j() {
        return "/swanAPI/coverimage";
    }

    @Override // d.a.i0.a.c2.f.b
    public boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.i0.a.a2.e eVar) {
        if (a0.f40775b) {
            Log.d("Component-Action-ImageCover", "insert");
        }
        c r = r(unitedSchemeEntity);
        if (r == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b("Component-Action-ImageCover", "model is null");
            return false;
        }
        d.a.i0.a.c0.c.e.b.b bVar = new d.a.i0.a.c0.c.e.b.b(context, r);
        bVar.g0(new a(bVar, callbackHandler));
        d.a.i0.a.c0.b.c w = bVar.w();
        boolean a2 = w.a();
        if (a2) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, w.f40676b);
        }
        return a2;
    }

    @Override // d.a.i0.a.c2.f.b
    public boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.i0.a.a2.e eVar) {
        if (a0.f40775b) {
            Log.d("Component-Action-ImageCover", "remove");
        }
        c r = r(unitedSchemeEntity);
        if (r == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b("Component-Action-ImageCover", "model is null");
            return false;
        }
        d.a.i0.a.c0.c.e.b.b bVar = (d.a.i0.a.c0.c.e.b.b) d.a.i0.a.c0.d.a.a(r);
        if (bVar == null) {
            String str2 = "can't find imageCoverView component:#" + r.f40671f;
            d.b("Component-Action-ImageCover", str2);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
            return false;
        }
        d.a.i0.a.c0.b.c C = bVar.C();
        boolean a2 = C.a();
        if (a2) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, C.f40676b);
        }
        return a2;
    }

    @Override // d.a.i0.a.c2.f.b
    public boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.i0.a.a2.e eVar) {
        if (a0.f40775b) {
            Log.d("Component-Action-ImageCover", IMTrack.DbBuilder.ACTION_UPDATE);
        }
        c r = r(unitedSchemeEntity);
        if (r == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b("Component-Action-ImageCover", "model is null");
            return false;
        }
        d.a.i0.a.c0.c.e.b.b bVar = (d.a.i0.a.c0.c.e.b.b) d.a.i0.a.c0.d.a.a(r);
        if (bVar == null) {
            String str2 = "can't find imageCoverView component:#" + r.f40671f;
            d.b("Component-Action-ImageCover", str2);
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
            return false;
        }
        d.a.i0.a.c0.b.c G = bVar.G(r);
        boolean a2 = G.a();
        if (a2) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        } else {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, G.f40676b);
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
            d.b("Component-Action-ImageCover", "params is null");
            return null;
        }
        c cVar = new c();
        try {
            cVar.a(k);
        } catch (JSONException e2) {
            e2.printStackTrace();
            d.c("Component-Action-ImageCover", "model parse exception:", e2);
        }
        return cVar;
    }

    public final void s(@NonNull CallbackHandler callbackHandler, JSONObject jSONObject, String str) {
        d.g("Component-Action-ImageCover", "sendAsyncCallback info: " + jSONObject);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
    }
}
