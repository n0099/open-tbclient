package d.a.i0.a.a0.a;

import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.i0.a.c2.f.a0;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class a extends a0 {
    public a(d.a.i0.a.c2.e eVar, String str) {
        super(eVar, str);
    }

    public void j(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, boolean z) {
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, z ? 0 : 1001);
    }

    public d.a.i0.a.a0.b.a k(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.a.i0.a.a0.b.a(unitedSchemeEntity.getParams().get("params"));
    }

    public JSONObject l(int i2) {
        return UnitedSchemeUtility.wrapCallbackParams(i2);
    }
}
