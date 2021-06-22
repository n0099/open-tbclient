package d.a.m0.a.h1.c.h;

import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import d.a.m0.a.v2.n0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g implements d.a.m0.a.l1.a {

    /* renamed from: e  reason: collision with root package name */
    public int f46480e = Integer.MIN_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public int f46481f = Integer.MIN_VALUE;

    /* renamed from: g  reason: collision with root package name */
    public int f46482g = -1;

    /* renamed from: h  reason: collision with root package name */
    public int f46483h = -1;

    @Override // d.a.m0.a.l1.a
    public void a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null && jSONObject.has(CustomDialogData.POS_LEFT) && jSONObject.has("top")) {
            this.f46480e = n0.g(jSONObject.optInt(CustomDialogData.POS_LEFT));
            this.f46481f = n0.g(jSONObject.optInt("top"));
            this.f46482g = jSONObject.has("width") ? Math.abs(n0.g(jSONObject.optInt("width"))) : -1;
            this.f46483h = jSONObject.has("height") ? Math.abs(n0.g(jSONObject.optInt("height"))) : -1;
        }
    }

    @Override // d.a.m0.a.l1.a
    public boolean isValid() {
        return (this.f46480e == Integer.MIN_VALUE || this.f46481f == Integer.MIN_VALUE) ? false : true;
    }
}
