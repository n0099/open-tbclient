package d.b.i0.e1.b;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public int f54420a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f54421b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f54422c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f54423d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f54424e = 0;

    public int a() {
        return this.f54420a;
    }

    public int b() {
        return this.f54422c;
    }

    public int c() {
        return this.f54424e;
    }

    public int d() {
        return this.f54423d;
    }

    public int e() {
        return this.f54421b;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f54420a = jSONObject.optInt("agree", 0);
            this.f54421b = jSONObject.optInt("replyme", 0);
            this.f54422c = jSONObject.optInt("atme", 0);
            this.f54423d = jSONObject.optInt("fans", 0);
            jSONObject.optInt("pletter", 0);
            this.f54424e = jSONObject.optInt("bookmark", 0);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
