package d.a.m0.a.p0.h;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.m0.a.k;
import d.a.m0.t.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f47875c = k.f46983a;

    /* renamed from: d  reason: collision with root package name */
    public static a f47876d;

    /* renamed from: e  reason: collision with root package name */
    public static a f47877e;

    /* renamed from: a  reason: collision with root package name */
    public String f47878a;

    /* renamed from: b  reason: collision with root package name */
    public long f47879b;

    @NonNull
    public static a a(@NonNull String str) {
        if (f47876d == null) {
            f47876d = d(e(str));
        }
        return f47876d;
    }

    @NonNull
    public static a b(@NonNull d.a.m0.a.p0.g.c.a aVar) {
        if (aVar.c() == 1) {
            return c(aVar.d());
        }
        return a(aVar.d());
    }

    @NonNull
    public static a c(@NonNull String str) {
        if (f47877e == null) {
            f47877e = d(e(str));
        }
        return f47877e;
    }

    @NonNull
    public static a d(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.f47878a = jSONObject.optString("extension-core-version-name");
            aVar.f47879b = jSONObject.optLong("extension-core-version-code");
        }
        return aVar;
    }

    public static JSONObject e(@NonNull String str) {
        if (f47875c) {
            Log.d("ExtCore-PresetConfig", "readPresetConfig start.");
        }
        String C = d.C(AppRuntime.getAppContext(), str);
        if (TextUtils.isEmpty(C)) {
            if (f47875c) {
                Log.w("ExtCore-PresetConfig", "readPresetConfig: empty preset json.");
            }
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(C);
            if (f47875c) {
                Log.d("ExtCore-PresetConfig", "readPresetConfig end. config: " + jSONObject.toString());
            }
            return jSONObject;
        } catch (JSONException e2) {
            if (f47875c) {
                throw new RuntimeException(e2);
            }
            return null;
        }
    }
}
