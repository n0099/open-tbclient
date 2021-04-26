package d.a.i0.s.c;

import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public String f49617a;

    /* renamed from: b  reason: collision with root package name */
    public String f49618b;

    /* renamed from: c  reason: collision with root package name */
    public String f49619c;

    /* renamed from: d  reason: collision with root package name */
    public String f49620d;

    /* renamed from: e  reason: collision with root package name */
    public int f49621e;

    public String a() {
        return this.f49617a;
    }

    public String b() {
        return this.f49619c;
    }

    public String c() {
        return this.f49618b;
    }

    public String d() {
        return this.f49620d;
    }

    public int e() {
        return this.f49621e;
    }

    public void f(JSONObject jSONObject) {
        this.f49617a = jSONObject.optString("icon");
        this.f49618b = jSONObject.optString(LowFlowsActivityConfig.TAB_CODE);
        this.f49619c = jSONObject.optString("pop_text");
        this.f49620d = jSONObject.optString("thread_id");
        this.f49621e = jSONObject.optInt("version");
    }
}
