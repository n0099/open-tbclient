package d.a.l0.n.i;

import android.text.TextUtils;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f51696f = d.a.l0.n.c.f51658a;

    /* renamed from: a  reason: collision with root package name */
    public int f51697a = -1;

    /* renamed from: b  reason: collision with root package name */
    public String f51698b;

    /* renamed from: c  reason: collision with root package name */
    public String f51699c;

    /* renamed from: d  reason: collision with root package name */
    public long f51700d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f51701e;

    public static c a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return b(new JSONObject(str));
        } catch (JSONException e2) {
            if (f51696f) {
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
        return this.f51701e;
    }

    public int d() {
        return this.f51697a;
    }

    public String e() {
        return this.f51698b;
    }

    public long f() {
        return this.f51700d;
    }

    public String g() {
        return this.f51699c;
    }

    public void h(JSONObject jSONObject) {
        this.f51701e = jSONObject;
    }

    public void i(int i2) {
        this.f51697a = i2;
    }

    public void j(String str) {
        this.f51698b = str;
    }

    public void k(long j) {
        this.f51700d = j;
    }

    public void l(String str) {
        this.f51699c = str;
    }
}
