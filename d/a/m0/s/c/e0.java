package d.a.m0.s.c;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e0 extends d.a.m0.r.q.o {

    /* renamed from: a  reason: collision with root package name */
    public long f50443a = Long.MAX_VALUE;

    /* renamed from: b  reason: collision with root package name */
    public long f50444b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f50445c = null;

    public String a() {
        return this.f50445c;
    }

    public long b() {
        return this.f50444b;
    }

    public long c() {
        return this.f50443a;
    }

    @Override // d.a.m0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f50443a = jSONObject.optLong("start_time", Long.MAX_VALUE);
            this.f50444b = jSONObject.optLong("end_time", 0L);
            this.f50445c = jSONObject.optString("dest_url", "");
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
