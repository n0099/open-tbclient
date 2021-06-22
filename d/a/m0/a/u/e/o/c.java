package d.a.m0.a.u.e.o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.m0.a.v2.q0;
import d.a.m0.a.v2.r0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends d.a.m0.a.u.c.d {

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f48937e;

        public a(c cVar, Context context) {
            this.f48937e = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a.m0.a.z1.b.f.e.d()) {
                return;
            }
            d.a.m0.a.z1.b.f.e.f(this.f48937e, d.a.m0.a.h.clipboardapi_tip_content).F();
        }
    }

    public c(@NonNull d.a.m0.a.u.c.b bVar) {
        super(bVar);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public d.a.m0.a.u.h.b r() {
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-ClipboardApi", "start get clipboard data");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            CharSequence a2 = r0.b(i()).a();
            jSONObject.put("data", TextUtils.isEmpty(a2) ? "" : a2.toString());
            if (d.a.m0.a.u.c.d.f48594c) {
                Log.i("Api-ClipboardApi", "getClipboardData:  " + jSONObject);
            }
            return new d.a.m0.a.u.h.b(0, jSONObject);
        } catch (JSONException e2) {
            if (d.a.m0.a.u.c.d.f48594c) {
                e2.printStackTrace();
            }
            return new d.a.m0.a.u.h.b(1001, "JSONException");
        }
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public d.a.m0.a.u.h.b s(String str) {
        SwanAppActivity x;
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-ClipboardApi", "start set clipboard data");
        }
        Pair<d.a.m0.a.u.h.b, JSONObject> b2 = d.a.m0.a.u.i.b.b("Api-ClipboardApi", str);
        d.a.m0.a.u.h.b bVar = (d.a.m0.a.u.h.b) b2.first;
        if (!bVar.isSuccess()) {
            if (d.a.m0.a.u.c.d.f48594c) {
                d.a.m0.a.e0.d.b("Api-ClipboardApi", "parse fail");
            }
            return bVar;
        }
        r0.b(i()).c(((JSONObject) b2.second).optString("data"));
        d.a.m0.a.a2.e r = d.a.m0.a.a2.d.g().r();
        if (r != null && (x = r.x()) != null) {
            q0.c0(new a(this, x), 200L);
        }
        return new d.a.m0.a.u.h.b(0);
    }
}
