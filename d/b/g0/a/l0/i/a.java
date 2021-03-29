package d.b.g0.a.l0.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.g0.a.k;
import d.b.g0.p.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45157b = k.f45051a;

    /* renamed from: c  reason: collision with root package name */
    public static a f45158c;

    /* renamed from: d  reason: collision with root package name */
    public static a f45159d;

    /* renamed from: a  reason: collision with root package name */
    public String f45160a;

    @NonNull
    public static a a(@NonNull String str) {
        if (f45158c == null) {
            f45158c = d(e(str));
        }
        return f45158c;
    }

    @NonNull
    public static a b(@NonNull d.b.g0.a.l0.h.c.a aVar) {
        if (aVar.c() == 1) {
            return c(aVar.d());
        }
        return a(aVar.d());
    }

    @NonNull
    public static a c(@NonNull String str) {
        if (f45159d == null) {
            f45159d = d(e(str));
        }
        return f45159d;
    }

    @NonNull
    public static a d(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.f45160a = jSONObject.optString("extension-core-version");
        }
        return aVar;
    }

    public static JSONObject e(@NonNull String str) {
        if (f45157b) {
            Log.d("ExtCore-PresetConfig", "readPresetConfig start.");
        }
        String q = d.q(AppRuntime.getAppContext(), str);
        if (TextUtils.isEmpty(q)) {
            if (f45157b) {
                Log.w("ExtCore-PresetConfig", "readPresetConfig: empty preset json.");
            }
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(q);
            if (f45157b) {
                Log.d("ExtCore-PresetConfig", "readPresetConfig end. config: " + jSONObject.toString());
            }
            return jSONObject;
        } catch (JSONException e2) {
            if (f45157b) {
                throw new RuntimeException(e2);
            }
            return null;
        }
    }
}
