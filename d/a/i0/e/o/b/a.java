package d.a.i0.e.o.b;

import com.baidu.pyramid.annotation.Service;
import d.a.i0.a.k;
import d.a.i0.a.p.c.h;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes3.dex */
public class a extends h {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46391a = k.f43025a;

    @Override // d.a.i0.a.p.d.m
    public boolean A() {
        return (f46391a && d.a.i0.a.u1.a.a.F().booleanValue()) ? false : true;
    }

    @Override // d.a.i0.a.p.d.m
    public JSONObject getRawSwitch() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (d.a.i0.w.a.b()) {
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
