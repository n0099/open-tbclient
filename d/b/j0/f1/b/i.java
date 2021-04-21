package d.b.j0.f1.b;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public int f56283a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f56284b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f56285c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f56286d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f56287e = 0;

    public int a() {
        return this.f56283a;
    }

    public int b() {
        return this.f56285c;
    }

    public int c() {
        return this.f56287e;
    }

    public int d() {
        return this.f56286d;
    }

    public int e() {
        return this.f56284b;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f56283a = jSONObject.optInt("agree", 0);
            this.f56284b = jSONObject.optInt("replyme", 0);
            this.f56285c = jSONObject.optInt("atme", 0);
            this.f56286d = jSONObject.optInt("fans", 0);
            jSONObject.optInt("pletter", 0);
            this.f56287e = jSONObject.optInt("bookmark", 0);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
