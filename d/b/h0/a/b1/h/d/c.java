package d.b.h0.a.b1.h.d;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.k;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44285a = k.f45772a;

    public c(@NonNull String str) {
    }

    public abstract boolean a(d.b.h0.a.b1.h.a aVar, d.b.h0.a.b1.h.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar);

    @Nullable
    public d.b.h0.a.b1.h.a b(@NonNull Context context, @Nullable String str, @Nullable String str2, @NonNull String str3, @NonNull JSONObject jSONObject) {
        d.b.h0.a.b1.a f2;
        if (TextUtils.isEmpty(str3) || (f2 = d.b.h0.a.b1.b.f(str, str2, str3)) == null || !(f2.a() instanceof d.b.h0.a.b1.h.a)) {
            return null;
        }
        return (d.b.h0.a.b1.h.a) f2.a();
    }

    public boolean c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        if (f44285a) {
            Log.d("VideoPlayerAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            d.b.h0.a.c0.c.b("vrvideo", "param is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        d.b.h0.a.b1.h.a b2 = b(context, optParamsAsJo.optString("slaveId"), optParamsAsJo.optString("sanId"), optParamsAsJo.optString("videoId"), optParamsAsJo);
        if (b2 != null && context != null) {
            d.b.h0.a.b1.h.c h2 = d.b.h0.a.b1.h.c.h(optParamsAsJo, b2.h());
            if (!h2.isValid()) {
                d.b.h0.a.c0.c.b("vrvideo", "param is invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            return a(b2, h2, context, unitedSchemeEntity, callbackHandler, eVar);
        }
        d.b.h0.a.c0.c.b("vrvideo", "player id is invalid or context is null");
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
        return false;
    }
}
