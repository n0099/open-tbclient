package d.a.j0.e3.b;

import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f53982a;

    /* renamed from: b  reason: collision with root package name */
    public int f53983b;

    /* renamed from: c  reason: collision with root package name */
    public long f53984c = 3000;

    /* renamed from: d  reason: collision with root package name */
    public int f53985d;

    /* renamed from: e  reason: collision with root package name */
    public String f53986e;

    /* renamed from: f  reason: collision with root package name */
    public String f53987f;

    public boolean a() {
        int i2 = this.f53985d;
        return i2 == 2 || i2 == 4;
    }

    public boolean b() {
        return this.f53985d == 1;
    }

    public boolean c() {
        int i2 = this.f53985d;
        return i2 == 3 || i2 == 4;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f53982a = jSONObject.optInt("id", 0);
            jSONObject.optLong("update_time", 0L);
            jSONObject.optLong("start_time", 0L);
            jSONObject.optLong("end_time", 0L);
            this.f53985d = jSONObject.optInt(RecordVideoActivityConfig.SHOW_TYPE, 0);
            this.f53983b = jSONObject.optInt("show_status", 0);
            this.f53986e = jSONObject.optString("resource_url");
            this.f53987f = jSONObject.optString("link_url");
        }
    }
}
