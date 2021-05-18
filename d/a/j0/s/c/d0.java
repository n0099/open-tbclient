package d.a.j0.s.c;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d0 extends d.a.j0.r.q.o {

    /* renamed from: a  reason: collision with root package name */
    public long f50375a = Long.MAX_VALUE;

    /* renamed from: b  reason: collision with root package name */
    public long f50376b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f50377c = null;

    public String a() {
        return this.f50377c;
    }

    public long b() {
        return this.f50376b;
    }

    public long c() {
        return this.f50375a;
    }

    @Override // d.a.j0.r.q.o
    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.f50375a = jSONObject.optLong("start_time", Long.MAX_VALUE);
            this.f50376b = jSONObject.optLong("end_time", 0L);
            this.f50377c = jSONObject.optString("dest_url", "");
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
