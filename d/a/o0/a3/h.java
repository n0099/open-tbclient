package d.a.o0.a3;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public int f55030a;

    /* renamed from: b  reason: collision with root package name */
    public String f55031b;

    /* renamed from: c  reason: collision with root package name */
    public int f55032c;

    /* renamed from: d  reason: collision with root package name */
    public String f55033d;

    /* renamed from: e  reason: collision with root package name */
    public int f55034e;

    /* renamed from: f  reason: collision with root package name */
    public String f55035f;

    /* renamed from: g  reason: collision with root package name */
    public a f55036g = new a();

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<i> f55037h = new ArrayList<>();

    public int a() {
        return this.f55034e;
    }

    public a b() {
        return this.f55036g;
    }

    public String c() {
        return this.f55035f;
    }

    public ArrayList<i> d() {
        return this.f55037h;
    }

    public int e() {
        return this.f55032c;
    }

    public String f() {
        return this.f55031b;
    }

    public String g() {
        return this.f55033d;
    }

    public int h() {
        return this.f55030a;
    }

    public void i(String str) {
        if (str == null) {
            return;
        }
        try {
            j(new JSONObject(str));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f55036g.c(jSONObject.optJSONObject("error"));
            this.f55030a = jSONObject.optInt("show_dialog");
            this.f55031b = jSONObject.optString("sign_notice");
            this.f55032c = jSONObject.optInt("is_timeout");
            this.f55033d = jSONObject.optString("timeout_notice");
            this.f55034e = jSONObject.optInt("error_code");
            this.f55035f = jSONObject.optString("error_msg");
            JSONArray optJSONArray = jSONObject.optJSONArray("info");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    i iVar = new i();
                    iVar.f(jSONObject2);
                    this.f55037h.add(iVar);
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
