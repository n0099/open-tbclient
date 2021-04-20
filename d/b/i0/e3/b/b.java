package d.b.i0.e3.b;

import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f55687a;

    /* renamed from: b  reason: collision with root package name */
    public int f55688b;

    /* renamed from: c  reason: collision with root package name */
    public long f55689c = 3000;

    /* renamed from: d  reason: collision with root package name */
    public int f55690d;

    /* renamed from: e  reason: collision with root package name */
    public String f55691e;

    /* renamed from: f  reason: collision with root package name */
    public String f55692f;

    public boolean a() {
        int i = this.f55690d;
        return i == 2 || i == 4;
    }

    public boolean b() {
        return this.f55690d == 1;
    }

    public boolean c() {
        int i = this.f55690d;
        return i == 3 || i == 4;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f55687a = jSONObject.optInt("id", 0);
            jSONObject.optLong("update_time", 0L);
            jSONObject.optLong("start_time", 0L);
            jSONObject.optLong("end_time", 0L);
            this.f55690d = jSONObject.optInt(RecordVideoActivityConfig.SHOW_TYPE, 0);
            this.f55688b = jSONObject.optInt("show_status", 0);
            this.f55691e = jSONObject.optString("resource_url");
            this.f55692f = jSONObject.optString("link_url");
        }
    }
}
