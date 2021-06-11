package d.a.m0.s.c;

import com.yy.gslbsdk.db.ResultTB;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d0 {

    /* renamed from: a  reason: collision with root package name */
    public String f54115a;

    /* renamed from: b  reason: collision with root package name */
    public long f54116b;

    /* renamed from: c  reason: collision with root package name */
    public long f54117c;

    public long a() {
        return this.f54117c;
    }

    public String b() {
        return this.f54115a;
    }

    public long c() {
        return this.f54116b;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f54115a = jSONObject.optString("link_url", "");
        this.f54116b = jSONObject.optLong("start_time", 0L);
        this.f54117c = jSONObject.optLong(ResultTB.ENDTIME, 0L);
    }
}
