package d.a.k0.z2;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public int f63737a;

    /* renamed from: b  reason: collision with root package name */
    public String f63738b;

    /* renamed from: c  reason: collision with root package name */
    public int f63739c;

    /* renamed from: d  reason: collision with root package name */
    public String f63740d;

    /* renamed from: e  reason: collision with root package name */
    public int f63741e;

    /* renamed from: f  reason: collision with root package name */
    public String f63742f;

    /* renamed from: g  reason: collision with root package name */
    public a f63743g = new a();

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<i> f63744h = new ArrayList<>();

    public int a() {
        return this.f63741e;
    }

    public a b() {
        return this.f63743g;
    }

    public String c() {
        return this.f63742f;
    }

    public ArrayList<i> d() {
        return this.f63744h;
    }

    public int e() {
        return this.f63739c;
    }

    public String f() {
        return this.f63738b;
    }

    public String g() {
        return this.f63740d;
    }

    public int h() {
        return this.f63737a;
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
            this.f63743g.c(jSONObject.optJSONObject("error"));
            this.f63737a = jSONObject.optInt("show_dialog");
            this.f63738b = jSONObject.optString("sign_notice");
            this.f63739c = jSONObject.optInt("is_timeout");
            this.f63740d = jSONObject.optString("timeout_notice");
            this.f63741e = jSONObject.optInt("error_code");
            this.f63742f = jSONObject.optString("error_msg");
            JSONArray optJSONArray = jSONObject.optJSONArray("info");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    i iVar = new i();
                    iVar.f(jSONObject2);
                    this.f63744h.add(iVar);
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
