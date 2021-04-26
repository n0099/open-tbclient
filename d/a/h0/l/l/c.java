package d.a.h0.l.l;

import android.text.TextUtils;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47158e = d.a.h0.l.f.f47117a;

    /* renamed from: a  reason: collision with root package name */
    public int f47159a = -1;

    /* renamed from: b  reason: collision with root package name */
    public String f47160b;

    /* renamed from: c  reason: collision with root package name */
    public String f47161c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f47162d;

    public static c a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return b(new JSONObject(str));
        } catch (JSONException e2) {
            if (f47158e) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public static c b(JSONObject jSONObject) {
        c cVar = new c();
        cVar.h(jSONObject.optInt("errno", -1));
        cVar.i(jSONObject.optString("errmsg"));
        cVar.k(jSONObject.optString("tipmsg"));
        cVar.j(jSONObject.optLong(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID));
        cVar.g(jSONObject.optJSONObject("data"));
        return cVar;
    }

    public JSONObject c() {
        return this.f47162d;
    }

    public int d() {
        return this.f47159a;
    }

    public String e() {
        return this.f47160b;
    }

    public String f() {
        return this.f47161c;
    }

    public void g(JSONObject jSONObject) {
        this.f47162d = jSONObject;
    }

    public void h(int i2) {
        this.f47159a = i2;
    }

    public void i(String str) {
        this.f47160b = str;
    }

    public void j(long j) {
    }

    public void k(String str) {
        this.f47161c = str;
    }
}
