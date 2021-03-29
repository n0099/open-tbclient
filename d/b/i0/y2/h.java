package d.b.i0.y2;

import com.baidu.adp.lib.util.BdLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public int f62642a;

    /* renamed from: b  reason: collision with root package name */
    public String f62643b;

    /* renamed from: c  reason: collision with root package name */
    public int f62644c;

    /* renamed from: d  reason: collision with root package name */
    public String f62645d;

    /* renamed from: e  reason: collision with root package name */
    public int f62646e;

    /* renamed from: f  reason: collision with root package name */
    public String f62647f;

    /* renamed from: g  reason: collision with root package name */
    public a f62648g = new a();

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<i> f62649h = new ArrayList<>();

    public int a() {
        return this.f62646e;
    }

    public a b() {
        return this.f62648g;
    }

    public String c() {
        return this.f62647f;
    }

    public ArrayList<i> d() {
        return this.f62649h;
    }

    public int e() {
        return this.f62644c;
    }

    public String f() {
        return this.f62643b;
    }

    public String g() {
        return this.f62645d;
    }

    public int h() {
        return this.f62642a;
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
            this.f62648g.c(jSONObject.optJSONObject("error"));
            this.f62642a = jSONObject.optInt("show_dialog");
            this.f62643b = jSONObject.optString("sign_notice");
            this.f62644c = jSONObject.optInt("is_timeout");
            this.f62645d = jSONObject.optString("timeout_notice");
            this.f62646e = jSONObject.optInt("error_code");
            this.f62647f = jSONObject.optString("error_msg");
            JSONArray optJSONArray = jSONObject.optJSONArray("info");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    i iVar = new i();
                    iVar.f(jSONObject2);
                    this.f62649h.add(iVar);
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
