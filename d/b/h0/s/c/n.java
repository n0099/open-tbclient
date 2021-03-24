package d.b.h0.s.c;

import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public String f51200a;

    /* renamed from: b  reason: collision with root package name */
    public String f51201b;

    /* renamed from: c  reason: collision with root package name */
    public String f51202c;

    /* renamed from: d  reason: collision with root package name */
    public String f51203d;

    /* renamed from: e  reason: collision with root package name */
    public int f51204e;

    public String a() {
        return this.f51200a;
    }

    public String b() {
        return this.f51202c;
    }

    public String c() {
        return this.f51201b;
    }

    public String d() {
        return this.f51203d;
    }

    public int e() {
        return this.f51204e;
    }

    public void f(JSONObject jSONObject) {
        this.f51200a = jSONObject.optString("icon");
        this.f51201b = jSONObject.optString(LowFlowsActivityConfig.TAB_CODE);
        this.f51202c = jSONObject.optString("pop_text");
        this.f51203d = jSONObject.optString("thread_id");
        this.f51204e = jSONObject.optInt("version");
    }
}
