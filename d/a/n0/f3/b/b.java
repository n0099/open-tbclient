package d.a.n0.f3.b;

import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f54879a;

    /* renamed from: b  reason: collision with root package name */
    public int f54880b;

    /* renamed from: c  reason: collision with root package name */
    public long f54881c = 3000;

    /* renamed from: d  reason: collision with root package name */
    public int f54882d;

    /* renamed from: e  reason: collision with root package name */
    public String f54883e;

    /* renamed from: f  reason: collision with root package name */
    public String f54884f;

    public boolean a() {
        int i2 = this.f54882d;
        return i2 == 2 || i2 == 4;
    }

    public boolean b() {
        return this.f54882d == 1;
    }

    public boolean c() {
        int i2 = this.f54882d;
        return i2 == 3 || i2 == 4;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f54879a = jSONObject.optInt("id", 0);
            jSONObject.optLong("update_time", 0L);
            jSONObject.optLong("start_time", 0L);
            jSONObject.optLong("end_time", 0L);
            this.f54882d = jSONObject.optInt(RecordVideoActivityConfig.SHOW_TYPE, 0);
            this.f54880b = jSONObject.optInt("show_status", 0);
            this.f54883e = jSONObject.optString("resource_url");
            this.f54884f = jSONObject.optString("link_url");
        }
    }
}
