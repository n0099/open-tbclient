package d.b.i0.y2;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public int f62641a;

    /* renamed from: b  reason: collision with root package name */
    public String f62642b;

    /* renamed from: c  reason: collision with root package name */
    public int f62643c;

    /* renamed from: d  reason: collision with root package name */
    public String f62644d;

    /* renamed from: e  reason: collision with root package name */
    public int f62645e;

    /* renamed from: f  reason: collision with root package name */
    public String f62646f;

    /* renamed from: g  reason: collision with root package name */
    public a f62647g = new a();

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<i> f62648h = new ArrayList<>();

    public int a() {
        return this.f62645e;
    }

    public a b() {
        return this.f62647g;
    }

    public String c() {
        return this.f62646f;
    }

    public ArrayList<i> d() {
        return this.f62648h;
    }

    public int e() {
        return this.f62643c;
    }

    public String f() {
        return this.f62642b;
    }

    public String g() {
        return this.f62644d;
    }

    public int h() {
        return this.f62641a;
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
            this.f62647g.c(jSONObject.optJSONObject("error"));
            this.f62641a = jSONObject.optInt("show_dialog");
            this.f62642b = jSONObject.optString("sign_notice");
            this.f62643c = jSONObject.optInt("is_timeout");
            this.f62644d = jSONObject.optString("timeout_notice");
            this.f62645e = jSONObject.optInt("error_code");
            this.f62646f = jSONObject.optString("error_msg");
            JSONArray optJSONArray = jSONObject.optJSONArray("info");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    i iVar = new i();
                    iVar.f(jSONObject2);
                    this.f62648h.add(iVar);
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
