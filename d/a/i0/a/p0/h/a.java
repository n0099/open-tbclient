package d.a.i0.a.p0.h;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.i0.a.k;
import d.a.i0.t.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f43917c = k.f43025a;

    /* renamed from: d  reason: collision with root package name */
    public static a f43918d;

    /* renamed from: e  reason: collision with root package name */
    public static a f43919e;

    /* renamed from: a  reason: collision with root package name */
    public String f43920a;

    /* renamed from: b  reason: collision with root package name */
    public long f43921b;

    @NonNull
    public static a a(@NonNull String str) {
        if (f43918d == null) {
            f43918d = d(e(str));
        }
        return f43918d;
    }

    @NonNull
    public static a b(@NonNull d.a.i0.a.p0.g.c.a aVar) {
        if (aVar.c() == 1) {
            return c(aVar.d());
        }
        return a(aVar.d());
    }

    @NonNull
    public static a c(@NonNull String str) {
        if (f43919e == null) {
            f43919e = d(e(str));
        }
        return f43919e;
    }

    @NonNull
    public static a d(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.f43920a = jSONObject.optString("extension-core-version-name");
            aVar.f43921b = jSONObject.optLong("extension-core-version-code");
        }
        return aVar;
    }

    public static JSONObject e(@NonNull String str) {
        if (f43917c) {
            Log.d("ExtCore-PresetConfig", "readPresetConfig start.");
        }
        String C = d.C(AppRuntime.getAppContext(), str);
        if (TextUtils.isEmpty(C)) {
            if (f43917c) {
                Log.w("ExtCore-PresetConfig", "readPresetConfig: empty preset json.");
            }
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(C);
            if (f43917c) {
                Log.d("ExtCore-PresetConfig", "readPresetConfig end. config: " + jSONObject.toString());
            }
            return jSONObject;
        } catch (JSONException e2) {
            if (f43917c) {
                throw new RuntimeException(e2);
            }
            return null;
        }
    }
}
