package d.b.h0.s.c;

import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public String f51627a;

    /* renamed from: b  reason: collision with root package name */
    public String f51628b;

    /* renamed from: c  reason: collision with root package name */
    public String f51629c;

    /* renamed from: d  reason: collision with root package name */
    public String f51630d;

    /* renamed from: e  reason: collision with root package name */
    public int f51631e;

    public String a() {
        return this.f51627a;
    }

    public String b() {
        return this.f51629c;
    }

    public String c() {
        return this.f51628b;
    }

    public String d() {
        return this.f51630d;
    }

    public int e() {
        return this.f51631e;
    }

    public void f(JSONObject jSONObject) {
        this.f51627a = jSONObject.optString("icon");
        this.f51628b = jSONObject.optString(LowFlowsActivityConfig.TAB_CODE);
        this.f51629c = jSONObject.optString("pop_text");
        this.f51630d = jSONObject.optString("thread_id");
        this.f51631e = jSONObject.optInt("version");
    }
}
