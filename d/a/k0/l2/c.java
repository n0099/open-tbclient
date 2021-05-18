package d.a.k0.l2;

import com.baidu.adp.lib.util.StringUtils;
import d.a.k0.l2.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c extends b.AbstractC1420b {

    /* renamed from: d  reason: collision with root package name */
    public final int f57270d;

    /* renamed from: e  reason: collision with root package name */
    public final String f57271e;

    public c(int i2, String str, int i3, String str2) {
        super(i2, str);
        this.f57270d = i3;
        this.f57271e = str2;
    }

    @Override // d.a.k0.l2.b.AbstractC1420b, d.a.k0.l2.b
    public JSONObject a() {
        JSONObject a2 = super.a();
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.f57270d != -4399) {
                jSONObject.put("code", this.f57270d);
            }
            if (!StringUtils.isNull(this.f57271e)) {
                jSONObject.put("msg", this.f57271e);
            }
            a2.put("ext", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return a2;
    }
}
