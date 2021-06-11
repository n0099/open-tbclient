package d.a.l0.a.p0.h;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.l0.a.k;
import d.a.l0.t.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f47767c = k.f46875a;

    /* renamed from: d  reason: collision with root package name */
    public static a f47768d;

    /* renamed from: e  reason: collision with root package name */
    public static a f47769e;

    /* renamed from: a  reason: collision with root package name */
    public String f47770a;

    /* renamed from: b  reason: collision with root package name */
    public long f47771b;

    @NonNull
    public static a a(@NonNull String str) {
        if (f47768d == null) {
            f47768d = d(e(str));
        }
        return f47768d;
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
        if (f47769e == null) {
            f47769e = d(e(str));
        }
        return f47769e;
    }

    @NonNull
    public static a d(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.f47770a = jSONObject.optString("extension-core-version-name");
            aVar.f47771b = jSONObject.optLong("extension-core-version-code");
        }
        return aVar;
    }

    public static JSONObject e(@NonNull String str) {
        if (f47767c) {
            Log.d("ExtCore-PresetConfig", "readPresetConfig start.");
        }
        String C = d.C(AppRuntime.getAppContext(), str);
        if (TextUtils.isEmpty(C)) {
            if (f47767c) {
                Log.w("ExtCore-PresetConfig", "readPresetConfig: empty preset json.");
            }
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(C);
            if (f47767c) {
                Log.d("ExtCore-PresetConfig", "readPresetConfig end. config: " + jSONObject.toString());
            }
            return jSONObject;
        } catch (JSONException e2) {
            if (f47767c) {
                throw new RuntimeException(e2);
            }
            return null;
        }
    }
}
