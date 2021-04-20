package d.b.g0.l.l;

import android.text.TextUtils;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f49319e = d.b.g0.l.f.f49281a;

    /* renamed from: a  reason: collision with root package name */
    public int f49320a = -1;

    /* renamed from: b  reason: collision with root package name */
    public String f49321b;

    /* renamed from: c  reason: collision with root package name */
    public String f49322c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f49323d;

    public static c a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return b(new JSONObject(str));
        } catch (JSONException e2) {
            if (f49319e) {
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
        return this.f49323d;
    }

    public int d() {
        return this.f49320a;
    }

    public String e() {
        return this.f49321b;
    }

    public String f() {
        return this.f49322c;
    }

    public void g(JSONObject jSONObject) {
        this.f49323d = jSONObject;
    }

    public void h(int i) {
        this.f49320a = i;
    }

    public void i(String str) {
        this.f49321b = str;
    }

    public void j(long j) {
    }

    public void k(String str) {
        this.f49322c = str;
    }
}
