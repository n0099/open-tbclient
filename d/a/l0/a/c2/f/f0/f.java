package d.a.l0.a.c2.f.f0;

import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import d.a.l0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends b {

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.q0.b.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44679a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44680b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44681c;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            this.f44679a = callbackHandler;
            this.f44680b = unitedSchemeEntity;
            this.f44681c = str;
        }

        @Override // d.a.l0.a.q0.b.a
        public void a() {
            f.this.n(this.f44680b, this.f44679a, this.f44681c);
        }

        @Override // d.a.l0.a.q0.b.a
        public void b() {
            f.this.n(this.f44680b, this.f44679a, this.f44681c);
        }

        @Override // d.a.l0.a.q0.b.a
        public void c() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("success", "1");
            } catch (JSONException e2) {
                if (k.f46875a) {
                    e2.printStackTrace();
                }
            }
            UnitedSchemeUtility.safeCallback(this.f44679a, this.f44680b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f44681c);
        }
    }

    public f(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/topFavor");
    }

    @Override // d.a.l0.a.c2.f.f0.b
    public boolean j(d.a.l0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity) {
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            return false;
        }
        try {
            String optString = new JSONObject(param).optString("appid");
            this.f44665c = optString;
            return !TextUtils.isEmpty(optString);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // d.a.l0.a.c2.f.f0.b
    public void k(d.a.l0.a.a2.e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        SwanFavorDataManager.h().j(this.f44665c, new a(callbackHandler, unitedSchemeEntity, str));
    }
}
