package d.a.i0.a.i1.g.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42830a = d.a.i0.a.k.f43025a;

    public g(@NonNull String str) {
    }

    public abstract boolean a(d.a.i0.a.i1.g.a aVar, d.a.i0.a.i1.g.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar);

    @Nullable
    public d.a.i0.a.i1.g.a b(@NonNull Context context, @Nullable String str, @Nullable String str2, @NonNull String str3, @NonNull JSONObject jSONObject) {
        d.a.i0.a.i1.a f2;
        if (TextUtils.isEmpty(str3) || (f2 = d.a.i0.a.i1.b.f(str, str2, str3)) == null || !(f2.i() instanceof d.a.i0.a.i1.g.a)) {
            return null;
        }
        return (d.a.i0.a.i1.g.a) f2.i();
    }

    public boolean c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (f42830a) {
            Log.d("VideoPlayerAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            d.a.i0.a.e0.d.b("video", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        d.a.i0.a.i1.g.a b2 = b(context, optParamsAsJo.optString("slaveId"), optParamsAsJo.optString("sanId"), optParamsAsJo.optString("videoId"), optParamsAsJo);
        if (b2 != null && context != null) {
            d.a.i0.a.i1.g.c h2 = d.a.i0.a.i1.g.c.h(optParamsAsJo, b2.g());
            if (!h2.isValid()) {
                d.a.i0.a.e0.d.b("video", "param is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            return a(b2, h2, context, unitedSchemeEntity, callbackHandler, eVar);
        }
        d.a.i0.a.e0.d.b("video", "player id is invalid or context is null");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return false;
    }
}
