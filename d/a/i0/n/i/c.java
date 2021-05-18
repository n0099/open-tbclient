package d.a.i0.n.i;

import android.text.TextUtils;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f47846f = d.a.i0.n.c.f47808a;

    /* renamed from: a  reason: collision with root package name */
    public int f47847a = -1;

    /* renamed from: b  reason: collision with root package name */
    public String f47848b;

    /* renamed from: c  reason: collision with root package name */
    public String f47849c;

    /* renamed from: d  reason: collision with root package name */
    public long f47850d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f47851e;

    public static c a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return b(new JSONObject(str));
        } catch (JSONException e2) {
            if (f47846f) {
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
        return this.f47851e;
    }

    public int d() {
        return this.f47847a;
    }

    public String e() {
        return this.f47848b;
    }

    public long f() {
        return this.f47850d;
    }

    public String g() {
        return this.f47849c;
    }

    public void h(JSONObject jSONObject) {
        this.f47851e = jSONObject;
    }

    public void i(int i2) {
        this.f47847a = i2;
    }

    public void j(String str) {
        this.f47848b = str;
    }

    public void k(long j) {
        this.f47850d = j;
    }

    public void l(String str) {
        this.f47849c = str;
    }
}
