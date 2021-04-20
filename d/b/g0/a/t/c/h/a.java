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
/* loaded from: classes2.dex */
public class a extends d {

    /* renamed from: d.b.g0.a.t.c.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0828a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f46474e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46475f;

        public RunnableC0828a(e eVar, String str) {
            this.f46474e = eVar;
            this.f46475f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f46474e.N().b(a.this.a().h(), this.f46475f);
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
            if (d.f46321c) {
                Log.i("Api-Network", "getNetworkType:  " + jSONObject);
            }
            return new d.b.g0.a.t.e.b(0, jSONObject);
        } catch (JSONException e3) {
            if (d.f46321c) {
                e3.printStackTrace();
            }
            return new d.b.g0.a.t.e.b(202);
        }
    }

    public d.b.g0.a.t.e.b r(String str) {
        e y = e.y();
        if (y == null) {
            if (d.f46321c) {
                d.b.g0.a.c0.c.b("Api-Network", "swan app is null");
            }
            return new d.b.g0.a.t.e.b(202, "swan app is null");
        }
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-Network", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.f46321c) {
                d.b.g0.a.c0.c.b("Api-Network", "parse fail");
            }
            return bVar;
        }
        String optString = ((JSONObject) a2.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            if (d.f46321c) {
                d.b.g0.a.c0.c.b("Api-Network", "callback is null");
            }
            return new d.b.g0.a.t.e.b(1001, "callback is null");
        }
        d.b.g0.a.r1.d.g().post(new RunnableC0828a(y, optString));
        return new d.b.g0.a.t.e.b(0);
    }
}
