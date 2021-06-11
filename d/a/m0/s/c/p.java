package d.a.m0.s.c;

import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public String f54179a;

    /* renamed from: b  reason: collision with root package name */
    public String f54180b;

    /* renamed from: c  reason: collision with root package name */
    public String f54181c;

    /* renamed from: d  reason: collision with root package name */
    public String f54182d;

    /* renamed from: e  reason: collision with root package name */
    public int f54183e;

    public String a() {
        return this.f54179a;
    }

    public String b() {
        return this.f54181c;
    }

    public String c() {
        return this.f54180b;
    }

    public String d() {
        return this.f54182d;
    }

    public int e() {
        return this.f54183e;
    }

    public void f(JSONObject jSONObject) {
        this.f54179a = jSONObject.optString("icon");
        this.f54180b = jSONObject.optString(LowFlowsActivityConfig.TAB_CODE);
        this.f54181c = jSONObject.optString("pop_text");
        this.f54182d = jSONObject.optString("thread_id");
        this.f54183e = jSONObject.optInt("version");
    }
}
