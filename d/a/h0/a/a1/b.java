package d.a.h0.a.a1;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public UnitedSchemeEntity f41167a;

    /* renamed from: b  reason: collision with root package name */
    public CallbackHandler f41168b;

    public b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.f41167a = unitedSchemeEntity;
        this.f41168b = callbackHandler;
    }

    public static b a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return new b(unitedSchemeEntity, callbackHandler);
    }

    public void b(String str, int i2, String str2) {
        UnitedSchemeUtility.safeCallback(this.f41168b, this.f41167a, UnitedSchemeUtility.wrapCallbackParams(i2, str2).toString(), str);
    }

    public void c(String str, JSONObject jSONObject) {
        UnitedSchemeUtility.safeCallback(this.f41168b, this.f41167a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }

    public void d(int i2) {
        this.f41167a.result = UnitedSchemeUtility.wrapCallbackParams(i2);
    }

    public void e(JSONObject jSONObject) {
        UnitedSchemeEntity unitedSchemeEntity = this.f41167a;
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(this.f41168b, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
    }
}
