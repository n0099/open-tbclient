package d.b.h0.s.c;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d0 extends d.b.h0.r.q.o {

    /* renamed from: a  reason: collision with root package name */
    public long f51567a = Long.MAX_VALUE;

    /* renamed from: b  reason: collision with root package name */
    public long f51568b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f51569c = null;

    public String a() {
        return this.f51569c;
    }

    public long b() {
        return this.f51568b;
    }

    public long c() {
        return this.f51567a;
    }

    @Override // d.b.h0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f51567a = jSONObject.optLong("start_time", Long.MAX_VALUE);
            this.f51568b = jSONObject.optLong("end_time", 0L);
            this.f51569c = jSONObject.optString("dest_url", "");
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
