package d.a.m0.a.c2.f;

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
    public static final boolean f44733b = d.a.m0.a.k.f46983a;

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
            if (f44733b) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public d.a.m0.a.a2.e c() {
        return d.a.m0.a.a2.e.i();
    }

    public abstract boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar);

    public boolean h(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        try {
            if (TextUtils.equals(this.f44735a, str)) {
                return d(context, unitedSchemeEntity, callbackHandler, c());
            }
            return i(context, unitedSchemeEntity, callbackHandler, str, c());
        } catch (Throwable th) {
            if (f44733b) {
                Log.e("SwanAppAction", Log.getStackTraceString(th));
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "execute with exception: " + Log.getStackTraceString(th));
            return false;
        }
    }

    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, d.a.m0.a.a2.e eVar) {
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(101, "not support such action ：" + unitedSchemeEntity.getUri().getPath());
        return false;
    }
}
