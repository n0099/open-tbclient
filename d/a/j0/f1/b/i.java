package d.a.j0.f1.b;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public int f54165a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f54166b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f54167c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f54168d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f54169e = 0;

    public int a() {
        return this.f54165a;
    }

    public int b() {
        return this.f54167c;
    }

    public int c() {
        return this.f54169e;
    }

    public int d() {
        return this.f54168d;
    }

    public int e() {
        return this.f54166b;
    }

    public void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f54165a = jSONObject.optInt("agree", 0);
            this.f54166b = jSONObject.optInt("replyme", 0);
            this.f54167c = jSONObject.optInt("atme", 0);
            this.f54168d = jSONObject.optInt("fans", 0);
            jSONObject.optInt("pletter", 0);
            this.f54169e = jSONObject.optInt("bookmark", 0);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
