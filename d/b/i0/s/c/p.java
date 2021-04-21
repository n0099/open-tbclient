package d.b.i0.s.c;

import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public String f51963a;

    /* renamed from: b  reason: collision with root package name */
    public String f51964b;

    /* renamed from: c  reason: collision with root package name */
    public String f51965c;

    /* renamed from: d  reason: collision with root package name */
    public String f51966d;

    /* renamed from: e  reason: collision with root package name */
    public int f51967e;

    public String a() {
        return this.f51963a;
    }

    public String b() {
        return this.f51965c;
    }

    public String c() {
        return this.f51964b;
    }

    public String d() {
        return this.f51966d;
    }

    public int e() {
        return this.f51967e;
    }

    public void f(JSONObject jSONObject) {
        this.f51963a = jSONObject.optString("icon");
        this.f51964b = jSONObject.optString(LowFlowsActivityConfig.TAB_CODE);
        this.f51965c = jSONObject.optString("pop_text");
        this.f51966d = jSONObject.optString("thread_id");
        this.f51967e = jSONObject.optInt("version");
    }
}
