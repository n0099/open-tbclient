package d.b.i0.e1.b;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public int f54421a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f54422b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f54423c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f54424d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f54425e = 0;

    public int a() {
        return this.f54421a;
    }

    public int b() {
        return this.f54423c;
    }

    public int c() {
        return this.f54425e;
    }

    public int d() {
        return this.f54424d;
    }

    public int e() {
        return this.f54422b;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f54421a = jSONObject.optInt("agree", 0);
            this.f54422b = jSONObject.optInt("replyme", 0);
            this.f54423c = jSONObject.optInt("atme", 0);
            this.f54424d = jSONObject.optInt("fans", 0);
            jSONObject.optInt("pletter", 0);
            this.f54425e = jSONObject.optInt("bookmark", 0);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
