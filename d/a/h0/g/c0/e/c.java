package d.a.h0.g.c0.e;

import com.baidu.wallet.router.RouterCallback;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d {

    /* renamed from: b  reason: collision with root package name */
    public String f46213b;

    /* renamed from: c  reason: collision with root package name */
    public int f46214c;

    @Override // d.a.h0.g.c0.e.d
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("packageName", this.f46213b);
            jSONObject.put(RouterCallback.KEY_ERROR_CODE, this.f46214c);
            jSONObject.put("errMsg", this.f46215a);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
