package d.a.l0.a.h1.c.h;

import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import d.a.l0.a.v2.n0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g implements d.a.l0.a.l1.a {

    /* renamed from: e  reason: collision with root package name */
    public int f42696e = Integer.MIN_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public int f42697f = Integer.MIN_VALUE;

    /* renamed from: g  reason: collision with root package name */
    public int f42698g = -1;

    /* renamed from: h  reason: collision with root package name */
    public int f42699h = -1;

    @Override // d.a.l0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has(CustomDialogData.POS_LEFT) && jSONObject.has("top")) {
            this.f42696e = n0.g(jSONObject.optInt(CustomDialogData.POS_LEFT));
            this.f42697f = n0.g(jSONObject.optInt("top"));
            this.f42698g = jSONObject.has("width") ? Math.abs(n0.g(jSONObject.optInt("width"))) : -1;
            this.f42699h = jSONObject.has("height") ? Math.abs(n0.g(jSONObject.optInt("height"))) : -1;
        }
    }

    @Override // d.a.l0.a.l1.a
    public boolean isValid() {
        return (this.f42696e == Integer.MIN_VALUE || this.f42697f == Integer.MIN_VALUE) ? false : true;
    }
}
