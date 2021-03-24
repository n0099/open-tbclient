package d.b.g0.a.t.c.h;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import d.b.g0.a.r1.e;
import d.b.g0.a.t.b.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d {

    /* renamed from: d.b.g0.a.t.c.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0815a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f46081e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46082f;

        public RunnableC0815a(e eVar, String str) {
            this.f46081e = eVar;
            this.f46082f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f46081e.N().b(a.this.a().h(), this.f46082f);
        }
    }

    public a(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public d.b.g0.a.t.e.b q() {
        String e2 = SwanAppNetworkUtils.e();
        if (TextUtils.isEmpty(e2)) {
            e2 = "unknown";
        } else if ("no".equals(e2)) {
            e2 = "none";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("networkType", e2);
            if (d.f45928c) {
                Log.i("Api-Network", "getNetworkType:  " + jSONObject);
            }
            return new d.b.g0.a.t.e.b(0, jSONObject);
        } catch (JSONException e3) {
            if (d.f45928c) {
                e3.printStackTrace();
            }
            return new d.b.g0.a.t.e.b(202);
        }
    }

    public d.b.g0.a.t.e.b r(String str) {
        e y = e.y();
        if (y == null) {
            if (d.f45928c) {
                d.b.g0.a.c0.c.b("Api-Network", "swan app is null");
            }
            return new d.b.g0.a.t.e.b(202, "swan app is null");
        }
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-Network", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.f45928c) {
                d.b.g0.a.c0.c.b("Api-Network", "parse fail");
            }
            return bVar;
        }
        String optString = ((JSONObject) a2.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            if (d.f45928c) {
                d.b.g0.a.c0.c.b("Api-Network", "callback is null");
            }
            return new d.b.g0.a.t.e.b(1001, "callback is null");
        }
        d.b.g0.a.r1.d.g().post(new RunnableC0815a(y, optString));
        return new d.b.g0.a.t.e.b(0);
    }
}
