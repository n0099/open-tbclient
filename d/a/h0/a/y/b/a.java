package d.a.h0.a.y.b;

import android.text.TextUtils;
import d.a.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.a.h0.a.a0.b.b {
    public boolean n;

    static {
        boolean z = k.f43101a;
    }

    public a(String str) {
        super("canvas", "canvasId");
        this.n = false;
        try {
            a(new JSONObject(str));
        } catch (JSONException e2) {
            d.a.h0.a.c0.c.c("Canvas", "parsing CanvasBasicthis occurs exception", e2);
        }
    }

    @Override // d.a.h0.a.a0.b.b, d.a.h0.a.e1.a
    public void a(JSONObject jSONObject) throws JSONException {
        super.a(jSONObject);
        this.j = TextUtils.equals(jSONObject.optString("hide"), "1") || jSONObject.optBoolean("hide");
        this.n = !TextUtils.equals(jSONObject.optString("disableScroll"), "0");
        this.k = !TextUtils.equals(jSONObject.optString("gesture"), "0");
    }

    @Override // d.a.h0.a.a0.b.b, d.a.h0.a.e1.a
    public boolean isValid() {
        return (TextUtils.isEmpty(this.f41092f) || TextUtils.isEmpty(this.f41093g)) ? false : true;
    }
}
