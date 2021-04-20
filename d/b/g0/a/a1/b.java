package d.b.g0.a.a1;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public UnitedSchemeEntity f43573a;

    /* renamed from: b  reason: collision with root package name */
    public CallbackHandler f43574b;

    public b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.f43573a = unitedSchemeEntity;
        this.f43574b = callbackHandler;
    }

    public static b a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return new b(unitedSchemeEntity, callbackHandler);
    }

    public void b(String str, int i, String str2) {
        UnitedSchemeUtility.safeCallback(this.f43574b, this.f43573a, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString(), str);
    }

    public void c(String str, JSONObject jSONObject) {
        UnitedSchemeUtility.safeCallback(this.f43574b, this.f43573a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }

    public void d(int i) {
        this.f43573a.result = UnitedSchemeUtility.wrapCallbackParams(i);
    }

    public void e(JSONObject jSONObject) {
        UnitedSchemeEntity unitedSchemeEntity = this.f43573a;
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(this.f43574b, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
    }
}
