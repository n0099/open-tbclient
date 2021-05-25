package d.a.n0.m2;

import com.baidu.adp.lib.util.StringUtils;
import d.a.n0.m2.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c extends b.AbstractC1438b {

    /* renamed from: d  reason: collision with root package name */
    public final int f57460d;

    /* renamed from: e  reason: collision with root package name */
    public final String f57461e;

    public c(int i2, String str, int i3, String str2) {
        super(i2, str);
        this.f57460d = i3;
        this.f57461e = str2;
    }

    @Override // d.a.n0.m2.b.AbstractC1438b, d.a.n0.m2.b
    public JSONObject a() {
        JSONObject a2 = super.a();
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.f57460d != -4399) {
                jSONObject.put("code", this.f57460d);
            }
            if (!StringUtils.isNull(this.f57461e)) {
                jSONObject.put("msg", this.f57461e);
            }
            a2.put("ext", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return a2;
    }
}
