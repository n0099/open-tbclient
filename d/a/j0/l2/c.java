package d.a.j0.l2;

import com.baidu.adp.lib.util.StringUtils;
import d.a.j0.l2.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c extends b.AbstractC1348b {

    /* renamed from: d  reason: collision with root package name */
    public final int f56563d;

    /* renamed from: e  reason: collision with root package name */
    public final String f56564e;

    public c(int i2, String str, int i3, String str2) {
        super(i2, str);
        this.f56563d = i3;
        this.f56564e = str2;
    }

    @Override // d.a.j0.l2.b.AbstractC1348b, d.a.j0.l2.b
    public JSONObject a() {
        JSONObject a2 = super.a();
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.f56563d != -4399) {
                jSONObject.put("code", this.f56563d);
            }
            if (!StringUtils.isNull(this.f56564e)) {
                jSONObject.put("msg", this.f56564e);
            }
            a2.put("ext", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return a2;
    }
}
