package d.a.l0.a.c2.f;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.l0.a.c2.f.p0.g;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
public class v extends a0 {

    /* loaded from: classes3.dex */
    public class a implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44949a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44950b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44951c;

        public a(v vVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            this.f44949a = callbackHandler;
            this.f44950b = unitedSchemeEntity;
            this.f44951c = str;
        }

        @Override // d.a.l0.a.c2.f.p0.g.d
        public void a(String str) {
            d.a.l0.a.e0.d.g("PreloadSubPackage", "preload subPackage success");
            UnitedSchemeUtility.safeCallback(this.f44949a, this.f44950b, UnitedSchemeUtility.wrapCallbackParams(0, "preload subPackage success").toString(), this.f44951c);
        }

        @Override // d.a.l0.a.c2.f.p0.g.d
        public void b(int i2) {
            d.a.l0.a.e0.d.b("PreloadSubPackage", "preload subPackage failed");
            UnitedSchemeUtility.safeCallback(this.f44949a, this.f44950b, UnitedSchemeUtility.wrapCallbackParams(1001, "No SubPackage").toString(), this.f44951c);
        }
    }

    public v(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/preloadSubPackage");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (eVar == null) {
            d.a.l0.a.e0.d.b("PreloadSubPackage", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            d.a.l0.a.e0.d.b("PreloadSubPackage", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.a.l0.a.e0.d.b("PreloadSubPackage", "none cb");
            if (a0.f44625b) {
                Log.d("SwanAppAction", "preload subPackage cb is empty");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString2 = optParamsAsJo.optString(PrefetchEvent.EVENT_DATA_ROOT_PATH);
        if (TextUtils.isEmpty(optString2)) {
            d.a.l0.a.e0.d.b("PreloadSubPackage", "subPackage root is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (eVar.l0(optString2) && eVar.k0(optString2)) {
            d.a.l0.a.e0.d.g("PreloadSubPackage", "subPackage have existed");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "subPackage have existed");
            return false;
        } else {
            String G = eVar.G(optString2);
            if (TextUtils.isEmpty(G)) {
                d.a.l0.a.e0.d.g("PreloadSubPackage", "subPackage cannot find aps key");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            d.a.l0.a.c2.f.p0.g.k(eVar.f44425f, eVar.Z(), "1", optString2, G, null, new a(this, callbackHandler, unitedSchemeEntity, optString));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
