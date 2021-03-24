package d.b.g0.d.j.c;

import com.baidu.pyramid.annotation.Service;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes3.dex */
public class a extends d.b.g0.a.p.b.b {
    @Override // d.b.g0.a.p.c.d
    public JSONObject getRawSwitch() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (d.b.g0.t.a.b()) {
                jSONObject.put("swanswitch_android_setdata", 1);
            }
            jSONObject.put("swanswitch_ab_inline_video", 1);
            jSONObject.put("swanswitch_ab_inline_input", 1);
            jSONObject.put("swanswitch_ab_inline_textarea", 1);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
