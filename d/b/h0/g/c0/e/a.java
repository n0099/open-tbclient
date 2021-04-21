package d.b.h0.g.c0.e;

import com.baidu.wallet.router.RouterCallback;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d {

    /* renamed from: b  reason: collision with root package name */
    public String f48742b;

    /* renamed from: c  reason: collision with root package name */
    public int f48743c;

    /* renamed from: d  reason: collision with root package name */
    public int f48744d;

    @Override // d.b.h0.g.c0.e.d
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f48742b);
            jSONObject.put(RouterCallback.KEY_ERROR_CODE, this.f48743c);
            jSONObject.put("net", this.f48744d);
            jSONObject.put("errMsg", this.f48748a);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
