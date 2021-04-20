package d.b.g0.f.f.c;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.g0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends d.b.g0.f.i.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f48170c = k.f45443a;

    public e() {
        super("openApp");
    }

    @Override // d.b.g0.f.i.a
    public d.b.g0.a.t.e.b a(@NonNull JSONObject jSONObject, @NonNull d.b.g0.a.p0.b bVar) {
        if (f48170c) {
            Log.d("GameCenterOpenAppAction", "handle: " + jSONObject);
        }
        String optString = jSONObject.optString("packageName");
        if (TextUtils.isEmpty(optString)) {
            bVar.onFail(31010, "package name is empty");
            return null;
        }
        d.b.g0.f.f.h.c.a(optString, "openApp", null, null, null);
        if (!d.b.g0.f.f.e.a.g(AppRuntime.getAppContext(), optString)) {
            bVar.onFail(31011, "app is not installed");
            d.b.g0.f.f.h.c.a(optString, "openApp", "fail", String.valueOf(31011), null);
            return null;
        }
        if (d.b.g0.f.f.e.a.l(AppRuntime.getAppContext(), optString)) {
            bVar.a(null);
            d.b.g0.f.f.h.c.a(optString, "openApp", "success", null, null);
        } else {
            bVar.onFail(31019, "open app fail");
            d.b.g0.f.f.h.c.a(optString, "openApp", "fail", String.valueOf(31019), null);
        }
        return null;
    }
}
