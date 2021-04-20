package d.b.i0.f1.b;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public int f55862a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f55863b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f55864c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f55865d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f55866e = 0;

    public int a() {
        return this.f55862a;
    }

    public int b() {
        return this.f55864c;
    }

    public int c() {
        return this.f55866e;
    }

    public int d() {
        return this.f55865d;
    }

    public int e() {
        return this.f55863b;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f55862a = jSONObject.optInt("agree", 0);
            this.f55863b = jSONObject.optInt("replyme", 0);
            this.f55864c = jSONObject.optInt("atme", 0);
            this.f55865d = jSONObject.optInt("fans", 0);
            jSONObject.optInt("pletter", 0);
            this.f55866e = jSONObject.optInt("bookmark", 0);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
