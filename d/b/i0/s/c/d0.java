package d.b.i0.s.c;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d0 extends d.b.i0.r.q.o {

    /* renamed from: a  reason: collision with root package name */
    public long f51903a = Long.MAX_VALUE;

    /* renamed from: b  reason: collision with root package name */
    public long f51904b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f51905c = null;

    public String a() {
        return this.f51905c;
    }

    public long b() {
        return this.f51904b;
    }

    public long c() {
        return this.f51903a;
    }

    @Override // d.b.i0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f51903a = jSONObject.optLong("start_time", Long.MAX_VALUE);
            this.f51904b = jSONObject.optLong("end_time", 0L);
            this.f51905c = jSONObject.optString("dest_url", "");
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
