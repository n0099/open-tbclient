package d.a.m0.n.i;

import android.text.TextUtils;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f51804f = d.a.m0.n.c.f51766a;

    /* renamed from: a  reason: collision with root package name */
    public int f51805a = -1;

    /* renamed from: b  reason: collision with root package name */
    public String f51806b;

    /* renamed from: c  reason: collision with root package name */
    public String f51807c;

    /* renamed from: d  reason: collision with root package name */
    public long f51808d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f51809e;

    public static c a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return b(new JSONObject(str));
        } catch (JSONException e2) {
            if (f51804f) {
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
        return this.f51809e;
    }

    public int d() {
        return this.f51805a;
    }

    public String e() {
        return this.f51806b;
    }

    public long f() {
        return this.f51808d;
    }

    public String g() {
        return this.f51807c;
    }

    public void h(JSONObject jSONObject) {
        this.f51809e = jSONObject;
    }

    public void i(int i2) {
        this.f51805a = i2;
    }

    public void j(String str) {
        this.f51806b = str;
    }

    public void k(long j) {
        this.f51808d = j;
    }

    public void l(String str) {
        this.f51807c = str;
    }
}
