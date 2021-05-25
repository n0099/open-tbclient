package d.a.l0.g.c.c;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.l0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends d.a.l0.g.f.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f46998c = k.f43199a;

    public f() {
        super("openApp");
    }

    @Override // d.a.l0.g.f.a
    public d.a.l0.a.u.h.b a(@NonNull JSONObject jSONObject, @NonNull d.a.l0.a.u0.b bVar) {
        if (f46998c) {
            Log.d("GameCenterOpenAppAction", "handle: " + jSONObject);
        }
        String optString = jSONObject.optString("packageName");
        if (TextUtils.isEmpty(optString)) {
            bVar.onFail(31010, "package name is empty");
            return null;
        }
        d.a.l0.g.c.i.c.a(optString, "openApp", null, null, null);
        if (!d.a.l0.g.c.e.a.h(AppRuntime.getAppContext(), optString)) {
            bVar.onFail(31011, "app is not installed");
            d.a.l0.g.c.i.c.a(optString, "openApp", "fail", String.valueOf(31011), null);
            return null;
        }
        if (d.a.l0.g.c.e.a.l(AppRuntime.getAppContext(), optString)) {
            bVar.b(null);
            d.a.l0.g.c.i.c.a(optString, "openApp", "success", null, null);
        } else {
            bVar.onFail(31019, "open app fail");
            d.a.l0.g.c.i.c.a(optString, "openApp", "fail", String.valueOf(31019), null);
        }
        return null;
    }
}
