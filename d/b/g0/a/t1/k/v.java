package d.b.g0.a.t1.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.t1.k.p0.g;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes3.dex */
public class v extends a0 {

    /* loaded from: classes3.dex */
    public class a implements g.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46956a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46957b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f46958c;

        public a(v vVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            this.f46956a = callbackHandler;
            this.f46957b = unitedSchemeEntity;
            this.f46958c = str;
        }

        @Override // d.b.g0.a.t1.k.p0.g.d
        public void a(String str) {
            d.b.g0.a.c0.c.g("PreloadSubPackage", "preload subPackage success");
            UnitedSchemeUtility.safeCallback(this.f46956a, this.f46957b, UnitedSchemeUtility.wrapCallbackParams(0, "preload subPackage success").toString(), this.f46958c);
        }

        @Override // d.b.g0.a.t1.k.p0.g.d
        public void b(int i) {
            d.b.g0.a.c0.c.b("PreloadSubPackage", "preload subPackage failed");
            UnitedSchemeUtility.safeCallback(this.f46956a, this.f46957b, UnitedSchemeUtility.wrapCallbackParams(1001, "No SubPackage").toString(), this.f46958c);
        }
    }

    public v(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/preloadSubPackage");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (eVar == null) {
            d.b.g0.a.c0.c.b("PreloadSubPackage", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            d.b.g0.a.c0.c.b("PreloadSubPackage", "params is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            d.b.g0.a.c0.c.b("PreloadSubPackage", "none cb");
            if (a0.f46680b) {
                Log.d("SwanAppAction", "preload subPackage cb is empty");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString2 = optParamsAsJo.optString("root");
        if (TextUtils.isEmpty(optString2)) {
            d.b.g0.a.c0.c.b("PreloadSubPackage", "subPackage root is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        } else if (eVar.h0(optString2) && eVar.g0(optString2)) {
            d.b.g0.a.c0.c.g("PreloadSubPackage", "subPackage have existed");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "subPackage have existed");
            return false;
        } else {
            String E = eVar.E(optString2);
            if (TextUtils.isEmpty(E)) {
                d.b.g0.a.c0.c.g("PreloadSubPackage", "subPackage cannot find aps key");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            d.b.g0.a.t1.k.p0.g.c(eVar.f46132f, eVar.W(), optString2, E, null, new a(this, callbackHandler, unitedSchemeEntity, optString));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
