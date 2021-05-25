package d.a.m0.s.c;

import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public String f50503a;

    /* renamed from: b  reason: collision with root package name */
    public String f50504b;

    /* renamed from: c  reason: collision with root package name */
    public String f50505c;

    /* renamed from: d  reason: collision with root package name */
    public String f50506d;

    /* renamed from: e  reason: collision with root package name */
    public int f50507e;

    public String a() {
        return this.f50503a;
    }

    public String b() {
        return this.f50505c;
    }

    public String c() {
        return this.f50504b;
    }

    public String d() {
        return this.f50506d;
    }

    public int e() {
        return this.f50507e;
    }

    public void f(JSONObject jSONObject) {
        this.f50503a = jSONObject.optString("icon");
        this.f50504b = jSONObject.optString(LowFlowsActivityConfig.TAB_CODE);
        this.f50505c = jSONObject.optString("pop_text");
        this.f50506d = jSONObject.optString("thread_id");
        this.f50507e = jSONObject.optInt("version");
    }
}
