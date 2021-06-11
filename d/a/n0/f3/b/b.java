package d.a.n0.f3.b;

import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.yy.gslbsdk.db.ResultTB;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f58568a;

    /* renamed from: b  reason: collision with root package name */
    public int f58569b;

    /* renamed from: c  reason: collision with root package name */
    public long f58570c = 3000;

    /* renamed from: d  reason: collision with root package name */
    public int f58571d;

    /* renamed from: e  reason: collision with root package name */
    public String f58572e;

    /* renamed from: f  reason: collision with root package name */
    public String f58573f;

    public boolean a() {
        int i2 = this.f58571d;
        return i2 == 2 || i2 == 4;
    }

    public boolean b() {
        return this.f58571d == 1;
    }

    public boolean c() {
        int i2 = this.f58571d;
        return i2 == 3 || i2 == 4;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f58568a = jSONObject.optInt("id", 0);
            jSONObject.optLong("update_time", 0L);
            jSONObject.optLong("start_time", 0L);
            jSONObject.optLong(ResultTB.ENDTIME, 0L);
            this.f58571d = jSONObject.optInt(RecordVideoActivityConfig.SHOW_TYPE, 0);
            this.f58569b = jSONObject.optInt("show_status", 0);
            this.f58572e = jSONObject.optString("resource_url");
            this.f58573f = jSONObject.optString("link_url");
        }
    }
}
