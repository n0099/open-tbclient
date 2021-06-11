package d.a.n0.g1.b;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public int f58749a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f58750b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f58751c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f58752d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f58753e = 0;

    public int a() {
        return this.f58749a;
    }

    public int b() {
        return this.f58751c;
    }

    public int c() {
        return this.f58753e;
    }

    public int d() {
        return this.f58752d;
    }

    public int e() {
        return this.f58750b;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f58749a = jSONObject.optInt("agree", 0);
            this.f58750b = jSONObject.optInt("replyme", 0);
            this.f58751c = jSONObject.optInt("atme", 0);
            this.f58752d = jSONObject.optInt("fans", 0);
            jSONObject.optInt("pletter", 0);
            this.f58753e = jSONObject.optInt("bookmark", 0);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
