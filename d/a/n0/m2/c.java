package d.a.n0.m2;

import com.baidu.adp.lib.util.StringUtils;
import d.a.n0.m2.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c extends b.AbstractC1494b {

    /* renamed from: d  reason: collision with root package name */
    public final int f61149d;

    /* renamed from: e  reason: collision with root package name */
    public final String f61150e;

    public c(int i2, String str, int i3, String str2) {
        super(i2, str);
        this.f61149d = i3;
        this.f61150e = str2;
    }

    @Override // d.a.n0.m2.b.AbstractC1494b, d.a.n0.m2.b
    public JSONObject a() {
        JSONObject a2 = super.a();
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.f61149d != -4399) {
                jSONObject.put("code", this.f61149d);
            }
            if (!StringUtils.isNull(this.f61150e)) {
                jSONObject.put("msg", this.f61150e);
            }
            a2.put("ext", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return a2;
    }
}
