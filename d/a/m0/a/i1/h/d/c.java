package d.a.m0.a.i1.h.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46800a = k.f46983a;

    public c(@NonNull String str) {
    }

    public abstract boolean a(d.a.m0.a.i1.h.a aVar, d.a.m0.a.i1.h.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar);

    @Nullable
    public d.a.m0.a.i1.h.a b(@NonNull Context context, @Nullable String str, @Nullable String str2, @NonNull String str3, @NonNull JSONObject jSONObject) {
        d.a.m0.a.i1.a f2;
        if (TextUtils.isEmpty(str3) || (f2 = d.a.m0.a.i1.b.f(str, str2, str3)) == null || !(f2.i() instanceof d.a.m0.a.i1.h.a)) {
            return null;
        }
        return (d.a.m0.a.i1.h.a) f2.i();
    }

    public boolean c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (f46800a) {
            Log.d("VideoPlayerAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            d.a.m0.a.e0.d.b("vrvideo", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        d.a.m0.a.i1.h.a b2 = b(context, optParamsAsJo.optString("slaveId"), optParamsAsJo.optString("sanId"), optParamsAsJo.optString("videoId"), optParamsAsJo);
        if (b2 != null && context != null) {
            d.a.m0.a.i1.h.c h2 = d.a.m0.a.i1.h.c.h(optParamsAsJo, b2.d());
            if (!h2.isValid()) {
                d.a.m0.a.e0.d.b("vrvideo", "param is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            return a(b2, h2, context, unitedSchemeEntity, callbackHandler, eVar);
        }
        d.a.m0.a.e0.d.b("vrvideo", "player id is invalid or context is null");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return false;
    }
}
