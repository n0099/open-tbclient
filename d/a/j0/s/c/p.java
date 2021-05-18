package d.a.j0.s.c;

import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public String f50436a;

    /* renamed from: b  reason: collision with root package name */
    public String f50437b;

    /* renamed from: c  reason: collision with root package name */
    public String f50438c;

    /* renamed from: d  reason: collision with root package name */
    public String f50439d;

    /* renamed from: e  reason: collision with root package name */
    public int f50440e;

    public String a() {
        return this.f50436a;
    }

    public String b() {
        return this.f50438c;
    }

    public String c() {
        return this.f50437b;
    }

    public String d() {
        return this.f50439d;
    }

    public int e() {
        return this.f50440e;
    }

    public void f(JSONObject jSONObject) {
        this.f50436a = jSONObject.optString("icon");
        this.f50437b = jSONObject.optString(LowFlowsActivityConfig.TAB_CODE);
        this.f50438c = jSONObject.optString("pop_text");
        this.f50439d = jSONObject.optString("thread_id");
        this.f50440e = jSONObject.optInt("version");
    }
}
