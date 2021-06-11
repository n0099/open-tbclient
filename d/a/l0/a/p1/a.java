package d.a.l0.a.p1;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.page.model.SwanAppPageInfo;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import d.a.l0.a.a2.e;
import d.a.l0.a.k;
import d.a.l0.a.v1.c.c;
import d.a.l0.a.v2.e1.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f47784c;

    /* renamed from: a  reason: collision with root package name */
    public b<SwanAppPageInfo> f47786a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f47783b = k.f46875a;

    /* renamed from: d  reason: collision with root package name */
    public static final String f47785d = d.a.l0.a.c1.a.m().a() + "_";

    public static a a() {
        if (f47784c == null) {
            synchronized (a.class) {
                if (f47784c == null) {
                    f47784c = new a();
                }
            }
        }
        return f47784c;
    }

    public final d.a.l0.a.f1.e.b b() {
        e Q = e.Q();
        if (Q == null || Q.L() == null) {
            return null;
        }
        return Q.L();
    }

    public void c(JSONObject jSONObject) {
        String optString = jSONObject.optString("type");
        if (TextUtils.isEmpty(optString) || !optString.startsWith(f47785d)) {
            return;
        }
        d.a.l0.a.f1.e.b b2 = b();
        if (b2 != null) {
            try {
                jSONObject.put("appName", b2.K());
                jSONObject.put("iconUrl", b2.Q());
                jSONObject.put("appDesc", b2.c1());
            } catch (JSONException e2) {
                if (f47783b) {
                    e2.printStackTrace();
                }
            }
        }
        jSONObject.put("type", optString.substring(f47785d.length()));
        b<SwanAppPageInfo> bVar = this.f47786a;
        if (bVar != null) {
            bVar.onCallback(new SwanAppPageInfo(jSONObject));
        }
        if (SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            d();
            Bundle bundle = new Bundle();
            bundle.putString("page_info", jSONObject.toString());
            d.a.l0.a.v1.c.a.e().h(new c(24, bundle));
            if (f47783b) {
                Log.d("SwanAppPageInfoHelper", "postPageInfo: post to main process");
            }
        }
    }

    public final void d() {
        if (this.f47786a != null) {
            this.f47786a = null;
        }
    }
}
