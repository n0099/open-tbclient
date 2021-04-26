package d.a.i0.s.c;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d0 extends d.a.i0.r.q.o {

    /* renamed from: a  reason: collision with root package name */
    public long f49556a = Long.MAX_VALUE;

    /* renamed from: b  reason: collision with root package name */
    public long f49557b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f49558c = null;

    public String a() {
        return this.f49558c;
    }

    public long b() {
        return this.f49557b;
    }

    public long c() {
        return this.f49556a;
    }

    @Override // d.a.i0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f49556a = jSONObject.optLong("start_time", Long.MAX_VALUE);
            this.f49557b = jSONObject.optLong("end_time", 0L);
            this.f49558c = jSONObject.optString("dest_url", "");
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
