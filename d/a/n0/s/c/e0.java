package d.a.n0.s.c;

import com.baidu.adp.lib.util.BdLog;
import com.yy.gslbsdk.db.ResultTB;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e0 extends d.a.n0.r.q.o {

    /* renamed from: a  reason: collision with root package name */
    public long f54226a = Long.MAX_VALUE;

    /* renamed from: b  reason: collision with root package name */
    public long f54227b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f54228c = null;

    public String a() {
        return this.f54228c;
    }

    public long b() {
        return this.f54227b;
    }

    public long c() {
        return this.f54226a;
    }

    @Override // d.a.n0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f54226a = jSONObject.optLong("start_time", Long.MAX_VALUE);
            this.f54227b = jSONObject.optLong(ResultTB.ENDTIME, 0L);
            this.f54228c = jSONObject.optString("dest_url", "");
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
