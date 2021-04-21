package d.b.j0.e3.b;

import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f56108a;

    /* renamed from: b  reason: collision with root package name */
    public int f56109b;

    /* renamed from: c  reason: collision with root package name */
    public long f56110c = 3000;

    /* renamed from: d  reason: collision with root package name */
    public int f56111d;

    /* renamed from: e  reason: collision with root package name */
    public String f56112e;

    /* renamed from: f  reason: collision with root package name */
    public String f56113f;

    public boolean a() {
        int i = this.f56111d;
        return i == 2 || i == 4;
    }

    public boolean b() {
        return this.f56111d == 1;
    }

    public boolean c() {
        int i = this.f56111d;
        return i == 3 || i == 4;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f56108a = jSONObject.optInt("id", 0);
            jSONObject.optLong("update_time", 0L);
            jSONObject.optLong("start_time", 0L);
            jSONObject.optLong("end_time", 0L);
            this.f56111d = jSONObject.optInt(RecordVideoActivityConfig.SHOW_TYPE, 0);
            this.f56109b = jSONObject.optInt("show_status", 0);
            this.f56112e = jSONObject.optString("resource_url");
            this.f56113f = jSONObject.optString("link_url");
        }
    }
}
