package d.b.h0.l.l;

import android.text.TextUtils;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f49648e = d.b.h0.l.f.f49610a;

    /* renamed from: a  reason: collision with root package name */
    public int f49649a = -1;

    /* renamed from: b  reason: collision with root package name */
    public String f49650b;

    /* renamed from: c  reason: collision with root package name */
    public String f49651c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f49652d;

    public static c a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return b(new JSONObject(str));
        } catch (JSONException e2) {
            if (f49648e) {
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
        return this.f49652d;
    }

    public int d() {
        return this.f49649a;
    }

    public String e() {
        return this.f49650b;
    }

    public String f() {
        return this.f49651c;
    }

    public void g(JSONObject jSONObject) {
        this.f49652d = jSONObject;
    }

    public void h(int i) {
        this.f49649a = i;
    }

    public void i(String str) {
        this.f49650b = str;
    }

    public void j(long j) {
    }

    public void k(String str) {
        this.f49651c = str;
    }
}
