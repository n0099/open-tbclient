package d.a.n0.s.c;

import com.yy.gslbsdk.db.ResultTB;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d0 {

    /* renamed from: a  reason: collision with root package name */
    public String f54222a;

    /* renamed from: b  reason: collision with root package name */
    public long f54223b;

    /* renamed from: c  reason: collision with root package name */
    public long f54224c;

    public long a() {
        return this.f54224c;
    }

    public String b() {
        return this.f54222a;
    }

    public long c() {
        return this.f54223b;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f54222a = jSONObject.optString("link_url", "");
        this.f54223b = jSONObject.optLong("start_time", 0L);
        this.f54224c = jSONObject.optLong(ResultTB.ENDTIME, 0L);
    }
}
