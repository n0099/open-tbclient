package d.a.h0.a.t1.k.f0;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import d.a.h0.a.k;
import d.a.h0.a.t1.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends b {

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.m0.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44435a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44436b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44437c;

        public a(f fVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            this.f44435a = callbackHandler;
            this.f44436b = unitedSchemeEntity;
            this.f44437c = str;
        }

        @Override // d.a.h0.a.m0.b.a
        public void a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("success", "0");
            } catch (JSONException e2) {
                if (k.f43101a) {
                    e2.printStackTrace();
                }
            }
            UnitedSchemeUtility.safeCallback(this.f44435a, this.f44436b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f44437c);
        }

        @Override // d.a.h0.a.m0.b.a
        public void b() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("success", "1");
            } catch (JSONException e2) {
                if (k.f43101a) {
                    e2.printStackTrace();
                }
            }
            UnitedSchemeUtility.safeCallback(this.f44435a, this.f44436b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f44437c);
        }
    }

    public f(j jVar) {
        super(jVar, "/swanAPI/topFavor");
    }

    @Override // d.a.h0.a.t1.k.f0.b
    public boolean j(d.a.h0.a.r1.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            return false;
        }
        try {
            String optString = new JSONObject(param).optString("appid");
            this.f44421c = optString;
            return !TextUtils.isEmpty(optString);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.a.h0.a.t1.k.f0.b
    public void k(d.a.h0.a.r1.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        SwanFavorDataManager.i().k(this.f44421c, 1, new a(this, callbackHandler, unitedSchemeEntity, str));
    }
}
