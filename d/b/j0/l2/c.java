package d.b.j0.l2;

import com.baidu.adp.lib.util.StringUtils;
import d.b.j0.l2.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends b.AbstractC1409b {

    /* renamed from: d  reason: collision with root package name */
    public final int f58554d;

    /* renamed from: e  reason: collision with root package name */
    public final String f58555e;

    public c(int i, String str, int i2, String str2) {
        super(i, str);
        this.f58554d = i2;
        this.f58555e = str2;
    }

    @Override // d.b.j0.l2.b.AbstractC1409b, d.b.j0.l2.b
    public JSONObject a() {
        JSONObject a2 = super.a();
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.f58554d != -4399) {
                jSONObject.put("code", this.f58554d);
            }
            if (!StringUtils.isNull(this.f58555e)) {
                jSONObject.put("msg", this.f58555e);
            }
            a2.put("ext", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return a2;
    }
}
