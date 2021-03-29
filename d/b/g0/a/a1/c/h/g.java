package d.b.g0.a.a1.c.h;

import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import d.b.g0.a.i2.h0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g implements d.b.g0.a.e1.a {

    /* renamed from: e  reason: collision with root package name */
    public int f43211e = Integer.MIN_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public int f43212f = Integer.MIN_VALUE;

    /* renamed from: g  reason: collision with root package name */
    public int f43213g = -1;

    /* renamed from: h  reason: collision with root package name */
    public int f43214h = -1;

    @Override // d.b.g0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has(CustomDialogData.POS_LEFT) && jSONObject.has("top")) {
            this.f43211e = h0.f(jSONObject.optInt(CustomDialogData.POS_LEFT));
            this.f43212f = h0.f(jSONObject.optInt("top"));
            this.f43213g = jSONObject.has("width") ? Math.abs(h0.f(jSONObject.optInt("width"))) : -1;
            this.f43214h = jSONObject.has("height") ? Math.abs(h0.f(jSONObject.optInt("height"))) : -1;
        }
    }

    @Override // d.b.g0.a.e1.a
    public boolean isValid() {
        return (this.f43211e == Integer.MIN_VALUE || this.f43212f == Integer.MIN_VALUE) ? false : true;
    }
}
