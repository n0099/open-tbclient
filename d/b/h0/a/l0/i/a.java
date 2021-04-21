package d.b.h0.a.l0.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.h0.a.k;
import d.b.h0.p.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45878b = k.f45772a;

    /* renamed from: c  reason: collision with root package name */
    public static a f45879c;

    /* renamed from: d  reason: collision with root package name */
    public static a f45880d;

    /* renamed from: a  reason: collision with root package name */
    public String f45881a;

    @NonNull
    public static a a(@NonNull String str) {
        if (f45879c == null) {
            f45879c = d(e(str));
        }
        return f45879c;
    }

    @NonNull
    public static a b(@NonNull d.b.h0.a.l0.h.c.a aVar) {
        if (aVar.c() == 1) {
            return c(aVar.d());
        }
        return a(aVar.d());
    }

    @NonNull
    public static a c(@NonNull String str) {
        if (f45880d == null) {
            f45880d = d(e(str));
        }
        return f45880d;
    }

    @NonNull
    public static a d(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.f45881a = jSONObject.optString("extension-core-version");
        }
        return aVar;
    }

    public static JSONObject e(@NonNull String str) {
        if (f45878b) {
            Log.d("ExtCore-PresetConfig", "readPresetConfig start.");
        }
        String q = d.q(AppRuntime.getAppContext(), str);
        if (TextUtils.isEmpty(q)) {
            if (f45878b) {
                Log.w("ExtCore-PresetConfig", "readPresetConfig: empty preset json.");
            }
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(q);
            if (f45878b) {
                Log.d("ExtCore-PresetConfig", "readPresetConfig end. config: " + jSONObject.toString());
            }
            return jSONObject;
        } catch (JSONException e2) {
            if (f45878b) {
                throw new RuntimeException(e2);
            }
            return null;
        }
    }
}
