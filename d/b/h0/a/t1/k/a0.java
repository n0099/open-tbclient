package d.b.h0.a.t1.k;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class a0 extends d<UnitedSchemeBaseDispatcher> {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f47009b = d.b.h0.a.k.f45772a;

    public a0(UnitedSchemeBaseDispatcher unitedSchemeBaseDispatcher, String str) {
        super(unitedSchemeBaseDispatcher, str);
    }

    @Nullable
    public static JSONObject a(UnitedSchemeEntity unitedSchemeEntity, String str) {
        if (unitedSchemeEntity == null) {
            return null;
        }
        String param = unitedSchemeEntity.getParam(str);
        if (TextUtils.isEmpty(param)) {
            return null;
        }
        try {
            return new JSONObject(param);
        } catch (JSONException e2) {
            if (f47009b) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public d.b.h0.a.r1.e c() {
        return d.b.h0.a.r1.e.y();
    }

    public abstract boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar);

    public boolean h(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        try {
            if (TextUtils.equals(this.f47011a, str)) {
                return g(context, unitedSchemeEntity, callbackHandler, c());
            }
            return i(context, unitedSchemeEntity, callbackHandler, str, c());
        } catch (Throwable th) {
            if (f47009b) {
                Log.e("SwanAppAction", Log.getStackTraceString(th));
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "execute with exception: " + Log.getStackTraceString(th));
            return false;
        }
    }

    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.b.h0.a.r1.e eVar) {
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(101, "not support such action ：" + this.f47011a + str);
        return false;
    }
}
