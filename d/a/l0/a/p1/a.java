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
    public static volatile a f44110c;

    /* renamed from: a  reason: collision with root package name */
    public b<SwanAppPageInfo> f44112a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f44109b = k.f43199a;

    /* renamed from: d  reason: collision with root package name */
    public static final String f44111d = d.a.l0.a.c1.a.m().a() + "_";

    public static a a() {
        if (f44110c == null) {
            synchronized (a.class) {
                if (f44110c == null) {
                    f44110c = new a();
                }
            }
        }
        return f44110c;
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
        if (TextUtils.isEmpty(optString) || !optString.startsWith(f44111d)) {
            return;
        }
        d.a.l0.a.f1.e.b b2 = b();
        if (b2 != null) {
            try {
                jSONObject.put("appName", b2.K());
                jSONObject.put("iconUrl", b2.Q());
                jSONObject.put("appDesc", b2.c1());
            } catch (JSONException e2) {
                if (f44109b) {
                    e2.printStackTrace();
                }
            }
        }
        jSONObject.put("type", optString.substring(f44111d.length()));
        b<SwanAppPageInfo> bVar = this.f44112a;
        if (bVar != null) {
            bVar.onCallback(new SwanAppPageInfo(jSONObject));
        }
        if (SwanAppProcessInfo.isSwanAppProcess(ProcessUtils.getCurProcessName())) {
            d();
            Bundle bundle = new Bundle();
            bundle.putString("page_info", jSONObject.toString());
            d.a.l0.a.v1.c.a.e().h(new c(24, bundle));
            if (f44109b) {
                Log.d("SwanAppPageInfoHelper", "postPageInfo: post to main process");
            }
        }
    }

    public final void d() {
        if (this.f44112a != null) {
            this.f44112a = null;
        }
    }
}
