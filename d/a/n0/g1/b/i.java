package d.a.n0.g1.b;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public int f55060a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f55061b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f55062c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f55063d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f55064e = 0;

    public int a() {
        return this.f55060a;
    }

    public int b() {
        return this.f55062c;
    }

    public int c() {
        return this.f55064e;
    }

    public int d() {
        return this.f55063d;
    }

    public int e() {
        return this.f55061b;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f55060a = jSONObject.optInt("agree", 0);
            this.f55061b = jSONObject.optInt("replyme", 0);
            this.f55062c = jSONObject.optInt("atme", 0);
            this.f55063d = jSONObject.optInt("fans", 0);
            jSONObject.optInt("pletter", 0);
            this.f55064e = jSONObject.optInt("bookmark", 0);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
