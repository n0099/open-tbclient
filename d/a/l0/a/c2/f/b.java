package d.a.l0.a.c2.f;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class b extends a0 {
    public b(d.a.l0.a.c2.e eVar, String str) {
        super(eVar, str);
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        return false;
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.l0.a.a2.e eVar) {
        boolean n;
        String l = l("insert");
        String l2 = l(IMTrack.DbBuilder.ACTION_UPDATE);
        String l3 = l("remove");
        if (TextUtils.equals(l, str)) {
            n = m(context, unitedSchemeEntity, callbackHandler, str, eVar);
        } else if (TextUtils.equals(l2, str)) {
            n = p(context, unitedSchemeEntity, callbackHandler, str, eVar);
        } else if (TextUtils.equals(l3, str)) {
            n = o(context, unitedSchemeEntity, callbackHandler, str, eVar);
        } else {
            n = n(context, unitedSchemeEntity, callbackHandler, str, eVar);
        }
        d.a.l0.a.e0.d.a("AbsSwanAppWidget", "subAction = " + str + " ; handle result = " + n);
        return n;
    }

    @NonNull
    public abstract String j();

    public JSONObject k(UnitedSchemeEntity unitedSchemeEntity) {
        if (unitedSchemeEntity == null) {
            d.a.l0.a.e0.d.b("AbsSwanAppWidget", "getParamsJSONObject entity is null");
            return null;
        }
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            d.a.l0.a.e0.d.b("AbsSwanAppWidget", "getParamsJSONObject paramsJson is empty");
            return null;
        }
        try {
            return new JSONObject(param);
        } catch (JSONException e2) {
            d.a.l0.a.e0.d.b("AbsSwanAppWidget", "getParamsJSONObject exception = " + e2.getMessage());
            if (a0.f44625b) {
                e2.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public final String l(String str) {
        return j() + "/" + str;
    }

    public abstract boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.l0.a.a2.e eVar);

    public boolean n(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.l0.a.a2.e eVar) {
        return super.i(context, unitedSchemeEntity, callbackHandler, str, eVar);
    }

    public abstract boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.l0.a.a2.e eVar);

    public abstract boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.l0.a.a2.e eVar);
}
