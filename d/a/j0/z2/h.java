package d.a.j0.z2;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public int f63013a;

    /* renamed from: b  reason: collision with root package name */
    public String f63014b;

    /* renamed from: c  reason: collision with root package name */
    public int f63015c;

    /* renamed from: d  reason: collision with root package name */
    public String f63016d;

    /* renamed from: e  reason: collision with root package name */
    public int f63017e;

    /* renamed from: f  reason: collision with root package name */
    public String f63018f;

    /* renamed from: g  reason: collision with root package name */
    public a f63019g = new a();

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<i> f63020h = new ArrayList<>();

    public int a() {
        return this.f63017e;
    }

    public a b() {
        return this.f63019g;
    }

    public String c() {
        return this.f63018f;
    }

    public ArrayList<i> d() {
        return this.f63020h;
    }

    public int e() {
        return this.f63015c;
    }

    public String f() {
        return this.f63014b;
    }

    public String g() {
        return this.f63016d;
    }

    public int h() {
        return this.f63013a;
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
            this.f63019g.c(jSONObject.optJSONObject("error"));
            this.f63013a = jSONObject.optInt("show_dialog");
            this.f63014b = jSONObject.optString("sign_notice");
            this.f63015c = jSONObject.optInt("is_timeout");
            this.f63016d = jSONObject.optString("timeout_notice");
            this.f63017e = jSONObject.optInt("error_code");
            this.f63018f = jSONObject.optString("error_msg");
            JSONArray optJSONArray = jSONObject.optJSONArray("info");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    i iVar = new i();
                    iVar.f(jSONObject2);
                    this.f63020h.add(iVar);
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
