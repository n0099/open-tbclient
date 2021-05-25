package d.a.l0.e.o.b;

import com.baidu.pyramid.annotation.Service;
import d.a.l0.a.k;
import d.a.l0.a.p.c.i;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes3.dex */
public class a extends i {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46567a = k.f43199a;

    @Override // d.a.l0.a.p.d.m
    public boolean A() {
        return (f46567a && d.a.l0.a.u1.a.a.F().booleanValue()) ? false : true;
    }

    @Override // d.a.l0.a.p.d.m
    public JSONObject getRawSwitch() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (d.a.l0.w.a.b()) {
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
