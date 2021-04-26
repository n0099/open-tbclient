package d.a.h0.a.l0.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.h0.a.k;
import d.a.h0.p.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f43212b = k.f43101a;

    /* renamed from: c  reason: collision with root package name */
    public static a f43213c;

    /* renamed from: d  reason: collision with root package name */
    public static a f43214d;

    /* renamed from: a  reason: collision with root package name */
    public String f43215a;

    @NonNull
    public static a a(@NonNull String str) {
        if (f43213c == null) {
            f43213c = d(e(str));
        }
        return f43213c;
    }

    @NonNull
    public static a b(@NonNull d.a.h0.a.l0.h.c.a aVar) {
        if (aVar.b() == 1) {
            return c(aVar.c());
        }
        return a(aVar.c());
    }

    @NonNull
    public static a c(@NonNull String str) {
        if (f43214d == null) {
            f43214d = d(e(str));
        }
        return f43214d;
    }

    @NonNull
    public static a d(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.f43215a = jSONObject.optString("extension-core-version");
        }
        return aVar;
    }

    public static JSONObject e(@NonNull String str) {
        if (f43212b) {
            Log.d("ExtCore-PresetConfig", "readPresetConfig start.");
        }
        String q = d.q(AppRuntime.getAppContext(), str);
        if (TextUtils.isEmpty(q)) {
            if (f43212b) {
                Log.w("ExtCore-PresetConfig", "readPresetConfig: empty preset json.");
            }
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(q);
            if (f43212b) {
                Log.d("ExtCore-PresetConfig", "readPresetConfig end. config: " + jSONObject.toString());
            }
            return jSONObject;
        } catch (JSONException e2) {
            if (f43212b) {
                throw new RuntimeException(e2);
            }
            return null;
        }
    }
}
