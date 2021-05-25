package d.a.l0.a.p0.h;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.l0.a.k;
import d.a.l0.t.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f44093c = k.f43199a;

    /* renamed from: d  reason: collision with root package name */
    public static a f44094d;

    /* renamed from: e  reason: collision with root package name */
    public static a f44095e;

    /* renamed from: a  reason: collision with root package name */
    public String f44096a;

    /* renamed from: b  reason: collision with root package name */
    public long f44097b;

    @NonNull
    public static a a(@NonNull String str) {
        if (f44094d == null) {
            f44094d = d(e(str));
        }
        return f44094d;
    }

    @NonNull
    public static a b(@NonNull d.a.l0.a.p0.g.c.a aVar) {
        if (aVar.c() == 1) {
            return c(aVar.d());
        }
        return a(aVar.d());
    }

    @NonNull
    public static a c(@NonNull String str) {
        if (f44095e == null) {
            f44095e = d(e(str));
        }
        return f44095e;
    }

    @NonNull
    public static a d(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.f44096a = jSONObject.optString("extension-core-version-name");
            aVar.f44097b = jSONObject.optLong("extension-core-version-code");
        }
        return aVar;
    }

    public static JSONObject e(@NonNull String str) {
        if (f44093c) {
            Log.d("ExtCore-PresetConfig", "readPresetConfig start.");
        }
        String C = d.C(AppRuntime.getAppContext(), str);
        if (TextUtils.isEmpty(C)) {
            if (f44093c) {
                Log.w("ExtCore-PresetConfig", "readPresetConfig: empty preset json.");
            }
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(C);
            if (f44093c) {
                Log.d("ExtCore-PresetConfig", "readPresetConfig end. config: " + jSONObject.toString());
            }
            return jSONObject;
        } catch (JSONException e2) {
            if (f44093c) {
                throw new RuntimeException(e2);
            }
            return null;
        }
    }
}
