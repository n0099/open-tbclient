package d.a.i0.a.u.e.j;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends d.a.i0.a.u.c.d {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f44870e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44871f;

        public a(d.a.i0.a.a2.e eVar, String str) {
            this.f44870e = eVar;
            this.f44871f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f44870e.P().b(f.this.a().h(), this.f44871f);
        }
    }

    public f(@NonNull d.a.i0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.i0.a.u.h.b r() {
        String e2 = SwanAppNetworkUtils.e();
        if (TextUtils.isEmpty(e2)) {
            e2 = "unknown";
        } else if ("no".equals(e2)) {
            e2 = "none";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("networkType", e2);
            if (d.a.i0.a.u.c.d.f44636c) {
                Log.i("Api-Network", "getNetworkType:  " + jSONObject);
            }
            return new d.a.i0.a.u.h.b(0, jSONObject);
        } catch (JSONException e3) {
            if (d.a.i0.a.u.c.d.f44636c) {
                e3.printStackTrace();
            }
            return new d.a.i0.a.u.h.b(202);
        }
    }

    public d.a.i0.a.u.h.b s(String str) {
        d.a.i0.a.a2.e i2 = d.a.i0.a.a2.e.i();
        if (i2 == null) {
            if (d.a.i0.a.u.c.d.f44636c) {
                d.a.i0.a.e0.d.b("Api-Network", "swan app is null");
            }
            return new d.a.i0.a.u.h.b(202, "swan app is null");
        }
        Pair<d.a.i0.a.u.h.b, JSONObject> b2 = d.a.i0.a.u.i.b.b("Api-Network", str);
        d.a.i0.a.u.h.b bVar = (d.a.i0.a.u.h.b) b2.first;
        if (!bVar.a()) {
            if (d.a.i0.a.u.c.d.f44636c) {
                d.a.i0.a.e0.d.b("Api-Network", "parse fail");
            }
            return bVar;
        }
        String optString = ((JSONObject) b2.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            if (d.a.i0.a.u.c.d.f44636c) {
                d.a.i0.a.e0.d.b("Api-Network", "callback is null");
            }
            return new d.a.i0.a.u.h.b(1001, "callback is null");
        }
        d.a.i0.a.a2.d.i().post(new a(i2, optString));
        return new d.a.i0.a.u.h.b(0);
    }
}
