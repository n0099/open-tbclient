package d.b.h0.s.c;

import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    public String f51201a;

    /* renamed from: b  reason: collision with root package name */
    public String f51202b;

    /* renamed from: c  reason: collision with root package name */
    public String f51203c;

    /* renamed from: d  reason: collision with root package name */
    public String f51204d;

    /* renamed from: e  reason: collision with root package name */
    public int f51205e;

    public String a() {
        return this.f51201a;
    }

    public String b() {
        return this.f51203c;
    }

    public String c() {
        return this.f51202b;
    }

    public String d() {
        return this.f51204d;
    }

    public int e() {
        return this.f51205e;
    }

    public void f(JSONObject jSONObject) {
        this.f51201a = jSONObject.optString("icon");
        this.f51202b = jSONObject.optString(LowFlowsActivityConfig.TAB_CODE);
        this.f51203c = jSONObject.optString("pop_text");
        this.f51204d = jSONObject.optString("thread_id");
        this.f51205e = jSONObject.optInt("version");
    }
}
