package d.a.k0.e3.b;

import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f54689a;

    /* renamed from: b  reason: collision with root package name */
    public int f54690b;

    /* renamed from: c  reason: collision with root package name */
    public long f54691c = 3000;

    /* renamed from: d  reason: collision with root package name */
    public int f54692d;

    /* renamed from: e  reason: collision with root package name */
    public String f54693e;

    /* renamed from: f  reason: collision with root package name */
    public String f54694f;

    public boolean a() {
        int i2 = this.f54692d;
        return i2 == 2 || i2 == 4;
    }

    public boolean b() {
        return this.f54692d == 1;
    }

    public boolean c() {
        int i2 = this.f54692d;
        return i2 == 3 || i2 == 4;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f54689a = jSONObject.optInt("id", 0);
            jSONObject.optLong("update_time", 0L);
            jSONObject.optLong("start_time", 0L);
            jSONObject.optLong("end_time", 0L);
            this.f54692d = jSONObject.optInt(RecordVideoActivityConfig.SHOW_TYPE, 0);
            this.f54690b = jSONObject.optInt("show_status", 0);
            this.f54693e = jSONObject.optString("resource_url");
            this.f54694f = jSONObject.optString("link_url");
        }
    }
}
