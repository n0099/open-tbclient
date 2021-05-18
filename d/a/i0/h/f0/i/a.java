package d.a.i0.h.f0.i;

import com.baidu.wallet.router.RouterCallback;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d {

    /* renamed from: b  reason: collision with root package name */
    public String f47199b;

    /* renamed from: c  reason: collision with root package name */
    public int f47200c;

    /* renamed from: d  reason: collision with root package name */
    public int f47201d;

    @Override // d.a.i0.h.f0.i.d
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f47199b);
            jSONObject.put(RouterCallback.KEY_ERROR_CODE, this.f47200c);
            jSONObject.put("net", this.f47201d);
            jSONObject.put("errMsg", this.f47205a);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
