package d.a.n0.a3;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public int f51228a;

    /* renamed from: b  reason: collision with root package name */
    public String f51229b;

    /* renamed from: c  reason: collision with root package name */
    public int f51230c;

    /* renamed from: d  reason: collision with root package name */
    public String f51231d;

    /* renamed from: e  reason: collision with root package name */
    public int f51232e;

    /* renamed from: f  reason: collision with root package name */
    public String f51233f;

    /* renamed from: g  reason: collision with root package name */
    public a f51234g = new a();

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<i> f51235h = new ArrayList<>();

    public int a() {
        return this.f51232e;
    }

    public a b() {
        return this.f51234g;
    }

    public String c() {
        return this.f51233f;
    }

    public ArrayList<i> d() {
        return this.f51235h;
    }

    public int e() {
        return this.f51230c;
    }

    public String f() {
        return this.f51229b;
    }

    public String g() {
        return this.f51231d;
    }

    public int h() {
        return this.f51228a;
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
            this.f51234g.c(jSONObject.optJSONObject("error"));
            this.f51228a = jSONObject.optInt("show_dialog");
            this.f51229b = jSONObject.optString("sign_notice");
            this.f51230c = jSONObject.optInt("is_timeout");
            this.f51231d = jSONObject.optString("timeout_notice");
            this.f51232e = jSONObject.optInt("error_code");
            this.f51233f = jSONObject.optString("error_msg");
            JSONArray optJSONArray = jSONObject.optJSONArray("info");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    i iVar = new i();
                    iVar.f(jSONObject2);
                    this.f51235h.add(iVar);
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
