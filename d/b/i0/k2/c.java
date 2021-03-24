package d.b.i0.k2;

import com.baidu.adp.lib.util.StringUtils;
import d.b.i0.k2.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c extends b.AbstractC1323b {

    /* renamed from: d  reason: collision with root package name */
    public final int f56461d;

    /* renamed from: e  reason: collision with root package name */
    public final String f56462e;

    public c(int i, String str, int i2, String str2) {
        super(i, str);
        this.f56461d = i2;
        this.f56462e = str2;
    }

    @Override // d.b.i0.k2.b.AbstractC1323b, d.b.i0.k2.b
    public JSONObject a() {
        JSONObject a2 = super.a();
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.f56461d != -4399) {
                jSONObject.put("code", this.f56461d);
            }
            if (!StringUtils.isNull(this.f56462e)) {
                jSONObject.put("msg", this.f56462e);
            }
            a2.put("ext", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return a2;
    }
}
