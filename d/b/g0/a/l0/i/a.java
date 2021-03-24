package d.b.g0.a.l0.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.g0.a.k;
import d.b.g0.p.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45156b = k.f45050a;

    /* renamed from: c  reason: collision with root package name */
    public static a f45157c;

    /* renamed from: d  reason: collision with root package name */
    public static a f45158d;

    /* renamed from: a  reason: collision with root package name */
    public String f45159a;

    @NonNull
    public static a a(@NonNull String str) {
        if (f45157c == null) {
            f45157c = d(e(str));
        }
        return f45157c;
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
        if (f45158d == null) {
            f45158d = d(e(str));
        }
        return f45158d;
    }

    @NonNull
    public static a d(JSONObject jSONObject) {
        a aVar = new a();
        if (jSONObject != null) {
            aVar.f45159a = jSONObject.optString("extension-core-version");
        }
        return aVar;
    }

    public static JSONObject e(@NonNull String str) {
        if (f45156b) {
            Log.d("ExtCore-PresetConfig", "readPresetConfig start.");
        }
        String q = d.q(AppRuntime.getAppContext(), str);
        if (TextUtils.isEmpty(q)) {
            if (f45156b) {
                Log.w("ExtCore-PresetConfig", "readPresetConfig: empty preset json.");
            }
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(q);
            if (f45156b) {
                Log.d("ExtCore-PresetConfig", "readPresetConfig end. config: " + jSONObject.toString());
            }
            return jSONObject;
        } catch (JSONException e2) {
            if (f45156b) {
                throw new RuntimeException(e2);
            }
            return null;
        }
    }
}
