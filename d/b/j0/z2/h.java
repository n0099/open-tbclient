package d.b.j0.z2;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public int f64724a;

    /* renamed from: b  reason: collision with root package name */
    public String f64725b;

    /* renamed from: c  reason: collision with root package name */
    public int f64726c;

    /* renamed from: d  reason: collision with root package name */
    public String f64727d;

    /* renamed from: e  reason: collision with root package name */
    public int f64728e;

    /* renamed from: f  reason: collision with root package name */
    public String f64729f;

    /* renamed from: g  reason: collision with root package name */
    public a f64730g = new a();

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<i> f64731h = new ArrayList<>();

    public int a() {
        return this.f64728e;
    }

    public a b() {
        return this.f64730g;
    }

    public String c() {
        return this.f64729f;
    }

    public ArrayList<i> d() {
        return this.f64731h;
    }

    public int e() {
        return this.f64726c;
    }

    public String f() {
        return this.f64725b;
    }

    public String g() {
        return this.f64727d;
    }

    public int h() {
        return this.f64724a;
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
            this.f64730g.c(jSONObject.optJSONObject("error"));
            this.f64724a = jSONObject.optInt("show_dialog");
            this.f64725b = jSONObject.optString("sign_notice");
            this.f64726c = jSONObject.optInt("is_timeout");
            this.f64727d = jSONObject.optString("timeout_notice");
            this.f64728e = jSONObject.optInt("error_code");
            this.f64729f = jSONObject.optString("error_msg");
            JSONArray optJSONArray = jSONObject.optJSONArray("info");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    i iVar = new i();
                    iVar.f(jSONObject2);
                    this.f64731h.add(iVar);
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
