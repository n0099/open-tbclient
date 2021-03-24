package d.b.i0.d3.b;

import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f54164a;

    /* renamed from: b  reason: collision with root package name */
    public int f54165b;

    /* renamed from: c  reason: collision with root package name */
    public long f54166c = 3000;

    /* renamed from: d  reason: collision with root package name */
    public int f54167d;

    /* renamed from: e  reason: collision with root package name */
    public String f54168e;

    /* renamed from: f  reason: collision with root package name */
    public String f54169f;

    public boolean a() {
        int i = this.f54167d;
        return i == 2 || i == 4;
    }

    public boolean b() {
        return this.f54167d == 1;
    }

    public boolean c() {
        int i = this.f54167d;
        return i == 3 || i == 4;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f54164a = jSONObject.optInt("id", 0);
            jSONObject.optLong("update_time", 0L);
            jSONObject.optLong("start_time", 0L);
            jSONObject.optLong("end_time", 0L);
            this.f54167d = jSONObject.optInt(RecordVideoActivityConfig.SHOW_TYPE, 0);
            this.f54165b = jSONObject.optInt("show_status", 0);
            this.f54168e = jSONObject.optString("resource_url");
            this.f54169f = jSONObject.optString("link_url");
        }
    }
}
