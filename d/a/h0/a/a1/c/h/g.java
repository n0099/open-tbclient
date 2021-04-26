package d.a.h0.a.a1.c.h;

import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import d.a.h0.a.i2.h0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g implements d.a.h0.a.e1.a {

    /* renamed from: e  reason: collision with root package name */
    public int f41201e = Integer.MIN_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public int f41202f = Integer.MIN_VALUE;

    /* renamed from: g  reason: collision with root package name */
    public int f41203g = -1;

    /* renamed from: h  reason: collision with root package name */
    public int f41204h = -1;

    @Override // d.a.h0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has(CustomDialogData.POS_LEFT) && jSONObject.has("top")) {
            this.f41201e = h0.f(jSONObject.optInt(CustomDialogData.POS_LEFT));
            this.f41202f = h0.f(jSONObject.optInt("top"));
            this.f41203g = jSONObject.has("width") ? Math.abs(h0.f(jSONObject.optInt("width"))) : -1;
            this.f41204h = jSONObject.has("height") ? Math.abs(h0.f(jSONObject.optInt("height"))) : -1;
        }
    }

    @Override // d.a.h0.a.e1.a
    public boolean isValid() {
        return (this.f41201e == Integer.MIN_VALUE || this.f41202f == Integer.MIN_VALUE) ? false : true;
    }
}
