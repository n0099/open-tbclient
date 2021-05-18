package d.a.k0.f1.b;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public int f54872a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f54873b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f54874c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f54875d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f54876e = 0;

    public int a() {
        return this.f54872a;
    }

    public int b() {
        return this.f54874c;
    }

    public int c() {
        return this.f54876e;
    }

    public int d() {
        return this.f54875d;
    }

    public int e() {
        return this.f54873b;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f54872a = jSONObject.optInt("agree", 0);
            this.f54873b = jSONObject.optInt("replyme", 0);
            this.f54874c = jSONObject.optInt("atme", 0);
            this.f54875d = jSONObject.optInt("fans", 0);
            jSONObject.optInt("pletter", 0);
            this.f54876e = jSONObject.optInt("bookmark", 0);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
