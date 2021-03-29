package d.b.g0.a.a1;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public UnitedSchemeEntity f43181a;

    /* renamed from: b  reason: collision with root package name */
    public CallbackHandler f43182b;

    public b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.f43181a = unitedSchemeEntity;
        this.f43182b = callbackHandler;
    }

    public static b a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return new b(unitedSchemeEntity, callbackHandler);
    }

    public void b(String str, int i, String str2) {
        UnitedSchemeUtility.safeCallback(this.f43182b, this.f43181a, UnitedSchemeUtility.wrapCallbackParams(i, str2).toString(), str);
    }

    public void c(String str, JSONObject jSONObject) {
        UnitedSchemeUtility.safeCallback(this.f43182b, this.f43181a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }

    public void d(int i) {
        this.f43181a.result = UnitedSchemeUtility.wrapCallbackParams(i);
    }

    public void e(JSONObject jSONObject) {
        UnitedSchemeEntity unitedSchemeEntity = this.f43181a;
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(this.f43182b, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
    }
}
