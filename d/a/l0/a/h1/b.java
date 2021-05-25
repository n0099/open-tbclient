package d.a.l0.a.h1;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public UnitedSchemeEntity f42662a;

    /* renamed from: b  reason: collision with root package name */
    public CallbackHandler f42663b;

    public b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        this.f42662a = unitedSchemeEntity;
        this.f42663b = callbackHandler;
    }

    public static b a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return new b(unitedSchemeEntity, callbackHandler);
    }

    public void b(String str, int i2, String str2) {
        UnitedSchemeUtility.safeCallback(this.f42663b, this.f42662a, UnitedSchemeUtility.wrapCallbackParams(i2, str2).toString(), str);
    }

    public void c(String str, JSONObject jSONObject) {
        UnitedSchemeUtility.safeCallback(this.f42663b, this.f42662a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
    }

    public void d(int i2) {
        this.f42662a.result = UnitedSchemeUtility.wrapCallbackParams(i2);
    }

    public void e(JSONObject jSONObject) {
        UnitedSchemeEntity unitedSchemeEntity = this.f42662a;
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(this.f42663b, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
    }
}
