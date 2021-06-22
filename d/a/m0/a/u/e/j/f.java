package d.a.m0.a.u.e.j;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends d.a.m0.a.u.c.d {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f48828e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48829f;

        public a(d.a.m0.a.a2.e eVar, String str) {
            this.f48828e = eVar;
            this.f48829f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f48828e.P().b(f.this.a().h(), this.f48829f);
        }
    }

    public f(@NonNull d.a.m0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.m0.a.u.h.b r() {
        String e2 = SwanAppNetworkUtils.e();
        if (TextUtils.isEmpty(e2)) {
            e2 = "unknown";
        } else if ("no".equals(e2)) {
            e2 = "none";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("networkType", e2);
            if (d.a.m0.a.u.c.d.f48594c) {
                Log.i("Api-Network", "getNetworkType:  " + jSONObject);
            }
            return new d.a.m0.a.u.h.b(0, jSONObject);
        } catch (JSONException e3) {
            if (d.a.m0.a.u.c.d.f48594c) {
                e3.printStackTrace();
            }
            return new d.a.m0.a.u.h.b(202);
        }
    }

    public d.a.m0.a.u.h.b s(String str) {
        d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
        if (i2 == null) {
            if (d.a.m0.a.u.c.d.f48594c) {
                d.a.m0.a.e0.d.b("Api-Network", "swan app is null");
            }
            return new d.a.m0.a.u.h.b(202, "swan app is null");
        }
        Pair<d.a.m0.a.u.h.b, JSONObject> b2 = d.a.m0.a.u.i.b.b("Api-Network", str);
        d.a.m0.a.u.h.b bVar = (d.a.m0.a.u.h.b) b2.first;
        if (!bVar.isSuccess()) {
            if (d.a.m0.a.u.c.d.f48594c) {
                d.a.m0.a.e0.d.b("Api-Network", "parse fail");
            }
            return bVar;
        }
        String optString = ((JSONObject) b2.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            if (d.a.m0.a.u.c.d.f48594c) {
                d.a.m0.a.e0.d.b("Api-Network", "callback is null");
            }
            return new d.a.m0.a.u.h.b(1001, "callback is null");
        }
        d.a.m0.a.a2.d.i().post(new a(i2, optString));
        return new d.a.m0.a.u.h.b(0);
    }
}
