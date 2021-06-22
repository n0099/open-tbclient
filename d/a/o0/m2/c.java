package d.a.o0.m2;

import com.baidu.adp.lib.util.StringUtils;
import d.a.o0.m2.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c extends b.AbstractC1498b {

    /* renamed from: d  reason: collision with root package name */
    public final int f61274d;

    /* renamed from: e  reason: collision with root package name */
    public final String f61275e;

    public c(int i2, String str, int i3, String str2) {
        super(i2, str);
        this.f61274d = i3;
        this.f61275e = str2;
    }

    @Override // d.a.o0.m2.b.AbstractC1498b, d.a.o0.m2.b
    public JSONObject a() {
        JSONObject a2 = super.a();
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.f61274d != -4399) {
                jSONObject.put("code", this.f61274d);
            }
            if (!StringUtils.isNull(this.f61275e)) {
                jSONObject.put("msg", this.f61275e);
            }
            a2.put("ext", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return a2;
    }
}
