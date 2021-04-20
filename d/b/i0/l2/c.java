package d.b.i0.l2;

import com.baidu.adp.lib.util.StringUtils;
import d.b.i0.l2.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends b.AbstractC1386b {

    /* renamed from: d  reason: collision with root package name */
    public final int f58133d;

    /* renamed from: e  reason: collision with root package name */
    public final String f58134e;

    public c(int i, String str, int i2, String str2) {
        super(i, str);
        this.f58133d = i2;
        this.f58134e = str2;
    }

    @Override // d.b.i0.l2.b.AbstractC1386b, d.b.i0.l2.b
    public JSONObject a() {
        JSONObject a2 = super.a();
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.f58133d != -4399) {
                jSONObject.put("code", this.f58133d);
            }
            if (!StringUtils.isNull(this.f58134e)) {
                jSONObject.put("msg", this.f58134e);
            }
            a2.put("ext", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return a2;
    }
}
