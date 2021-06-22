package d.a.n0.s.c;

import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public String f54286a;

    /* renamed from: b  reason: collision with root package name */
    public String f54287b;

    /* renamed from: c  reason: collision with root package name */
    public String f54288c;

    /* renamed from: d  reason: collision with root package name */
    public String f54289d;

    /* renamed from: e  reason: collision with root package name */
    public int f54290e;

    public String a() {
        return this.f54286a;
    }

    public String b() {
        return this.f54288c;
    }

    public String c() {
        return this.f54287b;
    }

    public String d() {
        return this.f54289d;
    }

    public int e() {
        return this.f54290e;
    }

    public void f(JSONObject jSONObject) {
        this.f54286a = jSONObject.optString("icon");
        this.f54287b = jSONObject.optString(LowFlowsActivityConfig.TAB_CODE);
        this.f54288c = jSONObject.optString("pop_text");
        this.f54289d = jSONObject.optString("thread_id");
        this.f54290e = jSONObject.optInt("version");
    }
}
