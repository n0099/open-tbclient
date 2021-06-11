package d.a.n0.a3;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public int f54905a;

    /* renamed from: b  reason: collision with root package name */
    public String f54906b;

    /* renamed from: c  reason: collision with root package name */
    public int f54907c;

    /* renamed from: d  reason: collision with root package name */
    public String f54908d;

    /* renamed from: e  reason: collision with root package name */
    public int f54909e;

    /* renamed from: f  reason: collision with root package name */
    public String f54910f;

    /* renamed from: g  reason: collision with root package name */
    public a f54911g = new a();

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<i> f54912h = new ArrayList<>();

    public int a() {
        return this.f54909e;
    }

    public a b() {
        return this.f54911g;
    }

    public String c() {
        return this.f54910f;
    }

    public ArrayList<i> d() {
        return this.f54912h;
    }

    public int e() {
        return this.f54907c;
    }

    public String f() {
        return this.f54906b;
    }

    public String g() {
        return this.f54908d;
    }

    public int h() {
        return this.f54905a;
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
            this.f54911g.c(jSONObject.optJSONObject("error"));
            this.f54905a = jSONObject.optInt("show_dialog");
            this.f54906b = jSONObject.optString("sign_notice");
            this.f54907c = jSONObject.optInt("is_timeout");
            this.f54908d = jSONObject.optString("timeout_notice");
            this.f54909e = jSONObject.optInt("error_code");
            this.f54910f = jSONObject.optString("error_msg");
            JSONArray optJSONArray = jSONObject.optJSONArray("info");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    i iVar = new i();
                    iVar.f(jSONObject2);
                    this.f54912h.add(iVar);
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
