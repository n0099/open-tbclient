package d.a.l0.n.i;

import android.text.TextUtils;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f48022f = d.a.l0.n.c.f47984a;

    /* renamed from: a  reason: collision with root package name */
    public int f48023a = -1;

    /* renamed from: b  reason: collision with root package name */
    public String f48024b;

    /* renamed from: c  reason: collision with root package name */
    public String f48025c;

    /* renamed from: d  reason: collision with root package name */
    public long f48026d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f48027e;

    public static c a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return b(new JSONObject(str));
        } catch (JSONException e2) {
            if (f48022f) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public static c b(JSONObject jSONObject) {
        c cVar = new c();
        cVar.i(jSONObject.optInt("errno", -1));
        cVar.j(jSONObject.optString("errmsg"));
        cVar.l(jSONObject.optString("tipmsg"));
        cVar.k(jSONObject.optLong(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID));
        cVar.h(jSONObject.optJSONObject("data"));
        return cVar;
    }

    public JSONObject c() {
        return this.f48027e;
    }

    public int d() {
        return this.f48023a;
    }

    public String e() {
        return this.f48024b;
    }

    public long f() {
        return this.f48026d;
    }

    public String g() {
        return this.f48025c;
    }

    public void h(JSONObject jSONObject) {
        this.f48027e = jSONObject;
    }

    public void i(int i2) {
        this.f48023a = i2;
    }

    public void j(String str) {
        this.f48024b = str;
    }

    public void k(long j) {
        this.f48026d = j;
    }

    public void l(String str) {
        this.f48025c = str;
    }
}
