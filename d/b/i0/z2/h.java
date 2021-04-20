package d.b.i0.z2;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public int f64303a;

    /* renamed from: b  reason: collision with root package name */
    public String f64304b;

    /* renamed from: c  reason: collision with root package name */
    public int f64305c;

    /* renamed from: d  reason: collision with root package name */
    public String f64306d;

    /* renamed from: e  reason: collision with root package name */
    public int f64307e;

    /* renamed from: f  reason: collision with root package name */
    public String f64308f;

    /* renamed from: g  reason: collision with root package name */
    public a f64309g = new a();

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<i> f64310h = new ArrayList<>();

    public int a() {
        return this.f64307e;
    }

    public a b() {
        return this.f64309g;
    }

    public String c() {
        return this.f64308f;
    }

    public ArrayList<i> d() {
        return this.f64310h;
    }

    public int e() {
        return this.f64305c;
    }

    public String f() {
        return this.f64304b;
    }

    public String g() {
        return this.f64306d;
    }

    public int h() {
        return this.f64303a;
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
            this.f64309g.c(jSONObject.optJSONObject("error"));
            this.f64303a = jSONObject.optInt("show_dialog");
            this.f64304b = jSONObject.optString("sign_notice");
            this.f64305c = jSONObject.optInt("is_timeout");
            this.f64306d = jSONObject.optString("timeout_notice");
            this.f64307e = jSONObject.optInt("error_code");
            this.f64308f = jSONObject.optString("error_msg");
            JSONArray optJSONArray = jSONObject.optJSONArray("info");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    i iVar = new i();
                    iVar.f(jSONObject2);
                    this.f64310h.add(iVar);
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
